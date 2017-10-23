package automationTesting.haloAutomation;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;


import automationTesting.haloAutomation.common.FunctionalSpecific.adjustBucketValue;
import automationTesting.haloAutomation.common.FunctionalSpecific.adjustPlayerTierLevel;
import automationTesting.haloAutomation.common.FunctionalSpecific.loginClass;
import automationTesting.haloAutomation.common.FunctionalSpecific.playerEnrollment;
import automationTesting.haloAutomation.common.FunctionalSpecific.propertyPlayPopUp;
import automationTesting.haloAutomation.common.FunctionalSpecific.pushPlayerEnrollment;
import automationTesting.haloAutomation.common.FunctionalSpecific.search;
import automationTesting.haloAutomation.common.utils.captureImage;
import automationTesting.haloAutomation.common.utils.generateHTML;
import automationTesting.haloAutomation.common.utils.webDriverClass;
import automationTesting.haloAutomation.common.utils.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;



public class updatePlayer {
	WebDriver driver = webDriverClass.driver;
	String playerID  ;
	  
	  @Test (priority = 1)	  
	  public void enrollPlayer() throws InterruptedException{	
		  	  String MARKETING_TESTCASE = "TestCase_001";		  			  
			  try {
				  playerID = playerEnrollment.enrollPlayer(MARKETING_TESTCASE); 
				  String cmd = "C:\\Users\\babulalp\\Desktop\\UpdateAccountType.vbs";
				  Process p = Runtime.getRuntime().exec("wscript "+cmd+" " + playerID+" PROP3UAT L");
				  p.waitFor();
				  Thread.sleep(10000);
				  for(int i=0;i<=5;i++){
					  search.appSearch(playerID);
					  webDriverClass.switchDriver("ifrContent");
					  String playerType = driver.findElement(By.id(haloVariables.CREDITBUTTON)).getAttribute("Value");
					  Thread.sleep(2000);
					  
					  if (playerType.equals("Cr")){
						  webDriverClass.switchDriver();
						  generateHTML.writeResults("Update Player in CMS", "Pass", "Player Updated to Cr in CMS", captureImage.capture("searchPage"));
						  return;
					  } 
				  }
				  webDriverClass.switchDriver();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				webDriverClass.switchDriver();
				e.printStackTrace();
			}
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
