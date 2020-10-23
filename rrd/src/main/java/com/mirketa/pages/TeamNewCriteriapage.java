package com.mirketa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.mirketa.utility.SyncElement;

public class TeamNewCriteriapage {

	WebDriver driver;

	public TeamNewCriteriapage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "(//button[@class='test-id__section-header-button slds-section__title-action slds-button'])[4]")
	WebElement CriteriaField;

	@FindBy(xpath = "//input[@class='btn'][@title='New Criteria']")
	WebElement Newcriterabtn;

	@FindBy(xpath = "//div[@id='j_id0:theForm:thePageBlockOne:j_id150']//input[@value='New Criteria']")
	WebElement Leads_Newcriterabtn;

	//closed for older package test
	
	  @FindBy(xpath =
	  "//table/tbody/tr//td//select[@name='j_id0:frm:pb:pbs:j_id8']") WebElement
	  SelectField;
	 
	//closed for New package test
	/*
	 * @FindBy(xpath =
	 * "//table/tbody/tr//td//select[@name='j_id0:frm:pb:pbs:j_id7']") WebElement
	 * SelectField;
	 */

	@FindBy(xpath = "//select[@name='j_id0:theForm:thePageBlockOne:j_id150:pg:table:0:j_id155']")
	WebElement SelectFieldLabel;
	
	@FindBy(xpath = "//select[@name='j_id0:theForm:thePageBlockOne:j_id150:pg:table:1:j_id155']")
	WebElement SelectFieldLabel_2;
	//closed for older package test
	
	  @FindBy(xpath =
	  "//table/tbody/tr//td//select[@name='j_id0:frm:pb:pbs:j_id12']") WebElement
	  SelectOperator;
	 
	//closed for new package test
		/*
		 * @FindBy(xpath =
		 * "//table/tbody/tr//td//select[@name='j_id0:frm:pb:pbs:j_id10']") WebElement
		 * SelectOperator;
		 */

	@FindBy(xpath = "//select[@name='j_id0:theForm:thePageBlockOne:j_id150:pg:table:0:j_id158']")
	WebElement LeadConfig_SelectOperator;
	
	@FindBy(xpath = "//select[@name='j_id0:theForm:thePageBlockOne:j_id150:pg:table:1:j_id158']")
	WebElement LeadConfig_SelectOperator_2;

	@FindBy(xpath = "//table/tbody/tr//td//input[@type='text']")
	WebElement Field_value;

	@FindBy(xpath = "//input[@name='j_id0:theForm:thePageBlockOne:j_id150:pg:table:0:j_id161']")
	WebElement LC_Field_value;

	@FindBy(xpath = "//input[@name='j_id0:theForm:thePageBlockOne:j_id150:pg:table:1:j_id161']")
	WebElement LC_Field_value_2;

	@FindBy(xpath = "//table/tbody/tr//td//input[@type='submit' and @value='Save']")
	WebElement save;

	@FindBy(xpath = "//option[contains(text(),'New Customer')]")
	WebElement NewCustomer;

	@FindBy(xpath = "//input[@name='j_id0:frm:pb:pbs:j_id16']")
	WebElement NewCustomer_AddButton;

	@FindBy(xpath = "//iframe[@title='accessibility title']")
	WebElement iframeCriteria;

	@FindBy(xpath = "//input[@name='j_id0:criteriaForm:pg:editCustomLogic' and @type='submit' and @value='Edit']")
	WebElement Edit;

	@FindBy(xpath = "//input[@name='j_id0:criteriaForm:pg:customFilterLogic' and @type='text']")
	WebElement AddcriteriaLogicfield;

	@FindBy(xpath = "//input[@name='j_id0:theForm:thePageBlockOne:j_id150:pg:customFilterLogic']")
	WebElement LC_criteriaLogicfield;

	@FindBy(xpath = "//input[@name='j_id0:criteriaForm:pg:submitCustomLogic' and @class='btn' and @value='Submit']")
	WebElement submit;

	

	public void navigateToCriteria() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().frame(iframeCriteria);
		Thread.sleep(3000);

	}

	public void navigatebacktoParent() throws InterruptedException {
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}

	public void scrolldowntoNewcriteria() throws InterruptedException {
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		Thread.sleep(3000);

	}

	public void Editcriteria() throws InterruptedException {
		SyncElement.TobeClickable(driver, Edit, 20);
		Edit.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	public void submitcriteria() throws InterruptedException {
		SyncElement.TobeClickable(driver, submit, 20);
		submit.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}

	public void AddCriteriaLogic(String logic) throws InterruptedException {
		SyncElement.isElementPresnt(driver, AddcriteriaLogicfield, 20);

		AddcriteriaLogicfield.sendKeys(logic);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);

	}

	public void LeadConfig_CriteriaLogic(String logic) throws InterruptedException {
		SyncElement.isElementPresnt(driver, LC_criteriaLogicfield, 20);

		LC_criteriaLogicfield.sendKeys(logic);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);

	}
	
	public void LeadConfig_CriteriaLogic_ClearField() throws InterruptedException {
		SyncElement.isElementPresnt(driver, LC_criteriaLogicfield, 20);

		LC_criteriaLogicfield.clear();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);

	}


	public void okalert() throws InterruptedException {
		driver.switchTo().alert().accept();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	public void clickOncriteriaField() {
		CriteriaField.click();
	}

	public void ClickonNewcriteria() throws InterruptedException {
		try {
			if (Newcriterabtn.isDisplayed())

			{
				Newcriterabtn.click();
			}
			Thread.sleep(5000);
		} catch (Exception e) {
			CriteriaField.click();
			Thread.sleep(3000);
			Newcriterabtn.click();
			Thread.sleep(5000);
		}
	}

	public void ClickonLeads_NewcriteriaBtn() throws InterruptedException {
		try {
			if (Leads_Newcriterabtn.isDisplayed())

			{
				Leads_Newcriterabtn.click();
			}
			Thread.sleep(5000);
		} catch (Exception e) {
			Leads_Newcriterabtn.click();
			Thread.sleep(3000);
			Leads_Newcriterabtn.click();
			Thread.sleep(5000);
		}
	}

	public void SelectfromField(String criteria) throws InterruptedException {
		SyncElement.isElementPresnt(driver, SelectField, 20);
		Select sel = new Select(SelectField);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sel.selectByVisibleText(criteria);

		Thread.sleep(5000);
	}

	public void Select_LEADConfig_fromField(String criteria) throws InterruptedException {
		SyncElement.isElementPresnt(driver, SelectFieldLabel, 20);
		Select sel = new Select(SelectFieldLabel);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sel.selectByVisibleText(criteria);
		Thread.sleep(5000);
	}
	
	public void Select_LEADConfig_fromField_2(String criteria) throws InterruptedException {
		SyncElement.isElementPresnt(driver, SelectFieldLabel_2, 20);
		Select sel = new Select(SelectFieldLabel_2);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sel.selectByVisibleText(criteria);
		Thread.sleep(5000);
	}

	public void SelectfromOPerator(String operator) throws InterruptedException {
		SyncElement.isElementPresnt(driver, SelectOperator, 20);
		Select sel = new Select(SelectOperator);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		sel.selectByVisibleText(operator);
		Thread.sleep(5000);
	}

	public void Select_LEADConfig_fromOPerator(String operator) throws InterruptedException {
		SyncElement.isElementPresnt(driver, LeadConfig_SelectOperator, 20);
		Select sel = new Select(LeadConfig_SelectOperator);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sel.selectByVisibleText(operator);
		Thread.sleep(5000);
	}
	
	public void Select_LEADConfig_fromOPerator_2(String operator) throws InterruptedException {
		SyncElement.isElementPresnt(driver, LeadConfig_SelectOperator_2, 20);
		Select sel = new Select(LeadConfig_SelectOperator_2);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		sel.selectByVisibleText(operator);
		Thread.sleep(5000);
	}


	public void Enterthefieldval(String field) throws InterruptedException {
		SyncElement.isElementPresnt(driver, Field_value, 20);
		Field_value.sendKeys(field);
		Thread.sleep(5000);
	}

	public void Enterthe_LEADConfig_fieldval(String field) throws InterruptedException {
		SyncElement.isElementPresnt(driver, LC_Field_value, 20);
		LC_Field_value.sendKeys(field);
		Thread.sleep(5000);
	}
	
	public void Enterthe_LEADConfig_fieldval_2(String field) throws InterruptedException {
		SyncElement.isElementPresnt(driver, LC_Field_value_2, 20);
		LC_Field_value_2.sendKeys(field);
		Thread.sleep(5000);
	}

	public void ClickonAdd_NewCustomer() throws InterruptedException {
		Thread.sleep(3000);
		NewCustomer.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		NewCustomer_AddButton.click();
		Thread.sleep(3000);
	}

	public void Clickonsave() throws InterruptedException {
		SyncElement.TobeClickable(driver, Field_value, 20);
		save.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Thread.sleep(6000);
	}

	public void newCriteriaTeam() {
		try {
			driver.findElement(By.linkText("New Criteria")).click();
		} catch (Exception e) {

		}
	}

	
	  public int getMultipleCriteriaCount() { 
	List<WebElement>criteria=driver.findElements(By.xpath("//table[@id=\"j_id0:criteriaForm:pg:table\"]//tr"));
	 System.out.println("getMultipleCriteriaCount size: "+criteria.size());
	  
	  return criteria.size();
	  
	  } 
	  
	  public void addLogicAndSubmitCriteria(String logic) {
	 
	  try { if (getMultipleCriteriaCount()>1) { 
	Editcriteria(); 
	Thread.sleep(5000);
	 System.out.println("edit criteria"); 
	 AddCriteriaLogic(logic);
	 Thread.sleep(5000); 
	 System.out.println("add criteria"); 
	 submitcriteria();
	 Thread.sleep(5000); 
	 System.out.println("submit criteria"); } }
	  catch(Exception e) { 
		  e.printStackTrace(); 
		  } }
	
	public void scrollToElement(WebElement webby) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", webby);
	}

	public void scrollPage(String to) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if (to.equals("end"))
			executor.executeScript(
					"window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		else if (to.equals("top"))
			executor.executeScript(
					"window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
		else
			throw new Exception("Exception : Invalid Direction (only scroll \"top\" or \"end\")");
	}

	
}
