package week2.day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Step1: Setup page
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//Step2: Enter the username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
		
		//Step3: Enter the password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		//Step4: Click Login
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		//Step5: Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//Step6: Click Leads link
		driver.findElement(By.xpath("//a[contains(@href,'leadsMain')]")).click();
		
		//Step7: Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Step8: Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Kamalapriya");
		
		//Step9: Click Find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		//Step10: Click on first resulting lead		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		String firstRecord = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a[@class='linktext']")).getText();
		 System.out.println("First record from the table: "+firstRecord);
		 
		 driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a[@class='linktext']")).click();
		 
		 //Step11: Verify title of the page
		 String title = driver.getTitle();
		 if(title.contains("View Lead")) {
			 System.out.println("Landed on correct page!");
		 }else {
			 System.out.println("There is some issue!!");
		 }
		 
		 //Step12: Click Edit
		 driver.findElement(By.linkText("Edit")).click();
		 
		 //Step13: Change the company name
		 driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).clear();
		 String actualText = "Edited";
		 driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys(actualText);
		 
		 //Step13: Click Update
		 driver.findElement(By.name("submitButton")).click();
		 
		 String expectedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		 
		 System.out.println("Company Name displayed is: "+expectedCompanyName);
		 
		 if(expectedCompanyName.contains(actualText)) {
			 System.out.println("Edited Successfully!");
		 }else {
			 System.out.println("Cannot Edit!!");
		 }
		 
		System.out.println("All Test case passed successfully!");
		System.out.println("Closing window!");
		 driver.close();
	}

}
