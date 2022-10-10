package com.application.pageactions;

import org.openqa.selenium.support.PageFactory;

import com.application.pageelements.ForgotPassPageElements;
import com.framework.webdriver.WebDriverClass;

public class ForgotPassPageActions extends ForgotPassPageElements{
	
	public void verifyWhetherForgotLoginInfoPageIsLaunched() {
		waitForElement(forgotPassPageHeader);
		log("PASS", "Forgot Login Information Page is Successfully Launched");
	}
	
	public static ForgotPassPageActions getActions() {
		return PageFactory.initElements(WebDriverClass.getDriver(), ForgotPassPageActions.class);
	}

}
