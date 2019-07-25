package DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class TemdGenGacdw extends DataGenerator {

	private List<Report> reports = new ArrayList<Report>();
	private Date dateID = new Date();
	
	private String[] TEMDFile;
	private String[] TEMDMSGFILE;
	private StringBuffer commandsList = new StringBuffer();
	
protected	static TemdViol TemdViolprodOScan1,TemdViolprodOScan2,TemdViolprodOScan3,TemdVioltransOScan1,TemdVioltransOScan2,TemdVioltransOScan3,TemdVioldeployOScan1,TemdVioldeployOScan2,TemdVioldeployOScan3,TemdViolprodAScan1,TemdViolprodAScan2,TemdViolprodAScan3,TemdVioltransAScan1,TemdVioltransAScan2,TemdVioltransAScan3,TemdVioldeployAScan3,TemdVioldeployAScan2,TemdVioldeployAScan1;
     static TemdMsg TemdMsgprodOScan1,TemdMsgprodOScan2,TemdMsgprodOScan3,TemdMsgtransOScan1,TemdMsgtransOScan2,TemdMsgtransOScan3,TemdMsgdeployOScan1,TemdMsgdeployOScan2,TemdMsgprodAScan1,TemdMsgdeployOScan3,TemdMsgprodAScan2,TemdMsgprodAScan3,TemdMsgtransAScan1,TemdMsgtransAScan2,TemdMsgtransAScan3,TemdMsgdeploysAScan1,TemdMsgdeploysAScan2,TemdMsgdeploysAScan3;
	public void TemdViolGenerator()
	{
		try{
			Random random = new Random();
			
		 int checkId = random.nextInt(1000);
		String checkName = "TEMCheckMsg_"+checkId;
		String checkDesc = "TEMCheckDes_"+checkId;
		String violName = "TEMViol_"+checkId;
		System.out.println("TemdViol start execution");
		TEMDFile = getRowFromCSV(TEMD_VIOL_FILE).split(TEMD_Separator, -1);
		
		TemdViolprodOScan1 = new TemdViol( TEMDFile, prodSystem1, "O", prodAppSystem1,"critical",checkName+1,checkDesc+1,violName+1 );
	    TemdViolprodOScan2 = new TemdViol(TEMDFile, prodSystem2, "O", prodAppSystem2 ,"warning",checkName+2,checkDesc+2,violName+2 );
	    TemdViolprodOScan3 = new TemdViol( TEMDFile, prodSystem3, "O", prodAppSystem3,"critical",checkName+3,checkDesc+3,violName+3 );
		
	     TemdVioltransOScan1 = new TemdViol( TEMDFile, transSystem1, "O", transAppSystem1,"critical" ,checkName+4,checkDesc+4,violName+4 );
		 TemdVioltransOScan2 = new TemdViol( TEMDFile, transSystem2, "O", transAppSystem2,"warning" ,checkName+5,checkDesc+5,violName+5 );
		 TemdVioltransOScan3 = new TemdViol( TEMDFile, transSystem3, "O", transAppSystem3 ,"critical",checkName+6,checkDesc+6,violName+6 );
		 
		 TemdVioldeployOScan1=new TemdViol( TEMDFile, deploySystem1, "O", deployAppSystem1,"critical" ,checkName+7,checkDesc+7,violName+7 );
		 TemdVioldeployOScan2=new TemdViol( TEMDFile, deploySystem2, "O", deployAppSystem2,"critical" ,checkName+8,checkDesc+8,violName+8 );
		 TemdVioldeployOScan3=new TemdViol( TEMDFile, deploySystem3, "O", deployAppSystem3,"critical" ,checkName+9,checkDesc+9,violName+9 );
		 
		reports.add(TemdViolprodOScan1);
		reports.add(TemdViolprodOScan2);
		reports.add(TemdViolprodOScan3);

		reports.add(TemdVioltransOScan1);
		reports.add(TemdVioltransOScan2);
		reports.add(TemdVioltransOScan3);
		
		reports.add(TemdVioldeployOScan1);
		reports.add(TemdVioldeployOScan2);
		reports.add(TemdVioldeployOScan3);
		
		
		TemdViolprodAScan1 = new TemdViol(TEMDFile, prodSystem1, "A", prodAppSystem1 ,"critical",checkName+1,checkDesc+1,violName+1 );
		TemdViolprodAScan2 = new TemdViol( TEMDFile, prodSystem2, "A", prodAppSystem2,"warning" ,checkName+2,checkDesc+2,violName+2 );
		TemdViolprodAScan3 = new TemdViol( TEMDFile, prodSystem3, "A", prodAppSystem3,"information" ,checkName+3,checkDesc+3,violName+3 );
		
		TemdVioltransAScan1 = new TemdViol( TEMDFile, transSystem1, "A", transAppSystem1,"critical" ,checkName+4,checkDesc+4,violName+4 );
	    TemdVioltransAScan2 = new TemdViol(TEMDFile, transSystem2, "A", transAppSystem2 ,"warning",checkName+5,checkDesc+5,violName+5 );
		TemdVioltransAScan3 = new TemdViol( TEMDFile, transSystem3, "A", transAppSystem3,"information" ,checkName+6,checkDesc+6,violName+6 );
		
		TemdVioldeployAScan1 = new TemdViol( TEMDFile, deploySystem1, "A", deployAppSystem1,"critical" ,checkName+7,checkDesc+7,violName+7);
		TemdVioldeployAScan2 = new TemdViol(TEMDFile, deploySystem2, "A", deployAppSystem2 ,"warning",checkName+8,checkDesc+8,violName+8);
		TemdVioldeployAScan3 = new TemdViol( TEMDFile, deploySystem3, "A", deployAppSystem3,"information" ,checkName+9,checkDesc+9,violName+9 );
		
		reports.add(TemdViolprodAScan1);
		reports.add(TemdViolprodAScan2);
		reports.add(TemdViolprodAScan3);

		reports.add(TemdVioltransAScan1);
		reports.add(TemdVioltransAScan2);
		reports.add(TemdVioltransAScan3);
		
		
		reports.add(TemdVioldeployAScan1);
		reports.add(TemdVioldeployAScan2);
		reports.add(TemdVioldeployAScan3);
		
		TEMDMSGFILE = getRowFromCSV(TEMD_MSG_FILE).split(TEMD_Separator, -1);
		 TemdMsgprodOScan1 = new TemdMsg( TEMDMSGFILE, prodSystem1, "O", prodAppSystem1,"critical",checkName+1,checkDesc+1 );
		 TemdMsgprodOScan2 = new TemdMsg(TEMDMSGFILE, prodSystem2, "O", prodAppSystem2 ,"warning",checkName+2,checkDesc+2 );
		 TemdMsgprodOScan3 = new TemdMsg( TEMDMSGFILE, prodSystem3, "O", prodAppSystem3,"information",checkName+3,checkDesc+3 );
		
		 TemdMsgtransOScan1 = new TemdMsg( TEMDMSGFILE, transSystem1, "O", transAppSystem1,"critical" ,checkName+4,checkDesc+4 );
		 TemdMsgtransOScan2 = new TemdMsg( TEMDMSGFILE, transSystem2, "O", transAppSystem2,"warning" ,checkName+5,checkDesc+5 );
		 TemdMsgtransOScan3 = new TemdMsg( TEMDMSGFILE, transSystem3, "O", transAppSystem3 ,"information",checkName+6,checkDesc+6 );
		 
		 TemdMsgdeployOScan1 = new TemdMsg( TEMDMSGFILE, deploySystem1, "O", deployAppSystem1,"critical" ,checkName+7,checkDesc+7 );
		 TemdMsgdeployOScan2 = new TemdMsg( TEMDMSGFILE, deploySystem2, "O", deployAppSystem2,"warning" ,checkName+8,checkDesc+8 );
		 TemdMsgdeployOScan3 = new TemdMsg( TEMDMSGFILE, deploySystem3, "O", deployAppSystem3 ,"information",checkName+9,checkDesc+9 );
		
		reports.add(TemdMsgprodOScan1);
		reports.add(TemdMsgprodOScan2);
		reports.add(TemdMsgprodOScan3);

 		reports.add(TemdMsgtransOScan1);
		reports.add(TemdMsgtransOScan2);
		reports.add(TemdMsgtransOScan3);
		
		reports.add(TemdMsgdeployOScan1);
		reports.add(TemdMsgdeployOScan2);
		reports.add(TemdMsgdeployOScan3);
		
		TemdMsgprodAScan1 = new TemdMsg(TEMDMSGFILE, prodSystem1, "A", prodAppSystem1 ,"critical",checkName+1,checkDesc+1 );
		 TemdMsgprodAScan2 = new TemdMsg( TEMDMSGFILE, prodSystem2, "A", prodAppSystem2,"warning" ,checkName+2,checkDesc+2 );
		 TemdMsgprodAScan3 = new TemdMsg( TEMDMSGFILE, prodSystem3, "A", prodAppSystem3,"information" ,checkName+3,checkDesc+3 );
		
		 TemdMsgtransAScan1 = new TemdMsg( TEMDMSGFILE, transSystem1, "A", transAppSystem1,"critical" ,checkName+4,checkDesc+4 );
		 TemdMsgtransAScan2 = new TemdMsg(TEMDMSGFILE, transSystem2, "A", transAppSystem2 ,"warning",checkName+5,checkDesc+5 );
		 TemdMsgtransAScan3 = new TemdMsg( TEMDMSGFILE, transSystem3, "A", transAppSystem3,"information" ,checkName+6,checkDesc+6 );
		 
		 TemdMsgdeploysAScan1 = new TemdMsg( TEMDMSGFILE, deploySystem1, "A", deployAppSystem1,"critical" ,checkName+4,checkDesc+4 );
		 TemdMsgdeploysAScan2 = new TemdMsg(TEMDMSGFILE, deploySystem2, "A", deployAppSystem2 ,"warning",checkName+5,checkDesc+5 );
		 TemdMsgdeploysAScan3 = new TemdMsg( TEMDMSGFILE, deploySystem3, "A", deployAppSystem3,"information" ,checkName+6,checkDesc+6 );
		 
		 
		
		reports.add(TemdMsgprodAScan1);
		reports.add(TemdMsgprodAScan2);
		reports.add(TemdMsgprodAScan3);

		reports.add(TemdMsgtransAScan1);
		reports.add(TemdMsgtransAScan2);
		reports.add(TemdMsgtransAScan3);
		
		reports.add(TemdMsgdeploysAScan1);
		reports.add(TemdMsgdeploysAScan2);
		reports.add(TemdMsgdeploysAScan3);
		
	}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void temdCreator()
	{
		boolean error = false;
		StringBuffer TemdViolReport = new StringBuffer();
		StringBuffer TemdMsgReport = new StringBuffer();
		StringBuffer resultReport;
		
		String lineSep = System.getProperty("line.separator");
		for (Report item : reports) {
			if (item instanceof TemdViol) {
				resultReport = TemdViolReport;
			}
			else
			{
				resultReport = TemdMsgReport;
			}
			for (int i = 0; i < item.getSize() - 1; i++) {
				resultReport.append(item.getField(i));
				resultReport.append(item.getSeparator());
			}
			
			resultReport.append(item.getField(item.getSize() - 1));
			resultReport.append(lineSep);
			}
		
		
		System.out.println("TEMDviol generated data:");
		System.out.println(TemdViolReport.toString());
		System.out.println("TEMDmsg generated data:");
		System.out.println(TemdMsgReport.toString());
		
		error = !writeReportToFile(getVIOLFileName(), TemdViolReport, false, "TEMDVIOL");
		error = !writeReportToFile(getMSGFileName(), TemdMsgReport, false, "TEMDMSG");
		
		System.out.println(" TEMD reports in files complete" + !error);
	}

	public void addCommand(String command) {
		String lineSep = System.getProperty("line.separator");
		commandsList.append(command);
		commandsList.append(lineSep);
	}
	
	
	public String getVIOLFileName() {
		String ID = getDate(dateID, "yyyyMMddHHmmss");
		String TEMDVIOLName = "TEMDviol." +
				"-" + TEMD_Server + "." + ID + ".csv";
		return Local_Folder_HC + File.separator + TEMDVIOLName;
	}
	public String getMSGFileName() {
		String ID = getDate(dateID, "yyyyMMddHHmmss");
		String TEMDMSGName = "TEMDmsg." +"-" + TEMD_Server + "." + ID + ".csv";
		return Local_Folder_HC + File.separator + TEMDMSGName;
	}
	
	
	
}
