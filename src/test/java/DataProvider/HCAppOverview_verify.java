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


import Pages.HCAppOverview_Page;
import Utility.ScreenShot;
import jxl.Workbook;

/**
 * @author Ramya
 *
 */
public class HCAppOverview_verify extends ConfigReader {
	
	WebDriver driver ;
	static HCAppOverview_Page HCAppOvw ;
	
	//@Test(priority=1)
	public void verify_All_ReportedSystem() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcapplicationovw";

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
		
		HCAppOvw = PageFactory.initElements(driver, HCAppOverview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HCAppOvw_Page");
		
		HCAppOvw.getAllSummary();
		
		HCAppOvw.getAllDevices();
		
		
		HCAppOvw.getOsFamilyAll();
		
		HCAppOvw.getGenerateButton();
		
		Thread.sleep(10000);
		
		HCAppOvw.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("ALL","ALL");
		
		int rowsize = HCAppOvw.getRowSizeAll();	
		int custSize = 0;
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		//String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,13);
		
		driver.quit();
		
	}
	
	//@Test(priority=2)
	public void verify_All_Device_Except_Network() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcapplicationovw";

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
		
		HCAppOvw = PageFactory.initElements(driver, HCAppOverview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HCAppOvw_Page");
		
		HCAppOvw.getAllFamilies();
		
		HCAppOvw.getAllExceptNetwork();
		
		HCAppOvw.getOsFamilyDistributed();
		
		HCAppOvw.getGenerateButton();
		
		Thread.sleep(10000);
		
		HCAppOvw.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("DS","SST");
		
		int rowsize = HCAppOvw.getRowSizeAll();	
		int custSize = 0;
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		//String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,13);
		
		driver.quit();
		
	}
	
	
	//@Test(priority=3)
	public void verify_HCAppOvw_Servers() throws Exception
	{
		
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcapplicationovw";

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
		
		HCAppOvw = PageFactory.initElements(driver, HCAppOverview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HCAppOvw_Page");
		
		HCAppOvw.getBusinessmgtSAP();
		
		HCAppOvw.getServer();
		
		HCAppOvw.getOsFamilyMainframe();
		
		HCAppOvw.getGenerateButton();
		
		Thread.sleep(10000);
		
		HCAppOvw.getDownloadCSV();
		
		//HC_DEPLOYMENT_IMT_Country_UNITED_STATES_UNITED_STATES_NA_IMI_All_ALL_ALL_181012
		String csvfileName = CsvDownload("MF","SER");
		
		int rowsize = HCAppOvw.getRowSizeImt();
		int custSize = 0;
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		//String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,custSize);
	
		compareData(csvfileName,rowsize,custSize,path,13);
		
		driver.quit();
		
	}
	
	//@Test(priority=4)
	public void verify_Network_Devices() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcapplicationovw";

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
		
		HCAppOvw = PageFactory.initElements(driver, HCAppOverview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HCAppOvw_Page");
		
		HCAppOvw.getAllSummary();
		
		HCAppOvw.getNetworkDevices();
		
		HCAppOvw.getOsFamilyAll();
		
		HCAppOvw.getGenerateButton();
		
		Thread.sleep(10000);
		
		HCAppOvw.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("ALL","NET");
		
		int rowsize = HCAppOvw.getRowSizeAll();	
		int custSize = 0;
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		//String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,13);
		
		driver.quit();
		
	}
	
	@Test(priority=5)
	public void verify_Storage_Devices() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcapplicationovw";

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
		
		HCAppOvw = PageFactory.initElements(driver, HCAppOverview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HCAppOvw_Page");
		
		HCAppOvw.getAllSummary();
		
		HCAppOvw.getStorageDevices();
		
		HCAppOvw.getOsFamilyDistributed();
		
		HCAppOvw.getGenerateButton();
		
		Thread.sleep(10000);
		
		HCAppOvw.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("DS","STO");
		
		int rowsize = HCAppOvw.getRowSizeAll();	
		int custSize = 0;
		String path = ".//*[@id='ibm-content-main']/div[6]/div/table[1]/tbody/tr";
		//String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,13);
		
		driver.quit();
		
	}
	public String CsvDownload(String osFamily,String reportSys) throws Exception
	{
		
		//HC_APPLICATION_overview_ALL_SER_190123.csv
		String FilePartialName1 = "HC_APPLICATION_overview_" + osFamily + "_" + reportSys ;
	
		String csvfileName = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "0");
		
		return csvfileName;
	}
	
