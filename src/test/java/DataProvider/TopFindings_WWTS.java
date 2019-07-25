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
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.TopFindings_Message_Page;
//import Pages.IDCOMP_Customer_Page;
import Pages.TopFindings_Page;
import jxl.Workbook;
/**
 * @author LAVANYA
 *
 */

public class TopFindings_WWTS extends ConfigReader{
	WebDriver driver ;
	private Date dateID = new Date();
	static String csvfileName,csvfileName1;
	static int ecmRowNo;
	FirefoxProfile profile = new FirefoxProfile();
	//@Test(priority=1)
	public void check_ALL_ALL_ALL() throws Exception
	{
	
	String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=topfindingscustomer";

	System.out.println(URL);
	FirefoxProfile profile = new FirefoxProfile();

	// Set Location to store files after downloading.
	profile.setPreference("browser.download.dir", Local_Folder_HC);
	//profile.setPreference("browser.download.dir", Local_Folder_HC);
	
	profile.setPreference("browser.download.folderList", 2);

	// Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
	profile.setPreference("browser.helperApps.neverAsk.saveToDisk",	"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");

	profile.setPreference("browser.download.manager.showWhenStarting", false);
	profile.setPreference("pdfjs.disabled", true);

	// Pass FProfile parameter In webdriver to use preferences to download file.
	driver = new FirefoxDriver(profile);
	driver.get(URL);
	driver.manage().window().maximize();
	
	TopFindings_Page custPage = PageFactory.initElements(driver, TopFindings_Page.class);
	
	String IMT_Customer_Name = IMT_COUNTRY + " - " + COUNTRY_ID.toLowerCase() + "_" + CUSTOMER_NAME.toLowerCase();

	// Selection of IMT_Customer
	Select customer = new Select(custPage.getImtCustomer());
	customer.selectByVisibleText(IMT_Customer_Name);
	custPage.getWWTS();
	custPage.getAllSystemState();
	custPage.getAllDevices();

	JavascriptExecutor Je = (JavascriptExecutor) driver;
	Je.executeScript("arguments[0].click();", custPage.getGenerateReportButton());
	Thread.sleep(10000);
	Assert.assertEquals(custPage.getCheckExp().getText().trim(),"Check expected value");
	Reporter.log("check expected value is verified", true);
	
	
	Assert.assertEquals(custPage.getChekID().getText().trim(),"Check ID");
	Reporter.log("Check id is verified", true);
	
	custPage.getDownloadCSV();

	CsvDownload("ALL","ALL","ALL");
	//compareHeadings();
	Thread.sleep(1000);
	compareData();
	/*int rowsize = custPage.getRowSizeAll();
	String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr";
	//compareData(csvfileName,rowsize,path,2);
*/	
	
	Thread.sleep(1000);

	TopFindings_Message_Page custPage1 = PageFactory.initElements(driver, TopFindings_Message_Page.class);
	custPage1.getSystems();
	String currentWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	for(String window : allWindowHandles) {
		if(!window.equals(currentWindowHandle)) {
			driver.switchTo().window(window);
		}
	}
	Thread.sleep(10000);
	custPage1.getDownloadCSVSystems();

	Thread.sleep(1000);
	CsvDownload_Systems();
	//compareHeadings_Systems();
	Thread.sleep(1000);
	int rowsize_sys = custPage1.getRowSizeAll_sys();
	int custSize_sys =custPage1.getCustSizeAll_sys();
	String path_sys = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr";
	String path2_sys = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[2]/tbody[1]/tr";
    compareDataSystems(csvfileName1,rowsize_sys,custSize_sys,path_sys,2,path2_sys,5);
	
    cleanLocalFolder(Local_Folder_HC);
	
	driver.quit();
	
	}
	public String CsvDownload_Systems() throws Exception
	{
      //HC_topfindings_customer_message_O_FRANCE_fr_te04_5744_all_TEM_All_ALL_ALL_190506 (2)
		String FilePartialName2 = "HC_topfindings_customer_message_O_"+ IMT_COUNTRY.toUpperCase() + "_" + COUNTRY_ID.toLowerCase() +"_" + CUSTOMER_NAME.toLowerCase();
	
		//csvfileName = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "0");
		csvfileName1 = downloadCSV(driver, FilePartialName2, Local_Folder_HC, "1");
		
		return csvfileName1;
	}
	
	
	
