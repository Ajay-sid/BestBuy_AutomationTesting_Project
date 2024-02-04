package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login extends AbstractComponents {
		
	@FindBy(id="fld-e")
	WebElement SignInEmail;
	
	@FindBy(id="fld-p1")
	WebElement SignInPassword;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement SignInbutton;
	
	@FindBy(xpath="//button[text()='Skip for now']")
	WebElement SkipMobileVerification;
	
	public Login(WebDriver driver) {
		super(driver);
	}
	
	
	public Login enterSignInEmail(String email) {
		sendKeys(SignInEmail, email);
		return this;
	}
	
	public Login enterSignInPassword(String password) {
		sendKeys(SignInPassword, password);
		return this;	
	}
	
	public Login clickSignInButton() {
		elementClick(SignInbutton);
		return this;
	}
	
	public LandingPage skipMobileVerification() {
		elementClick(SkipMobileVerification);
		return new LandingPage(driver);
	}
	
	
	
}
