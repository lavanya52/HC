package WebVerification;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import DataProvider.ConfigReader;
import DataProvider.DataGenerator;
import DataProvider.DataUploader;

import DataProvider.HC_Customer;
import DataProvider.TemdGenGacdw;

import DataProvider.TemdUpload;


public class HC_Customer_GACDW extends ConfigReader {
	DataGenerator dg = new DataGenerator();
	DataUploader du = new DataUploader();
	HC_Customer verify = new HC_Customer();
	TemdUpload temdu=new TemdUpload();
	TemdGenGacdw temd=new TemdGenGacdw();
	
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
	
		dg.createGacdwReport();
		System.out.println("========Inventory file Created============");
	
		du.uploadGacdwReport(DataGenerator.getGACDWFilePath("GACDW"),DataGenerator.getGACDWFilePath("GACDW_APP"));
		System.out.println("========Inventory file uploaded===========");		
		
		du.executeGacdwScripts();
		System.out.println("========Inventory file executed===========");
		
	}
	
	@Test(priority = 2)
	public void temdScanLoad() throws Exception
	{
		temd.TemdViolGenerator();	
		System.out.println("temd scan generated");
		temd.temdCreator();
		temdu.uploadTemdReport(temd.getVIOLFileName(), temd.getMSGFileName());
		temdu.executeTemdScripts();
	}
	@Test(priority = 6)
	public void pageVerify() throws Exception
	{
	logger = extent.createTest("Web Page Verification");
	verify.verify_MF_SER();
	verify.verify_ALL_NET();
	verify.verify_DS_STO();
	verify.verify_ALL_ALL();
	}

}
