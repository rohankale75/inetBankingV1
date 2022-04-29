package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

// This class is used to get/fetch the data from config.properties file and then send this data to Base Class
public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {	// Constructor is used to load the complete file
		
		File src = new File("./Configurations/config.properties");
		
		try {	
			FileInputStream fis = new FileInputStream(src);		//FileInputStream is used to open the file in "reading mode"
			
			pro = new Properties();		//Object of Properties (It is a Java Class)
			pro.load(fis);	//It will load the file (config.properties) at run time
		
		}
		catch (Exception e) {	// This "try-catch" block is used to handle the exception when the config.properties file is not found in given location
			System.out.println("Exception for Config.properties file from ReadConfig.java class is: "+e.getMessage());
		}
		
		
	}
//	To perform action on each variables present in the config.properties file, we have to create "Action methods" for each variable 
//	Every method will get the value and will return the same value
	
	public String getApplicationURL() {		// This and below methods will read data from config.properties file and return it.
		
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
	}
	
	public String getEdgePath() {
		
		String edgePath = pro.getProperty("edgePath");
		return edgePath;
	}
	
	public String getFirefoxPath() {
		
		String firefoxPath = pro.getProperty("firefoxPath");
		return firefoxPath;
	}
}
