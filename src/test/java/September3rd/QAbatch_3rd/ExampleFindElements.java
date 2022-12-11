package September3rd.QAbatch_3rd;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleFindElements {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver 108\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		
		//maximise the browser window
		wd.manage().window().maximize();
	}

	@Test
	public void findElementsExample() {
		List<WebElement> listOfElelements=wd.findElements(By.cssSelector("div.list-group a"));
		
		for (int i = 0; i < listOfElelements.size(); i++) {
			if(listOfElelements.get(i).getText().equals("My Account")) {
				listOfElelements.get(i).click();
				break;
			}
			
		}
	
	}
	
	@Test
	public void findElementExample() {
		WebElement listOfElelements=wd.findElement(By.cssSelector("div.list-group a"));
		
		listOfElelements.click();
		System.out.println(wd.getTitle());
	
	}

	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.close();
	}

}
