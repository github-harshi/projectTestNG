package com.framework.webdriver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.framework.reports.ReportsClass;
import com.framework.utilities.ReadExcel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass extends ReportsClass {

	// All the methods related to browser setup and tear-down

	private static WebDriver driver = null;
	public static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();

	//method to launch and maximize the browser window
	@BeforeMethod(alwaysRun = true)
	@Parameters(value = "browser")
	public void setupBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			Assert.fail("Inavlid Browser Selected");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		setDriver(driver);
		
	}

	//method to close browser window
	@AfterMethod(alwaysRun = true)
	public void teardownBrowser() {
		getDriver().quit();
	}
	
	public static synchronized void setDriver(WebDriver driver) {
		thread.set(driver);
	}
	
	public static synchronized WebDriver getDriver() {
		return thread.get();
	}
	
	
	@DataProvider(name="loginData")
	public String [][] testdata(){
		String [][] data =ReadExcel.readData("TestData.xlsx", "Sheet1");
		return data;
	}

}
