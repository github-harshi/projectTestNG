package com.application.pageactions;

import org.openqa.selenium.support.PageFactory;

import com.application.pageelements.RegistrationPageElements;
import com.framework.webdriver.WebDriverClass;

public class RegistrationPageActions extends RegistrationPageElements{
	
	public void verifyWhetherRegistrationPageIsLaunched() {
		waitForElement(regTitleLocator);
		log("PASS", "Registration Page is Successfully Launched");
	}
	
	public static RegistrationPageActions getActions() {
		return PageFactory.initElements(WebDriverClass.getDriver(), RegistrationPageActions.class);
	}

}
