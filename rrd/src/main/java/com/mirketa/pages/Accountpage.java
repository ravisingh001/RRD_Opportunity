package com.mirketa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mirketa.utility.SyncElement;

public class Accountpage {
	
	public WebDriver driver;

	

	public Accountpage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//div[contains(text(),'New')]")
	WebElement Newbtn;
	
	@FindBy(xpath="//span[@class='itemLabel slds-truncate slds-show--inline-block slds-m-left--xx-small' and @title='New Account']")
	WebElement NewAccount;
	
	@FindBy(xpath="//label//span[contains(text(),'Account Name')]//following-sibling::span[contains(@class,'required')][contains(text(),'*')]//following::input[@class=' input'][1]")
	WebElement AccountName;
	
	@FindBy(xpath="//div[@class='uiMenu']//div[@class='uiPopupTrigger']//a[@class='select' and @role='button']")
	List<WebElement> lists;
	
	@FindBy(xpath="//span[contains(text(),'Rating')]//following::div[@class='uiMenu'][1]")
	WebElement Rating;
	
	@FindBy(xpath="//li[@class='uiMenuItem uiRadioMenuItem']")
	List<WebElement> Picklistrating;
	
	@FindBy(xpath="(//span[contains(text(),'Phone')]//following::input[@type='tel'])[1]")
	WebElement phone;
	
	@FindBy(xpath="(//span[contains(text(),'Phone')]//following::input[@type='tel'])[2]")
	WebElement Fax;
	
	@FindBy(xpath="//span[contains(text(),'Website')]//following::input[@type='url']")
	WebElement Website;
	
	@FindBy(xpath="//span[contains(text(),'Ticker Symbol')]//following::input[@type='text'][1]")
	WebElement Ticketsymbol;
	
	@FindBy(xpath="//span[contains(text(),'Employees')]//following::input[@class='input uiInputSmartNumber'][1]")
	WebElement Employee;
	
	@FindBy(xpath="(//span[contains(text(),'Type')]//following::div[@class='uiMenu']//div[@class='uiPopupTrigger']//a[@class='select' and @role='button'])[1]")
	WebElement Type;
	
	@FindBy(xpath="//ul[@class='scrollable']//li[@class='uiMenuItem uiRadioMenuItem']")
	List<WebElement> TypeList;
	
	@FindBy(xpath="(//span[contains(text(),'Ownership')]//following::div[@class='uiMenu']//div[@class='uiPopupTrigger']//a[@class='select' and @role='button'])[1]")
	WebElement ownership;
	
	@FindBy(xpath="//li[@class='uiMenuItem uiRadioMenuItem']")
	List<WebElement> ownershiplist;
	
	@FindBy(xpath="(//span[contains(text(),'Industry')]//following::div[@class='uiMenu']//div[@class='uiPopupTrigger']//a[@class='select' and @role='button'])[1]")
	WebElement Industry;
	
	@FindBy(xpath="//li[@class='uiMenuItem uiRadioMenuItem']")
	List<WebElement> IndustryList;
	
	@FindBy(xpath="(//span[contains(text(),'Customer Priority')]//following::div[@class='uiMenu']//div[@class='uiPopupTrigger']//a[@class='select' and @role='button'])[1]")
	WebElement Customerprio;
	
	@FindBy(xpath="//li[@class='uiMenuItem uiRadioMenuItem']")
	List<WebElement> CustomerprioList;
	
	@FindBy(xpath="(//span[contains(text(),'SLA')]//following::div[@class='uiMenu']//div[@class='uiPopupTrigger']//a[@class='select' and @role='button'])[1]")
	WebElement Sla;
	
	@FindBy(xpath="//li[@class='uiMenuItem uiRadioMenuItem']")
	List<WebElement> SlaList;
	
	@FindBy(xpath="(//span[contains(text(),'SLA Expiration Date')]//following::input[@type='text'])[1]")
	WebElement SLAExpirationDate;
	
	@FindBy(xpath="(//span[contains(text(),'SLA Serial Number')]//following::input[@type='text'])[1]")
	WebElement SLASerialNum;
	
	@FindBy(xpath="(//span[contains(text(),'Number of Locations')]//following::input[@type='text'])[1]")
	WebElement NumofLocation;
	
	@FindBy(xpath="(//span[contains(text(),'Upsell Opportunity')]//following::div[@class='uiMenu']//div[@class='uiPopupTrigger']//a[@class='select' and @role='button'])[1]")
	WebElement Upsell_Opportunity;
	
	@FindBy(xpath="//li[@class='uiMenuItem uiRadioMenuItem']")
	List<WebElement> UpselListl_Opportunity;
	
	@FindBy(xpath="(//span[contains(text(),'Active')]//following::div[@class='uiMenu']//div[@class='uiPopupTrigger']//a[@class='select' and @role='button'])[1]")
	WebElement Active;
	
