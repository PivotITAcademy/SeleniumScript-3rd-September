package September3rd.QAbatch_3rd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWait {
	WebDriver wd;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\Chrome Driver 108\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();

		// Launch a page
		wd.get("https://www.webroot.com/us/en/home/");
		sleep();

		wd.findElement(By.id("onetrust-accept-btn-handler")).click();
		sleep();

	}

	@Test
	public void verifySelect() {
		wd.findElement(By.cssSelector("div.TableBlock div>div>div:nth-of-type(2) a:first-of-type")).click();
		sleep();

		selectElementByIndex(wd.findElement(By.cssSelector("select[name='billing.country']")), 4);
		sleep();
		selectElementByValue(wd.findElement(By.cssSelector("select[name='billing.country']")), "US");
		sleep();
		selectElementByVisibleText(wd.findElement(By.cssSelector("select[name='billing.country']")), "Canada");
		sleep();
		selectElementByIndex(wd.findElement(By.cssSelector("select[name='billing.state']")), 2);
		sleep();
		deselectAll(wd.findElement(By.cssSelector("select[name='billing.country']")));
		sleep();
		
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

	public void selectElementByIndex(WebElement element, int index) {
		Select sc = new Select(element);
		sc.selectByIndex(index);
	}

	public void selectElementByValue(WebElement element, String value) {
		Select sc = new Select(element);
		sc.selectByValue(value);
	}

	public void selectElementByVisibleText(WebElement element, String text) {
		Select sc = new Select(element);
		sc.selectByVisibleText(text);
	}
	
	public void deselectAll(WebElement element) {
		Select sc = new Select(element);
		sc.deselectAll();
	}

}
