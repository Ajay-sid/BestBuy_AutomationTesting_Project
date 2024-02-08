package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpec;
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

	
	
	@Test(dataProvider = "getData")
	public void menuLinkValidationTest(String mainMenu,String subMenu,String title) throws InterruptedException {
			LandingPage lp=new LandingPage(driver);
			lp.MenuIconClick();
			action = new Actions(driver);
			String parentwindow=getWindowHandle();

			getElementFormList(lp.getAllMenu(),mainMenu).click();
			WebElement inMenu = getElementFormList(lp.getAllSubMenu(),subMenu);
			System.out.println(inMenu.getText());
			action.moveToElement(inMenu).keyDown(Keys.CONTROL).click().build().perform();
			
			for(String s : getWindowHandles()) {
				switchWindow(s);
			}
			System.out.println(getPageTitle());	
			System.out.println("------------------------------------------------");	
			close();
			switchWindow(parentwindow);
			lp.MenuIconClick();
	}
	
	
	
	@Override
	@AfterMethod
	public void tear() {
		
	}
	
}
