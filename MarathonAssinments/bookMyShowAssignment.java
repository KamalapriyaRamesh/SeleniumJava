package MarathonAssinments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bookMyShowAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Search for your city']")).sendKeys("Hyderabad",Keys.ENTER);
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("hyderabad")) {
			System.out.println("Routed to correct page!");
		}else {
			System.out.println("Not expected page!!");
		}
		
		driver.findElement(By.xpath("//span[contains(text(),'Search for')]/../..")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search for')]")).sendKeys("Minions: The Rise of Gru");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Minions: The Rise of Gru')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Book tickets')]")).click();
		
		String theaterName = driver.findElement(By.xpath("(//ul[@id='venuelist']/li[1]//a)[1]")).getText();
		System.out.println("Theater found: "+theaterName);
		
		driver.findElement(By.xpath("//div[contains(text(),'INFO')]")).click();
		Thread.sleep(3000);
		boolean parking = driver.findElement(By.xpath("//div[contains(text(),'Parking Facility')]")).isDisplayed();
		if(parking==true) {
			System.out.println("Parking Available!");
		}else {
			System.out.println("Parking not available!!");
		}
		
		driver.findElement(By.xpath("//div[contains(@class,'cross-container')]")).click();
		
		driver.findElement(By.xpath("//a[@class='showtime-pill']")).click();
		
		
		driver.findElement(By.xpath("(//div[contains(text(),'Accept')])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='qty-sel-title-body']//li[contains(text(),'1')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Select Seats')]")).click();
		driver.findElement(By.xpath("//div[@id='A_8_014']/a")).click();
		driver.findElement(By.id("btmcntbook")).click();
		Thread.sleep(3000);
		String subTotal = driver.findElement(By.xpath("//span[@id='subTT']")).getText();
		System.out.println("You need to pay: "+subTotal);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
        File destination = new File("./snaps/bookMyShow.png");
        FileUtils.copyFile(source, destination);
        
        System.out.println("Completed all TCs successfully and closing window!");
        driver.close();
	}

}
