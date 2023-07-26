package com.qa.app.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static  ExtentReports getInstance() {
		
		if(extent==null) {
			extent= createInstance();
			return extent;
		}
		return extent;
	}
	
	public static  ExtentReports createInstance() {
		
		ExtentSparkReporter sparkReporter = new  ExtentSparkReporter("D:/GithubWS/page_obj_mod/extentreports/report1.html");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Automation Sprint-1");
		sparkReporter.config().setDocumentTitle("Sprint report -1");
		
		ExtentReports ext = new ExtentReports();
		ext.attachReporter(sparkReporter);
		
		return ext;
		
	}

}
