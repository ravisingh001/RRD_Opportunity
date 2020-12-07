
package AccountDistribution;

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
import com.mirketa.pages.AccountDetailspage;
import com.mirketa.pages.AccountListingpage;
import com.mirketa.pages.Accountpage;
import com.mirketa.pages.HomePage;
import com.mirketa.pages.ManualDistributionPage;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.pages.TeamPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ManualDistributionAccountt10 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;

	public String Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "AccountAllocation.xlsx";

	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/AccountDistribution10.html");
		logger = report.startTest("Verify Account Distribution10");
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
	public void AccountManualDistribution10() throws InterruptedException {
		Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);

		int rowCount = reader.getRowCount("AccountAllocation10");

		ManualDistributionPage manualdistribution = PageFactory.initElements(driver, ManualDistributionPage.class);
		manualdistribution.clickOnManualdistribution();
		logger.log(LogStatus.INFO, "Clicked on ManualDistribution");

		manualdistribution.switchtoframe();
		logger.log(LogStatus.INFO, "Switch to frame");
		manualdistribution.countofframe();
		manualdistribution.clickonDistributeAccount();
		logger.log(LogStatus.INFO, "Clicked on Distribute Account button to distribute the Account successfully");

		driver.navigate().refresh();
		Thread.sleep(4000);

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String Result = reader.getCellData("AccountAllocation10", "ExpectedResultAfterDistribution", rowNum);
			String Teamname = reader.getCellData("AccountAllocation10", "TeamName", rowNum);
			String ToBecount = reader.getCellData("AccountAllocation10", "ToBeAssignedAfterdistribution", rowNum);
			String AccountName = reader.getCellData("AccountAllocation10", "AccountName", rowNum);

			HomePage home = PageFactory.initElements(driver, HomePage.class);
			home.clickOnAccounttab();

			Accountpage Accobj = PageFactory.initElements(driver, Accountpage.class);

			logger.log(LogStatus.INFO, "Successfully clicked on Account tab");

			AccountListingpage Acclistobj = PageFactory.initElements(driver, AccountListingpage.class);

			Acclistobj.fetchAccountName(AccountName);
			Acclistobj.clickonAccountName();

			AccountDetailspage details = PageFactory.initElements(driver, AccountDetailspage.class);
			// details.getAccountname();

			logger.log(LogStatus.INFO, "Get The Account name from Account details page");

			try {
				System.out.println("Assigned RRD user  from sheet - " + Result);
				driver.navigate().refresh();
				String Username = details.AssignedOwner.getText();
				System.out.println("Assigned Account owner is:" + Username);
				Thread.sleep(1000);

				// softassert.assertTrue(Username.equalsIgnoreCase(Result),"Assigned RRD user
				// name is not matching");
				Assert.assertTrue(Username.equalsIgnoreCase(Result), "Assigned RRD user name is not matching");
				System.out.printf("%n");
			} catch (Exception e) {

			}

			TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);

			teamobj.clickonDefineTeamtab();
			logger.log(LogStatus.INFO, "Successfully clicked on Define Team tab");
			Thread.sleep(2000);

			teamobj.ProcessonSearchTeam(Teamname);
			logger.log(LogStatus.INFO, "Successfully searched the  Team name and get the value");
			teamobj.clickonTeamname();
			logger.log(LogStatus.INFO, "Successfully clicked on TeamId and Directed to Team details page");
			teamobj.scrolldowntoAccountteamrecord();
			logger.log(LogStatus.INFO, "Successfully scroll down to verify Team Count");

			try {

				System.out.println("To Be Assigned record of Team from sheet - " + ToBecount);
				String teamcount = teamobj.AccountTobeAssigned.getText();
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
