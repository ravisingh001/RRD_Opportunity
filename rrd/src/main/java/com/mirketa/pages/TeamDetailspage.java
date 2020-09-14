package com.mirketa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamDetailspage {
WebDriver driver;
	
	public TeamDetailspage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	@FindBy(xpath="(//lightning-formatted-text[@data-output-element-id='output-field'])[1]")
	public WebElement teamInfo;
	
	@FindBy(xpath="")
	WebElement TobeassignmentRec;
	
	
	
	 public String getteamname()
	 {
		 String teamname=null;
		 
		 teamname=teamInfo.getText();
		 System.out.println("Teamname is:"+teamname);
		 return teamname;
	 }
	 
	 public String getTobeassigned()
	 {
		return null;
		 
	 }
	

}
