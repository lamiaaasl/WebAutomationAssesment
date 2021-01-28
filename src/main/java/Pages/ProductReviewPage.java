package Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.PageBase;

public class ProductReviewPage extends PageBase{

	public WebDriver  driver;
	public Properties properties;
	public LoginPage LoginObj;
	
	public ProductReviewPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}	
	
//	By proceedBtn 		= By.xpath("//*[contains(text(),'Proceed to checkout')]");
//	By addingSuccessMSG = By.xpath("//*[@class='layer_cart_product col-xs-12 col-md-6']//h2");
	
	@FindBy(xpath="//*[contains(text(),'Proceed to checkout')]")
	WebElement proceedBtn;
	
	@FindBy(xpath="//*[@class='layer_cart_product col-xs-12 col-md-6']//h2")
	public WebElement addingSuccessMSG;
	
	public void ProceedToCheckOut() {
		clickOnLink(proceedBtn);			
	}	
}
