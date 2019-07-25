package WebVerification;
/**
 * 
 */

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import DataProvider.DataGenerator;
import DataProvider.DataUploader;
import DataProvider.HC_NonProd_Overview_Verify;
//import DataProvider.HC_NonProd_Verify;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class HC_NonProd_GACDW  {
	
	DataGenerator dg = new DataGenerator();
	DataUploader du = new DataUploader();
	HC_NonProd_Overview_Verify verify = new HC_NonProd_Overview_Verify();
	
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	ExtentTest logger2;
	
	@BeforeMethod
	public void extentReport() {

		reporter = new ExtentHtmlReporter("./OutPut/IMI.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);

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
	
	@Test(priority =5)
	public void pageVerify() throws Exception
	{
		logger = extent.createTest("Web Page Verification");
		
		verify.verify_TRANSITION_MF_SER();
		verify.verify_TRANSITION_ALL_NET();
		verify.verify_DEPLOYMENT_DS_STO();
		verify.verify_DEPLOYMENT_MF_SST();
		verify.verify_TRANSITION_DS_ALL();
		
		extent.flush();
		
	}

}
