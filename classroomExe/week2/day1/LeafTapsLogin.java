package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsLogin {

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
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Infosys");
		String firstName = "Kamalapriya";
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ramesh");
		
		//Choosing option using sendKeys
		WebElement sourceDD = driver.findElement(By.id("createLeadForm_dataSourceId"));
		sourceDD.sendKeys("Employee");
		
		//Choosing option using selectByIndex
		WebElement marketingDD = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select ddMarket = new Select(marketingDD);
		ddMarket.selectByIndex(3);
		
		//Choosing option using selectByVisibleText
		WebElement industryDD = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select ddIndus = new Select(industryDD);
		ddIndus.selectByVisibleText("Computer Software");
		
		//Choosing option using selectByValue
		WebElement currencyDD = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select ddCur = new Select(currencyDD);
		ddCur.selectByValue("INR");
		
		//Click "Create Lead"
		driver.findElement(By.name("submitButton")).click();
		
		String titleText = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		if(titleText.contains("View Lead")) {
			System.out.println("Lead created successfully!");
		}else {
			System.out.println("There is some issue!");
		}
		
		String verifyFirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(verifyFirstName.contentEquals(firstName)) {
			System.out.println("Correct Lead created!");
		}else {
			System.out.println("Something missing!");
		}
		driver.close();

	}

}
