/**
 * 
 */
package DataProvider;

import java.io.File;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class DataUploader extends ConfigReader {
	
	private StringBuffer commandsList = new StringBuffer();
	
	public void uploadSesdrReport(String SESDRFile, String SESDRAppFile) {
		execute("pscp -pw " + ECM_SSH_Password + " \"" + SESDRFile + "\" " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/incoming/sesdr/");
		execute("pscp -pw " + ECM_SSH_Password + " \"" + SESDRAppFile + "\" " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/incoming/sesdr/");
	}
	
	public void uploadGacdwReport(String GACDWFile, String GACDWAppFile) {
		execute("pscp -pw " + ECM_SSH_Password + " \"" + GACDWFile + "\" " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/incoming/gacdw/");
		execute("pscp -pw " + ECM_SSH_Password + " \"" + GACDWAppFile + "\" " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/incoming/gacdw/");
	}

	public void executeSesdrScripts()
	{
		System.out.println("Begin executing load scripts...");
		boolean error = false;
		String date = getDate("MMddhhm");
		String SSHFile = Local_Folder_SESDR + File.separator + SSH_COMMANDS_FILE;
		String SSHOutput = Local_Folder_SESDR + File.separator + SSH_OUTPUT_NAME;
		
		System.out.println("ssh file:"+SSHFile);
		System.out.println("ssh output"+SSHOutput);
		
		addCommand("cd /ecm/log/");
		addCommand("mv load_sesdr.log load_sesdr_" + date + ".log");
		addCommand("mv load_sesdr_records_error.log load_sesdr_records_error_" + date + ".log");
		addCommand("mv load_sesdr_app.log load_sesdr_app_" + date + ".log");
		addCommand("mv load_sesdr_app_records_error.log load_sesdr_app_records_error_" + date + ".log");
		//addCommand("mv load_sesdr_ip.log load_sesdr_ip_" + date + ".log");
		//addCommand("mv load_sesdr_ip_records_error.log load_sesdr_ip_records_error_" + date + ".log");
		addCommand("/ecm/bin/sesdr/load_sesdr.sh");
		addCommand("exit");

		writeDataToFile(SSHFile, commandsList.toString(), false);
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" < " + SSHFile + " > " + SSHOutput);
		
		execute("pscp -pw " + ECM_SSH_Password + " " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/log/load_sesdr_records_error.log \"" + Local_Folder_SESDR + "\"");
		
		execute("pscp -pw " + ECM_SSH_Password + " " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/log/load_sesdr_app_records_error.log \"" + Local_Folder_SESDR + "\"");
		
		
		if (checkDownloadFile(Local_Folder_SESDR + File.separator + "load_sesdr_records_error.log") == 0) {
			System.out.println("SESDR report loaded successfully");
		} else {
			error = true;
			System.err.println("Error while uploading SESDR report to server");
		}
		
		if (checkDownloadFile(Local_Folder_SESDR + File.separator + "load_sesdr_app_records_error.log") == 0) {
			System.out.println("SESDR APP report loaded successfully");
		} else {
			error = true;
			System.out.println("Error while uploading SESDR APP report to server");
		}
		
		//logTestResult("Importing SESDR, SESDR_APP & SESDR_IP reports to ECM server complete", !error);
	}
	
	public void executeGacdwScripts()
	{
		System.out.println("Begin executing load scripts...");
		boolean error = false;
		String date = getDate("MMddhhm");
		String SSHFile = Local_Folder_GACDW + File.separator + SSH_COMMANDS_FILE;
		String SSHOutput = Local_Folder_GACDW + File.separator + SSH_OUTPUT_NAME;
		
		System.out.println("ssh file:"+SSHFile);
		System.out.println("ssh output"+SSHOutput);
		
		addCommand("cd /ecm/log/");
		addCommand("mv load_gacdw.log load_gacdw_" + date + ".log");
		addCommand("mv load_gacdw_records_error.log load_gacdw_records_error_" + date + ".log");
		addCommand("mv load_gacdw_app.log load_gacdw_app_" + date + ".log");
		addCommand("mv load_gacdw_app_records_error.log load_gacdw_app_records_error_" + date + ".log");
		//addCommand("mv load_sesdr_ip.log load_sesdr_ip_" + date + ".log");
		//addCommand("mv load_sesdr_ip_records_error.log load_sesdr_ip_records_error_" + date + ".log");
		addCommand("/ecm/bin/gacdw/load_gacdw.sh");
		addCommand("/ecm/bin/HCTRANS_snapshot/create_HCTRANS_snapshot.sh");//snapshot added for IMI req FR21576
		//addCommand("/ecm/bin/HC_snapshot/create_HC_snapshot.sh");//snapshot added for IMI req FR21576
		addCommand("exit");

		writeDataToFile(SSHFile, commandsList.toString(), false);
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" < " + SSHFile + " > " + SSHOutput);
		
		execute("pscp -pw " + ECM_SSH_Password + " " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/log/load_gacdw_records_error.log \"" + Local_Folder_GACDW + "\"");
		
		execute("pscp -pw " + ECM_SSH_Password + " " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/log/load_gacdw_app_records_error.log \"" + Local_Folder_GACDW + "\"");
		
		
		if (checkDownloadFile(Local_Folder_GACDW + File.separator + "load_gacdw_records_error.log") == 0) {
			System.out.println("GACDW report loaded successfully");
		} else {
			error = true;
			System.err.println("Error while uploading GACDW report to server");
		}
		
		if (checkDownloadFile(Local_Folder_GACDW + File.separator + "load_gacdw_app_records_error.log") == 0) {
			System.out.println("GACDW APP report loaded successfully");
		} else {
			error = true;
			System.out.println("Error while uploading GACDW APP report to server");
		}
		
		//logTestResult("Importing SESDR, SESDR_APP & SESDR_IP reports to ECM server complete", !error);
	}
	
	public void addCommand(String command) {
		String lineSep = System.getProperty("line.separator");
		//System.out.println("line separator:"+lineSep);
		commandsList.append(command);
		commandsList.append(lineSep);
	}
}
