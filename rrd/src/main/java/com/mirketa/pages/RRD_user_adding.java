package com.mirketa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mirketa.utility.SyncElement;

public class RRD_user_adding {
	public WebDriver driver;

	

		public RRD_user_adding(WebDriver ldriver) {
			
			this.driver = ldriver;
		}
	
		/*@FindBy(xpath="//a[@title='Round Robin Users']")
		WebElement Round_Robin_user;
		
		
		@FindBy(xpath="//a[@class='slds-button slds-button_reset slds-context-bar__label-action']")
		WebElement Moremenu;
		
		@FindBy(xpath="//a[@role='menuitemcheckbox' and @href='/lightning/o/Round_Robin_Users__c/home']")
		WebElement RRDUseroption;
		*/
		
		@FindBy(xpath="//li[@title='Related']")
		WebElement Related;
		
		//div[@class='slds-truncate' and @title='New' ]
		//div[@class='slds-truncate'][contains(text(),'New')]
		@FindBy(xpath = "//ul[@class='branding-actions slds-button-group slds-m-left--xx-small small oneActionsRibbon forceActionsContainer']//li//a//div[contains(text(),'New')]")
	    WebElement newRRDUser;
		
		/*@FindBy(xpath="//div[contains(text(),'New')]")
		WebElement NewRRDuser;
		*/
		
		@FindBy(xpath="//input[@title='Search People']")
		WebElement RRDusersearch;
		
		@FindBy(xpath="//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")
	    List<WebElement> Lookuppeople;
		
		@FindBy(xpath="//input[@title='Search Step 2-Define Teams']")
		WebElement Team;
		
		@FindBy(xpath="//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")
		List<WebElement> LookupTeam;
		
		
		@FindBy(xpath="(//label[@class='form-element__label' and contains(text(),'Date')]//following::input[@class=' input' and @type=\"text\"])[1]")
		
		WebElement LastCaseAssignedDate;

		
		@FindBy(xpath="(//label[@class='form-element__label' and contains(text(),'Date')]//following::input[@class=' input' and @type=\"text\"])[3]")
		WebElement LastLeadAssignedDate;
		
		@FindBy(xpath="(//label[@class='form-element__label' and contains(text(),'Date')]//following::input[@class=' input' and @type=\"text\"])[5]")
		WebElement LastOppAssignedDate;
		
		@FindBy(xpath="(//div[@class='dateTime-inputTime form-element form-element__control'])[1]")
		WebElement LastCaseAssignedTime;
		
		@FindBy(xpath="//li[@role='menuitem']")
		List<WebElement> ListPickcaseTime;
		
		@FindBy(xpath="(//div[@class='dateTime-inputTime form-element form-element__control'])[2]")
		WebElement LastLeadAssignedTime;
		
		@FindBy(xpath="//div[@class='visible uiInputTimePicker--default uiInputTimePicker']//div//ul//li[@role=\"menuitem\"]")
		List<WebElement> ListPickLeadTime;
		
		@FindBy(xpath="(//div[@class='dateTime-inputTime form-element form-element__control'])[3]")
		WebElement LastOppAssignedTime;
		
		@FindBy(xpath="//div[@class='visible uiInputTimePicker--default uiInputTimePicker']//div//ul//li[@role=\"menuitem\"]")
		List<WebElement> ListPickOppTime;
		
		
		//@FindBy(xpath="(//input[@class='input uiInputSmartNumber'])[1]")
		
		@FindBy(xpath="(//span[contains(text(),'Record assign limit')]//following::input[@class='input uiInputSmartNumber'])[1]")
		WebElement RecordAssignLimit;
		
		@FindBy(xpath="//span[contains(text(),'Allowed Number of Open Cases')]//following::input[@class='input uiInputSmartNumber']")
	    WebElement Allowedopencases;
		
		@FindBy(xpath="//button[@title='Save']")
		WebElement save;
		
		@FindBy(xpath="//span[@class='uiOutputNumber']")
		WebElement Tobeassignedrecord_user;
		
	/*	public void click_on_more()
		{
			
				Moremenu.click();
				
				
				
				
		}	
			
			
		public void click_on_RRD_user()
		{
			
				
				
				RRDUseroption.click();
				
				
		}	
			
		
		public void clickOnNew()
		{
			NewRRDuser.click();
		}
		*/
		
		public void clickonRelatedtab() throws InterruptedException
		{
			SyncElement.TobeClickable(driver, Related, 30);
			Related.click();
			Thread.sleep(3000);
		}
		
		
		public void clickFirstTeam()
		{
			driver.findElement(By.linkText("RRDT-0026")).click();
		}
		public void clickonnew() throws InterruptedException
		{
			    SyncElement.isElementPresnt(driver, Related, 30);
		        JavascriptExecutor executor = (JavascriptExecutor)driver;
		        executor.executeScript("arguments[0].click();", newRRDUser);
		        Thread.sleep(3000);
		        
		    }
		
