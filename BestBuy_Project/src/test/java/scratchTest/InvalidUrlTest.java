package scratchTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpec;

public class InvalidUrlTest extends ProjectSpec {
	
	
	
	@Parameters({"browser"})
	@Test(groups = {"invalidUrl"})
	public void testInvalidProtocol(String browser) {
		launch(browser, "www.bestbuy.com");
		System.out.println(getPageTitle());
		//Assert.assertNotEquals(getPageTitle(), "Best Buy | Official Online Store | Shop Now & Save");
		
		
		
		
	
	}
	
	@Test(groups = {"invalidUrl"})
	public void testValidProtocol() {
		
		
	}
	
	

}
