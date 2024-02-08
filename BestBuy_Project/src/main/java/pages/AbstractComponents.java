package pages;

import java.util.List;

import org.openqa.selenium.By;
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
	
	//Menu 
	@FindBy(xpath="//button[text()='Menu']")
	WebElement MenuIcon;
	
	//MainMenu
	@FindBy(xpath="//button[@class='c-button-unstyled top-four v-fw-medium']")
	List<WebElement> MainMenu;
	
	@FindBy(xpath="//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/li/a[@class='hamburger-menu-flyout-list-item  ']")
	List<WebElement> SubMenu;
	
	
	
	//
	@FindBy(xpath="//button[text()='Close']")
	WebElement closeMenu;
	
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
    
	}
	public void MenuIconClick() {
		elementClick(MenuIcon);
	}
	public WebElement MainMenu(String str) {
		return getElementFormList(MainMenu, str); 
	}
	public List<WebElement> getAllMenu() {
		return MainMenu;
		
		
	}
	public List<WebElement> getAllSubMenu() {
		
		return SubMenu;
	}
	
//	public WebElement allMainMenu(String str) {
//		
//		return getElementFormList(allMainMenu,str);
//		
//	}
	public void scrollToClose() {
		scrollElement(closeMenu);

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
