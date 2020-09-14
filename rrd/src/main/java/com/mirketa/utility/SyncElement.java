package com.mirketa.utility;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncElement {
	
	public static WebElement isElementPresnt(WebDriver driver,WebElement webElement,int time)
	{
	 
	 
	WebElement ele = null;
	 
	for(int i=0;i<time;i++)
	{
	try{
	ele=webElement;
	break;
	}
	catch(Exception e)
	{
	try 
	{
	Thread.sleep(1000);
	} catch (InterruptedException e1) 
	{
	System.out.println("Waiting for element to appear on DOM");
	}
	}
	 
	 
	}
	return ele;
	 
	}
	
	 public static void TobeClickable(WebDriver driver,WebElement locator, int timeout)
	    {
	        new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
	    }

	 
	

}
