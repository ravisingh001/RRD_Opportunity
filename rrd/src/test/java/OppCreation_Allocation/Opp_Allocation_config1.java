package OppCreation_Allocation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
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
import com.mirketa.pages.TeamPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * <p>
 * <b>RRD-Automate Define New Team- Create New Team- Add New Criteria</b>
 * </p>
 * <p>
 * 1.Login into Sales force application
 * </p>
 * <p>
 * 2.Go to SetUp page
 * </p>
 * <p>
 * 4.Click on Application launcher
 * </p>
 * <p>
 * 5.Search RRD and clicks on The searched Option RRD that directed to RRD
 * Application Home page
 * </p>
 * <p>
 * 3.Click on opportunity tab that redirected to opportunity listing page
 * </p>
 * <p>
 * 4.Clicks On New button- New opportunity pop up appears
 * </p>
 * <p>
 * 5.Picked status from status drop-down using excel parameterization.
 * </p>
 * <p>
 * 6.Picked Priority from Priority drop-down using excel parameterization.
 * </p>
 * <p>
 * 7.Picked opportunity Origin from opportunity Origin drop-down using excel
 * parameterization.
 * </p>
 * <p>
 * 8.Clicked on Contact Name search Lookup.
 * </p>
 * <p>
 * 8.1.Clicked on New Contact button. "New Contact" Pop-up appears .
 * </p>
 * <p>
 * 8.2.Picked Salutation from Salutation drop down using excel parameterization.
 * </p>
 * <p>
 * 8.3.Enter First Name using excel parameterization.
 * </p>
 * <p>
 * 8.4.Enter Last Name using excel parameterized.
 * </p>
 * <p>
 * 8.5.Clicked on Save button. Back to the New Case.
 * </p>
 * <p>
 * 9.Clicked on Account Name search Lookup. "New Account" Pop-up appears
 * </p>
 * <p>
 * 9.1.Clicked on New Account button. "New Account" Pop-up appears .
 * </p>
 * <p>
 * 9.2.Picked Rating from Rating drop down using excel parameterization.
 * </p>
 * <p>
 * 9.3.Enter Account Name using excel parameterization.
 * </p>
 * <p>
 * 9.4.Clicked on Save button. Back to the New Case.
 * </p>
 * <p>
 * 10.Picked Type from Type drop down using excel parameterization.
 * </p>
 * <p>
 * 11.Picked opportunity Reason from opportunity Reason drop down using excel
 * Parameterization.
 * </p>
 * <p>
 * 13.Enter Subject using excel parameterization .
 * </p>
 * <p>
 * 15.Enter Internal Comments using excel parameterization.
 * </p>
 * <p>
 * 16.Clicks on save button and Rendering to the opportunity Details page
 * </p>
 * <p>
 * 17.Verify that opportunity has Assigned to the matched Round robin user in a
 * round robin distribution manner.
 * </p>
 * 
 * 
 * 
 * @author Ravi
 *
 */

