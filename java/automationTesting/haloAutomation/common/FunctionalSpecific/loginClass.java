package automationTesting.haloAutomation.common.FunctionalSpecific;

import automationTesting.haloAutomation.common.utils.captureImage;
import automationTesting.haloAutomation.common.utils.generateHTML;
import automationTesting.haloAutomation.common.utils.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;

public class loginClass {
	
public static void login(String userName, String password, String domain){
	  try{
		  webElementActionClass.setText("xpath", haloVariables.USERNAME, userName);
		  webElementActionClass.setText("xpath", haloVariables.PASSWORD, password);
		  webElementActionClass.selectValue("xpath", haloVariables.DOMAIN, domain);
		  webElementActionClass.WebElementLink("xpath", haloVariables.LOGINSUBMIT);		
		  Thread.sleep(2000);
		  generateHTML.writeResults("Login", "Pass", "Login Sucessful", captureImage.capture("LoginPage"));
		  Thread.sleep(1000);		 
	  }catch(Exception e){
		  System.out.println(e.getMessage());
	  }
	
}
	 
	 
}
