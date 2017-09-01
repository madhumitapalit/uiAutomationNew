package com.test.automation.uiAutomationNew.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.automation.uiAutomationNew.testBase.TestBase;

public class createAccount extends TestBase
{
	public static final Logger log = Logger.getLogger(createAccount.class.getName());
	WebDriver driver ;
	
	@FindBy(xpath = "//*[@id='columns']/div[1]/span[2]")
	WebElement authenticatinText;
	@FindBy(xpath = "//*[@id='id_gender1']")
	WebElement mrGender1;
	@FindBy(xpath ="//*[@id='customer_firstname']")
    WebElement firstName;	
	@FindBy(xpath ="//*[@id='customer_lastname']")
	WebElement lastName;
	@FindBy(xpath ="//*[@id='passwd']")
	WebElement passwd;
	@FindBy(xpath ="//*[@id='days']")
	WebElement days;
	@FindBy(xpath= "//*[@id='months']")
	WebElement month;
	@FindBy(xpath= "//*[@id='years']")
	WebElement year;
    @FindBy(xpath="//*[@id='newsletter']")
	WebElement newsLetter;
    @FindBy(xpath="//*[@id='optin']")
    WebElement offerOption;
	@FindBy(xpath="//*[@id='firstname']")
	WebElement firstName2;
	@FindBy(xpath="//*[@id='lastname']")
	WebElement lastName2;
	
	@FindBy(xpath="//*[@id='company']")
	WebElement companyName;
	
	@FindBy(xpath="//*[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath="//*[@id='address2']")
	WebElement address2;
	
	@FindBy(xpath="//*[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//*[@id='id_state']")
	WebElement IdState;
	
	@FindBy(xpath="//*[@id='postcode']")
	WebElement zipCode;
	
	@FindBy(xpath="//*[@id='phone']")
	WebElement homePhone;
	
	@FindBy(xpath="//*[@id='alias']")
	WebElement addressAlias;
	
	@FindBy(xpath="//*[@id='submitAccount']")
	WebElement submitRegister;
	
	
	public createAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
 
	
	public String getAuthenticationText()
	{
		log.info("===The error messaage is ===="+ authenticatinText.toString());
     //	log.info("-----The text is ------"+authenticatinText.getText());
		return authenticatinText.getText();
			
	}
	
	public void fillPersonalInformationMr(String Rita, String Bose, String mm2345, String sysco, String BernalAve ,String AptK, String pleasanton, String Purulia )
	
	{
		log.info("=====proceeding to fill up the registration form======");
		mrGender1.click();
		log.info("====Gender1 radio button is selected and the object is === "+mrGender1.toString());
		
		firstName.click();
		firstName.sendKeys(Rita);
		log.info("====First name has entered and the object is and the object is ===="+firstName.toString());
		
		lastName.click();
		lastName.sendKeys(Bose);
		log.info(" ======last name has entered and the object is ==="+ lastName.toString());
		
		passwd.click();
		passwd.sendKeys(mm2345);
		log.info("====Password has enterd and the object is ==="+passwd.toString());
		 
		
		log.info("===strated selecting from dropdown and first selecting from days===");
		Select Oselect1 = new Select(days);
		Oselect1.selectByValue("1");
		
		log.info("===selecting from month===");
		Select Oselect2 = new Select(month);
		Oselect2.selectByValue("1");
		
		log.info("===selecting from year===");
		Select Oselect3 = new Select(year);
		Oselect3.selectByValue("1980");
		
		log.info("===selecting the check box for news letter and the object is ==="+newsLetter.toString());
		newsLetter.click();
		
		log.info("===selecting the checkbox for extra offer option and the object is =="+offerOption.toString());
		offerOption.click();
		
		firstName2.click();
		log.info("====entering the first name 2nd time and the object is ==="+ firstName2.toString());
		firstName2.sendKeys(Rita);
		
		lastName2.click();
		log.info("=====enetring the last name 2nd time and the object is ===="+lastName2.toString());
		lastName2.sendKeys(Bose);
		
		companyName.click();
		companyName.sendKeys(sysco);
		log.info("Entered the company name and the object is "+companyName.toString());
		
		address1.click();
		address1.sendKeys(BernalAve);
		log.info("====Entered the address1 and the object is ==="+address1.toString());
		
		address2.click();
	    address2.sendKeys(AptK);
	    log.info("====entered the address2 and the object is ==="+address2.toString());
	    
	    city.click();
	    city.sendKeys( pleasanton);
	    log.info("===Enetred the city name and the object is ==="+ city.toString());
	    
	    Select Oselect4 = new Select(IdState);
	    Oselect4.selectByValue("5");
	    log.info("===Selected the dropdown for country==");
	    
	    zipCode.click();
	    zipCode.sendKeys((String.valueOf(94566)));
	    log.info("===enetring the zipcode ===");
	    
	    homePhone.click();
	    homePhone.sendKeys("6502420143");
	    log.info("======Enetering the home phone number hardcoded and the object is===="+homePhone.toString());
	    
	    addressAlias.clear();;
	    addressAlias.sendKeys(Purulia);
	    log.info("entering the alias adrees");
	    
	    submitRegister.click();
	    log.info("submitting register");
	    
	    
	    
	    
	    
		
	}
	
	
}