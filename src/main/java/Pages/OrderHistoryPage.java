package Pages;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.PageBase;

public class OrderHistoryPage extends PageBase{
	public WebDriver  driver;
	public Properties properties;
	public LoginPage LoginObj;
	
	public OrderHistoryPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}	
	
//	By referenceNumber 		= By.xpath("//*[@id='center_column']/div//br[5]//following-sibling::text()[1]");
//	By refNumCloumn 		= By.xpath("//*[@class='first_item']//a[@class='color-myaccount']");
//	By historyAmount 		= By.xpath("//tr[1]//span[@class='price']");
//	By backToOrdersBtn 		= By.xpath("//*[@title='Back to orders']");
	
	@FindBy(xpath="//*[@id='center_column']/div//br[5]//following-sibling::text()[1]")
	WebElement referenceNumber;
	
	@FindBy(xpath="//*[@class='first_item']//a[@class='color-myaccount']")
	WebElement refNumCloumn;
	
	@FindBy(xpath="//tr[1]//span[@class='price']")
	WebElement historyAmount;
	
	@FindBy(xpath="//*[@title='Back to orders']")
	WebElement backToOrdersBtn;
	
//This to try to extract Reference Number from the statement But it is difficult to reach the element of the statement
	public String ExtractReferenceNumber(WebElement element) {
		String RefNumText = getElementText(referenceNumber);
		String RefNumPartOne = RefNumText.replace(("- Do not forget to insert your order reference "),"");
		String RefNumPartTwo = RefNumPartOne.replace(" in the subject of your bank wire.", "");
		System.out.println(RefNumPartTwo);
		return RefNumPartTwo;
	}

	public boolean CheckRefNumDisplayed() {
		boolean flage = false;
		String ColRefNum = getElementText(refNumCloumn);
		String RefNumber = ExtractReferenceNumber(referenceNumber);
		System.out.println(RefNumber);
		System.out.println(ColRefNum);
		Assert.assertTrue(ColRefNum.contains(RefNumber));
		return flage;
	}
	
//So i try to assert with the amount of the order instead
	public String GetOrderHistoryPrice() {	
		clickOnLink(backToOrdersBtn);
		String OrderAmountinOrderHistory = getElementText(historyAmount);
		System.out.println(OrderAmountinOrderHistory);
		return OrderAmountinOrderHistory;
	}
}
