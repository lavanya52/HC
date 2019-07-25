package DataProvider;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HC_AUCU_Overview_Page;
import Utility.ScreenShot;
import jxl.Workbook;

/**
 * @author RAVIKUMARREDDY
 *
 */
public class HC_App_AUCU_Overview_Verify extends ConfigReader {
	
	WebDriver driver ;
	static HC_AUCU_Overview_Page hc_aucu ;
	
	//@Test(priority=1)
	public void verify_IMT_MF_SER() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_applicationaucu";

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
		
		hc_aucu = PageFactory.initElements(driver, HC_AUCU_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		
		hc_aucu.getaucuIMT();
		hc_aucu.getAllSummary();
		hc_aucu.getServer();
				
		hc_aucu.getOsFamilyMainframe();
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		hc_aucu.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		hc_aucu.getDownloadCSV();
		
		//HC_APPLICATION_AU_CU_AU_FRANCE_CU_FRANCE_MF_SER_190520
		String csvfileName = CsvDownload("MF","SER");
		
		int rowsize = hc_aucu.getRowSizeAll();	
		int custSize = hc_aucu.getCustSize();
		String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/table[1]/tbody[1]/tr";
		String path2 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/table[3]/tbody[1]/tr";
		
		compareColumnHeading(csvfileName,custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,11,path2,16);
		
		driver.quit();
		
	}
	
	//@Test(priority=2)
	public void verify_IMT_ALL_NET() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_applicationaucu";

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
		
		hc_aucu = PageFactory.initElements(driver, HC_AUCU_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		hc_aucu.getaucuIMT();
		hc_aucu.getAllFamilies();
		hc_aucu.getNetworkDevices();
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		hc_aucu.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		hc_aucu.getDownloadCSV();
		
		//HC_APPLICATION_AU_CU_AU_FRANCE_CU_FRANCE_ALL_NET_190520
		String csvfileName = CsvDownload("ALL","NET");
		
		int rowsize = hc_aucu.getRowSizeAll();	
		int custSize = hc_aucu.getCustSize();
		String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/table[1]/tbody[1]/tr";
		String path2 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/table[3]/tbody[1]/tr";
			
		compareColumnHeading(csvfileName,custSize);
	
		compareData(csvfileName,rowsize,custSize,path,11,path2,16);
		
		driver.quit();
		
	}
	
	@Test(priority=3)
	public void verify_IMT_DS_STO() throws Exception
	{
		
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_applicationaucu";

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
		
		hc_aucu = PageFactory.initElements(driver, HC_AUCU_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		hc_aucu.getaucuIMT();
		hc_aucu.getStorageDevices();
		hc_aucu.getBusinessmgtSAP();

		hc_aucu.getOsFamilyDistributed();
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		hc_aucu.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		hc_aucu.getDownloadCSV();
		
		//HC_APPLICATION_AU_CU_AU_FRANCE_CU_FRANCE_DS_STO_190520
		String csvfileName = CsvDownload("DS","STO");
		
		int rowsize = hc_aucu.getRowSizeAll();	
		int custSize = hc_aucu.getCustSize();
		String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/table[1]/tbody[1]/tr";
		String path2 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/table[3]/tbody[1]/tr";
		
		compareColumnHeading(csvfileName,custSize);
	
		compareData(csvfileName,rowsize,custSize,path,11,path2,16);
		
		driver.quit();
		
	}
	
	//@Test(priority=4)
	public void verify_AllIMT_MF_SST() throws Exception
	{

		
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_applicationaucu";

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
		
		hc_aucu = PageFactory.initElements(driver, HC_AUCU_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "hc_aucu_Page");
		hc_aucu.getauAllIMT();
		hc_aucu.getAllDevices();
		hc_aucu.getBusinessmgtAll();
		hc_aucu.getOsFamilyAll();
		
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		hc_aucu.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "hc_app_aucu_Page");
		hc_aucu.getDownloadCSV();
		
		//HC_APPLICATION_AU_CU_AU_FRANCE_CU_FRANCE_ALL_ALL_190520
		String csvfileName = CsvDownload("ALL","ALL");
		
		int rowsize = hc_aucu.getRowSizeAll();	
		int custSize = hc_aucu.getCustSize();
		String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/table[1]/tbody[1]/tr";
		String path2 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/table[3]/tbody[1]/tr";
		
		compareColumnHeading(csvfileName,custSize);
	
		compareData(csvfileName,rowsize,custSize,path,11,path2,16);
		
		driver.quit();
		
	
		
	}
	
