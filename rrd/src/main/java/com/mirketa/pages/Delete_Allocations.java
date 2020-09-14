package com.mirketa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Delete_Allocations {
	WebDriver driver;

	public Delete_Allocations(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//tr[1]//td[8]//span[1]//div[1]//a[1]")
	WebElement Delete_DropDown;

	@FindBy(xpath = "//a[@title='Delete']")
	WebElement Delete_Button;

	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	WebElement Confirm_Delete;

	public void ClickONDelete_DropDown() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Delete_DropDown);
		Thread.sleep(4000);
	}

	public void ClickONDelete_Button() throws InterruptedException {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Delete_Button);

		Thread.sleep(4000);
	}

	public void ClickOnConfirm_Delete() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Confirm_Delete);
		Thread.sleep(4000);
	}
}
