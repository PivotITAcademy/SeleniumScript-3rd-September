package September3rd.QAbatch_3rd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumScript {
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
	public void verifyLoginTest() {
		WebElement emailInputField = wd.findElement(By.cssSelector("form div.form-group:first-of-type input"));
		WebElement passwordInputField = wd.findElement(By.cssSelector("form div.form-group:last-of-type input"));
		WebElement loginBtn = wd.findElement(By.cssSelector("input[type='submit']"));

		// Send a text into an input field
		emailInputField.sendKeys("iron.man@gmail.com");
		passwordInputField.sendKeys("avengers.com");
		loginBtn.click();

		String titleOfPage = wd.getTitle();

		Assert.assertEquals(titleOfPage, "My Account", "User is not signed in");
	
		String urlOfPage=wd.getCurrentUrl();
		
		System.out.println(urlOfPage);
	
	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}

}
