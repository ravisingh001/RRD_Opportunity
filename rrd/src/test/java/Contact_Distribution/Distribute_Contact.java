package Contact_Distribution;

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
import com.mirketa.pages.ManualDistributionPage;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.RRD_New_Case_page;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.pages.TeamPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Distribute_Contact {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;

	public String Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "ContactDistributionAllocation.xlsx";

	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/ContactCreationDistributionAllocation.html");
		logger = report.startTest("Verify Contact Creation DistributionAllocation");
		logger.log(LogStatus.INFO, "Open Browser and type url in address bar");
		driver = BrowserFactory.getBrowser("chrome");
		logger.log(LogStatus.INFO, "Salesforce login page is loading.");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
		driver.manage().deleteAllCookies();
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
	public void CaseManualDistribution9() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);
		// Xls_Reader Reader = new Xls_Reader(Testdata_sheet_path);
		int rowCount = reader.getRowCount("ContactDistribution_2");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String Contact = reader.getCellData("ContactDistribution_2", "ContactName", rowNum);
			String Assigneduser = reader.getCellData("ContactDistribution_2", "ExpectedResultAfterDistribution",
					rowNum);
			String Teamname = reader.getCellData("ContactDistribution_2", "TeamName", rowNum);
			String ToBecount = reader.getCellData("ContactDistribution_2", "ToBeAssignedAfterdistribution", rowNum);

			ManualDistributionPage manualdistribution = PageFactory.initElements(driver, ManualDistributionPage.class);
			manualdistribution.clickOnManualdistribution();
			logger.log(LogStatus.INFO, "Clicked on ManualDistribution");
			driver.navigate().refresh();
			Thread.sleep(6000);
			manualdistribution.switchtoframe();
			logger.log(LogStatus.INFO, "Switch to frame");
			manualdistribution.countofframe();
			Thread.sleep(4000);

			manualdistribution.clickonDistributeContact();
			logger.log(LogStatus.INFO, "Clicked on Distribute Contact button to distribute the Contact successfully");
			driver.navigate().refresh();
			Thread.sleep(6000);

			// contactPage Contactobj = PageFactory.initElements(driver, contactPage.class);

			TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);

			teamobj.clickonDefineTeamtab();
			logger.log(LogStatus.INFO, "Successfully clicked on Define Team tab");
			Thread.sleep(2000);

			teamobj.ProcessonSearchTeam(Teamname);
			logger.log(LogStatus.INFO, "Successfully searched the  Team name and get the value");
			teamobj.clickonTeamname();
			logger.log(LogStatus.INFO, "Successfully clicked on TeamId and Directed to Team details page");
			teamobj.scrolldowntoteamrecord_ForContact();
			logger.log(LogStatus.INFO, "Successfully scroll down to verify Team Count");

			try {

				System.out.println("To Be Assigned record of Team from sheet - " + ToBecount);
				String teamcount = teamobj.TobeAssignedcount_ForContact.getText();
				System.out.println("Team count is- " + teamcount);
				System.out.printf("%n");
				Thread.sleep(1000);
				// Assert.assertTrue(teamcount.equalsIgnoreCase(ToBeAssigned), "To Be Assigned
				// count is not matching");
				softassert.assertTrue(teamcount.equalsIgnoreCase(ToBecount), "To Be Assigned count is not matching");
			} catch (Exception e) {
				System.out.println("Assertion issue");
				System.out.printf("%n");
				e.printStackTrace();
			}

			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(7000);

			RRD_New_Case_page contactobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
			contactobj.clickOnMore_ToSelect_Opportunity();
			logger.log(LogStatus.INFO, "Successfully clicked on More Tab");
			Thread.sleep(4000);
			contactobj.clickOnMore_ContactTab();
			logger.log(LogStatus.INFO, "Successfully clicked on Contact Button");
			Thread.sleep(6000);

			contactobj.ProcessonSearchContact(Contact);
			logger.log(LogStatus.INFO, "Successfully searched the  Team name and get the value");
			teamobj.clickonTeamname();
			logger.log(LogStatus.INFO, "Successfully clicked on TeamId and Directed to Team details page");
			driver.navigate().refresh();
			Thread.sleep(10000);

			driver.navigate().refresh();

			try {
				System.out.println("Assigned RRD user from sheet - " + Assigneduser);
				String Username = contactobj.AssignedContactRRDHover.getText();
				System.out.println("Assigned contact owner is:" + Username);
				// softassert.assertTrue(Username.equalsIgnoreCase(Result), "Assigned RRD user
				// name is not matching");
				Assert.assertTrue(Username.equalsIgnoreCase(Assigneduser), "Assigned RRD user name is not matching");
				System.out.printf("%n");
			}

			catch (Exception e)

			{
				System.out.println("Assigned RRD user  from sheet - " + Assigneduser);
				String Username = contactobj.AssignedContactRRDHover.getText();
				System.out.println("Assigned contact owner is:" + Username);
				// softassert.assertTrue(Username.equalsIgnoreCase(Result), "Assigned RRD user
				// name is not matching");
				Assert.assertTrue(Username.equalsIgnoreCase(Assigneduser), "Assigned RRD user name is not matching");
				System.out.printf("%n");
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
