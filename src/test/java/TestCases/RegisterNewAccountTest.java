package TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Base.TestBase;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import TestData.ExcelReader;

public class RegisterNewAccountTest extends TestBase {
	
	CreateAnAccountPage CreateAccountObj;
	ExcelReader ExcelReaderObj;
	LoginPage loginObject ;
	HomePage homeObject ; 
	
	Faker fakedata = new Faker();
	String email = fakedata.internet().emailAddress();
	String firstName = fakedata.name().firstName();
	String lastName = fakedata.name().lastName();
	
	public static String emailUsed ;
	public static String passwordUsed ;

	@BeforeMethod
	public void BeforeMethod() {
		homeObject = new HomePage(driver, properties); 
		loginObject = new LoginPage(driver, properties); 
		CreateAccountObj = new CreateAnAccountPage(driver, properties); 
	}
	
	@DataProvider(name = "RegisterNewUser")
    public Object[][] CreateAccountData() throws InvalidFormatException, IOException {
          Object[][] data = ExcelReader.fetchData(properties.getProperty("TestDataSheetPath"), "RegisterNewUser");
          System.out.println(data);
          return data;
    }

	  @Test(priority=1,alwaysRun=true,dataProvider="RegisterNewUser")
		public void UserCanRegisterSuccssfully(String strEmail, String strFirstName, String strLastName, String strPassword, String strAddress, String strCity, String strPostalCode, String strMobilePhone) {
			homeObject.openLoginPage();
			
			System.out.println("used email " + email);
			System.out.println("used first name " + firstName);
			System.out.println("used last name " + lastName);
			
			CreateAccountObj.CreateNewUser(email, firstName, lastName, strPassword, strAddress, strCity, strPostalCode, strMobilePhone);
			
			emailUsed = email;
			passwordUsed = strPassword ;
		
			Assert.assertTrue(CreateAccountObj.successMessage.getText().contains("Welcome to your account"));
			homeObject.userLogout();
			homeObject.openLoginPage();
			loginObject.UserLogin(strEmail, strPassword);
			
			emailUsed = email;
			
			Assert.assertTrue(homeObject.logoutLink.getText().contains("Sign out"));
			homeObject.userLogout();
		}
	}
