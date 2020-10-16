package com.mirketa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.mirketa.utility.SyncElement;
import com.mirketa.utility.Xls_Reader;

public class caseDetailspage {
	
	public WebDriver driver;
	public String Testdata_sheet_path=System.getProperty("user.dir") +File.separator+"AppData"+File.separator+"AppData.xlsx";
	Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);

		

		public caseDetailspage(WebDriver ldriver) {
			
			this.driver = ldriver;
		}
		
		@FindBy(xpath="//lightning-button-icon[@class='slds-shrink-none change-owner-trigger']//lightning-primitive-icon")
		WebElement changeownerbtn;
		
		@FindBy(xpath="//input[@title='Search People' and @role='combobox']")
		WebElement Searchowner;
		
		@FindBy(xpath="//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']")
		List<WebElement> Ownerlist;
		
		@FindBy(xpath="//input[@name='SendEmail']")
		WebElement sendnotification;
		
		@FindBy(xpath="//button[@name='change owner']")
		WebElement submitchangeowner;
		
		@FindBy(xpath="//input[@name='Case-search-input']")
		WebElement Searchcase;
		
		@FindBy(xpath="//button[@name='refreshButton']//lightning-primitive-icon")
		WebElement refreshButton;
		
		@FindBy(xpath="//a[starts-with(@class,'slds-truncate outputLookupLink slds-truncate outputLookupLink')]")
		WebElement clickoncaseid;
		
		
		

	public void fetchCasenum(String casenum) throws InterruptedException	
	{
		SyncElement.TobeClickable(driver, Searchcase, 30);
		Searchcase.clear();
		Searchcase.sendKeys(casenum);
		Thread.sleep(5000);
		refreshButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		Thread.sleep(2000);
	}

	public void clickoncaseNum() throws InterruptedException
	{
		 SyncElement.TobeClickable(driver,clickoncaseid, 30);
		 clickoncaseid.click();
		 Thread.sleep(3000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		
	}


	public void clickonchangeowner() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(changeownerbtn);
		Thread.sleep(2000);
		action.click().build().perform();
		Thread.sleep(2000);
		SyncElement.isElementPresnt(driver,submitchangeowner, 30);
		
		
		
	}

	public void clickonsearchowner(String searchowner) throws InterruptedException
	{
		SyncElement.TobeClickable(driver, Searchowner, 30);
		Searchowner.click();
		Thread.sleep(4000);
		Searchowner.sendKeys(searchowner);
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void pickuserfromlist(String owner) throws InterruptedException
	{
		 for(int i=0;i<Ownerlist.size();i++)
		 {
			 String ownerlisting= Ownerlist.get(i).getText();
			 if(ownerlisting.contains(owner))
			 {
				 Ownerlist.get(i).click();
			 }
	}
		 Thread.sleep(4000);
	}
	public void Checkedownernotification() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, sendnotification, 30);
		sendnotification.click();
		Thread.sleep(2000);
	}
	public void clickonSubmitchangeownerbtn() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, submitchangeowner, 30);
		submitchangeowner.click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	public void reloadPage() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(5000);
		
	}

	
	
	
	

}
