package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.ProjectSpec;
import junit.framework.Assert;
import pages.LandingPage;

public class LoginTest extends ProjectSpec{
	
	
	
	
	@Test()
	public void login() {
		new LandingPage(driver).acount()
			.SignIn().enterSignInEmail("testingpurpose6299@gmail.com")
			.enterSignInPassword("Nine+Nine=21")
			.clickSignInButton().skipMobileVerification();
			Assert.assertEquals(getPageTitle(),prop.getProperty("BestBuyTitle"));
	}
	
	@Override
	@AfterMethod()
	public void tear() {
		
	}
	
	

}
