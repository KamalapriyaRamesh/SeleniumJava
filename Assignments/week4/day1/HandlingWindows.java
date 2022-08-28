package week4.day1Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		
		String before = driver.getTitle();
		
		//TC1: Click and Confirm new Window Opens
		driver.findElement(By.xpath("(//h5[text()='Click and Confirm new Window Opens']//following::span)[1]")).click();
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		String after = driver.getTitle();
		
		if(!before.equalsIgnoreCase(after)) {
			System.out.println("You have landed to another window!");
		}else {
			System.out.println("You didn't land to new window!!");
		}
		driver.close();
		driver.switchTo().window(windowHandle);
		
		//TC2: Find the number of opened tabs
		driver.findElement(By.xpath("(//h5[text()='Click and Confirm new Window Opens']//following::span)[2]")).click();
		Set<String> windowHandlesForCount = driver.getWindowHandles();
		List<String> listCount = new ArrayList<String>(windowHandlesForCount);
		System.out.println("Number of tabs opened: "+listCount.size());
		
		//TC3: Close all windows except Primary
		driver.findElement(By.xpath("(//h5[text()='Click and Confirm new Window Opens']//following::span)[3]")).click();
		String windowHandle2 = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if(!handle.equals(windowHandle2)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		} 
		System.out.println("Closed all windows!");
		driver.switchTo().window(windowHandle2);
		
		//TC4: Wait for 2 new tabs to open
		driver.findElement(By.xpath("(//h5[text()='Click and Confirm new Window Opens']//following::span)[5]")).click();
		String windowHandle3 = driver.getWindowHandle();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles3);
		Thread.sleep(2000);
		System.out.println("There are "+list1.size()+"opened!");
		for (String handle : windowHandles3) {
			if(!handle.equals(windowHandle3)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
	}

}
