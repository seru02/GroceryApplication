package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitUtility;

public class LoginPage {

	public WebDriver driver;
	WaitUtility wait= new WaitUtility();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")WebElement userName;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement userPassword;
	@FindBy(xpath="//button[@type='submit']")WebElement signInButton;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement pageName;
	
	public LoginPage enterUserName(String uName)
	{
		userName.sendKeys(uName);
		return this;
	}
	
	public LoginPage enterUserPassword(String uPassword)
	{
		userPassword.sendKeys(uPassword);
		return this;
	}
    
	public HomePage signinButton()
	{
		wait.waitUntilElementToBeClickable(driver, signInButton);
		signInButton.click();
		return new HomePage(driver);
	}
 
	public boolean verifyWetherdashBoardIsDisplayed()
	{
		return dashboard.isDisplayed();
	}
	
	public String verifyPageName() {
		return pageName.getText();
	}
}
