package testScripts;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;
import pages.ManagePage;
import utilites.ExcelUtiles;

public class ManagePageTest extends Base{
	
	@Test
	public void verifyAddPages() throws IOException, AWTException {
		
		LoginPage lp=new LoginPage(driver);
		String uName=ExcelUtiles.readStringData(0, 0, "LoginData");
		String uPassword=ExcelUtiles.readStringData(0, 1, "LoginData");
		lp.enterUserName(uName);
		lp.enterUserPassword(uPassword);
		lp.signinButton();
		
		ManagePage mp= new ManagePage(driver);
		mp.clickManagePage();
		mp.clickNewButton();
		
		String extitl=ExcelUtiles.readStringData(0, 0, "PageName");
		String exdesc=ExcelUtiles.readStringData(1, 0, "PageName");
		String exp=ExcelUtiles.readStringData(1, 0, "PageName");
		mp.enterTilte(extitl);
		mp.enterDescription(exdesc);
		mp.enterPageName(exp);
		mp.uploadImage();
		
		mp.clickSave();
		
		String expected_url="https://groceryapp.uniqassosiates.com/admin/page/add";
		String current_url=driver.getCurrentUrl();
		assertEquals(current_url,expected_url,"page is not added");
		
		
	}
	

}
