package com.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public static WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public static void WaitForRoomType() {
		WebElement roomType = driver.findElement(By.xpath("//div[@class='amber-Text-root amber-qaflwk'][1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf(roomType));

	}

	public void searchCountry() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.mouseMove(360, 160);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		// WebElement searchField=driver.findElement(By.id("main-search"));
		driver.findElement(By.xpath("//input[@class='amber-1k51dde']")).sendKeys("london");
		// JavascriptExecutor javaScript=(JavascriptExecutor) driver;
		// javaScript.executeScript("arguments[0].value='london'", searchField);
		// //searchField.sendKeys("london");
	}

	public PlacesPage clickOnLondon() throws InterruptedException {
		Thread.sleep(5000);
		WebElement londonCountry = driver.findElement(By.xpath("//div[@class='amber-Text-root amber-132f789'][1]"));
		londonCountry.click();
		return new PlacesPage(driver);
	}

	public NorthLodgePage swichToNorthlodgePage() throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(300, 0);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		return new NorthLodgePage(driver);

	}
}
