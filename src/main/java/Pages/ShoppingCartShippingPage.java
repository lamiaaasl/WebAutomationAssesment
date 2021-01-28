package Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.PageBase;

public class ShoppingCartShippingPage extends PageBase{

	public WebDriver  driver;
	public Properties properties;
	public LoginPage LoginObj;
	
	public ShoppingCartShippingPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}	
	
//	By agreeTerms 	  = By.xpath("//div[@id='uniform-cgv']");
//	By finalProceedBtn 	  = By.xpath("//button[@name='processCarrier']");
	
	@FindBy(xpath="//div[@id='uniform-cgv']")
	WebElement agreeTerms;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement finalProceedBtn;
	
	public void FinalProceedToCheckout() {
		clickOnLink(agreeTerms);
		clickButton(finalProceedBtn);
	}	
}
