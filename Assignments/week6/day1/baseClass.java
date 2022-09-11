package testNG;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
//	protected ChromeDriver driver = new ChromeDriver(); "protected" needs to be given if we need to access this class from outside the package
	
	ChromeDriver driver;
	
	@BeforeMethod
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void browserShutdown() {
		System.out.println("This test case is completed successfully and closing the browser!");
		driver.close();
	}

}
