package Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.PageBase;

public class ShoppingCartAddressPage extends PageBase{

	public WebDriver  driver;
	public Properties properties;
	public LoginPage LoginObj;
	
	public ShoppingCartAddressPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}	
	
//	By preFinalProceedBtn 	= By.xpath("//button[@name='processAddress']");
	
	@FindBy(xpath="//button[@name='processAddress']")
	WebElement preFinalProceedBtn;
	
	public void PreFinalProceedToCheckout() {
		clickButton(preFinalProceedBtn);			
	}	
}
