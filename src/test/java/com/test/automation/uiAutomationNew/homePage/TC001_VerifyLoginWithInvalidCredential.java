package com.test.automation.uiAutomationNew.homePage;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomationNew.testBase.TestBase;
import com.test.automation.uiAutomationNew.uiActions.homePage;

public class TC001_VerifyLoginWithInvalidCredential extends TestBase{


	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredential.class.getName());
	
	homePage HomePageObj;
	
	@BeforeTest
	public void setup() {
	
		init();
	
	}
	@Test
	
	public void verifyLoginInvalidCredential()
	{
	
		
		log.info("==========Starting the test verifyLoginInvalidCredential====");
		HomePageObj = new homePage(driver);    
	
		HomePageObj.logInApplication("test@gmail.com","Pass123" );
		
		
		
		Assert.assertEquals(HomePageObj.getInvalidLoginText(),"Authentication failed.");
		
		log.info("==========Ending the test verifyLoginInvalidCredential ");
		
		
	}
	@AfterTest
	public void endTest()
	{
		driver.quit();
		
	}
	
	
}
