package automationTesting.haloAutomation;

import org.testng.annotations.Test;
import automationTesting.haloAutomation.common.FunctionalSpecific.loginClass;
import automationTesting.haloAutomation.common.FunctionalSpecific.playerEnrollment;
import automationTesting.haloAutomation.common.utils.captureImage;
import automationTesting.haloAutomation.common.utils.generateHTML;
import automationTesting.haloAutomation.common.utils.webDriverClass;
import automationTesting.haloAutomation.common.utils.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
public class MultiPlayerEnrollment {
	WebDriver driver = webDriverClass.driver;
	int marketingPlayerCount = 1;
	int nonCanadaPlayerCount = 0;
	int transportationPlayerCount = 0;
	String players = "SC|IP|STLV|BC";
	
	String playerID  ;
	String property;
	  @Test (priority = 1)	  
	  public void enrollPlayer(){			  	
		     String[] playerSplit = players.split("\\|");
		     String appUserName = "";
		     String appPassword = "";
		     for(int j =0;j<playerSplit.length;j++){
		    	 property = playerSplit[j];
		    	
		    	 if(playerSplit[j].toString().equalsIgnoreCase("IP")){
		    		 appUserName = "qauser1";
		    		 appPassword = "Password1";
		    	 }else if(playerSplit[j].toString().equalsIgnoreCase("SC")){
		    		 appUserName = "qauser4";
		    		 appPassword = "Password1";
		    	 }else if(playerSplit[j].toString().equalsIgnoreCase("STLV")){
		    		 appUserName = "qauser7";
		    		 appPassword = "Password1";
		    	 }else if (playerSplit[j].toString().equalsIgnoreCase("BC")) {
		    		 appUserName = "BabulalP";
		    		 appPassword = "Bal667Pra";
		    	 }
		    	 String MARKETING_TESTCASE = "TestCase_001";
			  	  String NONUS_CANADA_TESTCASE = "TestCase_002";
			  	  String TRANSPORTATION_TESTCASE = "TestCase_003";
			  	 driver = webDriverClass.getDriver("ie");
			  	 generateHTML.writeResults("Property", "Pass", "Property : "+property, captureImage.capture("property"));
			  	  loginClass.login(appUserName, appPassword, webDriverClass.appDomain);
			  	  for(int i =0;i<marketingPlayerCount;i++){
			  		playerID = playerEnrollment.enrollPlayer(MARKETING_TESTCASE);  
			  	  }
			  	  
			  	for(int i =0;i<nonCanadaPlayerCount;i++){
			  		playerID = playerEnrollment.enrollPlayer(NONUS_CANADA_TESTCASE);  
			  	  }
			  	
			  	for(int i =0;i<transportationPlayerCount;i++){
			  		playerID = playerEnrollment.enrollPlayer(TRANSPORTATION_TESTCASE);  
			  	  } 
			  	 webElementActionClass.clickLink(haloVariables.LOGOUT);
				 driver.quit();
		     }  	 
		    
		  	  
			  }	  
	  
	  @BeforeSuite
	  public void beforeSuite() {	
		  String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			Date today = new Date();
			String currentTime = today.getHours()+"-"+today.getMinutes()+"-"+today.getSeconds();
		  String datetime = currentDate+"-"+currentTime;
		  //generateHTML.writeStartResults("Halo", datetime, "Prabhu Babulal", "UAT");
//		  driver = webDriverClass.getDriver("ie");
		  File file = new File("src\\test\\java\\resources\\config\\haloApp-UAT.properties");
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file.getAbsolutePath());
				System.out.println("Application Properties File Path : "+file.getAbsolutePath());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();

			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		  String appURL = prop.getProperty("app.url");
		  generateHTML.writeStartResults("Halo", datetime, "Prabhu Babulal", "UAT",webDriverClass.appUsername,appURL);
		  generateHTML.writeResults("E2E Testing", "", "", "");
		  System.out.println("Inside Before Suite");		
	  }

	  @AfterSuite
	  public void afterSuite() {
		 webElementActionClass.clickLink(haloVariables.LOGOUT);
		 driver.quit();
		  
		  
	  }
	  
	  
}
