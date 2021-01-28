package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

public class HomePage extends PageBase
{
	public Properties properties;

	public HomePage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
	}
//	
//	By signIn_btn 		= By.xpath("//*[contains(text(),'Sign in')]");
//	By contactUsLink 	= By.linkText("Contact us");
//	By cartLink 		= By.id("Cart");
//	By userName 		= By.xpath("//*[@title='View my customer account']");
//	By logoutLink 		= By.xpath("//*[@title='Log me out']");
//	By searchElement 	= By.id("search_query_top");
//	By searchBtn 		= By.xpath("//*[@name='submit_search']");
//	By womenMenu 		= By.xpath("//*[@id=\\\"block_top_menu\\\"]/ul/li/a[contains(text(),'Women')]");
//	By blousesCateg 	= By.linkText("Blouses");
	
	@FindBy(xpath="//*[contains(text(),'Sign in')]")
	WebElement signIn_btn; 
	
	@FindBy(linkText="Contact us")
	WebElement contactUsLink ; 
	
	@FindBy(linkText="Cart")
	WebElement cartLink ; 

	@FindBy(xpath="//*[@title='View my customer account']")
	public WebElement userName;
	
	@FindBy(xpath="//*[@title='Log me out']")
	public WebElement logoutLink;
		
	@FindBy(id="search_query_top")
	public WebElement searchElement;
	
	@FindBy(xpath="//*[@name='submit_search']")
	public WebElement searchBtn;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li/a[contains(text(),'Women')]")
	public WebElement womenMenu; 
	
	@FindBy(linkText="Blouses")
	WebElement blousesCateg; 
	
	public void openLoginPage() {
		clickButton(signIn_btn);
	}
	
	public void SelectCategorySubcategory(String strCategory, String strSubCategory) {
		WebElement Category = driver.findElement(By.xpath("//li//a[@title='"+strCategory+"']"));
		hoverToElement(Category);
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='"+strSubCategory+"']")));
		WebElement SubCategory = driver.findElement(By.xpath("//a[@title='"+strSubCategory+"']"));
		clickOnLink(SubCategory);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='cat-name']")));
	}
		
	public void Search(String strSubCategory) {
		searchElement.sendKeys(strSubCategory);
		clickButton(searchBtn);
	}
	
	public void openContactUsPage() {
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	public void userLogout() {
		clickButton(logoutLink);
	}	

}
