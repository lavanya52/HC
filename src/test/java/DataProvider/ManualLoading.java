package DataProvider;

import java.io.File;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import Utility.ScreenShot;
/**
 * @author LAVANYA
 *
 */

public class ManualLoading extends ConfigReader {
	WebDriver driver ;
	private Date dateID = new Date();
	FirefoxProfile profile = new FirefoxProfile();
	//@Test(priority=1)
	public void Verify() 
	{
		
			//Group.IMT_RVT.20181010041241.csv
	
		
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/mload.php?mload=report_group_upload";

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
	
		
	WebElement uploadElement=	driver.findElement(By.xpath("//input[@id='file_input']"));
	JavascriptExecutor Je3 = (JavascriptExecutor) driver;
	Je3.executeScript("arguments[0].click();", uploadElement);
	String ID = getDate(dateID, "yyyyMMddHHmmss");
	String GroupFileName = "Group.IMT_RVT" + "." + ID + ".csv";
	String filename= Local_Folder_HC + File.separator + GroupFileName;
     uploadElement.sendKeys(filename);
    WebElement upload=	 driver.findElement(By.xpath("//*[@id='ibm-content-main']/div[3]/div/form/p[2]/input"));
	JavascriptExecutor Je4 = (JavascriptExecutor) driver;
	Je3.executeScript("arguments[0].click();", upload);
	
	String currentWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	for(String window : allWindowHandles) {
		if(!window.equals(currentWindowHandle)) {
			driver.switchTo().window(window);
		}
	} 
	System.out.println("file uploaded successfully");
	
	ScreenShot.captureScreenshot(driver, "Group File");
	driver.quit();
	}

}
