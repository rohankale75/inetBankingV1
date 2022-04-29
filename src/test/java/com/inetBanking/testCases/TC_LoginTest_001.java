package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{

//	This test class contains only @Test methods and methods which are common to all test classes are declared in Base Class
	
	@Test
	public void LoginTest() throws InterruptedException {
		
		driver.get(baseURL);
		logger.info("URL is Opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username");
		
		Thread.sleep(2000);
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		
		Thread.sleep(2000);
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		
		else {
			
			Assert.assertTrue(false);
			logger.info(lp);
		}
	}
	 
	
}
