package scratchTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import base.ProjectSpec;


public class ValidUrl extends ProjectSpec {
	
	
	@Override
	@Parameters({"browser","url"})
	@BeforeMethod()
	public void launchBrowser(String browser,String url) {
		System.out.println("override");
		
	}
	
	
	
	@BeforeTest()
	public void setup() {
		excelFile = "InvalidUrl";
	}
	
	@Parameters({"browser","url"})
	@Test
	public void validUrl(String browser,String url) throws IOException {
		launch(browser, url);
		String msg = urlCheck(url);
		System.out.println(getPageTitle());
		Assert.assertEquals(getPageTitle(),prop.getProperty("BestBuyTitle"));
		Assert.assertEquals(msg,"valid");
	}
	
	
	@Test(dataProvider="getSingleArrayData")
	public void InvalidUrl(String url) throws IOException {
		launch("chrome", url);
		String msg = urlCheck(url);
		System.out.println(getPageTitle());
		Assert.assertNotEquals(getPageTitle(),prop.getProperty("BestBuyTitle"));
		Assert.assertEquals(msg,"valid");
		
	}
	
	
	
	

}
