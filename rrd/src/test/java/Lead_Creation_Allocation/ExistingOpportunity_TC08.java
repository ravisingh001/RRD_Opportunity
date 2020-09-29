package Lead_Creation_Allocation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.mirketa.factory.BrowserFactory;
import com.mirketa.factory.DataProviderFactory;
import com.mirketa.pages.Accountpage;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.RRD_New_Case_page;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExistingOpportunity_TC08 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;

	public String Lead_Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "Leads_Allocation.xlsx";
	
	public String Lead_ExistingOpportunity_sheet_path = System.getProperty("user.dir") + File.separator + "AppData"
			+ File.separator + "Lead_ExistingOpportunity.xlsx";

	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/LeadCreation_ExistingOpportunity_TC08.html");
		logger = report.startTest("Verify Lead Creation ExistingOpportunity_TC08");
		logger.log(LogStatus.INFO, "Open Browser and type url in address bar");
		driver = BrowserFactory.getBrowser("chrome");
		logger.log(LogStatus.INFO, "Salesforce login page is loading.");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
		driver.manage().deleteAllCookies();
		logger.log(LogStatus.INFO, "Application is Cleared with all cookies");
		SalesForceLoginPage salesForceLoginPage = PageFactory.initElements(driver, SalesForceLoginPage.class);
		salesForceLoginPage.loginApplicaiton(DataProviderFactory.getExcel().getData(0, 1, 0),
				DataProviderFactory.getExcel().getData(0, 1, 1));
		logger.log(LogStatus.INFO, "Login into application");
		Thread.sleep(5000);
		RRDSearchpage rrdsearch = PageFactory.initElements(driver, RRDSearchpage.class);

		rrdsearch.appclick();
		logger.log(LogStatus.INFO, "Succesfully Clicked on Applauncher");

		rrdsearch.RRdsearch();
		logger.log(LogStatus.INFO, "Succesfully search the RRD");

		rrdsearch.RRDdrpdwnselection();
		logger.log(LogStatus.INFO,"Succesfully  RRD selection from Dropdown and Directed to RRDHome page successfully");

	}

	@Test
	public void LeadCreation_ExistingOpportunity_TC08() throws InterruptedException {

		RRD_New_Case_page Leadobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
		
		Leadobj.clickOnMore_ToSelect_Opportunity();
		logger.log(LogStatus.INFO, "Successfully clicked on More Tab");
		Thread.sleep(4000);
		Leadobj.clickOnMore_OpportunityTab();
		logger.log(LogStatus.INFO, "Successfully clicked on Opportunity Button");
		Thread.sleep(4000);

		Xls_Reader reader = new Xls_Reader(Lead_ExistingOpportunity_sheet_path);

		int rowCount = reader.getRowCount("ExistingOpportunity_TC08");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			try {
				String Amount = reader.getCellData("ExistingOpportunity_TC08", "Amount", rowNum);
				String Closedate = reader.getCellData("ExistingOpportunity_TC08", "Close date", rowNum);
				String Stages = reader.getCellData("ExistingOpportunity_TC08", "Stages", rowNum);
				String OpportunityName = reader.getCellData("ExistingOpportunity_TC08", "Opportunity Name", rowNum);
				String AccountName = reader.getCellData("ExistingOpportunity_TC08", "Account Name", rowNum);
				String Ratingtype = reader.getCellData("ExistingOpportunity_TC08", "Ratingtype", rowNum);
				String RRD_Type = reader.getCellData("ExistingOpportunity_TC08", "RRD_Type", rowNum);
				String RRD_LeadSource = reader.getCellData("ExistingOpportunity_TC08", "RRD_LeadSource", rowNum);
				String Discription = reader.getCellData("ExistingOpportunity_TC08", "Discription", rowNum);
				String ExpectedResult = reader.getCellData("ExistingOpportunity_TC08", "ExpectedResult", rowNum);
				

				Thread.sleep(5000);
				Leadobj.clickOnDefine_Opportunity();
				logger.log(LogStatus.INFO, "Successfully clicked on Define Opportunity");
				Thread.sleep(4000);

				Leadobj.clickOnNew_ForOpportunity();
				logger.log(LogStatus.INFO, "Successfully clicked on New case");
				Thread.sleep(3000);
				Leadobj.pickAmount(Amount);
				logger.log(LogStatus.INFO, "Successfully picked Amount from list ");

				Leadobj.pickCloseDate(Closedate);
				logger.log(LogStatus.INFO, "Successfully picked Close Date ");

				Leadobj.pickStage(Stages);
				logger.log(LogStatus.INFO, "Successfully picked Stage ");

				Leadobj.pickOpportunityName(OpportunityName);
				logger.log(LogStatus.INFO, "Successfully picked Opportunity Name ");

				// scrolling

				Leadobj.scrolldowntosearchAcc();

				Leadobj.clicksearchAcc();
				logger.log(LogStatus.INFO, "Successfully clicked the search Account value ");

				Accountpage Accobj = PageFactory.initElements(driver, Accountpage.class);
				Accobj.clickOnNewAccount();
				logger.log(LogStatus.INFO, "Successfully clicked on New  Account ");

				Accobj.ClickonAccountName(AccountName);
				logger.log(LogStatus.INFO, "Enter account name");

				Accobj.clickingRating();
				logger.log(LogStatus.INFO, "click on Rating Type");

				Accobj.pickrating(Ratingtype);
				logger.log(LogStatus.INFO, "Picked  Rating Type");

				Accobj.clickonsave();
				logger.log(LogStatus.INFO, "Successfully clicked on save");

				Leadobj.scrolldowntopicktype();
				logger.log(LogStatus.INFO, "Scroll down to pick Type from drop down");

				Leadobj.pickfromOpp_Type(RRD_Type);
				logger.log(LogStatus.INFO, "Successfully picked from type ");

				Leadobj.pickfromOpp_LeadSource(RRD_LeadSource);
				logger.log(LogStatus.INFO, "Successfully picked from Lead Source ");

				Leadobj.TypeDescription(Discription);
				logger.log(LogStatus.INFO, "Successfully entered the description");

				Leadobj.clickOnSave();
				logger.log(LogStatus.INFO, "Successfully saved  the new added case and Directed to Case Details page ");

				driver.navigate().refresh();
				Thread.sleep(10000);

				driver.navigate().refresh();

				try {
					System.out.println("Assigned RRD user  from sheet - " + ExpectedResult);
					String Username = Leadobj.AssignedOpportunityRRDHover.getText();
					System.out.println("Assigned case owner is:" + Username);
					softassert.assertTrue(Username.equalsIgnoreCase(ExpectedResult),"Assigned RRD user name is not matching");
				}

				catch (Exception e)
				{
					System.out.println("Assigned RRD user  from sheet - " + ExpectedResult);
					String Username = Leadobj.AssignedOpportunityRRDHover.getText();
					System.out.println("Assigned case owner is:" + Username);
					softassert.assertTrue(Username.equalsIgnoreCase(ExpectedResult),"Assigned RRD user name is not matching");
				}}finally {
				// ... cleanup that will execute whether or not an error occurred ...
			}}
		
		Xls_Reader Reader = new Xls_Reader(Lead_Testdata_sheet_path);

		int RowCount = Reader.getRowCount("ExistingOpportunity_TC08");
		for (int RowNum = 2; RowNum <= RowCount; RowNum++) {

			try {
				String Phone = Reader.getCellData("ExistingOpportunity_TC08", "Phone", RowNum);
				String LastName = Reader.getCellData("ExistingOpportunity_TC08", "Last Name", RowNum);
				String Company = Reader.getCellData("ExistingOpportunity_TC08", "Company", RowNum);
				String LeadStatus = Reader.getCellData("ExistingOpportunity_TC08", "Lead Status", RowNum);
				String Country = reader.getCellData("LeadRBAFilters_TC14_1", "Country", RowNum);
				String Discription = Reader.getCellData("ExistingOpportunity_TC08", "Discription", RowNum);
				String ExpectedResult = Reader.getCellData("ExistingOpportunity_TC08", "ExpectedResult", RowNum);

				Thread.sleep(5000);
				Leadobj.clickOn_Leads();
				logger.log(LogStatus.INFO, "Successfully clicked on Define Leads Tab");
				Thread.sleep(4000);

				Leadobj.clickOnNew_Leads();
				logger.log(LogStatus.INFO, "Successfully clicked on New Lead");
				Thread.sleep(3000);
				
				Leadobj.pickPhone(Phone);
				logger.log(LogStatus.INFO, "Successfully picked phone from list ");

				Leadobj.pickLastName(LastName);
				logger.log(LogStatus.INFO, "Successfully picked Last Name ");

				Leadobj.pickcompany(Company);
				logger.log(LogStatus.INFO, "Successfully picked Company");
				
				Leadobj.pickLeadStatus(LeadStatus);
				logger.log(LogStatus.INFO, "Successfully picked Lead Status");
				
				// scrolling

				Leadobj.scrolldowntoViewDiscription();
				Leadobj.pickCountry(Country);
				logger.log(LogStatus.INFO, "Successfully picked Lead country");
				
				Leadobj.TypeDescription(Discription);
				logger.log(LogStatus.INFO, "Successfully entered the description");

				Leadobj.clickOnSave();
				logger.log(LogStatus.INFO, "Successfully saved  the new added lead and Directed to lead Details page ");

				driver.navigate().refresh();
				Thread.sleep(6000);

				driver.navigate().refresh();
				Thread.sleep(6000);
				Leadobj.clickOnDetailsTab();
				logger.log(LogStatus.INFO, "Successfully switched to lead Details page ");
				
				try {
					System.out.println("Assigned RRD user  from sheet - " + ExpectedResult);
					String Username = Leadobj.AssignedLead_RRDHover.getText();
					System.out.println("Assigned case owner is:" + Username);
					softassert.assertTrue(Username.equalsIgnoreCase(ExpectedResult),"Assigned RRD user name is not matching");
				}
				catch (Exception e)
				{
					System.out.println("Assigned RRD user  from sheet - " + ExpectedResult);
					String Username = Leadobj.AssignedLead_RRDHover.getText();
					System.out.println("Assigned case owner is:" + Username);
					softassert.assertTrue(Username.equalsIgnoreCase(ExpectedResult),"Assigned RRD user name is not matching");
				}	
				if(driver.findElements(By.xpath("//span[@class='uiOutputTextArea']")).size()!= 0){ 
						 System.out.println("Lead assigment is done through RBA"); } 
					 else{
					  System.out.println("Lead assigment is not done  through RBA"); }
				
		}finally {
			// ... cleanup that will execute whether or not an error occurred ...
		}}}
	

	@AfterMethod
	public void teardown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
