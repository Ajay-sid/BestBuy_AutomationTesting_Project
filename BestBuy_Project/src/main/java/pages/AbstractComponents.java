package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


import base.ProjectSpec;

public class AbstractComponents extends ProjectSpec {
	
	@FindBy(id="gh-search-input")
	WebElement search;
	
	@FindBy(xpath="//button[@title='submit search']")
	WebElement searchButton;
	
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
	
	//TopMenu
	@FindBy(xpath="//ul[@class='bottom-nav-left lv']/li")
	List<WebElement> topMenu;
	
	
	//Menu 
	@FindBy(xpath="//button[text()='Menu']")
	WebElement MenuIcon;
	
	//MainMenu
	@FindBy(xpath="//button[@class='c-button-unstyled top-four v-fw-medium']")
	List<WebElement> MainMenu;
	
	//submenu in Main Menu
	@FindBy(xpath="//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/li/a[@class='hamburger-menu-flyout-list-item  ']")
	List<WebElement> SubMenu;
	
	
	
	//
	@FindBy(xpath="//button[text()='Close']")
	WebElement closeMenu;

	
	
	@FindBy(xpath="//footer[@id='footer']")
	WebElement footer;
	
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
    
	}
	public AbstractComponents MenuIconClick() {
		elementClick(MenuIcon);
		return this;
	}
	public WebElement getMainMenu(String str) {
		return getElementFormList(MainMenu, str); 
		
	}
	public WebElement getTopMenu(String str) {
		return getElementFormList(topMenu, str);
	}
//	public List<WebElement> getAllMenu() {
//		return MainMenu;
//		
//		
//	}
//	public List<WebElement> getAllSubMenu() {
//		
//		return SubMenu;
//	}
	
	public WebElement getSubMenu(String str) {
		
		return getElementFormList(SubMenu,str);
		
	}
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
	
	
	public List<WebElement> getFooterLink() {
		return footer.findElements(By.tagName("a"));
	}
	
	public LandingPage searchItem(String str) {
		sendKeys(search, str);
		elementClick(searchButton);
		return  new LandingPage(driver);
	}
	
	public CartPage goToCartTop() {
		elementClick(cart);
		return new CartPage(driver);
	}
	
	
}
