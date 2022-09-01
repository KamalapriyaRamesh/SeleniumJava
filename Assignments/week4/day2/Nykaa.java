package week4.day2Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();

		WebElement brands = driver.findElement(By.xpath("//a[contains(text(),'brands')]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		String product = "L'Oreal Paris";
		driver.findElement(By.id("brandSearchBox")).sendKeys(product);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]")).click();
		
		String title = driver.getTitle();
		if(title.contains(product)) {
			System.out.println("Landed on correct page!");
		}else {
			System.out.println("Incorrect Page!!");
		}
		
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		
		driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']//div[2]")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Category']/following::ul[2]/li[2]")).click();
		driver.findElement(By.xpath("//span[text()='Category']//following::ul[3]/li[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Shampoo']//following::div")).click();
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Color Protection']/following::div")).click();
		
		List<WebElement> filterCount = driver.findElements(By.xpath("//span[@class='filter-value']"));
		int size = filterCount.size();
		
		for (int count=1; count<=size; count++) {
			String filterText = driver.findElement(By.xpath("(//span[@class='filter-value'])["+count+"]")).getText();
			System.out.println("Filter Applied: "+filterText);
		}
		
		driver.findElement(By.xpath("//a[contains(@href,'paris-color-protect-shampoo')]")).click();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		Thread.sleep(2000);
		
		WebElement sizeDD = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select select = new Select(sizeDD);
		select.selectByVisibleText("175ml");
		
		String rate = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("Price of the selected product: "+rate);
		
		driver.findElement(By.xpath("//span[text()='Add to Bag']/parent::button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='cart-count']/parent::button")).click();
		
		WebElement cartFrame = driver.findElement(By.xpath("//iframe[contains(@src,'mobileCartIframe')]"));
		driver.switchTo().frame(cartFrame);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='payment-tbl-data']")));
		
		String grandBefore = driver.findElement(By.xpath("//div[@class='payment-tbl-data']/div[4]/div[2]")).getText();
		System.out.println("Grand Total: "+grandBefore);
		driver.findElement(By.xpath("//span[text()='Proceed']/ancestor::button")).click();
		
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		String grandAfter = driver.findElement(By.xpath("(//div[contains(@class,'payment-details-tbl')])[4]/div[2]")).getText();
		System.out.println("Grand Total in Payment: "+grandAfter);
		
		if(grandBefore.equalsIgnoreCase(grandAfter)) {
			System.out.println("Grand Total are same!");
		}else {
			System.out.println("Grand total is different!!");
		}
		
		System.out.println("Completed all TCs successfully and closing window!");
        driver.quit();
	}

}
