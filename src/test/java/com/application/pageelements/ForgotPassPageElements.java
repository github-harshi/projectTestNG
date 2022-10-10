package com.application.pageelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.commons.WebCommons;

public class ForgotPassPageElements  extends WebCommons{
	
	public By forgotPassPageHeader = By.xpath("//h1[@class='title']");
	
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='address.street']")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='address.city']")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='address.state']")
	private WebElement state;
	
	@FindBy(xpath="//input[@id='address.zipCode']")
	private WebElement zipCode;
	
	@FindBy(xpath="//input[@id='ssn']")
	private WebElement ssn;
	
	@FindBy(xpath="//input[@value='Find My Login Info']")                                     
	private WebElement findLoginInfoBtn;

}
