package automationTesting.haloAutomation.common.FunctionalSpecific;


import automationTesting.haloAutomation.common.utils.captureImage;
import automationTesting.haloAutomation.common.utils.generateHTML;
import automationTesting.haloAutomation.common.utils.webElementActionClass;
import automationTesting.haloAutomation.variables.haloVariables;

public class search {
public static void appSearch(String playerID){
		
	try{
		System.out.println("Player ID:"+playerID);
		webElementActionClass.setText("xpath", haloVariables.SEARCH_PLAYER_ID, playerID);
		System.out.println("=====================================");
		webElementActionClass.WebElementLink("xpath", haloVariables.SEARCH_IMAGE);
		System.out.println("=====================================");
		Thread.sleep(1000);	  
//		generateHTML.writeResults("Player Search", "Pass", "Player "+playerID+" Search Sucessful ", captureImage.capture("searchPage"));;
		System.out.println("Search Player Completed");
	}catch(Exception e){e.printStackTrace();}
}
}
