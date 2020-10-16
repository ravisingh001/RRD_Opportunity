package OnlineUsers;

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
import com.mirketa.pages.ManageUserspage;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Makeuseroffline3 {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;
	
	public String Testdata_sheet_path=System.getProperty("user.dir") +File.separator+"AppData"+File.separator+"AccountAllocation.xlsx";

	SoftAssert softassert=new SoftAssert();
	
	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/Makeuseroffline3.html");
		logger = report.startTest("Verify User offline scenario");
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
		RRDSearchpage rrdsearch=PageFactory.initElements(driver,RRDSearchpage.class);
		
		rrdsearch.appclick();
		logger.log(LogStatus.INFO, "Succesfully Clicked on Applauncher");
		
		rrdsearch.RRdsearch();
		logger.log(LogStatus.INFO, "Succesfully search the RRD");
		
		rrdsearch.RRDdrpdwnselection();
		logger.log(LogStatus.INFO, "Succesfully  RRD selection from Dropdown and Directed to RRDHome page successfully");
		
		
		
		
	}
	

	
	@Test
	public void Makeuseroffline3() throws InterruptedException
	{
		
		Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);
		
		int rowCount = reader.getRowCount("AccountAllocation3");
		int rowNum=2;
		 String useroff=reader.getCellData("AccountAllocation3", "MakeUserOffline", rowNum);
		 
		 ManageUserspage user=PageFactory.initElements(driver, ManageUserspage.class);
		 
		 user.ClickONMangeUserTab();
		 logger.log(LogStatus.INFO, "Successfully clicked on Manageusertab");
		 user.navigateToCriteria();
		 user.Mark_UserOffline(useroff);
		 driver.navigate().refresh();
		 
		 
			 
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
