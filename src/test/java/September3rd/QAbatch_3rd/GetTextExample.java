package September3rd.QAbatch_3rd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetTextExample {
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
	public void validatingText() {
		WebElement textElement = wd.findElement(By.cssSelector("#content div.row>div:last-of-type strong"));

		// getText text into an input field

		String text = textElement.getText();

		Assert.assertEquals(text, "I am a returning customer", "Text doesn't match");

	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}

}
