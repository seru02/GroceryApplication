package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilites.ExcelUtiles;

public class LoginTest extends Base{
	
	HomePage hp = new HomePage(driver);
	
	@Test(priority=1,description="user is login with valid creds",groups= {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		String uName=ExcelUtiles.readStringData(0, 0, "LoginData");
		String uPassword=ExcelUtiles.readStringData(0, 1, "LoginData");
		lp.enterUserName(uName).enterUserPassword(uPassword);
		hp=lp.signinButton();
		//assertion
		boolean dashboardDisplay=lp.verifyWetherdashBoardIsDisplayed();
		Assert.assertTrue(dashboardDisplay,Constant.VALID_CRED_ERROR);
	}
	
	@Test(priority=2,description="user is login with invalid creds",groups= {"smoke"},retryAnalyzer=retry.Retry.class)

	public void verifyUserLoginWithInvalidCredentials() throws IOException {

		LoginPage lp = new LoginPage(driver);
		String uName = ExcelUtiles.readStringData(1, 0, "loginData");
		String uPassword = ExcelUtiles.readStringData(1, 1, "loginData");
		lp.enterUserName(uName);
		lp.enterUserPassword(uPassword);
		lp.signinButton();
		//assertion
		String actual=lp.verifyPageName();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,"User is able to login with invalid credentials");
		
	
		
	}

	@Test(priority=3,description="user is login with invalid password",dataProvider = "LoginData")
	public void verifyUserLoginWithValidUserName(String uName,String uPassword) throws IOException {

		LoginPage lp = new LoginPage(driver);
		//String uName = ExcelUtiles.readStringData(2, 0, "loginData");
		//String uPassword = ExcelUtiles.readStringData(2, 1, "loginData");
		lp.enterUserName(uName);
		lp.enterUserPassword(uPassword);
		lp.signinButton();
		//assertion
		String actual=lp.verifyPageName();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,"User is able to login with invalid password");
				

	}

	@Test(priority=4,description="user is login with invalid username")
	public void verifyUserLoginWithValidPassword() throws IOException {

		LoginPage lp = new LoginPage(driver);
		String uName = ExcelUtiles.readStringData(3, 0, "loginData");
		String uPassword = ExcelUtiles.readStringData(3, 1, "loginData");
		lp.enterUserName(uName);
		lp.enterUserPassword(uPassword);
		lp.signinButton();
		//assertion
		String actual=lp.verifyPageName();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,"User is able to login with invalid username");
				
	}
	
	@DataProvider(name="LoginData")
	public Object[][] getDatafromDataProvider() {
		return new Object[][] {new Object[] {"admin","invalid"},new Object [] {"admin","admin123"},new Object[] {"admin","inadm"}};
	}
}
