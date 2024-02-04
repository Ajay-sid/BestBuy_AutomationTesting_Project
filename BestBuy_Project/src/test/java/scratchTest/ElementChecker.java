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
	
	driver.get("https://www.bestbuy.com/?intl=nosplash");
	//
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	Thread.sleep(5000);
	driver.switchTo().defaultContent();
	//bestbuy logo
//	driver.findElement(By.xpath("//a[@title='BestBuy.com']")).click();
//	Thread.sleep(5000);
//	driver.close();
	
	//cartLogo
	//driver.findElement(By.xpath("//span[text()='Cart']")).click();
	
	//menu
	//driver.findElement(By.xpath("//*[local-name()='svg' and @class='open-hamburger-icon' ]")).click();
	
	//Search input
	//driver.findElement(By.name("st")).sendKeys("Jade");
	//search button
	//driver.findElement(By.xpath("//button[@title='submit search']")).click();
	
	//acount
	driver.findElement(By.id("account-menu-account-button")).click();
	driver.findElement(By.xpath("//a[text()='Create Account']")).click();
	



}


}
