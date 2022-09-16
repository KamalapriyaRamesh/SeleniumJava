package week6.day2Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class KnowledgeForm extends ProjectSpecificMethod{
	
	@BeforeTest
	public void setData() {
		excelFileName="OrderingMobile";
		sheetName="order";
	}

	@Test(dataProvider = "sendData")
	public void mobileOrdering(String username, String password, String color, String size) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(15000);
		Shadow shade = new Shadow(driver);
		shade.findElementByXPath("//div[@id='all']").click();
		Thread.sleep(2000);
		//shade.findElementByXPath("//input[@id='filter']").sendKeys("Service catalog",Keys.TAB);
		
		shade.findElementByXPath("//span[text()='Knowledge']").click();
		
		Thread.sleep(7000);
////		WebElement createArticle = shade.findElementByXPath("//span[text()='Create an Article']");
		WebElement frameIns = shade.findElementByXPath("//iframe[@title='Main Content']");
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIns));
		
		driver.switchTo().frame(frameIns);
		
		Thread.sleep(5000);
		
		shade.findElementByXPath("//span[text()='Create an Article']").click();		
		
//		Thread.sleep(5000);
		String parentWindow = driver.getWindowHandle();
		String parentTitle = driver.getTitle();
		System.out.println("Parent window Title: "+parentTitle);
		shade.findElementByXPath("//span[@class='input-group-btn']").click();
		
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> jump = new ArrayList<String>(windowHandles);
		driver.switchTo().window(jump.get(1));
//		driver.switchTo().window("Knowledge Bases | ServiceNow");
//		for (String handle : windowHandles) {
//			if(driver.switchTo().window(handle).getTitle().contains("Knowledge Bases")) {
//				System.out.println("Jumped to Knowledge Base window");
//				jumpSuccess = true;
//				break;
//			}
//		}if(jumpSuccess) {
//			System.out.println("Could not jump to expected window!");
//			driver.switchTo().window(parentWindow);
//		}
		
		driver.findElement(By.xpath("//tbody[@class='list2_body']//td[3]/a")).click();
		driver.switchTo().window(parentWindow);
		if(driver.getTitle().contains(parentTitle)) {
			System.out.println("Landed back to parent window!");
		}
		
		Thread.sleep(20000);
		driver.switchTo().frame(frameIns);
		
		shade.findElementByXPath("//button[@id='lookup.kb_knowledge.kb_category']").click();
		Thread.sleep(5000);
		shade.findElementByXPath("//span[text()='IT']").click();
		shade.findElementByXPath("//span[text()='Java']").click();
		shade.findElementByXPath("//button[text()='OK']").click();
		Thread.sleep(15000);
		
		shade.findElementByXPath("//input[@id='kb_knowledge.short_description']").sendKeys("Creating for Automation Test");
//		
		shade.findElementByXPath("//button[text()='Submit']").click();
	}

}
