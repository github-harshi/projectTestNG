package com.application.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class AccountOverviewPageElements extends WebCommons{
	
	@FindBy(xpath="//a[text()='Accounts Overview']")
	public WebElement accountOverviewLink;
	
	public By accountOverviewLinkLocator = By.xpath("//a[text()='Accounts Overview']");

}