	@FindBy(xpath="//li[@class='uiMenuItem uiRadioMenuItem']")
	List<WebElement> ActiveList;
	
	@FindBy(xpath="//textarea[@placeholder='Billing Street']")
	WebElement BillingStreet;
	
	@FindBy(xpath="//textarea[@placeholder='Shipping Street']")
	WebElement ShippingStreet;
	
	@FindBy(xpath="//input[@class='city compoundBorderBottom compoundBorderRight input' and @placeholder='Billing City' ]")
	WebElement BillingCity;
	
	@FindBy(xpath="//input[@class='city compoundBorderBottom compoundBorderRight input' and  @placeholder='Shipping City']")
	WebElement ShippingCity;
	
	@FindBy(xpath="//input[@class='country compoundBRRadius input' and  @placeholder='Shipping Country']")
	WebElement ShippingCountry;
	
	@FindBy(xpath="//input[@class='state compoundBorderBottom input' and  @placeholder='Billing State/Province']")
	WebElement BillingState;
	
	@FindBy(xpath="//input[@class='state compoundBorderBottom input' and  @placeholder='Shipping State/Province']")
	WebElement ShippingState;
	
	@FindBy(xpath="//input[@class='country compoundBRRadius input' and  @placeholder='Billing Country']")
	WebElement BillingCountry;
	
	@FindBy(xpath="//input[@class='postalCode compoundBLRadius compoundBorderRight input' and @placeholder='Billing Zip/Postal Code']")
	WebElement Billingzopcode;
	
	@FindBy(xpath="//input[@class='postalCode compoundBLRadius compoundBorderRight input' and @placeholder='Billing Zip/Postal Code']")
	WebElement ShippingZipcode;
	
	@FindBy(xpath="//textarea[@class=' textarea']")
	WebElement Description;
	
	
	/*
	 * @FindBy(
	 * xpath="//button[contains(@class,'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton')]//span[contains(@class,'label bBody')][contains(text(),'Save')]"
	 * ) WebElement Save;
	 */
	 
	
	@FindBy(xpath="//button[@title='Save']//span[contains(@class,'label bBody')][contains(text(),'Save')]")
	WebElement Saveacc;
	
	/*
	 * @FindBy(
	 * xpath="//span[@class='itemLabel slds-truncate slds-show--inline-block slds-m-left--xx-small' and @title='New Account']"
	 * ) WebElement NewAccount;
	 * 
	 * @FindBy(
	 * xpath="//label//span[contains(text(),'Account Name')]//following-sibling::span[contains(@class,'required')][contains(text(),'*')]//following::input[@class=' input'][1]"
	 * ) WebElement AccountName;
	 * 
	 * @FindBy(xpath=
	 * "//span[contains(text(),'Rating')]//following::div[@class='uiMenu'][1]")
	 * WebElement Rating;
	 * 
	 * @FindBy(xpath="//li[@class='uiMenuItem uiRadioMenuItem']") List<WebElement>
	 * Picklistrating;
	 */
	
	
	@FindBy(xpath="(//button[3]/span[contains(text(),'Save')])[2]")
	WebElement Save;
	
	@FindBy(xpath="//button[3]/span[contains(text(),'Save')]")
	WebElement Account_Save;
	
