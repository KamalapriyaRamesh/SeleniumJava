package week2.day2Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//div[contains(@class,'ui-chkbox-box')])[1]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'ui-chkbox-box')])[2]")).click();
////		
////		//Ste3: Choose your fav. Lang
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Choose your fav. Lang");
		driver.findElement(By.xpath("(//div[contains(@class,'ui-chkbox-box')])[3]")).click();
//		
//		//Step4: Tri State Checkbox
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Tri State Checkbox");
		int counter=1;
		while(counter<=3) {
		driver.findElement(By.xpath("(//div[contains(@class,'ui-chkbox-box')])[8]")).click();
		Thread.sleep(400);
//		String pageSource = driver.getPageSource();
//		System.out.println("Value found: "+pageSource);
//		if(pageSource.contains("State has been changed")) {
//			System.out.println("Tri State changed successfully!");
//		}else {
//			System.out.println("Checkbox not clicked!");
//		}
		
		String text = driver.findElement(By.xpath("//div[@class='ui-growl-message']/p[contains(text(),'State')]")).getText();
		System.out.println("Status chnages to: "+text);
		counter++;
		}
//		
//		//Step5: Toggle Switch
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Toggle Switch");
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
		Thread.sleep(400);
		String toggleText = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span")).getText();
		System.out.println("toggleText: "+toggleText);
		if(toggleText.contains("Checked")) {
			System.out.println("Toggle switch worked successfully!");
		}else {
			System.out.println("Cannot Toggle!!");
		}
//		
//		//Step6: Verify if the check box is disabled
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Verify if the check box is disabled");
		boolean checkboxEnabled = driver.findElement(By.xpath("(//div[@class='grid formgrid']//input)[9]")).isEnabled();
		if(checkboxEnabled==false) {
			System.out.println("The checkbox is disabled!");
		}else {
			System.out.println("The checkbox is enabled!!");
		}
		
		//Step7: Select Multiple
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Select Multiple");
		driver.findElement(By.xpath("//div[contains(@class,'ui-selectcheckboxmenu-multiple')]")).click();
		String cities[] = {"Miami","London"};
		for(int i=0; i<cities.length;i++) {
			driver.findElement(By.xpath("(//label[text()='"+cities[i]+"']/preceding::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'][1])[2]")).click();
		}
		
//		driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[10]")).click();
//		driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[11]")).click();
		driver.findElement(By.xpath("//a[@class='ui-selectcheckboxmenu-close ui-corner-all']")).click();
		
		System.out.println("All Test case passed successfully!");
		System.out.println("Closing window!");
		driver.close();
	}

}
