package CaseDistribution;

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
import com.mirketa.pages.ManualDistributionPage;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.RRD_New_Case_page;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.pages.TeamPage;
import com.mirketa.pages.caseDetailspage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CaseManualDistribution5 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;

	public String Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "CaseAllocation.xlsx";

	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/CaseDistribution5.html");
		logger = report.startTest("Verify Case Distribution5");
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
	public void CaseManualDistribution5() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);

		int rowCount = reader.getRowCount("CaseAllocation_config5");

		/*
		 * ManualDistributionPage manualdistribution = PageFactory.initElements(driver,
		 * ManualDistributionPage.class);
		 * manualdistribution.clickOnManualdistribution(); logger.log(LogStatus.INFO,
		 * "Clicked on ManualDistribution");
		 * 
		 * manualdistribution.switchtoframe(); logger.log(LogStatus.INFO,
		 * "Switch to frame"); manualdistribution.countofframe();
		 * manualdistribution.clickonDistributecase(); logger.log(LogStatus.INFO,
		 * "Clicked on Distribute case button to distribute the case successfully");
		 * driver.navigate().refresh(); Thread.sleep(4000);
		 */

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String Assigneduser = reader.getCellData("CaseAllocation_config5", "ExpectedResultAfterDistribution",
					rowNum);
			String Teamname = reader.getCellData("CaseAllocation_config5", "TeamName", rowNum);
			String ToBecount = reader.getCellData("CaseAllocation_config5", "ToBeAssignedAfterdistribution", rowNum);
			String caseid = reader.getCellData("CaseAllocation_config5", "CaseNo", rowNum);

			RRD_New_Case_page caseobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
			caseobj.clickOnDefineCase();
			logger.log(LogStatus.INFO, "Successfully clicked on Define case");
			caseDetailspage casedetailobj = PageFactory.initElements(driver, caseDetailspage.class);

			casedetailobj.fetchCasenum(caseid);
			casedetailobj.clickoncaseNum();

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
			reader.removeColumn("CaseAllocation_config5", 20);
			Thread.sleep(3000);

		}

		reader.removeColumn("CaseAllocation_config5", 20);
		Thread.sleep(3000);

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
