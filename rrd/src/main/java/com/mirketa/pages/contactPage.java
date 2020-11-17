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
	
	@FindBy(xpath="(//input[@class=' input'])[9]")
	WebElement Department;
	
	@FindBy(xpath="(//input[@placeholder='Mailing Zip/Postal Code'])")
	WebElement MailingZip;
	
	@FindBy(xpath="//input[@placeholder='Mailing City']")
	WebElement MailingCity;
	
	@FindBy(xpath="(//span[contains(text(),'Title')]/following::input[@class=' input'])[1]")
	WebElement Title;
	
	@FindBy(xpath="//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']//span[contains(@class,' label bBody')][contains(text(),'Save')]")
	WebElement Save;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')][@class='slds-truncate']")
	WebElement Contacts;

	@FindBy(xpath="(//a[@class='select'])[2]")
	WebElement LeadSource;
	
	@FindBy(xpath="(//a[@class='select'])[1]")
	WebElement Solutation;
	
	@FindBy(xpath="//div[starts-with(@id,'pgId:theForm:contactpgBlckId:j_id')]/div/table/tbody/tr[2]/td//span")
	public  WebElement Contact_DistributionCount;
	
	public void clickOnContact() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, NewContact, 20);
		NewContact.click();
		Thread.sleep(3500);
	}
	
	/*
	 * public void Contact() throws InterruptedException {Thread.sleep(2500);
	 * Contacts.click(); Thread.sleep(3500); }
	 */
	
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
	
	public void sendDepartmenname(String department) throws InterruptedException
	{
		Thread.sleep(3000);
		SyncElement.isElementPresnt(driver, Department, 30);
		Department.sendKeys(department);
		Thread.sleep(1000);
	}
	
	public void sendMailingzipcode(String zip) throws InterruptedException
	{
		Thread.sleep(3000);
		SyncElement.isElementPresnt(driver, MailingZip, 30);
		MailingZip.sendKeys(zip);
		Thread.sleep(1000);
	}
	
	public void sendMailingCity(String city) throws InterruptedException
	{
		Thread.sleep(3000);
		SyncElement.isElementPresnt(driver, MailingCity, 30);
		MailingCity.sendKeys(city);
		Thread.sleep(1000);
	}
	
	public void sendtitle(String title) throws InterruptedException
	{
		Thread.sleep(3000);
		SyncElement.isElementPresnt(driver, Title, 30);
		Title.sendKeys(title);
		Thread.sleep(1000);
	}
	
	public void clickonsave() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, Save, 30);
		Save.click();
		Thread.sleep(4000);
	}
	
	 public void pick_LeadSource(String LS) throws InterruptedException
	 {
		 SyncElement.isElementPresnt(driver, LeadSource, 30);
		 LeadSource.sendKeys(LS+"\n");
		 Thread.sleep(5000);
	 }
	 
	 public void pick_Solutation(String solutation) throws InterruptedException
	 {
		 SyncElement.isElementPresnt(driver, Solutation, 30);
		 Solutation.sendKeys(solutation+"\n");
		 Thread.sleep(5000);
	 }
	
}

