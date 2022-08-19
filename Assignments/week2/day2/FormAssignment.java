package week2.day2Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0tmb2389go0xlxjvuy66xu9p668024.node0");
		driver.manage().window().maximize();
		
		
		//Step1: Type your name
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Type your name!");
		driver.findElement(By.xpath("//h5[text()='Type your name']/following::input[1]")).clear();
		driver.findElement(By.xpath("//h5[text()='Type your name']/following::input[1]")).sendKeys("Kamalapriya");
//		
//		//Step2: Append Country
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Append Country to this City.");
		String cityText = driver.findElement(By.xpath("//h5[text()='Append Country to this City.']/following::input[1]")).getText();
		driver.findElement(By.xpath("//h5[text()='Append Country to this City.']/following::input[1]")).sendKeys(", India"+cityText);
//		
//		//Step3: Verify if the text box is disabled
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Verify if text box is disabled");
		boolean textBoxEnabled = driver.findElement(By.xpath("//h5[text()='Verify if text box is disabled']/following::input[1]")).isEnabled();
		if(textBoxEnabled==false) {
			System.out.println("The text box is disabled as expected!");
		}else {
			System.out.println("Text box is not disabled!");
		}
//		
//		//Step4: Clear the typed text
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Clear the typed text");
		driver.findElement(By.xpath("//h5[text()='Clear the typed text.']/following::input[1]")).clear();
//		
//		//Step5: Retrieve the typed text
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Retrieve the typed text");
		String textFromPage = driver.findElement(By.xpath("//h5[text()='Retrieve the typed text.']/following::input[1]")).getAttribute("value");
		System.out.println("Text from the page: "+textFromPage);
//		
//		//Step6: Type Email and Tab
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Type email and Tab. Confirm control moved to next element.");
		driver.findElement(By.xpath("//h5[contains(text(),'Type email and Tab')]/following::input[1]")).sendKeys("Kamalapriya@gmail.com",Keys.TAB);
		WebElement activeElement = driver.switchTo().activeElement();
		String activetext = activeElement.getAttribute("placeholder");
		if(activetext.contains("About yourself")) {
			System.out.println("Focus moved to next box as expected!");
		}else {
			System.out.println("There is some issue!!");
		}
//		
//		//Step7: Type about yourself
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Type about yourself!");
		activeElement.sendKeys("Kamalapriya from Chennai!");
		
//		//Step8: Text Editor
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Text Editor");
		driver.findElement(By.xpath("//span[@class='ql-font ql-picker']")).click();
		driver.findElement(By.xpath("//span[@class='ql-picker-options']/span[3]")).click();
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("Life is Awesome!!");
		
		//Step9: Just Press Enter and confirm error message*
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Press Enter and confirm error message");
		driver.findElement(By.xpath("//h5[contains(text(),'Just Press Enter and confirm error message*')]/following::input[2]")).sendKeys(Keys.ENTER);
		String errorText = driver.findElement(By.xpath("//div[contains(@class,'ui-message-error')]//span[2]")).getText();
		if(errorText.contains("Age is mandatory")) {
			System.out.println("Error message displayed!");
		}else {
			System.out.println("Issue in displaying error message!!");
		}
		
		//Step10: Click and Confirm Label Position Changes
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Click and Confirm Label Position Changes");
		WebElement label = driver.findElement(By.xpath("(//label[@class='ui-outputlabel ui-widget'])[1]"));
		Point beforeLocation = label.getLocation();
		System.out.println("Location Before clicking: "+beforeLocation);
		driver.findElement(By.xpath("//h5[contains(text(),'Click and Confirm Label Position Changes')]/following::input[1]")).click();
		Point afterLocation = label.getLocation();
		System.out.println("Location Before clicking: "+afterLocation); 
		
		if(!beforeLocation.equals(afterLocation)) {
			System.out.println("Position changed successfully!");
		}else {
			System.out.println("Position not changed!!");
		}
		
		//Step11: Type your name and choose the third option
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Type your name and choose the third option");
		WebElement dropName = driver.findElement(By.xpath("//h5[text()='Type your name and choose the third option']/following::input[1]"));
		dropName.sendKeys("Kamalapriya");
		Thread.sleep(500);
		/*
		 * WebElement findMatch =
		 * driver.findElement(By.xpath("(//ul[contains(@class,' ui-helper-reset')])[2]")
		 * ); Actions builder = new Actions(driver);
		 * builder.moveToElement(findMatch).perform(); Thread.sleep(500); for(int
		 * i=0;i<3;i++) { dropName.sendKeys(Keys.DOWN); } dropName.sendKeys(Keys.ENTER);
		 */
		List<WebElement> list2 = driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete-items')]/li"));
		int listSize=list2.size();
		System.out.println(listSize);
		list2.get(2).click();
		
		//Step13: Type number and spin to confirm value changed
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Type number and spin to confirm value changed");
		WebElement spin = driver.findElement(By.xpath("//h5[contains(text(),'Type number')]/following::input[1]"));
		spin.sendKeys("21");
		String attribute = spin.getAttribute("value");
		driver.findElement(By.xpath("//span[@class='ui-icon ui-c ui-icon-triangle-1-n']")).click();
		String attribute1 = spin.getAttribute("value");
		if(!attribute.equals(attribute1)) {
			System.out.println("Confirmed value changed!");
		}else {
			System.out.println("value not changed!!");
		}
		
		//Step14: Type random number (1-100) and confirm slider moves correctly
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Type random number (1-100) and confirm slider moves correctly");
		Point beforesliderLocation = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]")).getLocation();
		driver.findElement(By.xpath("//h5[contains(text(),'Type random number')]/following::input[1]")).sendKeys("50");
		Point aftersliderLocation = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]")).getLocation();
		if(!beforesliderLocation.equals(aftersliderLocation)) {
			System.out.println("Slider moved!");
		}else {
			System.out.println("no change!!");
		}
		
		//Step15: Click and Confirm Keyboard appears
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Click and Confirm Keyboard appears");	
		driver.findElement(By.xpath("//h5[contains(text(),'Click and Confirm Keyboard appears')]/following::input[1]")).click();
		boolean keyboardDisplayed = driver.findElement(By.xpath("//div[contains(@class,'keypad-popup')]")).isDisplayed();
		if(keyboardDisplayed==true) {
			System.out.println("Keyboard displayed!");
		}else {
			System.out.println("Keyboard not displayed!!");
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class,'keypad-close')]")).click();
		
		//Step16: Custom Toolbar
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("Custom Toolbar");	
				driver.findElement(By.xpath("//h5[contains(text(),'Custom Toolbar')]/following::div[@class='ql-editor ql-blank']")).sendKeys("Life is Awesome when you trust yourself!");
		
				System.out.println("All Test case passed successfully!");
				System.out.println("Closing window!");
				driver.close();
	}

}
