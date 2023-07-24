package com.qa.app.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public static WebDriver startBrowser(String browser, String appURL) {
		WebDriver driver =null;

		if (browser.contains("chrome") || browser.contains("Google") || browser.contains("GC")) {
			driver = new ChromeDriver();

		} else if (browser.contains("firefox") || browser.contains("FF") || browser.contains("Mozilla")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		
		//driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		return driver;
	}
}
