package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpec;

public class AbstractComponents extends ProjectSpec {

	
	//return to previous page link
	@FindBy(xpath="//a[text()='Return to previous page']")	
	private WebElement returnToPrevPage;
	
	//Cart Menu
	@FindBy(xpath="//span[text()='Cart']")
	WebElement cart;
	
	//Account Menu
	@FindBy(id="account-menu-account-button")
	WebElement account;
	
	//Create account button inside Account Menu
	@FindBy(xpath="//a[text()='Create Account']")
	WebElement creatAccount;
	
	//SignIn AKA Login button inside Account Menu
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement SignIn;
	
	
	
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
			
	}
	
	public LandingPage returnToPrevPage() {
    	elementClick(returnToPrevPage);
    	return new LandingPage(driver);
    }
	
	public AbstractComponents acount() {
		elementClick(account);
		return this;
	}
	
	public SignUp creatAccount() {
		elementClick(creatAccount);
		return new SignUp(driver);
	}
	
	public Login SignIn() {
		elementClick(SignIn);
		return new Login(driver);
	}
	
	
	
	
	
	
	
	
	
}
