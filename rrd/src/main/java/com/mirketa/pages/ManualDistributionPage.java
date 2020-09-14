package com.mirketa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mirketa.utility.SyncElement;

public class ManualDistributionPage {
	
public WebDriver driver;

	

	public ManualDistributionPage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//span[contains(text(),'Manual Distribution')]")
	WebElement ManualDistribution;
	
	@FindBy(xpath="//iframe[@title='accessibility title']")
	WebElement elementiframe;
	
	//@FindBy(xpath="//input[@class='btn btn-default'and @value='Distribute Cases']")
	//@FindBy(xpath="//*[@id=\"pgId:theForm:casepgBlckId\"]//div[1]//div[2]//div[2]//input")
	//@FindBy(xpath="//div[@id='pgId:theForm:casepgBlckId']//div[1]//div[2]//div[@class='greenBtn']")
	@FindBy(xpath="//input[@value='Distribute Cases']")
	WebElement distributecase;
	
	
	public void clickOnManualdistribution() throws InterruptedException
	{
		 SyncElement.TobeClickable(driver, ManualDistribution, 10);	
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", ManualDistribution);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	     Thread.sleep(10000);
	}
	
	public void countofframe()
	{
		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		int numberOfTags = elements.size();
		System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);
	}
	
	public void clickonDistributecase() throws InterruptedException
	{
		// SyncElement.TobeClickable(driver, distributecase, 10);	
		
		
		
		  JavascriptExecutor executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", distributecase);
		 
		 
		 
		    distributecase.click();
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	     Thread.sleep(1000);
		
	}
	
	public void switchtoframe() throws InterruptedException
	{
		driver.switchTo().frame(1);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
	}

}
