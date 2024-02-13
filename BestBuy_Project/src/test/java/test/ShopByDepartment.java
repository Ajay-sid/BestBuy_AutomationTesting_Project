package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.ProjectSpec;
import pages.LandingPage;

public class ShopByDepartment extends ProjectSpec {

	
	@Test
	public void ShopByDepartmentTitlevalidation() {
		LandingPage lp = new LandingPage(driver);
		lp.MenuIconClick().scrollToClose().getShopByDepartmentMenu("Audio").click();
		String menuTitle=driver.findElement(By.xpath("//h2[@class='hamburger-menu-title']")).getText();
		Assert.assertEquals(menuTitle,"Audio" );
		
	}
	
	
	//@Test
	public void shopByDepartmentTest() {
		LandingPage lp = new LandingPage(driver);
		WebElement elem=lp.MenuIconClick().scrollToClose()
							.getShopByDepartmentMenu("Audio");
		elem.click();
		lp.scrollToClose().getSBDsubMenu("Headphones").click();
		lp.scrollToClose().getSBDAllsubMenu("AirPods").click();
		lp.selectFirstItem().addToCart().goToCart();
		
	}
	
	@Override
	@AfterMethod()
	public void tear(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE) {
			captureScreenshot(result.getMethod().getMethodName()+".jpg");
		}
	}
	
	
	
	
}