	public void compareData(String fileName,int rowsize,int custSize,String path,int columnSize)
	{
		System.out.println("rows size:"+ rowsize);
		System.out.println("custSize:"+custSize);
		
		for (int a=0 ; a<columnSize;a++)
		{ 
			System.out.println("**************FOR 1*******************");
			String webColum = Web_Column_HCAPPO[a]; 
			int csvColum =	Integer.parseInt(CSV_Column_HCAPPO[a]);
			 if(a==0)
				 {
				 for(int b=1 ; b<=rowsize ;b++)
					{ 
						System.out.println("**************FOR 2*******************");
						String xpath = path + "["+b+"]/td["+webColum+"]";
						
						System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b,csvColum , Local_Folder_HC,CSV_Separator) );

					Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().substring(0, 3).trim(),getCellValueFromCSV(fileName, b, csvColum, Local_Folder_HC,CSV_Separator).substring(0, 3).trim()); 
					
					}
				 
				 
			 }
				 
			 else { 
				 
				for(int b=1 ; b<=rowsize ;b++)
				{ 
					System.out.println("**************FOR 2*******************");
					String xpath = path + "["+b+"]/td["+webColum+"]";
					
					System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b,csvColum , Local_Folder_HC,CSV_Separator) );
					System.out.println("csv column : WEB Column" +csvColum +":" +webColum);
				Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
				System.out.println("csv column" +csvColum);
				
				}
		}
		}
		/*if(custSize != 0)
		{
			for (int a=0 ; a<columnSize2;a++)
			{ 
				System.out.println("**************FOR 1*******************");
				String webColum = Web_Column_Country_HCAPPO[a]; 
				int csvColum =	Integer.parseInt(CSV_Column_Country_HCAPPO[a]);
				
					
					for(int b=1 ; b<=custSize ;b++)
					{ 
						System.out.println("**************FOR 2*******************");
						String xpath = path2 + "["+b+"]/td["+webColum+"]";
						
						if(a == 2)
						{
							xpath = xpath + "/span";
							
							System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getAttribute("title").substring(0, 1).toUpperCase() + ":" + getCellValueFromCSV(fileName, b+3,csvColum , Local_Folder_HCAppOvew,CSV_Separator) );

							Assert.assertEquals(driver.findElement(By.xpath(xpath)).getAttribute("title").substring(0, 1).toUpperCase().trim(),getCellValueFromCSV(fileName, b+3, csvColum, Local_Folder_HCAppOvew,CSV_Separator).trim());
						}
						else
						{
							System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b+3,csvColum , Local_Folder_HCAppOvew,CSV_Separator) );

							Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b+3, csvColum, Local_Folder_HCAppOvew,CSV_Separator).trim()); 
							
						}
						
						
					
					}
			}
			
			
		}*/
	}
	
	public void compareColumnHeading (String fileName, int custSize) throws Exception
	{
		File CSVHeadersFile;
		
		
			CSVHeadersFile = new File("CSV\\HCAppOve.xls");			
		
			Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);
		
		for (int i = 0; i <= 45; i++) {
			
			{
			/*	if (imt.equalsIgnoreCase("IMT"))
				{
					System.out.println("****************** CSV Header********************************");
					System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 1).getContents());
					System.out.println("CSV File Name :" + getCellValueFromCSV(fileName, 0, i, Local_Folder_HCAppOvew, CSV_Separator));	

					Assert.assertEquals(wb1.getSheet(0).getCell(i, 1).getContents().substring(0, 3).trim(),getCellValueFromCSV(fileName, 0, i, Local_Folder_HCAppOvew, CSV_Separator));
				}
				else
				{
					System.out.println("****************** CSV Header********************************");
					System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 1).getContents());
					System.out.println("CSV File Name :" + getCellValueFromCSV(fileName, 0, i, Local_Folder_HCAppOvew, CSV_Separator));	

					Assert.assertEquals(wb1.getSheet(0).getCell(i, 1).getContents().substring(7).trim(),getCellValueFromCSV(fileName, 0, i, Local_Folder_HCAppOvew, CSV_Separator));	
				}
			}*/
			/*else
			{*/
			
			System.out.println("****************** CSV Header********************************");
			System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 1).getContents());
			System.out.println("CSV File Name :" + getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));

			Assert.assertEquals(wb1.getSheet(0).getCell(i, 1).getContents().trim(),getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));
			}
			
		}
		
		/*if(custSize != 0)
		{
			
			for (int i = 0; i <= 29; i++)
			{
				System.out.println("****************** 2nd  CSV Header ********************************");
				System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 3).getContents());
				System.out.println("CSV File Name :" + getCellValueFromCSV(fileName, 3, i, Local_Folder_HCAppOvew, CSV_Separator));

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 3).getContents().trim(),getCellValueFromCSV(fileName, 3, i, Local_Folder_HCAppOvew, CSV_Separator));
				
			}
			
			
		}
		*/
		
	}
	
	

}
