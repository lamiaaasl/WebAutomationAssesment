package Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.PageBase;

public class ShoppingCartSummeryPage extends PageBase{

	public WebDriver  driver;
	public Properties properties;
	public LoginPage LoginObj;
	
	public ShoppingCartSummeryPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}	
	
//	By firstProceedToCheckoutBtn 	  = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");
//	By summeryPageTitle 			  = By.id("cart_title");
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement firstProceedToCheckoutBtn;
	
	@FindBy(id="cart_title")
	public WebElement summeryPageTitle;
	
	public void FirstProceedToCheckout() {
		clickButton(firstProceedToCheckoutBtn);			
	}	
}
