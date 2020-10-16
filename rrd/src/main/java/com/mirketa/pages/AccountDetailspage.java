package com.mirketa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetailspage {
	
public WebDriver driver;

	

	public AccountDetailspage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	
	
	@FindBy(xpath="//a[@class='slds-grow flex-wrap-ie11 slds-truncate']")
	public WebElement AssignedOwner;
	
	@FindBy(xpath="//p[@class='fieldComponent slds-text-body--regular slds-show_inline-block slds-truncate']//lightning-button-icon[@class='slds-shrink-none change-owner-trigger']//lightning-primitive-icon")
	WebElement changeownerbtn;
	
	@FindBy(xpath="//span[@class='custom-truncate uiOutputText']")
	public WebElement Accountname;
	
	
	public void getAssignedowner()
	{
		String owner=AssignedOwner.getText();
		System.out.println("Assigned owner on this Account is:"+owner);
	
	}
	
	public String getAccountname()
	{
		String Accname=Accountname.getText();
		System.out.println(" Account name  is:"+Accname);
		return Accname;
		
	}
	
	
	
	

}
