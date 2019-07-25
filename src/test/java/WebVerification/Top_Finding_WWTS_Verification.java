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
import DataProvider.TopFindings_WWTS;
import DataProvider.WWTSGenerator;

public class Top_Finding_WWTS_Verification extends ConfigReader {
	
	DataGenerator dg = new DataGenerator();
	DataUploader du = new DataUploader();
	WWTSGenerator wwts = new WWTSGenerator();
	TopFindings_WWTS tf=new TopFindings_WWTS();
	
	
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	ExtentTest logger2;
	


	@Test(priority=0)
	public void cleanLocalFolder()
	{
		cleanLocalFolder(Local_Folder_HC);
	}
	/*@Test(priority=1)
	public void cleanLocalFolder_TOP()
	{
		cleanLocalFolder(LocalFolder_TOP);
	}*/
	
	
	
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
	public void wwtsGenerate()
	{

		
		wwts.wwtsGenerator();
		wwts.wwtsCreator();
		wwts.uploadWWTSFile(wwts.getWWTSFileName());
		wwts.executeWWTSFile();

	}
	
	@Test(priority = 3)
	public void TopFindings() throws Exception
	{
    tf.check_DEPLOYMENT_STO_MF();
	tf.check_PRODUCTIVE_SER_DS();
	tf.check_ALL_ALL_ALL();
	}
	

}
