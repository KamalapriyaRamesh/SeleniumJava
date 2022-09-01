package week4.day2Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		WebElement findMen = driver.findElement(By.xpath("//span[contains(text(),'Men')]/../.."));
		Actions builder = new Actions(driver);
		builder.moveToElement(findMen).perform();
		
		driver.findElement(By.xpath("//span[text()='Sports Shoes']/parent::a")).click();
		
		String searchCount = driver.findElement(By.xpath("//h1[contains(text(),'Sports Shoes for Men')]/following-sibling::span")).getText();
		System.out.println("Total count: "+searchCount);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sorting-sec animBounce']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		
		String price1 = driver.findElement(By.xpath("(//div[@class='product-tuple-description '])[1]//span[2]")).getText();
		String[] split = price1.split(" ");
		String formattedPrice1 = split[1].replace(",", "");
		System.out.println("Price of first Item: "+split[1]);
		Thread.sleep(2000);
		String price2 = driver.findElement(By.xpath("(//div[@class='product-tuple-description '])[2]//span[2]")).getText();
		String[] split1 = price2.split(" ");
		String formattedPrice2 = split1[1].replace(",", "");
		System.out.println("Price of second Item: "+split1[1].replace(",", "")); //Some issue-> showing wrong price
		
		if(Integer.parseInt(formattedPrice1)<=Integer.parseInt(formattedPrice2)) {
			System.out.println("Price changed according to your sort!");
		}else {
			System.out.println("Price did not changed!!");
		}
		
		driver.findElement(By.xpath("(//div[@class='price-input'])[1]//input")).clear();
		driver.findElement(By.xpath("(//div[@class='price-input'])[1]//input")).sendKeys("900");
		driver.findElement(By.xpath("(//div[@class='price-input'])[2]//input")).clear();
		driver.findElement(By.xpath("(//div[@class='price-input'])[2]//input")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
		Thread.sleep(2000);
//		String colourExpectedText = driver.findElement(By.xpath("//label[@for='Color_s-Navy']/a")).getText();
//		System.out.println("Colour selected: "+colourExpectedText);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
//		
//		String colourActualText = driver.findElement(By.xpath("//div[@class='navFiltersPill']/a")).getAttribute("data-value");
//		if(colourExpectedText.equalsIgnoreCase(colourActualText)) {
//			System.out.println("Correct filter is selected!");
//		}else {
//			System.out.println("Filter mismatch!!");
//		}
		
		
//		WebElement findProduct = driver.findElement(By.xpath("(//div[contains(@class,'product-tuple-listing')])[1]"));
//		builder.moveToElement(findProduct).perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
//		
//		String priceText = driver.findElement(By.xpath("//div[@class='lfloat']//div[2]")).getText();
//		System.out.println("Price: "+priceText);		
//
//		File source = driver.getScreenshotAs(OutputType.FILE);
//        File destination = new File("./snaps/SnapDeal.png");
//        FileUtils.copyFile(source, destination);
//        
//        System.out.println("Completed all TCs successfully and closing window!");
//        driver.close();
	}

}
