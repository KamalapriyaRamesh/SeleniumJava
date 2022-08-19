package week2.day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadAssignment {

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
				
				//Step8: Click on Phone tab
				driver.findElement(By.xpath("//span[text()='Phone']")).click();
				
				//Step9: Enter Phone Number
				driver.findElement(By.name("phoneNumber")).sendKeys("6487912167584621");
				
				//Step10: Click Find Lead button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				//Step11: Get Lead ID of first record
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				String leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a[@class='linktext'])[1]")).getText();
				
				System.out.println("Lead ID: "+leadID);
				
				//Step12: Click Delete
				driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a[@class='linktext'])[1]")).click();
				driver.findElement(By.linkText("Delete")).click();
				
				String titleAfterDelete = driver.getTitle();
				if(titleAfterDelete.contains("My Leads")) {
					System.out.println("Deleted and came back to My Leads Page!");
				}else {
					System.out.println("Cannot Delete!!");
				}
				
				//Step13: Click Find leads
				driver.findElement(By.linkText("Find Leads")).click();
				//Step14: Enter captured lead ID
				driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
				
				//Step15: Click Find leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				
				//Step16: Verify message "No records to display" in the Lead List. This message confirms the successful deletion
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				boolean verifyMessage = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).isDisplayed();
				if(verifyMessage==true) {
					System.out.println("Record Deleted successfully!");
				}else {
					System.out.println("Cannot delete record!!");
				}
				
				System.out.println("All Test case passed successfully!");
				System.out.println("Closing window!");
				
				driver.close();
	}

}
