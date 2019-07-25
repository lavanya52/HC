/**
 * 
 */
package DataProvider;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HCOverview_Page;
import Utility.ScreenShot;
import jxl.Workbook;

/**
 * @author RajaReddy
 *
 */
public class HCOverview_Verify extends ConfigReader {
	
	WebDriver driver ;
	static HCOverview_Page HCO ;
	
	//@Test(priority=1)
	public void verify_All_ReportedSystem() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_ovw";

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
		
		HCO = PageFactory.initElements(driver, HCOverview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HCO_Page");
		
		HCO.getAllDevices();
		
		HCO.getOsFamilyAll();
		
		HCO.getGenerateButton();
		
		Thread.sleep(10000);
		
		HCO.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("ALL","ALL");
		
		int rowsize = HCO.getRowSizeAll();	
		int custSize = 0;
		String path = ".//*[@id='ibm-content-main']/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,"TRANS","IMT",custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,11,path2,19);
		
		driver.quit();
		
	}
	
	//@Test(priority=2)
	public void verify_All_Device_Except_Network() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_ovw";

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
		
		HCO = PageFactory.initElements(driver, HCOverview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HCO_Page");
		
		HCO.getAllExceptNetwork();
		
		HCO.getOsFamilyDistributed();
		
		HCO.getGenerateButton();
		
		Thread.sleep(10000);
		
		HCO.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("DS","SST");
		
		int rowsize = HCO.getRowSizeAll();	
		int custSize = 0;
		String path = ".//*[@id='ibm-content-main']/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,"TRANS","IMT",custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,11,path2,19);
		
		driver.quit();
		
	}
	
	
	//@Test(priority=3)
	public void verify_HCO_Servers() throws Exception
	{
		
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_ovw";

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
		
		HCO = PageFactory.initElements(driver, HCOverview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HCO_Page");
		
		HCO.getServer();
		
		HCO.getOsFamilyMainframe();
		
		HCO.getGenerateButton();
		
		Thread.sleep(10000);
		
		HCO.getDownloadCSV();
		
		//HC_DEPLOYMENT_IMT_Country_UNITED_STATES_UNITED_STATES_NA_IMI_All_ALL_ALL_181012
		String csvfileName = CsvDownload("MF","SER");
		
		int rowsize = HCO.getRowSizeImt();
		int custSize = 0;
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,"DEPLOY","IMT",custSize);
	
		compareData(csvfileName,rowsize,custSize,path,11,path2,15);
		
		driver.quit();
		
	}
	
	//@Test(priority=4)
	public void verify_Network_Devices() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_ovw";

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
		
		HCO = PageFactory.initElements(driver, HCOverview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HCO_Page");
		
		HCO.getNetworkDevices();
		
		HCO.getOsFamilyAll();
		
		HCO.getGenerateButton();
		
		Thread.sleep(10000);
		
		HCO.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("ALL","NET");
		
		int rowsize = HCO.getRowSizeAll();	
		int custSize = 0;
		String path = ".//*[@id='ibm-content-main']/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,"TRANS","IMT",custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,11,path2,19);
		
		driver.quit();
		
	}
	
	@Test(priority=5)
	public void verify_Storage_Devices() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_ovw";

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
		
		HCO = PageFactory.initElements(driver, HCOverview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HCO_Page");
		
		HCO.getStorageDevices();
		
		HCO.getOsFamilyDistributed();
		
		HCO.getGenerateButton();
		
		Thread.sleep(10000);
		
		HCO.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("DS","STO");
		
		int rowsize = HCO.getRowSizeAll();	
		int custSize = 0;
		String path = ".//*[@id='ibm-content-main']/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,"TRANS","IMT",custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,11,path2,19);
		
		driver.quit();
		
	}
	public String CsvDownload(String osFamily,String reportSys) throws Exception
	{
		
		//HC_TRANSITION_IMT_Country_All_NA_IMI_External_ALL_SER_181010
		String FilePartialName1 = "HC_overview_" + osFamily + "_" + reportSys ;
	
		String csvfileName = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "0");
		
