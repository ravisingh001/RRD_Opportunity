package com.mirketa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mirketa.utility.SyncElement;

public class AccountListingpage {
	
	
public WebDriver driver;

	

	public AccountListingpage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//input[@class='slds-input' and @placeholder='Search this list...']")
	WebElement Searchfield;
	
	@FindBy(xpath="//button[@name='refreshButton']//lightning-primitive-icon")
    WebElement refreshbtn;
	
	@FindBy(xpath="//a[starts-with(@class,'slds-truncate outputLookupLink slds-truncate outputLookupLink')]")
	WebElement Accountnamelink;
	
	public void fetchAccountName(String Accountname) throws InterruptedException	
	{
		SyncElement.TobeClickable(driver, Searchfield, 30);
		Searchfield.clear();
		Searchfield.sendKeys(Accountname);
		Thread.sleep(5000);
		refreshbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		Thread.sleep(2000);
	}
	
	public void clickonAccountName() throws InterruptedException
	{
		 SyncElement.TobeClickable(driver,Accountnamelink, 30);
		 Accountnamelink.click();
		 Thread.sleep(3000);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		
	}
	
	

	
	
}
