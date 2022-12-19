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

public class ExplicitWait {
	
	WebDriver wd;
	
	WebDriverWait wdwait;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();
		
//		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wdwait = new WebDriverWait(	wd, Duration.ofSeconds(10));

		// Launch a page
		wd.get("https://demoqa.com/alerts");



	}

	@Test
	public void verifyExplicitWaitForAlert() {
		
		WebElement alertButtonAfterWait = wd.findElement(By.cssSelector("#timerAlertButton"));
		
		wdwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("#timerAlertButton"))));
		
		alertButtonAfterWait.click();
		
		wdwait.until(ExpectedConditions.alertIsPresent());
		
		wd.switchTo().alert().accept();
		
		
		
		
		

	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}

}
