package com.framework.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.reports.ReportsClass;
import com.framework.utilities.ProjectConstants;
import com.framework.webdriver.WebDriverClass;

public class WebCommons {

	// All common methods to perform actions on web elements

	public WebDriver driver = WebDriverClass.getDriver();
	Actions action = new Actions(driver);

	// Scroll-down till element
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("argumets[0].scrollIntoView()", element);
	}

	// Click on the element
	public void clickOnElement(WebElement element) {
//		scrollToElement(element);
		element.click();
	}

	// Java-script click on the element
	public void jsClickOnElement(WebElement element) {
		scrollToElement(element);
		((JavascriptExecutor) driver).executeScript("argumets[0].click()", element);
	}

	// Enter value in text-box
	public void enterInfo(WebElement element, String value) {
//		scrollToElement(element);
		element.clear();
		element.sendKeys(value);
	}

	// Select check-box
	public void selectCheckbox(WebElement element) {
		scrollToElement(element);
		if (!element.isSelected())
			element.click();
	}

	// Select option from Drop-down
	public void selectOption(WebElement element, String method, String option) {
		Select s = new Select(element);
		if (method.equalsIgnoreCase("Index")) {
			s.selectByIndex(Integer.parseInt(option));
		} else if (method.equalsIgnoreCase("value")) {
			s.selectByValue(option);
		} else if (method.equalsIgnoreCase("VisibleText")) {
			s.selectByVisibleText(option);
		}
	}

	// Perform double click
	public void doubleClick(WebElement element) {
		scrollToElement(element);
		action.doubleClick(element).perform();
	}

	// Perform right click
	public void rightClick(WebElement element) {
		scrollToElement(element);
		action.contextClick(element).perform();
	}

	// Perform mouse hover
	public void mouseHover(WebElement element) {
		scrollToElement(element);
		action.moveToElement(element).perform();
	}

	// Implicit Wait
	public void implictWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ProjectConstants.WAIT_TIME));
	}

	// Wait for element -Explicit wait
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ProjectConstants.WAIT_TIME));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ProjectConstants.WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Fluent wait
	public void fluentWait(By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(ProjectConstants.WAIT_TIME)).pollingEvery(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}

	// Take Screenshot of WebPage
	public String takeScreenshotOfWebPage(String name) {
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + name + UniqueId() + ".png";
		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	// Take Screenshot of WebElement
	public String takeScreenshotOfWebElement(WebElement element, String name) {
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + name + UniqueId() + ".png";
		try {
			File file = element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	// Generate random unique id
	public String UniqueId() {
		String uniqueId = new SimpleDateFormat("ddMMyyyyhhmmss").format(Calendar.getInstance().getTime());
		return uniqueId;
	}
	
	// Get the title from window
	public String getWindowTitle() {
		return driver.getTitle();
	}
	
	//Get the text value from the element
	public String getTextValue(WebElement element) {
		return element.getText();
	}
	
	//Get the attribute value
	public String getAttributeValue(WebElement element,String attribute) {
		return element.getAttribute(attribute);
	}
	
	//Browser actions
	public void browserAction(String action) {
		if(action.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}else if(action.equalsIgnoreCase("back")) {
			driver.navigate().back();
		}else if(action.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}
	}
	
	//Print custom messages in the report
	public void log(String status, String message) {
		if(status.equalsIgnoreCase("PASS")) {
			ReportsClass.logger.pass(message);
		}else if(status.equalsIgnoreCase("FAIL")) {
			ReportsClass.logger.fail(message);
		}else if(status.equalsIgnoreCase("INFO")) {
			ReportsClass.logger.info(message);
		}else if(status.equalsIgnoreCase("WARNING")) {
			ReportsClass.logger.warning(message);
		}
	}
	
	// Element Displayed Status
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	// Element Enabled Status
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}
}
