/**
 * 
 */
package DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HC_NonProd_Overview_Page;
import Utility.ScreenShot;
import jxl.Workbook;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class HC_NonProd_Overview_Verify extends ConfigReader {
	
	WebDriver driver ;
	static HC_NonProd_Overview_Page hc_nonprod ;
	
	//@Test(priority=1)
	public void verify_TRANSITION_MF_SER() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_ovwtrans";

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
		
		hc_nonprod = PageFactory.initElements(driver, HC_NonProd_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
		
		//hc_nonprod.getSector();
		
		//hc_nonprod.getAllIMT();
		
		hc_nonprod.getTransitionState();
		
		hc_nonprod.getServer();
				
		//hc_nonprod.getAccountType();
		
		hc_nonprod.getOsFamilyMainframe();
		
		//hc_nonprod.getOsFamilyDistributed();
		
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
		hc_nonprod.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
		hc_nonprod.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("TRANSITION","MF","SER");
		
		int rowsize = hc_nonprod.getRowSizeAll();	
		int custSize = 0;
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,"TRANS","IMT",custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,17,path2,19);
		
		driver.quit();
		
	}
	
	//@Test(priority=2)
	public void verify_TRANSITION_ALL_NET() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_ovwtrans";

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
		
		hc_nonprod = PageFactory.initElements(driver, HC_NonProd_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Page");
		
		
		
		hc_nonprod.getTransitionState();
		
		hc_nonprod.getNetworkDevices();
				
		hc_nonprod.getOsFamilyAll();
		
		//hc_nonprod.getOsFamilyDistributed();
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
		hc_nonprod.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
		hc_nonprod.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("TRANSITION","ALL","NET");
		
		int rowsize = hc_nonprod.getRowSizeImt();
		int custSize = 0;
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
			
		compareColumnHeading(csvfileName,"TRANS","IMT",custSize);
	
		compareData(csvfileName,rowsize,custSize,path,17,path2,19);
		
		driver.quit();
		
	}
	
	//@Test(priority=3)
	public void verify_DEPLOYMENT_DS_STO() throws Exception
	{
		
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_ovwtrans";

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
		
		hc_nonprod = PageFactory.initElements(driver, HC_NonProd_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Page");
		
		
		
		hc_nonprod.getDeploymentState();
		
		hc_nonprod.getStorageDevices();
				
		
		
		hc_nonprod.getOsFamilyDistributed();
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
		hc_nonprod.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
		hc_nonprod.getDownloadCSV();
		
		//HC_DEPLOYMENT_IMT_Country_UNITED_STATES_UNITED_STATES_NA_IMI_All_ALL_ALL_181012
		String csvfileName = CsvDownload("DEPLOYMENT","DS","STO");
		
		int rowsize = hc_nonprod.getRowSizeImt();
		int custSize = 0;
		//int custSize = hc_nonprod.getCustSize();
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,"DEPLOY","IMT",custSize);
	
		compareData(csvfileName,rowsize,custSize,path,13,path2,15);
		
		driver.quit();
		
	}
	
	//@Test(priority=4)
	public void verify_DEPLOYMENT_MF_SST() throws Exception
	{

		
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_ovwtrans";

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
		
		hc_nonprod = PageFactory.initElements(driver, HC_NonProd_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Page");
		
		
		
		hc_nonprod.getDeploymentState();
		
		hc_nonprod.getAllExceptNetwork();
				
		hc_nonprod.getOsFamilyMainframe();
		
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
		hc_nonprod.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
		hc_nonprod.getDownloadCSV();
		
		//HC_DEPLOYMENT_IMT_Country_UNITED_STATES_NA_IMI_All_MF_SST_181014
		String csvfileName = CsvDownload("DEPLOYMENT","MF","SST");
		
		int rowsize = hc_nonprod.getRowSizeIOTAll();
		int custSize = 0;
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,"DEPLOY","IMT",custSize);
	
		compareData(csvfileName,rowsize,custSize,path,13,path2,15);
		
		driver.quit();
		
	
		
	}
	
		@Test(priority=5)
		public void verify_TRANSITION_DS_ALL() throws Exception
		{
			
			String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_ovwtrans";

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
			
			hc_nonprod = PageFactory.initElements(driver, HC_NonProd_Overview_Page.class);
			
			ScreenShot.captureScreenshot(driver, "HC_NonProd_Page");
			
			
			
			hc_nonprod.getTransitionState();
			
			hc_nonprod.getAllDevices();
			
			hc_nonprod.getOsFamilyDistributed();
			
			ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
			hc_nonprod.getGenerateButton();
			
			Thread.sleep(10000);
			ScreenShot.captureScreenshot(driver, "HC_NonProd_Overview_Page");
			hc_nonprod.getDownloadCSV();
			
			//HC_DEPLOYMENT_IMT_Country_UNITED_STATES_UNITED_STATES_NA_IMI_All_ALL_ALL_181012
			String csvfileName = CsvDownload("TRANSITION","DS","ALL");
			
			int rowsize = hc_nonprod.getRowSizeImt();
			int custSize = 0;
			//int custSize = hc_nonprod.getCustSize();
			String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
			String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
			
			compareColumnHeading(csvfileName,"TRANS","IMT",custSize);
		
			compareData(csvfileName,rowsize,custSize,path,13,path2,15);
			
			driver.quit();
			
		}
	
	public String CsvDownload(String sysState,String osFamily,String reportSys) throws Exception
	{
		
		//HC_TRANSITION_IMT_Country_All_NA_IMI_External_ALL_SER_181010
		String FilePartialName1 = "HC_"+sysState+"_Overview_"+osFamily+ "_" +reportSys;
	
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
			String webColum = HC_NonProd_Overview_Web_Column[a]; 
			int csvColum =	Integer.parseInt(HC_NonProd_Overview_CSV_Column[a]);
			
				
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
				String webColum = HC_NonProd_Overview_Web_Column_Country[a]; 
				int csvColum =	Integer.parseInt(HC_NonProd_Overview_CSV_Column_Country[a]);
				
					
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
	
	public void compareColumnHeading (String fileName, String state,String nonprod,int custSize) throws Exception
	{
		File CSVHeadersFile;
		
		if(state.equalsIgnoreCase("TRANS"))
		{
			CSVHeadersFile = new File("CSV\\HcNonProdTrans.xls");			
		}
		else
		{
			CSVHeadersFile = new File("CSV\\HcNonProdDeploy.xls");
		}
		
		

		Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);
		
		for (int i = 0; i <= 17; i++) {
			
			
			
			System.out.println("****************** CSV Header********************************");
			System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 1).getContents());
			System.out.println("CSV File Name :" + getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));

			Assert.assertEquals(wb1.getSheet(0).getCell(i, 1).getContents().trim(),getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));
			//}
			
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
