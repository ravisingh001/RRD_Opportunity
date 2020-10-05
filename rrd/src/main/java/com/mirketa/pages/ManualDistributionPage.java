package com.mirketa.pages;

import java.util.List;
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
	
	@FindBy(xpath="(//iframe[@title='accessibility title'])[1]")
	WebElement elementiframe;
	
	//@FindBy(xpath="//input[@class='btn btn-default'and @value='Distribute Cases']")
	//@FindBy(xpath="//*[@id=\"pgId:theForm:casepgBlckId\"]//div[1]//div[2]//div[2]//input")
	//@FindBy(xpath="//form[@id='pgId:theForm']//div[@id='pgId:theForm:casepgBlckId']//input[@type='submit']")
	@FindBy(xpath="(//*[@class='greenBtn']//input[@type='submit'])[2]")
	WebElement distributecase;
	
	@FindBy(xpath="(//div[@class='greenBtn']//input[@type='submit'])[1]")
	WebElement distributeLead;
	
	@FindBy(xpath="(//*[@class='greenBtn']//input[@type='submit'])[3]")
	WebElement DistributeAccount;
	
	
	public void clickOnManualdistribution() throws InterruptedException
	{
		 SyncElement.TobeClickable(driver, ManualDistribution, 10);	
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", ManualDistribution);
	     //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	     Thread.sleep(20000);
	}
	
	public void countofframe()
	{
		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		int numberOfTags = elements.size();
		System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);
	}
	
	public void clickonDistributecase() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", distributecase);
		 //distributecase.click();
	     Thread.sleep(1000);
		
	}
	
	public void clickonDistributeLead() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", distributeLead);
		 //distributecase.click();
	     Thread.sleep(3000);
		
	}
	
	public void clickonDistributeAccount() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", DistributeAccount);
		 //distributecase.click();
	     Thread.sleep(2000);
		
	}
	
	
	
	public void switchtoframe() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.switchTo().frame(elementiframe);
		Thread.sleep(3000);
	}

}
