package com.inetBanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCustomerPage;
import com.inetBanking.pageObjects.LoginPage;



public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException {
		
//		Here we have to use 2 page objects class 
//		1) Login Page
//		2) AddNewCustomer page
		
//		Because to add a new customer, first we to perform login action on the wepage
		
//	===============================================================================================================================================
//		1) Login Page
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Username Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickSubmit();
		
		Thread.sleep(3000);
//	===============================================================================================================================================
//		driver.switchTo().alert().dismiss();
//	===============================================================================================================================================
		
//		2) Add New Customer Page

		AddNewCustomerPage anc = new AddNewCustomerPage(driver);
		
		anc.clickAddNewCustomer();
		anc.custName("Valtteri Bottas");
		anc.custGender("male");
		anc.custDOB("20", "10", "2020");
		Thread.sleep(3000);
		anc.custAddress("Finland");
		anc.custCity("Russian GP");
		anc.custState("Mexico");
		anc.custPin("445821");
		anc.custMobileNumber("0987654321");
		
//		Email Id is unique to every person so when we iterate this test case again and again it will throw an error to email id because it is unique
//		So we have to use different email ids' for every iteration, for this we have to generate "random email ids using generic method
		
//		randomEmail() method is present is Base Class because it can be used for any test cases
		String email = randomEmail() + "@gmail.com";
		anc.custEmail(email);
		
		Thread.sleep(3000);
		
		anc.custPassword("dfjhsui");
		anc.custSubmit();
		
//		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		
//		After Adding new customer, it will show message like "Customer Registered Successfully!!!", we have to validate this message to pass our test case
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");		// This method returns boolean value

		logger.info("Validation Started for Add New Customer Test Case");
		if(result == true)
		{
			Assert.assertTrue(true);
			logger.info("Add New Customer Test Case Passed");
		}
		else
		{
			// If test case failed then capture screenshot, video time (03:48:25)
			Assert.assertTrue(false);
			logger.info("Add New Customer Test Case Failed");
		}
	}
 
}
