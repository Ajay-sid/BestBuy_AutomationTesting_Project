package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp extends AbstractComponents {

		
	 	@FindBy(id = "firstName")
	    private WebElement firstNameInput;

	    @FindBy(id = "lastName")
	    private WebElement lastNameInput;

	    @FindBy(id = "email")
	    private WebElement emailInput;

	    @FindBy(id = "fld-p1")
	    private WebElement passwordInput;

	    @FindBy(id = "reenterPassword")
	    private WebElement confirmPasswordInput;
	    
	    @FindBy(id = "phone")
	    private WebElement mobileNumberInput;
	    
	
	    @FindBy(xpath = "//button[text()='Create an Account']")
	    private WebElement createAccountButton;
	    
	    //constructor
	    public SignUp(WebDriver driver) {
	        super(driver);
	       
	    }

	   
	    public SignUp enterFirstName(String firstName) {
	        sendKeys(firstNameInput, firstName);
	        return this;
	    }

	    public SignUp enterLastName(String lastName) {
	        sendKeys(lastNameInput, lastName);
	        return this;
	    }

	    public SignUp enterEmail(String email) {
	       sendKeys(emailInput, email);
	       return this;
	    }

	    public SignUp enterPassword(String password) {
	        sendKeys(passwordInput, password);
	        return this;
	    }

	    public SignUp enterConfirmPassword(String confirmPassword) {
	        sendKeys(confirmPasswordInput, confirmPassword);
	        return this;
	    }
	    
	    public SignUp enterMobileNumber(String mobileNumber) {
	    	sendKeys(mobileNumberInput, mobileNumber);
	    	return this;
	    }
	    
	    
	    public SignUp clickCreateAccountButton() {
	        elementClick(createAccountButton);
	        return this;
	    }
	
	
	
	
	
	
	
}
