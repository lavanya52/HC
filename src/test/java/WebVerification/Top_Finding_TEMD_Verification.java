/**
 * 
 */
package WebVerification;

import org.testng.annotations.Test;

import DataProvider.ConfigReader;
import DataProvider.DataGenerator;
import DataProvider.DataUploader;
import DataProvider.TemdGenGacdw;
import DataProvider.TemdUpload;
import DataProvider.TopFindings_TEMD;

/**
 * @author Lavanya
 *
 */
public class Top_Finding_TEMD_Verification extends ConfigReader{
	
DataGenerator dg = new DataGenerator();
	
	DataUploader du = new DataUploader();
	TemdUpload temdu=new TemdUpload();
	
	TemdGenGacdw temd=new TemdGenGacdw();
	TopFindings_TEMD tt=new TopFindings_TEMD();
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
	
	@Test(priority=2)
	public void generate() throws Exception
	{
		System.out.println("====Inside DataGenerator====");
		dg.generateGacdwReports();
		System.out.println("========Invnetory Data Created============");
	}
	
	@Test(priority= 3)
	public void create()
	{
		dg.createGacdwReport();
		System.out.println("========Inventory file Created============");
	}
	
	@Test(priority = 4)
	public void upload()
	{
		du.uploadGacdwReport(DataGenerator.getGACDWFilePath("GACDW"),DataGenerator.getGACDWFilePath("GACDW_APP"));
		System.out.println("========Inventory file uploaded===========");		
		
	}
	
	@Test(priority = 5)
	public void execute()
	{
		du.executeGacdwScripts();
		System.out.println("========Inventory file executed===========");
		
	}
	@Test(priority=6)
	public void temdScanLoad() throws Exception
	{
	temd.TemdViolGenerator();	
	System.out.println("temd scan generated");
	temd.temdCreator();
	temdu.uploadTemdReport(temd.getVIOLFileName(), temd.getMSGFileName());
	temdu.executeTemdScripts();
	}
	@Test(priority=7)
	public void verify() throws Exception
	{
	tt.check_DEPLOYMENT_STO_MF();
	tt.check_ALL_ALL_ALL();
	tt.check_TRANSITION_SER_DS();
	}
	

}
