package ContactConfiguration;

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
import com.mirketa.factory.BrowserFactory;
import com.mirketa.factory.DataProviderFactory;
import com.mirketa.pages.HomePage;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.pages.Step1ContactConfigurationpage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ContactConfig1 {
	/**
	 * <p>
	 * <b>QAT-RRD-Automate Contact Configuration 1</b>
	 * </p>
	 * <p>
	 * 1.Login into RRD application
	 * </p>
	 * <p>
	 * 2.Go to SetUp page
	 * </p>
	 * <p>
	 * 4.Click on App launcher
	 * </p>
	 * <p>
	 * 5.Search RRD and clicks on The searched option RRD that directed to RRD
	 * Application Home page
	 * </p>
	 * <p>
	 * 3.Click on step1Configuration tab
	 * </p>
	 * <p>
	 * 4.Navigate to and .click on edit button.
	 * </p>
	 * <p>
	 * 5.Clicks on Contact tab.
	 * </p>
	 * 
	 * <p>
	 * 6.Select user from drop down value that is None.
	 * </p>
	 * <p>
	 * 7.Select owner notification from drop down value that is by None.
	 * </p>
	 * <p>
	 * 8.Select Default owner value from drop down that is None.
	 * </p>
	 * 
	 * <p>
	 * 9.click on save button to save data
	 * </p>
	 * <p>
	 * 10.Assert that Contact config changes has saved By checking if Edit button is
	 * visible or not
	 * </p>
	 * 
	 * 
	 * 
	 * @author Ravi
	 *
	 */

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;
	public String Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "ContactConfigData.xlsx";

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/ContactConfiguration1.html");
		logger = report.startTest("Verify Contact Configuration1");
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
		Thread.sleep(15000);

	}

	@Test
	public void TestContactConfig1() throws InterruptedException {

		Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);

		int rowCount = reader.getRowCount("Contactconfig1");
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String sUser1 = reader.getCellData("Contactconfig1", "Enable_RRD_Users", rowNum);
			String sOwnerNotification = reader.getCellData("Contactconfig1", "ownerNotification", rowNum);
			String sDefaultowner = reader.getCellData("Contactconfig1", "DefaultOwner", rowNum);

			HomePage homePage = PageFactory.initElements(driver, HomePage.class);

			homePage.clickOnStep1Configuration();
			logger.log(LogStatus.INFO, "click on step1 configuration tab");

			Step1ContactConfigurationpage step1ContactConfigPage = PageFactory.initElements(driver,
					Step1ContactConfigurationpage.class);

			step1ContactConfigPage.navigatetoIframeContactConfig();
			logger.log(LogStatus.INFO, "Navigate to iframe");

			step1ContactConfigPage.clickOnEditButton();
			logger.log(LogStatus.INFO, "click on edit button");

			step1ContactConfigPage.clickOnContact();
			logger.log(LogStatus.INFO, "click on Contact tab");

			step1ContactConfigPage.selectEnableRRD(sUser1);
			logger.log(LogStatus.INFO, "Select user from drop down value that is None");

			step1ContactConfigPage.selecctOwnerNotication(sOwnerNotification);
			logger.log(LogStatus.INFO, "Select owner notification from drop down value that is by None");

			step1ContactConfigPage.selectDefaultOwner(sDefaultowner);
			logger.log(LogStatus.INFO, "Select Default owner value from drop down that is None");

			step1ContactConfigPage.clickOnSaveButton();
			logger.log(LogStatus.INFO, "click on save button to save data");
			try {
				Assert.assertTrue(step1ContactConfigPage.isEditButtonVisible(),"Contact Configuration data was  not submitted successfully");
			} catch (Exception e) {
				System.out.println("Assertion is not working");
			}
			Thread.sleep(5000);
			logger.log(LogStatus.PASS, "Contact configuration data saved successfully");

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