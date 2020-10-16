package Testpackage;

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
import com.mirketa.pages.Accountpage;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.RRD_New_Case_page;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.pages.TeamPage;
import com.mirketa.pages.caseDetailspage;
import com.mirketa.pages.contactPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Testpackage1 {

		
		WebDriver driver;
		ExtentReports report;
		ExtentTest logger;
		Properties pro;
		
		public String Testdata_sheet_path=System.getProperty("user.dir") +File.separator+"AppData"+File.separator+"AppData.xlsx";

		SoftAssert softassert=new SoftAssert();
		
		@BeforeMethod
		public void setUp() throws FileNotFoundException, InterruptedException {
			report = new ExtentReports("./Report/CaseCreation.html");
			logger = report.startTest("Verify Case Creation");
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
		public void CaseCreation_config1() throws InterruptedException
		{
			
			Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);
			
			int rowCount = reader.getRowCount("RRDCaseOnline");
			
			reader.addColumn("RRDCaseOnline", "CaseNo");
			Thread.sleep(5000);
			logger.log(LogStatus.INFO, "Add the new col Case no.");
			
			for (int rowNum = 2; rowNum <= rowCount; rowNum++)
			{
			     String Status=reader.getCellData("RRDCaseOnline", "Status", rowNum);
				 String Priority=reader.getCellData("RRDCaseOnline", "Priority", rowNum);
				 String CaseOrigin=reader.getCellData("RRDCaseOnline", "CaseOrigin", rowNum);
				 String  saluationtest=reader.getCellData("RRDCaseOnline", "Salutation", rowNum);
				 String firstname=reader.getCellData("RRDCaseOnline", "Firstname", rowNum);
				 String lastName=reader.getCellData("RRDCaseOnline", "LastName", rowNum);
				 String Account=reader.getCellData("RRDCaseOnline", "Account", rowNum);
				 String Ratingval=reader.getCellData("RRDCaseOnline", "Ratingtype", rowNum);
				 String RRDType=reader.getCellData("RRDCaseOnline", "RRDType", rowNum);
				 String RRDCaseReason=reader.getCellData("RRDCaseOnline", "RRDCaseReason", rowNum);
			     String WebEmailtext=reader.getCellData("RRDCaseOnline", "WebEmailtext", rowNum);
			     String Subject=reader.getCellData("RRDCaseOnline", "Subject", rowNum);
			     String Description=reader.getCellData("RRDCaseOnline", "Description", rowNum);
			     String Internalcommnet=reader.getCellData("RRDCaseOnline", "Internal comment", rowNum);
			     String Assigneduser=reader.getCellData("RRDCaseOnline", "ExpectedResult", rowNum);
			     String Teamname=reader.getCellData("RRDCaseOnline", "TeamName", rowNum);
			     String ToBecount=reader.getCellData("RRDCaseOnline", "ToBeAssigned", rowNum);
			     String Changeowner=reader.getCellData("Changeowner", "Owner" , rowNum); 
			
			RRD_New_Case_page caseobj = PageFactory.initElements(driver, RRD_New_Case_page.class);
			caseobj.clickOnDefineCase();
			logger.log(LogStatus.INFO, "Successfully clicked on Define case");
			
			caseobj.clickOnNew();
			logger.log(LogStatus.INFO, "Successfully clicked on New case");
			
			
			caseobj.pickstatus(Status);
			logger.log(LogStatus.INFO, "Successfully picked status from list ");
			
			caseobj.pickpriority();
			
			caseobj.pickpriorityfromlist(Priority);
			logger.log(LogStatus.INFO, "Successfully picked priority ");
			
			caseobj.clickcaseorigin();
			logger.log(LogStatus.INFO, "Successfully clicked on case origin ");
			
			caseobj.pickcaseorigin(CaseOrigin);
			logger.log(LogStatus.INFO, "Successfully picked case origin ");
			
			caseobj.clickcearchcontact();
			logger.log(LogStatus.INFO, "Successfully clicked on search contact ");
			
			contactPage contactobj = PageFactory.initElements(driver, contactPage.class);
			contactobj.clickOnContact();
			logger.log(LogStatus.INFO, "Successfully clicked on New contact and pop up opens");
			
			contactobj.clickonsaluation();
			logger.log(LogStatus.INFO, "Successfully clicked on Salutation");
			
			contactobj.picksaluationfromlist(saluationtest);
			logger.log(LogStatus.INFO, "Successfully picked from Salutation");
			
			contactobj.sendfirstname(firstname);
			logger.log(LogStatus.INFO, "Successfully enter firstname");
			
			contactobj.sendLastname(lastName);
			
			logger.log(LogStatus.INFO, "Successfully enter firstname");
			contactobj.clickonsave();
			
			logger.log(LogStatus.INFO, "Successfully clicked on save");
			//scrolling
		    
			caseobj.scrolldowntosearchAcc();
			 
			 caseobj.clicksearchAcc();
		     logger.log(LogStatus.INFO, "Successfully clicked the search Account value ");
			
			 Accountpage Accobj = PageFactory.initElements(driver, Accountpage.class);
			 Accobj.clickOnNewAccount();
		     logger.log(LogStatus.INFO, "Successfully clicked on New  Account ");
			 
			 Accobj.ClickonAccountName(Account);
			 logger.log(LogStatus.INFO, "Enter account name");
			
			 Accobj.clickingRating();
			 logger.log(LogStatus.INFO, "click on Rating Type");
			
			 Accobj.pickrating(Ratingval);
			 logger.log(LogStatus.INFO, "Picked  Rating Type");
			 
			 Accobj.clickonsave();
			 logger.log(LogStatus.INFO, "Successfully clicked on save");
				//scrolling
			 caseobj.scrolldowntopicktype();
			 logger.log(LogStatus.INFO, "Scroll down to pick Type from drop down");
			 
			 caseobj.pickfromType(RRDType);
			 logger.log(LogStatus.INFO, "Successfully picked from type ");
			
			 caseobj.scrolldowntopickcasereason();
			 logger.log(LogStatus.INFO, "Scroll down to pick Case Reason from drop down");
			 
			 
			 caseobj.pickfromcasereason(RRDCaseReason);
			 logger.log(LogStatus.INFO, "Successfully picked from case reason ");
			
			 caseobj.scrolldowntoviewwebinfo();
			 logger.log(LogStatus.INFO, "Scroll down to View Web Info details");
			 
			 caseobj.TypeWebemail(WebEmailtext);
			 logger.log(LogStatus.INFO, "Successfully entered the email ");
			 
			
			 caseobj.scrolldowntoviewdescinfo();
			 logger.log(LogStatus.INFO, "Scroll down to View Description Info ");
			 
			 caseobj.Typesubject(Subject);
			 logger.log(LogStatus.INFO, "Successfully entered the subject");
			
			 caseobj.TypeDescription(Description);
			 logger.log(LogStatus.INFO, "Successfully entered the description");
			 
			 caseobj.TypeInternalComments(Internalcommnet);
			 logger.log(LogStatus.INFO, "Successfully entered the Internal comments");
		
			 caseobj.clickOnSave();
			 logger.log(LogStatus.INFO, "Successfully saved  the new added case and Directed to Case Details page ");
			
			 driver.navigate().refresh();
			 Thread.sleep(10000);
			 caseobj.getcaseno();
			 logger.log(LogStatus.INFO, "Get The cas No. from case details page");
			 
			
			reader.setCellData("RRDCaseOnline", "CaseNo", rowNum, caseobj.getcaseno());
		    driver.navigate().refresh();
			 Thread.sleep(10000);
			 caseobj.clickOnDefineCase();
			logger.log(LogStatus.INFO, "Successfully clicked on Define case");
			caseDetailspage casedetailobj = PageFactory.initElements(driver, caseDetailspage.class);
			String caseid=reader.getCellData("RRDCaseOnline", "CaseNo", rowNum);
			casedetailobj.fetchCasenum(caseid);
			casedetailobj.clickoncaseNum();
			 try
			 {
				System.out.println("Assigned RRD user  from sheet - "+Assigneduser);
				String Username=caseobj.AssignedRRDHover.getText();
				System.out.println("Assigned case owner is:"+Username);
				softassert.assertTrue(Username.equalsIgnoreCase(Assigneduser),"Assigned RRD user name is not matching");
			}
			 
			
			
			catch(Exception e)
			
			{
				 System.out.println("Assigned RRD user  from sheet - "+Assigneduser);
					String Username=caseobj.AssignedRRD.getText();
					System.out.println("Assigned case owner is:"+Username);
					softassert.assertTrue(Username.equalsIgnoreCase(Assigneduser),"Assigned RRD user name is not matching");
			}
		 
			
			/*
			 * TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);
			 * 
			 * teamobj.clickonDefineTeamtab(); logger.log(LogStatus.INFO,
			 * "Successfully clicked on Define Team tab"); Thread.sleep(2000);
			 * 
			 * teamobj.ProcessonSearchTeam(Teamname); logger.log(LogStatus.INFO,
			 * "Successfully searched the  Team name and get the value");
			 * teamobj.clickonTeamname(); logger.log(LogStatus.INFO,
			 * "Successfully clicked on TeamId and Directed to Team details page");
			 * teamobj.scrolldowntoteamrecord(); logger.log(LogStatus.INFO,
			 * "Successfully scroll down to verify Team Count");
			 * 
			 * 
			 * try {
			 * 
			 * System.out.println("To Be Assigned record of Team from sheet - "+ToBecount);
			 * String teamcount=teamobj.TobeAssignedcount.getText();
			 * System.out.println("Team count is- "+teamcount); Thread.sleep(1000);
			 * softassert.assertTrue(teamcount.equalsIgnoreCase(ToBecount)
			 * ,"To Be Assigned count is not matching"); } catch(Exception e) {
			 * System.out.println("Assertion issue"); e.printStackTrace(); }
			 */
			 
			
			
			/*
			 * caseDetailspage casedetailobj = PageFactory.initElements(driver,
			 * caseDetailspage.class); casedetailobj.clickonchangeowner();
			 * casedetailobj.clickonsearchowner(Changeowner);
			 * casedetailobj.pickuserfromlist(Changeowner);
			 * casedetailobj.Checkedownernotification();
			 * casedetailobj.clickonSubmitchangeownerbtn();
			 */
			 
				
			}
		
			reader.removeColumn("RRDCaseOnline", 18);
			Thread.sleep(3000);
			
			/* try
				 {
					System.out.println("Assigned RRD user  from sheet - "+Assigneduser);
					String Username=caseobj.AssignedRRDHover.getText();
					System.out.println("Assigned case owner is:"+Username);
					softassert.assertTrue(Username.equalsIgnoreCase(Assigneduser),"Assigned RRD user name is not matching");
				}
				 
				
				
				catch(Exception e)
				
				{
					 System.out.println("Assigned RRD user  from sheet - "+Assigneduser);
						String Username=caseobj.AssignedRRD.getText();
						System.out.println("Assigned case owner is:"+Username);
						softassert.assertTrue(Username.equalsIgnoreCase(Assigneduser),"Assigned RRD user name is not matching");
				}
			 
				
				  TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);
				  
				  teamobj.clickonDefineTeamtab(); logger.log(LogStatus.INFO,
				  "Successfully clicked on Define Team tab"); Thread.sleep(2000);
				  
				  teamobj.ProcessonSearchTeam(Teamname); logger.log(LogStatus.INFO,
				  "Successfully searched the  Team name and get the value");
				   teamobj.clickonTeamname(); logger.log(LogStatus.INFO,
				  "Successfully clicked on TeamId and Directed to Team details page");
				  teamobj.scrolldowntoteamrecord();
				  logger.log(LogStatus.INFO, "Successfully scroll down to verify Team Count");
				 
				  
				  try {
					  
				  System.out.println("To Be Assigned record of Team from sheet - "+ToBecount);
				  String teamcount=teamobj.TobeAssignedcount.getText();
				  System.out.println("Team count is- "+teamcount); 
				  Thread.sleep(1000);
				  softassert.assertTrue(teamcount.equalsIgnoreCase(ToBecount)
				  ,"To Be Assigned count is not matching"); 
				  } 
				  catch(Exception e)
				  {
				  System.out.println("Assertion issue"); e.printStackTrace();
				  }
				 
			}*/
			
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


