package September3rd.QAbatch_3rd;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleIframes {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver 108\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.get("https://demoqa.com/alerts");

		// maximise the browser window
		wd.manage().window().maximize();
	}

	@Test
	public void acceptAlertExample() {

		wd.findElement(By.cssSelector("#alertButton")).click();
		sleep();

		// Accept Alert
		wd.switchTo().alert().accept();
		sleep();

	}
	
	@Test
	public void confirmationAlertAcceptExample() {

		wd.findElement(By.cssSelector("#confirmButton")).click();
		sleep();

		// Accept Alert
		wd.switchTo().alert().accept();
		sleep();

		String text = wd.findElement(By.cssSelector("#confirmResult")).getText();

		Assert.assertTrue(text.contains("Ok"));

	}

	@Test
	public void confirmationAlertDismissExample() {

		wd.findElement(By.cssSelector("#confirmButton")).click();
		sleep();

		// Accept Alert
		Alert alert=wd.switchTo().alert();
		alert.dismiss();
		sleep();

		String text = wd.findElement(By.cssSelector("#confirmResult")).getText();

		Assert.assertTrue(text.contains("Cancel"));

	}

	@Test
	public void verifyPromptAlert() {

		wd.findElement(By.cssSelector("#promtButton")).click();
		sleep();

		// Accept Alert
		wd.switchTo().alert();
		Alert alert = wd.switchTo().alert();
		alert.sendKeys("Manvir");
		alert.accept();
		sleep();

		String text = wd.findElement(By.cssSelector("#promptResult")).getText();

		Assert.assertTrue(text.contains("Manvir"));

	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
