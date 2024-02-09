package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.ProjectSpec;
import pages.LandingPage;

public class FooterLinkValidation extends ProjectSpec{
	
	//There are 54 Links in footer
	//So it takes time
	@Test
	public void footerLinkValidation() throws InterruptedException, IOException {
		
		LandingPage lp = new LandingPage(driver);
		String parentWindow = getWindowHandle();
		System.out.println(lp.getFooterLink().size());
		List<WebElement> linkS=lp.getFooterLink();
		int count=1;
		
		for(WebElement ele :linkS) {
			System.out.println("Link no "+(count));
			System.out.println(ele.getText());
			String link = ele.getAttribute("href");
			if(link==null||link.isEmpty()||ele.getText().equalsIgnoreCase("Best Buy Canada")) {
				continue;	
			}
			System.out.println(urlCheck(link));
			System.out.println("----------------------------------------------------");
			clickElementInNewWindow(ele);
			for(String s : getWindowHandles()) {
				switchWindow(s);
			}
			close();
			switchWindow(parentWindow);
			count++;
	
		Thread.sleep(500);
		 
		
		}
		
		String message = (count==linkS.size())?"Links are valid":"There are broken Links";
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
