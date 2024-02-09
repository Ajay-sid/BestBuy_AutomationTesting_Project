package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends AbstractComponents{

	@FindBy(xpath="//ul[@class='item-list']/li/section/div[@class='fluid-item']//a")
	List<WebElement> cartItemsList;
	
	
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public List<String> getCartItemList() {
		List<String> list =cartItemsList.stream()
								.filter(m->!m.getText().equals(null)).map(m->m.getText())
									.collect(Collectors.toList());
		
		return list;
//		for(WebElement ele : element) {
//			if(!ele.getText().equals(null)) {
//				System.out.println(ele.getText());
//			}
//		}
	}
	
	
	
	
}
