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
	
	
	
	@BeforeClass()
	public void setup() {
		System.out.println("excel");
		excelFile = "validUrl";
	}
	
	@Parameters({"browser","url"})
	@Test
	//Testing BestBuy url
	public void validUrl(String browser,String url) throws IOException {
		launch(browser, url);
		String msg = urlCheck(url);
		System.out.println(getPageTitle());
		Assert.assertEquals(getPageTitle(),prop.getProperty("BestBuyTitle"));
		Assert.assertEquals(msg,"valid");
	}
	
	
	@Test(dataProvider="getData")
	//Testing other domain URL 
	public void OtherDomainValidUrl(String url,String title) throws IOException {
		launch(prop.getProperty("browser"), url);
		String msg = urlCheck(url);
		System.out.println(getPageTitle());
		Assert.assertNotEquals(getPageTitle(),title);
		Assert.assertEquals(msg,"valid");
		
	}
	

	
	

}
