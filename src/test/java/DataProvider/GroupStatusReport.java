package DataProvider;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.GroupPage;
import Utility.ScreenShot;
//import Pages.IDCOMP_Customer_Page;
/**
 * @author LAVANYA
 *
 */

public class GroupStatusReport extends ConfigReader {
	WebDriver driver ;
	private Date dateID = new Date();
	FirefoxProfile profile = new FirefoxProfile();
	//@Test(priority=1)
	public void check()
	{
	
	String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=report_hcgroupcustreport";

	System.out.println(URL);
	FirefoxProfile profile = new FirefoxProfile();

	// Set Location to store files after downloading.
	profile.setPreference("browser.download.dir", Local_Folder_HC);
	profile.setPreference("browser.download.folderList", 2);

	// Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
	profile.setPreference("browser.helperApps.neverAsk.saveToDisk",	"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");

	profile.setPreference("browser.download.manager.showWhenStarting", false);
	profile.setPreference("pdfjs.disabled", true);

	// Pass FProfile parameter In webdriver to use preferences to download file.
	driver = new FirefoxDriver(profile);
	driver.get(URL);
	driver.manage().window().maximize();

	GroupPage custPage = PageFactory.initElements(driver, GroupPage.class);
	custPage.getIoTIMTCountry();
	JavascriptExecutor Je = (JavascriptExecutor) driver;
	Je.executeScript("arguments[0].click();", custPage.getGenerateReportButton());
	ScreenShot.captureScreenshot(driver, "Group Info Page");
	//driver.close();
	
	

}
}
