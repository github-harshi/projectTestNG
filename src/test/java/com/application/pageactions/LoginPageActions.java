package com.application.pageactions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.pageelements.LoginPageElements;
import com.framework.utilities.ReadProp;
import com.framework.webdriver.WebDriverClass;


public class LoginPageActions extends LoginPageElements{
	
	public void launchApplication() {
		driver.get(ReadProp.readData("Config.properties", "URL"));
		log("PASS","Application Launched Successfully");
	}
	
	public void verifyTitle() {
		Assert.assertEquals(getWindowTitle(), ReadProp.readData("Config.properties", "Title"));
		log("PASS","Application Title is Matching");
	}
	
	public void verifyLogo() {
		Assert.assertTrue(isElementDisplayed(logo));
		log("PASS","Application Logo is Displayed");
	}
	
	public void verifyCaption() {
		Assert.assertEquals(getTextValue(caption), ReadProp.readData("Config.properties", "Caption"));
		log("PASS","Application Caption is Matching");
	}
	
	public void verifyLoginSectionHeader() {
		Assert.assertEquals(getTextValue(loginSectionHeader), ReadProp.readData("Config.properties", "LoginHeader"));
		log("PASS","Application Login Header is Matching");
	}
	
	public void updateUsernameAndPassword(String username,String password) {
		enterInfo(usernameTextbox, username);
		enterInfo(passwordTextbox, password);
		log("PASS","Updated User Credentials Successfully");
	}
	
	public void signInIntoApplication() {
		clickOnElement(loginButton);
		log("PASS","Clicked on SignIn/Login Button");
	}
	
	public void verifyRegistrationLink() {
		Assert.assertTrue(isElementDisplayed(registerLink));
		Assert.assertTrue(isElementEnabled(registerLink));
		log("PASS","Registartion Link is Displayed");
	}
	
	public void verifyForgotLoginInfoLink() {
		Assert.assertTrue(isElementDisplayed(forgotLoginLink));
		Assert.assertTrue(isElementEnabled(forgotLoginLink));
		log("PASS","Forgot Login Information Link is Displayed");
	}
	
	public void launchRegistrationPage() {
		clickOnElement(registerLink);
	}
	
	public void launchForgotLoginInfoPage() {
		clickOnElement(registerLink);
	}
	
	public static LoginPageActions getActions() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPageActions.class);
	}

}
