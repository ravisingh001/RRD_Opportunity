package com.mirketa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mirketa.utility.SyncElement;

public class RRDSearchpage 
{
	WebDriver driver;
	
	public RRDSearchpage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//div[@class='slds-icon-waffle']")
	WebElement AppLauncher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement SearchRRD;
	
	@FindBy(xpath="//div[@class='al-menu-dropdown-list']")
	List<WebElement> DrpRRDselection;

	
	public void appclick() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, AppLauncher, 20);
		AppLauncher.click();
		Thread.sleep(2000);
	}
	public void RRdsearch() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, SearchRRD, 20);
		SearchRRD.sendKeys("RRD");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}
	public void RRDdrpdwnselection() throws InterruptedException
	{
		SyncElement.TobeClickable(driver, DrpRRDselection.get(0), 20);
		DrpRRDselection.get(0).click();
		Thread.sleep(5000);
	}
}
