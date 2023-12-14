package com.qa.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LaunchAmberSite;
import com.qa.pages.NorthLodgePage;
import com.qa.pages.PlacesPage;

public class verifyAmber {
	LaunchAmberSite lunchSite = new LaunchAmberSite();
	HomePage homePage;
	PlacesPage places;
	NorthLodgePage northLodge;

	@BeforeTest
	public void lunchAmberSite() {
		homePage = lunchSite.amberLaunch();
	}

	@Test(priority = 0)
	public void verifyTitleOfLodge() throws InterruptedException, AWTException {
		homePage.searchCountry();
		places = homePage.clickOnLondon();
		places.clickOnFilter();
		places.checkOnPrivateRoom();
		places.checkOnPrivatBathRoom();
		places.clickOnShowResult();
		northLodge = places.openNewTabForSearch();
		places = northLodge.switchToHomePage();
		String ExpectedNorthLodgeText = "North lodge";
		String actualNorthLodgeText = places.GetNorthLodgeTitle();
		Assert.assertEquals(actualNorthLodgeText, ExpectedNorthLodgeText, "Incorrect North Lodge Text");
	}

	@Test(priority = 1, dependsOnMethods = { "verifyTitleOfLodge" }, alwaysRun = true)
	public void verifyAddressOfLodge() throws InterruptedException, AWTException {
		northLodge = homePage.swichToNorthlodgePage();
		northLodge.scrollNorthLodgePage();

		// northLodge=places.openNewTabForSearch();

		// northLodge.getAddress();
		// String actualAddress=northLodge.getAddress();
		// String expectedAddress="london";
		// Assert.assertEquals(actualAddress, expectedAddress,"Incorrect North lodge
		// address");

	}

}
