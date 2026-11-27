package testScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import base.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilites.ExcelUtiles;

public class AdminUserTest extends Base{
	
	
	@Test(description="user is able to click on new button")
	public void verifySearch() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String uName=ExcelUtiles.readStringData(0, 0, "LoginData");
		String uPassword=ExcelUtiles.readStringData(0, 1, "LoginData");
		lp.enterUserName(uName);
		lp.enterUserPassword(uPassword);
		lp.signinButton();
		HomePage hp=new HomePage(driver);
		hp.clickOnMoreInfo();
		AdminUsersPage ap= new AdminUsersPage(driver);
		String userName=ExcelUtiles.readStringData(0, 0, "User");
		String userPassword=ExcelUtiles.readStringData(0, 1, "User");
		String usertypev=ExcelUtiles.readStringData(0, 2, "User");
		ap.clickOnMainSearch();
		ap.enterSearchUsername(userName);
		ap.selectSearchUserType();
		ap.clickOnSearch();
		String actual = ap.getUnameText();
		
		//assertion
		assertEquals(actual, userName,"username is not valid");
		
		
	}
	
	@Test(description="user is able to create new user")
	public void verifyEnetringAdminUsersInformations() throws IOException {
		LoginPage lp=new LoginPage(driver);
		String uName=ExcelUtiles.readStringData(0, 0, "LoginData");
		String uPassword=ExcelUtiles.readStringData(0, 1, "LoginData");
		lp.enterUserName(uName);
		lp.enterUserPassword(uPassword);
		lp.signinButton();
		
		HomePage hp=new HomePage(driver);
		hp.clickOnMoreInfo();
		
		String userName=ExcelUtiles.readStringData(0, 0, "User");
		String userPassword=ExcelUtiles.readStringData(0, 1, "User");
		String usertypev=ExcelUtiles.readStringData(0, 2, "User");
		AdminUsersPage ap= new AdminUsersPage(driver);
		ap.clickonNewButton();
		ap.enteronUsername(userName);
		ap.enterPassword(userPassword);
		ap.clickOnUsertype();
		ap.selectUserType();
		ap.clickOnSave();
		boolean alertresult= ap.verifyAlertDisplayed();
		//assertion
		assertTrue(alertresult,"User is not created");
		
		
		//searching added user
		
		ap.clickOnMainSearch();
		ap.enterSearchUsername(userName);
		ap.selectSearchUserType();
		ap.clickOnSearch();
		String actual = ap.getUnameText();
		
		//assertion
		assertEquals(actual, userName,"username is not valid");
		
		
	}


}
