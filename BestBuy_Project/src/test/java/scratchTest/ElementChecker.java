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
	int sum=0;
	int count =0;
	driver.findElement(By.xpath("//*[local-name()='svg' and @class='open-hamburger-icon' ]")).click();
	List<WebElement> menulist= driver.findElements(By.xpath("//button[@class='c-button-unstyled top-four v-fw-medium']"));
	
	String ctrlClick=Keys.chord(Keys.CONTROL,Keys.ENTER);
	String parentWindow= driver.getWindowHandle();
	Actions action= new Actions(driver);
	
	for(WebElement ele : menulist) {
		//System.out.println(ele.getText());
		ele.click();
		WebElement elee = driver.findElement(By.xpath("//button[text()='Close']"));
		action.scrollToElement(elee).perform();
		List<WebElement> subMenu = driver.findElements(By.xpath("//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/li/a[@class='hamburger-menu-flyout-list-item  ']"));
		sum+=subMenu.size();
		for(WebElement element:subMenu) {
//			try 
			System.out.println(element.getText());
//				
//		
//			
//			action.moveToElement(element).keyDown(Keys.CONTROL).click().build().perform();
//			System.out.println(element.getText());
//			for(String s : driver.getWindowHandles()) {
//				driver.switchTo().window(s);
//			}
//			System.out.println(driver.getTitle());
//			System.out.println("---------------------------------------------------------------");
//			driver.close();
//			driver.switchTo().window(parentWindow);
//			count++;
//			}catch(ElementNotInteractableException e) {
//				System.out.println(e.getMessage());
//				System.out.println("---------------------------------------------------------------");
//			}
		}
		
	}
	
//	public void menuLinkValidationTest(String mainMenu,String subMenu,String title) throws InterruptedException {
//		LandingPage lp=new LandingPage(driver);
//		String parentwindow=getWindowHandle();
//		
//		action = new Actions(driver);
//		String ctrl = Keys.chord(Keys.CONTROL,Keys.ENTER);
//		actionElementClick(lp.MainMenu(mainMenu));
//		
//		action.moveToElement(lp.allMainMenu(subMenu)).keyDown(Keys.CONTROL).click().build().perform();
//		
//		for(String s : getWindowHandles()) {
//			switchWindow(s);
//		}
//		System.out.println(getPageTitle());	
//		close();
//		switchWindow(parentwindow);
//		actionElementClick(lp.MainMenu(mainMenu));
//	}
			
	
	//Search input
	//driver.findElement(By.name("st")).sendKeys("Jade");
	//search button
	//driver.findElement(By.xpath("//button[@title='submit search']")).click();
	
	//acount
	//driver.findElement(By.id("account-menu-account-button")).click();
	//driver.findElement(By.xpath("//a[text()='Create Account']")).click();
	



}


}
