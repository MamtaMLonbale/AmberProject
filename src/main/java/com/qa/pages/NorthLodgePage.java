package com.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NorthLodgePage extends HomePage {

	public NorthLodgePage(WebDriver driver) {
		super(driver);
	}

	public PlacesPage switchToHomePage() throws AWTException, InterruptedException {
		Thread.sleep(5000);

		Robot robot = new Robot();
		robot.mouseMove(10, 10);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		return new PlacesPage(driver);
	}

	public void scrollNorthLodgePage() throws InterruptedException {
		System.out.println("Scrolling web page");
		Thread.sleep(5000);
		JavascriptExecutor javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("window.scrollBy(0,800);");
		System.out.println("Scrolled web page");
	}

	public void getAddress() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);

		// WebElement address=driver.findElement(By.xpath("//div[@class='amber-Text-root
		// amber-1gvc0gz']"));
		// return address.getText();

	}

}
