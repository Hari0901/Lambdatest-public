package test_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestScenarioOne extends DriverConfiguration {
	@Test(dataProvider = "browserOsData",timeOut = 20000)
	public void getMessage(String browser, String os) throws Exception {
		WebDriver driver=setUp(browser, os);
		Actions action=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.lambdatest.com/selenium-playground");
		WebElement simple=driver.findElement(By.linkText("Simple Form Demo"));
		action.moveToElement(simple).build().perform();
		simple.click();
		String url=driver.getCurrentUrl();
		String givenText="simple-form-demo";
		if(!url.contains(givenText)) {
			throw new Exception("The url is not containing the given text : "+givenText);
		}
		String enterValue="Welcome to LambdaTest";
		driver.findElement(By.id("user-message")).sendKeys(enterValue);
		driver.findElement(By.xpath("//button[@id='showInput']")).click();
		
		WebElement getValue=driver.findElement(By.id("message"));
		String visibleValue=getValue.getText().trim();
		Assert.assertEquals(visibleValue,enterValue);
		tearDown();
	}
}
