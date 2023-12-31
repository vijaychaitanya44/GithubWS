package com.qa.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class CucumberHooks {

	WebDriver driver;
	
	static ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return tDriver.get();
	}
	
	@Before(order=0)
	public void beforeScenario() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		tDriver.set(driver);
		System.out.println("This is BEFORE Scenario - FIRST ");
	}

	@After(order=0)
	public void afterScenario() {
		getDriver().quit();
		System.out.println("This is AFTER Scenario - LAST");
	}

	@BeforeStep(order=1)
	public void beforeStep() {
		System.out.println("Before STEP");
		try {
			getDriver().wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterStep(order=1)
	public void afterStep() {
		System.out.println("After STEP");
		try {
			getDriver().wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
