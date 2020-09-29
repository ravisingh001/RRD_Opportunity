package com.mirketa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mirketa.utility.SyncElement;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//span[@class='slds-truncate'][contains(text(),'RRD')]")
	WebElement RRDLabel;

	@FindBy(xpath = "//span[contains(text(),'Step 1-Configuration')]")
	WebElement Step1Configuration;

	@FindBy(xpath = "//span[@class='slds-truncate'][contains(text(),'Step 2-Define Teams')]")
	WebElement Step2DefineTeam;
	
	@FindBy(xpath="//one-app-nav-bar-item-root[8]//one-app-nav-bar-item-dropdown[1]//div[1]//one-app-nav-bar-menu-button[1]//a[1]//lightning-icon[1]//lightning-primitive-icon[1]//*[local-name()='svg']")
	WebElement Accountdrpdown;
	
	@FindBy(xpath="//a[@href='/001/e?sObjectName=Account&save_new_url=%2F001%2Fe&navigationLocation=LIST_VIEW']")
	WebElement Newaccdrpdownval;

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean RRDisDisplayed() {
		return RRDLabel.isDisplayed();
	}

	public void clickOnStep1Configuration() throws InterruptedException {
		
		SyncElement.TobeClickable(driver, Step1Configuration, 50);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Step1Configuration);
		Thread.sleep(15000);
		
	}

	public void clickOnStep2DefineTeam() {
		
		SyncElement.TobeClickable(driver, Step1Configuration, 50);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Step2DefineTeam);
		
	}
	
	public void clickOnAccountdrpdown() throws InterruptedException {
		 // SyncElement.TobeClickable(driver, Accountdrpdown, 0);
		  Accountdrpdown.click(); 
		  Thread.sleep(3000);
        
		 }

	public void clickonNewAccount()
	{
		  SyncElement.TobeClickable(driver, Newaccdrpdownval, 20);	
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", Newaccdrpdownval);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 //NewTeam.click(); 
	}

}
