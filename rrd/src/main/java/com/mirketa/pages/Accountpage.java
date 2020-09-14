package com.mirketa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mirketa.utility.SyncElement;

public class Accountpage {
	
	public WebDriver driver;

	

	public Accountpage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//span[@class='itemLabel slds-truncate slds-show--inline-block slds-m-left--xx-small' and @title='New Account']")
	WebElement NewAccount;
	
	@FindBy(xpath="//label//span[contains(text(),'Account Name')]//following-sibling::span[contains(@class,'required')][contains(text(),'*')]//following::input[@class=' input'][1]")
	WebElement AccountName;
	
	@FindBy(xpath="//span[contains(text(),'Rating')]//following::div[@class='uiMenu'][1]")
	WebElement Rating;
	
	@FindBy(xpath="//li[@class='uiMenuItem uiRadioMenuItem']")
	List<WebElement> Picklistrating;
	
	
	@FindBy(xpath="//button[contains(@class,'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton')]//span[contains(@class,'label bBody')][contains(text(),'Save')]")
     WebElement Save;
	
	public void clickOnNewAccount() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, NewAccount, 20);
		NewAccount.click();
		Thread.sleep(2000);
	}
	
	public void ClickonAccountName(String Account) throws InterruptedException
	{
		SyncElement.isElementPresnt(driver, AccountName, 20);
		AccountName.sendKeys(Account);
		 Thread.sleep(2000);
	}
	
	public void clickingRating() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, Rating, 20);
		Rating.click();
		Thread.sleep(2000);
	}
	
	public void pickrating(String Ratingval) throws InterruptedException
	{
		for(int i=0;i<Picklistrating.size();i++)
		{
			String pickratingval=Picklistrating.get(i).getText();
			
			if(pickratingval.contains(Ratingval))
			{
				Picklistrating.get(i).click();
			}
		}
		 Thread.sleep(2000);
	}
	
	public void clickonsave() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, Save, 20);
		Save.click();
		Thread.sleep(4000);
	}

}
