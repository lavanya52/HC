package WebVerification;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import DataProvider.DataGenerator;
import DataProvider.DataUploader;
import DataProvider.HC_AUCU_Overview_Verify;
import DataProvider.TemdGenGacdw;
import DataProvider.TemdUpload;
/*import DataProvider.HC_Customer_NonProd_GACDW;
import DataProvider.TemdGenGacdw;

import DataProvider.TemdUpload;*/
import DataProvider.AUCUGenerator;

/**
 * @author RAVIKUMARREDDY
 *
 */
public class HC_AUCU_Overview_GACDW_Verify {
	
	DataGenerator dg = new DataGenerator();
	DataUploader du = new DataUploader();
	AUCUGenerator aucu = new AUCUGenerator();
	TemdUpload temdu=new TemdUpload();
	TemdGenGacdw temd=new TemdGenGacdw();
	HC_AUCU_Overview_Verify verify=new HC_AUCU_Overview_Verify();
	
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	ExtentTest logger2;
	
	@BeforeMethod
	public void extentReport() {

		reporter = new ExtentHtmlReporter("./OutPut/AUCU.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);

	}
	
	@Test(priority=1)
	public void gacdwgenerate() throws Exception
	{
		System.out.println("====Inside DataGenerator====");
		dg.generateGacdwReports();
		System.out.println("========Invnetory Data Created============");
	
		dg.createGacdwReport();
		System.out.println("========Inventory file Created============");
	
		/*du.uploadGacdwReport(DataGenerator.getGACDWFilePath("GACDW"),DataGenerator.getGACDWFilePath("GACDW_APP"));
		System.out.println("========Inventory file uploaded===========");		
		
		du.executeGacdwScripts();
		System.out.println("========Inventory file executed===========");*/
		
	}
	
	/*@Test(priority = 2)
	public void temdScanLoad() throws Exception
	{
		temd.TemdViolGenerator();	
		System.out.println("temd scan generated");
		temd.temdCreator();
		temdu.uploadTemdReport(temd.getVIOLFileName(), temd.getMSGFileName());
		temdu.executeTemdScripts();
	}*/
	
	@Test(priority = 3)
	public void aucuGenerate()
	{

		
		aucu.AUCUGenerator();
		aucu.createAucuReport();
		/*aucu.uploadAUCUFile(AUCUGenerator.getFilePath("AUCU"));
		aucu.executeAUCUFile();*/

	}
	
	/*@Test(priority =3)
	public void pageVerify() throws Exception
	{
		logger = extent.createTest("Web Page Verification");
		
		verify.verify_IMT_MF_SER();
		verify.verify_IMT_ALL_NET();
		verify.verify_IMT_DS_STO();
		verify.verify_AllIMT_MF_SST();
		
		extent.flush();
		
	}*/
	}
