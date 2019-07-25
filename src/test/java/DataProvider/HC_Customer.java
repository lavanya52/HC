package DataProvider;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import Pages.HC_Customer_Page;
import Utility.ScreenShot;
import jxl.Workbook;
/**
 * @author LAVANYA
 *
 */
public class HC_Customer extends ConfigReader {
	
	WebDriver driver ;
	static HC_Customer_Page hc_cust ;
	static String csvfileName,csvfileName1;
	static String HCMatch;
	String IMT_Customer_Name = IMT_COUNTRY + " - " + COUNTRY_ID.toLowerCase() + "_" + CUSTOMER_NAME.toLowerCase();

	public void verify_MF_SER() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_cust";

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
		
		hc_cust = PageFactory.initElements(driver, HC_Customer_Page.class);
		ScreenShot.captureScreenshot(driver, "HC_Customer");
		// Selection of IMT_Customer
		Select customer = new Select(hc_cust.getImtCustomer());
		customer.selectByVisibleText(IMT_Customer_Name);
   		
        hc_cust.getServer();
		hc_cust.getOsFamilyMainframe();
		
		ScreenShot.captureScreenshot(driver, "HC_Customer");
		hc_cust.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "HC_Customer");
		hc_cust.getDownloadCSV();
		 CsvDownload_complete("MF","SER");
		Thread.sleep(3000);
		
	   hc_cust.getCompleteCSV();
       CsvDownload_Summary("MF","SER");
	compareCsvHeadings_Compl();
			Thread.sleep(1000);
			System.out.println("==================================================");
			 System.out.println("************************** second CSV Headding comparision starts **********************");
	compareCsvHeadings_Summary();
		Thread.sleep(1000);
			
			int rowsize = hc_cust.getRowSizeAll();	
			int custSize =hc_cust.getCustSizeAll();
			String path = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[1]/tbody[1]/tr";
			String path2 = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[2]/tbody[1]/tr";
          compareData_Compl(csvfileName,rowsize,custSize,path,12,path2,7);
	        compareData_Summary(csvfileName1,rowsize,custSize,path,7,path2,11);
			
			driver.close();
			
		}
	public void verify_ALL_NET() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_cust";

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
		
		hc_cust = PageFactory.initElements(driver, HC_Customer_Page.class);
		
		
		ScreenShot.captureScreenshot(driver, "HC_Customer");
		// Selection of IMT_Customer
		Select customer = new Select(hc_cust.getImtCustomer());
		customer.selectByVisibleText(IMT_Customer_Name);
     
        hc_cust.getNetworkDevices();
        
        ScreenShot.captureScreenshot(driver, "HC_Customer");
        hc_cust.getGenerateButton();
        ScreenShot.captureScreenshot(driver, "HC_Customer");
         hc_cust.getDownloadCSV();
         CsvDownload_complete("ALL","NET");
     	Thread.sleep(1000);
     	hc_cust.getCompleteCSV();
     	CsvDownload_Summary("ALL","NET");
        compareCsvHeadings_Compl();
		Thread.sleep(1000);
		System.out.println("==================================================");
		 System.out.println("************************* second CSV Headding comparision starts **********************");
		 compareCsvHeadings_Summary();
     Thread.sleep(1000);
 	int rowsize = hc_cust.getRowSizeAll();	
	int custSize =hc_cust.getCustSizeAll();
	String path = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[1]/tbody[1]/tr";
	String path2 = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[2]/tbody[1]/tr";
   compareData_Compl(csvfileName,rowsize,custSize,path,12,path2,7);
    compareData_Summary(csvfileName1,rowsize,custSize,path,7,path2,11);
	
		driver.quit();
		
	}
	public void verify_DS_STO() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_cust";

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
		
		hc_cust = PageFactory.initElements(driver, HC_Customer_Page.class);
        ScreenShot.captureScreenshot(driver, "HC_Customer");
		// Selection of IMT_Customer
		Select customer = new Select(hc_cust.getImtCustomer());
		customer.selectByVisibleText(IMT_Customer_Name);
         hc_cust.getStorageDevices();
         hc_cust.getOsFamilyDistributed();
	   
         ScreenShot.captureScreenshot(driver, "HC_Customer");
       hc_cust.getGenerateButton();
       ScreenShot.captureScreenshot(driver, "HC_Customer");
	   hc_cust.getDownloadCSV();

	   CsvDownload_complete("DS","STO");
		
		Thread.sleep(10000);
		hc_cust.getCompleteCSV();
	
		CsvDownload_Summary("DS","STO");
		
		compareCsvHeadings_Compl();
		 Thread.sleep(1000);
		 System.out.println("==================================================");
		 System.out.println("******************************* second CSV Headding comparision starts **********************");

		 compareCsvHeadings_Summary();
	 Thread.sleep(1000);
		int rowsize = hc_cust.getRowSizeAll();	
		int custSize =hc_cust.getCustSizeAll();
		String path = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[1]/tbody[1]/tr";
		String path2 = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[2]/tbody[1]/tr";
       compareData_Compl(csvfileName,rowsize,custSize,path,12,path2,7);
        compareData_Summary(csvfileName1,rowsize,custSize,path,7,path2,11);
		
	
		driver.close();

		
	}
	public void verify_ALL_ALL() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_cust";

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
		
		hc_cust = PageFactory.initElements(driver, HC_Customer_Page.class);
		ScreenShot.captureScreenshot(driver, "HC_Customer");
		// Selection of IMT_Customer
		Select customer = new Select(hc_cust.getImtCustomer());
		customer.selectByVisibleText(IMT_Customer_Name);
         hc_cust.getAllDevices();
	   
         ScreenShot.captureScreenshot(driver, "HC_Customer");
       hc_cust.getGenerateButton();
       ScreenShot.captureScreenshot(driver, "HC_Customer");
	   hc_cust.getDownloadCSV();

	   CsvDownload_complete("ALL","ALL");
		
		Thread.sleep(10000);
		hc_cust.getCompleteCSV();
	
		CsvDownload_Summary("ALL","ALL");
		
		compareCsvHeadings_Compl();
		 Thread.sleep(1000);
		 System.out.println("==================================================");
		 System.out.println("************************* second CSV Headding comparision starts **********************");
		 compareCsvHeadings_Summary();
	    Thread.sleep(1000);
		int rowsize = hc_cust.getRowSizeAll();	
		int custSize =hc_cust.getCustSizeAll();
		String path = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[1]/tbody[1]/tr";
		String path2 = "//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[2]/tbody[1]/tr";
    //   compareData_Compl(csvfileName,rowsize,custSize,path,12,path2,7);
        compareData_Summary(csvfileName1,rowsize,custSize,path,7,path2,11);
		
		
	
		driver.close();

		
	}
	public String CsvDownload_complete(String osFamily,String reportSys) throws Exception
	{
		
		
	//  HC_compl_customer_overvw_FRANCE_fr_custo1_MF_SER_190515 (3)
        String FilePartialName1 = "HC_compl_customer_overvw_"+IMT_COUNTRY+"_"+COUNTRY_ID.toLowerCase()+"_"+CUSTOMER_NAME+"_"+osFamily+"_"+reportSys;
		 csvfileName = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "0");
		
		return csvfileName;
	}
	public String CsvDownload_Summary(String osFamily,String reportSys) throws Exception
	{
		
	
	//HC_summary_customer_overvw_FRANCE_fr_custo1_ALL_MF_SER_190515
        String FilePartialName1 = "HC_summary_customer_overvw_"+IMT_COUNTRY+"_"+COUNTRY_ID.toLowerCase()+"_"+CUSTOMER_NAME+"_"+"ALL"+"_"+osFamily+"_"+reportSys;
		 csvfileName1 = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "1");
		
		return csvfileName1;
	}
	
	
	public void compareData_Compl(String fileName,int rowsize,int custSize,String path,int columnSize,String path2,int columnSize2)
	{
		System.out.println("rows size:"+ rowsize);
		System.out.println("custSize:"+custSize);
		
		for (int a=0 ; a<columnSize;a++)
		{ 
			System.out.println("**************FOR 1*******************");
			String webColum = Web_Column_Country_HCO_Cust[a]; 
			int csvColum =	Integer.parseInt(CSV_Column_Country_HCO_Cust[a]);
			
				
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
				String webColum = Web_Column_HCO_Cust[a];  
				int csvColum =	Integer.parseInt(CSV_Column_HC_Cust[a]);
				
					
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
	
	public void compareData_Summary(String fileName,int rowsize,int custSize,String path,int columnSize,String path2,int columnSize2)
	{
		System.out.println("rows size:"+ rowsize);
		System.out.println("custSize:"+custSize);
		
		for (int a=0 ; a<columnSize;a++)
		{ 
			System.out.println("**************FOR 1*******************");
			String webColum = Web_Column_Country_HCO_Cust[a]; 
			int csvColum =	Integer.parseInt(CSV_Column_Country_HCO_Cust[a]);
			
				
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
				String webColum = Web_Column_HCO_Cust_SUM[a];  
				int csvColum =	Integer.parseInt(CSV_Column_HCO_Cust_SUM[a]);
				
					
					for(int b=1 ; b<=custSize ;b++)
					{ 
						System.out.println("**************FOR 2*******************");
						String xpath = path2 + "["+b+"]/td["+webColum+"]";

							System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b+2,csvColum , Local_Folder_HC,CSV_Separator) );

							Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b+2, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
							
						
						
						
					
					}
			}
			
			
		}
	}

	public void compareCsvHeadings_Compl() throws Exception
	{
		File CSVHeadersFile = new File("CSV\\HCCUST.xls");
		
		Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);

		
		for(int i=0 ; i <22 ; i++)
		{
			
				System.out.println("****************** CSV Header********************************");
				System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 0).getContents());
				System.out.println("CSV File Name :" + getCellValueFromCSV(csvfileName, 0, i, Local_Folder_HC, CSV_Separator));	

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 0).getContents().trim(),getCellValueFromCSV(csvfileName, 0, i, Local_Folder_HC, CSV_Separator));
			
		}
		
		for(int i=0; i<52 ;i++)
		{
			
				System.out.println("****************** CSV Header********************************");
				System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 3).getContents());
				System.out.println("CSV File Name :" + getCellValueFromCSV(csvfileName, 3, i, Local_Folder_HC, CSV_Separator));	

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 3).getContents().trim(),getCellValueFromCSV(csvfileName, 3, i, Local_Folder_HC, CSV_Separator));
			
		}
	}
	public void compareCsvHeadings_Summary() throws Exception
	{
		File CSVHeadersFile = new File("CSV\\HCSumCust.xls");
		
		Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);

		
		for(int i=0 ; i <24; i++)
		{
			
				System.out.println("****************** CSV Header********************************");
				System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 0).getContents());
				System.out.println("CSV File Name :" + getCellValueFromCSV(csvfileName1, 0, i, Local_Folder_HC, CSV_Separator));	

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 0).getContents().trim(),getCellValueFromCSV(csvfileName1, 0, i, Local_Folder_HC, CSV_Separator));
			
		}
		
		for(int i=0; i<46 ;i++)
		{
			
				System.out.println("****************** CSV Header********************************");
				System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 2).getContents());
				System.out.println("CSV File Name :" + getCellValueFromCSV(csvfileName1, 2, i, Local_Folder_HC, CSV_Separator));	

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 2).getContents().trim(),getCellValueFromCSV(csvfileName1, 2, i, Local_Folder_HC, CSV_Separator));
			
		}
	}
	
	


}
