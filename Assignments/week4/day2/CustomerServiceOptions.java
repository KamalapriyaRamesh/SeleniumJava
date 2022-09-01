package week4.day2Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CustomerServiceOptions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.titleContains("Home | Salesforce"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Learn More']/parent::button")).click();
		
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		String title = driver.getTitle();
		System.out.println("Landed to: "+title);
		
		Shadow shade = new Shadow(driver);
		shade.findElementByXPath("//span[contains(text(),'Products')]").click();
		Thread.sleep(2000);
		shade.findElementByXPath("//span[contains(text(),'Service')]").click();
		shade.findElementByXPath("//a[text()='Customer Service']").click();
		
		String title1 = driver.getTitle();
		System.out.println("Landed to: "+title1);
		
		List<WebElement> listOfCert = driver.findElements(By.xpath("//div[contains(@class,'buttonCTAComponent')]/preceding-sibling::div[contains(@class,'headingSmallLightComponent')]"));
		int size = listOfCert.size();
		System.out.println("Certificates under this section: ");
		for(int cert=1;cert<=size;cert++) {
			String certText = driver.findElement(By.xpath("(//div[contains(@class,'buttonCTAComponent')]/preceding-sibling::div[contains(@class,'headingSmallLightComponent')])["+cert+"]")).getText();
			System.out.println(certText);
		}
		
		System.out.println("Completed all TCs successfully and closing window!");
	       driver.quit();
	}

}
