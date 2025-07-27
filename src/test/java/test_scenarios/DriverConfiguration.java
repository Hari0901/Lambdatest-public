package test_scenarios;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class DriverConfiguration extends DataProviderClass{

	public static WebDriver driver;
	//driver setup
	public WebDriver setUp(String browser,String os) throws MalformedURLException {
		if (browser.equals("Chrome") && os.equals("Windows 10")) {
			ChromeOptions options = new ChromeOptions();
			options.setPlatformName("Windows 10");
			options.setBrowserVersion("128.0");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "hariharanbas754");
			ltOptions.put("accessKey", "lnZKxgahvOQWMxQNl73Uxp4ODhJkJdoAeJaBj3Iap6pkniLumk");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("network", true);
			ltOptions.put("timezone", "Kolkata");
			ltOptions.put("build", "Selenium java 101 Test 3");
			ltOptions.put("project", "Test project");
			ltOptions.put("name", browser+" "+os);
			ltOptions.put("console", "true");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("w3c", true);
			ltOptions.put("idleTimeout", 20);
			options.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://hariharanbas754:lnZKxgahvOQWMxQNl73Uxp4ODhJkJdoAeJaBj3Iap6pkniLumk@hub.lambdatest.com/wd/hub"), options);
		} else if (browser.equals("Microsoft Edge") && os.equals("macOS Ventura")) {
			EdgeOptions options = new EdgeOptions();
			options.setPlatformName("macOS Ventura");
			options.setBrowserVersion("127.0");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "hariharanbas754");
			ltOptions.put("accessKey", "lnZKxgahvOQWMxQNl73Uxp4ODhJkJdoAeJaBj3Iap6pkniLumk");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("network", true);
			ltOptions.put("timezone", "Kolkata");
			ltOptions.put("build", "Selenium java 101 Test 3");
			ltOptions.put("project", "Test project");
			ltOptions.put("name", browser+" "+os);
			ltOptions.put("console", "true");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("w3c", true);
			ltOptions.put("idleTimeout", 20);
			options.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://hariharanbas754:lnZKxgahvOQWMxQNl73Uxp4ODhJkJdoAeJaBj3Iap6pkniLumk@hub.lambdatest.com/wd/hub"), options);
		} else if (browser.equals("Firefox") && os.equals("Windows 11")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setPlatformName("Windows 11");
			options.setBrowserVersion("130.0");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "hariharanbas754");
			ltOptions.put("accessKey", "lnZKxgahvOQWMxQNl73Uxp4ODhJkJdoAeJaBj3Iap6pkniLumk");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("network", true);
			ltOptions.put("timezone", "Kolkata");
			ltOptions.put("build", "Selenium java 101 Test 3");
			ltOptions.put("project", "Test project");
			ltOptions.put("name", browser+" "+os);
			ltOptions.put("console", "true");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("w3c", true);
			ltOptions.put("idleTimeout", 20);
			options.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://hariharanbas754:lnZKxgahvOQWMxQNl73Uxp4ODhJkJdoAeJaBj3Iap6pkniLumk@hub.lambdatest.com/wd/hub"), options);
		} else if (browser.equals("Internet Explorer") && os.equals("Windows 10")) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setPlatformName("Windows 10");
			options.setBrowserVersion("11.0");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "hariharanbas754");
			ltOptions.put("accessKey", "lnZKxgahvOQWMxQNl73Uxp4ODhJkJdoAeJaBj3Iap6pkniLumk");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("network", true);
			ltOptions.put("timezone", "Kolkata");
			ltOptions.put("build", "Selenium java 101 Test 3");
			ltOptions.put("project", "Test project");
			ltOptions.put("name", browser+" "+os);
			ltOptions.put("console", "true");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("idleTimeout", 20);
			ltOptions.put("w3c", true);
			options.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://hariharanbas754:lnZKxgahvOQWMxQNl73Uxp4ODhJkJdoAeJaBj3Iap6pkniLumk@hub.lambdatest.com/wd/hub"), options);
		}
		return driver;
	}

	
	public void tearDown() throws Exception {
		if (driver != null) {
			//Take screenshot
//			TakesScreenshot screenshot=(TakesScreenshot) driver;
//			File destination = new File("C:\\Users\\harih\\eclipse-workspace\\LambdatestSeleniumTest\\Screenshots\\test.jpg");
//			File source=screenshot.getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(destination, source);
			// Quit WebDriver
			driver.quit();
		}
	}
}
