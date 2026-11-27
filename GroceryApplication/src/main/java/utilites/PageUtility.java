 package utilites;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDragDropWithValue(WebElement element, String value) {

		Select object=new Select(element);

		object.selectByValue(value);

		}
	
	public void selectDragDropWithVisibleText(WebElement element, String value) {

		Select object=new Select(element);

		object.selectByVisibleText(value);

		}
	
	public void selectDragDropWithIndex(WebElement element, int index) {

		Select object=new Select(element);

		object.selectByIndex(index);

		}
	
	
	public void verifyActions(WebElement element, WebDriver driver) {
		
		
		Actions actionRightClick =new Actions(driver);
		actionRightClick.contextClick(element).build().perform();
		}
	
	
	public void verifyMouseHover(WebElement element, WebDriver driver) {
		
		
		Actions actionMouseHover =new Actions(driver);
		actionMouseHover.moveToElement(element).build().perform();
		
		
	}
	
	public void verifyDoubleClick(WebElement element, WebDriver driver) {
		
		Actions actionDoubleClick =new Actions(driver);
		actionDoubleClick.doubleClick(element).build().perform();
		
	}
	
	public void dragAndDrop(WebElement drag, WebElement drop, WebDriver driver) {
		
		
		Actions draganddropref = new Actions(driver);
		draganddropref.dragAndDrop(drag, drop).build().perform();
		
	}
	
	public void verifyKeyboardActions() throws AWTException
	{
	    Robot ro = new Robot(); // keyboard actions class
	    ro.keyPress(KeyEvent.VK_CONTROL);
	    ro.keyPress(KeyEvent.VK_T);
	    ro.keyRelease(KeyEvent.VK_CONTROL);
	    ro.keyRelease(KeyEvent.VK_T);
	}

	
public void verifyjavaScript(WebElement element, WebDriver driver) {
		
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
		js.executeScript("window.scrollBy(0,350)","");
	}
	
		

	//drp down methos,mouse actions, javascript executor
	
	

}
