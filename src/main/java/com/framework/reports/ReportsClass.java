package com.framework.reports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsClass {
	
	//This class will have all the methods to prepare report
		
	public static ExtentReports extent = null;
	public static ExtentTest logger = null;
	
	@BeforeSuite(alwaysRun=true)
	public static void setupReport() {
		ExtentHtmlReporter html = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\AutomationTestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(html);		
		extent.setSystemInfo("Project Name", "Parabank");
	}
	
	
	public static void startReporting(String testcase) {
		logger = extent.createTest(testcase);
	}
	
	@AfterSuite(alwaysRun=true)
	public static void stopReporting() {
		 extent.flush();
	}

}
