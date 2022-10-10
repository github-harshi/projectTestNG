package com.application.test;

import org.testng.annotations.Test;

import com.application.pageactions.AccountOverviewPageActions;
import com.application.pageactions.ForgotPassPageActions;
import com.application.pageactions.LoginPageActions;
import com.application.pageactions.RegistrationPageActions;
import com.framework.webdriver.WebDriverClass;

public class ApplicationTest extends WebDriverClass{
	
	LoginPageActions loginPage;
	RegistrationPageActions regPage;
	ForgotPassPageActions forgotPassPage;
	AccountOverviewPageActions aoPage;
	
	@Test (priority=1,groups= {"Smoke"})
	public void verifyApplicationTitle() {
		loginPage = LoginPageActions.getActions();
		loginPage.launchApplication();
		loginPage.verifyTitle();
	}
	
	@Test(priority=2,groups= {"Sanity"})
	public void verifyApplicationLogo() {
		loginPage = LoginPageActions.getActions();
		loginPage.launchApplication();
		loginPage.verifyLogo();
	}
	
	@Test(priority=3,groups= {"Sanity"})
	public void verifyApplicationCaption() {
		loginPage = LoginPageActions.getActions();
		loginPage.launchApplication();
		loginPage.verifyCaption();
	}
	
	@Test(priority=4,groups= {"Smoke","Sanity"})
	public void verifyApplicationLoginPageHeader() {
		loginPage = LoginPageActions.getActions();
		loginPage.launchApplication();
		loginPage.verifyLoginSectionHeader();
	}
	
	@Test(priority=5,groups= {"Sanity","Regression"},dataProvider="loginData")
	public void verifyApplicationLogin(String username, String password) {
		loginPage = LoginPageActions.getActions();
		aoPage = AccountOverviewPageActions.getActions();
		loginPage.launchApplication();
		loginPage.updateUsernameAndPassword(username, password);
		loginPage.signInIntoApplication();
		aoPage.verifyWhetherLoginIsSuccessful();
		
	}
	
	@Test(priority=6,groups= {"Smoke","Sanity"})
	public void verifyRegistrationLink() {
		loginPage = LoginPageActions.getActions();
		loginPage.launchApplication();
		loginPage.verifyRegistrationLink();
	}
	
	@Test(priority=7,groups= {"Smoke","Sanity"})
	public void verifyForgotLoginInfoLink() {
		loginPage = LoginPageActions.getActions();
		loginPage.launchApplication();
		loginPage.verifyForgotLoginInfoLink();
	}
	
	@Test(priority=8,groups= {"Smoke","Sanity"})
	public void verifyRegistrationPage() {
		loginPage = LoginPageActions.getActions();
		regPage = RegistrationPageActions.getActions();
		loginPage.launchApplication();
		loginPage.verifyRegistrationLink();
		loginPage.launchRegistrationPage();
		regPage.verifyWhetherRegistrationPageIsLaunched();
	}
	
	@Test(priority=9,groups= {"Smoke","Sanity"})
	public void verifyForgotLoginInfoPage() {
		loginPage = LoginPageActions.getActions();
		forgotPassPage = ForgotPassPageActions.getActions();
		loginPage.launchApplication();
		loginPage.verifyForgotLoginInfoLink();
		loginPage.launchForgotLoginInfoPage();
		forgotPassPage.verifyWhetherForgotLoginInfoPageIsLaunched();
	}
	

}
