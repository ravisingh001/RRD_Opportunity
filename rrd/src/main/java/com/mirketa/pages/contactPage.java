package com.mirketa.pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mirketa.utility.SyncElement;

public class contactPage {
	
public WebDriver driver;

	

	public contactPage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	
	@FindBy(xpath="//span[@class='itemLabel slds-truncate slds-show--inline-block slds-m-left--xx-small' and @title='New Contact' ]")
    WebElement NewContact;
	
	@FindBy(xpath="//div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']//div[@class='uiPopupTrigger']//a[@class='select' and @role=\"button\" and contains(text(),'--None--')]")
	WebElement clicksaluation;
	
	@FindBy(xpath="//li[@class='uiMenuItem uiRadioMenuItem']")
	List<WebElement> picksaluation;
	
	@FindBy(xpath="//input[@class='firstName compoundBorderBottom form-element__row input']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")
	WebElement LastName;
	
	@FindBy(xpath="//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']//span[contains(@class,'label bBody')][contains(text(),'Save')]")
	WebElement Save;
	
	public void clickOnContact() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, NewContact, 20);
		NewContact.click();
		Thread.sleep(3500);
	}
	
	public void clickonsaluation() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, clicksaluation, 20);
		clicksaluation.click();
		Thread.sleep(1500);
		
	}
	
	public void picksaluationfromlist(String saluationtest) throws InterruptedException
	{
		for(int i=0;i<picksaluation.size();i++)
		{
			String pickval=picksaluation.get(i).getText();
			
			if(pickval.contains(saluationtest))
			{
				picksaluation.get(i).click();
			}
		}
		Thread.sleep(2500);
		
		
	}
	
	public void sendfirstname(String firstname) throws InterruptedException
	{
		SyncElement.isElementPresnt(driver, Firstname, 30);
		Firstname.sendKeys(firstname);
		Thread.sleep(1500);
	}
	
	public void sendLastname(String lastName) throws InterruptedException
	{
		SyncElement.isElementPresnt(driver, LastName, 30);
		LastName.sendKeys(lastName);
		Thread.sleep(1000);
	}
	
	
	public void clickonsave() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, Save, 30);
		Save.click();
		Thread.sleep(4000);
	}
	
}

