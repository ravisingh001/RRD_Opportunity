package com.mirketa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Teamlistingpage {
WebDriver driver;
	
	public void TeamDetailspage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	@FindBy(xpath="(//lightning-formatted-text[@data-output-element-id='output-field'])[1]")
	public WebElement teamInfo;
	
	@FindBy(xpath="//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']//lightning-icon[@class='slds-icon-utility-down slds-icon_container']")
	WebElement dropdown;
	
	
	
	
	
	 
	
	

}
