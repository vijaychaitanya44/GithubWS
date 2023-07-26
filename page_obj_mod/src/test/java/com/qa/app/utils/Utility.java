package com.qa.app.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import com.qa.app.waits.CustomWaits;

public class Utility {

	static WebDriver driver;

	public static WebDriver getBrowserInstance() {
		return driver;
	}

	public void clickElement(WebDriver driver, By locator) {

		try {
			driver.findElement(locator).click();
		} catch (Exception e) {

			try {
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(locator)).click().build().perform();

			} catch (Exception e2) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;

				jse.executeScript("arguments[0].click();", driver.findElement(locator));

			}
		}

	}

	public void enterText(WebDriver driver, By loactor, String value) {

		driver.findElement(loactor).sendKeys(value);
	}

	public static Alert handleAlert(WebDriver driver, By localtor) {

		Alert ale = null;

		for (int i = 0; i < 15; i++) {

			try {
				ale = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				CustomWaits.waitForSeconds(i);
			}
		}
		return ale;
	}

	public static Alert handleAlert(WebDriver driver, By Locator, int time) {
		Alert ale = null;

		for (int i = 0; i < time; i++) {
			try {
				ale = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				CustomWaits.waitForSeconds(time);
			}
		}
		return ale;
	}

	public static void takeScreenShot(WebDriver driver) {

		try {
//			TakesScreenshot sc = (TakesScreenshot) driver;
//			File source = sc.getScreenshotAs(OutputType.FILE);
//			File dest = new File("D:/GithubWS/page_obj_mod/screenshots/text.png");
//			FileUtils.copyFile(source, dest);

			((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File("D:/GithubWS/page_obj_mod/screenshots/text.png"));

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}

	}

	public static void scrollIntoView(WebDriver driver, By locator) {
		try {
			Actions act = new Actions(driver);
			act.scrollToElement(driver.findElement(locator)).perform();
		} catch (Exception e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
		}
	}
}
