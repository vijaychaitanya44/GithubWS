package com.qa.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By user = By.name("username");
	By pass = By.xpath("//input[@type='password']");
	By btn = By.xpath("//button[normalize-space()='Login']");

	public void loginToApplication(String username,String password) {
		
		driver.findElement(user).sendKeys(username);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(btn).click();
	}
	
	
}
