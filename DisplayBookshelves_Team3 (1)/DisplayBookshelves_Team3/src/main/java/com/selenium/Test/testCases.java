package com.selenium.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.Pages.DriverSetup;
//import com.selenium.Pages.browserSetup;
import com.selenium.Utilities.extentReport;


public class testCases {
	
	ExtentReports report = extentReport.getReportInstance();
	
	public static WebDriver driver;

	@BeforeSuite
	public void setup() {

		//driver = browserSetup.DriverSetup();
		driver = DriverSetup.getDriver();

	}
	
	@Test(priority = 0)
	public void popup() throws Exception {
		//report.attachReporter(htmlreporter);
		ExtentTest logger = report.createTest("Test 1", "Closing Popup");
		logger.log(Status.INFO, "Test for closing Popup");
		new urbanLadder(driver);
		logger.info("This will close the popup window");
		urbanLadder.closePopup();
		logger.pass("Passed");
	}
	
	@Test(priority = 1)
	public void bookshelves() throws Exception {
		//report.attachReporter(htmlreporter);
		ExtentTest logger = report.createTest("Test 2", "Open Bookshelves");
		logger.log(Status.INFO, "Test for opening bookshelevs");
		new urbanLadder(driver);
		logger.info("Redirected to booksheleves page");
		urbanLadder.clickBookshelves();
		logger.pass("Passed");
	}
	
	@Test(priority = 2)
	public void storage() throws Exception {
		//report.attachReporter(htmlreporter);
		ExtentTest logger = report.createTest("Test 3", "Select storage type");
		logger.log(Status.INFO, "Test for selecting bookshelves");
		new urbanLadder(driver);
		logger.info("Storage type open is selected");
		urbanLadder.storageType();
		logger.pass("Passed");
	}
	
	@Test(priority = 3)
	public void slider() throws Exception {
		//report.attachReporter(htmlreporter);
		ExtentTest logger = report.createTest("Test 4", "Adjust slider");
		logger.log(Status.INFO, "Test for moving slider");
		new urbanLadder(driver);
		logger.info("Price adjusted within range");
		urbanLadder.priceSlider();
		logger.pass("Passed");
	}
	
	@Test(priority = 4)
	public void checkbox() throws Exception {
		//report.attachReporter(htmlreporter);
		ExtentTest logger = report.createTest("Test 5", "Exclude - Checbox");
		logger.log(Status.INFO, "Test for enabling checkbox");
		new urbanLadder(driver);
		logger.info("Checkbox enabled");
		urbanLadder.excludeCheckbox();
		logger.pass("Passed");
	}
	
	@Test(priority = 5)
	public void printItems() throws Exception {
		//report.attachReporter(htmlreporter);
		ExtentTest logger = report.createTest("Test 6", "Print first three items");
		logger.log(Status.INFO, "Test for printing items");
		new urbanLadder(driver);
		logger.info("Items printed");
		urbanLadder.printFirstThree();
		logger.pass("Passed");
	}
	
	@Test(priority = 6)
	public void collections() throws Exception {
		//report.attachReporter(htmlreporter);
		ExtentTest logger = report.createTest("Test 7", "Collections");
		logger.log(Status.INFO, "Test for collections");
		new urbanLadder(driver);
		logger.info("Options displayed");
		urbanLadder.collections();
		logger.pass("Passed");
	}
	
	@Test(priority = 7)
	public void printSubmenu() throws Exception {
		//report.attachReporter(htmlreporter);
		ExtentTest logger = report.createTest("Test 8", "Sub menu - New Arrivals");
		logger.log(Status.INFO, "Test for Retriving submenu list");
		new urbanLadder(driver);
		logger.info("Listed the options");
		urbanLadder.printOptions();
		logger.pass("Passed");
	}
	
	@Test(priority = 8)
	public void giftCard() throws Exception {
		//report.attachReporter(htmlreporter);
		ExtentTest logger = report.createTest("Test 9", "Giftcards");
		logger.log(Status.INFO, "Test for filling form and validate");
		new urbanLadder(driver);
		logger.info("Validation done");
		urbanLadder.giftcards();
		logger.pass("Passed");
	}
	
	@AfterSuite
	public void closeBrowser() {
		
		report.flush();

		driver.quit();
	}

}
