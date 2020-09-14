package com.mirketa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mirketa.utility.SyncElement;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//span[@class='slds-truncate'][contains(text(),'RRD')]")
	WebElement RRDLabel;

	@FindBy(xpath = "//span[contains(text(),'Step 1-Configuration')]")
	WebElement Step1Configuration;

	@FindBy(xpath = "//span[@class='slds-truncate'][contains(text(),'Step 2-Define Teams')]")
	WebElement Step2DefineTeam;

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean RRDisDisplayed() {
		return RRDLabel.isDisplayed();
	}

	public void clickOnStep1Configuration() throws InterruptedException {
		
		SyncElement.TobeClickable(driver, Step1Configuration, 50);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Step1Configuration);
		Thread.sleep(15000);
		
	}

	public void clickOnStep2DefineTeam() {
		
		SyncElement.TobeClickable(driver, Step1Configuration, 50);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Step2DefineTeam);
		
	}

}
