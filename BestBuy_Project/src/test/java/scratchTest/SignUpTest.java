package scratchTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpec;

import pages.SignUp;

public class SignUpTest extends ProjectSpec{

@BeforeClass
public void setUp() {
	excelFile = "SignUpData";
}
	
	
	
	
@Test(dataProvider="getData")
public void SignUpFunctionality(String fname,String lname,String email,
		String pass,String conformPass,String mobileNum,String message) 
{
	new SignUp(driver).
	acount().
	creatAccount().
	enterFirstName(fname).
	enterLastName(lname).
	enterEmail(email).
	enterPassword(pass).
	enterConfirmPassword(conformPass).
	enterMobileNumber(mobileNum).clickCreateAccountButton();
	WebElement mess =driver.findElement(By.xpath("(//strong)[2]"));
	System.out.println(mess.getText());
	Assert.assertNotEquals(getPageTitle(),message);
	
	
}
	
	
	
	
	
	
	
}
