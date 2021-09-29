package com.selenium.Pages;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.selenium.Utilities.readProperty;

public class DriverSetup {
	
	public static WebDriver driver;
	public static String userDir = System.getProperty("user.dir");
	static String Browser;

	public static WebDriver getDriver() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Choose Browser \r\n\t 1.Google Chrome \r\n\t 2.Mozilla Firefox \r\n");
	
		int choosedBrowser = scanner.nextInt();
		if(choosedBrowser ==1){
		 Browser = "Chrome";
		}
		else{
			Browser = "Firefox";
		}

		
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", userDir + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", userDir + "\\driver\\geckodriver.exe");
			FirefoxOptions fo = new FirefoxOptions();
			driver = new FirefoxDriver(fo);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
			driver.get(readProperty.getKey("url"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		
		return driver;
	}
}
