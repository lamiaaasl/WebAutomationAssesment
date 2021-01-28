package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	static int defaultElementIdentificationTimeout = 1; // Integer.parseInt(System.getProperty("defaultElementIdentificationTimeout").trim());
	static int attemptsBeforeThrowingElementNotFoundException = 1; // Integer.parseInt(System.getProperty("attemptsBeforeThrowingElementNotFoundException").trim());
	public WebDriver driver ; 
	public JavascriptExecutor jse ; 
	public Actions action ;
	public WebDriverWait wait;
	// methods
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	protected static void clickButton(WebElement button) {
		button.click();
		String text = button.getText();
		System.out.println("clicked on button successfully " +"[" +text + "]");
	}
	
	protected static void clickOnLink(WebElement link) {
		link.click();
	}
	
	protected static void setTextElementText(WebElement textElement , String value) {
		textElement.sendKeys(value);
		System.out.println("Value " +"[" +value + "]" +"typed successfully");
	}
	
	public void clearText(WebElement element) {
		element.clear();
	}
	
	public void hoverToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}	
	
	public String getElementText(WebElement element) {
		String TextGot = element.getText();
		return TextGot;
	}
	
	public void scrollToBottom() {
		jse.executeScript("scrollBy(0,2500)"); 
	}
}
