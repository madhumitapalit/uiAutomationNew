package com.test.automation.uiAutomationNew.homePage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomationNew.testBase.TestBase;
import com.test.automation.uiAutomationNew.uiActions.homePage;

public class TC002_VerifyLoginWithDifferentRecords extends TestBase {
  
public static final Logger log = Logger.getLogger(TC002_VerifyLoginWithDifferentRecords.class.getName());
	
	homePage HomePageObj;
	

	
	@DataProvider(name = "loginData")
	public String[][] getTestData()
	{
	 String[][] testRecords = getData("uiAutomationPracticeDocument.xlsx","SignInTestData");
	 System.out.println("The excel is "+testRecords);
	 return testRecords;
	 
	}
	
	
	@BeforeTest
	public void setup() {
	
		init();
	}
	
	
	
	
	
	@Test (dataProvider = "loginData")
  public void testLogin(String emailAddress, String Password , String runMode) 
  { 
	if (runMode.equalsIgnoreCase("n"))
	{
		throw new SkipException("user marked this as no run  =====");
	}
		
  log.info("==============starting verifyLogin with different record test==========");
  
  HomePageObj = new homePage(driver);
  HomePageObj.logInApplication(emailAddress, Password);
  boolean status = HomePageObj.verifyInvalidEmailAddressMsg();
  
  if(status)
  {
	  HomePageObj.clickSignIn();
  }
  Assert.assertEquals(status, true);
  
  
  log.info("===============finished verify login with different records========");
  
  
  }
	
	@AfterClass
	public void endTest()
	{
		driver.quit();
	}
	
	
	
}
