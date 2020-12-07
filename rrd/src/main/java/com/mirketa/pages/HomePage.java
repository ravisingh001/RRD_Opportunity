package com.mirketa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mirketa.utility.SyncElement;
import com.relevantcodes.extentreports.LogStatus;

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
	
	@FindBy(xpath="//a[@href='/003/e?sObjectName=Contact&save_new_url=%2F003%2Fe&navigationLocation=LIST_VIEW']")
	WebElement NewContactdrpdownval;
	
	@FindBy(xpath="//span[@class='slds-truncate'][contains(text(),'Accounts')]")
	WebElement Account;
	
	@FindBy(xpath="//one-app-nav-bar-item-root[9]/one-app-nav-bar-item-dropdown/div/one-app-nav-bar-menu-button/a")
	WebElement Contactdrpdown;
	
	@FindBy(xpath="//a[@title='Contacts']//span[contains(text(),'Contacts')]")
	WebElement ContactTab;
	
	@FindBy(xpath="//a[@title='Accounts']//span[contains(text(),'Accounts')]")
	WebElement AccountTab;
	

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
	
	public void clickOnAccountTab() throws InterruptedException {
		 // SyncElement.TobeClickable(driver, Accountdrpdown, 0);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", AccountTab);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		//ContactTab.click(); 
		Thread.sleep(3000);
     
		 }
	
	public void clickOnAccountdrpdown() throws InterruptedException {
		 // SyncElement.TobeClickable(driver, Accountdrpdown, 0);
		  Accountdrpdown.click(); 
		  Thread.sleep(3000);
        
		 }
	
	public void clickOnContactdrpdown() throws InterruptedException {
		 // SyncElement.TobeClickable(driver, Accountdrpdown, 0);
		  Contactdrpdown.click(); 
		  Thread.sleep(3000);
       
		 }
	
	public void clickOnContactTab() throws InterruptedException {
		 // SyncElement.TobeClickable(driver, Accountdrpdown, 0);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", ContactTab);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		//ContactTab.click(); 
		 // Thread.sleep(3000);
      
		 }

	public void clickonNewAccount()
	{
		  SyncElement.TobeClickable(driver, Newaccdrpdownval, 20);	
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", Newaccdrpdownval);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 //NewTeam.click(); 
	}
	
	public void clickonNewContact()
	{
		  SyncElement.TobeClickable(driver, NewContactdrpdownval, 20);	
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", NewContactdrpdownval);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 //NewTeam.click(); 
	}
	
	
public void clickOnAccounttab() throws InterruptedException {
		
		SyncElement.TobeClickable(driver, Account, 50);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Account);
		Thread.sleep(5000);
}
public void VerifyContactDropDown() throws InterruptedException {
	
	if(driver.findElements(By.xpath("//a[@title='Contacts']//span[contains(text(),'Contacts')]")).size()!= 0) {
		clickOnContactTab();
		Thread.sleep(3000);
		clickOnContactdrpdown();
		Thread.sleep(2000);
		clickonNewContact();
		}
		else {
			RRD_New_Case_page contactobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
			contactobj.clickOnMore_ToSelect_Opportunity();
			Thread.sleep(4000);
			contactobj.clickOnMore_ContactTab();
			Thread.sleep(4000);
			clickOnContactdrpdown();
			clickonNewContact();
		}
	
}




}
