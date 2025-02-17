package test_scenarios;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	    @DataProvider(name = "browserOsData")
	    public Object[][] provideLoginData() {
	    	return new Object[][] {
	            {"Chrome", "Windows 10"},
	            {"Microsoft Edge", "macOS Ventura"},
	            {"Firefox", "Windows 11"},
	            {"Internet Explorer", "Windows 10"},
	        };
	    }
}
