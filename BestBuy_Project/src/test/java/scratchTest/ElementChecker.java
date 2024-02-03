package scratchTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementChecker {


public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.bestbuy.com");
	WebElement us = driver.findElement(By.xpath("//div[@lang='en']/div[@class='country-selection']/a[@class='us-link']"));
	us.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	Thread.sleep(5000);
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//a[@title='BestBuy.com']")).click();
	Thread.sleep(5000);
	driver.close();
	
	
}
}
