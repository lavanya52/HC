package DataProvider;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HC_APP_IOT_IMT_NonProd_Page;
//import Pages.HC_IOT_IMT_Page;
import Utility.ScreenShot;
import jxl.Workbook;

/**
 * @author RAVIKUMARREDDY
 *
 */
public class HC_APP_IOT_IMT_Country_NonProd_Verify 	extends ConfigReader {
		
		WebDriver driver ;
		static HC_APP_IOT_IMT_NonProd_Page iot_imt ;
		
		//@Test(priority=1)
		
		public void verify_AllIMT() throws Exception
		{
			String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcappliovwimtcountrytrans";

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
			
			iot_imt = PageFactory.initElements(driver, HC_APP_IOT_IMT_NonProd_Page.class);
			
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			
			iot_imt.getSector();
			
			iot_imt.getAllIMT();
			
			iot_imt.getSummary();
			
			iot_imt.getOsFamilyDistributed();
			
			iot_imt.getServer();
					
			iot_imt.getAccountTypeExternal();
			
			iot_imt.getTransitionState();
			
		//	iot_imt.getOsFamilyMainframe();
			
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			iot_imt.getGenerateButton();
			
			Thread.sleep(10000);
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			iot_imt.getDownloadCSV();
			
			
			String csvfileName = CsvDownload("TRANSITION","ALL","IBM","External","DS","SER");
			
			int rowsize = iot_imt.getRowSizeAll();	
			int custSize = 0;
			String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
			String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
			                
			
			
			compareColumnHeading(csvfileName,"TRANS","IMT",custSize);
			

			
			compareData(csvfileName,rowsize,custSize,path,11,path2,17);
			
			driver.quit();
			
		}
		
		//@Test(priority=2)
		public void verify_SingleIOT() throws Exception
		{
			String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcappliovwimtcountrytrans";

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
			
			iot_imt = PageFactory.initElements(driver, HC_APP_IOT_IMT_NonProd_Page.class);
			
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			
			iot_imt.getSector();
			
			iot_imt.getSingleIOT();
			
			iot_imt.getFamily();
			
			iot_imt.getTransitionState();
			
			iot_imt.getNetworkDevices();
					
			iot_imt.getAccountType();
			
			//iot_imt.getOsFamilyDistributed();
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			iot_imt.getGenerateButton();
			
			Thread.sleep(10000);
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			iot_imt.getDownloadCSV();
			
			
			String csvfileName = CsvDownload("TRANSITION","AP-IOT","IBM","All","ALL","NET");
			
			int rowsize = iot_imt.getRowSizeImt();
			int custSize = iot_imt.getCustSize();
			String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
			String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
				
			compareColumnHeading(csvfileName,"TRANS","IOT",custSize);
		
			compareData(csvfileName,rowsize,custSize,path,11,path2,16);
			
			driver.quit();
			
		}
		
		//@Test(priority=3)
		public void verify_SingleIOT_IMT_Country() throws Exception
		{
			
			String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcappliovwimtcountrytrans";

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
			
			iot_imt = PageFactory.initElements(driver, HC_APP_IOT_IMT_NonProd_Page.class);
			
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			
			iot_imt.getSectorNA();
			
			iot_imt.getSingleIOT_1INDIA_SA();
			
			iot_imt.getTransitionState();
			
			iot_imt.getStorageDevices();
					
			iot_imt.getAccountTypeExternal();
			
			
			iot_imt.getMGMT_ALL();
			
			iot_imt.getOsFamilyMainframe();
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			iot_imt.getGenerateButton();
			
			Thread.sleep(10000);
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			iot_imt.getDownloadCSV();
			
			//HC_DEPLOYMENT_IMT_Country_UNITED_STATES_UNITED_STATES_NA_IMI_All_ALL_ALL_181012
			String csvfileName = CsvDownload("TRANSITION","INDIA_SA","Public","External","MF","STO");
			
			
			int rowsize = iot_imt.getRowSizeImt();
			int custSize = iot_imt.getCustSize();
			String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
			String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[3]/tbody/tr";
			
			compareColumnHeading(csvfileName,"DEPLOY","IMT",custSize);
		
			compareData(csvfileName,rowsize,custSize,path,11,path2,16);
			
			driver.quit();
			
		}
		
