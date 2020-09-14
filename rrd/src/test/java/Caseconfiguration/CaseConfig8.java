package Caseconfiguration;


	
	/**
	 * <p>
	 * <b>QAT-RRD-Automate Case Configuration 5</b>
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
	 * 5.Search RRD and clicks on The searched option RRD that directed to RRD Application Home page
	 * </p>
	 * <p>
	 * 3.Click on step1Configuration tab
	 * </p>
	 * <p>4.Navigate to iframe.</p>
	 * <p>5.click on edit button.</p>
	 * <p>6.Select user from drop down value that is Online.</p>
	 * <p>7.Select owner notification from drop down value that is by Notify by Task .</p>
	 * <p>8.Select Relationship based assignment value from drop down that is Case origin.</p>
	 * <p>9.Uncheck Queue assignment checkbox</p>
	 * <p>10.Uncheck handle manual assignment checkbox</p>
	 * <p>11.Uncheck Handle High Priority Case Checkbox</p>
	 * <p>.Enter the case priority as High.</p>
	 * 
	 * <p>12.click on save button to save data</p>
	 * <p>13.Assert that Case config  changes has saved By checking if Edit button is visible </p>
	 * 
	 * 
	 * 
	 * @author Anshu
	 *
	 */
		
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
		import com.mirketa.pages.Step1ConfigurationPage;
		import com.mirketa.utility.Helper;
		import com.mirketa.utility.Xls_Reader;
		import com.relevantcodes.extentreports.ExtentReports;
		import com.relevantcodes.extentreports.ExtentTest;
		import com.relevantcodes.extentreports.LogStatus;

		public class CaseConfig8 {
			
			WebDriver driver;
			ExtentReports report;
			ExtentTest logger;
			Properties pro;
			public String Testdata_sheet_path=System.getProperty("user.dir") +File.separator+"AppData"+File.separator+"CaseConfigData.xlsx";
			
			@BeforeMethod
			public void setUp() throws FileNotFoundException, InterruptedException {
				report = new ExtentReports("./Report/CaseConfiguration8.html");
				logger = report.startTest("Verify Case Configuration8");
				logger.log(LogStatus.INFO, "Open Browser and type url in address bar");
				driver = BrowserFactory.getBrowser("chrome");
				logger.log(LogStatus.INFO, "Salesforce login page is loading.");
				driver.get(DataProviderFactory.getConfig().getApplicationUrl());
				logger.log(LogStatus.INFO, "Application is up and running");
				
				SalesForceLoginPage salesForceLoginPage = PageFactory.initElements(driver, SalesForceLoginPage.class);
				salesForceLoginPage.loginApplicaiton(DataProviderFactory.getExcel().getData(0, 1, 0),
						DataProviderFactory.getExcel().getData(0, 1, 1));
				logger.log(LogStatus.INFO, "Login into application");
				Thread.sleep(2000);
		       RRDSearchpage rrdsearch=PageFactory.initElements(driver,RRDSearchpage.class);
				
				rrdsearch.appclick();
				logger.log(LogStatus.INFO, "Succesfully Clicked on Applauncher");
				rrdsearch.RRdsearch();
				logger.log(LogStatus.INFO, "Succesfully search the RRD");
				
				rrdsearch.RRDdrpdwnselection();
				logger.log(LogStatus.INFO, "Succesfully  RRD selection from Dropdown and Directed to RRDHome page successfully");
			
				
				

			}

			@Test
			public void TestCaseConfig5() throws InterruptedException{

				Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);
				
				int rowCount = reader.getRowCount("Caseconfig8");
				for (int rowNum = 2; rowNum <= rowCount; rowNum++)
				{
				
				String sUser1=reader.getCellData("Caseconfig8", "Enable_RRD_Users" , rowNum);
				String sOwnerNotification=reader.getCellData("Caseconfig8", "ownerNotification", rowNum);
				String sReleationshipBasedAssignment=reader.getCellData("Caseconfig8", "Rel_Based_Asgmt", rowNum);
				String sCasePriority=reader.getCellData("Caseconfig8", "casepriority", rowNum);
				
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				
				
				homePage.clickOnStep1Configuration();
				logger.log(LogStatus.INFO, "click on step1 configuration tab");
			   
				Step1ConfigurationPage step1ConfigPage = PageFactory.initElements(driver, Step1ConfigurationPage.class);
				
				step1ConfigPage.navigatetoIframeCaseConfig();
				logger.log(LogStatus.INFO, "Navigate to iframe");
				
				step1ConfigPage.clickOnCase();
				logger.log(LogStatus.INFO, "click on case tab");
				
				step1ConfigPage.clickOnEditButton();
				logger.log(LogStatus.INFO, "click on edit button");
				
				step1ConfigPage.selectUser(sUser1);
				logger.log(LogStatus.INFO, "Select user from drop down value that is Online");
			
			
				step1ConfigPage.selecctOwnerNotication(sOwnerNotification);
				logger.log(LogStatus.INFO, "Select owner notification from drop down value that is by Notify by Task");
				
				step1ConfigPage.selectRelationship_Based_Asignment(sReleationshipBasedAssignment);
				logger.log(LogStatus.INFO, "Select Relationship based assignment value from drop down that is Case Origin");
				
				step1ConfigPage.unCheckQueueAssignmentCheckbox();
				logger.log(LogStatus.INFO, "Uncheck Queue assignment checkbox");
				
				
				step1ConfigPage.unCheckHandleManualAssignmentCheckbox();
				logger.log(LogStatus.INFO, "Uncheck handle manual assignment checkbox");
				
			
				step1ConfigPage.unCheckHandleHighPriorityCaseCheckbox();
				logger.log(LogStatus.INFO, "Uncheck Handle High Priority Case Checkbox");
				
				
				step1ConfigPage.enterCasePriority(sCasePriority);
				logger.log(LogStatus.INFO, "Entered case Priority as High");
				
				step1ConfigPage.clickOnSaveButton();
	            logger.log(LogStatus.INFO, "click on save button to save data");
				try
				{
				Assert.assertTrue(step1ConfigPage.isEditButtonVisible(), "Case Configuration data was  not submitted successfully");
				}
				catch(Exception e)
				{
					System.out.println("Assertion is not working");
				}
				Thread.sleep(2000);
				logger.log(LogStatus.PASS, "case configuration data saved successfully");
				
				
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





