package com.mirketa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mirketa.utility.SyncElement;

public class EditTeamPage {
	
	public WebDriver driver;

	

	public EditTeamPage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//button[@name='Edit']")
	WebElement Editteambtn;
	
	@FindBy(xpath="(//span[contains(text(),'Maximum Intake limit in current cycle')]//following::input[@class='input uiInputSmartNumber'])[2]")
	WebElement EditMaxIntakelimit;
	
	@FindBy(xpath="//span[contains(text(),'Maximum Intake limit in current cycle')]//following::input[@name='rrde__Maximum_limit_in_current_cycle__c']")
	WebElement EditMaxIntakelimit_Contact;
	
	@FindBy(xpath="//button[@title='Save']")
	WebElement Editteamsave;
	
	@FindBy(xpath="//span[@class='view-all-label']")
	WebElement Viewalllink;
	
	@FindBy(xpath="//a[starts-with(@title,'RRU-')]")
	List<WebElement> UserList;
	
	@FindBy(xpath="//div[@class='slds-grid primaryFieldRow']//div[@class='slds-col slds-no-flex slds-grid slds-grid_vertical-align-center horizontal actionsContainer']//div//button[@name='Edit'][contains(text(),'Edit')]")
	List<WebElement> EditUser;
	
	@FindBy(xpath="(//runtime_platform_actions-actions-ribbon//button[@name='Edit'])[2]")
	List<WebElement> EditUser_Contact;
	
	@FindBy(xpath="(//span[contains(text(),'Record assign limit')]//following::input[@class='input uiInputSmartNumber'])[1]")
	WebElement EditRecordassignlimit;
	
	@FindBy(xpath="//span[contains(text(),'Record assign limit')]//following::input[@name='rrde__Record_assign_limit__c']")
	WebElement EditRecordassignlimit_Contact;
	
	//@FindBy(xpath="(//span[contains(text(),'Allowed Number of Open Cases')]//following::input[@class='input uiInputSmartNumber'])[3]")
	@FindBy(xpath="//span[contains(text(),'Allowed Number of Open Cases')]//following::input[@class='input uiInputSmartNumber']")
	List<WebElement> EditTeamopencases;
	
	@FindBy(xpath="//span[contains(text(),'Allowed Number of Open Cases')]//following::input[@class='input uiInputSmartNumber']")
    List<WebElement> UserAllowedopencases;
	
	@FindBy(xpath="//span[contains(text(),'Allowed Number of Open Cases')]//following::input[@name='rrde__Allowed_Number_of_Open_Cases__c']")
    List<WebElement> UserAllowedopencases_Contact;
	
	
	
	@FindBy(xpath="//button[@title='Save']")
	WebElement EditUsersave;
	
	@FindBy(xpath="//li[@title='Related']")
	WebElement Related;
	
	@FindBy(xpath="//span[@class='uiOutputText forceOutputLookup']")
	List<WebElement> Readonly;
	
	public void ClickonEditTeam()
	{
		     SyncElement.TobeClickable(driver, Editteambtn, 50);	
			 JavascriptExecutor executor = (JavascriptExecutor)driver;
		     executor.executeScript("arguments[0].click();", Editteambtn);
		     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	}
	
