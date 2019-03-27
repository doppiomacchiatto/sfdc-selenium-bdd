package sfdc.selenium.test.login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.NoSuchElementException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sfdc.selenium.bdd.utils.EnvironmentManager;
import sfdc.selenium.bdd.utils.RunEnvironment;

@RunWith(JUnit4.class)
public class LoginTest {

	@BeforeClass
	public static void setup() {
		// do something
		EnvironmentManager.initWebDriver();
		EnvironmentManager.initPropsFile();
	}

	@Test
	public void testFetchLoginPage() {
		WebDriver webDriver = RunEnvironment.getWebDriver();
		HashMap<String, String> propsMap = RunEnvironment.getProps();

		try {
			webDriver.navigate().to(new URL(propsMap.get("url")));

			WebElement webElement = webDriver.findElement(By.id("username"));

			assertEquals(webElement, webDriver.findElement(By.xpath("//input[@id='username']")));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testLoginWithValidAccount() {
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

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".breadcrumbDetail.uiOutputText")));
			WebElement home = webDriver.findElement(
					By.xpath("//span[contains(@class,'breadcrumbDetail') and contains(@class,'uiOutputText')]"));
			assertEquals(home, webDriver.findElement(
					By.xpath("//span[contains(@class,'breadcrumbDetail') and contains(@class,'uiOutputText')]")));
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
			webDriver.findElement(By.xpath("//a[@class='profile-link-label logout uiOutputURL']")).click();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private boolean checkIfElementExistsCss(String cssSelector, WebDriver webDriver) {
		boolean result = false;
		try {
	        webDriver.findElement(By.cssSelector(cssSelector));
	        result = true;
	    } catch (NoSuchElementException e) {
	        return result;
	    }
		
		return result;
	}

	@Test
	public void testSalesApp() {
		fail("deod");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		EnvironmentManager.shutDownDriver();
	}

}
