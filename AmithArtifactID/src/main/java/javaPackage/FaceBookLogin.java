package javaPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FaceBookLogin {

	
WebDriver driver;
	
	@BeforeTest
	
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	
	@Test(dataProvider="LoginData")
	public void loginTest(String email,String password) {
		
		WebElement email_text = driver.findElement(By.id("email"));
		email_text.clear();
		email_text.sendKeys(email);
		
		WebElement email_password = driver.findElement(By.id("pass"));
		email_text.clear();
		email_text.sendKeys(password);
		
	}
		
	@DataProvider(name="LoginData")
	
	public String[][] getData() {
		
		String data[][] = {{"preethis9008@gmail.com", "Preethis@1"}};
		return data;
		
	}
	
	@Test
	public void tearDown() {
		driver.close();
	}
}
