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
import com.mirketa.pages.HomePage;
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

public class ContactDistributionAllocation {
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
	public void ContactCreation_DistributionAllocation() throws InterruptedException {
		RRD_New_Case_page CONTACTobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
		RRDSearchpage rrdsearch = PageFactory.initElements(driver, RRDSearchpage.class);
		rrdsearch.appclick();
		logger.log(LogStatus.INFO, "Succesfully Clicked on Applauncher");

		rrdsearch.ContactSearch();
		logger.log(LogStatus.INFO, "Succesfully search the Contact");

		rrdsearch.RRDdrpdwnselection_Contacts();
		logger.log(LogStatus.INFO,
				"Succesfully  Contact selection from Dropdown and Directed to Contacts page successfully");

		Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);

		int RowCount = reader.getRowCount("ContactDistribution_1");
		for (int rowNum = 2; rowNum <= RowCount; rowNum++) {
			String FirstName = reader.getCellData("ContactDistribution_1", "FirstName", rowNum);
			String LastName = reader.getCellData("ContactDistribution_1", "LastName", rowNum);
			String Result = reader.getCellData("ContactDistribution_1", "ExpectedResult", rowNum);
			String Teamname = reader.getCellData("ContactDistribution_1", "TeamName", rowNum);
			String ToBeAssigned = reader.getCellData("ContactDistribution_1", "ToBeAssigned", rowNum);

			HomePage home = PageFactory.initElements(driver, HomePage.class);

			home.VerifyContactDropDown();
			Thread.sleep(5000);

			contactPage Contactobj = PageFactory.initElements(driver, contactPage.class);
			Thread.sleep(3000);
			driver.navigate().refresh();
			Thread.sleep(6000);

			Contactobj.sendfirstname(FirstName);
			logger.log(LogStatus.INFO, "Enter Contact first name");

			Contactobj.sendLastname(LastName);
			logger.log(LogStatus.INFO, "Enter Contact name");

			Contactobj.clickonsave();
			logger.log(LogStatus.INFO, "Successfully clicked on save");

			driver.navigate().refresh();
			Thread.sleep(10000);

			driver.navigate().refresh();

			try {
				System.out.println("Assigned RRD user from sheet - " + Result);
				String Username = CONTACTobj.AssignedContactRRDHover.getText();
				System.out.println("Assigned contact owner is:" + Username);
				// softassert.assertTrue(Username.equalsIgnoreCase(Result), "Assigned RRD user
				// name is not matching");
				Assert.assertTrue(Username.equalsIgnoreCase(Result), "Assigned RRD user name is not matching");
				System.out.printf("%n");
			}

			catch (Exception e)

			{
				System.out.println("Assigned RRD user  from sheet - " + Result);
				String Username = CONTACTobj.AssignedContactRRDHover.getText();
				System.out.println("Assigned contact owner is:" + Username);
				// softassert.assertTrue(Username.equalsIgnoreCase(Result), "Assigned RRD user
				// name is not matching");
				Assert.assertTrue(Username.equalsIgnoreCase(Result), "Assigned RRD user name is not matching");
				System.out.printf("%n");
			}
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

				System.out.println("To Be Assigned record of Team from sheet - " + ToBeAssigned);
				String teamcount = teamobj.TobeAssignedcount_ForContact.getText();
				System.out.println("Team count is- " + teamcount);
				System.out.printf("%n");
				Thread.sleep(1000);
				// Assert.assertTrue(teamcount.equalsIgnoreCase(ToBeAssigned), "To Be Assigned
				// count is not matching");
				softassert.assertTrue(teamcount.equalsIgnoreCase(ToBeAssigned), "To Be Assigned count is not matching");
			} catch (Exception e) {
				System.out.println("Assertion issue");
				System.out.printf("%n");
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
