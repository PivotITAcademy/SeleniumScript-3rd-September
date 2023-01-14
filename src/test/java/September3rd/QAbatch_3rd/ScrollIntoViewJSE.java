package September3rd.QAbatch_3rd;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollIntoViewJSE {

	WebDriver driver;
	JavascriptExecutor jse;
	

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		jse = (JavascriptExecutor)driver;

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

	}

	@Test
	public void scrollIntoiViewFunction() {
		
		WebElement opencartLink = driver.findElement(By.xpath("//a[text() = 'OpenCart']"));
		
		jse.executeScript("arguments[0].scrollIntoView(true);", opencartLink);
		
		jse.executeScript("arguments[0].click();", opencartLink);
	}

}
