package TestCases;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import TestData.ExcelReader;


public class LoginTest extends TestBase{
	CreateAnAccountPage CreateAccountObj;
	ExcelReader ExcelReaderObj;
	LoginPage loginObject ;
	HomePage homeObject ; 
	
	@DataProvider(name = "LoginByRegisteredUser")
    public Object[][] testLogin() throws InvalidFormatException, IOException {
          Object[][] data = ExcelReader.fetchData(properties.getProperty("TestDataSheetPath"), "LoginByRegisteredUser");
          return data;
    }
	
	 @Test(priority=1,alwaysRun=true,dataProvider="LoginByRegisteredUser")
		public void UserCanRegisterSuccssfully(String strEmail, String strPassword, String strFirstName, String strLastName) {
		homeObject = new HomePage(driver, properties); 
		loginObject = new LoginPage(driver, properties); 

		homeObject.openLoginPage();
		loginObject.UserLogin(strEmail, strPassword);
		
		//loginObject.UserLogin(RegisterNewAccountTest.emailUsed, RegisterNewAccountTest.passwordUsed);

		Assert.assertTrue(homeObject.userName.getText().contains(strFirstName + " " + strLastName));
		System.out.println("User Logged Successfully");
	 }

}
