package Contact_Distribution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mirketa.factory.BrowserFactory;
import com.mirketa.factory.DataProviderFactory;
import com.mirketa.pages.RRDSearchpage;
import com.mirketa.pages.RRD_user_adding;
import com.mirketa.pages.SalesForceLoginPage;
import com.mirketa.pages.TeamNewCriteriapage;
import com.mirketa.pages.TeamPage;
import com.mirketa.utility.Helper;
import com.mirketa.utility.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * <p>
 * <b>RRD-Automate Define New Team- Create New Team- Add New Criteria</b>
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
 * 5.Search RRD and clicks on The searched Option RRD that directed to RRD
 * 
 * Application Home page
 * </p>
 * <p>
 * 3.Click on step2 Define Team drop down
 * </p>
 * <p>
 * 4.Clicks On New Team drop down option
 * </p>
 * <p>
 * 5. Select Record type - Contact criteria and clicks on Next button.
 * </p>
 * <p>
 * 6.New Team: Contact Criteria pop up appears .
 * </p>
 * <p>
 * 7.Fill Unique value in Priority order.
 * </p>
 * <p>
 * 8.Fill Unique value in Team name.
 * </p>
 * <p>
 * 9.Fill Max Intake Limit.
 * </p>
 * <p>
 * 10.Fill Allowed No. of Open cases.
 * </p>
 * <p>
 * 11.Clicks on save button that redirected to Team Detail page.
 * </p>
 * <p>
 * 12.Verified that the Team has created with the same name.
 * </p>
 * <p>
 * .13.Scroll down the page
 * </p>
 * <p>
 * .14.Clicks on New Criteria and Redirected to the Criteria page
 * </p>
 * <p>
 * 15.Selected the Criteria Field from the drop down.
 * </p>
 * <p>
 * 16.Selected the operator.
 * </p>
 * <p>
 * 17.Fill the Field Value.
 * </p>
 * <p>
 * 18. Clicks on save button and directed back to Team Details page
 * </p>
 * <p>
 * 19.Navigate to Iframe.
 * <p>
 * <p>
 * 20.Goes to Related tab
 * </p>
 * <p>
 * 20.Clicks on New button and RRD New user pop up appears .
 * </p>
 * <p>
 * 21.Clicked on search people and picked value from lookup.
 * </p>
 * <p>
 * 22.Fill the Last assigned case date
 * </p>
 * <p>
 * 22.Pick the Last assigned case time
 * </p>
 * <p>
 * 22.Fill the Last assigned Lead date
 * </p>
 * <p>
 * 22.Pick the Last assigned Lead Time
 * </p>
 * <p>
 * 22.Fill the Last assigned Contact date
 * </p>
 * <p>
 * 22.Fill the Last assigned Contact Time
 * </p>
 * <p>
 * 22.Fill the Record limit
 * </p>
 * <p>
 * 22.Fill the Allowed no. of open Contact
 * </p>
 * <p>
 * .Clicks on save that rendering to the Team details page.
 * </p>
 * 
 * 
 * 
 * 
 * @author Ravi
 *
 */

