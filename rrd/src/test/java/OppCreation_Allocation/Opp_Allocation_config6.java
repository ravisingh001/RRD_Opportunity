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
import com.mirketa.pages.Online_Offline_UserTest;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.RRD_New_Case_page;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.pages.TeamPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Opp_Allocation_config6 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;

	public String opp_Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "Opp_Allocation.xlsx";

	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/opportunityCreation6.html");
		logger = report.startTest("Verify opportunity Creation");
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
	public void OpportunityCreation_config6() throws InterruptedException {
		Online_Offline_UserTest OnlineofflineUsers = PageFactory.initElements(driver, Online_Offline_UserTest.class);
		RRD_New_Case_page caseobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
		caseobj.clickOnMore_ToSelect_Opportunity();
		logger.log(LogStatus.INFO, "Successfully clicked on More Tab");
		Thread.sleep(4000);
		caseobj.clickOnMore_OpportunityTab();
		logger.log(LogStatus.INFO, "Successfully clicked on Opportunity Button");
		Thread.sleep(4000);

		Xls_Reader reader = new Xls_Reader(opp_Testdata_sheet_path);

		int rowCount = reader.getRowCount("Opp_Allocation_config6_1");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			try {
				String Amount = reader.getCellData("Opp_Allocation_config6_1", "Amount", rowNum);
				String Closedate = reader.getCellData("Opp_Allocation_config6_1", "Close date", rowNum);
				String Stages = reader.getCellData("Opp_Allocation_config6_1", "Stages", rowNum);
				String OpportunityName = reader.getCellData("Opp_Allocation_config6_1", "Opportunity Name", rowNum);
				String AccountName = reader.getCellData("Opp_Allocation_config6_1", "Account Name", rowNum);
				String Ratingtype = reader.getCellData("Opp_Allocation_config6_1", "Ratingtype", rowNum);
				//String RRD_Type = reader.getCellData("Opp_Allocation_config6_1", "RRD_Type", rowNum);
				//String RRD_LeadSource = reader.getCellData("Opp_Allocation_config6_1", "RRD_LeadSource", rowNum);
				String Discription = reader.getCellData("Opp_Allocation_config6_1", "Discription", rowNum);
				String ExpectedResult = reader.getCellData("Opp_Allocation_config6_1", "ExpectedResult", rowNum);
				String TeamName = reader.getCellData("Opp_Allocation_config6_1", "TeamName", rowNum);
				String ToBeAssigned = reader.getCellData("Opp_Allocation_config6_1", "ToBeAssigned", rowNum);

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
				teamobj.scrolldowntoteamrecord_ForOpportunity();
				logger.log(LogStatus.INFO, "Successfully scroll down to verify Team Count");

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

			}
		}
		OnlineofflineUsers.ClickONMangeUserTab();
		logger.log(LogStatus.INFO, "Successfully clicked on manager tab");
		driver.navigate().refresh();
		OnlineofflineUsers.navigateToCriteria(); 
		logger.log(LogStatus.INFO, "Successfully switche to iframe");
		 
		OnlineofflineUsers.MarkSecurity_UserOffline();
		logger.log(LogStatus.INFO, "Successfully user marked offline on manager tab");
		driver.switchTo().parentFrame();
		caseobj.clickOnMore_ToSelect_Opportunity();
		logger.log(LogStatus.INFO, "Successfully clicked on More Tab");
		Thread.sleep(4000);
		caseobj.clickOnMore_OpportunityTab();
		logger.log(LogStatus.INFO, "Successfully clicked on Opportunity Button");
		Thread.sleep(4000);
		
		int rowcount = reader.getRowCount("Opp_Allocation_config6_2");
		for (int rownum = 2; rownum <= rowcount; rownum++) {

			try {
				String Amount = reader.getCellData("Opp_Allocation_config6_2", "Amount", rownum);
				String Closedate = reader.getCellData("Opp_Allocation_config6_2", "Close date", rownum);
				String Stages = reader.getCellData("Opp_Allocation_config6_2", "Stages", rownum);
				String OpportunityName = reader.getCellData("Opp_Allocation_config6_2", "Opportunity Name", rownum);
				String AccountName = reader.getCellData("Opp_Allocation_config6_2", "Account Name", rownum);
				String Ratingtype = reader.getCellData("Opp_Allocation_config6_2", "Ratingtype", rownum);
				/*
				 * String RRD_Type = reader.getCellData("Opp_Allocation_config6_2", "RRD_Type",
				 * rownum); String RRD_LeadSource =
				 * reader.getCellData("Opp_Allocation_config6_2", "RRD_LeadSource", rownum);
				 */
				String Discription = reader.getCellData("Opp_Allocation_config6_2", "Discription", rownum);
				String ExpectedResult = reader.getCellData("Opp_Allocation_config6_2", "ExpectedResult", rownum);
				//String TeamName = reader.getCellData("Opp_Allocation_config3_1", "TeamName", rownum);
				//String ToBeAssigned = reader.getCellData("Opp_Allocation_config3_1", "ToBeAssigned", rownum);

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

	}finally {

	}}
		OnlineofflineUsers.ClickONMangeUserTab();
		logger.log(LogStatus.INFO, "Successfully clicked on manager tab");
		driver.navigate().refresh();
		OnlineofflineUsers.navigateToCriteria(); 
		logger.log(LogStatus.INFO, "Successfully switche to iframe");
		 
		OnlineofflineUsers.MarkSecurity_UserOnline();
		logger.log(LogStatus.INFO, "Successfully user marked offline on manager tab");
		driver.switchTo().parentFrame();
		caseobj.clickOnMore_ToSelect_Opportunity();
		logger.log(LogStatus.INFO, "Successfully clicked on More Tab");	
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
