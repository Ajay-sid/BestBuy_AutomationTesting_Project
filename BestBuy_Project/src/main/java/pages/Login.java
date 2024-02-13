package pages;

import java.util.List;

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
	
	@FindBy(xpath="//div[@class='tb-validation']")
	List<WebElement> fieldErrorTextLogin;
	
	@FindBy(xpath="//div[@class='c-alert-content rounded-r-100 flex-fill v-bg-pure-white p-200 pl-none']")
	WebElement topAlertMessage;
	
	
	public WebElement getTopAlertMessage() {
		return topAlertMessage;
	}


	public List<WebElement> getFieldErrorTextLogin() {
		return fieldErrorTextLogin;
	}
	
	


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
