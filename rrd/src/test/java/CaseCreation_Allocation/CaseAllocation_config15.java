package CaseCreation_Allocation;


	
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
	import com.mirketa.pages.contactPage;
	import com.mirketa.utility.Helper;
	import com.mirketa.utility.Xls_Reader;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;


		
		/**
		 * <p>
		 * <b>QAT-RRD-Automate - Case Creation and Allocation</b>
		 * </p>
		 * <p>
		 * 1.Login into Salesforce application
		 * </p>
		 * <p>
		 * 2.Go to SetUp page
		 * </p>
		 * <p>
		 * 4.Click on App launcher
		 * </p>
		 * <p>
		 * 5.Search RRD and clicks on The searched Option RRD that directed to RRD Application Home page
		 * </p>
		 * <p>
		 * 3.Click on Cases tab that redirected to Case listing page
		 * </p>
		 * <p>4.Clicks On New  button- New Case pop up appears</p>
		 * <p>5.Picked status from status dropdown using excel parameterisation.</p>
		 * <p>6.Picked Priority from Priority dropdown using excel parameterisation.</p>
		 * <p>7.Picked Case Origin from  Case Origin dropdown using excel parameterisation.</p>
		 * <p>8.Clicked on Contact Name search Lookup.</p>
		 * <p>8.1.Clicked on New Contact button. "New Contact" Popup appears .</p>
		 * <p>8.2.Picked Salutation from Salutation drop down using excel parameterisation.</p>
		 * <p>8.3.Enter First Name using excel parameterisation.</p>
		 * <p>8.4.Enter Last Name using excel parameterisatio.</p>
		 * <p>8.5.Clicked on Save button. Back to the New Case. </p>
		 * <p>9.Clicked on Account Name search Lookup. "New Account" Popup appears</p>
		 * <p>9.1.Clicked on New Account button. "New Account" Popup appears .</p>
		 * <p>9.2.Picked Rating from Rating drop down using excel parameterisation.</p>
		 * <p>9.3.Enter Account Name using excel parameterisation.</p>
		 * <p>9.4.Clicked on Save button. Back to the New Case. </p>
		 * <p>10.Picked Type from Type drop down using excel parameterisation.</p>
		 * <p>11.Picked Case Reason from Case Reason drop down using excel parameterisation.</p>
		 * <p>12.Enter Web Email using excel parameterisation.</p>
		 * <p>13.Enter Subject using excel parameterisation .</p>
		 * <p>14.Enter Description using excel parameterisation.</p>
		 * <p>15.Enter Internal Comments using excel parameterisation.</p>
		 * <p>16.Clicks on save button and Rendering to the Case Details page </p>
		 * <p>17.Verify that Case has Assigned to the matched Round robin user in a round robin distribution manner.</p>
		 * 
		 * 
		 * 
		 * @author Anshu
		 *
		 */
	public class CaseAllocation_config15 {
			
			WebDriver driver;
			ExtentReports report;
			ExtentTest logger;
			Properties pro;
			
			public String Testdata_sheet_path=System.getProperty("user.dir") +File.separator+"AppData"+File.separator+"CaseAllocation.xlsx";

			SoftAssert softassert=new SoftAssert();
			
			@BeforeMethod
			public void setUp() throws FileNotFoundException, InterruptedException {
				report = new ExtentReports("./Report/CaseCreation15.html");
				logger = report.startTest("Verify Case Creation15");
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
			public void CaseCreation_config15() throws InterruptedException
			{
				
				Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);
				
				int rowCount = reader.getRowCount("CaseAllocation_config15");
				for (int rowNum = 2; rowNum <= rowCount; rowNum++)
				{
				     String Status=reader.getCellData("CaseAllocation_config15", "Status", rowNum);
					 String Priority=reader.getCellData("CaseAllocation_config15", "Priority", rowNum);
					 String CaseOrigin=reader.getCellData("CaseAllocation_config15", "CaseOrigin", rowNum);
					 String  saluationtest=reader.getCellData("CaseAllocation_config15", "Salutation", rowNum);
					 String firstname=reader.getCellData("CaseAllocation_config15", "Firstname", rowNum);
					 String lastName=reader.getCellData("CaseAllocation_config15", "LastName", rowNum);
					 String Account=reader.getCellData("CaseAllocation_config15", "Account", rowNum);
					 String Ratingval=reader.getCellData("CaseAllocation_config15", "Ratingtype", rowNum);
					 String RRDType=reader.getCellData("CaseAllocation_config15", "RRDType", rowNum);
					 String RRDCaseReason=reader.getCellData("CaseAllocation_config15", "RRDCaseReason", rowNum);
				     String WebEmailtext=reader.getCellData("CaseAllocation_config15", "WebEmailtext", rowNum);
				     String Subject=reader.getCellData("CaseAllocation_config15", "Subject", rowNum);
				     String Description=reader.getCellData("CaseAllocation_config15", "Description", rowNum);
				     String Internalcommnet=reader.getCellData("CaseAllocation_config15", "Internal comment", rowNum);
				     String Assigneduser=reader.getCellData("CaseAllocation_config15", "ExpectedResult", rowNum);
				     String Teamname=reader.getCellData("CaseAllocation_config15", "TeamName", rowNum);
				     String ToBecount=reader.getCellData("CaseAllocation_config15", "ToBeAssigned", rowNum);
				      
				
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
				 
				/*
				 * caseobj.TypeWebCompany(Webcompany); logger.log(LogStatus.INFO,
				 * "Successfully entered the company"); Thread.sleep(1500);
				 * caseobj.TypeWebName(Webname); logger.log(LogStatus.INFO,
				 * "Successfully entered the name"); Thread.sleep(1500);
				 * caseobj.TypeWebPhone(Webphone); logger.log(LogStatus.INFO,
				 * "Successfully entered the phone"); Thread.sleep(1500);
				 */
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
				 
				 driver.navigate().refresh();
				
					
					
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
				 
					
					  TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);
					  
					  teamobj.clickonDefineTeamtab(); logger.log(LogStatus.INFO,
					  "Successfully clicked on Define Team tab"); 
					  Thread.sleep(2000);
					  
					  teamobj.ProcessonSearchTeam(Teamname); logger.log(LogStatus.INFO,
					  "Successfully searched the  Team name and get the value");
					   teamobj.clickonTeamname(); 
					   logger.log(LogStatus.INFO,
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










