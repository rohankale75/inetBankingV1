package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver driver;
	
	public AddNewCustomerPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	Two types to write webelement paths
//	1) @FindBy(attribute = "value")
//	2) @FindBy(how = How.attribute, using = "value")
	
//	1) New Customer Button
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkAddNewCustomer;

//	2)Customer Name
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
//	3) Gender
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rGender;
	
//	4) Date of Birth
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtDob;
	
//	5) Address
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
//	6) City
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
//	7) State
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
//	8) Pin
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPin;
	
//	9) Mobile Number
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtMobileNumber;
	
//	10) Email
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;
	
//	11) Password
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;
	
//	12) Submit Button
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
//	13) Reset Button
	@FindBy(how = How.NAME, using = "res")
	@CacheLookup
	WebElement btnReset;
	
//	================================================================================================================================================
	
//	Action Methods
	
//	1) New Customer Button
	public void clickAddNewCustomer() {
		
		linkAddNewCustomer.click();
	}
	
//	2) Username
	public void custName(String cname) {
		
		txtCustomerName.sendKeys(cname);
	}
	
//  3) Gender
	public void custGender(String cgender) {
		
		rGender.click();
	}
	
//	4) Date of Birth
	public void custDOB(String dd, String mm, String yyyy) {
		
		txtDob.sendKeys(dd);	// As the Dob box input is text in the form of dd/mm/yyyy and after entering date, cursor will move to mm and then yyyy hence three different sendkeys() methods are written
		txtDob.sendKeys(mm);
		txtDob.sendKeys(yyyy);
	}
	
//	5) Address
	public void custAddress(String caddress) {
		
		txtAddress.sendKeys(caddress);
	}
	
//	6) City
	public void custCity(String ccity) {
		
		txtCity.sendKeys(ccity);
	}
	
//	7) State
	public void custState(String cstate) {
		
		txtState.sendKeys(cstate);
	}
	
//	8) Pin
	public void custPin(String cpin) {	// Input for pin may be in the integer or string format hence we have used a method called "String.valueOf(Parameter)" it will convert entered "integer" data to string
										// And if the entered data is in the String format then String.valueOf(Parameter) method will not change the input, it will remain as it is because it is String.
		txtPin.sendKeys(String.valueOf(cpin));
	}
	
//	9) Mobile Number
	public void custMobileNumber(String ctelephoneno) {
		
		txtMobileNumber.sendKeys(ctelephoneno);
	}
	
//	10) Email
	public void custEmail(String cemailid) {
		
		txtEmail.sendKeys(cemailid);
	}
	
//	11) Password
	public void custPassword(String cpassword) {
		
		txtPassword.sendKeys(cpassword);
	}
	
//	12) Submit Button
	public void custSubmit() {
		
		btnSubmit.click();
	}
	
//	13) Reset Button
	public void custReset() {
		
		btnReset.click(); 
	}
}
