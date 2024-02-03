package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpec;


public class LandingPage extends ProjectSpec {
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		header = new HeaderPage(driver);
		footer = new FooterPage(driver);
		
		
	}
	
	
	

}
