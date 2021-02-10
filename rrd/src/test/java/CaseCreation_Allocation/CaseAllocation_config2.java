package CaseCreation_Allocation;

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
import com.mirketa.pages.contactPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * <p>
 * <b> <b>QAT-RRD-Automate - Case Creation and Allocation</b></b>
 * </p>
 * <p>
 * 1.Login into Salesforce application
 * </p>
 * <p>
 * 2.Go to SetUp page
 * </p>
 * <p>
 * 4.Click on App launcher
 * </p>
 * <p>
 * 5.Search RRD and clicks on The searched Option RRD that directed to RRD
 * Application Home page
 * </p>
 * <p>
 * 3.Click on Cases tab that redirected to Case listing page
 * </p>
 * <p>
 * 4.Clicks On New button- New Case pop up appears
 * </p>
 * <p>
 * 5.Picked status from status dropdown using excel parameterisation.
 * </p>
 * <p>
 * 6.Picked Priority from Priority dropdown using excel parameterisation.
 * </p>
 * <p>
 * 7.Picked Case Origin from Case Origin dropdown using excel parameterisation.
 * </p>
 * <p>
 * 8.Clicked on Contact Name search Lookup.
 * </p>
 * <p>
 * 8.1.Clicked on New Contact button. "New Contact" Popup appears .
 * </p>
 * <p>
 * 8.2.Picked Salutation from Salutation drop down using excel parameterisation.
 * </p>
 * <p>
 * 8.3.Enter First Name using excel parameterisation.
 * </p>
 * <p>
 * 8.4.Enter Last Name using excel parameterisatio.
 * </p>
 * <p>
 * 8.5.Clicked on Save button. Back to the New Case.
 * </p>
 * <p>
 * 9.Clicked on Account Name search Lookup. "New Account" Popup appears
 * </p>
 * <p>
 * 9.1.Clicked on New Account button. "New Account" Popup appears .
 * </p>
 * <p>
 * 9.2.Picked Rating from Rating drop down using excel parameterisation.
 * </p>
 * <p>
 * 9.3.Enter Account Name using excel parameterisation.
 * </p>
 * <p>
 * 9.4.Clicked on Save button. Back to the New Case.
 * </p>
 * <p>
 * 10.Picked Type from Type drop down using excel parameterisation.
 * </p>
 * <p>
 * 11.Picked Case Reason from Case Reason drop down using excel
 * parameterisation.
 * </p>
 * <p>
 * 12.Enter Web Email using excel parameterisation.
 * </p>
 * <p>
 * 13.Enter Subject using excel parameterisation .
 * </p>
 * <p>
 * 14.Enter Description using excel parameterisation.
 * </p>
 * <p>
 * 15.Enter Internal Comments using excel parameterisation.
 * </p>
 * <p>
 * 16.Clicks on save button and Rendering to the Case Details page
 * </p>
 * <p>
 * 17.Verify that Case has Assigned to the matched Round robin user in a round
 * robin distribution manner.
 * </p>
 * 
 * 
 * 
 * @author Anshu
 *
 */
