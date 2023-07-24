package com.qa.app.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qa.app.loggers.LoggingUtil;

public class BaseClass {
	public WebDriver driver;

	@BeforeMethod
	public void setUpBrowser() {
		
		driver = 
				BrowserFactory.startBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("url"));
	}

	@AfterMethod

	public void closeBrowser() {

		driver.quit();
	}

}
