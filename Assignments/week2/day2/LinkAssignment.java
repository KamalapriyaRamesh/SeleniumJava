package week2.day2Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		
		//Step1: Take me to Dashboard
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Take me to Dashboard");
		driver.findElement(By.linkText("Go to Dashboard")).click();
		String title = driver.getTitle();
		if(title.contains("Dashboard")) {
			System.out.println("Landed to Dashboard successfully!");
		}else {
			System.out.println("Issue in link click!!");
		}
		driver.navigate().back();
		
		//Step2: Find my URL
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Find my URL");
		String findURL = driver.findElement(By.linkText("Find the URL without clicking me.")).getAttribute("href");
		System.out.println("The URL of your next page is: "+findURL);
		
		//Step3: Find Broken URL
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Find Broken URL");
		driver.findElement(By.linkText("Broken?")).click();
		String statusText = driver.findElement(By.xpath("//table/tbody/tr[2]/td")).getText();
		if(statusText.contains("404")) {
			System.out.println("Broken Link!");
		}else {
			System.out.println("URL works fine!!");
		}
		driver.navigate().back();
		
		//Step4: Duplicate Link
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Duplicate Link");
		String linkHref = driver.findElement(By.linkText("Go to Dashboard")).getAttribute("href");
		if(linkHref.contains("/dashboard.xhtml")) {
			System.out.println("Link landing to duplicate page!");
		}else {
			System.out.println("Not a duplicate page!!");
		}
		
		//Step5: How many links in this page?
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("How many links in this page?");
		driver.findElement(By.linkText("How many links in this page?")).click();
		List<WebElement> linkCount = driver.findElements(By.tagName("a"));
		System.out.println("Number of links in this page: "+linkCount.size());
		driver.navigate().back();
		
		//Step6: How many Links in the Layout?
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("How many Links in the Layout?");
		driver.findElement(By.linkText("How many links in this layout?")).click();
		List<WebElement> layoutLinkCount = driver.findElements(By.tagName("a"));
		System.out.println("Number of links in this page: "+layoutLinkCount.size());
		driver.navigate().back();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("All Test case passed successfully!");
		System.out.println("Closing window!");
		driver.close();
	}

}
