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
import com.mirketa.pages.TeamNewCriteriapage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Lead_Config19 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;
	public String Lead_Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData"
			+ File.separator + "Lead_ConfigData.xlsx";

	public String Lead_ConfigCriteria_sheet_path = System.getProperty("user.dir") + File.separator + "AppData"
			+ File.separator + "Lead_Config_CriteriaLogic.xlsx";

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/Lead_Configuration19.html");
		logger = report.startTest("Verify Lead Configuration19");
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
		logger.log(LogStatus.INFO,
				"Succesfully  RRD selection from Dropdown and Directed to RRDHome page successfully");
		Thread.sleep(19000);

	}

	@Test
	public void Test_Config19() throws InterruptedException {

		Xls_Reader reader = new Xls_Reader(Lead_Testdata_sheet_path);

		int rowCount = reader.getRowCount("Lead_Config19");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String sUser1 = reader.getCellData("Lead_Config19", "Enable_RRD_Users", rowNum);
			String sOwnerNotification = reader.getCellData("Lead_Config19", "ownerNotification", rowNum);
			String sReleationshipBasedAssignment = reader.getCellData("Lead_Config19", "Rel_Based_Asgmt", rowNum);
			String RBA_LeadField = reader.getCellData("Lead_Config19", "Lead Fields", rowNum);

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

			step1ConfigPage.Leads_RBAFilter_Checked();
			logger.log(LogStatus.INFO, "Selecting RBA Filter Checkbox");

			step1ConfigPage.Select_Lead_Relationship_Based_Asignment_LeadField(RBA_LeadField);
			logger.log(LogStatus.INFO, "Select Relationship based assignment Lead Field value from drop down");

			Xls_Reader Reader = new Xls_Reader(Lead_ConfigCriteria_sheet_path);
			int Criteriacount = Reader.getRowCount("Lead_Config19_CL");

			step1ConfigPage.Leads_ConfigCriteria_Delete();
			logger.log(LogStatus.INFO, "Succesfully removed criteria ");
			Thread.sleep(3000);

			for (int rownumt = 2; rownumt <= Criteriacount; rownumt++) {
				try {
					String Scriteria = Reader.getCellData("Lead_Config19_CL", "RRD_Crieteria", rownumt);
					String Soperator = Reader.getCellData("Lead_Config19_CL", "RRD_operator", rownumt);
					String Sfieldval = Reader.getCellData("Lead_Config19_CL", "RRD_fieldvalue", rownumt);
					// String logic = Reader.getCellData("Lead_Config19_CL", "CriteriaLogic",
					// rownumt);

					TeamNewCriteriapage teamcriteria = PageFactory.initElements(driver, TeamNewCriteriapage.class);
					logger.log(LogStatus.INFO, "Succesfully directed to the team details page");

					teamcriteria.ClickonLeads_NewcriteriaBtn();
					logger.log(LogStatus.INFO, "Succesfully new criteria form has opened ");

					teamcriteria.Select_LEADConfig_fromField(Scriteria);
					logger.log(LogStatus.INFO, "Succesfully selected the criteria ");

					teamcriteria.Select_LEADConfig_fromOPerator(Soperator);
					logger.log(LogStatus.INFO, "Succesfully selected the Operator ");

					teamcriteria.Enterthe_LEADConfig_fieldval(Sfieldval);
					logger.log(LogStatus.INFO, "Succesfully entered the field value ");

					teamcriteria.LeadConfig_CriteriaLogic_ClearField();
					logger.log(LogStatus.INFO, "Succesfully cleared the criteria logic ");
					/*
					 * teamcriteria.LeadConfig_CriteriaLogic(logic); logger.log(LogStatus.INFO,
					 * "Succesfully entered the criteria logic ");
					 */

				} catch (Exception e) {
					e.printStackTrace();
				}

				step1ConfigPage.clickOnSaveButton();
				logger.log(LogStatus.INFO, "click on save button to save data");
				/*
				 * Thread.sleep(2000); step1ConfigPage.okalert();
				 */
				try {
					Assert.assertTrue(step1ConfigPage.isEditButtonVisible(),
							"Lead Configuration data was  not submitted successfully");
				} catch (Exception e) {
					System.out.println("Assertion is not working");
				}
				Thread.sleep(2000);
				logger.log(LogStatus.PASS, "Lead configuration data saved successfully");
			}
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
