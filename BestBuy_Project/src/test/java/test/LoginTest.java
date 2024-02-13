package test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.ProjectSpec;
import pages.LandingPage;
import pages.Login;

public class LoginTest extends ProjectSpec{
	Map<String,String> errors;
	
	
	@BeforeClass
	public void setup() {
		 errors= new LinkedHashMap<String, String>();
		 errors.put("emailError", "Please enter a valid email address.");
		 errors.put("passError", "Please enter your password.");
		 errors.put("topAlert", "Sorry, something went wrong. Please try again.");
		 
			
	}
	
	
	@Test
	//Positive - verifying login page
	
	public void loginPageValidation() {
		String actualPageTitle = new LandingPage(driver).acount()
		.SignIn().getPageTitle();
	
		Assert.assertEquals(actualPageTitle, "Sign In to Best Buy");
		//Assert.assertTrue(false);
	}
	
	
	@Test()
	//Positive - Login Validation
	public void login() {
		new LandingPage(driver).acount()
			.SignIn().enterSignInEmail("testingpurpose6299@gmail.com")
			.enterSignInPassword("Nine+Nine=21")
			.clickSignInButton();
			//Assert.assertEquals(getPageTitle(),prop.getProperty("BestBuyTitle"));
	}
	
	@Test()
	//Negative - Login without email and password
	public void loginWithoutEmailandPassword() {
		Login lp =  new LandingPage(driver).acount().SignIn();
		lp.clickSignInButton();
		List<String> Actual = lp.getFieldErrorTextLogin().stream().map(m->m.getText()).collect(Collectors.toList());
		Assert.assertTrue(errors.values().containsAll(Actual));
	}
	
	@Test()
		//Negative - Login with correct email and Wrong password
		public void loginWithInvalidPassword() {
			Login lp =  new LandingPage(driver).acount().SignIn();
			String alertText= lp.enterSignInEmail("testingpurpose6299@gmail.com").enterSignInPassword("InvalidPassword")
			.clickSignInButton().getTopAlertMessage().getText();
			Assert.assertEquals(alertText, errors.get("topAlert"));
			//when logged in using chrome(userSignedIn) is gives "Oops! The email or password did not match our records. Please try again."
			//when used selenium it gives this alert "Sorry, something went wrong. Please try again."
		}
		
	
	
	
	
	
	

}