		return csvfileName;
	}
	
	public void compareData(String fileName,int rowsize,int custSize,String path,int columnSize,String path2,int columnSize2)
	{
		System.out.println("rows size:"+ rowsize);
		System.out.println("custSize:"+custSize);
		
		for (int a=0 ; a<columnSize;a++)
		{ 
			System.out.println("**************FOR 1*******************");
			String webColum = Web_Column_HCO[a]; 
			int csvColum =	Integer.parseInt(CSV_Column_HCO[a]);
			
				
				for(int b=1 ; b<=rowsize ;b++)
				{ 
					System.out.println("**************FOR 2*******************");
					String xpath = path + "["+b+"]/td["+webColum+"]";
					
					System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b,csvColum , Local_Folder_HC,CSV_Separator) );

				Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
				
				}
		}
		
		if(custSize != 0)
		{
			for (int a=0 ; a<columnSize2;a++)
			{ 
				System.out.println("**************FOR 1*******************");
				String webColum = Web_Column_Country_HCO[a]; 
				int csvColum =	Integer.parseInt(CSV_Column_Country_HCO[a]);
				
					
					for(int b=1 ; b<=custSize ;b++)
					{ 
						System.out.println("**************FOR 2*******************");
						String xpath = path2 + "["+b+"]/td["+webColum+"]";
						
						if(a == 2)
						{
							xpath = xpath + "/span";
							
							System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getAttribute("title").substring(0, 1).toUpperCase() + ":" + getCellValueFromCSV(fileName, b+3,csvColum , Local_Folder_HC,CSV_Separator) );

							Assert.assertEquals(driver.findElement(By.xpath(xpath)).getAttribute("title").substring(0, 1).toUpperCase().trim(),getCellValueFromCSV(fileName, b+3, csvColum, Local_Folder_HC,CSV_Separator).trim());
						}
						else
						{
							System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b+3,csvColum , Local_Folder_HC,CSV_Separator) );

							Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b+3, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
							
						}
						
						
					
					}
			}
			
			
		}
	}
	
	public void compareColumnHeading (String fileName, String state,String imt,int custSize) throws Exception
	{
		File CSVHeadersFile;
		
		if(state.equalsIgnoreCase("TRANS"))
		{
			CSVHeadersFile = new File("CSV\\HCOver.xls");			
		}
		else
		{
			CSVHeadersFile = new File("CSV\\HCOver.xls");
		}
		
		

		Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);
		
		for (int i = 0; i <= 41; i++) {
			
			if (i==1)
			{
				if (imt.equalsIgnoreCase("IMT"))
				{
					System.out.println("****************** CSV Header********************************");
					System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 1).getContents());
					System.out.println("CSV File Name :" + getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));	

					Assert.assertEquals(wb1.getSheet(0).getCell(i, 1).getContents().substring(0, 3).trim(),getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));
				}
				else
				{
					System.out.println("****************** CSV Header********************************");
					System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 1).getContents());
					System.out.println("CSV File Name :" + getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));	

					Assert.assertEquals(wb1.getSheet(0).getCell(i, 1).getContents().substring(7).trim(),getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));	
				}
			}
			else
			{
			
			System.out.println("****************** CSV Header********************************");
			System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 1).getContents());
			System.out.println("CSV File Name :" + getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));

			Assert.assertEquals(wb1.getSheet(0).getCell(i, 1).getContents().trim(),getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));
			}
			
		}
		
		if(custSize != 0)
		{
			
			for (int i = 0; i <= 29; i++)
			{
				System.out.println("****************** 2nd  CSV Header ********************************");
				System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 3).getContents());
				System.out.println("CSV File Name :" + getCellValueFromCSV(fileName, 3, i, Local_Folder_HC, CSV_Separator));

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 3).getContents().trim(),getCellValueFromCSV(fileName, 3, i, Local_Folder_HC, CSV_Separator));
				
			}
			
			
		}
		
		
	}
	
	

}
