package week6.day2Assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import week6.day2Assignment.ReadExcelData;

public class ProjectSpecificMethod {
	
//	protected ChromeDriver driver = new ChromeDriver(); "protected" needs to be given if we need to access this class from outside the package
	
	public RemoteWebDriver driver;
	public String excelFileName,sheetName;
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void browserSetup(String url,String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
//	@AfterMethod
//	public void browserShutdown() {
//		System.out.println("This test case is completed successfully and closing the browser!");
//		driver.close();
//	}
	
	@DataProvider
	public String[][] sendData() throws IOException{
		String[][] data = ReadExcelData.getData(excelFileName,sheetName);
		return data;
	}

}
