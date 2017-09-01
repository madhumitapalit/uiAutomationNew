package com.test.automation.uiAutomationNew.homePage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomationNew.testBase.TestBase;
import com.test.automation.uiAutomationNew.uiActions.homePage;
import com.test.automation.uiAutomationNew.uiActions.createAccount;

public class TC003_CreateAnAccount extends TestBase {
	
	String emailId = "binod@gmail.com" ; String FirstName; String LastName; String passWord; String companyName; 
	String address; String sccondAddress; String city; String zipCode; 
	String aliasAddress;
	
	homePage HomePageObj; 
	createAccount CreateAccountObj; 
	
	@BeforeTest
	public void setup() {
	
		init();
	}
	
    @Test
    public void createAccount()
    
    {   log.info("====Starting the test verrification of create an account ====");
    	HomePageObj = new homePage(driver);
    	HomePageObj.creatAnAcount(emailId);
    	
    	 CreateAccountObj = new	createAccount(driver);
    	Assert.assertEquals( CreateAccountObj.getAuthenticationText(),"Authentication");
    	 
    	
    	
    	log.info("====navigating to the next page create account ===="); 
    	
    	
    	CreateAccountObj.fillPersonalInformationMr("Rita1"," Bose", "mm2345","sysco", "BernalAve", "AptI", "pleasanton", "Purulia");
    	
    
    	
    }
    
    @AfterTest
	public void endTest()
	{
	//	driver.quit();
		
	}
	
	
	
}
