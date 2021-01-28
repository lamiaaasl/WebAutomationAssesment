package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

public class ProductViewPage extends PageBase {
	public Properties properties;
	public LoginPage LoginObj;
	
	public ProductViewPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
		 wait= new WebDriverWait(driver, 10);

	}	
	
//	By product 		= By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']");
//	By headerTxt 	= By.xpath("//span[@class='cat-name']");
//	By addtoCart 	= By.xpath("//*[contains(text(),'Add to cart')]");
	
	@FindBy(xpath="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']")
	WebElement product;
	
	@FindBy(xpath="//span[@class='cat-name']")
	public WebElement headerTxt;
	
	@FindBy(xpath="//*[contains(text(),'Add to cart')]")
	WebElement addtoCart;
	
	public void AddBlouseToCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']")));
		hoverToElement(product);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Add to cart')]")));
		clickOnLink(addtoCart);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='layer_cart_product col-xs-12 col-md-6']")));
	}
}
