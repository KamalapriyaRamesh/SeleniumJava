package week6.day2Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class OrderingMobile extends ProjectSpecificMethod{
	
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
		shade.findElementByXPath("//span[text()='Service Catalog']").click();
		Thread.sleep(10000);
		WebElement frameID = shade.findElementByXPath("//iframe[@id='gsft_main']");//driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(frameID);
		shade.findElementByXPath("//h2[contains(text(),'Mobiles')]").click();
		
		shade.findElementByXPath("//strong[text()='iPhone 6s']").click();
		
		WebElement colorDrop = driver.findElement(By.xpath("(//span[text()='What color would you like?']/following::select)[1]"));
		Select sec = new Select(colorDrop);
		sec.selectByVisibleText(color);
		
		WebElement sizeDrop = driver.findElement(By.xpath("(//span[text()='What color would you like?']/following::select)[2]"));
		Select sec1 = new Select(sizeDrop);
		sec1.selectByVisibleText(size);
		
		shade.findElementByXPath("//button[@id='oi_order_now_button']").click();
		
		String orderStatus = shade.findElementByXPath("//div[contains(@id,'order_status')]/div/span").getText();
		System.out.println(orderStatus);
		String requestID = shade.findElementByXPath("//div[contains(@id,'order_status')]/dl/dd[2]/a/b").getText();
		if(orderStatus.contains("your request has been submitted")) {
			System.out.println("Order placed successfully and your request ID is: "+requestID);
		}else {
			System.out.println("There is some issue!!");
		}
		
	}

}
