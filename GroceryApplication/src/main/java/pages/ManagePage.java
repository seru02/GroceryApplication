package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePage {
	
	public WebDriver driver;
	
	public ManagePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='inner']//p[text()='Manage Pages']//following::a[text()='More info '][1]")WebElement managePage;
	@FindBy(xpath="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/pages/add\"]")WebElement newButton;
	@FindBy(id="title")WebElement title;
	@FindBy(xpath="//div[@class='note-editable card-block']")WebElement descp;
	@FindBy(id="page")WebElement pageName;
	@FindBy(id="main_img")WebElement image;
	@FindBy(xpath="//button[@type='submit']")WebElement save;
	
	
	public void clickManagePage() {
		managePage.click();
	}
	
	public void clickNewButton() {
		newButton.click();
	}
	
	public void enterTilte(String extitle) {
		title.sendKeys(extitle);
	}
	
	public void enterDescription(String exdescp) {
		descp.sendKeys(exdescp);
	}
	
	public void enterPageName(String expname) {
		pageName.sendKeys(expname);
	}
	
	public void uploadImage() throws AWTException {
		
		image.click();
		
		
		StringSelection image = new StringSelection("C:\\Serina_JAVA\\Workplace\\GroceryApplication\\src\\test\\resources\\image.PNG");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(image, null);

		Robot r = new Robot();
		r.delay(2500);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void clickSave() {
		save.click();
	}
}
