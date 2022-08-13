package week2Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
		WebElement getWelcomeMess = driver.findElement(By.tagName("h2"));
		String text = getWelcomeMess.getText();
		System.out.println("The message present is: "+text);
		
		if(text.contains("Welcome")) {
			System.out.println("Landed on correct page!");
		}else {
			System.out.println("No such message!");
		}
		
		//Click on CRM image
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//To go to "Leads" tab
		driver.findElement(By.linkText("Leads")).click();  
		
		//To go to "Create Lead" list
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Fill form
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Infosys Ltd");
		String firstName = "Kamalapriya";
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ramesh");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("KP");
		driver.findElement(By.name("departmentName")).sendKeys("IT");
		driver.findElement(By.name("description")).sendKeys("Creating New Lead for Kamalapriya from IT Dept");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("kp@gmail.com");
		
		//Test step 14: Select State/Province as NewYork Using Visible Text
		WebElement state = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select statedrop = new Select(state);
		statedrop.selectByVisibleText("New York");
		
		//Click "Create Lead"
		driver.findElement(By.name("submitButton")).click();
		
//		//
		String titlePage = driver.getTitle();
		System.out.println("The title of the page is: "+titlePage);
		

	}

}