public class Opp_Allocation_config1 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;

	public String opp_Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "Opp_Allocation.xlsx";

	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/opportunityCreation1.html");
		logger = report.startTest("Verify opportunity Creation1");
		logger.log(LogStatus.INFO, "Open Browser and type url in address bar");
		driver = BrowserFactory.getBrowser("chrome");
		logger.log(LogStatus.INFO, "Salesforce login page is loading.");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
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
		logger.log(LogStatus.INFO,
				"Succesfully  RRD selection from Dropdown and Directed to RRDHome page successfully");

	}

	@Test
	public void OpportunityCreation_config1() throws InterruptedException {

		RRD_New_Case_page caseobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
		caseobj.clickOnMore_ToSelect_Opportunity();
		logger.log(LogStatus.INFO, "Successfully clicked on More Tab");
		Thread.sleep(4000);
		caseobj.clickOnMore_OpportunityTab();
		logger.log(LogStatus.INFO, "Successfully clicked on Opportunity Button");
		Thread.sleep(4000);

		Xls_Reader reader = new Xls_Reader(opp_Testdata_sheet_path);

		int rowCount = reader.getRowCount("Opp_Allocation_config1");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			try {
				String Amount = reader.getCellData("Opp_Allocation_config1", "Amount", rowNum);
				String Closedate = reader.getCellData("Opp_Allocation_config1", "Close date", rowNum);
				String Stages = reader.getCellData("Opp_Allocation_config1", "Stages", rowNum);
				String OpportunityName = reader.getCellData("Opp_Allocation_config1", "Opportunity Name", rowNum);
				String AccountName = reader.getCellData("Opp_Allocation_config1", "Account Name", rowNum);
				String Ratingtype = reader.getCellData("Opp_Allocation_config1", "Ratingtype", rowNum);
				String RRD_Type = reader.getCellData("Opp_Allocation_config1", "RRD_Type", rowNum);
				String RRD_LeadSource = reader.getCellData("Opp_Allocation_config1", "RRD_LeadSource", rowNum);
				String Discription = reader.getCellData("Opp_Allocation_config1", "Discription", rowNum);
				String ExpectedResult = reader.getCellData("Opp_Allocation_config1", "ExpectedResult", rowNum);
				String TeamName = reader.getCellData("Opp_Allocation_config1", "TeamName", rowNum);
				String ToBeAssigned = reader.getCellData("Opp_Allocation_config1", "ToBeAssigned", rowNum);

				Thread.sleep(5000);
				caseobj.clickOnDefine_Opportunity();
				logger.log(LogStatus.INFO, "Successfully clicked on Define Opportunity");
				Thread.sleep(4000);

				caseobj.clickOnNew_ForOpportunity();
				logger.log(LogStatus.INFO, "Successfully clicked on New case");
				Thread.sleep(3000);
				caseobj.pickAmount(Amount);
				logger.log(LogStatus.INFO, "Successfully picked Amount from list ");

				caseobj.pickCloseDate(Closedate);
				logger.log(LogStatus.INFO, "Successfully picked Close Date ");

				caseobj.pickStage(Stages);
				logger.log(LogStatus.INFO, "Successfully picked Stage ");

				caseobj.pickOpportunityName(OpportunityName);
				logger.log(LogStatus.INFO, "Successfully picked Opportunity Name ");

				// scrolling

				caseobj.scrolldowntosearchAcc();

				caseobj.clicksearchAcc();
				logger.log(LogStatus.INFO, "Successfully clicked the search Account value ");

				Accountpage Accobj = PageFactory.initElements(driver, Accountpage.class);
				Accobj.clickOnNewAccount();
				logger.log(LogStatus.INFO, "Successfully clicked on New  Account ");

				Accobj.ClickonOpportunity_AccountName(AccountName);
				logger.log(LogStatus.INFO, "Enter account name");

				Accobj.clickingRating();
				logger.log(LogStatus.INFO, "click on Rating Type");

				Accobj.pickrating(Ratingtype);
				logger.log(LogStatus.INFO, "Picked  Rating Type");

				Accobj.clickonAccounts_save();
				logger.log(LogStatus.INFO, "Successfully clicked on save");

				caseobj.scrolldowntopicktype();
				logger.log(LogStatus.INFO, "Scroll down to pick Type from drop down");

				caseobj.pickfromOpp_Type(RRD_Type);
				logger.log(LogStatus.INFO, "Successfully picked from type ");

				caseobj.pickfromOpp_LeadSource(RRD_LeadSource);
				logger.log(LogStatus.INFO, "Successfully picked from Lead Source ");

				caseobj.TypeDescription(Discription);
				logger.log(LogStatus.INFO, "Successfully entered the description");

				caseobj.clickOnSave();
				logger.log(LogStatus.INFO, "Successfully saved  the new added case and Directed to Case Details page ");

				driver.navigate().refresh();
				Thread.sleep(10000);

				driver.navigate().refresh();

				try {
					System.out.println("Assigned RRD user  from sheet - " + ExpectedResult);
					String Username = caseobj.AssignedOpportunityRRDHover.getText();
					System.out.println("Assigned case owner is:" + Username);
					softassert.assertTrue(Username.equalsIgnoreCase(ExpectedResult),
							"Assigned RRD user name is not matching");
				}

				catch (Exception e)

				{
					System.out.println("Assigned RRD user  from sheet - " + ExpectedResult);
					String Username = caseobj.AssignedOpportunityRRDHover.getText();
					System.out.println("Assigned case owner is:" + Username);
					softassert.assertTrue(Username.equalsIgnoreCase(ExpectedResult),
							"Assigned RRD user name is not matching");
				}

				TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);

				teamobj.clickonDefineTeamtab();
				logger.log(LogStatus.INFO, "Successfully clicked on Define Team tab");
				Thread.sleep(2000);

				teamobj.ProcessonSearchTeam(TeamName);
				logger.log(LogStatus.INFO, "Successfully searched the  Team name and get the value");
				teamobj.clickonTeamname();
				logger.log(LogStatus.INFO, "Successfully clicked on TeamId and Directed to Team details page");
				try {

					System.out.println("To Be Assigned record of Team from sheet - " + ToBeAssigned);
					String teamcount = teamobj.TobeAssignedcount_ForOpportunity.getText();
					System.out.println("Team count is- " + teamcount);
					Thread.sleep(1000);
					softassert.assertTrue(teamcount.equalsIgnoreCase(ToBeAssigned),
							"To Be Assigned count is not matching");
				} catch (Exception e) {
					System.out.println("Assertion issue");
					e.printStackTrace();
				}
			} finally {
				// ... cleanup that will execute whether or not an error occurred ...
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