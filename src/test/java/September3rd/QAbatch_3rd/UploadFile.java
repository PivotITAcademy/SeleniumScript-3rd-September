package September3rd.QAbatch_3rd;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/upload-download");
		
	}
	
	
	@org.testng.annotations.Test
	public void verifyuploadFunctionality() {
		WebElement uploadButton = driver.findElement(By.cssSelector("#uploadFile"));
		uploadFile("C:\\Users\\swaro\\Downloads\\sampleFile.jpeg", uploadButton);
	}
	
	public void uploadFile(String filePath, WebElement uploadButton) {
		uploadButton.sendKeys(filePath);
	}

}
