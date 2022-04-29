package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ExcelUtils;


// DDT - Data Driven Test
public class TC_LoginDDT_002 extends BaseClass {

	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pass) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("User Name is Provided");
		lp.setPassword(pass);
		logger.info("Password is Provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();		// close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
			{
				return false;
			}
			}
	
	@DataProvider(name="LoginData")	//It will take the data from Excel and store it in "Two Dimensional Array" and it(i.e. @DataProvider annotation) will return "Two Dimensional Array"
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/ExcelData.xlsx";
		
		int rownum = ExcelUtils.getRowCount(path, "Sheet1");
		int colcount = ExcelUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String[rownum][colcount];	// It is used to assign No of Rows and No of Cell from Excel sheet to Two dimensional Array of Login Data
										// Because no of rows and cells of Two dimensional array must be equal to No of rows and cells of Excel sheet
					// Hence Excel value assigned to loginData[][] from RHS TO LHS
		
		for(int i=1; i<=rownum; i++)	// i = 1; because 0th(i.e. 1st) row of Excel file contains Header hence we have ignored it.
		{
			for(int j=0; j<colcount; j++)
			{
				loginData[i-1][j] = ExcelUtils.getCellData(path, "Sheet1", i, j); // 1 , 0
			}
		}
		return loginData;
	}
}	