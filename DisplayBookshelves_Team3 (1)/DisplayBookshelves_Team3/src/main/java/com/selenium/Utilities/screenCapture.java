package com.selenium.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class screenCapture {
	
		public static ExtentTest logger;
		public static TakesScreenshot takeScreenshot;
		static int i = 0;

		public static void takeScreenShot(WebDriver driver, String name){
			
			takeScreenshot = ((TakesScreenshot) driver);
			File sourceFile = (File) takeScreenshot.getScreenshotAs(OutputType.FILE);

			File destFile = new File(System.getProperty("user.dir")+"\\screenshots\\"+i+" "+name +".png");
			i++;
			try {
				FileUtils.copyFile(sourceFile,destFile);
				//logger.addScreenCaptureFromPath(System.getProperty("user.dir")+ "\\Screenshots" + Utils.getTimeInstance() +".png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}

