package DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupGenerator extends DataGenerator {
	private List<Report> reports = new ArrayList<Report>();
	private Date dateID = new Date();
	
	private String[] GroupFile;
	private StringBuffer commandsList = new StringBuffer();
	
	static Group prodOScan1,prodOScan2,prodOScan3;
	static Group transOScan1,transOScan2,transOScan3;
	static Group deployOScan1,deployOScan2,deployOScan3;
	
	static Group prodAScan1,prodAScan2,prodAScan3;
	static Group transAScan1,transAScan2,transAScan3;
	static Group deployAcan1,deployAcan2,deployAcan3;
	
	public void GroupGenerator()
	{
		GroupFile = getRowFromCSV(Group_File).split(Group_Separator, -1);
		
		prodOScan1 = new Group( GroupFile, prodSystem1, "O", prodAppSystem1 );
		prodOScan2 = new Group( GroupFile, prodSystem2, "O", prodAppSystem2 );
		prodOScan3 = new Group( GroupFile, prodSystem3, "O", prodAppSystem3 );
		
		
		transOScan1 = new Group( GroupFile, transSystem1, "O", transAppSystem1 );
		transOScan2 = new Group( GroupFile, transSystem2, "O", transAppSystem2 );
		transOScan3 = new Group( GroupFile, transSystem3, "O", transAppSystem3 );
		
		deployOScan1 = new Group( GroupFile, deploySystem1, "O", deployAppSystem1 );
		deployOScan2 = new Group( GroupFile, deploySystem2, "O", deployAppSystem2 );
		deployOScan3 = new Group( GroupFile, deploySystem3, "O", deployAppSystem3 );
		
		reports.add(prodOScan1);
		reports.add(prodOScan2);
		reports.add(prodOScan3);
		

		reports.add(transOScan1);
		reports.add(transOScan2);
		reports.add(transOScan3);
		
		reports.add(deployOScan1);
		reports.add(deployOScan2);
		reports.add(deployOScan3);
		
		
		prodAScan1 = new Group( GroupFile, prodSystem1, "A", prodAppSystem1);
		prodAScan2 = new Group( GroupFile, prodSystem2, "A", prodAppSystem2 );
		prodAScan3 = new Group( GroupFile, prodSystem3, "A", prodAppSystem3 );
		
		
		transAScan1 = new Group( GroupFile, transSystem1, "A", transAppSystem1 );
		transAScan2 = new Group( GroupFile, transSystem2, "A", transAppSystem2 );
		transAScan3 = new Group( GroupFile, transSystem3, "A", transAppSystem3 );
		
		deployAcan1 = new Group( GroupFile, deploySystem1, "A", deployAppSystem1 );
		deployAcan2 = new Group( GroupFile, deploySystem2, "A", deployAppSystem2 );
		deployAcan3 = new Group( GroupFile, deploySystem3, "A", deployAppSystem3 );
		
		
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
	
	public void GroupCreator()
	{
		boolean error = false;
		StringBuffer GroupReport = new StringBuffer();
		StringBuffer resultReport;
		
		String lineSep = System.getProperty("line.separator");
		for (Report item : reports) {
			if (item instanceof Group) {
				resultReport = GroupReport;
			for (int i = 0; i < item.getSize() - 1; i++) {
				resultReport.append(item.getField(i));
				resultReport.append(item.getSeparator());
			}
			
			resultReport.append(item.getField(item.getSize() - 1));
			resultReport.append(lineSep);
			}
		}
		
		System.out.println("Group generated data:");
		System.out.println(GroupReport.toString());
		
		error = !writeReportToFile(getGroupFileName(), GroupReport, false, "Group");
		
		System.out.println(" Group reports in files complete" + !error);
	}
	public void addCommand(String command) {
		String lineSep = System.getProperty("line.separator");
		commandsList.append(command);
		commandsList.append(lineSep);
	}
	
	public String getGroupFileName() {
		//Group.IMT_RVT.20181010041241.csv
		String ID = getDate(dateID, "yyyyMMddHHmmss");
		String GroupFileName = "Group.IMT_RVT" + "." + ID + ".csv";
		return Local_Folder_HC + File.separator + GroupFileName;
	}
	
	public void downloadLog(String logName) {
		execute("pscp -pw " + ECM_SSH_Password + " " + ECM_SSH_Login + 
				"@" + IP_ADDRESS + ":/ecm/log/" + logName + " \"" + Local_Folder_HC + "\"");
	}
	
	/*public void checkLog(String logName, String reportName) {
		if (checkDownloadFile(Local_Folder_Group + File.separator + logName) == 0) {
			System.out.println(reportName + " report loaded successfully");
		} else {
			System.out.println("Error while uploading " + reportName + " report to server");
		}
	}*/

}
