package com.test.automation.uiAutomationNew.homePage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomationNew.testBase.TestBase;
import com.test.automation.uiAutomationNew.uiActions.homePage;

public class TC004_VerifyLoginWithValidCredential extends TestBase{
	
	String emailId = "amio@gmail.com"; String passWord = "mm2345";
	
public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredential.class.getName());
	
	homePage HomePageObj;
	
	@BeforeTest
	public void setup() {
	
		init();
	}
	
	
	@Test
	public void testValidLogin()
	{
		log.info("==========Starting the test verifyLoginValidCredential====");
		HomePageObj = new homePage(driver);  
		
		HomePageObj.logInApplication(emailId,passWord );
		HomePageObj.verifyRegistration();
		
	}
	
	@AfterClass
	public void endTest()
	{
		driver.quit();
	}
	
}