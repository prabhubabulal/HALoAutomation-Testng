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
import automationTesting.haloAutomation.common.utils.writeDataExcel;
import automationTesting.haloAutomation.variables.haloVariables;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;



public class manualRating {
	WebDriver driver = webDriverClass.driver;
	String playerID  ;
	  
	  @Test (priority = 1)	  
	  public void enrollPlayer() throws InterruptedException, EncryptedDocumentException, InvalidFormatException{	
		  	  String MARKETING_TESTCASE = "TestCase_001";		  			  
			  				  playerID = playerEnrollment.enrollPlayer(MARKETING_TESTCASE);	
							  // Add Multiple Rating in CMS							
			  				String cmd = "src\\test\\java\\automationTesting\\haloAutomation\\MultipleRating.vbs";
							  Process p;
							try {
								p = Runtime.getRuntime().exec("wscript "+cmd+" " + playerID+" "+webDriverClass.appCMSProperty+" "+MARKETING_TESTCASE);							
								p.waitFor();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							  search.appSearch(playerID);
							  webElementActionClass.clickLink(haloVariables.TRIPS_MENU);
								Thread.sleep(1000);
								webDriverClass.switchDriver("ifrContent");							
							  
							  
							  int pageNumber = 1;
							  String page;
							  do {
								  
								  try{
									  driver.findElement(By.xpath(haloVariables.TRIPLINK.replace("TRIPNUMBER", "1"))).isDisplayed();	
									  driver.findElement(By.xpath(haloVariables.TRIPLINK.replace("TRIPNUMBER", "1"))).click();
								  }catch(Exception e){
									  break;
								  }
								  System.out.println("Trip "+pageNumber+" Details");	
								  System.out.println("================");								  
								  Thread.sleep(1000);
								  System.out.println("Rating Type name is  - "+webElementActionClass.readDataFromWebTable("RatingTypeName", haloVariables.TRIPWEBTABLE));
								  System.out.println("Property Name is  - "+webElementActionClass.readDataFromWebTable("PropertyName", haloVariables.TRIPWEBTABLE));
								  System.out.println("BaseReinvestment is  - "+webElementActionClass.readDataFromWebTable("BaseReinvestment", haloVariables.TRIPWEBTABLE));
								  System.out.println("GameID is  - "+webElementActionClass.readDataFromWebTable("GameID", haloVariables.TRIPWEBTABLE));
								  System.out.println("StartDateTime  is  - "+webElementActionClass.readDataFromWebTable("StartDateTime", haloVariables.TRIPWEBTABLE));
								  System.out.println("EndDateTime  is  - "+webElementActionClass.readDataFromWebTable("EndDateTime", haloVariables.TRIPWEBTABLE));
								  System.out.println("TimePlayed  is  - "+webElementActionClass.readDataFromWebTable("TimePlayed", haloVariables.TRIPWEBTABLE));

								  try{
									  driver.findElement(By.linkText("Next Rating")).isDisplayed();
									  driver.findElement(By.linkText("Next Rating")).click();
									  Thread.sleep(1000);
									  System.out.println("Rating Type name is  - "+webElementActionClass.readDataFromWebTable("RatingTypeName", haloVariables.TRIPWEBTABLE));
									  System.out.println("Property Name is  - "+webElementActionClass.readDataFromWebTable("PropertyName", haloVariables.TRIPWEBTABLE));
									  System.out.println("BaseReinvestment is  - "+webElementActionClass.readDataFromWebTable("BaseReinvestment", haloVariables.TRIPWEBTABLE));
									  System.out.println("GameID is  - "+webElementActionClass.readDataFromWebTable("GameID", haloVariables.TRIPWEBTABLE));
									  System.out.println("StartDateTime  is  - "+webElementActionClass.readDataFromWebTable("StartDateTime", haloVariables.TRIPWEBTABLE));
									  System.out.println("EndDateTime  is  - "+webElementActionClass.readDataFromWebTable("EndDateTime", haloVariables.TRIPWEBTABLE));
									  System.out.println("TimePlayed  is  - "+webElementActionClass.readDataFromWebTable("TimePlayed", haloVariables.TRIPWEBTABLE));
								  }catch(Exception e){}
								  webElementActionClass.clickLink("linktext", "Back To Trip History");
								  Thread.sleep(1000);
								  System.out.println("Trip "+pageNumber+" Details ");
								  System.out.println("================");
								  try{
									  driver.findElement(By.xpath(haloVariables.TRIPLINK.replace("TRIPNUMBER", "2"))).isDisplayed();	
									  driver.findElement(By.xpath(haloVariables.TRIPLINK.replace("TRIPNUMBER", "2"))).click();
								  }catch(Exception e){
									  break;
								  }
								  Thread.sleep(1000);
								  System.out.println("Rating Type name is  - "+webElementActionClass.readDataFromWebTable("RatingTypeName", haloVariables.TRIPWEBTABLE));
								  System.out.println("Property Name is  - "+webElementActionClass.readDataFromWebTable("PropertyName", haloVariables.TRIPWEBTABLE));
								  System.out.println("BaseReinvestment is  - "+webElementActionClass.readDataFromWebTable("BaseReinvestment", haloVariables.TRIPWEBTABLE));
								  System.out.println("GameID is  - "+webElementActionClass.readDataFromWebTable("GameID", haloVariables.TRIPWEBTABLE));
								  System.out.println("StartDateTime  is  - "+webElementActionClass.readDataFromWebTable("StartDateTime", haloVariables.TRIPWEBTABLE));
								  System.out.println("EndDateTime  is  - "+webElementActionClass.readDataFromWebTable("EndDateTime", haloVariables.TRIPWEBTABLE));
								  System.out.println("TimePlayed  is  - "+webElementActionClass.readDataFromWebTable("TimePlayed", haloVariables.TRIPWEBTABLE));
								  try{
									  driver.findElement(By.linkText("Next Rating")).isDisplayed();
									  driver.findElement(By.linkText("Next Rating")).click();
									  Thread.sleep(1000);
									  System.out.println("Rating Type name is  - "+webElementActionClass.readDataFromWebTable("RatingTypeName", haloVariables.TRIPWEBTABLE));
									  System.out.println("Property Name is  - "+webElementActionClass.readDataFromWebTable("PropertyName", haloVariables.TRIPWEBTABLE));
									  System.out.println("BaseReinvestment is  - "+webElementActionClass.readDataFromWebTable("BaseReinvestment", haloVariables.TRIPWEBTABLE));
									  System.out.println("GameID is  - "+webElementActionClass.readDataFromWebTable("GameID", haloVariables.TRIPWEBTABLE));
									  System.out.println("StartDateTime  is  - "+webElementActionClass.readDataFromWebTable("StartDateTime", haloVariables.TRIPWEBTABLE));
									  System.out.println("EndDateTime  is  - "+webElementActionClass.readDataFromWebTable("EndDateTime", haloVariables.TRIPWEBTABLE));
									  System.out.println("TimePlayed  is  - "+webElementActionClass.readDataFromWebTable("TimePlayed", haloVariables.TRIPWEBTABLE));
								  }catch(Exception e){}
								  
								  webElementActionClass.clickLink("linktext", "Back To Trip History");
								  Thread.sleep(1000);								  
								  pageNumber = pageNumber+1;
								  page = String.valueOf(pageNumber);
								  boolean pageAvailability = false;
								  try{
									  pageAvailability = driver.findElement(By.linkText(page)).isDisplayed(); 
									  driver.findElement(By.linkText(page)).click();
								  }catch(Exception e){
									  try{
										  driver.findElement(By.linkText("Next")).isDisplayed();
										  driver.findElement(By.linkText("Next")).click();
									  }catch(Exception ex){break;}
									  }								  
							  }while(pageNumber>0);
							  
							  
			  }	  
	  
	  @BeforeSuite
	  public void beforeSuite() {	
		  String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			Date today = new Date();
			String currentTime = today.getHours()+"-"+today.getMinutes()+"-"+today.getSeconds();
		  String datetime = currentDate+"-"+currentTime;
		  //generateHTML.writeStartResults("Halo", datetime, "Prabhu Babulal", "UAT");
		  driver = webDriverClass.getDriver("chrome");
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
