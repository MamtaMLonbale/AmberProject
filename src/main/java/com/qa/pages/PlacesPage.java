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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlacesPage extends HomePage {
	public PlacesPage(WebDriver driver) {
		super(driver);

	}

	public void clickOnFilter() throws InterruptedException {
		Thread.sleep(5000);
		WebElement filter = driver.findElement(
				By.xpath("//img[@src='https://prod-static-assets.amberstudent.com/images/funnel.svg'][1]"));
		JavascriptExecutor javasScript = (JavascriptExecutor) driver;
		javasScript.executeScript("arguments[0].click();", filter);
	}

	public void checkOnPrivateRoom() {
		WebElement privateRoom = driver.findElement(By.xpath("//div[contains(text(),'Private Room')]"));
		// WebElement
		// privateRoom=driver.findElement(By.xpath("//input[@id='mantine-iaxr4fpbb']"));
		// WebElement
		// privateRoom=driver.findElement(By.xpath("//div[@class='amber-Checkbox-labelWrapper
		// amber-1fxqhsh'][2]"));
		JavascriptExecutor javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("arguments[0].click()", privateRoom);
	}

	public void checkOnPrivatBathRoom() {
		WaitForRoomType();
		// WebElement
		// roomType=driver.findElement(By.xpath("//div[@class='amber-Text-root
		// amber-qaflwk'][1]"));
		// WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
		// wait.until(ExpectedConditions.visibilityOf(roomType));
		WebElement privateBathRoom = driver.findElement(By.xpath("//label[contains(text(),'Private Bathroom')]"));
		// WebElement
		// privateBathRoom=driver.findElement(By.xpath("//*[contains(@class,'amber-Checkbox-label
		// amber-1jf3re')][4]"));
		// WebElement
		// privateBathRoom=driver.findElement(By.xpath("//*[contains(@class,'amber-Checkbox-label
		// amber-1jf3re')]//ancestor::div[32]"));
		// WebElement
		// privateBathRoom=driver.findElement(By.xpath("//input[id='mantine-lcu9vxugk']"));
		// WebElement
		// privateBathRoom=driver.findElement(By.xpath("//label[@class='amber-Checkbox-label
		// amber-1jf3re'][4]"));
		privateBathRoom.click();

	}

	public void clickOnShowResult() {
		WaitForRoomType();
		WebElement showResult = driver
				.findElement(By.xpath("//button[@class='amber-UnstyledButton-root amber-Button-root amber-1abcetc']"));
		showResult.click();
	}

	public NorthLodgePage openNewTabForSearch() throws AWTException, InterruptedException {
		WebElement londonText = driver.findElement(By.xpath("//a[@href=\"/places/search/london-1811028205760\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf(londonText));
		// JavascriptExecutor javaScript=(JavascriptExecutor) driver;
		// javaScript.executeScript("window.open()");
		WebElement secondSearchResult = driver
				.findElement(By.xpath("//a[@href=\"/places/north-lodge-london-1710102555905\"]"));
		Actions action = new Actions(driver);
		action.contextClick(secondSearchResult).perform();
		// action.moveByOffset(-400, -800).build().perform();
		Robot robot = new Robot();
		robot.mouseMove(500, 500);
		action.click().perform();
		Thread.sleep(5000);
		action.release().build().perform();

		// robot.keyPress(InputEvent.);
		// robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		// action.keyUp(Keys.ARROW_UP).perform();
		// action.keyDown(Keys.ARROW_UP).perform();
		// return new NorthLodgePage(driver);
		return new NorthLodgePage(driver);

		// action.keyDown(Keys.ARROW_UP).perform();
		// action.keyUp(Keys.ARROW_UP).perform();
	}

	public String GetNorthLodgeTitle() {
		WebElement northLodge = driver.findElement(By.xpath("//a[@href=\"/places/north-lodge-london-1710102555905\"]"));
		// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
		// wait.until(ExpectedConditions.invisibilityOf(northLodge));

		String northLogdeText = northLodge.getText();
		return northLogdeText;
	}

}
