package DataProvider;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import jxl.Workbook;
import Pages.HC_Customer_NonProd_Page;
import Utility.ScreenShot;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class HC_Customer_NonProd_GACDW extends ConfigReader {
	
	WebDriver driver ;
	static HC_Customer_NonProd_Page iot_imt ;
	static String csvfileName,csvfileName1;
	
	//@Test(priority=1)
	public void verify_DEPLOYMENT_ALL_ALL_NET() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_custtrans";

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
		
		iot_imt = PageFactory.initElements(driver, HC_Customer_NonProd_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		
		String IMT_Customer_Name = COUNTRY_NAME + " - " + COUNTRY_ID.toLowerCase() + "_" + CUSTOMER_NAME.toLowerCase();
		Select customer = new Select(iot_imt.getImtCustomer());
		customer.selectByVisibleText(IMT_Customer_Name);
		
		iot_imt.getNetworkDevices();
		
		iot_imt.getDeploymentState();
		
		iot_imt.getOsFamilyDistributed();
		
		//iot_imt.getDeploymentState();
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		iot_imt.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		iot_imt.getDownloadCSV();
		
		//HC_DEPLOYMENT_compl_customer_overvw_FRANCE_fr_top04_ALL_NET_190515(2)
		String csvfileName = CsvDownload("DEPLOYMENT","ALL","ALL","NET");
		iot_imt.getCompleteCSV();
		Thread.sleep(2000);
		CsvDownload_complete("DEPLOYMENT","ALL","NET");
		
		int rowsize = iot_imt.getRowSizeAll();	
		int custSize = iot_imt.getCustSize();
		
		String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[1]/tbody[1]/tr";
		String path2 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[2]/tbody[1]/tr";
		                
		
		compareColumnHeading(csvfileName,"DEPLOY",custSize);
		

		
		compareData("DEPLOY",csvfileName,rowsize,custSize,path,11,path2,7);
		
		compareComplCsvHeadings();
		compareData_Compl("DEPLOY",csvfileName1,rowsize,custSize,path,11,path2,5);
		
		driver.quit();
		
	}
	
	//@Test(priority=2)
	public void verify_TRANSITION_MF_ALL_STO() throws Exception
	{
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_custtrans";

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
		
		iot_imt = PageFactory.initElements(driver, HC_Customer_NonProd_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		
		String IMT_Customer_Name = COUNTRY_NAME + " - " + COUNTRY_ID.toLowerCase() + "_" + CUSTOMER_NAME.toLowerCase();
		Select customer = new Select(iot_imt.getImtCustomer());
		customer.selectByVisibleText(IMT_Customer_Name);
		
		//iot_imt.getSingleIOT();
		
		iot_imt.getTransitionState();
		
		iot_imt.getStorageDevices();
				
		//iot_imt.getMGMT_APP();;
		
		iot_imt.getOsFamilyMainframe();
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		iot_imt.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		iot_imt.getDownloadCSV();
		
		//HC_TRANSITION_APPLICATION_Customer_FRANCE_fr_fix08_ALL_DS_STO_190416
		String csvfileName = CsvDownload("TRANSITION","MF","ALL","STO");
		iot_imt.getCompleteCSV();
		Thread.sleep(2000);
		CsvDownload_complete("TRANSITION","MF","STO");
		
		int rowsize = iot_imt.getRowSizeImt();
		int custSize = iot_imt.getCustSize();
		
		String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[1]/tbody[1]/tr";
		String path2 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[2]/tbody[1]/tr";
			
		compareColumnHeading(csvfileName,"TRANS",custSize);
	
		compareData("TRANS",csvfileName,rowsize,custSize,path,15,path2,7);
		
		compareComplCsvHeadings();
		compareData_Compl("TRANS",csvfileName1,rowsize,custSize,path,11,path2,5);
		
		driver.quit();
		
	}
	
	//@Test(priority=3)
	public void verify_DEPLOYMENT_ALL_ALL_SER() throws Exception
	{
		
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_custtrans";

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
		
		iot_imt = PageFactory.initElements(driver, HC_Customer_NonProd_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		
		String IMT_Customer_Name = COUNTRY_NAME + " - " + COUNTRY_ID.toLowerCase() + "_" + CUSTOMER_NAME.toLowerCase();
		Select customer = new Select(iot_imt.getImtCustomer());
		customer.selectByVisibleText(IMT_Customer_Name);
		//iot_imt.getSector();
		
		//iot_imt.getSingleIOT_IMT_Country();
		
		iot_imt.getDeploymentState();
		
		iot_imt.getServer();
				
		//iot_imt.getFamily();
		
		//iot_imt.getMGMT_ALL();
		
		iot_imt.getOsFamilyAll();
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		iot_imt.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		iot_imt.getDownloadCSV();
		Thread.sleep(9000);
		
		
		//HC_DEPLOYMENT_APPLICATION_Customer_FRANCE_fr_fix08_ALL_ALL_ALL_190416
		String csvfileName = CsvDownload("DEPLOYMENT","ALL","ALL","SER");
		iot_imt.getCompleteCSV();
		Thread.sleep(2000);
		CsvDownload_complete("DEPLOYMENT","ALL","SER");
		
		
		int rowsize = iot_imt.getRowSizeImt();
		int custSize = iot_imt.getCustSize();
		String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[1]/tbody[1]/tr";
		String path2 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[2]/tbody[1]/tr";
		
		compareColumnHeading(csvfileName,"DEPLOY",custSize);
	
		compareData("DEPLOY",csvfileName,rowsize,custSize,path,11,path2,7);
		
		compareComplCsvHeadings();
		compareData_Compl("DEPLOY",csvfileName1,rowsize,custSize,path,11,path2,5);
		
		driver.quit();
		
	}
	
	@Test(priority=4)
	public void verify_TRANSITION_DS_ALL_ALL() throws Exception
	{

		
		String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=hc_custtrans";

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
		
		iot_imt = PageFactory.initElements(driver, HC_Customer_NonProd_Page.class);
		
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		
		String IMT_Customer_Name = COUNTRY_NAME + " - " + COUNTRY_ID.toLowerCase() + "_" + CUSTOMER_NAME.toLowerCase();

		// Selection of IMT_Customer
		Select customer = new Select(iot_imt.getImtCustomer());
		customer.selectByVisibleText(IMT_Customer_Name);
		
		//iot_imt.getSingleIOT_IMT();
		
		iot_imt.getTransitionState();
		
		iot_imt.getAllDevices();
				
		//iot_imt.getAccountType();
		
		iot_imt.getOsFamilyDistributed();
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		iot_imt.getGenerateButton();
		
		Thread.sleep(10000);
		ScreenShot.captureScreenshot(driver, "HC_Customer_NonProd_Page");
		iot_imt.getDownloadCSV();
		
		//HC_DEPLOYMENT_APPLICATION_Customer_FRANCE_fr_big03_ALL_DS_ALL_190415
		String csvfileName = CsvDownload("TRANSITION","DS","ALL","ALL");
		iot_imt.getCompleteCSV();
		Thread.sleep(2000);
		CsvDownload_complete("TRANSITION","DS","ALL");
		
		int rowsize = iot_imt.getRowSizeIOTAll();
		int custSize = iot_imt.getCustSizeAll();
		String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[1]/tbody[1]/tr";
		String path2 = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/table[2]/tbody[1]/tr";
		
		compareColumnHeading(csvfileName,"TRANS",custSize);
	
		compareData("TRANS",csvfileName,rowsize,custSize,path,15,path2,7);
		
		compareComplCsvHeadings();
		compareData_Compl("TRANS",csvfileName1,rowsize,custSize,path,11,path2,5);
		
		driver.quit();
		
	}
	
	public String CsvDownload(String sysstate,String accType,String osFamily,String reportSys) throws Exception
	{
		
		//HC_TRANSITION_Customer_CANADA_ca_top10_ALL_ALL_NET_190515
		String FilePartialName1 ;

		
			FilePartialName1 = "HC_"+ sysstate +"_Customer_"+ COUNTRY_NAME+"_"+COUNTRY_ID.toLowerCase()+ "_" + CUSTOMER_NAME.toLowerCase() + "_" + osFamily + "_" + accType + "_" + reportSys ;			
			
		String csvfileName = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "0");
		
		return csvfileName;
	}
	
	
	public String CsvDownload_complete(String sysstate,String osFamily,String reportSys) throws Exception
	{
		
	
	//	HC_DEPLOYMENT_compl_customer_overvw_FRANCE_fr_top04_ALL_NET_190515(2)
        String FilePartialName1 = "HC_"+sysstate+"_compl_customer_overvw"+"_"+COUNTRY_NAME+"_"+COUNTRY_ID.toLowerCase()+"_"+CUSTOMER_NAME.toLowerCase()+"_"+osFamily+"_"+reportSys;
		 csvfileName1 = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "1");
		
		return csvfileName1;
	}
	
	public void compareData(String sysState,String fileName,int rowsize,int custSize,String path,int columnSize,String path2,int columnSize2)
	{
		System.out.println("rows size:"+ rowsize);
		System.out.println("custSize:"+custSize);
		
		for (int a=0 ; a<columnSize;a++)
		{ 
			System.out.println("**************FOR 1*******************");
			String webColum = HC_Cust_NonProd_Web_Column[a]; 
			int csvColum =	Integer.parseInt(HC_Cust_NonProd_CSV_Column[a]);
			
				
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
				System.out.println(a+"**************FOR 1*******************");
				
				//1,4,6,7,8,10,12,13
				//if(HC_Cust_NonProd_TRANS_Web_Column_Country[a].equalsIgnoreCase("4")||HC_Cust_NonProd_TRANS_Web_Column_Country[a].equalsIgnoreCase("6")||HC_Cust_NonProd_TRANS_Web_Column_Country[a].equalsIgnoreCase("7")||HC_Cust_NonProd_TRANS_Web_Column_Country[a].equalsIgnoreCase("8")||HC_Cust_NonProd_TRANS_Web_Column_Country[a].equalsIgnoreCase("10")||HC_Cust_NonProd_TRANS_Web_Column_Country[a].equalsIgnoreCase("12")||HC_Cust_NonProd_TRANS_Web_Column_Country[a].equalsIgnoreCase("13")) {
				if(sysState.equals("TRANS")) {
				String webColum = HC_Cust_NonProd_TRANS_Web_Column_Country[a]; 
				int csvColum =	Integer.parseInt(HC_Cust_NonProd_TRANS_CSV_Column_Country[a]);
				
				for(int b=1 ; b<=custSize ;b++)
				{ 
					System.out.println(b+"**************FOR 2*******************");
					String xpath = path2 + "["+b+"]/td["+webColum+"]";
					
												
					System.out.println("**********Table2 Excution Started***************");
						System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName,b+2,csvColum , Local_Folder_HC,CSV_Separator) );

						Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b+2, csvColum, Local_Folder_HC,CSV_Separator).trim());
				
			}
				}
				
				else {
					String webColum = HC_Cust_NonProd_Web_Column_Country[a]; 
					int csvColum =	Integer.parseInt(HC_Cust_NonProd_CSV_Column_Country[a]);
					for(int b=1 ; b<=custSize ;b++)
					{ 
						System.out.println("**************FOR 2*******************");
						String xpath = path2 + "["+b+"]/td["+webColum+"]";
						
													
						System.out.println("**********Table2 Excution Started***************");
							System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName,b+2,csvColum , Local_Folder_HC,CSV_Separator) );

							Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b+2, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
							
					}
					}
			}
			
			
		}
	}
	
	
	public void compareData_Compl(String sysState,String fileName,int rowsize,int custSize,String path,int columnSize,String path2,int columnSize2)
	{
		System.out.println("rows size:"+ rowsize);
		System.out.println("custSize:"+custSize);
		
		for (int a=0 ; a<columnSize;a++)
		{ 
			System.out.println("**************FOR 1*******************");
			
			String webColum = HC_Cust_NonProd_Complt_Web_Column[a]; 
			int csvColum =	Integer.parseInt(HC_Cust_NonProd_Complt_CSV_Column[a]);
			
				
				for(int b=1 ; b<=rowsize ;b++)
				{ 
					System.out.println("**************FOR 2*******************");
					String xpath = path + "["+b+"]/td["+webColum+"]";
					
					System.out.println("**********Table 1 Excution Started***************");
					System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b,csvColum , Local_Folder_HC,CSV_Separator) );

				Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
				
				}
		}
		
		if(custSize != 0)
		{
			for (int a=0 ; a<columnSize2;a++)
			{ 
				System.out.println("**************FOR 1*******************");
				
				//1,4,6,7,8,10
				//if(HC_Cust_NonProd_TRANS_Complt_Web_Column_Country[a].equalsIgnoreCase("4")||HC_Cust_NonProd_TRANS_Complt_Web_Column_Country[a].equalsIgnoreCase("6")||HC_Cust_NonProd_TRANS_Complt_Web_Column_Country[a].equalsIgnoreCase("7")||HC_Cust_NonProd_TRANS_Complt_Web_Column_Country[a].equalsIgnoreCase("8")||HC_Cust_NonProd_TRANS_Complt_Web_Column_Country[a].equalsIgnoreCase("10")) {
				if(sysState.equals("TRANS")) {
				
				String webColum = HC_Cust_NonProd_TRANS_Complt_Web_Column_Country[a];  
				int csvColum =	Integer.parseInt(HC_Cust_NonProd_TRANS_Complt_CSV_Column_Country[a]);
				
					for(int b=1 ; b<=custSize ;b++)
					{ 
						System.out.println("**************FOR 2*******************");
						String xpath = path2 + "["+b+"]/td["+webColum+"]";
						
						
							System.out.println("**********Table2 Excution Started***************");
							System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b+3,csvColum , Local_Folder_HC,CSV_Separator) );

							Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b+3, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
					
					}
			}
				else {
					String webColum = HC_Cust_NonProd_Complt_Web_Column_Country[a];  
					int csvColum =	Integer.parseInt(HC_Cust_NonProd_Complt_CSV_Column_Country[a]);
					
						for(int b=1 ; b<=custSize ;b++)
						{ 
							System.out.println("**************FOR 2*******************");
							String xpath = path2 + "["+b+"]/td["+webColum+"]";
							
							
								System.out.println("**********Table2 Excution Started***************");
								System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b+3,csvColum , Local_Folder_HC,CSV_Separator) );

								Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b+3, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
						
						}
				}
			
			
			}
			
		}
	}
	
	
	public void compareColumnHeading (String fileName, String state,int custSize) throws Exception
	{
		File CSVHeadersFile;
		
		
			CSVHeadersFile = new File("CSV\\HC_Cust_NonProd.xls");			
		
		

		Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);
		
		for (int i = 0; i <= 27; i++) {
			
			
			if(getCellValueFromCSV(fileName, 0, 8, Local_Folder_HC, CSV_Separator).equalsIgnoreCase("Trans. Systems")) {
			System.out.println("****************** 1st CSV Header********************************");
			System.out.println(i+"==> work book value :" + wb1.getSheet(0).getCell(i, 1).getContents());
			System.out.println(i+"==> CSV File Name :" + getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));

			Assert.assertEquals(wb1.getSheet(0).getCell(i, 1).getContents().toLowerCase().trim(),getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator).toLowerCase());
			}
			
			else {
				System.out.println("****************** 1st CSV Header********************************");
				System.out.println(i+"==> work book value :" + wb1.getSheet(0).getCell(i, 5).getContents());
				System.out.println(i+"==> CSV File Name :" + getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator));

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 5).getContents().toLowerCase().trim(),getCellValueFromCSV(fileName, 0, i, Local_Folder_HC, CSV_Separator).toLowerCase());
			}
		}
			
		
		
		if(custSize != 0)
		{
			
			for (int i = 0; i <= 43; i++)
			{
				
				System.out.println("****************** 2nd  CSV Header ********************************");
				System.out.println(i+"==> work book value :" + wb1.getSheet(0).getCell(i, 3).getContents());
				System.out.println(i+"==> CSV File Name :" + getCellValueFromCSV(fileName, 2, i, Local_Folder_HC, CSV_Separator));

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 3).getContents().toLowerCase().trim(),getCellValueFromCSV(fileName, 2, i, Local_Folder_HC, CSV_Separator).toLowerCase());
									
			}	
			
		}
		
	}
	
	
	public void compareComplCsvHeadings() throws Exception
	{
		File CSVHeadersFile = new File("CSV\\HC_Cust_NonProd_Cmplt.xls");
		
		Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);

		
		for(int i=0 ; i <=21; i++)
		{
			if(getCellValueFromCSV(csvfileName1, 0, 8, Local_Folder_HC, CSV_Separator).equalsIgnoreCase("Trans. Systems")) {
				System.out.println("****************** 1st Complete CSV Header********************************");
				System.out.println(i+"==> work book value :" + wb1.getSheet(0).getCell(i, 1).getContents());
				System.out.println(i+"==> CSV File Name :" + getCellValueFromCSV(csvfileName1, 0, i, Local_Folder_HC, CSV_Separator));	

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 1).getContents().trim(),getCellValueFromCSV(csvfileName1, 0, i, Local_Folder_HC, CSV_Separator));
			}
			
			else {
				System.out.println("****************** 1st Complete CSV Header********************************");
				System.out.println(i+"==> work book value :" + wb1.getSheet(0).getCell(i, 5).getContents());
				System.out.println(i+"==> CSV File Name :" + getCellValueFromCSV(csvfileName1, 0, i, Local_Folder_HC, CSV_Separator));	

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 5).getContents().trim(),getCellValueFromCSV(csvfileName1, 0, i, Local_Folder_HC, CSV_Separator));
			}
		}
		
		
			
			for (int i = 0; i <= 47; i++)
			{
				
				System.out.println("****************** 2nd Complete CSV Header ********************************");
				System.out.println(i+"==> work book value :" + wb1.getSheet(0).getCell(i, 3).getContents());
				System.out.println(i+"==> CSV File Name :" + getCellValueFromCSV(csvfileName1, 3, i, Local_Folder_HC, CSV_Separator));

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 3).getContents().toLowerCase().trim(),getCellValueFromCSV(csvfileName1, 3, i, Local_Folder_HC, CSV_Separator).toLowerCase());
									
			
			
		}
	}
	
}