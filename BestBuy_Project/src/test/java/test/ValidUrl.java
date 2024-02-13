package test;

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
	
	
	
	@BeforeClass()
	public void setup() {
		excelFile = "UrlValidation";
		System.out.println("excel initiated");
	
	}
	
	@Parameters({"browser","url"})
	@Test
	//Testing BestBuy url for valid url Test
	public void validUrlTest(String browser,String url) throws IOException {
		launch(browser, url);
		String msg = urlCheck(url);
		System.out.println(getPageTitle());
		Assert.assertEquals(getPageTitle(),prop.getProperty("BestBuyTitle"));
		Assert.assertEquals(msg, "Link is valid");
		
	}
	
	@Parameters({"browser","url"})
	@Test
	//Testing other domain URL for Invalid Test
	public void OtherDomainValidUrl(String browser,String url) throws IOException {
		//String url = "https://www.google.com";
		launch(browser, url);
		String msg = urlCheck(url);
		System.out.println(getPageTitle());
		Assert.assertNotEquals(getPageTitle(),prop.getProperty("BestBuyTitle"));
		Assert.assertEquals(msg,"Link is valid");
		
	}
	
	@Test(dataProvider="getData")
	//Testing invalid URL format Like missing "https://" and invalid protocol like "fttps://"
	public void testInvalidUrl(String url,String error) throws InterruptedException, IOException {
		launch(prop.getProperty("browser"),url);
		String message = urlCheck(url);
		Assert.assertEquals(message,error);	
	}
	
	

}
