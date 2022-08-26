package MarathonAssinments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class redBusAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("src")).sendKeys("Chennai");
		Thread.sleep(3000);
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		Thread.sleep(3000);
		driver.findElement(By.id("onward_cal")).click();
		driver.findElement(By.xpath("//td[contains(text(),'27')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		String textFun = driver.findElement(By.xpath("//span[@class='f-bold busFound']/parent::span")).getText();
		System.out.println("Number of Buses: "+textFun);
		driver.findElement(By.xpath("//label[@for='dtAfter 6 pm']")).click();
		String busText = driver.findElement(By.xpath("//ul[@class='bus-items']/div[2]//div[contains(@class,'travels')]")).getText();
		System.out.println("Bus name in second search result: "+busText);
		
		driver.findElement(By.xpath("//ul[@class='bus-items']/div[2]//div[contains(text(),'View Seats')]")).click();
		
		File source = driver.getScreenshotAs(OutputType.FILE);
        File destination = new File("./snaps/redBus.png");
        FileUtils.copyFile(source, destination);
        
        System.out.println("Completed all TCs successfully and closing window!");
        driver.close();
	}

}
