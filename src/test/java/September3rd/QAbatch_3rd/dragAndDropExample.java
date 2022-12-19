package September3rd.QAbatch_3rd;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class dragAndDropExample {
	
WebDriver wd;
	
	WebDriverWait wdwait;
	
	Actions action;
	
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {

		// Basic Setup to begin with Selenium
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

		// intialise webdriver instance
		wd = new ChromeDriver();
			
		wdwait = new WebDriverWait(	wd, Duration.ofSeconds(10));
		
		sf = new SoftAssert();

		// Launch a page
		wd.get("https://demoqa.com/droppable");
		
		action = new Actions(wd);

		

	}
	
	@Test
	public void verifyDragAndDrop() {
		
		
		WebElement sourceBox = wd.findElement(By.cssSelector("#draggable"));
		
		WebElement targetBox = wd.findElement(By.cssSelector("div .simple-drop-container div:nth-of-type(2)"));
		
		action.dragAndDrop(sourceBox, targetBox).perform();
		
		sf.assertEquals(targetBox.getText(), "Dropped!", "Text does not match");
		

	}
	
	@AfterMethod
	public void tearDown() {
		// closing the browser
		wd.quit();
	}

}
