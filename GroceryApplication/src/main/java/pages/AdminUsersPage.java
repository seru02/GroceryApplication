package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilites.PageUtility;

public class AdminUsersPage {
	
	public WebDriver driver;
	PageUtility pu= new PageUtility();
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	@FindBy(id="username")WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(id="user_type")WebElement userType;
	@FindBy(xpath="//button[@type='submit' and @name='Create']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement mainSearch;
	@FindBy(id="ut")WebElement searchUsetype;
	@FindBy(id="un")WebElement searchUname;
	@FindBy(xpath="//button[@name='Search']")WebElement search;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]/td[1]") WebElement un;
	
	
	public void clickonNewButton() {
		newButton.click();
	}
	
	public void enteronUsername(String usern) {
		username.sendKeys(usern);
	}
	
	public void enterPassword(String userpass) {
		password.sendKeys(userpass);
	}
	
	public void clickOnUsertype() {
		userType.click();
	}
	
	public void selectUserType() {
		pu.selectDragDropWithValue(userType, "admin");
		//Select s = new Select(userType);
		//s.selectByValue(usertypeValue);
	}
	
	public void clickOnSave() {
		save.click();
	}
	
	public boolean verifyAlertDisplayed() {
		return successAlert.isDisplayed();
	}
	
	public void clickOnMainSearch() {
		mainSearch.click();
	}
	
	
	public void enterSearchUsername(String usern) {
		searchUname.sendKeys(usern);
	}
	
	public void selectSearchUserType() {
		pu.selectDragDropWithValue(searchUsetype,"admin");
		//Select s = new Select(searchUsetype);
		//s.selectByValue(usertypeValue);
	}
	
	public void clickOnSearch() {
		search.click();
	}
	
	public String getUnameText() {
		String name=un.getText();
		return name;
	}
	
	
	

}
