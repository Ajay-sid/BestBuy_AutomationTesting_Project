package scratchTest;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.ProjectSpec;
import pages.CartPage;
import pages.LandingPage;

public class E2EsearcAndAddItemToCart extends ProjectSpec {


	
	
@Test()
//Searchig an Item
public void searchItemTest() {
	LandingPage lp =new LandingPage(driver);
	String product="Nikon d850";
	lp.searchItem(product);
	//results of searching
	List<WebElement> ele =driver.findElements(By.xpath("//div[@class='title-wrapper title']/descendant::span"));
	String msg = ele.stream()
	.filter(m->!m.getText().equals(null))
		.map(m->m.getText()).collect(Collectors.joining(" "));
	System.out.println(msg);
	Assert.assertTrue(Pattern.matches("(?i).*Nikon.*d850.*", msg));
	
	//Assert.assertTrue(msg.contains(product.toLowerCase()));
}

@Test
public void searchNonExistingItem() {
	LandingPage lp =new LandingPage(driver);
	String product="lkfshjalkdjfhfa";
	lp.searchItem(product);
	String s = driver.findElement(By.xpath("//h3[@class='no-results-message']")).getText();
	Assert.assertEquals("Hmmm, we didn't find anything for \""+product+"\"",s);
	
	
}
	

@Test()
//Searchin and adding item to cart
public void searchAndAddItemToCartTest() {
	String product="lenovo legion";
	List<String> cartItems = new LandingPage(driver).searchItem(product)
			.selectFirstItem().addToCart().goToCart().getCartItemList();
	System.out.println(cartItems.get(0));
	Assert.assertTrue(Pattern.matches("(?i).*lenovo.*legion.*", cartItems.get(0)));
		
	
}
	
	
	
@Override	
@AfterMethod()
public void tear(){
close();
}	
	
	
	
}
