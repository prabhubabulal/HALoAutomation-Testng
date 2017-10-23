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
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;



public class enrollPlayer {
	WebDriver driver = webDriverClass.driver;
	String playerID  ;
	  
	  @Test (priority = 1)	  
	  public void enrollPlayer(){	
		  	  String MARKETING_TESTCASE = "TestCase_001";
		  	  String NONUS_CANADA_TESTCASE = "TestCase_002";
		  	  String TRANSPORTATION_TESTCASE = "TestCase_003";
			  playerID = playerEnrollment.enrollPlayer(MARKETING_TESTCASE); 	
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
		  
		  
	  }
	  
	  
}