	public void scrolldowntoreadonlydata() throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",Readonly.get(1));
		 //SyncElement.isElementPresnt(driver,Readonly.get(2), 10);
		 Thread.sleep(2000);
	}
	
	public void EditTeamopencase(String opencaset) throws InterruptedException
	{
		 
		EditTeamopencases.get(1).clear();
		Thread.sleep(1000);
		EditTeamopencases.get(1).sendKeys(opencaset);
		Thread.sleep(1000);
	}
	
	public void EditMaxIntakeLimit(String maxlimit) throws InterruptedException
	{
		
		EditMaxIntakelimit.clear();
		Thread.sleep(1000);
		EditMaxIntakelimit.sendKeys(maxlimit);
		Thread.sleep(1000);
	}
	
	public void EditMaxIntakeLimit_Contact(String maxlimit) throws InterruptedException
	{
		Thread.sleep(2000);
		EditMaxIntakelimit_Contact.clear();
		Thread.sleep(2000);
		EditMaxIntakelimit_Contact.sendKeys(maxlimit);
		Thread.sleep(2000);
	}
	
	public void clickonEditteamsave() throws InterruptedException
	{
		 Thread.sleep(2000);
		 Editteamsave.click();
		 Thread.sleep(3000);
	}
	
	public void scrolldowntoopencase() throws InterruptedException
	 {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",EditTeamopencases );
		 SyncElement.isElementPresnt(driver,EditTeamopencases.get(1), 10);
		 Thread.sleep(2000);
		 
	 }
	
	
	public void scrolldowntoMaxIntake() throws InterruptedException
	 {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",EditMaxIntakelimit );
		 SyncElement.isElementPresnt(driver,EditMaxIntakelimit, 10);
		 Thread.sleep(2000);
		 
	 }
	public void scrolldowntouserRecordlimit() throws InterruptedException
	 {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",EditRecordassignlimit );
		 SyncElement.isElementPresnt(driver,EditRecordassignlimit, 10);
		 Thread.sleep(2000);
		 
	 }
	

	public void scrolldowntouserRecordlimit_Contact() throws InterruptedException
	 {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",EditRecordassignlimit_Contact );
		 SyncElement.isElementPresnt(driver,EditRecordassignlimit_Contact, 10);
		 Thread.sleep(2000);
		 
	 }
	
	
	public void clickonEdituser() throws InterruptedException
	{

		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();",  EditUser.get(0));
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	     Thread.sleep(2000);
	}
	
	public void clickonEdituser_Contact() throws InterruptedException
	{

		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();",  EditUser_Contact.get(0));
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	     Thread.sleep(2000);
	}
	
	public void EditRecordLimit(String Reclimit) throws InterruptedException
	{
		
		EditRecordassignlimit.clear();
		Thread.sleep(1000);
		EditRecordassignlimit.sendKeys(Reclimit);
		Thread.sleep(1000);
	}
	
	public void EditRecordLimit_Contact(String Reclimit) throws InterruptedException
	{
		
		EditRecordassignlimit_Contact.clear();
		Thread.sleep(1000);
		EditRecordassignlimit_Contact.sendKeys(Reclimit);
		Thread.sleep(1000);
	}
	
	public void EditUserallowcases(String Allopencase) throws InterruptedException
	{
		
		UserAllowedopencases.get(0).clear();
		Thread.sleep(1000);
		UserAllowedopencases.get(0).sendKeys(Allopencase);
		Thread.sleep(1000);
	}
	
	public void EditUserallowcases_Contact(String Allopencase) throws InterruptedException
	{
		
		UserAllowedopencases_Contact.get(0).clear();
		Thread.sleep(1000);
		UserAllowedopencases_Contact.get(0).sendKeys(Allopencase);
		Thread.sleep(1000);
	}
	
	public void clickonRelatedtab() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, Related, 50);
		Related.click();
		Thread.sleep(5000);
	}
	public void clickonviewall() throws InterruptedException
	{
		
		 SyncElement.TobeClickable(driver, Viewalllink, 50);	
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", Viewalllink);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	     Thread.sleep(2000);
	}
	
	
   public void ProcessEditUsers(String Reclimit,String Allopencases ) throws InterruptedException
   {
	  
			 for(int i=0;i<UserList.size();i++)
			 {
				
				 Thread.sleep(2000);
				 UserList.get(i).click();
				Thread.sleep(3000);
				driver.navigate().refresh();
				clickonEdituser();
				Thread.sleep(2000);
				scrolldowntouserRecordlimit() ;
				EditRecordLimit(Reclimit);
				EditUserallowcases(Allopencases);
				SyncElement.TobeClickable(driver, EditUsersave, 30);	
				EditUsersave.click();
				Thread.sleep(5000);	
				 driver.navigate().back();
				 Thread.sleep(2000);
			 }
			 Thread.sleep(1500);
	   
   }
   
   public void ProcessEditUsers_Contact(String Reclimit,String Allopencases ) throws InterruptedException
   {
	  
			 for(int i=0;i<UserList.size();i++)
			 {
				
				 Thread.sleep(2000);
				 UserList.get(i).click();
				Thread.sleep(3000);
				driver.navigate().refresh();
				clickonEdituser_Contact();
				Thread.sleep(2000);
				scrolldowntouserRecordlimit_Contact() ;
				EditRecordLimit_Contact(Reclimit);
				EditUserallowcases_Contact(Allopencases);
				SyncElement.TobeClickable(driver, EditUsersave, 30);	
				EditUsersave.click();
				Thread.sleep(5000);	
				 driver.navigate().back();
				 Thread.sleep(2000);
			 }
			 Thread.sleep(1500);
	   
   }
	
	
}
