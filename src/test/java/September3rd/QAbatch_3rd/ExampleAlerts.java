package September3rd.QAbatch_3rd;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleAlerts {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver 108\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.get("https://demoqa.com/frames");
		
		wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		// maximise the browser window
		wd.manage().window().maximize();
	}

	@Test
	public void verifyIframeUsingIndex() {

		//driver switch to iframe using index
		wd.switchTo().frame(4);
		
		
		System.out.println(wd.findElement(By.cssSelector("#sampleHeading")).getText());

	}
	
	@Test
	public void verifyIframeUsingID() {

		//driver switch to iframe using index
		wd.switchTo().frame("frame1");
		
		
		System.out.println(wd.findElement(By.cssSelector("#sampleHeading")).getText());

	}
	
	@Test
	public void verifyIframeUsingName() {

		//driver switch to iframe using index
		wd.switchTo().frame("frame1");
		
		
		System.out.println(wd.findElement(By.cssSelector("#sampleHeading")).getText());

	}
	
	@Test
	public void switchBetweenIframes() {

		System.out.println("Switching to First Iframe");
		//driver switch to 1st Iframe
		wd.switchTo().frame("frame1");
		System.out.println(wd.findElement(By.cssSelector("#sampleHeading")).getText());
		
		//Switch back to Window
		wd.switchTo().defaultContent();
		
		
		System.out.println("Switching to Second Iframe");
		
		//driver switch to 2nd Iframe
		wd.switchTo().frame("frame2");
		System.out.println(wd.findElement(By.cssSelector("#sampleHeading")).getText());
		
	}
	
	@Test
	public void switchToParentWindow() {

		System.out.println("Switching to First Iframe");
		//driver switch to 1st Iframe
		wd.switchTo().frame("frame1");
		System.out.println(wd.findElement(By.cssSelector("#sampleHeading")).getText());
		
		//Switch back to Window
		wd.switchTo().defaultContent();
		boolean isDisplayed=wd.findElement(By.cssSelector("#app a")).isDisplayed();
		org.testng.Assert.assertTrue(isDisplayed);
		
		
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
