package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpec;
import pages.LandingPage;

public class MenuValidation extends ProjectSpec{
	
	
	@BeforeClass
	public void setUp() {
		excelFile="MenuLinkValidation";
		
		
	}
	
	
	
	
	@Test(priority=0)
	public void menuButtonTest() {
		LandingPage lp=new LandingPage(driver);
		lp.MenuIconClick();
		WebElement menuSection = driver.findElement(By.xpath("//div[@class=\"hamburger-menu-flyout\"]"));
		Assert.assertTrue(menuSection.isDisplayed());
		
	}
	
	@Test(priority=1)
	public void menuItemsTest() {
		LandingPage lp=new LandingPage(driver);
		clickElementInNewWindow(lp.getTopMenu("Gift Cards"));
		for(String s : getWindowHandles()) {
			switchWindow(s);
		}
		System.out.println(getPageTitle());
		Assert.assertTrue(getPageTitle().equalsIgnoreCase("Gifts Cards and E-Gift Cards - Best Buy"));
		
		
	}

	@Test(priority=2)
	public void InvalidmenuItemsTest() {
		LandingPage lp=new LandingPage(driver);
		clickElementInNewWindow(lp.getTopMenu("Top Deals"));
		for(String s : getWindowHandles()) {
			switchWindow(s);
		}
		System.out.println(getPageTitle());
		Assert.assertFalse(getPageTitle().equalsIgnoreCase("Gifts Cards and E-Gift Cards - Best Buy"));

	}
	
	
	
	//To test all sub link	
	@Test(priority=3,dataProvider="getData")
	public void menuLinkValidationTest(String mainMenu,String subMenu,String pageTitle) throws InterruptedException {
			LandingPage lp=new LandingPage(driver);
			lp.MenuIconClick();
			lp.getMainMenu(mainMenu).click();
			lp.scrollToClose();
			WebElement inMenu = lp.getSubMenu(subMenu);
			System.out.println(inMenu.getText());
			action=new Actions(driver);
			action.moveToElement(inMenu).keyDown(Keys.CONTROL).click().build().perform();
			for(String s : getWindowHandles()) {
				switchWindow(s);
			}
			System.out.println(getPageTitle());	
			System.out.println("------------------------------------------------");	

			Assert.assertEquals(pageTitle, getPageTitle());
	}
	
	
	
	@Override
	@AfterMethod
	public void tear() {
		quit();
		System.out.println("After Method");
	}
	
	@AfterClass
	public void teardown() {
		
	}
	
}
