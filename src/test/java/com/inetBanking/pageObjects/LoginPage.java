package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;	// ldriver = local driver
	
	public LoginPage(WebDriver driver) {	// rdriver = remote driver
		
		this.driver = driver;	// ldriver = rdriver ==> this.driver = driver
		
		PageFactory.initElements(driver, this);
	} 
	
//	1) Username
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
//	2) Password
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
//	3) Login Button
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
//	4) Logout Button
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
	@CacheLookup
	WebElement btnLogout;
	
//	Create action methods for all objects present on the web page to perform actions on them 
	public void setUserName(String uname) {
		
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		
		btnLogout.click();
	}
	
}
