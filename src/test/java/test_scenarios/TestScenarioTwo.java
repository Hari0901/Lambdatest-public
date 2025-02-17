package test_scenarios;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class TestScenarioTwo extends DriverConfiguration {
	@Test(dataProvider = "browserOsData",timeOut = 20000)
	public void dragDrop(String browser,String os) throws Exception {
		WebDriver driver=setUp(browser, os);
		Actions action=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.lambdatest.com/selenium-playground");
		WebElement element=driver.findElement(By.linkText("Drag & Drop Sliders"));
		action.moveToElement(element).build().perform();
		element.click();
		WebElement slider = driver.findElement(By.cssSelector("input[type='range'][value='15']"));
		   int result=Integer.parseInt(driver.findElement(By.id("rangeSuccess")).getText().trim());
		   int vall=180;
		   while(result!=95) {
			   action.clickAndHold(slider).moveByOffset(vall,0).release().build().perform();
			   vall+=5;
			   result=Integer.parseInt(driver.findElement(By.id("rangeSuccess")).getText());
		   }
		   String outputResult = driver.findElement(By.id("rangeSuccess")).getText();
		   System.out.println(outputResult);
		   assertEquals(Integer.parseInt(outputResult),95);
		   tearDown();
	}
}
