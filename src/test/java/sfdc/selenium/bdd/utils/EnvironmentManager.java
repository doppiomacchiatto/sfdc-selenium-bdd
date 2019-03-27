package sfdc.selenium.bdd.utils;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnvironmentManager {
	
	private static String OS_X_CHROMEDRIVER="/usr/local/bin/chromedriver";
	
	public static WebDriver driver;
	
	private EnvironmentManager() {
		
	}

    public static void initWebDriver() {
    	//TODO add logic to determine which OS
        System.setProperty("webdriver.chrome.driver", OS_X_CHROMEDRIVER);
        if(driver == null) {
        	//Driver has been set (Singleton)
        	driver = new ChromeDriver();
        	RunEnvironment.setWebDriver(driver);
        }
    }
    public static void initPropsFile() {
    	ApplicationUtil appUtil = new ApplicationUtil();
    	HashMap<String,String> propMap = appUtil.loadProps();
    	RunEnvironment.setProps(propMap);
    }
    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }
    public static void closeBrowser() {
    	RunEnvironment.getWebDriver().close();
    }

}
