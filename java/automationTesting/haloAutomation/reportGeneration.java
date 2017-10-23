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
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;



public class reportGeneration {
	WebDriver driver = webDriverClass.driver;
	String playerID  ;
	

	  @AfterSuite
	  public void afterSuite() throws InterruptedException {

		 
		 Runtime rTime = Runtime.getRuntime();
		 String url = "C:/Users/babulalp/workspace/haloAutomation/src/test/resources/result/Halo_report_25-08-2017-15-52-44.html";
		 String browser = "C:/Program Files/Internet Explorer/iexplore.exe ";
		 Process pc;
		try {
			pc = rTime.exec(browser + url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		  
	  }
	  
	  
}
