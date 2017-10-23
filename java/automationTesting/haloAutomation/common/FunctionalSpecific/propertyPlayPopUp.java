package automationTesting.haloAutomation.common.FunctionalSpecific;


import automationTesting.haloAutomation.common.utils.captureImage;
import automationTesting.haloAutomation.common.utils.generateHTML;
import automationTesting.haloAutomation.common.utils.webDriverClass;
import automationTesting.haloAutomation.common.utils.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;

public class propertyPlayPopUp {
public static void propertyPlayPopUp(String playerType) {
	try{	
	  webElementActionClass.clickLink("id", haloVariables.PLAYERFUNCTIONSMENU);
	  Thread.sleep(1000);
	  webElementActionClass.clickLink(haloVariables.PROPERTYPLAY_POPUP_MENU);	  
	  Thread.sleep(1000);
	  webDriverClass.switchDriver("FramePopUp1");	  
	  String[] propertyPlayPopup = webElementActionClass.readDataFromWebTable(haloVariables.PROPERTY_PLAY_POPUP_TABLE);
	  for(int i=0;i<propertyPlayPopup.length;i++){
		  System.out.println("Transaction "+(i+1)+" :"+propertyPlayPopup[i].toString());
	  }
	  
	  generateHTML.writeResults("Property Play Popup", "Pass", "Property Play Popup entry is successful and Last Entry is "+ propertyPlayPopup[propertyPlayPopup.length-1].toString(), captureImage.capture("propertyPlayPopup"));
	  webElementActionClass.clickLink("xpath", haloVariables.CANCELBUTTON);
	  webDriverClass.switchDriver();
	}catch(Exception e){e.printStackTrace();}
	
}



}
