package DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class AUCUGenerator extends DataGenerator{
	
	private List<Report> reports = new ArrayList<Report>();
	private Date dateID = new Date();
	
	private String[] AUCUFile;
	private StringBuffer commandsList = new StringBuffer();
	
	private static String AUCUFileName;
	static AUCU prodOScan1;
	
	public void AUCUGenerator()
	{
		AUCUFile = getRowFromCSV(AUCU_File).split(AUCU_Separator, -1);
		
		prodOScan1 = new AUCU( AUCUFile, prodSystem1, "O", prodAppSystem1 );
	
		reports.add(prodOScan1);
	}
	
	
	public void createAucuReport()
	{
		System.out.println("========Begin creating reports=============");
		
		boolean error = false;
		StringBuffer resultReport;
		StringBuffer AUCUReport = new StringBuffer();
		//StringBuffer SESDRAppReport = new StringBuffer();
		String lineSep = System.getProperty("line.separator");
		
		for (Report item : reports) 
		{
			if (item instanceof AUCU) 
			{
				resultReport = AUCUReport;
			
			
			for (int i = 0; i < item.getSize() - 1; i++) 
			{
				resultReport.append(item.getField(i));
				resultReport.append(item.getSeparator());
			}
			
			
			resultReport.append(item.getField(item.getSize() - 1));
			resultReport.append(lineSep);
			}
		}
		
		System.out.println("AUCU generated data:");
		System.out.println(AUCUReport.toString());
		
		String AUCUGzName = execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"ls -t /ecm/archive/aucu | grep -i '^AUCU\\.' | head -n1\"");
		
		AUCUFileName = downloadInventory(AUCUGzName);
		
		error = error || !writeReportToFile(getFilePath("AUCU"), AUCUReport, true, "AUCU");
		
		//logTestResult("Record SESDR reports in files complete", !error);
	}
	
	
	public String matchToInventory(String oldFileName) {
		File fileFromECM = new File(Local_Folder_HC + File.separator + oldFileName);
		String newFileName = oldFileName.split("\\.")[0] + "." + AUCUFileName.split("\\.")[1] + ".csv";
		System.out.println("Old File Name : " + oldFileName);
		System.out.println("New File Name(Changed) : " + newFileName);
		File matchForInv = new File(Local_Folder_HC + File.separator + newFileName);
		fileFromECM.renameTo(matchForInv);
		return newFileName;
	}
	
	
	public String downloadInventory(String inventoryGzName) {
		String CSVName = inventoryGzName.substring(0, inventoryGzName.indexOf(".gz"));
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"gzip -dc </ecm/archive/aucu/" + CSVName + ".gz> /home/" + ECM_SSH_Login + "/Documents/" + CSVName + "\"");
		execute("pscp -pw " + ECM_SSH_Password + " " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/home/" + ECM_SSH_Login + "/Documents/" + CSVName + " \"" + Local_Folder_HC + "\"");
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" \"rm /home/" + ECM_SSH_Login + "/Documents/" + CSVName + "\"");
		return CSVName;
	}
	
	public static String getFilePath(String fileType) {
		String fileName = new String();
		switch (fileType) {
			case "AUCU":
				fileName = AUCUFileName;
				break;
		}
		return Local_Folder_HC + File.separator + fileName;
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
	
	
	public void uploadAUCUFile(String AUCUFile)
	{
		execute("pscp -pw " + ECM_SSH_Password + " \"" + AUCUFile + "\" " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/incoming/aucu/");
		System.out.println("Upload reports to ECM server complete");
	}
	
	public void executeAUCUFile()
	{
		System.out.println("Begin executing AUCU scripts...");
		boolean error = false;
		String date = getDate("MMddhhm");
		String SSHFile = Local_Folder_HC + File.separator + AUCU_COMMANDS_FILE;
		String SSHOutput = Local_Folder_HC + File.separator + AUCU_OUTPUT_FILE;
		
		System.out.println("ssh file:"+SSHFile);
		System.out.println("ssh output"+SSHOutput);
		
		addCommand("cd /ecm/log/");
		addCommand("mv load_aucu.log load_aucu_" + date + ".log");
		addCommand("mv load_aucu_findings_error.log load_aucu_findings_error_" + date + ".log");
		addCommand("/ecm/bin/aucu/load_aucu.sh");
		
		addCommand("/ecm/bin/HC_snapshot/create_HC_snapshot.sh");
		addCommand("/ecm/bin/HCAPP_snapshot/create_HCAPP_snapshot.sh");
		
		addCommand("exit");
		
		writeDataToFile(SSHFile, commandsList.toString(), false);
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" < " + SSHFile + " > " + SSHOutput);
		
		downloadLog("load_aucu.log");
		downloadLog("load_aucu_findings_error.log");
		
		checkLog("load_aucu_findings_error.log", "AUCU");
		
		System.out.println("Loading AUCU reports to ECM server complete" + !error);
	}
	
	public void addCommand(String command) {
		String lineSep = System.getProperty("line.separator");
		commandsList.append(command);
		commandsList.append(lineSep);
	}
	
	public String getAUCUFileName() {
		String ID = getDate(dateID, "yyyyMMddHHmmss");
		String AUCUFileName = AUCU_SERVER + "." + ID + ".csv";
		return Local_Folder_HC + File.separator + AUCUFileName;
	}
	
	public void downloadLog(String logName) {
		execute("pscp -pw " + ECM_SSH_Password + " " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/log/" + logName + " \"" + Local_Folder_HC + "\"");
	}
	
	public void checkLog(String logName, String reportName) {
		if (checkDownloadFile(Local_Folder_HC + File.separator + logName) == 0) {
			System.out.println(reportName + " report loaded successfully");
		} else {
			System.out.println("Error while uploading " + reportName + " report to server");
		}
	}
	
}
