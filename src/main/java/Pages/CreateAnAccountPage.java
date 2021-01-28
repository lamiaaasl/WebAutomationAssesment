package Pages;

import java.util.Properties;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.PageBase;

public class CreateAnAccountPage extends PageBase{
	
    public Properties properties;
	
	public CreateAnAccountPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;
		}
	
//		By signIn_btn 			= By.xpath("//*[contains(text(),'Sign in')]");
//		By createAccount_Btn 	= By.id("SubmitCreate");
//		By email_Txt 			= By.id("email_create");
//		By mrsCheckbox 		= By.id("id_gender2");
//		By firstName_Txt 		= By.id("customer_firstname");
//		By lastName_Txt			= By.id("customer_lastname");
//		By pass_Txt				= By.id("passwd");
//		By address_Txt 			= By.id("address1");
//		By city_Txt				= By.id("city");		
//		By state 				= By.xpath("//*[@id='id_state']/option[@value ='1']");
//		By postalCode_Txt 		= By.id("postcode");
//		By mobilePhone_Txt 		= By.id("phone_mobile");
//		By registerBtn 			= By.id("submitAccount");
//		By successMessage 		= By.xpath("//*[@class='info-account']");
		
		@FindBy(xpath="//*[contains(text(),'Sign in')]")
		WebElement signIn_btn;
		
		@FindBy(id="SubmitCreate")
		WebElement createAccount_Btn;
				
		@FindBy(id="email_create")
		WebElement email_Txt;
		
		@FindBy(id="id_gender2")
		WebElement mrsCheckbox;
		
		@FindBy(id="customer_firstname")
		WebElement firstName_Txt;
		
		@FindBy(id="customer_lastname")
		WebElement lastName_Txt;
		
		@FindBy(id="passwd")
		WebElement pass_Txt;
		
		@FindBy(id="address1")
		WebElement address_Txt;
		
		@FindBy(id="city")
		WebElement city_Txt;
		
		@FindBy(xpath="//*[@id='id_state']/option[@value ='1']")
		WebElement state;
				
		@FindBy(id="postcode")
		WebElement postalCode_Txt;
		
		@FindBy(id="phone_mobile")
		WebElement mobilePhone_Txt;
		
		@FindBy(id="submitAccount")
		WebElement registerBtn;
		
		@FindBy(xpath="//*[@class='info-account']")
		public WebElement successMessage ;
					
		public void CreateNewUser(String strEmail, String strFirstName, String strLastName, String strPass, String strAddress, String strCity, String strPostalCode, String strMobilePhone) 
		{
			clickButton(signIn_btn);
			setTextElementText(email_Txt, strEmail);
			clickButton(createAccount_Btn);
			clickButton(mrsCheckbox);
			setTextElementText(firstName_Txt, strFirstName);
			setTextElementText(lastName_Txt, strLastName);
			setTextElementText(pass_Txt, strPass);
			setTextElementText(address_Txt, strAddress);
			setTextElementText(city_Txt, strCity);
			clickButton(state);
			setTextElementText(postalCode_Txt, strPostalCode);
			setTextElementText(mobilePhone_Txt, strMobilePhone);
			clickButton(registerBtn);
		}
				
}
