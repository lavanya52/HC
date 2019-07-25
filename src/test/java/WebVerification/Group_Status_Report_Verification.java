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
import DataProvider.GroupGenerator;
import DataProvider.GroupStatusReport;
import DataProvider.ManualLoading;
import DataProvider.WWTSGenerator;

public class Group_Status_Report_Verification extends ConfigReader {
	
	DataGenerator dg = new DataGenerator();
	DataUploader du = new DataUploader();
	WWTSGenerator wwts = new WWTSGenerator();
	GroupGenerator gg = new GroupGenerator();
	ManualLoading ml=new ManualLoading();
	GroupStatusReport gs=new GroupStatusReport();
	
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	ExtentTest logger2;
	
	@BeforeMethod
	public void extentReport() {

		reporter = new ExtentHtmlReporter("./OutPut/HCTransApp.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@Test(priority=0)
	public void cleanLocalFolder()
	{
		cleanLocalFolder(Local_Folder_HC);
	}
	/*@Test(priority=1)
	public void cleanLocalFolder_Group()
	{
		cleanLocalFolder(Local_Folder_Group);
	}*/
	
	
	
	@Test(priority=2)
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
	
	@Test(priority = 3)
	public void wwtsGenerate()
	{
		logger=extent.createTest("WWTS Scan Loading");
		
		logger.log(Status.INFO, "*********** WWTS Scan Loading Starts ***********");
		
		wwts.wwtsGenerator();
		wwts.wwtsCreator();
		logger.log(Status.INFO, "*********** WWTS Scan generated and created ***********");
		
		wwts.uploadWWTSFile(wwts.getWWTSFileName());
		wwts.executeWWTSFile();
		logger.log(Status.PASS, "*********** WWTS Scan Loaded Sucessfully ***********");
		
		extent.flush();
	}
	
	@Test(priority=4)
	public void generater() throws Exception
	{
		System.out.println("====Inside DataGenerator====");
        gg.GroupGenerator();
		System.out.println("========Invnetory Data Created============");
	
		gg.GroupCreator();
		System.out.println("========Inventory file Created============");
	}

	@Test(priority=5)
	public void GroupFileCreator() throws Exception
	{
		
        ml.Verify();
		System.out.println("========Group File loaded successfully============");
	
	
	}
	

	@Test(priority=6)
	public void ManulLoadingChecking() throws Exception
	{
		
        gs.check();
		System.out.println("========File Created Successfully============");
	
	
	}
	
	

}
