package com.inetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;


@Listeners(com.inetBanking.utilities.ListenersClass.class)
public class BaseClass {

//	Here setUp (@Before) and tearDown (@After) methods are declared in BaseClass
	
//	========================================================================================================================================================================
	
	ReadConfig rc = new ReadConfig();	// As ReadConfig class is in another package which is "Utility Package" hence we have to import this ReadConfig Class
										// Reason is "BaseClass" don't know ReadConfig class because Packages of both classes are different
	
	public String baseURL = rc.getApplicationURL();
	public String username = rc.getUsername();
	public String password = rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;

//	========================================================================================================================================================================

	@Parameters("browser")		// It will take input from "testNG.xml" file
	@BeforeClass
	public void setUp(String browser) {		// This parameter (String browser) will take input from "@Parameters" annotation's parameter
		
//		Log4j is required for every test case hence it is declared in Base Class
		logger = Logger.getLogger("ebanking");	// Parameter = name of your project which is "ebanking"
		PropertyConfigurator.configure("Log4j.properties");
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", rc.getEdgePath());
			driver = new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
//	===============================================================================================================================================================================================

//	Common Methods to be used for any test cases are declared below
	
//	===============================================================================================================================================================================================

//	In Java, "RandomStringUtils" is the predefined class in java 
	public String randomEmail() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(5);	//This method will generate 5 random letters from A to Z. 
		return generatedString;
	}
	
//	Method to generate Random Number
	public String randomNumber() {
		
		String generatedNumber = RandomStringUtils.randomNumeric(15);	// This method will generate random numbers upto 15 digits
		return generatedNumber;
		
	}
	
//	GitHub Remote Repository link: https://github.com/rohankale75/inetBankingV1.git
	
//	Watch 2nd video from 39:00:00 for "run.bat" file command
//	Watch 2nd video from 43:58:00 for "Jenkins" execution 
//	Watch 2nd video from 01:37:27 for "Git & GitHub" i.e. Maintaince part (Theory Part)
//	Watch 2nd video from 01:57:00 for "Git & GitHub" i.e. Maintaince part (Practical Part)
}
