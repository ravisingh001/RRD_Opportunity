package com.mirketa.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.mirketa.utility.SyncElement;

public class Step1ConfigurationPage {
	WebDriver driver;

	public Step1ConfigurationPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath="//span[contains(text(),'Step 1-Configuration')]")
	WebElement Step1config;
	
	@FindBy(xpath="//tr//td[@class='rich-tabhdr-side-cell']//td[contains(text(),'Case')]")
	WebElement clickoncase;
	
	@FindBy(xpath="//tr//td[@class='rich-tabhdr-side-cell']//td[contains(text(),'Opportunity')]")
	WebElement clickonOpportunity;
	
	@FindBy(xpath="//tr//td[@class='rich-tabhdr-side-cell']//td[contains(text(),'Lead')]")
	WebElement clickonLead;

	
	@FindBy(xpath = "//input[@value='Edit']")
	WebElement EditButton;

	@FindBy(xpath = "//input[@value='Save']")
	WebElement SaveButton;
	
	@FindBy(xpath = "//td//input[@id='j_id0:theForm:thePageBlockOne:j_id106:j_id107']")
	WebElement QueueAssignment_checkbox;

	@FindBy(xpath = "//td//input[@id='j_id0:theForm:thePageBlockOne:RBA_hideDiv_pb:RBA_hideDiv:enableCheckBox']")
	WebElement RBAFilter_checkbox;
	
	@FindBy(xpath = "//iframe[@title='accessibility title']")
	WebElement iframeStep1Config;

	@FindBy(xpath = "(//select[contains(@name,'j_id0:theForm:thePageBlockOne:showpgaeblocksectionCase:j_id')])[1]")
	WebElement selectUser;
	
	@FindBy(xpath = "/descendant::select[@class='opp-drop'][2]")
	WebElement select_Opp_User;
	
	@FindBy(xpath = "//*[@id=\"j_id0:theForm:thePageBlockOne:showpgaeblocksection\"]/div/table/tbody/tr/td[1]/select")
	WebElement select_Lead_RRDUser;
	
	@FindBy(xpath = "//select[@name='j_id0:theForm:thePageBlockOne:j_id257:j_id258']")
	WebElement SelectUserDisableMode;

	@FindBy(xpath = "(//select[contains(@name,'j_id0:theForm:thePageBlockOne:showpgaeblocksectionCase:j_id')])[2]")
	WebElement OwnerNotification;
	
	@FindBy(xpath = "(//select[contains(@name,'j_id0:theForm:thePageBlockOne:showpgaeblocksectionOpp1:j_id')])[2]")
	WebElement Opp_OwnerNotification;
	
	@FindBy(xpath = "(//select[contains(@name,'j_id0:theForm:thePageBlockOne:showpgaeblocksection:j_id')])[2]")
	WebElement Lead_OwnerNotification;

	@FindBy(xpath = "(//td[@class='dataCol first']//select[starts-with(@name,'j_id0:theForm:thePageBlockOne:j_id') and @class='drop'])[1]")
	WebElement Relationship_Based_Asignment;
	
	@FindBy(xpath = "(//select[contains(@name,'j_id0:theForm:thePageBlockOne:showpgaeblocksectionOppNotification:j_id')])[1]")
	WebElement Opp_Relationship_Based_Asignment;
	
	@FindBy(xpath = "(//select[contains(@name,'j_id0:theForm:thePageBlockOne:RBA_hideDiv_pb:j_id110:assignment_type')])")
	WebElement Lead_Relationship_Based_Asignment;
	
	@FindBy(xpath = "//td//select[@name='j_id0:theForm:thePageBlockOne:showRBA:j_id127:j_id128']")
	WebElement Lead_Relationship_Based_Asignment_LeadField;

	@FindBy(xpath = "//td[@class='dataCol']//input[starts-with(@id,'j_id0:theForm:thePageBlockOne:j_id') and @type='checkbox']")
	WebElement QueueAssignmentCheckbox;

	@FindBy(xpath = "//td[@class='dataCol last']//input[starts-with(@id,'j_id0:theForm:thePageBlockOne:j_id121:j_id132') and @type='checkbox']")
	WebElement HandleManualAssignmentCheckbox;

	@FindBy(xpath = "//td[@class='dataCol first']//input[starts-with(@id,'j_id0:theForm:thePageBlockOne:j_id') and @type='checkbox']")
	WebElement HandleHighPriorityCaseCheckbox;

	@FindBy(xpath = "//td[@class='dataCol']//input[@type='text']")
	WebElement CasePriorityInputBox;

	
	
	public void clickonstepconfig()
	{

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Step1config);
		
	}
	

	public void clickOnEditButton() throws InterruptedException {
		SyncElement.TobeClickable(driver, EditButton, 30);
		EditButton.click();
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	public boolean isEditButtonVisible() {
		return EditButton.isDisplayed();
	}

	public void clickOnSaveButton() throws InterruptedException {
		SyncElement.TobeClickable(driver, SaveButton, 30);
		SaveButton.click();
		Thread.sleep(4000);
		
	}

	public void clickOnCase() throws InterruptedException {
		SyncElement.TobeClickable(driver, clickoncase, 30);
		clickoncase.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void clickOnOpportunity() throws InterruptedException {
		SyncElement.TobeClickable(driver, clickonOpportunity, 30);
		clickonOpportunity.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void clickOnLeads() throws InterruptedException {
		SyncElement.TobeClickable(driver, clickonLead, 30);
		clickonLead.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void navigatetoIframeCaseConfig() {
		driver.switchTo().frame(iframeStep1Config);
	}
	
	public void navigatebacktoParent()
	{
		driver.switchTo().defaultContent();
	}

	public void Opp_OwnerNotification(String owner) throws InterruptedException {
		SyncElement.isElementPresnt(driver, Opp_OwnerNotification, 20);
		Select sel = new Select(Opp_OwnerNotification);
		Opp_OwnerNotification.click();
		sel.selectByVisibleText(owner);
		Thread.sleep(4000);

	}
	
	public void Lead_OwnerNotification(String owner) throws InterruptedException {
		SyncElement.isElementPresnt(driver, Lead_OwnerNotification, 20);
		Select sel = new Select(Lead_OwnerNotification);
		Lead_OwnerNotification.click();
		sel.selectByVisibleText(owner);
		Thread.sleep(4000);

	}
	
	public void selecctOwnerNotication(String owner) throws InterruptedException {
		SyncElement.isElementPresnt(driver, OwnerNotification, 20);
		Select sel = new Select(OwnerNotification);
		OwnerNotification.click();
		sel.selectByVisibleText(owner);
		Thread.sleep(4000);

	}

	public void selectUser(String user) throws InterruptedException {
		SyncElement.isElementPresnt(driver, selectUser, 20);
		Select sel = new Select(selectUser);
		selectUser.click();
		sel.selectByVisibleText(user);
		Thread.sleep(4000);
	}
	
	public void select_Opp_User(String user) throws InterruptedException {
		SyncElement.isElementPresnt(driver, select_Opp_User, 20);
		Select sel = new Select(select_Opp_User);
		select_Opp_User.click();
		sel.selectByVisibleText(user);
		Thread.sleep(4000);
	}
	
	public void select_lead_RRDUser(String user) throws InterruptedException {
		SyncElement.isElementPresnt(driver, select_Lead_RRDUser, 20);
		Select sel = new Select(select_Lead_RRDUser);
		select_Lead_RRDUser.click();
		sel.selectByVisibleText(user);
		Thread.sleep(4000);
	}
	
	
	
	
	public String getSelectedUserValue()
	{
		Select sel = new Select(SelectUserDisableMode);
		WebElement selectedValue=sel.getFirstSelectedOption();
		return selectedValue.getText();
	}
	
	

	public void selectRelationship_Based_Asignment(String str) throws InterruptedException {
		SyncElement.isElementPresnt(driver, Relationship_Based_Asignment, 20);
		Select sel = new Select(Relationship_Based_Asignment);
		Relationship_Based_Asignment.click();
		sel.selectByVisibleText(str);
		Thread.sleep(2000);
	}
	
	public void Select_Opp_Relationship_Based_Asignment(String str) throws InterruptedException {
		SyncElement.isElementPresnt(driver, Opp_Relationship_Based_Asignment, 20);
		Select sel = new Select(Opp_Relationship_Based_Asignment);
		Opp_Relationship_Based_Asignment.click();
		sel.selectByVisibleText(str);
		Thread.sleep(2000);
	}
	
	public void Select_Lead_Relationship_Based_Asignment(String str) throws InterruptedException {
		SyncElement.isElementPresnt(driver, Lead_Relationship_Based_Asignment, 20);
		Select sel = new Select(Lead_Relationship_Based_Asignment);
		Lead_Relationship_Based_Asignment.click();
		sel.selectByVisibleText(str);
		Thread.sleep(2000);
	}
	
	public void Select_Lead_Relationship_Based_Asignment_LeadField(String str) throws InterruptedException {
		SyncElement.isElementPresnt(driver, Lead_Relationship_Based_Asignment_LeadField, 20);
		Select sel = new Select(Lead_Relationship_Based_Asignment_LeadField);
		Lead_Relationship_Based_Asignment_LeadField.click();
		sel.selectByVisibleText(str);
		Thread.sleep(2000);
	}
	

	public void clickOnHandleManualAssignmentCheckbox() throws InterruptedException {
		
		HandleManualAssignmentCheckbox.click();
		Thread.sleep(2000);
	}

	public void unCheckHandleManualAssignmentCheckbox() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (HandleManualAssignmentCheckbox.isSelected()) {
			HandleManualAssignmentCheckbox.click();
		}
		Thread.sleep(2000);
	}

	public void clickOnCheckQueueAssignmentCheckbox() throws InterruptedException {
		QueueAssignmentCheckbox.click();
		Thread.sleep(2000);
	}

	public void unCheckQueueAssignmentCheckbox() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (QueueAssignmentCheckbox.isSelected()) {
			QueueAssignmentCheckbox.click();
		}
		Thread.sleep(2000);
	}

	public void clickOnHandleHighPriorityCaseCheckbox() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HandleHighPriorityCaseCheckbox.click();
		Thread.sleep(2000);
	}

	public void unCheckHandleHighPriorityCaseCheckbox() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (HandleHighPriorityCaseCheckbox.isSelected()) {
			HandleHighPriorityCaseCheckbox.click();
		}
		Thread.sleep(3000);
	}

	public void enterCasePriority(String str) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CasePriorityInputBox.clear();
		CasePriorityInputBox.sendKeys(str);
		Thread.sleep(3000);
	}
	
	public void ClearCasePriority() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		CasePriorityInputBox.clear();
		
		Thread.sleep(3000);
	}

	public void QueueAssignment_Checked() throws InterruptedException {
		Thread.sleep(4000);
		
		if(!QueueAssignment_checkbox.isSelected()) {
			QueueAssignment_checkbox.click();
			System.out.println("Checkbox is now selected");
		}else {
			System.out.println("CheckBox is selected on default");
		}	
	}
	
	public void QueueAssignment_Unchecked() throws InterruptedException {
		Thread.sleep(4000);
		
		if(QueueAssignment_checkbox.isSelected()) {
			System.out.println("Checkbox is selected on default");
			Thread.sleep(2000);
			QueueAssignment_checkbox.click();
			System.out.println("Checkbox is now unchecked");
		}else {
			System.out.println("Checkbox is Unchecked");
		}	
	}
	
	public void Leads_RBAFilter_Checked() throws InterruptedException {
		Thread.sleep(4000);
		
		if(!RBAFilter_checkbox.isSelected()) {
			RBAFilter_checkbox.click();
			System.out.println("Checkbox is now selected");
		}else {
			System.out.println("CheckBox is selected on default");
		}	
	}
	
	public void Leads_RBAFilter_Unchecked() throws InterruptedException {
		Thread.sleep(4000);
		
		if(RBAFilter_checkbox.isSelected()) {
			System.out.println("Checkbox is selected on default");
			Thread.sleep(2000);
			RBAFilter_checkbox.click();
			System.out.println("Checkbox is now unchecked");
		}else {
			System.out.println("Checkbox is Unchecked");
		}	
	}

	
}
