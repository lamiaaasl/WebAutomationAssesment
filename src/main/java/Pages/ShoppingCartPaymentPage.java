package Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.PageBase;

public class ShoppingCartPaymentPage extends PageBase {
	
	public WebDriver  driver;
	public Properties properties;
	public LoginPage LoginObj;
	
	public ShoppingCartPaymentPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}	
	
//	By payByBankWire 	  = By.xpath("//*[@title='Pay by bank wire']");
//	By confirmOrderBtn 	  = By.xpath("//*[contains(text(),'I confirm my order')]");
//	By orderCompleteMsg   = By.xpath("//*[@class=\\\"box\\\"]//p//*[@class='dark']");
//	By backToOrdersBtn 	  = By.xpath("//*[@title='Back to orders']");
//	By completeOrderMsg   = By.xpath("//*[@class='cheque-indent']//*[@class='dark']");
//	By orderAmount 	      = By.xpath("//*[@id='center_column']/div/span/strong");
	
	@FindBy(xpath="//*[@title='Pay by bank wire']")
	WebElement payByBankWire;
	
	@FindBy(xpath="//*[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	@FindBy(xpath="//*[@class=\"box\"]//p//*[@class='dark']")
	WebElement orderCompleteMsg;
	
	@FindBy(xpath="//*[@title='Back to orders']")
	WebElement backToOrdersBtn;
	
	@FindBy(xpath="//*[@class='cheque-indent']//*[@class='dark']")
	public WebElement completeOrderMsg;
		
	@FindBy(xpath="//*[@id='center_column']/div/span/strong")
	WebElement orderAmount;
	
	public void ConfirmOrderPayment() {
		clickOnLink(payByBankWire);
		clickButton(confirmOrderBtn);
	}	
	
	public String GetOrderPrice() {		
		String OrderAmountinConfirmationPage = getElementText(orderAmount);
		return OrderAmountinConfirmationPage;
	}
	
	public void BackToOrdersPage() {
		clickOnLink(backToOrdersBtn);
	}
	
}
