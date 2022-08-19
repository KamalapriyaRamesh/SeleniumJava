package week2.day2Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		
		WebElement toolDd = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select toolS = new Select(toolDd);
		toolS.selectByVisibleText("Selenium");
		
		driver.findElement(By.xpath("//label[contains(@class,'ui-selectonemenu-label')]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'ui-selectonemenu-item')]/ul)[1]/li[contains(text(),'India')]")).click();
		
		
		Thread.sleep(5000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		driver.findElement(By.xpath("//label[contains(text(),'Select City')]")).click();
//		
		List<WebElement> cityList = driver.findElements(By.xpath("(//div[contains(@class,'ui-selectonemenu-item')]/ul)[2]/li"));
		int cityLoaded = cityList.size();
		if(cityLoaded>1) {
			System.out.println("Loaded successfully as Expected! ");
		}else {
			System.out.println("Problem in loading city!!");
		}
		
		driver.findElement(By.xpath("//div[contains(@class,'ui-selectonemenu-item')]/ul/li[contains(text(),'Chennai')]")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'ui-autocomplete-dropdown')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[contains(@class,'ui-autocomplete-panel')]/ul/li)[3]")).click();
		
		driver.findElement(By.xpath("//label[contains(text(),'Select Language')]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'ui-selectonemenu-items')])[2]/ul/li[contains(text(),'Tamil')]")).click();
		
		Thread.sleep(400);
		driver.findElement(By.xpath("//label[contains(text(),'Select Values')]")).click();
		driver.findElement(By.xpath("(//div[@class='ui-selectonemenu-items-wrapper']/ul)[4]/li[2]")).click();
		
		System.out.println("Successfully completed accessing all elements and shutting down!");
		driver.close();
		
	}

}
