package MarathonAssinments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
		System.out.println("Waited");
		driver.findElement(By.xpath("//span[contains(text(),' for boys')]")).click();
		String forText = driver.findElement(By.xpath("//span[contains(text(),'bags for boys')]")).getText();
		String searchText = driver.findElement(By.xpath("//span[contains(text(),'bags for boys')]/preceding::span[2]")).getText();
		String[] split = searchText.split(" ");
		String splitVal1= split[3].replace(",", "");
		System.out.println("Total search results found: "+splitVal1);
		driver.findElement(By.xpath("//span[@class='a-button-inner']")).click();
		driver.findElement(By.linkText("Newest Arrivals")).click();
		driver.findElement(By.xpath("//li[@aria-label='Get It by Tomorrow']//div")).click();
		Thread.sleep(1000);
		String resultedText = driver.findElement(By.xpath("//span[contains(text(),'bags for boys')]/preceding::span[2]")).getText();
		String[] split2 = resultedText.split(" ");
		System.out.println(resultedText);
		String splitVal2 = split2[2];
		System.out.println("Total search results found now: "+splitVal2);
		if(Integer.parseInt(splitVal2)<Integer.parseInt(splitVal1)) {
			System.out.println("The result value is reduced as expected!");
		}else {
			System.out.println("No expected changes found!!");
		}
		
		String productDesc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-micro puis-padding-right-micro']/div[2]")).getText();
		System.out.println("Product Description: "+productDesc);
		String productPrice = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small puis-padding-left-micro puis-padding-right-micro']/div[3]")).getText();
		System.out.println("Product Price: "+productPrice);
		
		List<WebElement> DoDCount = driver.findElements(By.xpath("//span[contains(text(),'Deal of the Day')]"));
		int dodSize = DoDCount.size();
		System.out.println("Total Product under Deals of the Day in this page is: "+dodSize);
		
		String colourOfDOD = driver.findElement(By.xpath("//span[contains(text(),'Deal of the Day')]/../..")).getCssValue("background-color");
		System.out.println("Colour of Deals of the Day button: "+colourOfDOD);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
        File destination = new File("./snaps/bag.png");
        FileUtils.copyFile(source, destination);
        
        System.out.println("Completed all TCs successfully and closing window!");
        driver.close();
	}

}
