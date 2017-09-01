package com.test.automation.uiAutomationNew.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automation.uiAutomationNew.excelReader.Excel_Reader;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
			
      public	WebDriver driver;
	  String URL = "http://automationpractice.com/index.php";
	  String browser = "firefox";
	  Excel_Reader excel;
	  
	  public void init() 
	  {
		  
		  selectBrowser(browser);
		  getURL(URL); 
		  
		  String log4jConfPath = "log4j.properties";
		  PropertyConfigurator.configure(log4jConfPath);
		  
	  }
	
	  public void selectBrowser(String browser)
	  {
		  log.info("Creating the Object of " + browser);
		  
		  
		  if(browser.equalsIgnoreCase("firefox"))
		  {
			  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		      driver = new FirefoxDriver();
		  
		  }
	  }	
	
	 public void getURL(String URL)
	 {
		 log.info("navogating to "+URL);
		 driver.get(URL);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		 
	 }
	 
	 public String[][] getData(String excelName, String sheetName)
	 {
	
		 
		 String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\automation\\uiAutomationNew\\data\\"+excelName;
		 
		 excel = new Excel_Reader(path);
		String[][]data =  excel.getDataFromSheet(sheetName, excelName);
	    return data;
	 }
   
	 public void waitForElement(int timeOutInSeconds, WebElement element)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		 wait.until(ExpectedConditions.visibilityOf(element));
		 
	 }
	
	
	 
}
