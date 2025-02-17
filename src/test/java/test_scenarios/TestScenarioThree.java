package test_scenarios;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestScenarioThree extends DriverConfiguration {
	@Test(dataProvider = "browserOsData",timeOut = 20000)
	public void submitForm(String browser, String os) throws Exception {
		WebDriver driver=setUp(browser, os);
		Actions action=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.lambdatest.com/selenium-playground");
		WebElement element=driver.findElement(By.linkText("Input Form Submit"));
		action.moveToElement(element);
		element.click();
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and not(@id)]"));
		submitButton.click();
		String message = driver.findElement(By.name("name")).getAttribute("validationMessage");
		if(browser.toLowerCase().contains("edge")) {
			assertEquals(message,"Please fill in this field.");
		}else {
			assertEquals(message,"Please fill out this field.");
		}
		WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email']"));
		//To enter name
		WebElement name = driver.findElement(By.name("name"));
		name.click();
		name.sendKeys("Hari");
		//To enter email
		email.sendKeys("hari@gmail.com");
		//To enter password
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("Hari@000");
		//To enter company
		WebElement company=driver.findElement(By.id("company"));
		company.sendKeys("hari@gmail.com");
		//To enter website name
		WebElement website=driver.findElement(By.id("websitename"));
		website.sendKeys("Test website");
		//To select the country in drop down
		String country="United States";
		WebElement input=driver.findElement(By.name("country"));
		Select s=new Select(input);
		s.selectByVisibleText(country);
		//To enter city name
		WebElement city=driver.findElement(By.id("inputCity"));
		city.sendKeys("Los Angels");
		//To enter the address line 1
		WebElement address1=driver.findElement(By.id("inputAddress1"));
		address1.sendKeys("No.02 Los anglels");
		//To enter the address line 2
		WebElement address2=driver.findElement(By.name("address_line2"));
		address2.sendKeys("Colorado, United statates");
		//To enter state
		WebElement state=driver.findElement(By.id("inputState"));
		state.sendKeys("Colorado");
		//To enter Zip code
		WebElement zipCode=driver.findElement(By.name("zip"));
		zipCode.sendKeys("123456");
		submitButton.click();
		Thread.sleep(1000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement success = driver.findElement(By.xpath("//p[@class='success-msg hidden']"));
			wait.until(ExpectedConditions.visibilityOf(success));
		} catch (Exception e) {
			throw new Exception("Success message not shown after submitting the form.");
		}
		tearDown();
	}
}
