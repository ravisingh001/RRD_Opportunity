package Opp_Configuration;

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

public class Opp_caseconfig5 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;
	public String Opp_Testdata_sheet_path = System.getProperty("user.dir") +File.separator+"AppData"+File.separator+"Opp_caseConfigData.xlsx";
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/Opp_CaseConfiguration5.html");
		logger = report.startTest("Verify Opp Case Configuration5");
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
       RRDSearchpage rrdsearch=PageFactory.initElements(driver,RRDSearchpage.class);
		
		rrdsearch.appclick();
		logger.log(LogStatus.INFO, "Succesfully Clicked on Applauncher");
		rrdsearch.RRdsearch();
		logger.log(LogStatus.INFO, "Succesfully search the RRD");
		
		rrdsearch.RRDdrpdwnselection();
		logger.log(LogStatus.INFO, "Succesfully  RRD selection from Dropdown and Directed to RRDHome page successfully");
		Thread.sleep(15000);
		
		

	}

	@Test
	public void TestCaseConfig5() throws InterruptedException{

		Xls_Reader reader = new Xls_Reader(Opp_Testdata_sheet_path);
		
		int rowCount = reader.getRowCount("Opp_caseconfig5");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++)
		{
		
		String sUser1=reader.getCellData("Opp_caseconfig5", "Opp_Enable_RRD_Users" , rowNum);
		String sOwnerNotification=reader.getCellData("Opp_caseconfig5", "Opp_ownerNotification", rowNum);
		String sReleationshipBasedAssignment=reader.getCellData("Opp_caseconfig5", "Opp_Rel_Based_Asgmt", rowNum);
		//String sCasePriority=reader.getCellData("Opp_caseconfig1", "casepriority", rowNum);
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		
		homePage.clickOnStep1Configuration();
		logger.log(LogStatus.INFO, "click on step1 configuration tab");
	   
		Step1ConfigurationPage step1ConfigPage = PageFactory.initElements(driver, Step1ConfigurationPage.class);
		
		step1ConfigPage.navigatetoIframeCaseConfig();
		logger.log(LogStatus.INFO, "Navigate to iframe");

		step1ConfigPage.clickOnEditButton();
		logger.log(LogStatus.INFO, "click on edit button");
		
		step1ConfigPage.clickOnOpportunity();
		logger.log(LogStatus.INFO, "click on case tab");
		
		step1ConfigPage.select_Opp_User(sUser1);
		logger.log(LogStatus.INFO, "Select user from drop down value that is None");
	
	
		step1ConfigPage.Opp_OwnerNotification(sOwnerNotification);
		logger.log(LogStatus.INFO, "Select owner notification from drop down value that is by None");
		
		step1ConfigPage.Select_Opp_Relationship_Based_Asignment(sReleationshipBasedAssignment);
		logger.log(LogStatus.INFO, "Select Relationship based assignment value from drop down that is None");
		
		step1ConfigPage.clickOnSaveButton();
        logger.log(LogStatus.INFO, "click on save button to save data");
		try
		{
		Assert.assertTrue(step1ConfigPage.isEditButtonVisible(), "Opportunity Configuration data was  not submitted successfully");
		}
		catch(Exception e)
		{
			System.out.println("Assertion is not working");
		}
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "Opportunity configuration data saved successfully");
		
		
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