	public String CsvDownload(String osFamily,String reportSys) throws Exception
	{
		
		//HC_APPLICATION_AU_CU_AU_FRANCE_CU_FRANCE_ALL_SER_190520
		
		if(reportSys.equalsIgnoreCase("ALL")) {
			String FilePartialName1 = "HC_APPLICATION_AUCU_AU_"+COUNTRY_NAME+"_"+osFamily+ "_" +reportSys;
			String csvfileName = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "0");
			return csvfileName;
		}
		
		else {
			String FilePartialName1 = "HC_APPLICATION_AUCU_AU_"+COUNTRY_NAME+"_CU_"+COUNTRY_NAME+"_"+osFamily+ "_" +reportSys;
			String csvfileName = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "0");
			return csvfileName;
		}
		
		
		
	}
	
	public void compareData(String fileName,int rowsize,int custSize,String path,int columnSize,String path2,int columnSize2)
	{
		System.out.println("rows size:"+ rowsize);
		System.out.println("custSize:"+custSize);
		
		for (int a=0 ; a<columnSize;a++)
		{ 
			System.out.println("**************FOR 1*******************");
			String webColum = HC_App_AUCU_Overview_Web_Column_Summary[a]; 
			int csvColum =	Integer.parseInt(HC_App_AUCU_Overview_CSV_Column_Summary[a]);
			
				
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
				String webColum = HC_App_AUCU_Overview_Web_Column_Customers[a]; 
				int csvColum =	Integer.parseInt(HC_App_AUCU_Overview_CSV_Column_Customers[a]);
				
					
					for(int b=1 ; b<=custSize ;b++)
					{ 
						System.out.println("**************FOR 2*******************");
						String xpath = path2 + "["+b+"]/td["+webColum+"]";
						
						
							System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b+3,csvColum , Local_Folder_HC,CSV_Separator) );

							Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b+3, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
							
						}
						
						
					
					}
			
		}
	}
	
	public void compareColumnHeading (String fileName,int custSize) throws Exception
	{
		File CSVHeadersFile;
		
		
			CSVHeadersFile = new File("CSV\\HC_App_AUCU_Overview.xls");
				Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);
		
		for (int i = 0; i <= 19; i++) {
			
			
			
			System.out.println("****************** CSV Header********************************");
			System.out.println(i+"==> work book value :" + wb1.getSheet(0).getCell(i, 0).getContents());
			System.out.println(i+"==> CSV File Name :" + getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));

			Assert.assertEquals(wb1.getSheet(0).getCell(i, 0).getContents().trim(),getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));
			
			
		}
		
		if(custSize != 0)
		{
			
			for (int i = 0; i <= 48; i++)
			{
				System.out.println("****************** 2nd  CSV Header ********************************");
				System.out.println(i+"==> work book value :" + wb1.getSheet(0).getCell(i, 2).getContents());
				System.out.println(i+"==> CSV File Name :" + getCellValueFromCSV(fileName, 3, i, Local_Folder_HC, CSV_Separator));

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 2).getContents().toLowerCase().trim(),getCellValueFromCSV(fileName, 3, i, Local_Folder_HC, CSV_Separator).toLowerCase());
				
			}
			
			
		}
		
		
	}
	
	

}
