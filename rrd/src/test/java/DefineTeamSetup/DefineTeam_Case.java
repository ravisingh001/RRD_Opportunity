package DefineTeamSetup;

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
 * <b>QAT-RRD-Automate Define New Team for case- Create New Team- Add New
 * Criteria</b>
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
 * 5. Select Record type - Case criteria and clicks on Next button.
 * </p>
 * <p>
 * 6.New Team:Case Criteria pop up appears .
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
 * 21.Clicked on search people and picked value from looup.
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
 * 22.Fill the Last assigned Opp date
 * </p>
 * <p>
 * 22.Fill the Last assigned Opp Time
 * </p>
 * <p>
 * 22.Fill the Record limit
 * </p>
 * <p>
 * 22.Fill the Allowed no. of open cases
 * </p>
 * <p>
 * .Clicks on save that rendering to the Team details page.
 * </p>
 * 
 * 
 * 
 * 
 * @author Anshu
 *
 */

public class DefineTeam_Case {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Properties pro;
	public String Testdata_sheet_path = System.getProperty("user.dir") + File.separator + "AppData" + File.separator
			+ "DefineTeamSetup.xlsx";

	@BeforeMethod
	public void setUp() throws FileNotFoundException, InterruptedException {
		report = new ExtentReports("./Report/DefineTeamSetup.html");
		logger = report.startTest("Verify add  Define Team Setup ");
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
	public void DefineTeamSetup_case() throws InterruptedException {

		Xls_Reader reader = new Xls_Reader(Testdata_sheet_path);

		int KeywordrowCount = reader.getRowCount("Keyword");

		int RRDTeamrowCount = reader.getRowCount("RRDTeam");

		int Criteriacount = reader.getRowCount("TeamNewCriteria");

		int RRDusercount = reader.getRowCount("RRDUser");

		for (int rowNum = 2; rowNum <= KeywordrowCount; rowNum++) {

			for (int rownum = 2; rownum <= RRDTeamrowCount; rownum++) {

				try {

					if ((reader.getCellData("Keyword", "Team", rowNum))
							.equalsIgnoreCase(reader.getCellData("RRDTeam", "TeamName", rownum)))

					{
						String SpriorityOrder = reader.getCellData("RRDTeam", "PriorityOrder", rownum);
						String SteamName = reader.getCellData("RRDTeam", "TeamName", rownum);
						String SmaxIntakeLimit = reader.getCellData("RRDTeam", "Max_Intake_limit", rownum);
						String SAllowed_Numbe = reader.getCellData("RRDTeam", "Allowed_no._of_open_cases", rownum);

						TeamPage teamobj = PageFactory.initElements(driver, TeamPage.class);
						teamobj.clickOnDefineTeam();
						logger.log(LogStatus.INFO, "Succesfully clicked on  RRD Define team");

						teamobj.clickonNewTeam();
						logger.log(LogStatus.INFO, "Succesfully clicked on  RRD New team button");

						teamobj.clickonCaseCriteria_RadioButton();
						logger.log(LogStatus.INFO, "Succesfully clicked on  case New team button");
						teamobj.clickOnNext();

						logger.log(LogStatus.INFO, "Succesfully clicked on  RRD Next button");

						teamobj.type_priority_order(SpriorityOrder);
						logger.log(LogStatus.INFO, "Succesfully Enter priority order value");

						teamobj.type_Team_name(SteamName);
						logger.log(LogStatus.INFO, "Succesfully Enter Team name value");

						teamobj.type_Maximum_Intake_limit(SmaxIntakeLimit);
						logger.log(LogStatus.INFO, "Succesfully Enter Max Intake value");

						teamobj.type_Allowed_Num_of_case(SAllowed_Numbe);
						logger.log(LogStatus.INFO, "Succesfully Enter Allowed Num of open case");

						teamobj.click_save_button();
						logger.log(LogStatus.INFO, "Succesfully save the team for case criteria");

						driver.navigate().refresh();
						Thread.sleep(10000);
						try {
							System.out.println("Team Name is from sheet - " + SteamName);
							String tempteam = teamobj.teamInfo.getText();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							System.out.println("Team Name is from element - " + tempteam);
							Assert.assertTrue(tempteam.equalsIgnoreCase(SteamName), "Team name is not matching");
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						} catch (Exception e) {
							System.out.println("Assertion issue");
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			for (int rownumt = 2; rownumt <= Criteriacount; rownumt++) {
				try {

					if ((reader.getCellData("Keyword", "Team", rowNum))
							.equalsIgnoreCase(reader.getCellData("TeamNewCriteria", "TeamName", rownumt)))

					{

						String Scriteria = reader.getCellData("TeamNewCriteria", "RRD_Crieteria", rownumt);
						String Soperator = reader.getCellData("TeamNewCriteria", "RRD_operator", rownumt);
						String Sfieldval = reader.getCellData("TeamNewCriteria", "RRD_fieldvalue", rownumt);
						String logic = reader.getCellData("TeamNewCriteria", "CriteriaLogic", rownumt);

						TeamNewCriteriapage teamcriteria = PageFactory.initElements(driver, TeamNewCriteriapage.class);
						logger.log(LogStatus.INFO, "Succesfully directed to the team details page");

						teamcriteria.scrolldowntoNewcriteria();

						/*
						 * String teamcount=teamobj.TobeAssignedcount.getText();
						 * System.out.println("Team count is- "+teamcount); Thread.sleep(1000);
						 */
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

						teamcriteria.Clickonsave();
						logger.log(LogStatus.INFO, "Succesfully saved the team criteria ");

						teamcriteria.navigatebacktoParent();

						driver.navigate().refresh();

						teamcriteria.scrolldowntoNewcriteria();

						// System.out.println(teamcriteria.getMultipleCriteriaCount());
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

					if ((reader.getCellData("Keyword", "Team", rowNum))
							.equalsIgnoreCase(reader.getCellData("RRDUser", "TeamName", rowval))) {

						String RRdUser = reader.getCellData("RRDUser", "SearchPeople", rowval);
						String caseDate = reader.getCellData("RRDUser", "LastCaseAssignedDate", rowval);
						String Leaddate = reader.getCellData("RRDUser", "LastLeadAssignedDate", rowval);
						String Oppdate = reader.getCellData("RRDUser", "LastOppAssignedDate", rowval);
						String Recordlimit = reader.getCellData("RRDUser", "RecordAssignLimit", rowval);
						String AllowedNo = reader.getCellData("RRDUser", "Allowedopencases", rowval);

						RRD_user_adding userobj = PageFactory.initElements(driver, RRD_user_adding.class);

						userobj.clickonRelatedtab();
						logger.log(LogStatus.INFO, "Succesfully goes to  Related tab");

						logger.log(LogStatus.INFO, "Succesfully clicked on New uer");
						userobj.clickonnew();

						logger.log(LogStatus.INFO, "Succesfully clicked on new button");
						userobj.clicksOnsearchPeople(RRdUser);
						logger.log(LogStatus.INFO, "Succesfully clicked on search people");

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
