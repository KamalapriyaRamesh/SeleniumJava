package week2.day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewFBAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//Step1: Click Registration button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Step2: Fill Firstname,Lastname,Email and Password
		driver.findElement(By.name("firstname")).sendKeys("Krits");
		driver.findElement(By.name("lastname")).sendKeys("Rams");
		driver.findElement(By.name("reg_email__")).sendKeys("9381052964");
		driver.findElement(By.id("password_step_input")).sendKeys("K@m@l@2222");
		
		//Step3: Select Day from Dropdown
		WebElement dayDrop = driver.findElement(By.id("day"));
		Select daySec = new Select(dayDrop);
		daySec.selectByIndex(1);
		
		//Step3: Select Month from Dropdown
		WebElement monthDrop = driver.findElement(By.id("month"));
		Select monthSec = new Select(monthDrop);
		monthSec.selectByVisibleText("Jun");
		
		//Step3: Select Year from Dropdown
		WebElement yearDrop = driver.findElement(By.id("year"));
		Select yearSec = new Select(yearDrop);
		yearSec.selectByVisibleText("1993");
		
		//Step3: Select Gender radiobutton
		driver.findElement(By.xpath("//label[contains(text(),'Female')]/following-sibling::input")).click();
		
		//Step4: Click Submit button
		driver.findElement(By.name("websubmit")).click();
		
		System.out.println("All Test case passed successfully!");
		System.out.println("Closing window!");
	}

}
