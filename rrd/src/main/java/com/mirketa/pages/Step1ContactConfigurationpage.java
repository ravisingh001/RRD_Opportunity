package com.mirketa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.mirketa.utility.SyncElement;

public class Step1ContactConfigurationpage {
	WebDriver driver;

	public Step1ContactConfigurationpage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Step 1-Configuration')]")
	WebElement Step1config;
	
	@FindBy(xpath="//tr//td[@class='rich-tabhdr-side-cell']//td[contains(text(),'Contact')]")
	WebElement clickonContact;
	

	@FindBy(xpath = "//input[@value='Edit']")
	WebElement EditButton;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement SaveButton;


	@FindBy(xpath = "//iframe[@title='accessibility title']")
	WebElement iframeStep1Config;

	@FindBy(xpath = "(//select[starts-with(@name,'j_id0:theForm:thePageBlockOne:hidepgaeblocksectionContact:j_id')])[1]")
	WebElement EnableRRD;
	
	
	@FindBy(xpath = "(//select[starts-with(@name,'j_id0:theForm:thePageBlockOne:hidepgaeblocksectionContact:j_id')])[2]")
	WebElement OwnerNotification;

	@FindBy(xpath = "(//select[starts-with(@name,'j_id0:theForm:thePageBlockOne:showpgaeblocksectionContactNotification:j_id')])")
	WebElement DefaultOwner;

	


	
	public void clickonstepconfig()
	{

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Step1config);
		
	}
	

	public void clickOnEditButton() throws InterruptedException {
		SyncElement.TobeClickable(driver, EditButton, 30);
		EditButton.click();
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	public boolean isEditButtonVisible() {
		return EditButton.isDisplayed();
	}

	public void clickOnSaveButton() throws InterruptedException {
		SyncElement.TobeClickable(driver, SaveButton, 30);
		SaveButton.click();
		Thread.sleep(5000);
		
	}

	public void clickOnContact() throws InterruptedException {
		SyncElement.TobeClickable(driver, clickonContact, 30);
		clickonContact.click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void navigatetoIframeContactConfig() throws InterruptedException {
		driver.switchTo().frame(iframeStep1Config);
		Thread.sleep(2000);
		SyncElement.TobeClickable(driver, clickonContact, 30);
	}
	
	public void navigatebacktoParent()
	{
		driver.switchTo().defaultContent();
	}

	public void selecctOwnerNotication(String owner) throws InterruptedException {
		SyncElement.isElementPresnt(driver, OwnerNotification, 20);
		Select sel = new Select(OwnerNotification);
		OwnerNotification.click();
		sel.selectByVisibleText(owner);
		Thread.sleep(6000);

	}

	public void selectEnableRRD(String user) throws InterruptedException {
		SyncElement.isElementPresnt(driver, EnableRRD, 20);
		Select sel = new Select(EnableRRD);
		EnableRRD.click();
		sel.selectByVisibleText(user);
		Thread.sleep(6000);
	}
	
	
	
	

	public void selectDefaultOwner(String str) throws InterruptedException {
		SyncElement.isElementPresnt(driver, DefaultOwner, 20);
		Select sel = new Select(DefaultOwner);
		DefaultOwner.click();
		sel.selectByVisibleText(str);
		Thread.sleep(4000);
	}
	
	public void reloadpage() throws InterruptedException
	{
		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	

	


}
