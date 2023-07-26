package com.qa.app.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestNGITestListner implements ITestListener{
	
	ExtentReports ext = ExtentManager.getInstance();
	ThreadLocal <ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		ExtentTest extent = ext.createTest(result.getMethod().getMethodName());
		parentTest.set(extent);
	   
	  }

	 
	  public void onTestSuccess(ITestResult result) {
	   parentTest.get().pass("Passed");
	  }

	  
	  public void onTestFailure(ITestResult result) {
	   parentTest.get().fail("Failed: "+result.getThrowable().getMessage());
	  }

	 
	  public void onTestSkipped(ITestResult result) {
		  parentTest.get().skip("Skipped: "+result.getThrowable().getMessage());
	  }

	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	   
	  }

	  
	  public void onTestFailedWithTimeout(ITestResult result) {
	  
	  }

	 
	  public void onStart(ITestContext context) {
	  
	  }

	 
	  public void onFinish(ITestContext context) {
		  ext.flush();
	  }

}
