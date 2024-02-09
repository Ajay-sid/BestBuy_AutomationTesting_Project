package scratchTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LandingPage;

public class ElementChecker {


public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.bestbuy.com/?intl=nosplash");
	//
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	try {
		driver.switchTo().frame("tag-sandbox");
		driver.findElement(By.id("survey_invite_no")).click();
		
	}catch(Exception e) {
	}finally {
		driver.switchTo().defaultContent();
	}
	
	driver.findElement(By.id("gh-search-input")).sendKeys("DJI - Mini 4");
	driver.findElement(By.xpath("//button[@title='submit search']")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ol[@class='sku-item-list']//*[@class='column-left'])[1]")));
	
//	List<WebElement> element = driver.findElements(By.xpath("//ol[@class='sku-item-list']//li//div[@class='column-left']"));
//	element.get(0).click();
	//select first element
	driver.findElement(By.xpath("(//ol[@class='sku-item-list']//*[@class='column-left'])[1]")).click();
	////ol[@class="sku-item-list"]/li
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[contains(@class,'quick-assessment')]//*[text()='Add to Cart']")).click();
	




}


}
