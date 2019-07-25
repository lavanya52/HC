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

import Pages.HCApp_NonProd_Overview_Page;
import Pages.HC_NonProd_Overview_Page;
import Utility.ScreenShot;
import jxl.Workbook;

/**
 * @author Rajashekar
 *
 */
public class HC_APP_Overview_NonProduction extends ConfigReader {
	
	WebDriver driver ;
	static HCApp_NonProd_Overview_Page hc_nonprod ;
	
	@Test(priority=1)
	public void verify_TRANSITION_MF_SER() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcapplicationovwtrans";

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
		
		hc_nonprod = PageFactory.initElements(driver, HCApp_NonProd_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Page");
		
		//hc_nonprod.getSector();
		
		//hc_nonprod.getAllIMT();
		
		hc_nonprod.getTransitionState();
		
		hc_nonprod.getServer();
				
		//hc_nonprod.getAccountType();
		
		hc_nonprod.getOsFamilyMainframe();
		
		//hc_nonprod.getOsFamilyDistributed();
		
		hc_nonprod.getGenerateButton();
		
		Thread.sleep(10000);
		
		hc_nonprod.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("TRANSITION","MF","SER");
		
		int rowsize = hc_nonprod.getRowSizeAll();	
		int custSize = 0;
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,"TRANS","IMT",custSize);
		

		
		compareData(csvfileName,rowsize,custSize,path,12,path2,19);
		
		driver.quit();
		
	}
	
	@Test(priority=2)
	public void verify_TRANSITION_ALL_NET() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcapplicationovwtrans";

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
		
		hc_nonprod = PageFactory.initElements(driver, HCApp_NonProd_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Page");
		
		
		
		hc_nonprod.getDeploymentState();
		
		hc_nonprod.getAllExceptNetwork();
				
		hc_nonprod.getOsFamilyMainframe();
		
		hc_nonprod.getOsAppFamily();
		
		hc_nonprod.getGenerateButton();
		
		Thread.sleep(10000);
		
		hc_nonprod.getDownloadCSV();
		
		
		String csvfileName = CsvDownload("DEPLOYMENT","MF","SST");
		
		int rowsize = hc_nonprod.getRowSizeImt();
		int custSize = 0;
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
			
		compareColumnHeading(csvfileName,"TRANS","IMT",custSize);
	
		compareData(csvfileName,rowsize,custSize,path,12,path2,19);
		
		driver.quit();
		
	}
	
	@Test(priority=3)
	public void verify_DEPLOYMENT_DS_STO() throws Exception
	{
		
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hcapplicationovwtrans";

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
		
		hc_nonprod = PageFactory.initElements(driver, HCApp_NonProd_Overview_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_NonProd_Page");
		
		
		
		hc_nonprod.getTransitionState();
		
		hc_nonprod.getStorageDevices();
				
		hc_nonprod.getOsAppFamily();
		
		hc_nonprod.getOsFamilyDistributed();
		
		hc_nonprod.getGenerateButton();
		
		Thread.sleep(10000);
		
		hc_nonprod.getDownloadCSV();
		
		//HC_DEPLOYMENT_IMT_Country_UNITED_STATES_UNITED_STATES_NA_IMI_All_ALL_ALL_181012
		String csvfileName = CsvDownload("TRANSITION","DS","STO");
		
		int rowsize = hc_nonprod.getRowSizeImt();
		int custSize = 0;
		//int custSize = hc_nonprod.getCustSize();
		String path = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr";
		String path2 = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr";
		
		compareColumnHeading(csvfileName,"DEPLOY","IMT",custSize);
	
		compareData(csvfileName,rowsize,custSize,path,12,path2,15);
		
		driver.quit();
		
	}
	
	
	public String CsvDownload(String sysState,String osFamily,String reportSys) throws Exception
	{
		
		//HC_TRANSITION_IMT_Country_All_NA_IMI_External_ALL_SER_181010
		String FilePartialName1 = "HC_"+sysState+"_APPLICATION_overview_"+osFamily+ "_" +reportSys;
	
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
			String webColum = HCAPP_NonProd_Overview_Web_Column[a]; 
			int csvColum =	Integer.parseInt(HCAPP_NonProd_Overview_CSV_Column[a]);
			
				
				for(int b=1 ; b<=rowsize ;b++)
				{ 
					System.out.println("**************FOR 2*******************");
					String xpath = path + "["+b+"]/td["+webColum+"]";
					
					//if(a==1) {
						System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b,csvColum , Local_Folder_HC,CSV_Separator).trim());

						Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText(),getCellValueFromCSV(fileName, b, csvColum, Local_Folder_HC,CSV_Separator).trim()); 

					//}
					
					/*else {
					System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b,csvColum , Local_Folder_IMI,CSV_Separator) );

				Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b, csvColum, Local_Folder_IMI,CSV_Separator).trim()); 
				
					}*/
				}
		}
		
			}
	
	public void compareColumnHeading (String fileName, String state,String nonprod,int custSize) throws Exception
	{
		File CSVHeadersFile;
		
		if(state.equalsIgnoreCase("TRANS"))
		{
			CSVHeadersFile = new File("CSV\\HcAPPNonProdTrans.xls");			
		}
		else
		{
			CSVHeadersFile = new File("CSV\\HcAPPNonProdDeploy.xls");
		}
		
		

		Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);
		
		for (int i = 0; i <= 29; i++) {
			
			if (i==1)
			{
				if (nonprod.equalsIgnoreCase("IMT"))
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
			//}
			
		}
		
		}}	

}
