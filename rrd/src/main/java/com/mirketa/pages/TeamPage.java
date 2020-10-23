package com.mirketa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mirketa.utility.SyncElement;

public class TeamPage 
{
	WebDriver driver;
	SyncElement sync=new SyncElement();
	
	public TeamPage(WebDriver ldriver) {
		
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//span[contains(@class,'slds-truncate')][contains(text(),'Step 2-Define Teams')]")
	 WebElement DefineTeamtab;
	
	@FindBy(xpath="//*[@type='search'][@name='rrde__RRD_Teams__c-search-input']")
	 WebElement SearchTeam;
	
	@FindBy(xpath="//*[@type='search'][@name='Opportunity-search-input']")
	 WebElement SearchOpportunity;
	
	@FindBy(xpath = "//button[@name='refreshButton']//lightning-primitive-icon")
	WebElement refreshButton;
	
	@FindBy(xpath="//a[starts-with(@class,'slds-truncate outputLookupLink slds-truncate outputLookupLink')]")
	 WebElement clickonTeamId;
	
	@FindBy(xpath="//div[contains(text(),'Clone')]")
	 WebElement clickonCloneButton;
	
	@FindBy(xpath="//one-app-nav-bar-item-root[3]//one-app-nav-bar-item-dropdown[1]//div[1]//one-app-nav-bar-menu-button[1]//a[1]/lightning-icon[1]/lightning-primitive-icon[1]//*[local-name()='svg']")
	WebElement DefineTeambuttondrpdown;
	
	@FindBy(xpath="//one-app-nav-bar-menu-item[1]//a[@href='/setup/ui/recordtypeselect.jsp?sObjectName=rrde__RRD_Teams__c&save_new_url=%2Fa04%2Fe&navigationLocation=LIST_VIEW']")
	WebElement NewTeam;
	
	@FindBy(xpath="//div[11]//label[1]//div[1]//span[1]")
	WebElement OpportunityCriteria_RadiaBtn;
	
	@FindBy(xpath="//div[5]//label[1]//div[1]//span[1]")
	WebElement ContactCriteria_RadiaBtn;
	
	//close for older package
	/*
	 * @FindBy(xpath="//div[7]//label[1]//div[1]//span[1]") WebElement
	 * LeadCriteria_RadiaBtn;
	 */
	
	@FindBy(xpath="//div[5]//label[1]//div[1]//span[1]")
	WebElement LeadCriteria_RadiaBtn;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement NextButton;
	//close for older package
	
	  @FindBy(xpath="//input[@name='rrde__Priority_Order_Not_Unique__c']") public
	  List<WebElement> txtFieldList_CC;
	//close for New package
	/*
	 * @FindBy(xpath="//input[@name='rrde__Priority_Order__c']") public
	 * List<WebElement> txtFieldList_CC;
	 */
	
	@FindBy(xpath="//input[@name='rrde__Team_Name__c']")
    WebElement Team_name;
	
	@FindBy(xpath="//input[@name='rrde__Maximum_limit_in_current_cycle__c']")
	WebElement Max_intake_limit;
	
	@FindBy(xpath="//input[@name='rrde__Allowed_Number_of_Open_Cases__c']")
	WebElement Allowed_Num_of_open_case;
	
	@FindBy(xpath="//*[@class='forceOutputRecordType']")
	WebElement Record_type;
	
	@FindBy(xpath="//span[contains(@class,'uiOutputText forceOutputLookup')]")
	WebElement owner;
	
	@FindBy(xpath="//input[@type='checkbox' and @checked='checked']")
	WebElement Is_Active;
	
	@FindBy(xpath="//button[@title='Save']")
	WebElement Save;
	
	@FindBy(xpath="//span[contains(text(),'Save & New')]")
	WebElement saveAndNew;
	
	@FindBy(xpath="//button[@title='Cancel']")
	WebElement cancel;
	
	@FindBy(xpath="(//button[@class='slds-button slds-button_icon slds-button_icon-bare'][@title='Change Owner'])[1]")
	WebElement ChangeOwnerIcon;
	
	@FindBy(xpath="//input[contains(@placeholder,'Search People...')]")
	WebElement SearchOwnerName;
	
	@FindBy(xpath="//div[@title='Integration User']")
	WebElement SelectOwner;
	
	@FindBy(xpath="//div[@title='Security User']")
	WebElement SelectOwner_SecurityUser;
	
	@FindBy(xpath="//span[@class='slds-radio--faux']")
	List<WebElement> Teamsrecordtype;
	
	@FindBy(xpath="//button[contains(@name,'change owner')]")
	WebElement ChangeOwnerButton;
	
	@FindBy(xpath="(//lightning-formatted-text[@data-output-element-id='output-field'])[1]")
	public WebElement teamInfo;
	
	@FindBy(xpath="(//div[@class='slds-form-element slds-hint-parent test-id__output-root slds-form-element_readonly slds-form-element_stacked']//slot//lightning-formatted-number)[7]")
    public WebElement TobeAssignedcount;
	
	@FindBy(xpath="(//div[@class='slds-form-element slds-hint-parent test-id__output-root slds-form-element_readonly slds-form-element_stacked']//slot//lightning-formatted-number)[6]")
    public WebElement TobeAssignedcount_ForOpportunity;
	
	@FindBy(xpath="(//div[@class='slds-form-element slds-hint-parent test-id__output-root slds-form-element_readonly slds-form-element_stacked']//slot//lightning-formatted-number)[6]")
    public WebElement TobeAssignedcount_ForLeads;
	
	@FindBy(xpath="(//force-hoverable-link//div[@class='slds-grid']//a)[2]")
    public WebElement Ownername;
	
	@FindBy(xpath="(//div[@class='slds-form-element slds-hint-parent test-id__output-root slds-form-element_readonly slds-form-element_stacked']//slot//lightning-formatted-number)[6]")
	public WebElement AccountTobeAssigned;
	
   public void clickOnDefineTeam() throws InterruptedException {
		/*
		 * WebDriverWait wait=new WebDriverWait(driver,20);
		 * SyncElement.isElementPresnt(driver, DefineTeambuttondrpdown, 10);
		 * SyncElement.TobeClickable(driver, NewTeam, 10);
		 */
	   Thread.sleep(3000);
      DefineTeambuttondrpdown.click();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
		        
	 }
	 public void clickonNewTeam()
	 {
		  SyncElement.TobeClickable(driver, NewTeam, 10);	
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
	     executor.executeScript("arguments[0].click();", NewTeam);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 //NewTeam.click();
		 
	 }
	 
	 public void clickonOpportunityCriteria_RadioButton()
	 {
		  SyncElement.TobeClickable(driver, OpportunityCriteria_RadiaBtn, 10);	
		  OpportunityCriteria_RadiaBtn.click();
		 //JavascriptExecutor executor = (JavascriptExecutor)driver;
	    // executor.executeScript("arguments[0].click();", OpportunityCriteria_RadiaBtn);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 //NewTeam.click();
	  
	 }
	 
	 
	 public void clickonContactCriteria_RadioButton()
	 {
		  SyncElement.TobeClickable(driver, ContactCriteria_RadiaBtn, 10);	
		  ContactCriteria_RadiaBtn.click();
		 //JavascriptExecutor executor = (JavascriptExecutor)driver;
	    // executor.executeScript("arguments[0].click();", OpportunityCriteria_RadiaBtn);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 //NewTeam.click();
	  
	 }
	 
	 public void clickonrecordtypeAccount() throws InterruptedException
	   {
		   
		   Teamsrecordtype.get(1).click();
		   Thread.sleep(3000);
	   }
	   
	 
	 public void clickonLeadsCriteria_RadioButton()
	 {
		  SyncElement.TobeClickable(driver, LeadCriteria_RadiaBtn, 10);	
		  LeadCriteria_RadiaBtn.click();
		 //JavascriptExecutor executor = (JavascriptExecutor)driver;
	    // executor.executeScript("arguments[0].click();", LeadCriteria_RadiaBtn);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 //NewTeam.click();
	  
	 }
	 

	public void clickOnNext()
	 {
		 //SyncElement.isElementPresnt(driver, NextButton, 10);	
		 SyncElement.TobeClickable(driver, NextButton, 10);	
		 NextButton.click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	 }
	 public void type_priority_order(String priority)
	 {
		 SyncElement.isElementPresnt(driver,  txtFieldList_CC.get(0), 10);	
		 txtFieldList_CC.get(0).sendKeys(priority);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	 }
	 public void type_Team_name(String Team)
	 {
		  SyncElement.isElementPresnt(driver,Team_name, 10);	
		  Team_name.sendKeys(Team);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	 }
	 
	 public void type_Maximum_Intake_limit(String Intake_limit)
	 {
		 SyncElement.isElementPresnt(driver,Max_intake_limit, 10);
		 Max_intake_limit.sendKeys(Intake_limit);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	 }
	 
	 public void  type_Allowed_Num_of_case(String Allowed_limit)
	 {
		 SyncElement.isElementPresnt(driver,Allowed_Num_of_open_case, 10);
		 Allowed_Num_of_open_case.sendKeys(Allowed_limit);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	 }
	 
	 public void click_save_button() throws InterruptedException
	 {
		 SyncElement.TobeClickable(driver, Save, 10);
		 Save.click();
		 Thread.sleep(5000);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		 
	 }
	 
	 public String getteamname()
	 {
		 SyncElement.isElementPresnt(driver,teamInfo, 10);
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	 
		 //System.out.println("Teamname is:"+teamname);
		 return getteamname();
	 }
	 
	 public String getTobeAssignedcount()
	 {
		 SyncElement.isElementPresnt(driver,TobeAssignedcount, 10);
		 String teamrecordcount=TobeAssignedcount.getText();
		 System.out.println("TeamCount is:"+teamrecordcount);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 return teamrecordcount;
		 
	 }
	 
	 public void scrolldowntoteamrecord() throws InterruptedException
	 {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",TobeAssignedcount );
		 SyncElement.isElementPresnt(driver,TobeAssignedcount, 10);
		 Thread.sleep(2000);
		 
	 }
	 
	 public void scrolldowntoteamrecord_ForOpportunity() throws InterruptedException
	 {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",TobeAssignedcount_ForOpportunity );
		 SyncElement.isElementPresnt(driver,TobeAssignedcount_ForOpportunity, 10);
		 Thread.sleep(2000);
		 
	 }
	 
	 public void scrolldowntoteamrecord_ForLeads() throws InterruptedException
	 {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",TobeAssignedcount_ForLeads );
		 SyncElement.isElementPresnt(driver,TobeAssignedcount_ForLeads, 10);
		 Thread.sleep(2000);
		 
	 }
	 
	public void clickonDefineTeamtab() throws InterruptedException
	{
		 SyncElement.TobeClickable(driver,DefineTeamtab, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",DefineTeamtab );
		Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		//DefineTeamtab.click();
	}
	 
	public void ProcessonSearchTeam(String str) throws InterruptedException
	{
		    SyncElement.isElementPresnt(driver,SearchTeam, 10);
			SearchTeam.clear();
			SearchTeam.sendKeys(str);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
			refreshButton.click();
			Thread.sleep(2000);
	}
	
	public void ProcessonSearch_CreatedOpportunity(String str) throws InterruptedException
	{
		    SyncElement.isElementPresnt(driver,SearchOpportunity, 10);
		    SearchOpportunity.clear();
		    SearchOpportunity.sendKeys(str);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
			refreshButton.click();
			Thread.sleep(2000);
	}
	public void clearsearchTeam() throws InterruptedException {
		 SyncElement.isElementPresnt(driver,SearchTeam, 10);
		SearchTeam.clear();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		refreshButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		Thread.sleep(2000);
	}
	
	public void clickonTeamname()
	{
		 SyncElement.TobeClickable(driver,clickonTeamId, 10);
		 clickonTeamId.click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	}
	
	public void clickonCloneOpportunity()
	{
		 SyncElement.TobeClickable(driver,clickonCloneButton, 10);
		 clickonCloneButton.click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	}
	
	public void clickonChangeOwner_IntegrationUser() throws InterruptedException
	{
		 //SyncElement.TobeClickable(driver,ChangeOwnerIcon, 10);
		 ChangeOwnerIcon.click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 SearchOwnerName.click();
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 SearchOwnerName.clear();
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 SearchOwnerName.sendKeys("Integration User");
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 SelectOwner.click();
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 ChangeOwnerButton.click();
		 Thread.sleep(5000);
	}
	
	public void clickonChangeOwner_SecurityUser() throws InterruptedException
	{
		 //SyncElement.TobeClickable(driver,ChangeOwnerIcon, 10);
		 ChangeOwnerIcon.click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 SearchOwnerName.click();
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 SearchOwnerName.clear();
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 SearchOwnerName.sendKeys("Security User");
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 SelectOwner_SecurityUser.click();
		 Thread.sleep(2000);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 ChangeOwnerButton.click();
		 Thread.sleep(5000);
	}
	
	public void scrolldowntoAccountteamrecord() throws InterruptedException
	 {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",AccountTobeAssigned );
		 SyncElement.isElementPresnt(driver,AccountTobeAssigned, 20);
		 Thread.sleep(2000);
	 }
	
}
