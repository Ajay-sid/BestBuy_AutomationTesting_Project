package scratchTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpec;
import junit.framework.Assert;
import pages.LandingPage;

public class MenuValidation extends ProjectSpec{
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void setUp(String browser,String url) {
		launch(browser, url);
		
		excelFile="MenuLinkValidation";
		
		
	}
	
	
	@Override
	@Parameters({"browser","url"})
	@BeforeMethod
	public void launchBrowser(String browser,String url) {
		
	}
	
	@Test(priority=0)
	public void menuButtonTest() {
		LandingPage lp=new LandingPage(driver);
		lp.MenuIconClick();
		WebElement menuSection = driver.findElement(By.xpath("//div[@class=\"hamburger-menu-flyout\"]"));
		Assert.assertTrue(menuSection.isDisplayed());
		
		
	}
	
	
	@Test(dataProvider="getData")
	public void menuLinkValidationTest(String mainMenu,String subMenu,String pageTitle) throws InterruptedException {
			LandingPage lp=new LandingPage(driver);
			String parentwindow=getWindowHandle();
			getElementFormList(lp.getAllMenu(),mainMenu).click();
			lp.scrollToClose();
			WebElement inMenu = getElementFormList(lp.getAllSubMenu(),subMenu);
			System.out.println(inMenu.getText());
			action=new Actions(driver);
			action.moveToElement(inMenu).keyDown(Keys.CONTROL).click().build().perform();
			for(String s : getWindowHandles()) {
				switchWindow(s);
			}
			System.out.println(getPageTitle());	
			System.out.println("------------------------------------------------");	

			Assert.assertEquals(pageTitle, getPageTitle());
			close();
			switchWindow(parentwindow);
			getElementFormList(lp.getAllMenu(),mainMenu).click();
	}
	
	
	
	@Override
	@AfterMethod
	public void tear() {
		
	}
	
	@AfterClass
	public void teardown() {
		quit();
	}
	
}
