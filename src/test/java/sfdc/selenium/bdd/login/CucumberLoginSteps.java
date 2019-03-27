package sfdc.selenium.bdd.login;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sfdc.selenium.bdd.utils.EnvironmentManager;
import sfdc.selenium.bdd.utils.RunEnvironment;

public class CucumberLoginSteps {
	
	public CucumberLoginSteps(){
		EnvironmentManager.initWebDriver();
		EnvironmentManager.initPropsFile();
	}
	@Given("^User is on Login Page$")
	public void user_is_on_LoginPage() throws Throwable{
		WebDriver webDriver = RunEnvironment.getWebDriver();
		HashMap<String, String> propsMap = RunEnvironment.getProps();

		try {
			webDriver.navigate().to(new URL(propsMap.get("url")));

			WebElement webElement = webDriver.findElement(By.id("username"));

			assertEquals(webElement, webDriver.findElement(By.xpath("//input[@id='username']")));

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@And("^User enters Username and Password$")
	public void user_enters_Username_Password() throws Throwable{
		WebDriver webDriver = RunEnvironment.getWebDriver();
		HashMap<String, String> propsMap = RunEnvironment.getProps();

		WebDriverWait wait = new WebDriverWait(webDriver, 10000);
		try {
			webDriver.navigate().to(new URL(propsMap.get("url")));
			WebElement webElement = webDriver.findElement(By.id("username"));
			webDriver.findElement(By.id("username")).sendKeys(propsMap.get("username"));
			webDriver.findElement(By.id("password")).sendKeys(propsMap.get("password"));
			assertEquals(webElement, webDriver.findElement(By.xpath("//input[@id='username']")));
			webDriver.findElement(By.id("Login")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='breadcrumbDetail uiOutputText']")));
			WebElement home = webDriver.findElement(
					By.xpath("//span[@class='breadcrumbDetail uiOutputText']"));
			assertEquals(home, webDriver.findElement(
					By.xpath("//span[@class='breadcrumbDetail uiOutputText']")));
			

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@When("^The User click's Login Button$")
	public void user_clicks_Login_Button() throws Throwable{
		WebDriver webDriver = RunEnvironment.getWebDriver();
		

		WebDriverWait wait = new WebDriverWait(webDriver, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.uiImage")));	
		WebElement userProfile;
		//check if user has a profile picture
		if(checkIfElementExistsCss("img.profileTrigger.branding-user-profile.circular", webDriver)) {
			userProfile = webDriver.findElement(By.cssSelector("img.profileTrigger.branding-user-profile.circular"));
			userProfile.click();
		}else {
			userProfile = webDriver.findElement(By.cssSelector("span.uiImage"));
			userProfile.click();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out")));
		WebElement logout = webDriver.findElement(By.linkText("Log Out"));
		assertNotNull(logout);
		webDriver.findElement(By.xpath("//a[@class='profile-link-label logout uiOutputURL']")).click();
		
	
	}
	@Then("^User is taken to the Home Page$")
	public void user_at_Home_Page(){
		WebDriver webDriver = RunEnvironment.getWebDriver();
	
		WebDriverWait wait = new WebDriverWait(webDriver, 10000);
		////span[@class='breadcrumbDetail uiOutputText']
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.breadcrumbDetail.uiOutputText")));
		WebElement home = webDriver.findElement(By.cssSelector("span.breadcrumbDetail.uiOutputText"));
		assertNotNull(home);
		
		EnvironmentManager.shutDownDriver();
	
		
	}
	/**
	 * Helper method that check if an HTML element is present.
	 * @param String cssSelector
	 * @param WebDriver
	 **/
	private boolean checkIfElementExistsCss(String cssSelector, WebDriver webDriver) {
		boolean result = false;
		try {
	        webDriver.findElement(By.cssSelector(cssSelector));
	        result = true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return result;
	    }
		
		return result;
	}
}