		//@Test(priority=4)
		public void verify_SingleIOT_IMT() throws Exception
		{

			
			String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcappliovwimtcountrytrans";

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
			
			iot_imt = PageFactory.initElements(driver, HC_APP_IOT_IMT_NonProd_Page.class);
			
			ScreenShot.captureScreenshot(driver, "IOT_IMT_NonProd_Page");
            //iot_imt.getSector();
			
			iot_imt.getAllIMT();
			
			iot_imt.getMGMT_ALL();
			
			iot_imt.getTransitionState();
			
			iot_imt.getAllDevices();
					
			iot_imt.getAccountTypeITSGBSExtenal();
			
			iot_imt.getOsFamilyAll();
			
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			iot_imt.getGenerateButton();
			
			Thread.sleep(10000);
			ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
			iot_imt.getDownloadCSV();
			
			//
			String csvfileName = CsvDownload("TRANSITION","ALL","","ITS-GBS_external","ALL","ALL");
			
			
			int rowsize = iot_imt.getRowSizeAll();
			int custSize = 0;
			String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
			String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
			
			compareColumnHeading(csvfileName,"DEPLOY","IMT",custSize);
		
			//compareData(csvfileName,rowsize,custSize,path,10,path2,12);
			compareData(csvfileName,rowsize,custSize,path,11,path2,16);
			
			driver.quit();
			
		
			
		}

			
			
			
		@Test(priority=5)
			public void verify_All_IMT() throws Exception
			{

				
				String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcappliovwimtcountrytrans";

				System.out.println(URL);
				FirefoxProfile profile =
						new FirefoxProfile();

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
				
				iot_imt = PageFactory.initElements(driver, HC_APP_IOT_IMT_NonProd_Page.class);
				
				ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
				
			//	iot_imt.getSectorNA();
				
				iot_imt.getAllIMT();
				
				iot_imt.getDeploymentState();
				
				iot_imt.getAllDevices();
						
				iot_imt.getAccountType();
				
				iot_imt.getMGMT_APP();
				
				iot_imt.getOsFamilyAll();
				
				ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
				iot_imt.getGenerateButton();
				
				Thread.sleep(10000);
				ScreenShot.captureScreenshot(driver, "HC_APP_IOT_IMT_NonProd_Page");
				iot_imt.getDownloadCSV();
				
				//HC_DEPLOYMENT_APPLICATION_ALL_NA_IMI_All_ALL_SER_181026
				String csvfileName = CsvDownload("DEPLOYMENT","ALL","","All","ALL","ALL");
				
				int rowsize = iot_imt.getRowSizeIOTAll();
				int custSize = 0;
				String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
				String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
				
				compareColumnHeading(csvfileName,"DEPLOY","IMT",custSize);
			
				compareData(csvfileName,rowsize,custSize,path,11,path2,16);
				
				driver.quit();
		
			
		}
		
		public String CsvDownload(String sysstate,String imtCountry,String sector,String accType,String osFamily,String reportSys) throws Exception
		{
			
			//HC_DEPLOYMENT_APPLICATION_FRANCE_All_ALL_NET_181026(1)
			String FilePartialName1 ;

			if(sector.equalsIgnoreCase("IBM"))
			{
				FilePartialName1 = "HC_" +sysstate+"_APPLICATION_"+ imtCountry + "_" + sector + "_" + accType + "_" + osFamily + "_" + reportSys ;			
			}
			else if(sector.equalsIgnoreCase("Public"))
			{
				FilePartialName1 = "HC_" +sysstate+"_APPLICATION_"+ imtCountry + "_" + sector + "_" + accType + "_" + osFamily + "_" + reportSys ;			
			}
			else
			{
				FilePartialName1 = "HC_" +sysstate+"_APPLICATION_"+ imtCountry + "_" + accType + "_" + osFamily + "_" + reportSys ;
			}
			
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
				String webColum = App_IOT_IMT_NonProd_Web_Column[a]; 
				int csvColum =	Integer.parseInt(App_IOT_IMT_NonProd_CSV_Column[a]);
				
					
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
					String webColum = App_IOT_IMT_NonProd_Web_Column_Country[a]; 
					int csvColum =	Integer.parseInt(App_IOT_IMT_NonProd_CSV_Column_Country[a]);
					
						
						for(int b=1 ; b<=custSize ;b++)
						{ 
							System.out.println("**************FOR 2*******************");
							String xpath = path2 + "["+b+"]/td["+webColum+"]";
							
							/*if(a == 4)
							{
								xpath = xpath + "/span";
								
								System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getAttribute("title").substring(0, 1).toUpperCase() + ":" + getCellValueFromCSV(fileName, b+3,csvColum , Local_Folder_APP_IMT_Non_prod,CSV_Separator) );

								Assert.assertEquals(driver.findElement(By.xpath(xpath)).getAttribute("title").substring(0, 1).toUpperCase().trim(),getCellValueFromCSV(fileName, b+3, csvColum, Local_Folder_APP_IMT_Non_prod,CSV_Separator).trim());
							}*/
							
							System.out.println("**********Table2 Excution Started***************");
								System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName,b+3,csvColum , Local_Folder_HC,CSV_Separator) );

								Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b+3, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
								
							
							
							
						
						}
				}
				
				
			}
		}
		
		public void compareColumnHeading (String fileName, String state,String imt,int custSize) throws Exception
		{
			File CSVHeadersFile;
			
			if(state.equalsIgnoreCase("TRANS"))
			{
				CSVHeadersFile = new File("CSV\\HCAppIOTIMTNonProdDeploy.xls");			
			}
			else
			{
				CSVHeadersFile = new File("CSV\\HCAppIOTIMTNonProdTrans.xls");
			}
			
			

			Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);
			
			for (int i = 0; i <= 18; i++) {
				
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
				
				for (int i = 0; i <= 27; i++)
				{
					
					System.out.println("****************** 2nd  CSV Header ********************************");
					System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 3).getContents());
					System.out.println("CSV File Name :" + getCellValueFromCSV(fileName, 3, i, Local_Folder_HC, CSV_Separator));

					Assert.assertEquals(wb1.getSheet(0).getCell(i, 3).getContents().trim(),getCellValueFromCSV(fileName, 3, i, Local_Folder_HC, CSV_Separator));
										
				}
				
				
			}
			
			
			
		}
		
		

	}


