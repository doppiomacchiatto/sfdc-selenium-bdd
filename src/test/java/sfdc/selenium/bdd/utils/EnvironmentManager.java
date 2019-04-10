package sfdc.selenium.bdd.utils;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnvironmentManager {
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	private static String OS_X_CHROMEDRIVER="/usr/local/bin/chromedriver";
	
	private static String WIN_CHROMEDRIVER= "C:\\Drivers\\chromedriver.exe" ;
	
	private EnvironmentManager() {
		
	}

    public static void initWebDriver() {
    	//TODO add logic to determine which OS
    	
    	if(OS.indexOf("mac") >= 0) {
    		System.setProperty("webdriver.chrome.driver", OS_X_CHROMEDRIVER);
    		setDriver();

    	}
    	if(OS.indexOf("win") >= 0) {
    		System.setProperty("webdriver.chrome.driver",WIN_CHROMEDRIVER);
    		setDriver();
    	}
    	

    }
    private static WebDriver setDriver() {
    	WebDriver driver = new ChromeDriver();
        RunEnvironment.setWebDriver(driver);
        
    	return driver;
    	
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
