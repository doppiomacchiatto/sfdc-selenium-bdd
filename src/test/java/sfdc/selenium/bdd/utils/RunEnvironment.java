package sfdc.selenium.bdd.utils;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class RunEnvironment {

    private static WebDriver webDriver;
    private static HashMap<String,String> props;

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    static void setWebDriver(WebDriver webDriver) {
        RunEnvironment.webDriver = webDriver;
    }
    
    static void setProps(HashMap<String,String> props){
    	RunEnvironment.props = props;
    }
    
    public static HashMap<String,String> getProps() {
    	return props;
    }
}