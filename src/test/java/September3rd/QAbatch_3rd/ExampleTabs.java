package September3rd.QAbatch_3rd;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleTabs {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver 108\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.get("https://demoqa.com/browser-windows");

		// maximise the browser window
		wd.manage().window().maximize();
	}

	@Test
	public void acceptAlertExample() {
		String parentWindowHandle = wd.getWindowHandle();
		System.out.println(parentWindowHandle);

		wd.findElement(By.cssSelector("#tabButton")).click();

		Set<String> allWindowHandles = wd.getWindowHandles();

		int[] num = { 1, 2, 3, 4, 5 };
		System.out.println(num[2]);

		List<String> names = new ArrayList<>(List.of("MANVIR", "Swaroop", "Sahib", "Jattan"));

		System.out.println(names.get(1));

		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				wd.switchTo().window(handle);
				System.out.println("Child handle is " + handle);
				System.out
						.println("Text from child tab : " + wd.findElement(By.cssSelector("#sampleHeading")).getText());
			}
		}
		wd.switchTo().window(parentWindowHandle);

	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.quit();
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
