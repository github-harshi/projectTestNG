package com.application.pageactions;

import org.openqa.selenium.support.PageFactory;

import com.application.pageelements.AccountOverviewPageElements;
import com.framework.webdriver.WebDriverClass;

public class AccountOverviewPageActions extends AccountOverviewPageElements {
	
	public void verifyWhetherLoginIsSuccessful() {
		waitForElement(accountOverviewLinkLocator);
		log("PASS", "Application Login is Successful");
	}
	
	public static AccountOverviewPageActions getActions() {
		return PageFactory.initElements(WebDriverClass.getDriver(), AccountOverviewPageActions.class);
	}

}
