package com.selenium.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class extentReport {
public static ExtentReports report;
	
	public static ExtentReports getReportInstance() {
		
	if(report== null) {
		
		String reportName = timeInstance.getname();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\report\\"+reportName+".html");
		report = new ExtentReports(); 
		report.attachReporter(htmlReporter);
		
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Environment", "UAT");
		report.setSystemInfo("Browser", "Chrome");
		
		htmlReporter.config().setDocumentTitle("Hackathon project");
		htmlReporter.config().setReportName("Display Bookshelves Automation");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTimeStampFormat("dd MMM, yyyy  HH:mm:ss");
		
	}
	return report;
	}
}
