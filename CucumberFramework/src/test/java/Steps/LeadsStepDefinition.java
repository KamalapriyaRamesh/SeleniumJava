package Steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadsStepDefinition {
	
	ChromeDriver driver;
    List<String> allhandles;
    String leadID;
	
	@Given("Browser is setup")
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @And("Load the leaftaps webpage using {string}")
    public void loadURL(String url) {
        driver.get(url);

    }

    @And("maximize the webBrowser and set timeouts")
    public void maximizeAndSetTimeout() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @And("Enter the username {string} and password {string} and click submit button")
    public void enterTheUsernameAndPasswordAndClickSubmitButton(String username,String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("decorativeSubmit")).click();
    }

    @And("Click on crmsfa link and move to Leads tab")
    public void moveToLead() {
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
    }
    
    @And("Click on Create Leads link")
	public void createLeadLink() {
		driver.findElement(By.linkText("Create Lead")).click();
	}
	
	@Then("Enter the necessary details in the CreateLead form")
	public void fillCreateLeadForm() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
	}

    @And("Click Submit button and the lead should be created successfully.")
    public void submitForm() {
        driver.findElement(By.name("submitButton")).click();
    }

    @And("Click on Find Leads link")
    public void clickFindLeadsLink() {
        driver.findElement(By.linkText("Find Leads")).click();
    }

    @And("Click on Phone")
    public void clickOnPhone() {
        driver.findElement(By.xpath("//span[text()='Phone']")).click();
    }

    @And("Pass {string} for Phone Number in the text box")
    public void passValueInTextBox(String value) {
        driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(value);
    }

    @And("Click on FindLead Button")
    public void clickOnFindLead() {
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
    }



    @And("Click first found data from the table")
    public void clickFirstFoundData() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
    }

    @Then("Click on Edit link and update the existing company name to {string}")
    public void updateExisitngProfile(String companyName) {
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
    }

    @Then("Close Browser once test case passed")
    public void closeBrowserOnceTestCasePassed() {
        driver.close();
    }

    @Then("Click on Duplicate Lead link")
    public void clickOnDuplicateLeadLink() {
        driver.findElement(By.linkText("Duplicate Lead")).click();
    }

    @Given("Click on Merge Leads link")
    public void clickOnMergeLeadsLink() {
        driver.findElement(By.linkText("Merge Leads")).click();
    }

    @And("Click First lookup")
    public void clickFirstLookup(){
        driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
    }

    @And("Click Second lookup")
    public void clickSecondLookup(){
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
    }

    @And("Find using firstname as {string}")
    public void findUsingFirstnameAs(String fname){
        Set<String> allWindows = driver.getWindowHandles();
        allhandles = new ArrayList<String>(allWindows);
        driver.switchTo().window(allhandles.get(1));
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname);
    }

    @Then("Find first occurring lead ID from the table and click it")
    public void findFirstOccurringLeadIDFromTheTableAndClickIt() throws InterruptedException {
        Thread.sleep(1000);
        leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
    }

    @And("Switch Back to parent Window")
    public void switchBackToParentWindow() {
        driver.switchTo().window(allhandles.get(0));
    }

    @And("Click First occurring lead ID and Click Merge")
    public void clickFirstOccurringLeadIDAndClickMerge() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
        driver.switchTo().window(allhandles.get(0));
        driver.findElement(By.xpath("//a[text()='Merge']")).click();
        driver.switchTo().alert().accept();
    }

    @And("Pass the first lead ID")
    public void passTheFirstLeadID() {
        driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
    }

    @And("Check if the lead ID exist or not")
    public void checkIfTheLeadIDExistOrNot() {
        String text = driver.findElement(By.className("x-paging-info")).getText();
        if (text.equals("No records to display")) {
            System.out.println("Text matched");
        } else {
            System.out.println("Text not matched");
        }
    }

    @Then("Click on Delete link")
    public void clickOnDeleteLink() {
        driver.findElement(By.linkText("Delete")).click();
    }
}
