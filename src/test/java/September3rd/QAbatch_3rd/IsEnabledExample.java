package September3rd.QAbatch_3rd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsEnabledExample {

	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver 108\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

	}

	@Test
	public void verifyLogoIsDisplayed() {
		WebElement logo = wd.findElement(By.cssSelector("div#logo img"));

		// isDisplayed

		boolean isLogoDisplayed = logo.isDisplayed();
		Assert.assertTrue(isLogoDisplayed);

	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}
}
