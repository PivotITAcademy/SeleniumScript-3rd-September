package September3rd.QAbatch_3rd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsDisplayedExample {

	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver 108\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.get("https://ca.hotels.com/login?&uurl=e3id%3Dredr%26rurl%3D%2F%3Flocale%3Den_CA%26pos%3DHCOM_CA%26siteid%3D300000002");

	}

	@Test
	public void verifyIsBtnEnabled() {
		WebElement btn = wd.findElement(By.cssSelector("#loginFormSubmitButton"));

		// isEnabled

		boolean isBtnEnabled = btn.isEnabled();
		Assert.assertTrue(isBtnEnabled);

	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}
}
