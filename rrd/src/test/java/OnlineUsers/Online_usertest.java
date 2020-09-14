package OnlineUsers;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mirketa.factory.BrowserFactory;
import com.mirketa.factory.DataProviderFactory;
import com.mirketa.pages.SalesForceLoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Online_usertest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro; 
	
	@Test
	public void onlineuser() throws InterruptedException
	{
		report=new ExtentReports("./Report/LoginPageReport.html");
		logger=report.startTest("Verify login into SalesForce");
		logger.log(LogStatus.INFO, "Open Browser and type url in address bar");
		driver = BrowserFactory.getBrowser("IE");
		logger.log(LogStatus.INFO, "Salesforce login page is loading.");
		driver.get("https://login.salesforce.com/");
		//driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and running");
		
		SalesForceLoginPage salesForceLoginPage = PageFactory.initElements(driver, SalesForceLoginPage.class);
	
		logger.log(LogStatus.PASS, "SalesForce Login page loaded successfully");
		salesForceLoginPage.loginApplicaiton(DataProviderFactory.getExcel().getData(0, 2, 0),
				DataProviderFactory.getExcel().getData(0, 2, 1));
		
		logger.log(LogStatus.INFO, "Username and password entered and click on login button");
		Thread.sleep(2000);
	
	
		Thread.sleep(2000);
		
		
     
		
	}

}
