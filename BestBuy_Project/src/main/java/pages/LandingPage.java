package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpec;


public class LandingPage extends AbstractComponents {
	
	@FindBy(xpath="(//ol[@class='sku-item-list']//*[@class='column-left'])[1]")
	WebElement selectFirst;
	
	@FindBy(xpath="//div[contains(@class,'quick-assessment')]//div[contains(@class,'col-xs')]//*[text()='Add to Cart']")
	WebElement addToCartButton;
	
	@FindBy(xpath="//button[text()='Continue shopping']")
	WebElement continueShopingButton;

	@FindBy(xpath="//a[text()='Go to Cart']")
	WebElement goToCart;
	
	
	
	
	public LandingPage(WebDriver driver) {
		super(driver);
		
	}
	
	public LandingPage selectFirstItem() {
		elementClick(selectFirst);
		return this;
	}
	
	public LandingPage addToCart() {
		elementClick(addToCartButton);
		return this;
		
		
	}
	public LandingPage continueShoping() {
		elementClick(continueShopingButton);
		return this;
	}
	
	public CartPage goToCart() {
		elementClick(goToCart);
		return new CartPage(driver);
	}

}
