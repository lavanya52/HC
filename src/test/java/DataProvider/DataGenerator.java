/**
 * 
 */
package DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdk.nashorn.internal.runtime.options.LoggingOption.LoggerInfo;
import jxl.Workbook;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class DataGenerator extends ConfigReader {

	//private List reports = new ArrayList<>();
	private List<Report> reports = new ArrayList<Report>();
	private Date dateID = new Date();
	
	private static String SESDRFileName;
	private static String SESDRAPPFileName;
	private static String GACDWFileName;
	private static String GACDWAPPFileName;
	
	private String[] SESDRv14File;
	private String[] SESDRAppFile;
	private String[] GACDWFile;
	private String[] GACDWAppFile;
	
	//ConfigReader conf = new ConfigReader();
	
	static GacdwInventory prodSystem1,prodSystem2,prodSystem3;
	static GacdwInventory transSystem1,transSystem2,transSystem3;
	static GacdwInventory deploySystem1,deploySystem2,deploySystem3;
	
	static GacdwApplication prodAppSystem1,prodAppSystem2,prodAppSystem3;
	static GacdwApplication transAppSystem1,transAppSystem2,transAppSystem3;
	static GacdwApplication deployAppSystem1,deployAppSystem2,deployAppSystem3;
	
	public void generateSesdrReports() throws Exception
	{
		System.out.println("SESDR Generating Starts");
		
		SESDRv14File = getRowFromCSV(SESDR_FILE).split(SESDR_Separator, -1);

	
		SesdrInventory prodSystem1 = new SesdrInventory(SESDRv14File, dateID, true, 1, "CPU"); 
		SesdrInventory prodSystem2 = new SesdrInventory(SESDRv14File, dateID, true, 1, "NETWORK"); 
		SesdrInventory prodSystem3 = new SesdrInventory(SESDRv14File, dateID, true, 1, "STORAGE"); 
		
		SesdrInventory transSystem1 = new SesdrInventory(SESDRv14File, dateID, false, 1, "CPU"); 
		SesdrInventory transSystem2 = new SesdrInventory(SESDRv14File, dateID, false, 1, "NETWORK"); 
		SesdrInventory transSystem3 = new SesdrInventory(SESDRv14File, dateID, false, 1, "STORAGE"); 
		
		reports.add(prodSystem1);
		reports.add(prodSystem2);
		reports.add(prodSystem3);
		
		reports.add(transSystem1);
		reports.add(transSystem2);
		reports.add(transSystem3);
		
		SESDRAppFile = getRowFromCSV(SESDR_APP_FILE).split(SESDR_Separator, -1);
		
		SesdrApplication prodAppSystem1 = new SesdrApplication(SESDRAppFile, prodSystem1,"A");
		SesdrApplication prodAppSystem2 = new SesdrApplication(SESDRAppFile, prodSystem2,"A");
		SesdrApplication prodAppSystem3 = new SesdrApplication(SESDRAppFile, prodSystem3,"A");
		
		SesdrApplication transAppSystem1 = new SesdrApplication(SESDRAppFile, transSystem1,"A");
		SesdrApplication transAppSystem2 = new SesdrApplication(SESDRAppFile, transSystem2,"A");
		SesdrApplication transAppSystem3 = new SesdrApplication(SESDRAppFile, transSystem3,"A");
		
		reports.add(prodAppSystem1);
		reports.add(prodAppSystem2);
		reports.add(prodAppSystem3);
		
		reports.add(transAppSystem1);
		reports.add(transAppSystem2);
		reports.add(transAppSystem3);
		
	}
	
	public void generateGacdwReports() throws Exception
	{
		System.out.println("GACDW Generating Starts");
		
		GACDWFile = getRowFromCSV(GACDW_FILE).split(GACDW_Separator, -1);

	
		 prodSystem1 = new GacdwInventory(GACDWFile, dateID, 1, 2, "SERVER"); 
		 prodSystem2 = new GacdwInventory(GACDWFile, dateID, 1, 1, "NETWORK DEVICE"); 
		 prodSystem3 = new GacdwInventory(GACDWFile, dateID, 1, 1, "STORAGE"); 
		
		 transSystem1 = new GacdwInventory(GACDWFile, dateID, 2, 1, "SERVER"); 
		 transSystem2 = new GacdwInventory(GACDWFile, dateID, 2, 1, "NETWORK DEVICE"); 
		 transSystem3 = new GacdwInventory(GACDWFile, dateID, 2, 1, "STORAGE"); 
		
		 deploySystem1 = new GacdwInventory(GACDWFile, dateID, 3, 2, "SERVER"); 
		 deploySystem2 = new GacdwInventory(GACDWFile, dateID, 3, 1, "NETWORK DEVICE"); 
		 deploySystem3 = new GacdwInventory(GACDWFile, dateID, 3, 2, "STORAGE"); 
		
		reports.add(prodSystem1);
		reports.add(prodSystem2);
		reports.add(prodSystem3);
		
		reports.add(transSystem1);
		reports.add(transSystem2);
		reports.add(transSystem3);
		
		reports.add(deploySystem1);
		reports.add(deploySystem2);
		reports.add(deploySystem3);
		
		GACDWAppFile = getRowFromCSV(GACDW_APP_FILE).split(GACDW_Separator, -1);
		
		 prodAppSystem1 = new GacdwApplication(GACDWAppFile, prodSystem1,"A");
		 prodAppSystem2 = new GacdwApplication(GACDWAppFile, prodSystem2,"A");
		 prodAppSystem3 = new GacdwApplication(GACDWAppFile, prodSystem3,"A");
		
		 transAppSystem1 = new GacdwApplication(GACDWAppFile, transSystem1,"A");
		 transAppSystem2 = new GacdwApplication(GACDWAppFile, transSystem2,"A");
		 transAppSystem3 = new GacdwApplication(GACDWAppFile, transSystem3,"A");
		
		 deployAppSystem1 = new GacdwApplication(GACDWAppFile, deploySystem1,"A");
		 deployAppSystem2 = new GacdwApplication(GACDWAppFile, deploySystem2,"A");
		 deployAppSystem3 = new GacdwApplication(GACDWAppFile, deploySystem3,"A");
		
		reports.add(prodAppSystem1);
		reports.add(prodAppSystem2);
		reports.add(prodAppSystem3);
		
		reports.add(transAppSystem1);
		reports.add(transAppSystem2);
		reports.add(transAppSystem3);
		
		reports.add(deployAppSystem1);
		reports.add(deployAppSystem2);
		reports.add(deployAppSystem3);
		
		
		
	}
	
	public void createSesdrReport()
	{
		System.out.println("========Begin creating reports=============");
		
		boolean error = false;
		StringBuffer resultReport;
		StringBuffer SESDRReport = new StringBuffer();
		StringBuffer SESDRAppReport = new StringBuffer();
		String lineSep = System.getProperty("line.separator");
		
		for (Report item : reports) 
		{
			if (item instanceof SesdrInventory) 
			{
				resultReport = SESDRReport;
			}
			else
			{
				resultReport = SESDRAppReport;
			}
			for (int i = 0; i < item.getSize() - 1; i++) 
			{
				resultReport.append(item.getField(i));
				resultReport.append(item.getSeparator());
			}
			
			resultReport.append(item.getField(item.getSize() - 1));
			resultReport.append(lineSep);
		}
		
		System.out.println("SESDR generated data:");
		System.out.println(SESDRReport.toString());
		
		System.out.println("SESDR APP generated data:");
		System.out.println(SESDRAppReport.toString());
		
		String SESDRGzName = execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"ls -t /ecm/archive/sesdr | grep -i '^SESDR\\.' | head -n1\"");
		
		String SESDRAppGzName = execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"ls -t /ecm/archive/sesdr | grep -i '^SESDR_APP' | head -n1\"");
		
		SESDRFileName = downloadInventory(SESDRGzName);
		SESDRAPPFileName = downloadInventory(SESDRAppGzName);
		
		SESDRAPPFileName = matchToInventory(SESDRAPPFileName);
		
		error = error || !writeReportToFile(getFilePath("SESDR"), SESDRReport, true, "SESDR");
		error = error || !writeReportToFile(getFilePath("SESDR_APP"), SESDRAppReport, true, "SESDR APP");
		
		//logTestResult("Record SESDR reports in files complete", !error);
	}
	
	public void createGacdwReport()
	{
		System.out.println("========Begin creating GACDW reports=============");
		
		boolean error = false;
		StringBuffer resultReport;
		StringBuffer GACDWReport = new StringBuffer();
		StringBuffer GACDWAppReport = new StringBuffer();
		String lineSep = System.getProperty("line.separator");
		
		for (Report item : reports) 
		{
			if (item instanceof GacdwInventory) 
			{
				resultReport = GACDWReport;
			}
			else
			{
				resultReport = GACDWAppReport;
			}
			for (int i = 0; i < item.getSize() - 1; i++) 
			{
				resultReport.append(item.getField(i));
				resultReport.append(item.getSeparator());
			}
			
			resultReport.append(item.getField(item.getSize() - 1));
			resultReport.append(lineSep);
		}
		
		System.out.println("GACDW generated data:");
		System.out.println(GACDWReport.toString());
		
		System.out.println("GACDW APP generated data:");
		System.out.println(GACDWAppReport.toString());
		
		String GACDWGzName = execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"ls -t /ecm/archive/gacdw | grep -i '^GACDW\\.' | head -n1\"");
		
		String GACDWAppGzName = execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"ls -t /ecm/archive/gacdw | grep -i '^GACDW_APP' | head -n1\"");
		
		GACDWFileName = downloadInventoryGACDW(GACDWGzName);
		GACDWAPPFileName = downloadInventoryGACDW(GACDWAppGzName);
		
		GACDWAPPFileName = matchToInventoryGACDW(GACDWAPPFileName);
		
		error = error || !writeReportToFile(getGACDWFilePath("GACDW"), GACDWReport, true, "GACDW");
		error = error || !writeReportToFile(getGACDWFilePath("GACDW_APP"), GACDWAppReport, true, "GACDW APP");
		
		//logTestResult("Record GACDW reports in files complete", !error);
	}
	
	public String matchToInventory(String oldFileName) {
		File fileFromECM = new File(Local_Folder_SESDR + File.separator + oldFileName);
		String newFileName = oldFileName.split("\\.")[0] + "." + SESDRFileName.split("\\.")[1] + ".csv";
		System.out.println("Old File Name : " + oldFileName);
		System.out.println("New File Name(Changed) : " + newFileName);
		File matchForInv = new File(Local_Folder_SESDR + File.separator + newFileName);
		fileFromECM.renameTo(matchForInv);
		return newFileName;
	}
	
	public String matchToInventoryGACDW(String oldFileName) {
		File fileFromECM = new File(Local_Folder_GACDW + File.separator + oldFileName);
		String newFileName = oldFileName.split("\\.")[0] + "." + GACDWFileName.split("\\.")[1] + ".csv";
		System.out.println("Old File Name : " + oldFileName);
		System.out.println("New File Name(Changed) : " + newFileName);
		File matchForInv = new File(Local_Folder_GACDW + File.separator + newFileName);
		fileFromECM.renameTo(matchForInv);
		return newFileName;
	}
	
	public String downloadInventory(String inventoryGzName) {
		String CSVName = inventoryGzName.substring(0, inventoryGzName.indexOf(".gz"));
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"gzip -dc </ecm/archive/sesdr/" + CSVName + ".gz> /home/" + ECM_SSH_Login + "/Documents/" + CSVName + "\"");
		execute("pscp -pw " + ECM_SSH_Password + " " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/home/" + ECM_SSH_Login + "/Documents/" + CSVName + " \"" + Local_Folder_SESDR + "\"");
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"rm /home/" + ECM_SSH_Login + "/Documents/" + CSVName + "\"");
		return CSVName;
	}
	
	public String downloadInventoryGACDW(String inventoryGzName) {
		String CSVName = inventoryGzName.substring(0, inventoryGzName.indexOf(".gz"));
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"gzip -dc </ecm/archive/gacdw/" + CSVName + ".gz> /home/" + ECM_SSH_Login + "/Documents/" + CSVName + "\"");
		execute("pscp -pw " + ECM_SSH_Password + " " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/home/" + ECM_SSH_Login + "/Documents/" + CSVName + " \"" + Local_Folder_GACDW + "\"");
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"rm /home/" + ECM_SSH_Login + "/Documents/" + CSVName + "\"");
		return CSVName;
	}
	
	public static String getFilePath(String fileType) {
		String fileName = new String();
		switch (fileType) {
			case "SESDR":
				fileName = SESDRFileName;
				break;
			case "SESDR_APP":
				fileName = SESDRAPPFileName;
				break;
			case "SESDR_IP":
				//fileName = SESDRIPFileName;
				break;
		}
		return Local_Folder_SESDR + File.separator + fileName;
	}
	
	public static String getGACDWFilePath(String fileType) {
		String fileName = new String();
		switch (fileType) {
			case "GACDW":
				fileName = GACDWFileName;
				break;
			case "GACDW_APP":
				fileName = GACDWAPPFileName;
				break;
			case "GACDW_IP":
				//fileName = SESDRIPFileName;
				break;
		}
		return Local_Folder_GACDW + File.separator + fileName;
	}
	
	public boolean writeReportToFile(String fileName, StringBuffer reportData, boolean append, String reportName) {
		String lineSep = System.getProperty("line.separator");
		writeDataToFile(fileName, reportData.toString(), append);
		if (checkDownloadFile(fileName) > 0) {
			System.out.println(reportName + " reports successfully written to the file" + lineSep + 
					"Filename: " + new File(fileName).getName() + lineSep + 
					"Size: " + (checkDownloadFile(fileName) / 1024) + " kb");
		} else {
			System.out.println("Error while writing " + reportName + " report to file");
			return false;
		}
		return true;
	}
	
	protected static String getRowFromCSV(String file) {
		String row = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    for (String line; (line = br.readLine()) != null;) {
		        	row = line;
		        	break;
		        }
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return row;
	}
	
	/*public static void main(String[] args) {
		
	}*/
	
}
