package scratchTest;

import java.io.IOException;
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
	@Test(groups = {"invalidUrl"},priority=1)
	public void testMissingProtocol(String browser) throws InterruptedException, IOException {
//	testig with malformed url	
		String link =prop.getProperty("missingProtocoll");
		launch(browser,link);
		String message = urlCheck(link);
		Assert.assertEquals(message, "no protocol: www.bestbuy.com");	
		
	}
	
	
	@Parameters({"browser"})
	@Test(groups = {"invalidUrl"},priority=2)
	public void testInvalidProtocol(String browser) throws IOException {
		launch(browser, prop.getProperty("invalidProtocoll"));
		String message = urlCheck(prop.getProperty("invalidProtocoll"));
		Assert.assertEquals(message, "unknown protocol: fttps");	
		
		
	}

	@Parameters({"browser"})
	@Test(groups = {"invalidUrl"},priority=3)
	public void testOtherValidDomain(String browser) throws InterruptedException {
		launch(browser,prop.getProperty("otherDomain"));
		Thread.sleep(5000);
		System.out.println(getPageTitle());
		
		Assert.assertNotEquals(getPageTitle(), "Best Buy | Official Online Store | Shop Now & Save");
			
		
	}

}
