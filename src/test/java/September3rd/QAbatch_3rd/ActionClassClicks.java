package September3rd.QAbatch_3rd;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ActionClassClicks {
	
	WebDriver wd;
	
	WebDriverWait wdwait;
	
	Actions action;
	
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();
			
		wdwait = new WebDriverWait(	wd, Duration.ofSeconds(10));
		
		sf = new SoftAssert();

		// Launch a page
		wd.get("https://demoqa.com/buttons");
		
		action = new Actions(wd);

		

	}

	@Test
	public void VerifyLeftClick() {
		
		
		WebElement clickButton = wd.findElement(By.cssSelector("div.col-12.mt-4.col-md-6 div.mt-4:last-of-type button"));
		
		action.click(clickButton).perform();
		
		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dynamicClickMessage")));
		
		WebElement successMessage = wd.findElement(By.cssSelector("#dynamicClickMessage"));
		
		sf.assertEquals(successMessage.getText(), "You have done a dynamic click", "Message Incorrect");
		
		sf.assertAll();
		

	}
	
	@Test
	public void verifyRightClick() {
		
		
		WebElement rightClickButton = wd.findElement(By.cssSelector("#rightClickBtn"));
		
		action.contextClick(rightClickButton).perform();
		
		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rightClickMessage")));
		
		WebElement successMessage = wd.findElement(By.cssSelector("#rightClickMessage"));
		
		sf.assertEquals(successMessage.getText(), "You have done a right click", "Message Incorrect");
		
		sf.assertAll();
		

	}
	
	@Test
	public void verifyDoubleClick() {
		
		
		WebElement doubleClickButton = wd.findElement(By.cssSelector("#doubleClickBtn"));
		
		action.doubleClick(doubleClickButton).perform();
		
		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#doubleClickMessage")));
		
		WebElement successMessage = wd.findElement(By.cssSelector("#doubleClickMessage"));
		
		sf.assertEquals(successMessage.getText(), "You have done a double click", "Message Incorrect");
		
		sf.assertAll();
		

	}
	
	

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}

}