	/*
	 * public void clickOnNewAccount() throws InterruptedException {
	 * SyncElement.TobeClickable(driver, NewAccount, 20); NewAccount.click();
	 * Thread.sleep(2000); }
	 * 
	 * public void ClickonAccountName(String Account) throws InterruptedException {
	 * SyncElement.isElementPresnt(driver, AccountName, 20);
	 * AccountName.sendKeys(Account); Thread.sleep(2000); }
	 * 
	 * public void clickingRating() throws InterruptedException {
	 * SyncElement.TobeClickable(driver, Rating, 20); Rating.click();
	 * Thread.sleep(2000); }
	 */
	
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
		/*
		 * JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].scrollIntoView();", Save);
		 */
		Saveacc.click();
		//Save.click();
		Thread.sleep(4000);
	}
	
	public void clickonAccounts_save() throws InterruptedException
	{
		Account_Save.click();
		Thread.sleep(4000);
	}
	
	
	
	
	public void clickOnNewAccount() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, NewAccount, 20);
		NewAccount.click();
		Thread.sleep(2000);
	}
	
	public void clickonNew() throws InterruptedException
	{
		
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", Newbtn);
	     Thread.sleep(3000);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	}
	
	public void ClickonAccountName(String Account) throws InterruptedException
	{
		SyncElement.isElementPresnt(driver, AccountName, 20);
		AccountName.sendKeys(Account);
		 Thread.sleep(2000);
	}
	
	public void clickingRating() throws InterruptedException
	{
		//SyncElement.TobeClickable(driver, lists.get(0), 40);
		Rating.click();
		//lists.get(0).click();
		Thread.sleep(2000);
	}
	
	public void EnterphoneNo(String Phone) throws InterruptedException
	{
		SyncElement.TobeClickable(driver, phone, 20);
		phone.sendKeys(Phone);
		Thread.sleep(2000);
	}
	
	public void Ticketsymbol(String ticket) throws InterruptedException
	{
		SyncElement.TobeClickable(driver, Ticketsymbol, 20);
		Ticketsymbol.sendKeys(ticket);
		Thread.sleep(2000);
		
	}
	
	
	
	public void EnterFax(String fax) throws InterruptedException
	{
		SyncElement.TobeClickable(driver, Fax, 20);
		Fax.sendKeys(fax);
		Thread.sleep(2000);
	}
	
	public void Enterwebsite(String address) throws InterruptedException
	{
		SyncElement.TobeClickable(driver, Website, 20);
		Website.sendKeys(address);
		Thread.sleep(2000);
	}
	
	/*
	 * public void pickrating(String Ratingval) throws InterruptedException {
	 * for(int i=0;i<Picklistrating.size();i++) { String
	 * pickratingval=Picklistrating.get(i).getText();
	 * 
	 * if(pickratingval.contains(Ratingval)) { Picklistrating.get(i).click(); } }
	 * 
	 * Thread.sleep(2000); }
	 */
	
	public void scrolltocustomerprio() throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", lists.get(4));
		 Thread.sleep(3000);
	}
	
	public void clickonCustomerprio() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, lists.get(4), 20);
		//Customerprio.click();
		lists.get(4).click();
		Thread.sleep(2000);
	}
	
	public void pickcustomerpriofromlist(String prio) throws InterruptedException
	{
		
		for(int i=0;i<CustomerprioList.size();i++)
		{
			String clickprio=CustomerprioList.get(i).getText();
			
			if(clickprio.contains(prio))
			{
				CustomerprioList.get(i).click();
			}
		}
		
		Thread.sleep(4000);
		
		
	}
	public void scrolltoindustry() throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", lists.get(3));
		 Thread.sleep(3000);
		 
		}
	
	public void clickonindustry() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, lists.get(3), 20);
		//Industry.click();
		lists.get(3).click();
		Thread.sleep(3000);
	}
	
	public void pickindustryfromlist(String indus) throws InterruptedException
	{
		
			
			for(int i=0;i<IndustryList.size();i++)
			{
				String indusval=CustomerprioList.get(i).getText();
				
				if(indusval.contains(indus))
				{
					
					
					IndustryList.get(i).click();
				}
			}
			
			Thread.sleep(4000);
	}
	
	public void EnterBillingCity(String City) throws InterruptedException
	{
		SyncElement.TobeClickable(driver, BillingCity, 20);
		BillingCity.clear();
		Thread.sleep(1000);
		BillingCity.sendKeys(City);
	}
	
	public void scrolltoAddressInformation() throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", BillingStreet);
		 Thread.sleep(3000);
	}
	
	
	public void Enetremployee(String Emp) throws InterruptedException
	{
		SyncElement.TobeClickable(driver, Employee, 20);
		Employee.sendKeys(Emp);
		Thread.sleep(2000);
	}
	
	public void scrolltoactive() throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", lists.get(7));
		 Thread.sleep(5000);
		
	}
	
	public void clickonActivity() throws InterruptedException
	{
		//SyncElement.TobeClickable(driver, lists.get(7), 20);
		//Active.click();
		lists.get(7).click();
		Thread.sleep(2000);
	}
	
	public void PickActivefromlist(String act) throws InterruptedException
	{
		
		
		for(int i=0;i<ActiveList.size();i++)
		{
			String pickactiveval=ActiveList.get(i).getText();
			
			if(pickactiveval.contains(act))
			{
				ActiveList.get(i).click();
			}
		}
		
		Thread.sleep(2000);
		
		
	}
	
	public void clickonownership() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, lists.get(2), 50);
		//ownership.click();
		lists.get(2).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void pickownershipval(String owner) throws InterruptedException
	{
		for(int i=0;i<ownershiplist.size();i++)
		{
			String pickownership=ownershiplist.get(i).getText();
			
			if(pickownership.contains(owner))
			{
				ownershiplist.get(i).click();
			}
		}
		
		Thread.sleep(2000);
		
	}
	
	public void clickonsla()
	{
		SyncElement.TobeClickable(driver, lists.get(5), 50);
		//Sla.click();
		lists.get(5).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void pickslafromlist(String sla) throws InterruptedException
	{
		for(int i=0;i<SlaList.size();i++)
		{
			String picksla=SlaList.get(i).getText();
			
			if(picksla.contains(sla))
			{
				SlaList.get(i).click();
			}
		}
		
		Thread.sleep(2000);
	}
	
	
	/*
	 * public void clickonsave() throws InterruptedException {
	 * 
	 * Saveacc.click(); Thread.sleep(4000); }
	 */
	
	public void saveaccount() throws InterruptedException
	{
		Save.click();
		Thread.sleep(4000);
		 
		
	}

}
