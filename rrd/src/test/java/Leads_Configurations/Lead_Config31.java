package Leads_Configurations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mirketa.factory.BrowserFactory;
import com.mirketa.factory.DataProviderFactory;
import com.mirketa.pages.HomePage;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.pages.Step1ConfigurationPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Lead_Config31 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;
	public String Lead_Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData"
			+ File.separator + "Lead_ConfigData.xlsx";

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/Lead_Configuration31.html");
		logger = report.startTest("Verify Lead Configuration31");
		logger.log(LogStatus.INFO, "Open Browser and type url in address bar");
		driver = BrowserFactory.getBrowser("chrome");
		logger.log(LogStatus.INFO, "Salesforce login page is loading.");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");

		SalesForceLoginPage salesForceLoginPage = PageFactory.initElements(driver, SalesForceLoginPage.class);
		salesForceLoginPage.loginApplicaiton(DataProviderFactory.getExcel().getData(0, 1, 0),
				DataProviderFactory.getExcel().getData(0, 1, 1));
		logger.log(LogStatus.INFO, "Login into application");
		Thread.sleep(2000);
		RRDSearchpage rrdsearch = PageFactory.initElements(driver, RRDSearchpage.class);

		rrdsearch.appclick();
		logger.log(LogStatus.INFO, "Succesfully Clicked on Applauncher");
		rrdsearch.RRdsearch();
		logger.log(LogStatus.INFO, "Succesfully search the RRD");

		rrdsearch.RRDdrpdwnselection();
		logger.log(LogStatus.INFO,"Succesfully  RRD selection from Dropdown and Directed to RRDHome page successfully");
		Thread.sleep(31000);

	}

	@Test
	public void Test_Config31() throws InterruptedException {

		Xls_Reader reader = new Xls_Reader(Lead_Testdata_sheet_path);

		int rowCount = reader.getRowCount("Lead_Config31");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String sUser1 = reader.getCellData("Lead_Config31", "Enable_RRD_Users", rowNum);
			String sOwnerNotification = reader.getCellData("Lead_Config31", "ownerNotification", rowNum);
			String sReleationshipBasedAssignment = reader.getCellData("Lead_Config31", "Rel_Based_Asgmt", rowNum);
			String EO_RBA_LeadField = reader.getCellData("Lead_Config31", "EO_Lead Fields", rowNum);
			String EO_RBA_OpportunityField = reader.getCellData("Lead_Config31", "EO_Opportunity Fields", rowNum);

			HomePage homePage = PageFactory.initElements(driver, HomePage.class);

			homePage.clickOnStep1Configuration();
			logger.log(LogStatus.INFO, "click on step1 configuration tab");

			Step1ConfigurationPage step1ConfigPage = PageFactory.initElements(driver, Step1ConfigurationPage.class);

			step1ConfigPage.navigatetoIframeCaseConfig();
			logger.log(LogStatus.INFO, "Navigate to iframe");

			step1ConfigPage.clickOnEditButton();
			logger.log(LogStatus.INFO, "click on edit button");

			step1ConfigPage.clickOnLeads();
			logger.log(LogStatus.INFO, "click on lead tab");

			step1ConfigPage.select_lead_RRDUser(sUser1);
			logger.log(LogStatus.INFO, "Select user from drop down value");

			step1ConfigPage.Lead_OwnerNotification(sOwnerNotification);
			logger.log(LogStatus.INFO, "Select owner notification from drop down value");

			step1ConfigPage.QueueAssignment_Unchecked();
			logger.log(LogStatus.INFO, " Selecting Queue assignment Checkbox");

			step1ConfigPage.Select_Lead_Relationship_Based_Asignment(sReleationshipBasedAssignment);
			logger.log(LogStatus.INFO, "Select Relationship based assignment value from drop down");
			
			step1ConfigPage.Leads_RBAFilter_Unchecked();
			logger.log(LogStatus.INFO, "Selecting RBA Filter Checkbox");
			
			step1ConfigPage.Select_Lead_RBA_ExistingOpportunity_LeadField(EO_RBA_LeadField);
			logger.log(LogStatus.INFO, "Select Relationship based assignment Existing Opportunity Leads Field value from drop down");
			
			step1ConfigPage.Select_Lead_RBA_ExistingOpportunity_OpportunityField(EO_RBA_OpportunityField);
			logger.log(LogStatus.INFO, "Select Relationship based assignment Exisiting opportunity based opportunity Field value from drop down");
			
			step1ConfigPage.clickOnSaveButton();
			logger.log(LogStatus.INFO, "click on save button to save data");
			try {
				Assert.assertTrue(step1ConfigPage.isEditButtonVisible(),"Lead Configuration data was  not submitted successfully");
			} catch (Exception e) {
				System.out.println("Assertion is not working");
			}
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Lead configuration data saved successfully");

		}
	}

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
