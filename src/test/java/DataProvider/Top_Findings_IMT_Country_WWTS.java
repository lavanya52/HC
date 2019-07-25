package DataProvider;



import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

//import Pages.IDCOMP_Customer_Page;
import Pages.TopFindingsIMT_Page;
import Utility.ScreenShot;
import jxl.Workbook;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class Top_Findings_IMT_Country_WWTS extends WWTSGenerator{
	WebDriver driver ;
	private Date dateID = new Date();
	static String csvfileName;
	FirefoxProfile profile = new FirefoxProfile();
	
	
	//@Test(priority=1)
	public void Top_SER_TRA_ALL() throws Exception
	{
	
	String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=topfindingsimtcountry";

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
	
	TopFindingsIMT_Page custPage = PageFactory.initElements(driver, TopFindingsIMT_Page.class);
	ScreenShot.captureScreenshot(driver, "Top findings IMT-country WWTS");
	custPage.getimtCountry();
	custPage.getWWTS();
	custPage.getAllSystemState();
	custPage.getServer();
	ScreenShot.captureScreenshot(driver, "Top findings IMT-country WWTS");
	
	JavascriptExecutor Je = (JavascriptExecutor) driver;
	Je.executeScript("arguments[0].click();", custPage.getGenerateReportButton());
	Thread.sleep(30000);
	ScreenShot.captureScreenshot(driver, "Top findings IMT-country WWTS");
	
	List<WebElement>CheckMSG=driver.findElements(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[3]"));
	List<WebElement>CustLink=driver.findElements(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[2]/a"));
	List<WebElement>CheckID=driver.findElements(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[4]"));
				
					for(int i=0;i<CheckMSG.size();i++)
					{
			if(prodOScan1.getField(20).equalsIgnoreCase(CheckMSG.get(i).getText())) {
				System.out.println(CheckMSG.get(i).getText() +" ");
			System.out.println(i);
			
			for(int k=0;k<CheckID.size();k++) {
				if(i==k) {
					System.out.println(CheckID.get(k).getText() +" ");
				System.out.println(k);
			
			for(int j=0;j<CustLink.size();j++) {
				if(i==j) {
					System.out.println(j);
					JavascriptExecutor Je3 = (JavascriptExecutor) driver;
					Je3.executeScript("arguments[0].click();", CustLink.get(j));
					
				}
			}
		}
	}
}
}
	
					
					Thread.sleep(2000);
					String currentWindowHandle = driver.getWindowHandle();
					Set<String> allWindowHandles = driver.getWindowHandles();
					for(String window : allWindowHandles) {
						if(!window.equals(currentWindowHandle)) {
							driver.switchTo().window(window);
							System.out.println(driver.getTitle());
						}
					} 
					
	custPage.getDownloadCSV();
	
	CsvDownload("ALL","ALL","ALL");
	compareHeadings();
	int rowsize = custPage.getRowSizeAll();
	String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[1]/tbody[1]/tr";
	compareData(csvfileName,rowsize,path,2);
	
	int rowsize1 = custPage.getRowSize();
	String path1 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[2]/tbody[1]/tr";
	compareFindingsData(csvfileName,rowsize1,path1,3);
	
	driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[2]/tbody[1]/tr[1]/td[5]/a")).click();
	String currentWindowHandle1 = driver.getWindowHandle();
	Set<String> allWindowHandles1 = driver.getWindowHandles();
	for(String window1 : allWindowHandles1) {
		if(!window1.equals(currentWindowHandle1)) {
			driver.switchTo().window(window1);
			
			if(driver.getTitle().equalsIgnoreCase("ECM - Security Reporting on Demand | Health checking - Top findings customer message details")) {
				ScreenShot.captureScreenshot(driver, "Top findings customer message details WWTS");
				System.out.println(driver.getTitle());
				}
			
		}
	}
	
	cleanLocalFolder(Local_Folder_HC);
	driver.quit();
	}
	
	
	//@Test(priority=2)
	public void Top_STO_TRA_ALL() throws Exception
	{
	
	String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=topfindingsimtcountry";

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
	
	TopFindingsIMT_Page custPage = PageFactory.initElements(driver, TopFindingsIMT_Page.class);
	
	ScreenShot.captureScreenshot(driver, "Top findings IMT-country WWTS");
	custPage.getimtCountry();
	custPage.getWWTS();
	custPage.getTransition();
	custPage.getStorage();
	
	ScreenShot.captureScreenshot(driver, "Top findings IMT-country WWTS");
	JavascriptExecutor Je = (JavascriptExecutor) driver;
	Je.executeScript("arguments[0].click();", custPage.getGenerateReportButton());
	
	Thread.sleep(30000);
	ScreenShot.captureScreenshot(driver, "Top findings IMT-country WWTS");
	
	List<WebElement>CheckMSG=driver.findElements(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[3]"));
	List<WebElement>CustLink=driver.findElements(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[2]/a"));
	List<WebElement>CheckID=driver.findElements(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[4]"));
				
					for(int i=0;i<CheckMSG.size();i++)
					{
			if(transOScan3.getField(20).equalsIgnoreCase(CheckMSG.get(i).getText())) {
				System.out.println(CheckMSG.get(i).getText() +" ");
			System.out.println(i);
			
			for(int k=0;k<CheckID.size();k++) {
				if(i==k) {
					System.out.println(CheckID.get(k).getText() +" ");
				System.out.println(k);
			
			for(int j=0;j<CustLink.size();j++) {
				if(i==j) {
					System.out.println(j);
					JavascriptExecutor Je3 = (JavascriptExecutor) driver;
					Je3.executeScript("arguments[0].click();", CustLink.get(j));
					
				}
			}
		}
	}
}
}
	
					
					Thread.sleep(2000);
					String currentWindowHandle = driver.getWindowHandle();
					Set<String> allWindowHandles = driver.getWindowHandles();
					for(String window : allWindowHandles) {
						if(!window.equals(currentWindowHandle)) {
							driver.switchTo().window(window);
							System.out.println(driver.getTitle());
						}
					} 
					
	custPage.getDownloadCSV();
	
	CsvDownload("ALL","ALL","ALL");
	compareHeadings();
	int rowsize = custPage.getRowSizeAll();
	String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[1]/tbody[1]/tr";
	compareData(csvfileName,rowsize,path,2);
	
	int rowsize1 = custPage.getRowSize();
	String path1 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[2]/tbody[1]/tr";
	compareFindingsData(csvfileName,rowsize1,path1,3);
	
	driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[2]/tbody[1]/tr[1]/td[5]/a")).click();
	String currentWindowHandle1 = driver.getWindowHandle();
	Set<String> allWindowHandles1 = driver.getWindowHandles();
	for(String window1 : allWindowHandles1) {
		if(!window1.equals(currentWindowHandle1)) {
			driver.switchTo().window(window1);
			
			if(driver.getTitle().equalsIgnoreCase("ECM - Security Reporting on Demand | Health checking - Top findings customer message details")) {
				ScreenShot.captureScreenshot(driver, "Top findings customer message details WWTS");
				System.out.println(driver.getTitle());
				}
			
		}
	}
	
	cleanLocalFolder(Local_Folder_HC);
	driver.quit();
	}
	
	
	@Test(priority=3)
	public void Top_NET_TRA_ALL() throws Exception
	{
	
	String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=topfindingsimtcountry";

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
	
	TopFindingsIMT_Page custPage = PageFactory.initElements(driver, TopFindingsIMT_Page.class);
	
	ScreenShot.captureScreenshot(driver, "Top findings IMT-country WWTS");
	custPage.getimtCountry();
	custPage.getWWTS();
	custPage.getDeployment();
	custPage.getNetwork();
	
	ScreenShot.captureScreenshot(driver, "Top findings IMT-country WWTS");
	JavascriptExecutor Je = (JavascriptExecutor) driver;
	Je.executeScript("arguments[0].click();", custPage.getGenerateReportButton());
	Thread.sleep(30000);
	ScreenShot.captureScreenshot(driver, "Top findings IMT-country WWTS");
	
	List<WebElement>CheckMSG=driver.findElements(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[3]"));
	List<WebElement>CustLink=driver.findElements(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[2]/a"));
	List<WebElement>CheckID=driver.findElements(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td[4]"));
				
					for(int i=0;i<CheckMSG.size();i++)
					{
			if(deployOScan2.getField(20).equalsIgnoreCase(CheckMSG.get(i).getText())) {
				System.out.println(CheckMSG.get(i).getText() +" ");
			System.out.println(i);
			
			for(int k=0;k<CheckID.size();k++) {
				if(i==k) {
					System.out.println(CheckID.get(k).getText() +" ");
				System.out.println(k);
			
			for(int j=0;j<CustLink.size();j++) {
				if(i==j) {
					System.out.println(j);
					JavascriptExecutor Je3 = (JavascriptExecutor) driver;
					Je3.executeScript("arguments[0].click();", CustLink.get(j));
					
					
					}
				}
			}
		}
	}
}
	
					
					Thread.sleep(2000);
					String currentWindowHandle = driver.getWindowHandle();
					Set<String> allWindowHandles = driver.getWindowHandles();
					for(String window : allWindowHandles) {
						if(!window.equals(currentWindowHandle)) {
							driver.switchTo().window(window);
							
							
						}
					} 
					
	custPage.getDownloadCSV();
	
	CsvDownload("ALL","ALL","ALL");
	compareHeadings();
	int rowsize = custPage.getRowSizeAll();
	String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[1]/tbody[1]/tr";
	compareData(csvfileName,rowsize,path,2);
	
	int rowsize1 = custPage.getRowSize();
	String path1 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[2]/tbody[1]/tr";
	compareFindingsData(csvfileName,rowsize1,path1,3);
	
	
	driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[2]/tbody[1]/tr[1]/td[5]/a")).click();
	String currentWindowHandle1 = driver.getWindowHandle();
	Set<String> allWindowHandles1 = driver.getWindowHandles();
	for(String window1 : allWindowHandles1) {
		if(!window1.equals(currentWindowHandle1)) {
			driver.switchTo().window(window1);
			
			if(driver.getTitle().equalsIgnoreCase("ECM - Security Reporting on Demand | Health checking - Top findings customer message details")) {
				ScreenShot.captureScreenshot(driver, "Top findings customer message details WWTS");
				System.out.println(driver.getTitle());
				}
			
		}
	}
	
	
	cleanLocalFolder(Local_Folder_HC);
	driver.quit();
	}
	
	
	
	public String CsvDownload(String osFamily,String reportSys,String SystemState) throws Exception
	{
	//HC_topfindings_IMT_message_CANADA_CANADA_182_all_WWTS_all_ALL_ALL_190510
		
		
		String FilePartialName1 = "HC_topfindings_IMT_message_"+ IMT_COUNTRY.toUpperCase()+"_"+ IMT_COUNTRY.toUpperCase();
	
		csvfileName = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "0");
		
		return csvfileName;
		
	}
	public void compareHeadings() throws Exception
	{
		File CSVHeadersFile = new File("CSV\\TopFindings.xls");
		
		Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);
		
	
		
		for(int i=0 ; i <=24 ; i++)
		{
			
				System.out.println("****************** CSV Header********************************");
				System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 0).getContents());
				System.out.println("CSV File Name :" + getCellValueFromCSV(csvfileName, 0, i, Local_Folder_HC, CSV_Separator));	

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 0).getContents().trim(),getCellValueFromCSV(csvfileName, 0, i, Local_Folder_HC, CSV_Separator).trim());
			
			
		}
	}
	public void compareData(String fileName,int rowsize,String path,int columnSize)
	{
		System.out.println("rows size:"+ rowsize);
	
		for (int a=0 ; a<columnSize;a++)
		{ 
			System.out.println("**************FOR 1*******************");
			String webColum = Web_Column_HCTop_IMT[a]; 
			int csvColum =	Integer.parseInt(CSV_Column_HCTop_IMT[a]);
			
				
				for(int b=1 ; b<=rowsize ;b++)
				{ 
					System.out.println("**************FOR 2*******************");
					String xpath = path + "["+b+"]/td["+webColum+"]";
					
					System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b,csvColum , Local_Folder_HC,CSV_Separator) );

				String x=driver.findElement(By.xpath(xpath)).getText().trim();
				String y=getCellValueFromCSV(fileName, b, csvColum, Local_Folder_HC,CSV_Separator).trim();
				if(x==y)
				{
					System.out.println("msg id found");
				}
					
				}
		}
		
	}
		
		public void compareFindingsData(String fileName,int rowsize1,String path1,int columnSize)
		{
			System.out.println("rows size:"+ rowsize1);
		
			for (int a=0 ; a<columnSize;a++)
			{ 
				System.out.println("**************FOR 1*******************");
				String webColum = Web_Column_HCTopMsg_IMT[a]; 
				int csvColum =	Integer.parseInt(CSV_Column_HCTopMsg_IMT[a]);
				
					
					for(int b=1 ; b<=rowsize1 ;b++)
					{ 
						System.out.println("**************FOR 2*******************");
						String xpath = path1 + "["+b+"]/td["+webColum+"]";
						
						System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b,csvColum , Local_Folder_HC,CSV_Separator) );

					String x=driver.findElement(By.xpath(xpath)).getText().trim();
					String y=getCellValueFromCSV(fileName, b, csvColum, Local_Folder_HC,CSV_Separator).trim();
					if(x==y)
					{
						System.out.println("msg id found");
					}
						
					}
			}	
			
		
	}

		
		
		
		
		
}
