package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.inetBanking.testCases.BaseClass;
import com.inetBanking.testCases.TC_LoginTest_001;

public class ListenersClass extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		System.out.println("Failed Test Case Name: "+result.getTestName());
		
		TakesScreenshot tsc = (TakesScreenshot)driver;
		File source = tsc.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshots\\Snap.png");
		
		try {
			FileHandler.copy(source, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		
		System.out.println("Skipped Test Case Name: "+result.getTestClass());
		
		TakesScreenshot tsc = (TakesScreenshot)driver;
		File source = tsc.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshots\\Snap.png");
		
		try {
			FileHandler.copy(source, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	
		
}
