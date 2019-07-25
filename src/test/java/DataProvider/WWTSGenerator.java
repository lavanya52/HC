/**
 * 
 */
package DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class WWTSGenerator extends DataGenerator{
	
	private List<Report> reports = new ArrayList<Report>();
	private Date dateID = new Date();
	
	private String[] WWTSFile;
	private StringBuffer commandsList = new StringBuffer();
	
	static WWTS prodOScan1,prodOScan2,prodOScan3;
	static WWTS transOScan1,transOScan2,transOScan3;
	static WWTS deployOScan1,deployOScan2,deployOScan3;
	
	static WWTS prodAScan1,prodAScan2,prodAScan3;
	static WWTS transAScan1,transAScan2,transAScan3;
	static WWTS deployAcan1,deployAcan2,deployAcan3;
	
	public void wwtsGenerator()
	{
		WWTSFile = getRowFromCSV(WWTS_File).split(WWTS_Separator, -1);
		
		prodOScan1 = new WWTS( WWTSFile, prodSystem1, "O", prodAppSystem1 );
		prodOScan2 = new WWTS( WWTSFile, prodSystem2, "O", prodAppSystem2 );
		prodOScan3 = new WWTS( WWTSFile, prodSystem3, "O", prodAppSystem3 );
		
		
		transOScan1 = new WWTS( WWTSFile, transSystem1, "O", transAppSystem1 );
		transOScan2 = new WWTS( WWTSFile, transSystem2, "O", transAppSystem2 );
		transOScan3 = new WWTS( WWTSFile, transSystem3, "O", transAppSystem3 );
		
		deployOScan1 = new WWTS( WWTSFile, deploySystem1, "O", deployAppSystem1 );
		deployOScan2 = new WWTS( WWTSFile, deploySystem2, "O", deployAppSystem2 );
		deployOScan3 = new WWTS( WWTSFile, deploySystem3, "O", deployAppSystem3 );
		
		reports.add(prodOScan1);
		reports.add(prodOScan2);
		reports.add(prodOScan3);
		

		reports.add(transOScan1);
		reports.add(transOScan2);
		reports.add(transOScan3);
		
		reports.add(deployOScan1);
		reports.add(deployOScan2);
		reports.add(deployOScan3);
		
		
		prodAScan1 = new WWTS( WWTSFile, prodSystem1, "A", prodAppSystem1 );
		prodAScan2 = new WWTS( WWTSFile, prodSystem2, "A", prodAppSystem2 );
		prodAScan3 = new WWTS( WWTSFile, prodSystem3, "A", prodAppSystem3 );
		
		
		transAScan1 = new WWTS( WWTSFile, transSystem1, "A", transAppSystem1 );
		transAScan2 = new WWTS( WWTSFile, transSystem2, "A", transAppSystem2 );
		transAScan3 = new WWTS( WWTSFile, transSystem3, "A", transAppSystem3 );
		
		deployAcan1 = new WWTS( WWTSFile, deploySystem1, "A", deployAppSystem1 );
		deployAcan2 = new WWTS( WWTSFile, deploySystem2, "A", deployAppSystem2 );
		deployAcan3 = new WWTS( WWTSFile, deploySystem3, "A", deployAppSystem3 );
		
		
		reports.add(prodAScan1);
		reports.add(prodAScan2);
		reports.add(prodAScan3);
		

		reports.add(transAScan1);
		reports.add(transAScan2);
		reports.add(transAScan3);
		
		reports.add(deployAcan1);
		reports.add(deployAcan2);
		reports.add(deployAcan3);
		
		
	}
	
	public void wwtsCreator()
	{
		boolean error = false;
		StringBuffer WWTSReport = new StringBuffer();
		StringBuffer resultReport;
		
		String lineSep = System.getProperty("line.separator");
		for (Report item : reports) {
			if (item instanceof WWTS) {
				resultReport = WWTSReport;
			for (int i = 0; i < item.getSize() - 1; i++) {
				resultReport.append(item.getField(i));
				resultReport.append(item.getSeparator());
			}
			
			resultReport.append(item.getField(item.getSize() - 1));
			resultReport.append(lineSep);
			}
		}
		
		System.out.println("WWTS generated data:");
		System.out.println(WWTSReport.toString());
		
		error = !writeReportToFile(getWWTSFileName(), WWTSReport, false, "WWTS");
		
		System.out.println(" WWTS reports in files complete" + !error);
	}
	
	public void uploadWWTSFile(String WWTSFile)
	{
		execute("pscp -pw " + ECM_SSH_Password + " \"" + WWTSFile + "\" " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/incoming/wwts/");
		System.out.println("Upload reports to ECM server complete");
	}
	
	public void executeWWTSFile()
	{
		System.out.println("Begin executing WWTS scripts...");
		boolean error = false;
		String date = getDate("MMddhhm");
		String SSHFile = Local_Folder_HC + File.separator + WWTS_COMMANDS_FILE;
		String SSHOutput = Local_Folder_HC + File.separator + WWTS_OUTPUT_FILE;
		
		System.out.println("ssh file:"+SSHFile);
		System.out.println("ssh output"+SSHOutput);
		
		addCommand("cd /ecm/log/");
		addCommand("mv load_wwts.log load_wwts_" + date + ".log");
		addCommand("mv load_wwts_findings_error.log load_wwts_findings_error_" + date + ".log");
		addCommand("/ecm/bin/wwts/load_wwts.sh");
		addCommand("/ecm/bin/HCOSscan_snapshot/create_hcos_scan_snapshot.sh");
		addCommand("/ecm/bin/HC_snapshot/create_HC_snapshot.sh");
		addCommand("/ecm/bin/HCTRAPP_snapshot/create_HCTRAPP_snapshot.sh");
		addCommand("/ecm/bin/HCTRANS_snapshot/create_HCTRANS_snapshot.sh");
		addCommand("exit");
		
		writeDataToFile(SSHFile, commandsList.toString(), false);
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" < " + SSHFile + " > " + SSHOutput);
		
		downloadLog("load_wwts.log");
		downloadLog("load_wwts_findings_error.log");
		
		checkLog("load_wwts_findings_error.log", "WWTS");
		
		System.out.println("Loading WWTS reports to ECM server complete" + !error);
	}
	
	public void addCommand(String command) {
		String lineSep = System.getProperty("line.separator");
		commandsList.append(command);
		commandsList.append(lineSep);
	}
	
	public String getWWTSFileName() {
		String ID = getDate(dateID, "yyyyMMddHHmmss");
		String WWTSFileName = "WWTSviol." + COUNTRY_NAME.toUpperCase() + 
				"-" + WWTS_SERVER + "." + ID + ".csv";
		return Local_Folder_HC + File.separator + WWTSFileName;
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
