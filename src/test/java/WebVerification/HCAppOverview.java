package WebVerification;
/**
 * 
 */

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import DataProvider.ConfigReader;
import DataProvider.DataGenerator;
import DataProvider.DataUploader;
import DataProvider.HCAppOverview_verify;


/**
 * @author Nive
 *
 */
public class HCAppOverview extends ConfigReader {
	
	DataGenerator dg = new DataGenerator();
	DataUploader du = new DataUploader();
	HCAppOverview_verify verify = new HCAppOverview_verify();
	
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	ExtentTest logger2;
	
	@BeforeMethod
	public void extentReport() {

		reporter = new ExtentHtmlReporter("./OutPut/HCAppOverview.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);

	}
	@Test(priority=0)
	public void cleanLocalFolder()
	{
		cleanLocalFolder(Local_Folder_HC);
	}
	@Test(priority=1)
	public void generate() throws Exception
	{
		System.out.println("====Inside DataGenerator====");
		dg.generateGacdwReports();
		System.out.println("========Invnetory Data Created============");
	}
	
	@Test(priority= 2)
	public void create()
	{
		dg.createGacdwReport();
		System.out.println("========Inventory file Created============");
	}
	
	@Test(priority = 3)
	public void upload()
	{
		du.uploadGacdwReport(DataGenerator.getGACDWFilePath("GACDW"),DataGenerator.getGACDWFilePath("GACDW_APP"));
		System.out.println("========Inventory file uploaded===========");		
		
	}
	
	@Test(priority = 4)
	public void execute()
	{
		du.executeGacdwScripts();
		System.out.println("========Inventory file executed===========");
		
	}
	
	@Test(priority = 5)
	public void pageVerify() throws Exception
	{
		logger = extent.createTest("Web Page Verification");
		
		verify.verify_All_ReportedSystem();
		verify.verify_All_Device_Except_Network();
		verify.verify_HCAppOvw_Servers();
		verify.verify_Network_Devices();
		verify.verify_Storage_Devices();
		
		extent.flush();
		
	}

}
