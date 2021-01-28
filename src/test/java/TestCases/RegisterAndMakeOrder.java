package TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CreateAnAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderHistoryPage;
import Pages.ProductReviewPage;
import Pages.ProductViewPage;
import Pages.ShoppingCartAddressPage;
import Pages.ShoppingCartPaymentPage;
import Pages.ShoppingCartShippingPage;
import Pages.ShoppingCartSummeryPage;
import TestData.ExcelReader;

public class RegisterAndMakeOrder extends TestBase{
	CreateAnAccountPage CreateAccountObj;
	ExcelReader ExcelReaderObj;
	LoginPage loginObject ;
	HomePage homeObject ; 
	ProductViewPage prodViewPageObj;
	ProductReviewPage prodReviewPageObj;
	ShoppingCartSummeryPage shopCartSummeryPageObj;
	ShoppingCartAddressPage ShoppingCartAddressPageObj;
	ShoppingCartShippingPage ShoppingCartShippingPageObj;
	ShoppingCartPaymentPage ShoppingCartPaymentPageObj;
	OrderHistoryPage OrderHistoryPageObj;
	
	@BeforeMethod
	public void BeforeMethod() {
		homeObject = new HomePage(driver, properties); 
		loginObject = new LoginPage(driver, properties); 
		CreateAccountObj = new CreateAnAccountPage(driver, properties); 
		prodViewPageObj = new ProductViewPage(driver, properties);
		prodReviewPageObj = new ProductReviewPage(driver, properties);
		shopCartSummeryPageObj = new ShoppingCartSummeryPage(driver, properties);
		ShoppingCartAddressPageObj = new ShoppingCartAddressPage(driver, properties);
		ShoppingCartShippingPageObj = new ShoppingCartShippingPage(driver, properties);
		ShoppingCartPaymentPageObj = new ShoppingCartPaymentPage(driver, properties);	
		OrderHistoryPageObj = new OrderHistoryPage(driver, properties);
	}
	
	@DataProvider(name = "RegisterNewUserAndMakeOrder")
    public Object[][] testLogin() throws InvalidFormatException, IOException {
          Object[][] data = ExcelReader.fetchData(properties.getProperty("TestDataSheetPath"), "RegisterNewUserAndMakeOrder");
          return data;
    }
	
	 @Test(priority=1,alwaysRun=true,dataProvider="RegisterNewUserAndMakeOrder")
		public void UserRegAndMakeOrder
		(String strEmail, String strFirstName, String strLastName, String strPassword, String strAddress, 
		 String strCity, String strPostalCode, String strMobilePhone, String strCategory, String strSubCategory) {
		homeObject.openLoginPage();
		CreateAccountObj.CreateNewUser(strEmail, strFirstName, strLastName, strPassword, strAddress, strCity, strPostalCode, strMobilePhone);
		Assert.assertTrue(CreateAccountObj.successMessage.getText().contains("Welcome to your account"));
		System.out.println("User Registered Successfully");
		homeObject.userLogout();
		
		homeObject.openLoginPage();
		loginObject.UserLogin(strEmail, strPassword);
		Assert.assertTrue(homeObject.logoutLink.getText().contains("Sign out"));
		
		homeObject.SelectCategorySubcategory(strCategory, strSubCategory);
		Assert.assertTrue(prodViewPageObj.headerTxt.getText().contains("BLOUSES"));
		System.out.println("'"+strSubCategory+"'SubCategory Selected Successfully");
		
		prodViewPageObj.AddBlouseToCart();
		Assert.assertTrue(prodReviewPageObj.addingSuccessMSG.getText().contains("Product successfully added to your shopping cart"));
		System.out.println("Product Added to Cart Successfully");

		prodReviewPageObj.ProceedToCheckOut();
		Assert.assertTrue(shopCartSummeryPageObj.summeryPageTitle.getText().contains("SHOPPING-CART SUMMARY"));
		System.out.println("Product displayed correctly in the Summery page");
		
		shopCartSummeryPageObj.FirstProceedToCheckout();
		ShoppingCartAddressPageObj.PreFinalProceedToCheckout();
		ShoppingCartShippingPageObj.FinalProceedToCheckout();
		ShoppingCartPaymentPageObj.ConfirmOrderPayment();
		Assert.assertTrue(ShoppingCartPaymentPageObj.completeOrderMsg.getText().contains("Your order on My Store is complete."));
		System.out.println("Your order on My Store is complete.");
		Assert.assertTrue((ShoppingCartPaymentPageObj.GetOrderPrice()).contains(OrderHistoryPageObj.GetOrderHistoryPrice()));
		System.out.println("Order displayed correctly in Order History Page");
	 }
}
