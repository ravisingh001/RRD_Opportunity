package com.mirketa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mirketa.factory.BrowserFactory;
import com.mirketa.factory.DataProviderFactory;
import com.mirketa.utility.SyncElement;

public class SalesForceLoginPage {
	WebDriver driver;

	public SalesForceLoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passWord;
	@FindBy(xpath = "//input[@id='Login']")
	WebElement loginButton;
	
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
	public void loginApplicaiton(String user,String password) throws InterruptedException
	{
		System.out.println("user value: "+user);
		System.out.println("pass value: "+password);

		userName.sendKeys(user);
		System.out.println("1");
		passWord.sendKeys(password);
		System.out.println("2");
		SyncElement.TobeClickable(driver, loginButton, 20);
		loginButton.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	public boolean verifyLoginSuccessfull()
	{
		boolean val=false;
		try
		{
		if(loginButton.isDisplayed())
		{
			val=false;
		}
		}
		catch(Exception e)
		{
			val=true;
		}
		return val;
		}


}
