
package EditTeamSetupAccount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mirketa.factory.BrowserFactory;
import com.mirketa.factory.DataProviderFactory;
import com.mirketa.pages.EditTeamPage;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.RRD_user_adding;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.pages.TeamPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EditTeamAcc_config11 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;
	public String Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "DefineTeamSetup_account.xlsx";

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/EditTeamSetup.html");
		logger = report.startTest("Verify add  Define Team Setup ");
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
	public void EditTeamsetup() throws InterruptedException {

		Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);

		int RRDEditCount = reader.getRowCount("Accountconfig11");
		int RRDEditCountuser = reader.getRowCount("Accountconfig11");

		String SteamName = reader.getCellData("Accountconfig11", "TeamName", RRDEditCount);
		String Accountconfig = reader.getCellData("Accountconfig11", "AccountConfig", RRDEditCount);
		String EditMaxinlimit = reader.getCellData("Accountconfig11", "EditMaxIntakeLimit", RRDEditCount);
		String teamopencaset = reader.getCellData("Accountconfig11", "EditTeamopencase", RRDEditCount);
		String EditRecordlimit = reader.getCellData("Accountconfig111", "EditRecordAssignlimit", RRDEditCountuser);
		String Edituseropencases = reader.getCellData("Accountconfig111", "EditAllowOpencases", RRDEditCountuser);

		TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);
		EditTeamPage editteamobj = PageFactory.initElements(driver, EditTeamPage.class);

		teamobj.clickonDefineTeamtab();
		logger.log(LogStatus.INFO, "Successfully clicked on Define Team tab");
		Thread.sleep(2000);

		teamobj.ProcessonSearchTeam(SteamName);
		logger.log(LogStatus.INFO, "Successfully searched the  Team name and get the value");
		teamobj.clickonTeamname();
		logger.log(LogStatus.INFO, "Successfully clicked on TeamId and Directed to Team details page");

		editteamobj.ClickonEditTeam();
		logger.log(LogStatus.INFO, "Successfully clicked on Edit Team btn");
		editteamobj.scrolldowntoreadonlydata();
		logger.log(LogStatus.INFO, "Successfully scroll down to Max intake limit");

		editteamobj.EditMaxIntakeLimit(EditMaxinlimit);
		logger.log(LogStatus.INFO, "Clear the value and enter the  Max intake limit");

		editteamobj.clickonEditteamsave();
		logger.log(LogStatus.INFO, "Save the Edited value successfully");

		RRD_user_adding userobj = PageFactory.initElements(driver, RRD_user_adding.class);

		editteamobj.clickonRelatedtab();
		editteamobj.clickonviewall();
		editteamobj.ProcessEditUsers(EditRecordlimit, Edituseropencases);
		logger.log(LogStatus.INFO, "Save the Edited value successfully");

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
