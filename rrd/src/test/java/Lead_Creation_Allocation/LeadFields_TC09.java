package Lead_Creation_Allocation;

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
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.RRD_New_Case_page;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LeadFields_TC09 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;

	public String Lead_Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "Leads_Allocation.xlsx";

	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/LeadCreation_LeadFields_TC09.html");
		logger = report.startTest("Verify Lead Creation LeadFields_TC09");
		logger.log(LogStatus.INFO, "Open Browser and type url in address bar");
		driver = BrowserFactory.getBrowser("chrome");
		logger.log(LogStatus.INFO, "Salesforce login page is loading.");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
		driver.manage().deleteAllCookies();
		logger.log(LogStatus.INFO, "Application is Cleared with all cookies");
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
	public void LeadCreation_LeadFields_TC09() throws InterruptedException {

		RRD_New_Case_page Leadobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
		Xls_Reader reader = new Xls_Reader(Lead_Testdata_sheet_path);

		int rowCount = reader.getRowCount("LeadFields_TC09");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			try {
				String Phone = reader.getCellData("LeadFields_TC09", "Phone", rowNum);
				String LastName = reader.getCellData("LeadFields_TC09", "Last Name", rowNum);
				String Company = reader.getCellData("LeadFields_TC09", "Company", rowNum);
				String LeadStatus = reader.getCellData("LeadFields_TC09", "Lead Status", rowNum);
				String Country = reader.getCellData("LeadFields_TC09", "Country", rowNum);
				String Discription = reader.getCellData("LeadFields_TC09", "Discription", rowNum);
				String ExpectedResult = reader.getCellData("LeadFields_TC09", "ExpectedResult", rowNum);
				String City = reader.getCellData("LeadFields_TC09", "City", rowNum);
				//String ToBeAssigned = reader.getCellData("LeadFields_TC09", "ToBeAssigned", rowNum);

				Thread.sleep(5000);
				Leadobj.clickOn_Leads();
				logger.log(LogStatus.INFO, "Successfully clicked on Define Leads Tab");
				Thread.sleep(4000);

				Leadobj.clickOnNew_Leads();
				logger.log(LogStatus.INFO, "Successfully clicked on New Lead");
				Thread.sleep(3000);
				
				Leadobj.pickPhone(Phone);
				logger.log(LogStatus.INFO, "Successfully picked phone from list ");

				Leadobj.pickLastName(LastName);
				logger.log(LogStatus.INFO, "Successfully picked Last Name ");

				Leadobj.pickcompany(Company);
				logger.log(LogStatus.INFO, "Successfully picked Company");

				Leadobj.pickLeadStatus(LeadStatus);
				logger.log(LogStatus.INFO, "Successfully picked Lead Status");
				// scrolling

				Leadobj.scrolldowntoViewDiscription();
				
				Leadobj.pickCity(City);
				logger.log(LogStatus.INFO, "Successfully picked Lead city");
				
				Leadobj.pickCountry(Country);
				logger.log(LogStatus.INFO, "Successfully picked Lead country");

				Leadobj.TypeDescription(Discription);
				logger.log(LogStatus.INFO, "Successfully entered the description");

				Leadobj.clickOnSave();
				logger.log(LogStatus.INFO, "Successfully saved  the new added lead and Directed to lead Details page ");

				driver.navigate().refresh();
				Thread.sleep(10000);

				driver.navigate().refresh();
				Thread.sleep(6000);
				Leadobj.clickOnDetailsTab();
				logger.log(LogStatus.INFO, "Successfully switched to lead Details page ");
				
				try {
					System.out.println("Assigned RRD user  from sheet - " + ExpectedResult);
					String Username = Leadobj.AssignedLead_RRDHover.getText();
					System.out.println("Assigned case owner is:" + Username);
					softassert.assertTrue(Username.equalsIgnoreCase(ExpectedResult),"Assigned RRD user name is not matching");
				}
				catch (Exception e)
				{
					System.out.println("Assigned RRD user  from sheet - " + ExpectedResult);
					String Username = Leadobj.AssignedLead_RRDHover.getText();
					System.out.println("Assigned case owner is:" + Username);
					softassert.assertTrue(Username.equalsIgnoreCase(ExpectedResult),"Assigned RRD user name is not matching");
				}

				
		}finally {
			// ... cleanup that will execute whether or not an error occurred ...
		}}

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
