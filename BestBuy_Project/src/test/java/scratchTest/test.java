package scratchTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpec;

public class test extends ProjectSpec {


	@BeforeTest()
	public void setup() {
		excelFile = "InvalidUrl";
	}
		

	@Override
	//@Parameters({"browser","url"})
	@BeforeMethod()
	public void launchBrowser(String browser,String url) {
		System.out.println("override");
		
	}
		
		@Test(dataProvider="getSingleArrayData")
		public void InvalidUrl(String url) throws IOException {
			launch("chrome", url);
			String msg = urlCheck(url);
			System.out.println(getPageTitle());
			Assert.assertNotEquals(getPageTitle(), prop.getProperty("BestBuyTitle"));;
			Assert.assertEquals(msg,"valid");
			
		}
		
		
		
		
	
	
	
	
}