		public void clicksOnsearchPeople(String SearchPeople) throws InterruptedException
		{
		    SyncElement.isElementPresnt(driver, Related, 30);
			RRDusersearch.click();
			RRDusersearch.sendKeys(SearchPeople);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1500);
			
		}
		public void PickRRDuser(String RRD_user) throws InterruptedException
		{
			
			for(int i=0;i<Lookuppeople.size();i++)
			{
				String LookupPeople=Lookuppeople.get(i).getText();
				
				if(LookupPeople.contains(RRD_user))
				{
					Lookuppeople.get(i).click();
				}
				
			}
			Thread.sleep(1500);
		}
		
		public void clicksOnsearchTeam()
		{
			Team.click();
			
		}
		
		
		public void PickTeam(String Team_name )
		{
			for(int i=0;i<LookupTeam.size();i++)
			{
				String Lookupteam=LookupTeam.get(i).getText();
				if(LookupTeam.contains(Team_name))
				{
					LookupTeam.get(i).click();
				}
			}
		}
		
		public void getCaseDate(String caseDate) throws InterruptedException
		{
			SyncElement.isElementPresnt(driver, LastCaseAssignedDate, 20);
			LastCaseAssignedDate.clear();
			LastCaseAssignedDate.sendKeys(caseDate);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(1500);
		}
		
		public void clickoncaseTime() throws InterruptedException
		{
			SyncElement.isElementPresnt(driver, LastCaseAssignedTime, 20);
			LastCaseAssignedTime.click();
			Thread.sleep(1500);
		}
		
		public void pickCaseTime() throws InterruptedException
		{
			
			ListPickcaseTime.get(1).click();
			Thread.sleep(2000);
		/*
		 * for(int i=0;i<ListPickcaseTime.size();i++) { String
		 * listtime=ListPickcaseTime.get(i).getText(); if((
		 * ListPickcaseTime).contains(caseTime)) { ListPickcaseTime.get(i).click(); } }
		 */
		}
		
		
		public void getLeadDate(String LeadDate) throws InterruptedException
		{
			SyncElement.isElementPresnt(driver, LastLeadAssignedDate, 20);
			LastLeadAssignedDate.clear();
			LastLeadAssignedDate.sendKeys(LeadDate);
			Thread.sleep(1500);
		}
		
		public void clickonLeadTime() throws InterruptedException
		{
			SyncElement.isElementPresnt(driver, LastLeadAssignedDate, 20);
			LastLeadAssignedTime.click();
			Thread.sleep(1500);
		}
		
		public void pickLeadTime() throws InterruptedException
	{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			ListPickLeadTime.get(3).click();
			Thread.sleep(2500);
		
		}
		
		
		public void getOppDate(String OppDate) throws InterruptedException
		{
			SyncElement.isElementPresnt(driver, LastOppAssignedDate, 20);
			LastOppAssignedDate.sendKeys(OppDate);
			Thread.sleep(1500);
		}
		
		public void clickonOPpTime() throws InterruptedException
		{
			SyncElement.TobeClickable(driver, LastOppAssignedTime, 20);
			LastOppAssignedTime.click();
			Thread.sleep(1500);
		}
		
		public void pickOppTime() throws InterruptedException
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			ListPickOppTime.get(2).click();
			Thread.sleep(1500);
			
		/*
		 * for(int i=0;i<ListPickOppTime.size();i++) { String
		 * listOtime=ListPickOppTime.get(i).getText(); if(
		 * ListPickOppTime.contains(oppTime)) { ListPickOppTime.get(i).click(); } }
		 */
		}
		
		
		public void getRecordAssignLimit(String limit) throws InterruptedException
		{
			SyncElement.isElementPresnt(driver, RecordAssignLimit, 20);
			RecordAssignLimit.sendKeys(limit);
			Thread.sleep(1500);
		}
		
		public void getAllowedopencases(String opencases) throws InterruptedException
		{
			SyncElement.isElementPresnt(driver, Allowedopencases, 20);
			Allowedopencases.sendKeys(opencases);
			Thread.sleep(1500);
		}
		
		 public void scrolldowntosearchRecordlimit() throws InterruptedException
		 {
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].scrollIntoView();", Allowedopencases);
			 Thread.sleep(2000);
		 }
		
		public void clickOnSave() throws InterruptedException
		{
			SyncElement.TobeClickable(driver, save, 30);
			save.click();
			Thread.sleep(2000);
			
		}

		

}
