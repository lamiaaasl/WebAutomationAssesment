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
import Pages.ProductReviewPage;
import Pages.ProductViewPage;
import Pages.ShoppingCartSummeryPage;
import TestData.ExcelReader;

public class AddToCartTest extends TestBase {
	CreateAnAccountPage CreateAccountObj;
	ExcelReader ExcelReaderObj;
	LoginPage loginObject ;
	HomePage homeObject ; 
	ProductViewPage prodViewPageObj;
	ProductReviewPage prodReviewPageObj;
	ShoppingCartSummeryPage shopCartSummeryPageObj;
	
	@BeforeMethod
	public void BeforeMethod() {
		homeObject = new HomePage(driver, properties); 
		loginObject = new LoginPage(driver, properties); 
		prodViewPageObj = new ProductViewPage(driver, properties);
		prodReviewPageObj = new ProductReviewPage(driver, properties);	
	}
	
	@DataProvider(name = "SelectCategorySubCategory")
    public Object[][] testLogin() throws InvalidFormatException, IOException {
          Object[][] data = ExcelReader.fetchData(properties.getProperty("TestDataSheetPath"), "SelectCategorySubCategory");
          return data;
    }
	
	 @Test(priority=1,alwaysRun=true,dataProvider="SelectCategorySubCategory")
		public void UserAddToCart(String strEmail, String strPassword, String strCategory, String strSubCategory) {
		homeObject.openLoginPage();
		loginObject.UserLogin(strEmail, strPassword);
		homeObject.SelectCategorySubcategory(strCategory, strSubCategory);
		prodViewPageObj.AddBlouseToCart();
		Assert.assertTrue(prodReviewPageObj.addingSuccessMSG.getText().contains("Product successfully added to your shopping cart"));
		System.out.println("Product Added to Cart Successfully");
	 }
}
