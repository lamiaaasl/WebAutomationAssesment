package TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductViewPage;
import TestData.ExcelReader;

public class SelectCategoryTest extends TestBase{

	LoginPage loginObject ;
	HomePage homeObject ; 
	ProductViewPage prodViewPageObj;
	public WebDriverWait wait ;
	
	@BeforeMethod
	public void BeforeMethod() {
		homeObject = new HomePage(driver, properties); 
		loginObject = new LoginPage(driver, properties); 
		prodViewPageObj = new ProductViewPage(driver, properties);
	}
	
	@DataProvider(name = "SelectCategorySubCategory")
    public Object[][] testLogin() throws InvalidFormatException, IOException {
          Object[][] data = ExcelReader.fetchData(properties.getProperty("TestDataSheetPath"), "SelectCategorySubCategory");
          return data;
    }
	
	 @Test(priority=1,alwaysRun=true,dataProvider="SelectCategorySubCategory")
		public void UserCanSelectCategory(String strEmail, String strPassword, String strCategory, String strSubCategory) {
		homeObject.openLoginPage();
		loginObject.UserLogin(strEmail, strPassword);
		homeObject.SelectCategorySubcategory(strCategory, strSubCategory);		
		Assert.assertTrue(prodViewPageObj.headerTxt.getText().contains("BLOUSES"));
		System.out.println("'"+strSubCategory+"'SubCategory Selected Successfully");
	 }
}
