package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpec;
import pages.LandingPage;
import pages.SignUp;

public class SignUpTest extends ProjectSpec {
	Map<String,String> errors;
	
	
	
	
	@BeforeClass
	public void setUp() {
		System.out.println("class");
		errors=new LinkedHashMap<String, String>();
		errors.put("fnameError", "Please enter your first name.");
		errors.put("lnameError", "Please enter your last name.");
		errors.put("emailError", "Please enter a valid email address.");
		errors.put("passError", "Please enter a strong password.");
		errors.put("confPassError","Please reenter your password.");
		errors.put("mobileError","Please enter a valid mobile phone number.");
	}

@Test()
// Positive - Testing SignUp Functionality 
	public void SignUpFunctionalityTest() {
		new LandingPage(driver).acount().creatAccount().enterFirstName("Ajay").enterLastName("Sid")
				.enterEmail("testingpurpose6299@gmail.com").enterPassword("Nine+Nine=18")
				.enterConfirmPassword("Nine+Nine=18").enterMobileNumber("2323432322").clickCreateAccountButton();
		//******Change the email and enable the below lines for validation******
		// WebElement mess =driver.findElement(By.xpath("(//strong)[2]"));
		// System.out.println(mess.getText());
		// Assert.assertNotEquals(getPageTitle(),message);

	}

@Test()
//Negative - InvalidTest with no fields populated
	public void InvalidSignUpFunctionality() {

		List<String> actual = new LandingPage(driver).acount().creatAccount().clickCreateAccountButton()
				.getFieldErrorText().stream().map(m -> m.getText()).collect(Collectors.toList());
		System.out.println(actual);
		List<String> expected = new ArrayList<String>(errors.values());
		Assert.assertTrue(actual.equals(expected));

	}

@Test
// Negative - Entering password lesser than requried Length
	public void InvalidPassword() {
		String expected = errors.get("passError");
		SignUp sp = new LandingPage(driver).acount().creatAccount();
		sp.enterPassword("less");
		sp.tabOutofTextField(sp.getPasswordInput());

		String passwordError = sp.getFieldErrorText().stream().filter(m -> m.getAttribute("id").equals("fld-p1-text"))
				.map(m -> m.getText()).findAny().get();
		System.out.println(passwordError);
		Assert.assertEquals(passwordError, expected);

	}

@Test
// Negative - Testing password not equal to conformpassword
	public void passwordNotEqualsConformpassword() {
		String expected = "Passwords do not match.";
		SignUp sp = new LandingPage(driver).acount().creatAccount();
		sp.enterPassword("Hello@321n").enterConfirmPassword("hello@321n").getConfirmPasswordInput().sendKeys(Keys.TAB);

		String ConfPassError = sp.getFieldErrorText().stream()
				.filter(m -> m.getAttribute("id").equals("reenterPassword-text")).map(m -> m.getText()).findAny().get();
		System.out.println(ConfPassError);
		Assert.assertEquals(ConfPassError, expected);

	}

@Test
// Positive - Testing password equal to conformpassword
	public void passwordEqualsConformpassword() {
		String expected = "Your passwords match!";
		SignUp sp = new LandingPage(driver).acount().creatAccount();
		sp.enterPassword("Dominator@343").enterConfirmPassword("Dominator@343").getConfirmPasswordInput()
				.sendKeys(Keys.TAB);
		String ConformPassMessage = driver
				.findElement(By.xpath("//span[@class='c-input-error-message cdi-input-success-message']")).getText();
		System.out.println(ConformPassMessage);
		Assert.assertEquals(ConformPassMessage, expected);

	}

@Test
//Negative - Testing mobilenumber with less length
	public void InvalidMobileNumber() {
		String expected = "Please enter a valid mobile phone number.";
		SignUp sp = new LandingPage(driver).acount().creatAccount();
		sp.enterMobileNumber("2342345");
		sp.tabOutofTextField(sp.getMobileNumberInput());

		String mobileError = sp.getFieldErrorText().stream().filter(m -> m.getAttribute("id").equals("phone-text"))
				.map(m -> m.getText()).findAny().get();

		Assert.assertEquals(mobileError, expected);

	}

	
}
