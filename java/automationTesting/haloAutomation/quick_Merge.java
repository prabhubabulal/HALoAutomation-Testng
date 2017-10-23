package automationTesting.haloAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class quick_Merge {
	static WiniumDriver driver = null;
	static WiniumDriverService service = null;
	static DesktopOptions options=null;
	
   
  @BeforeClass
	public static void setUoEnvironment() throws IOException{
		options = new DesktopOptions();
		options.setApplicationPath("C:\\Program Files (x86)\\House Advantage\\Quick Merge\\QuickMerge.exe");
		File diverPath = new File("src\\test\\resources\\Installables\\Winium.Desktop.Driver.exe");
		service = new WiniumDriverService.Builder().usingDriverExecutable(diverPath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
		service.start();
	}
	
  @Test
  public void startDriver() {
  	driver = new WiniumDriver(service,options);
  	WebElement quickMerge = driver.findElement(By.name("Quick Merge"));
  	quickMerge.findElement(By.name("UsernameTextBox")).sendKeys("qauser1");
  }
  
}