public class Contact_DefineTeams {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;
	public String Contact_Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "ContactDistribution_DefineTeam.xlsx";

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/ContactDistribution_DefineTeam.html");
		logger = report.startTest("Verify Contact add  Contact Distribution DefineTeam ");
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
		logger.log(LogStatus.INFO,"Succesfully  RRD selection from Dropdown and Directed to RRDHome page successfully");

	}

	@Test
	public void DefineTeamSetup() throws InterruptedException {

		Xls_Reader reader = new Xls_Reader(Contact_Testdata_sheet_path);

		int KeywordrowCount = reader.getRowCount("Contact_Keywords");

		int RRDTeamrowCount = reader.getRowCount("Contact_RRDTeam");

		int Criteriacount = reader.getRowCount("Contact_TeamNewCriteria");

		int RRDusercount = reader.getRowCount("Contact_RRDUser");

		for (int rowNum = 2; rowNum <= KeywordrowCount; rowNum++) {

			for (int rownum = 2; rownum <= RRDTeamrowCount; rownum++) {

				try {

					if ((reader.getCellData("Contact_Keywords", "Team", rowNum))
							.equalsIgnoreCase(reader.getCellData("Contact_RRDTeam", "TeamName", rownum)))

					{

						String SpriorityOrder = reader.getCellData("Contact_RRDTeam", "PriorityOrder", rownum);
						String SteamName = reader.getCellData("Contact_RRDTeam", "TeamName", rownum);
						String SmaxIntakeLimit = reader.getCellData("Contact_RRDTeam", "Max_Intake_limit", rownum);

						TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);
						teamobj.clickOnDefineTeam();
						logger.log(LogStatus.INFO, "Succesfully clicked on  RRD Define team");

						teamobj.clickonNewTeam();
						logger.log(LogStatus.INFO, "Succesfully clicked on  RRD New team button");
						/*
						 * Thread.sleep(3000); driver.navigate().refresh();
						 */
						Thread.sleep(5000);
						teamobj.clickonContactCriteria_RadioButton();
						logger.log(LogStatus.INFO, "Succesfully clicked on  RRD New team button");
						Thread.sleep(5000);
						teamobj.clickOnNext();
						logger.log(LogStatus.INFO, "Succesfully clicked on  RRD Next button");
						Thread.sleep(5000);
						teamobj.type_priority_order(SpriorityOrder);
						logger.log(LogStatus.INFO, "Succesfully Enter priority order value");

						teamobj.type_Team_name(SteamName);
						logger.log(LogStatus.INFO, "Succesfully Enter Team name value");

						teamobj.type_Maximum_Intake_limit(SmaxIntakeLimit);
						logger.log(LogStatus.INFO, "Succesfully Enter Max Intake value");

						teamobj.click_save_button();
						logger.log(LogStatus.INFO, "Succesfully save the team for Opportunity criteria");

						driver.navigate().refresh();
						Thread.sleep(4000);
						try {
							System.out.println("Team Name is from sheet - " + SteamName);
							String tempteam = teamobj.teamInfo.getText();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							System.out.println("Team Name is from element - " + tempteam);
							Assert.assertTrue(tempteam.equalsIgnoreCase(SteamName), "Team name is not matching");
							System.out.printf("%n");
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						} catch (Exception e) {
							System.out.println("Assertion issue");
							System.out.printf("%n");
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			for (int rownumt = 2; rownumt <= Criteriacount; rownumt++) {
				try {

					if ((reader.getCellData("Contact_Keywords", "Team", rowNum))
							.equalsIgnoreCase(reader.getCellData("Contact_TeamNewCriteria", "TeamName", rownumt)))

					{

						String Scriteria = reader.getCellData("Contact_TeamNewCriteria", "RRD_Crieteria", rownumt);
						String Soperator = reader.getCellData("Contact_TeamNewCriteria", "RRD_operator", rownumt);
						String Sfieldval = reader.getCellData("Contact_TeamNewCriteria", "RRD_fieldvalue", rownumt);
						String logic = reader.getCellData("Contact_TeamNewCriteria", "CriteriaLogic", rownumt);

						TeamNewCriteriapage teamcriteria = PageFactory.initElements(driver, TeamNewCriteriapage.class);
						logger.log(LogStatus.INFO, "Succesfully directed to the team details page");

						teamcriteria.scrolldowntoNewcriteria();

						teamcriteria.navigateToCriteria();

						logger.log(LogStatus.INFO, "Succesfully scroll down to the New critera section");

						teamcriteria.ClickonNewcriteria();
						logger.log(LogStatus.INFO, "Succesfully new criteria form has opened ");

						// teamcriteria.navigatebacktoParent();

						teamcriteria.SelectfromField(Scriteria);
						logger.log(LogStatus.INFO, "Succesfully selected the criteria ");

						teamcriteria.SelectfromOPerator(Soperator);
						logger.log(LogStatus.INFO, "Succesfully selected the Operator ");

						teamcriteria.Enterthefieldval(Sfieldval);
						logger.log(LogStatus.INFO, "Succesfully selected the Operator ");

						/*
						 * teamcriteria.ClickonAdd_NewCustomer(); logger.log(LogStatus.INFO,
						 * "Succesfully Added the team criteria ");
						 */

						teamcriteria.Clickonsave();
						logger.log(LogStatus.INFO, "Succesfully saved the team criteria ");

						teamcriteria.navigatebacktoParent();

						driver.navigate().refresh();

						teamcriteria.scrolldowntoNewcriteria();

						teamcriteria.navigateToCriteria();

						try {
							if (logic != null)

							{
								teamcriteria.Editcriteria();

								teamcriteria.AddCriteriaLogic(logic);

								teamcriteria.submitcriteria();

								teamcriteria.okalert();

							}
						} catch (Exception e) {
							e.printStackTrace();
						}

						// teamcriteria.addLogicAndSubmitCriteria(logic);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			for (int rowval = 2; rowval <= RRDusercount; rowval++) {
				try {

					if ((reader.getCellData("Contact_Keywords", "Team", rowNum))
							.equalsIgnoreCase(reader.getCellData("Contact_RRDUser", "TeamName", rowval))) {

						String RRdUser = reader.getCellData("Contact_RRDUser", "SearchPeople", rowval);
						String caseDate = reader.getCellData("Contact_RRDUser", "LastCaseAssignedDate", rowval);
						String Leaddate = reader.getCellData("Contact_RRDUser", "LastLeadAssignedDate", rowval);
						String Oppdate = reader.getCellData("Contact_RRDUser", "LastOppAssignedDate", rowval);
						String Recordlimit = reader.getCellData("Contact_RRDUser", "RecordAssignLimit", rowval);
						String AllowedNo = reader.getCellData("Contact_RRDUser", "Allowedopencases", rowval);

						RRD_user_adding userobj = PageFactory.initElements(driver, RRD_user_adding.class);

						userobj.clickonRelatedtab();
						logger.log(LogStatus.INFO, "Succesfully goes to  Related tab");

						logger.log(LogStatus.INFO, "Succesfully clicked on New uer");
						userobj.clickonnew();

						logger.log(LogStatus.INFO, "Succesfully clicked on new button");
						userobj.clicksOnsearchPeople(RRdUser);
						logger.log(LogStatus.INFO, "Succesfully clicked on search people");

						Thread.sleep(3000);
						userobj.PickRRDuser(RRdUser);
						logger.log(LogStatus.INFO, "Succesfully picked from lookup");

						userobj.getCaseDate(caseDate);
						logger.log(LogStatus.INFO, "Succesfully picked  case date");

						userobj.clickoncaseTime();
						logger.log(LogStatus.INFO, "Succesfully clicked on case time");

						/*
						 * userobj.pickCaseTime(); logger.log(LogStatus.INFO,
						 * "Succesfully picked  case Time");
						 */

						userobj.getLeadDate(Leaddate);
						logger.log(LogStatus.INFO, "Succesfully picked  Lead date");

						userobj.clickonLeadTime();
						logger.log(LogStatus.INFO, "Succesfully clicked on lead time");

						/*
						 * userobj.pickLeadTime(); logger.log(LogStatus.INFO,
						 * "Succesfully picked  Lead time");
						 */

						userobj.scrolldowntosearchRecordlimit();

						userobj.getOppDate(Oppdate);
						logger.log(LogStatus.INFO, "Succesfully picked  Opp date");

						userobj.clickonOPpTime();
						logger.log(LogStatus.INFO, "Succesfully clicked on Opp time");

						/*
						 * userobj.pickOppTime(); logger.log(LogStatus.INFO,
						 * "Succesfully picked  Opp time");
						 */

						userobj.getRecordAssignLimit(Recordlimit);
						logger.log(LogStatus.INFO, "Succesfully picked  Record limit");

						userobj.getAllowedopencases(AllowedNo);
						logger.log(LogStatus.INFO, "Succesfully picked  Allowed no. of open cases");

						userobj.clickOnSave();
						logger.log(LogStatus.INFO, "Succesfully clicked on save button");

						driver.navigate().refresh();
						Thread.sleep(5000);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
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
