package OppCreation_Allocation;

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

public class Opp_Allocation_config83 {


	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;

	public String opp_Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "Opp_Allocation.xlsx";

	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/opportunityCreation83.html");
		logger = report.startTest("Verify opportunity Creation");
		logger.log(LogStatus.INFO, "Open Browser and type url in address bar");
		driver = BrowserFactory.getBrowser("chrome");
		logger.log(LogStatus.INFO, "Salesforce login page is loading.");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
		driver.manage().deleteAllCookies();
		Thread.sleep(6000);
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
	public void OpportunityCreation_config83() throws InterruptedException {

		RRD_New_Case_page caseobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
		Thread.sleep(3000);
		caseobj.clickOnMore_ToSelect_Opportunity();
		logger.log(LogStatus.INFO, "Successfully clicked on More Tab");
		Thread.sleep(4000);
		caseobj.clickOnMore_OpportunityTab();
		logger.log(LogStatus.INFO, "Successfully clicked on Opportunity Button");
		Thread.sleep(4000);

		Xls_Reader reader = new Xls_Reader(opp_Testdata_sheet_path);

		int rowCount = reader.getRowCount("Opp_Allocation_config83");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			try {
				String Amount = reader.getCellData("Opp_Allocation_config83", "Amount", rowNum);
				String Closedate = reader.getCellData("Opp_Allocation_config83", "Close date", rowNum);
				String Stages = reader.getCellData("Opp_Allocation_config83", "Stages", rowNum);
				String OpportunityName = reader.getCellData("Opp_Allocation_config83", "Opportunity Name", rowNum);
				String AccountName = reader.getCellData("Opp_Allocation_config83", "Account Name", rowNum);
				String Ratingtype = reader.getCellData("Opp_Allocation_config83", "Ratingtype", rowNum);
				//String RRD_Type = reader.getCellData("Opp_Allocation_config83", "RRD_Type", rowNum);
				String RRD_LeadSource = reader.getCellData("Opp_Allocation_config83", "RRD_LeadSource", rowNum);
				String Discription = reader.getCellData("Opp_Allocation_config83", "Discription", rowNum);
				String ExpectedResult = reader.getCellData("Opp_Allocation_config83", "ExpectedResult", rowNum);
				String TeamName = reader.getCellData("Opp_Allocation_config83", "TeamName", rowNum);
				String ToBeAssigned = reader.getCellData("Opp_Allocation_config83", "ToBeAssigned", rowNum);

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

				Accobj.ClickonAccountName(AccountName);
				logger.log(LogStatus.INFO, "Enter account name");

				Accobj.clickingRating();
				logger.log(LogStatus.INFO, "click on Rating Type");

				Accobj.pickrating(Ratingtype);
				logger.log(LogStatus.INFO, "Picked  Rating Type");

				Accobj.clickonsave();
				logger.log(LogStatus.INFO, "Successfully clicked on save");

				caseobj.scrolldowntopicktype();
				logger.log(LogStatus.INFO, "Scroll down to pick Type from drop down");

				//caseobj.pickfromOpp_Type(RRD_Type);
				//logger.log(LogStatus.INFO,"Successfully picked from type ");
				  
				caseobj.pickfromOpp_LeadSource(RRD_LeadSource); 
				logger.log(LogStatus.INFO,"Successfully picked from Lead Source ");
				 

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
		TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);
		String OppName = reader.getCellData("Opp_Allocation_config83", "Opportunity Name", rowCount);
		String ChangedOwner = reader.getCellData("ChangeOwner_SECURITY", "Changed Owner", rowCount);

		caseobj.clickOnDefine_Opportunity();
		logger.log(LogStatus.INFO, "Successfully clicked on Opportunity tab");
		Thread.sleep(5000);

		teamobj.ProcessonSearch_CreatedOpportunity(OppName);
		logger.log(LogStatus.INFO, "Successfully searched the  Opportunity name and get the value");
		teamobj.clickonTeamname();
		logger.log(LogStatus.INFO, "Successfully clicked on OpportunityId and Directed to Opportunity details page");

		teamobj.clickonChangeOwner_SecurityUser();
		logger.log(LogStatus.INFO, "Successfully Changed the owner");

		try {

			System.out.println("To Be Assigned record of Team from sheet - " + ChangedOwner);
			String Ownername = teamobj.Ownername.getText();
			System.out.println("Changed Owner Name is- " + Ownername);
			Thread.sleep(1000);
			softassert.assertTrue(Ownername.equalsIgnoreCase(ChangedOwner), "To Be changed owner is not matching");
		} catch (Exception e) {
			System.out.println("Assertion issue");
			e.printStackTrace();
		}
		Thread.sleep(5000);
		caseobj.clickOnDefine_Opportunity();
		logger.log(LogStatus.INFO, "Successfully clicked on Opportunity tab");
		Thread.sleep(5000);

		teamobj.ProcessonSearch_CreatedOpportunity(OppName);
		logger.log(LogStatus.INFO, "Successfully searched the  Opportunity name and get the value");
		teamobj.clickonTeamname();
		logger.log(LogStatus.INFO, "Successfully clicked on OpportunityId and Directed to Opportunity details page");
		Thread.sleep(5000);
		teamobj.clickonCloneOpportunity();
		logger.log(LogStatus.INFO, "Successfully clicked on clone button");
		Thread.sleep(5000);
		caseobj.clickOnSave();
		logger.log(LogStatus.INFO, "Successfully saved  the new added case and Directed to Case Details page ");

		driver.navigate().refresh();
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		
			
		if (teamobj.Ownername.getText().equals("Integration User") ) {
			System.out.println("To Be Assigned record is -" + teamobj.Ownername.getText());
			softassert.assertTrue(teamobj.Ownername.getText().equalsIgnoreCase(ChangedOwner), "To Be changed owner is not matching");
		} 
		else if(teamobj.Ownername.getText().equals("Testing_Nandini"))  {
			System.out.println("To Be Assigned record is -" + teamobj.Ownername.getText());
			softassert.assertTrue(teamobj.Ownername.getText().equalsIgnoreCase(ChangedOwner), "To Be changed owner is not matching");
		}
		  else if (teamobj.Ownername.getText().equals("Security User")) {
		  System.out.println("To Be Assigned record is -" + teamobj.Ownername.getText());
		  softassert.assertTrue(teamobj.Ownername.getText().equalsIgnoreCase(ChangedOwner), "To Be changed owner is not matching"); }
		 
		/*
		 * else if (teamobj.Ownername.getText().equals("RRD Mirketa")){
		 * System.out.println("To Be Assigned record is -" +
		 * teamobj.Ownername.getText());
		 * softassert.assertTrue(teamobj.Ownername.getText().equalsIgnoreCase(
		 * ChangedOwner), "To Be changed owner is not matching"); }
		 */
		 else {
			System.out.println("Assigned record not matches with Any User");
			Assert.fail("Does not match the criteria");
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