	//@Test(priority=2)
	public void check_PRODUCTIVE_SER_DS() throws Exception
	{
	
	String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=topfindingscustomer";

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
	
	TopFindings_Page custPage = PageFactory.initElements(driver, TopFindings_Page.class);
	
	String IMT_Customer_Name = IMT_COUNTRY + " - " + COUNTRY_ID.toLowerCase() + "_" + CUSTOMER_NAME.toLowerCase();

	// Selection of IMT_Customer
	Select customer = new Select(custPage.getImtCustomer());
	customer.selectByVisibleText(IMT_Customer_Name);
	custPage.getWWTS();
	//custPage.getAllSystemState();
	custPage.getServer();
	custPage.getDistributed();
	JavascriptExecutor Je = (JavascriptExecutor) driver;
	Je.executeScript("arguments[0].click();", custPage.getGenerateReportButton());
	Thread.sleep(10000);
	Assert.assertEquals(custPage.getCheckExp().getText().trim(),"Check expected value");
	Reporter.log("check expected value is verified", true);
	
	
	Assert.assertEquals(custPage.getChekID().getText().trim(),"Check ID");
	Reporter.log("Check id is verified", true);
	
	custPage.getDownloadCSV();
	
	CsvDownload("DS","SER","PRODUCTION");
//	compareHeadings();
	Thread.sleep(1000);
	compareData();
	/*int rowsize = custPage.getRowSizeAll();
	String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr";
//	compareData(csvfileName,rowsize,path,2);
*/	
	Thread.sleep(1000);
	TopFindings_Message_Page custPage1 = PageFactory.initElements(driver, TopFindings_Message_Page.class);
	custPage1.getSystems();
	String currentWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	for(String window : allWindowHandles) {
		if(!window.equals(currentWindowHandle)) {
			driver.switchTo().window(window);
		}
	}
	Thread.sleep(10000);
	custPage1.getDownloadCSVSystems();

	Thread.sleep(1000);
	CsvDownload_Systems();
	//compareHeadings_Systems();
	Thread.sleep(1000);
	int rowsize_sys = custPage1.getRowSizeAll_sys();
	int custSize_sys =custPage1.getCustSizeAll_sys();
	String path_sys = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr";
	String path2_sys = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[2]/tbody[1]/tr";
    compareDataSystems(csvfileName1,rowsize_sys,custSize_sys,path_sys,2,path2_sys,5);
	
    cleanLocalFolder(Local_Folder_HC);
	
	driver.close();
	
	
	}
	//@Test(priority=3)
	public void check_DEPLOYMENT_STO_MF() throws Exception
	{
	
	String URL = "https://" + Web_Login + ":" + Web_Password + "@" + IP_ADDRESS + "/hc.php?hc=topfindingscustomer";

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
	
	TopFindings_Page custPage = PageFactory.initElements(driver, TopFindings_Page.class);
	
	String IMT_Customer_Name = IMT_COUNTRY + " - " + COUNTRY_ID.toLowerCase() + "_" + CUSTOMER_NAME.toLowerCase();

	// Selection of IMT_Customer
	Select customer = new Select(custPage.getImtCustomer());
	customer.selectByVisibleText(IMT_Customer_Name);
	custPage.getWWTS();
	custPage.getDeployment();
	custPage.getStorage();
	custPage.getMainframe();
	JavascriptExecutor Je = (JavascriptExecutor) driver;
	Je.executeScript("arguments[0].click();", custPage.getGenerateReportButton());
	Thread.sleep(10000);
	Assert.assertEquals(custPage.getCheckExp().getText().trim(),"Check expected value");
	Reporter.log("check expected value is verified", true);
	
	
	Assert.assertEquals(custPage.getChekID().getText().trim(),"Check ID");
	Reporter.log("Check id is verified", true);
	
	custPage.getDownloadCSV();
	
	CsvDownload("MF","STO","DEPLOYMENT");
//	compareHeadings();
	Thread.sleep(2000);
	compareData();
	/*int rowsize = custPage.getRowSizeAll();
	String path = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr";
	//compareData(csvfileName,rowsize,path,2);
	//Thread.sleep(1000);
*/	
	TopFindings_Message_Page custPage1 = PageFactory.initElements(driver, TopFindings_Message_Page.class);
	custPage1.getSystems();
	String currentWindowHandle = driver.getWindowHandle();
	Set<String> allWindowHandles = driver.getWindowHandles();
	for(String window : allWindowHandles) {
		if(!window.equals(currentWindowHandle)) {
			driver.switchTo().window(window);
		}
	}
	Thread.sleep(10000);
	custPage1.getDownloadCSVSystems();

	Thread.sleep(1000);
	CsvDownload_Systems();
//	compareHeadings_Systems();
	Thread.sleep(1000);
	int rowsize_sys = custPage1.getRowSizeAll_sys();
	int custSize_sys =custPage1.getCustSizeAll_sys();
	String path_sys = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr";
	String path2_sys = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[2]/tbody[1]/tr";
    compareDataSystems(csvfileName1,rowsize_sys,custSize_sys,path_sys,2,path2_sys,5);
	
    cleanLocalFolder(Local_Folder_HC);
	driver.close();
	

	}
	public String CsvDownload(String osFamily,String reportSys,String SystemState) throws Exception
	{
	//HC_topfindings_customer_overvw_FRANCE_fr_gro12_all_WWTS_ALL_ALL_ALL_190502	
	//HC_topfindings_customer_overvw_FRANCE_fr_gro12_all_WWTS_ALL_DS_ALL_190502
	//HC_topfindings_customer_overvw_FRANCE_fr_gro12_all_WWTS_ALL_DS_SER_190502
	//HC_topfindings_customer_overvw_FRANCE_fr_gro12_all_WWTS_PRODUCTION_DS_SER_190504
		
		String FilePartialName1 = "HC_topfindings_customer_overvw_"+ IMT_COUNTRY.toUpperCase() + "_" + COUNTRY_ID.toLowerCase() +"_" + CUSTOMER_NAME.toLowerCase() + "_all_"+Scan_Type_WWTS+"_" +SystemState+"_"+osFamily+"_"+reportSys ;

		
		csvfileName = downloadCSV(driver, FilePartialName1, Local_Folder_HC, "0");
		
		return csvfileName;
	}
	public void compareHeadings_Systems() throws Exception
	{
		File CSVHeadersFile = new File("CSV\\TopFindings.xls");
		
		Workbook wb1 = Workbook.getWorkbook(CSVHeadersFile);
		
	
		
		for(int i=0 ; i <=24 ; i++)
		{
			
				System.out.println("****************** CSV Header********************************");
				System.out.println("work book value :" + wb1.getSheet(0).getCell(i, 0).getContents());
				System.out.println("CSV File Name :" + getCellValueFromCSV(csvfileName1, 0, i, Local_Folder_HC, CSV_Separator));	

				Assert.assertEquals(wb1.getSheet(0).getCell(i, 0).getContents().trim(),getCellValueFromCSV(csvfileName1, 0, i, Local_Folder_HC, CSV_Separator).trim());
			
			
		}
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
	
	

		public void compareDataSystems(String fileName,int rowsize_sys,int custSize_sys,String path_sys,int columnSize1,String path2_sys,int columnSize2)
		{
			System.out.println("rows size:"+ rowsize_sys);
			System.out.println("custSize:"+custSize_sys);
			
			for (int a=0 ; a<columnSize1;a++)
			{ 
				System.out.println("**************FOR 1*******************");
				String webColum = Web_Column_HCTop_Table1[a]; 
				int csvColum =	Integer.parseInt(CSV_Column_HCTop_Table1[a]);
				
					
					for(int b=1 ; b<=rowsize_sys ;b++)
					{ 
						System.out.println("**************FOR 2*******************");
						String xpath = path_sys + "["+b+"]/td["+webColum+"]";
						
						System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b,csvColum , Local_Folder_HC,CSV_Separator) );

					Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
					
					}
			}
			
