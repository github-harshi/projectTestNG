package com.framework.listners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.commons.WebCommons;
import com.framework.reports.ReportsClass;

public class TestListners extends ReportsClass implements ITestListener {
	
	//Actions to be performed based on the test execution and test result

	public void onTestStart(ITestResult result) {
		startReporting(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.pass(result.getMethod().getMethodName()+" is Successfully Executed");
		extent.flush();
	}

	public void onTestFailure(ITestResult result) {
		logger.fail(result.getMethod().getMethodName()+" is Failed");
		logger.fail(result.getThrowable().getMessage());
		try {
			logger.addScreenCaptureFromPath(new WebCommons().takeScreenshotOfWebPage(result.getMethod().getMethodName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {
		logger.fail(result.getMethod().getMethodName()+" is Skipped");
		logger.fail(result.getThrowable().getMessage());
		try {
			logger.addScreenCaptureFromPath("C:\\Training\\Frameworks\\ProjectMorningSelenium\\Screenshots\\Logo.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.flush();
	}

}
