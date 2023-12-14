package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchAmberSite {
	public WebDriver driver=null;
	public HomePage amberLaunch()
	{
		WebDriverManager.chromedriver().driverVersion("109").setup();
		driver=new ChromeDriver();
		driver.get("https://amberstudent.com");
		driver.manage().window().maximize();
		return new HomePage(driver);
	}
}
