package com.test.automation.uiAutomationNew.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomationNew.testBase.TestBase;

public class homePage extends TestBase {

	public static final Logger log = Logger.getLogger(homePage.class.getName());
	WebDriver driver ;
    
	
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath = "//*[@id='email']")
	WebElement emailId;
	
	@FindBy(xpath = "//*[@id='passwd']")
	WebElement passWd;
	
	@FindBy(xpath = "//*[@id='SubmitLogin']")
	WebElement submitButton;
	
	@FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
	WebElement invalidPassWd;
	
	@FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
	WebElement validEmailAddresMsg;
	
	@FindBy(xpath = "//*[@id='email_create']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement submitCreateButton;
	
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")
	WebElement Header;
	
	public homePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void logInApplication(String emailAddress, String Password)
	{
		signIn.click();
		log.info("clicked on sign in and the object is "+signIn.toString());
		emailId.sendKeys(emailAddress);
		log.info("entered email address :-"+emailAddress+ "and the object is "+ emailId.toString());
		passWd.sendKeys(Password);
		log.info("entered password :-" +Password +" and the object is "+passWd.toString());
		submitButton.click();
		log.info("clicked on submit button and the object is "+ submitButton.toString());
		
		
		
	}
	
	public String getInvalidLoginText()
	{
		log.info("error message is :-"+invalidPassWd.toString());
		return  invalidPassWd.getText();
	}

	public boolean verifyInvalidEmailAddressMsg()
    {
	//	waitForElement(300,validEmailAddresMsg);
		try {
			validEmailAddresMsg.isDisplayed();
			log.info("Invalid email address message is displayed ======"+validEmailAddresMsg.toString());
			return true; 
		} catch (Exception e) {
          return false;
		
		}
	}
	
	public void clickSignIn()
	{
		signIn.click();
		log.info("===clicked on signin button and theobject is ====="+signIn.toString());
	}
	
	public void creatAnAcount(String emailId)
	{
		signIn.click();
		log.info("clicked on sign in and the object is "+signIn.toString());
		emailAddress.sendKeys(emailId);
		submitCreateButton.click();
		
	}
	
	public String verifyRegistration()
	{
		log.info("Verification name is "+Header.toString());
		return Header.getText();
	   
		
		
	}
	
}
