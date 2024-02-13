package test;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
	Map<String,String> topMenuTitles;
	
	@BeforeClass
	public void setUp() {
		excelFile="MenuLinkValidation";
		topMenuTitles=new LinkedHashMap<String, String>();
		topMenuTitles.put("Top Deals", "Top Deals and Featured Offers on Electronics");
		topMenuTitles.put("Deal of the Day", "Deal of the Day: Electronics Deals");
		topMenuTitles.put("Yes, Best Buy Sells That", "Yes, Best Buy Sells That");
		topMenuTitles.put("My Best Buy Memberships","My Best Buy Memberships");
		topMenuTitles.put("Credit Cards", "Best Buy Credit Card: Rewards & Financing");
		topMenuTitles.put("Gift Cards", "Gifts Cards and E-Gift Cards - Best Buy");
		topMenuTitles.put("Gift Ideas", "Gift Ideas 2024: Best Gifts to Give This Year");
	}
	
	
	
	
	@Test()
	//Positive - Verifying menu is Displayed when clicked.
	public void menuButtonTest() {
		LandingPage lp=new LandingPage(driver);
		lp.MenuIconClick();
		WebElement menuSection = driver.findElement(By.xpath("//div[@class='hamburger-menu-flyout']"));
		Assert.assertTrue(menuSection.isDisplayed());
		
	}
	
	@Test
	//Positive - Verifying functionality of the Top Menu
	public void TopMenuFunctionality() {
		LandingPage lp = new LandingPage(driver);
		String parentWindow=getWindowHandle();
		String elementText;
		List<WebElement> MenuTop=lp.getTopMenu();
		for(WebElement element :MenuTop) {
			elementText = element.getText();
			clickElementInNewWindow(element);
			for(String s : getWindowHandles()) {
				switchWindow(s);
			}
			System.out.println(getPageTitle());
			Assert.assertTrue(getPageTitle().contains(topMenuTitles.get(elementText)));
			close();
			switchWindow(parentWindow);
	
		}
	}
	
	
	@Test()
	//Verifing hamburger Menu function
	public void menuItemsTest() {
		LandingPage lp=new LandingPage(driver);
		clickElementInNewWindow(lp.getTopMenu("Gift Cards"));
		for(String s : getWindowHandles()) {
			switchWindow(s);
		}
		System.out.println(getPageTitle());
		Assert.assertTrue(getPageTitle().equalsIgnoreCase("Gifts Cards and E-Gift Cards - Best Buy"));
		
		
	}

	@Test()
	//Don't know why i put this
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
	
	
	

	
	@AfterClass
	public void teardown() {
		
	}
	
}
