package week2.day2Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
		//Step2: Click and confirm title
		driver.findElement(By.xpath("//span[contains(text(),'Click')]")).click();
		String title = driver.getTitle();
		if(title.contains("Dashboard")) {
			System.out.println("Landed on Correct page!");
		}else {
			System.out.println("Step failed!!");
		}
		
		driver.navigate().back();
		
		//Step3: Confirm if the button is disabled
		boolean enabled = driver.findElement(By.xpath("(//div[@class='card'])[2]/button")).isEnabled();
		if(enabled== false) {
			System.out.println("The button is disabled as expected!");
		}else {
			System.out.println("The button is still enabled!!");
		}
		
		//Step4: Find the position of the Submit button
		Point location = driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).getLocation();
		System.out.println("The position of the Submit button in the page is: "+location);
		
		//Step5: Find the Save button colour
		String cssValue = driver.findElement(By.xpath("//span[contains(text(),'Save')]")).getCssValue("color");
		System.out.println("The colour of the button is: "+cssValue);
		
		//Step6: Find height and width of the button
		Dimension size = driver.findElement(By.xpath("(//span[contains(text(),'Submit')])[2]")).getSize();
		System.out.println("The Height and width of the button is: "+size);
		
		//Step7: Verify if the colour of the button changes when hover
		String cssValueBeforeChange = driver.findElement(By.xpath("(//span[contains(text(),'Success')])[1]/parent::button")).getCssValue("background-color");
		System.out.println("Button Colour before change: "+cssValueBeforeChange);
		
		WebElement findElement = driver.findElement(By.xpath("(//span[contains(text(),'Success')])[1]/parent::button"));
		Actions act = new Actions(driver);
		act.moveToElement(findElement).perform();
		
		String cssValueAfterChange = driver.findElement(By.xpath("(//span[contains(text(),'Success')])[1]/parent::button")).getCssValue("background-color");
		System.out.println("Button Colour before change: "+cssValueAfterChange);
		
		if(cssValueBeforeChange.equals(cssValueAfterChange)) {
			System.out.println("No Changes!");
		}else {
			System.out.println("Button color changed successfully!!");
		}
		
		//Step8: Click on hidden images
		driver.findElement(By.xpath("//span[contains(text(),'Image')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		
		//Step9: Find total rounded buttons
	List<WebElement> findElements = driver.findElements(By.xpath("//button[contains(@class,'rounded-button')]"));
		int countOfEle = findElements.size();
		System.out.println("Number of Rounded button available: "+countOfEle);
		
		System.out.println("All Test case passed successfully!");
		System.out.println("Closing window!");
		driver.close();
	}

}
