package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//button[@type='submit']")WebElement signInButton;
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminLink;
	@FindBy(linkText="Logout")WebElement logoutButton;
	@FindBy(xpath="//div[@class='inner']//p[text()='Admin Users']/../following-sibling::a")WebElement moreInfoAdmin;
	@FindBy(id="un")WebElement searchuname;
	
    
	public void signinButton()
	{
		signInButton.click();
	}
	
	public void clickOnAdminLink()
	{
		adminLink.click();
	}
	
	public void clickOnLogoutButton()
	{
		logoutButton.click();
	}
	
	public void clickOnMoreInfo() {
		moreInfoAdmin.click();
	}
}
