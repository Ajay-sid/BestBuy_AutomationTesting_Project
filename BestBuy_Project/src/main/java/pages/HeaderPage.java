package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpec;

public class HeaderPage {
		
	
	@FindBy(xpath="//a[@title='BestBuy.com']")
	WebElement bestBuyLogo;
	
		
		
	public HeaderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	

}
