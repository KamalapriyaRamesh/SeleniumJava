package week4.day1Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
	    driver.findElement(By.linkText("CRM/SFA")).click();
	    driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	   
	    driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']//following::a")).click();
	    String windowHandle = driver.getWindowHandle();
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> list = new ArrayList<String>(windowHandles); 
	    driver.switchTo().window(list.get(1));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//a")).click();
	    driver.switchTo().window(windowHandle);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
	    driver.findElement(By.xpath("//input[@id='ComboBox_partyIdTo']//following::a")).click();
	    String windowHandleTo = driver.getWindowHandle();
	    Set<String> windowHandlesTo = driver.getWindowHandles();
	    List<String> list1 = new ArrayList<String>(windowHandlesTo); 
	    driver.switchTo().window(list1.get(1));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//a")).click();
	    driver.switchTo().window(windowHandleTo);
	    
	    driver.findElement(By.xpath("//a[text()='Merge']")).click();
	    driver.switchTo().alert().accept();
	    
	    String title = driver.getTitle();
	    System.out.println("You landed to: "+title);
	    
	    System.out.println("Completed all TCs successfully and closing window!");
        driver.close();
	}

}
