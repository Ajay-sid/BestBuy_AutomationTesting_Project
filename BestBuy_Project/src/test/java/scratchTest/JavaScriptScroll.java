package scratchTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptScroll {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.bestbuy.com/?intl=nosplash");
		//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.switchTo().defaultContent();
		//bestbuy logo
//		driver.findElement(By.xpath("//a[@title='BestBuy.com']")).click();
//		Thread.sleep(5000);
//		driver.close();
		
		//cartLogo
		//driver.findElement(By.xpath("//span[text()='Cart']")).click();
		
		//menu
		int sum=0;
		int count =0;
		driver.findElement(By.xpath("//*[local-name()='svg' and @class='open-hamburger-icon' ]")).click();
		driver.findElement(By.xpath("//button[text()='Deals']")).click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//button[text()='Close']"));
		action.scrollToElement(ele).perform();
		
		
		
		
		
	}
}
