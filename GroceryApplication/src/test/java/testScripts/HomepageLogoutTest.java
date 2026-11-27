package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;
import utilites.ExcelUtiles;

public class HomepageLogoutTest extends Base{

	@Test(description="user is able to logout")
	
	public void verifyWhetherUserLogoutSuccessfully() throws IOException
	{
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		String uName=ExcelUtiles.readStringData(0, 0, "LoginData");
		String uPassword=ExcelUtiles.readStringData(0, 1, "LoginData");
		lp.enterUserName(uName);
		lp.enterUserPassword(uPassword);
		lp.signinButton();
		
		hp.clickOnAdminLink();
		hp.clickOnLogoutButton();
		
		//assertion
		String actual=lp.verifyPageName();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,"User is not able to logout");
				
	}
	
	
}
