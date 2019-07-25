package DataProvider;

import java.io.File;



/**
 * @author RAVIKUMARREDDY
 *
 */
public class TemdUpload extends ConfigReader {
private StringBuffer commandsList = new StringBuffer();
	
	public void uploadTemdReport(String TEMDVIOL, String TEMDMSG) {
		execute("pscp -pw " + ECM_SSH_Password + " \"" + TEMDVIOL + "\" " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/incoming/temd/");
		execute("pscp -pw " + ECM_SSH_Password + " \"" + TEMDMSG + "\" " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/incoming/temd/");
		
	}
	public void executeTemdScripts()
	{
		System.out.println("Begin executing load scripts...");
		boolean error = false;
		String date = getDate("MMddhhm");
		String SSHFile = Local_Folder_HC + File.separator + TEMD_COMMANDS_FILE;
		String SSHOutput = Local_Folder_HC + File.separator + TEMD_OUTPUT_NAME;
		
		System.out.println("ssh file:"+SSHFile);
		System.out.println("ssh output"+SSHOutput);
		

		addCommand("cd /ecm/incoming/temd/");
		addCommand("gzip *");
		addCommand("cd /ecm/log/");
		addCommand("mv load_temd.log load_temd_" + date + ".log");;
    	addCommand("mv load_temd_msg.log load_temd_msg_" + date + ".log");
		addCommand("mv load_temd_findings_error.log load_temd_findings_error_" + date + ".log");
		addCommand("/ecm/bin/temd/load_temd.sh");
		addCommand("/ecm/bin/HCOSscan_snapshot/create_hcos_scan_snapshot.sh");
		addCommand("/ecm/bin/HC_snapshot/create_HC_snapshot.sh");
		addCommand("/ecm/bin/HCTRAPP_snapshot/create_HCTRAPP_snapshot.sh");
		addCommand("/ecm/bin/HCTRANS_snapshot/create_HCTRANS_snapshot.sh");
		addCommand("exit");

		writeDataToFile(SSHFile, commandsList.toString(), false);
		execute("plink " + IP_ADDRESS + " -l " + ECM_SSH_Login + " -pw " + ECM_SSH_Password + 
				" < " + SSHFile + " > " + SSHOutput);
		execute("pscp -pw " + ECM_SSH_Password + " " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/log/load_temd_findings_error.log \"" + Local_Folder_HC+ "\""); 
	
		
		System.out.println("Loading TEMD reports to ECM server complete" + !error);
	}
	
	public void addCommand(String command) {
		String lineSep = System.getProperty("line.separator");
		commandsList.append(command);
		commandsList.append(lineSep);
	}
}