public class CaseAllocation_config2 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;

	public String Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "CaseAllocation.xlsx";

	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/CaseCreation2.html");
		logger = report.startTest("Verify Case Creation2");
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
	public void CaseCreation_config2() throws InterruptedException {

		Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);

		int rowCount = reader.getRowCount("CaseAllocation_config2_1");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			String Status = reader.getCellData("CaseAllocation_config2_1", "Status", rowNum);
			String Priority = reader.getCellData("CaseAllocation_config2_1", "Priority", rowNum);
			String CaseOrigin = reader.getCellData("CaseAllocation_config2_1", "CaseOrigin", rowNum);
			String saluationtest = reader.getCellData("CaseAllocation_config2_1", "Salutation", rowNum);
			String firstname = reader.getCellData("CaseAllocation_config2_1", "Firstname", rowNum);
			String lastName = reader.getCellData("CaseAllocation_config2_1", "LastName", rowNum);
			String Account = reader.getCellData("CaseAllocation_config2_1", "Account", rowNum);
			String Ratingval = reader.getCellData("CaseAllocation_config2_1", "Ratingtype", rowNum);
			String RRDType = reader.getCellData("CaseAllocation_config2_1", "RRDType", rowNum);
			String RRDCaseReason = reader.getCellData("CaseAllocation_config2_1", "RRDCaseReason", rowNum);
			String WebEmailtext = reader.getCellData("CaseAllocation_config2_1", "WebEmailtext", rowNum);
			String Subject = reader.getCellData("CaseAllocation_config2_1", "Subject", rowNum);
			String Description = reader.getCellData("CaseAllocation_config2_1", "Description", rowNum);
			String Internalcommnet = reader.getCellData("CaseAllocation_config2_1", "Internal comment", rowNum);
			String Assigneduser = reader.getCellData("CaseAllocation_config2_1", "ExpectedResult", rowNum);
			String Teamname = reader.getCellData("CaseAllocation_config2_1", "TeamName", rowNum);
			String ToBecount = reader.getCellData("CaseAllocation_config2_1", "ToBeAssigned", rowNum);

			RRD_New_Case_page caseobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
			caseobj.clickOnDefineCase();
			logger.log(LogStatus.INFO, "Successfully clicked on Define case");

			caseobj.clickOnNew();
			logger.log(LogStatus.INFO, "Successfully clicked on New case");

			
			caseobj.ClickonNametoCloseContactWindow();

			caseobj.pickpriority();

			caseobj.pickpriorityfromlist(Priority);
			logger.log(LogStatus.INFO, "Successfully picked priority ");

			caseobj.clickcaseorigin();
			logger.log(LogStatus.INFO, "Successfully clicked on case origin ");

			caseobj.pickcaseorigin(CaseOrigin);
			logger.log(LogStatus.INFO, "Successfully picked case origin ");

			caseobj.clickcearchcontact();
			logger.log(LogStatus.INFO, "Successfully clicked on search contact ");
			Accountpage Accobj = PageFactory.initElements(driver, Accountpage.class);
			contactPage contactobj = PageFactory.initElements(driver, contactPage.class);
			contactobj.clickOnContact();
			logger.log(LogStatus.INFO, "Successfully clicked on New contact and pop up opens");

			contactobj.clickonsaluation();
			logger.log(LogStatus.INFO, "Successfully clicked on Salutation");

			contactobj.picksaluationfromlist(saluationtest);
			logger.log(LogStatus.INFO, "Successfully picked from Salutation");

			contactobj.sendfirstname(firstname);
			logger.log(LogStatus.INFO, "Successfully enter firstname");

			contactobj.sendLastname(lastName);

			logger.log(LogStatus.INFO, "Successfully enter firstname");
			Accobj.saveaccount();

			logger.log(LogStatus.INFO, "Successfully clicked on save");
			// scrolling

			caseobj.scrolldowntosearchAcc();

			caseobj.clicksearchAcc();
			logger.log(LogStatus.INFO, "Successfully clicked the search Account value ");

			

			Accobj.clickOnNewAccount();
			logger.log(LogStatus.INFO, "Successfully clicked on New  Account ");

			Accobj.ClickonCase_AccountName(Account);
			logger.log(LogStatus.INFO, "Enter account name");

			Accobj.clickingRating();
			logger.log(LogStatus.INFO, "click on Rating Type");

			Accobj.pickrating(Ratingval);
			logger.log(LogStatus.INFO, "Picked  Rating Type");

			Accobj.saveaccount();
			logger.log(LogStatus.INFO, "Successfully clicked on save");
			// scrolling

			caseobj.scrolldowntoviewwebinfo();
			logger.log(LogStatus.INFO, "Scroll down to View Web Info details");

			caseobj.TypeWebemail(WebEmailtext);
			logger.log(LogStatus.INFO, "Successfully entered the email ");

			caseobj.scrolldowntoviewdescinfo();
			logger.log(LogStatus.INFO, "Scroll down to View Description Info ");

			caseobj.Typesubject(Subject);
			logger.log(LogStatus.INFO, "Successfully entered the subject");

			caseobj.TypeDescription(Description);
			logger.log(LogStatus.INFO, "Successfully entered the description");

			caseobj.TypeInternalComments(Internalcommnet);
			logger.log(LogStatus.INFO, "Successfully entered the Internal comments");

			caseobj.clickOnSave();
			logger.log(LogStatus.INFO, "Successfully saved  the new added case and Directed to Case Details page ");

			driver.navigate().refresh();
			Thread.sleep(10000);

			driver.navigate().refresh();
			Thread.sleep(10000);
			caseobj.clickOnDetailsTab();
			Thread.sleep(5000);

			try {
				System.out.println("Assigned RRD user  from sheet - " + Assigneduser);
				String Username = caseobj.AssignedRRDHover.getText();
				System.out.println("Assigned case owner is:" + Username);
				softassert.assertTrue(Username.equalsIgnoreCase(Assigneduser),
						"Assigned RRD user name is not matching");
			}

			catch (Exception e)

			{
				System.out.println("Assigned RRD user  from sheet - " + Assigneduser);
				String Username = caseobj.AssignedRRD.getText();
				System.out.println("Assigned case owner is:" + Username);
				softassert.assertTrue(Username.equalsIgnoreCase(Assigneduser),
						"Assigned RRD user name is not matching");
			}

			TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);

			teamobj.clickonDefineTeamtab();
			logger.log(LogStatus.INFO, "Successfully clicked on Define Team tab");
			Thread.sleep(2000);

			teamobj.ProcessonSearchTeam(Teamname);
			logger.log(LogStatus.INFO, "Successfully searched the  Team name and get the value");
			teamobj.clickonTeamname();
			logger.log(LogStatus.INFO, "Successfully clicked on TeamId and Directed to Team details page");
			teamobj.scrolldowntoteamrecord();
			logger.log(LogStatus.INFO, "Successfully scroll down to verify Team Count");

			try {

				System.out.println("To Be Assigned record of Team from sheet - " + ToBecount);
				String teamcount = teamobj.TobeAssignedcount.getText();
				System.out.println("Team count is- " + teamcount);
				Thread.sleep(1000);
				softassert.assertTrue(teamcount.equalsIgnoreCase(ToBecount), "To Be Assigned count is not matching");
			} catch (Exception e) {
				System.out.println("Assertion issue");
				e.printStackTrace();
			}

		}

		
		
		Xls_Reader Reader = new Xls_Reader(Testdata_sheet_path);

		int RowCount = Reader.getRowCount("CaseAllocation_config2_2");
		for (int rowNum = 2; rowNum <= RowCount; rowNum++) {
			String Status = Reader.getCellData("CaseAllocation_config2_2", "Status", rowNum);
			String Priority = Reader.getCellData("CaseAllocation_config2_2", "Priority", rowNum);
			String CaseOrigin = Reader.getCellData("CaseAllocation_config2_2", "CaseOrigin", rowNum);
			String saluationtest = Reader.getCellData("CaseAllocation_config2_2", "Salutation", rowNum);
			String firstname = Reader.getCellData("CaseAllocation_config2_2", "Firstname", rowNum);
			String lastName = Reader.getCellData("CaseAllocation_config2_2", "LastName", rowNum);
			String Account = Reader.getCellData("CaseAllocation_config2_2", "Account", rowNum);
			String Ratingval = Reader.getCellData("CaseAllocation_config2_2", "Ratingtype", rowNum);
			String RRDType = Reader.getCellData("CaseAllocation_config2_2", "RRDType", rowNum);
			String RRDCaseReason = Reader.getCellData("CaseAllocation_config2_2", "RRDCaseReason", rowNum);
			String WebEmailtext = Reader.getCellData("CaseAllocation_config2_2", "WebEmailtext", rowNum);
			String Subject = Reader.getCellData("CaseAllocation_config2_2", "Subject", rowNum);
			String Description = Reader.getCellData("CaseAllocation_config2_2", "Description", rowNum);
			String Internalcommnet = Reader.getCellData("CaseAllocation_config2_2", "Internal comment", rowNum);
			String Assigneduser = Reader.getCellData("CaseAllocation_config2_2", "ExpectedResult", rowNum);
			String Teamname = Reader.getCellData("CaseAllocation_config2_2", "TeamName", rowNum);
			String ToBecount = Reader.getCellData("CaseAllocation_config2_2", "ToBeAssigned", rowNum);

			RRD_New_Case_page caseobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
			caseobj.clickOnDefineCase();
			logger.log(LogStatus.INFO, "Successfully clicked on Define case");

			caseobj.clickOnNew();
			logger.log(LogStatus.INFO, "Successfully clicked on New case");
			driver.navigate().refresh();
			Thread.sleep(7000);
			
			caseobj.ClickonNametoCloseContactWindow();

			caseobj.pickpriority();

			caseobj.pickpriorityfromlist(Priority);
			logger.log(LogStatus.INFO, "Successfully picked priority ");

			caseobj.clickcaseorigin();
			logger.log(LogStatus.INFO, "Successfully clicked on case origin ");

			caseobj.pickcaseorigin(CaseOrigin);
			logger.log(LogStatus.INFO, "Successfully picked case origin ");

			caseobj.clickcearchcontact();
			logger.log(LogStatus.INFO, "Successfully clicked on search contact ");

			Accountpage Accobj = PageFactory.initElements(driver, Accountpage.class);
			contactPage contactobj = PageFactory.initElements(driver, contactPage.class);
			contactobj.clickOnContact();
			logger.log(LogStatus.INFO, "Successfully clicked on New contact and pop up opens");

			contactobj.clickonsaluation();
			logger.log(LogStatus.INFO, "Successfully clicked on Salutation");

			contactobj.picksaluationfromlist(saluationtest);
			logger.log(LogStatus.INFO, "Successfully picked from Salutation");

			contactobj.sendfirstname(firstname);
			logger.log(LogStatus.INFO, "Successfully enter firstname");

			contactobj.sendLastname(lastName);

			logger.log(LogStatus.INFO, "Successfully enter firstname");
			Accobj.saveaccount();

			logger.log(LogStatus.INFO, "Successfully clicked on save");
			// scrolling

			caseobj.scrolldowntosearchAcc();

			caseobj.clicksearchAcc();
			logger.log(LogStatus.INFO, "Successfully clicked the search Account value ");


			Accobj.clickOnNewAccount();
			logger.log(LogStatus.INFO, "Successfully clicked on New  Account ");

			Accobj.ClickonCase_AccountName(Account);
			logger.log(LogStatus.INFO, "Enter account name");

			Accobj.clickingRating();
			logger.log(LogStatus.INFO, "click on Rating Type");

			Accobj.pickrating(Ratingval);
			logger.log(LogStatus.INFO, "Picked  Rating Type");

			Accobj.saveaccount();
			logger.log(LogStatus.INFO, "Successfully clicked on save");
			// scrolling

			caseobj.scrolldowntoviewwebinfo();
			logger.log(LogStatus.INFO, "Scroll down to View Web Info details");

			caseobj.TypeWebemail(WebEmailtext);
			logger.log(LogStatus.INFO, "Successfully entered the email ");

			caseobj.scrolldowntoviewdescinfo();
			logger.log(LogStatus.INFO, "Scroll down to View Description Info ");

			caseobj.Typesubject(Subject);
			logger.log(LogStatus.INFO, "Successfully entered the subject");

			caseobj.TypeDescription(Description);
			logger.log(LogStatus.INFO, "Successfully entered the description");

			caseobj.TypeInternalComments(Internalcommnet);
			logger.log(LogStatus.INFO, "Successfully entered the Internal comments");

			caseobj.clickOnSave();
			logger.log(LogStatus.INFO, "Successfully saved  the new added case and Directed to Case Details page ");

			driver.navigate().refresh();
			Thread.sleep(10000);

			driver.navigate().refresh();
			Thread.sleep(10000);
			caseobj.clickOnDetailsTab();
			Thread.sleep(5000);

			try {
				System.out.println("Assigned RRD user  from sheet - " + Assigneduser);
				String Username = caseobj.AssignedRRDHover.getText();
				System.out.println("Assigned case owner is:" + Username);
				softassert.assertTrue(Username.equalsIgnoreCase(Assigneduser),
						"Assigned RRD user name is not matching");
			}

			catch (Exception e)

			{
				System.out.println("Assigned RRD user  from sheet - " + Assigneduser);
				String Username = caseobj.AssignedRRD.getText();
				System.out.println("Assigned case owner is:" + Username);
				softassert.assertTrue(Username.equalsIgnoreCase(Assigneduser),
						"Assigned RRD user name is not matching");
			}

			TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);

			teamobj.clickonDefineTeamtab();
			logger.log(LogStatus.INFO, "Successfully clicked on Define Team tab");
			Thread.sleep(2000);

			teamobj.ProcessonSearchTeam(Teamname);
			logger.log(LogStatus.INFO, "Successfully searched the  Team name and get the value");
			teamobj.clickonTeamname();
			logger.log(LogStatus.INFO, "Successfully clicked on TeamId and Directed to Team details page");
			teamobj.scrolldowntoteamrecord();
			logger.log(LogStatus.INFO, "Successfully scroll down to verify Team Count");

			try {

				System.out.println("To Be Assigned record of Team from sheet - " + ToBecount);
				String teamcount = teamobj.TobeAssignedcount.getText();
				System.out.println("Team count is- " + teamcount);
				Thread.sleep(1000);
				softassert.assertTrue(teamcount.equalsIgnoreCase(ToBecount), "To Be Assigned count is not matching");
			} catch (Exception e) {
				System.out.println("Assertion issue");
				e.printStackTrace();
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
