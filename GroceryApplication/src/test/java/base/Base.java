package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilites.ScreenshotUtilites;

public class Base {
	public WebDriver driver;
	
	Properties p;
	FileInputStream f;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initialisebrowser(String browsers) throws IOException
	
	{
		p=new Properties();
		f= new FileInputStream(Constant.CONFIGFILE);
		p.load(f);
		if(browsers.equalsIgnoreCase("Chrome")) 
		{	
			driver=new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("FireFox")){
			driver=new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("Edge")) {
			driver= new EdgeDriver();
		}
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
			@AfterMethod(alwaysRun=true)
			public void closeBrowser(ITestResult itestresult) throws IOException{
				if(itestresult.getStatus()==ITestResult.FAILURE) {
					ScreenshotUtilites screenshotutility=new ScreenshotUtilites();
					screenshotutility.getScreenshot(driver, itestresult.getName());
				}
				 // driver.close();
				//driver.quit();
}
}
