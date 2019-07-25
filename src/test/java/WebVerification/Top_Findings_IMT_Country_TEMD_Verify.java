/**
 * 
 */
package WebVerification;

import org.testng.annotations.Test;

import DataProvider.ConfigReader;
import DataProvider.DataGenerator;
import DataProvider.DataUploader;
/*import DataProvider.TemdGenGacdw;
import DataProvider.TemdUpload;
import DataProvider.TopFindings_TEMD;*/
import DataProvider.TemdGenGacdw;
import DataProvider.TemdUpload;
import DataProvider.Top_Findings_IMT_Country_TEMD;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class Top_Findings_IMT_Country_TEMD_Verify extends ConfigReader {
	
	DataGenerator dg = new DataGenerator();
	DataUploader du = new DataUploader();
	TemdGenGacdw temd=new TemdGenGacdw();
	TemdUpload temdu=new TemdUpload();
	Top_Findings_IMT_Country_TEMD tt=new Top_Findings_IMT_Country_TEMD();
	
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
	@Test(priority = 3)
	public void TopFindings() throws Exception
	{
	
		tt.Top_SER_TRA_ALL();
		tt.Top_STO_TRA_ALL();
		tt.Top_NET_TRA_ALL();
		
	}
	

}
