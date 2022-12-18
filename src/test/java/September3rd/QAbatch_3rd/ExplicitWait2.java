package September3rd.QAbatch_3rd;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExplicitWait2 {
	
	WebDriver wd;
	
	WebDriverWait wdwait;
	
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();
		
		sf = new SoftAssert();
		
//		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wdwait = new WebDriverWait(	wd, Duration.ofSeconds(10));

		// Launch a page
		wd.get("https://ca.hotels.com/login");



	}

	@Test
	public void verifyButtonIsClickable() {
		
		
		WebElement emailInput = wd.findElement(By.cssSelector("#loginFormEmailInput"));
		WebElement passwordInput = wd.findElement(By.cssSelector("#loginFormPasswordInput"));
		
		emailInput.sendKeys("12345@email.com");
		passwordInput.sendKeys("1234@xyz");
		
		//Wait till submit button is clickable
		wdwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginFormSubmitButton")));
		
		WebElement submitButton = wd.findElement(By.cssSelector("#loginFormSubmitButton"));
		
		submitButton.click();
		
		//wait till element is visible
		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.uitk-error-summary-heading")));
		
		WebElement errorMessageBanner = wd.findElement(By.cssSelector("h3.uitk-error-summary-heading"));
		
		
		sf.assertEquals(errorMessageBanner.getText(), "Email and password don't match. Please try again.", "Error Message Not Correct");
		
		
		
		
		
		
		
		

	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}

}
