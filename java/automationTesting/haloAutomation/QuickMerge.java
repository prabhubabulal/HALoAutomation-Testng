package automationTesting.haloAutomation;



import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.IOException;

public class QuickMerge {
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
	
    @BeforeTest
    public void startDriver() {
    	driver = new WiniumDriver(service,options);
    }
}