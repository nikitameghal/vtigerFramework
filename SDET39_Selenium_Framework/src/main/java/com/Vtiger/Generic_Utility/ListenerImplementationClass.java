package com.Vtiger.Generic_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener
{

	public void onTestFailure(ITestResult result) 
	{
		String testname = result.getMethod().getMethodName();
		System.out.println(testname+"-----Execute and I am LISTENING------");
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		try
		{
			File destFile= new File("./data/photo/screenshot"+testname+".png");
			FileUtils.copyFile(srcFile, destFile);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			
		}
		
		
		
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
