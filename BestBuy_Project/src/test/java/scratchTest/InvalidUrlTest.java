package scratchTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpec;

public class InvalidUrlTest extends ProjectSpec {
	
	@Override
	@Parameters({"browser","url"})
	@BeforeMethod()
	public void launchBrowser(String browser,String url) {
		
		
	}
	@BeforeClass
	public void setup() {
		System.out.println("excel");
		excelFile = "InvalidUrl";
	}
	
	
	
	
	@Test(dataProvider="getData")
	//Testing invalid URL format
	public void testInvalidUrl(String url,String error) throws InterruptedException, IOException {
		launch(prop.getProperty("browser"),url);
		String message = urlCheck(url);
		Assert.assertEquals(message,error);	
		
	}
	

}