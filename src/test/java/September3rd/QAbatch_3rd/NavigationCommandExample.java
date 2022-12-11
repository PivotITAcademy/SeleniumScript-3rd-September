package September3rd.QAbatch_3rd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationCommandExample {

	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver 108\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.navigate().to("https://www.webroot.com/us/en/home/");

	}

	@Test
	public void validatingNavigation() {
		// to command
		
		wd.navigate().to("https://www.carbonite.com/");
		wd.navigate().back();
		
		//Refresh a page
		wd.navigate().refresh();
		
		//Go back
		wd.navigate().back();
		//Forward
		wd.navigate().forward();
		
		
		//
	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		//wd.close();
	}
	
	public void sleep() {
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
