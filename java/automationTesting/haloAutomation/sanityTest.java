package automationTesting.haloAutomation;

import org.testng.annotations.Test;


import automationTesting.haloAutomation.common.FunctionalSpecific.adjustBucketValue;
import automationTesting.haloAutomation.common.FunctionalSpecific.adjustPlayerTierLevel;
import automationTesting.haloAutomation.common.FunctionalSpecific.loginClass;
import automationTesting.haloAutomation.common.FunctionalSpecific.playerEnrollment;
import automationTesting.haloAutomation.common.FunctionalSpecific.propertyPlayPopUp;
import automationTesting.haloAutomation.common.FunctionalSpecific.pushPlayerEnrollment;
import automationTesting.haloAutomation.common.FunctionalSpecific.search;
import automationTesting.haloAutomation.common.utils.generateHTML;
import automationTesting.haloAutomation.common.utils.webDriverClass;
import automationTesting.haloAutomation.common.utils.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;



public class sanityTest {
	WebDriver driver = webDriverClass.driver;
	String playerID  ;
	  
	  @Test (priority = 1)	  
	  public void enrollPlayer(){	
		  String MARKETING_TESTCASE = "TestCase_001";
	  	  String NONUS_CANADA_TESTCASE = "TestCase_002";
	  	  String TRANSPORTATION_TESTCASE = "TestCase_003";
			  playerID = playerEnrollment.enrollPlayer(MARKETING_TESTCASE); 	
			  }
	  
	  @Test(priority = 2)
	  public void searchPlayer(){		  
		  search.appSearch(playerID);
	  }
	  
	  @Test(priority = 3)
	  public void editPlayerPatron() throws InterruptedException{
		  automationTesting.haloAutomation.common.FunctionalSpecific.editPlayerPatron.editPlayer(playerID);
	  }
	  @Test(priority = 6)
	  public void pushPlayerPopup() throws InterruptedException{
		  pushPlayerEnrollment.pushPlayer(playerID,"Suncoast");
	  }
	  
	  @Test(priority= 7)
	  public void propertyPlayPopup() throws InterruptedException{
		  propertyPlayPopUp.propertyPlayPopUp(playerID);
	  }
	  
	  @Test (priority=4)
	  public void adjustmentBucketValue(){
		  adjustBucketValue.adjustBucketValue(playerID,"Card Score Earnings");
		  adjustBucketValue.adjustBucketValue(playerID,"Slot Points Earnings");
	  }
	  
	  @Test (priority =5)
	  public void adjustmentTierValue(){
		  adjustPlayerTierLevel.adjustPlayerTierLevel(playerID, "SAPPHIRE", "None");
	  }
	  
	  
	  @BeforeSuite
	  public void beforeSuite() {	
		  String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			Date today = new Date();
			String currentTime = today.getHours()+"-"+today.getMinutes()+"-"+today.getSeconds();
		  String datetime = currentDate+"-"+currentTime;
		  //generateHTML.writeStartResults("Halo", datetime, "Prabhu Babulal", "UAT");
		  driver = webDriverClass.getDriver("ie");
		  generateHTML.writeStartResults("Halo", datetime, "Prabhu Babulal", "UAT",webDriverClass.appUsername,webDriverClass.appURL);
		  generateHTML.writeResults("E2E Testing", "", "", "");
		  loginClass.login(webDriverClass.appUsername, webDriverClass.appPassword, webDriverClass.appDomain);		
	  }

	  @AfterSuite
	  public void afterSuite() {
		 webElementActionClass.clickLink(haloVariables.LOGOUT);
		 driver.quit();
		 generateHTML.writeEndResult();		
		 
//		 // Added to open the html report after execution
//		 
//		 Runtime rTime = Runtime.getRuntime();
//		 Path url = Paths.get(generateHTML.reportPath);
//		 String browser = "C:/Program Files/Internet Explorer/iexplore.exe ";
//		 Process pc;
//		try {
//			pc = rTime.exec(browser + url);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		 
	  }
	  
	  
}
