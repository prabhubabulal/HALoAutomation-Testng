package automationTesting.haloAutomation.common.FunctionalSpecific;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationTesting.haloAutomation.common.utils.captureImage;
import automationTesting.haloAutomation.common.utils.generateHTML;
import automationTesting.haloAutomation.common.utils.readDataFromExcel;
import automationTesting.haloAutomation.common.utils.webDriverClass;
import automationTesting.haloAutomation.common.utils.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;

public class playerEnrollment {
public static String enrollPlayer(String testCaseID) {
	WebDriver driver = webDriverClass.driver;
	WebDriverWait wait = new WebDriverWait(driver,60);
	String playerType = "";
	String firstName = "";
	String lastName = "";
	String dateOfBirth = "";
	String gender = "";
	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	try{
		readDataFromExcel data = new readDataFromExcel();
		Map<String,Object[]> map = data.readTestData("TestData", "TestData", testCaseID);
		playerType = data.getValuefromMap(map, "Enrollment_Type", 0);
		firstName = data.getValuefromMap(map, "FirstName", 0);
		lastName = data.getValuefromMap(map, "LastName", 0);
		dateOfBirth = data.getValuefromMap(map, "BirthDate", 0);
		gender = data.getValuefromMap(map, "Gender", 0);
		System.out.println("Player Type : "+playerType);
		System.out.println("===================");
	}catch(Exception e){}
	
	
	
	Random rand = new Random();
	int random_3_Char = rand.nextInt(99);
	  firstName = firstName+String.valueOf(random_3_Char);
	  int random4_char = rand.nextInt(99);
	  lastName = lastName+String.valueOf(random4_char);
	  
	  if(playerType.equals("MARKETING")){
		  try{
		
			  
			  webElementActionClass.clickLink("id", haloVariables.PLAYERFUNCTIONSMENU);
			  webElementActionClass.clickLink("linktext", haloVariables.ENROLLPLAYER_MENU);
			  wait.until(ExpectedConditions.elementToBeClickable(By.id(haloVariables.ENROLLMENTTYPE)));
			  webElementActionClass.selectValue("id", haloVariables.ENROLLMENTTYPE, playerType);
			  wait.until(ExpectedConditions.elementToBeClickable(By.id(haloVariables.PREFIX)));
			  
			  // Entering Player Identity
			  webElementActionClass.setText("xpath", haloVariables.FIRSTNAME, firstName);
			  webElementActionClass.setText("xpath", haloVariables.LASTNAME, lastName);
			  webElementActionClass.setText("xpath", haloVariables.BIRTHDATE, dateOfBirth);
			  webElementActionClass.selectValue("xpath", haloVariables.GENDER, gender);
			  
			  //Entering Identification
			  webElementActionClass.selectValue("xpath", haloVariables.TYPE, "Driver's License");
//			  webElementActionClass.WebElementLink("xpath", haloVariables.IDENTIFICATIONNUMBER);
			  Thread.sleep(2000);
			  webElementActionClass.WebElementLink("xpath", haloVariables.IDENTIFICATIONNUMBER);
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(haloVariables.IDENTIFICATIONNUMBER)));
			  webElementActionClass.setText("xpath", haloVariables.IDENTIFICATIONNUMBER, "40000456556");
			  webElementActionClass.setText("xpath", haloVariables.EXPIRE_DATE, "01/05/2020");
			  webElementActionClass.selectValue("xpath", haloVariables.ID_STATE, "Nevada");
			  
			  //Address Details
			  webElementActionClass.setCheckBox("xpath", haloVariables.UCPLAYERADDRESS_CHKOPTIN);
			  webElementActionClass.selectValue("xpath", haloVariables.ADDRESSTYPE, "Home");
			  webElementActionClass.clickLink("xpath", haloVariables.ADDRESSLINE1);
			  Thread.sleep(2000);
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(haloVariables.ADDRESSLINE1)));
			  webElementActionClass.setText("xpath", haloVariables.ADDRESSLINE1, "7405 Burnham Avn");
			  webElementActionClass.setText("xpath", haloVariables.TXTCITY, "Los Vegas");
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(haloVariables.TXTSTATE)));
			  webElementActionClass.selectValue("xpath", haloVariables.TXTSTATE, "Nevada");
			  
			  webElementActionClass.setText("xpath", haloVariables.TXTZIP, "89123");
			  webElementActionClass.WebElementLink("xpath", haloVariables.ENROLL);
			  Thread.sleep(2000);
			  System.out.println("Enroll Player Completed");
			  return playerdetails(playerType);		
			  
		  }catch(Exception e){
			  e.printStackTrace();
			  return "";  
		  }  
	  }else if(playerType.equalsIgnoreCase("NON US or Canada")){
		  try{

			  
			  webElementActionClass.clickLink("id", haloVariables.PLAYERFUNCTIONSMENU);
			  webElementActionClass.clickLink("linktext", haloVariables.ENROLLPLAYER_MENU);
			  wait.until(ExpectedConditions.elementToBeClickable(By.id(haloVariables.ENROLLMENTTYPE)));
			  webElementActionClass.selectValue("id", haloVariables.ENROLLMENTTYPE, playerType);
			  wait.until(ExpectedConditions.elementToBeClickable(By.id(haloVariables.PREFIX)));
			  
			  // Entering Player Identity
			  webElementActionClass.setText("xpath", haloVariables.FIRSTNAME, firstName);
			  webElementActionClass.setText("xpath", haloVariables.LASTNAME, lastName);
			  webElementActionClass.setText("xpath", haloVariables.BIRTHDATE, "05/02/1989");
			  webElementActionClass.selectValue("xpath", haloVariables.GENDER, "Male");
			  
			  //Entering Identification
			  webElementActionClass.selectValue("xpath", haloVariables.TYPE, "Driver's License");
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(haloVariables.IDENTIFICATIONNUMBER)));
			  webElementActionClass.setText("xpath", haloVariables.IDENTIFICATIONNUMBER, "40000456556");
			  webElementActionClass.setText("xpath", haloVariables.EXPIRE_DATE, "01/05/2020");
			  webElementActionClass.selectValue("xpath", haloVariables.ID_STATE, "Nevada");
			  
			  //Address Details
			  webElementActionClass.setCheckBox("xpath", haloVariables.UCPLAYERADDRESS_CHKOPTIN);
			  webElementActionClass.selectValue("xpath", haloVariables.ADDRESSTYPE, "Home");
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(haloVariables.ADDRESSLINE1)));
			  webElementActionClass.setText("xpath", haloVariables.ADDRESSLINE1, "7405 Burnham Avn");
			  webElementActionClass.setText("xpath", haloVariables.TXTCITY, "Los Vegas");
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(haloVariables.TXTSTATE)));
			  webElementActionClass.selectValue("xpath", haloVariables.TXTSTATE, "Nevada");
			  
			  webElementActionClass.setText("xpath", haloVariables.TXTZIP, "89123");
			  webElementActionClass.WebElementLink("xpath", haloVariables.ENROLL);
			  Thread.sleep(500);System.out.println("Enroll Player Completed");
			  return playerdetails(playerType);		
			  
		  }catch(Exception e){
			  e.printStackTrace();
			  return "";  
		  }
		  
	  }else if(playerType.equalsIgnoreCase("Transportation")){
		  try{

			  
			  webElementActionClass.clickLink("id", haloVariables.PLAYERFUNCTIONSMENU);
			  webElementActionClass.clickLink("linktext", haloVariables.ENROLLPLAYER_MENU);
			  wait.until(ExpectedConditions.elementToBeClickable(By.id(haloVariables.ENROLLMENTTYPE)));
			  webElementActionClass.selectValue("id", haloVariables.ENROLLMENTTYPE, playerType);
			  wait.until(ExpectedConditions.elementToBeClickable(By.id(haloVariables.PREFIX)));
			  
			  // Entering Player Identity
			  webElementActionClass.setText("xpath", haloVariables.FIRSTNAME, firstName);
			  webElementActionClass.setText("xpath", haloVariables.LASTNAME, lastName);
			  webElementActionClass.setText("xpath", haloVariables.BIRTHDATE, "05/02/1989");
			  webElementActionClass.selectValue("xpath", haloVariables.GENDER, "Male");
			  
			  //Entering Identification
			  webElementActionClass.selectValue("xpath", haloVariables.TYPE, "Driver's License");
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(haloVariables.IDENTIFICATIONNUMBER)));
			  webElementActionClass.setText("xpath", haloVariables.IDENTIFICATIONNUMBER, "40000456556");
			  webElementActionClass.setText("xpath", haloVariables.EXPIRE_DATE, "01/05/2020");
			  webElementActionClass.selectValue("xpath", haloVariables.ID_STATE, "Nevada");
			  
			  //Address Details
			  webElementActionClass.setCheckBox("xpath", haloVariables.UCPLAYERADDRESS_CHKOPTIN);
			  webElementActionClass.selectValue("xpath", haloVariables.ADDRESSTYPE, "Home");
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(haloVariables.ADDRESSLINE1)));
			  webElementActionClass.setText("xpath", haloVariables.ADDRESSLINE1, "7405 Burnham Avn");
			  webElementActionClass.setText("xpath", haloVariables.TXTCITY, "Los Vegas");
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(haloVariables.TXTSTATE)));
			  webElementActionClass.selectValue("xpath", haloVariables.TXTSTATE, "Nevada");
			 
			  webElementActionClass.setText("xpath", haloVariables.TXTZIP, "89123");
			  webElementActionClass.WebElementLink("xpath", haloVariables.ENROLL);
			  Thread.sleep(500);System.out.println("Enroll Player Completed");
			  return playerdetails(playerType);		
			  
		  }catch(Exception e){
			  generateHTML.writeResults("New Player Enrollment", "Fail", "Player Enrollment Failed", captureImage.capture("EnrollPage"));
			  e.printStackTrace();
			  return "";  
		  }
	  }
	  return "";
}

public static String playerdetails(String playertype){
	 WebDriver driver = webDriverClass.driver;
	 try{
		 WebDriverWait wait = new WebDriverWait(driver,60);
		  Thread.sleep(10000);		  
		  webDriverClass.switchDriver("ifrContent");
		  String tierLabel = driver.findElement(By.xpath(haloVariables.TIERLABEL)).getText();
		  assertEquals(tierLabel, "RUBY");
		  String playerID = driver.findElement(By.xpath(haloVariables.PLAYERID)).getText();
		  Thread.sleep(2000);
		  webDriverClass.switchDriver();
		  generateHTML.writeResults("Player Enrollment", "Pass", playertype+" player enrolled successfully. Player ID is "+playerID+" and Tier Value is "+tierLabel , captureImage.capture("EnrollPage"));
		  return playerID;		  
	  }catch(Exception e){e.printStackTrace();}
	 	  generateHTML.writeResults("New Player Enrollment", "Fail", "Player Enrollment Failed", captureImage.capture("EnrollPage"));
		  driver.switchTo().defaultContent();
		  return "";
}

}