			if(custSize_sys != 0)
			{
				for (int a=0 ; a<columnSize2;a++)
				{ 
					System.out.println("**************FOR 1*******************");
					String webColum = Web_Column_HCTop_Table2[a];  
					int csvColum =	Integer.parseInt(CSV_Column_HCTop_Table2[a]);
					
						
						for(int b=1 ; b<=custSize_sys ;b++)
						{ 
							System.out.println("**************FOR 2*******************");
							String xpath = path2_sys + "["+b+"]/td["+webColum+"]";
		
								System.out.println("web: csv "+ driver.findElement(By.xpath(xpath)).getText() + ":" + getCellValueFromCSV(fileName, b,csvColum , Local_Folder_HC,CSV_Separator) );

								Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText().trim(),getCellValueFromCSV(fileName, b, csvColum, Local_Folder_HC,CSV_Separator).trim()); 
								
							
							
							
						
						}
				}
				
				
			}
		}
		
				
	public void compareData()
	{
		
			String ecmFilePath = Local_Folder_HC + "\\" + csvfileName ;
			
			List<String> ecmRows = getRowsFromCSV(ecmFilePath , 1);
				
				WebElement ele1=driver.findElement(By.xpath("//*[@id='ibm-content-main']/div[4]/div/table/tbody/tr[1]/td[3]"));
				
				for (int j=1 ; j<=ecmRows.size(); j++)
				{
					
					if (ele1.getText().equalsIgnoreCase((getCellValueFromCSV(csvfileName, j, 20, Local_Folder_HC, CSV_Separator))))
							{
						System.out.println("Inside ECM for : " + getCellValueFromCSV(csvfileName, j, 20, Local_Folder_HC, CSV_Separator));
								System.out.println(" Inside ecm row num "+j);
								ecmRowNo = j ;
								break;
							}
				}
				
				
				WebElement ele2=driver.findElement(By.xpath("//*[@id='ibm-content-main']/div[4]/div/table/tbody/tr[1]/td[4]"));
				for (int j=1 ; j<=ecmRows.size(); j++)
				{
					
					if (ele2.getText().equalsIgnoreCase((getCellValueFromCSV(csvfileName, j, 21, Local_Folder_HC, CSV_Separator))))
							{
						System.out.println("Inside ECM for : " + getCellValueFromCSV(csvfileName, j, 21, Local_Folder_HC, CSV_Separator));
								System.out.println(" Inside ecm row num "+j);
								ecmRowNo = j ;
								break;
							}
				}
		}

	
			}
		
			
		
	


