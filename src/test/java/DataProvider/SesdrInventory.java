/**
 * 
 */
package DataProvider;

import java.util.Date;
import java.util.Random;

/**
 * @author Nive
 *
 */
public class SesdrInventory extends ConfigReader implements Report{
	

	private String[] inventoryData;
	private Date dateID;
	private boolean systemStatus;
	private String customerID;
	private String hostName;
	private String IPAddress;
	private int systemID;

	public SesdrInventory(String[] inventoryLoad, Date dateID, boolean status, int scenario,String ReportedFamily)
	{
		this.inventoryData = inventoryLoad.clone();
		this.dateID = dateID; 
		this.systemStatus = status;
		
		//Customer ID & Customer Name
		customerID = COUNTRY_ID + "_" + CUSTOMER_NAME;
		setField(2,customerID);
		setField(3, customerID);

		String ID = getDate(this.dateID, "MMddhhmm") + generateRandomString(2);
		hostName = HOSTNAME_PREFIX + ID;
		setField(6, hostName);
		
		this.IPAddress = String.valueOf((new Random()).nextInt(10)) + "." + String.valueOf((new Random()).nextInt(10)) + "." + String.valueOf((new Random()).nextInt(100)) + "." + String.valueOf((new Random()).nextInt(100));
		setField(9, IPAddress);
		
		this.systemID = (new Random()).nextInt(100000000);
		setField(12, String.valueOf(systemID));
		
		if (systemStatus) {
			setField(13, "ACTIVE");
		} else {
			setField(13, "TRANSITION");
		}
		
		setField(15, getDate("yyyy-MM-dd"));
		setField(16, getDate("yyyy-MM-dd"));
		setField(17, getDate("yyyy-MM-dd"));
		
		setField(54, System_Owner);
		setField(55, System_Owner);
		
		setField(58, ReportedFamily);
		setField(59, ReportedFamily);
		
		setField(94,"YES");
		setField(95,"YES");
		setField(96,"YES");
		
		switch(scenario){
		case 1 :
			setField(7,"WINDOWS SERVER 2003 STANDARD 5.2..SP2");
			setField(8,"WIN");
			setField(92, "NOT CLOUD");
			setField(93, "DISTRIBUTED");
			break; 

		case 2 :
			setField(7,"Z/VM");
			setField(8,"Z/VM 6.3.0.");  
			setField(93,"MAIN_FRAME"); 
			break; 

		case 3 :

			setField(7,"3COM_OS 3.3.2.S168");
			setField(8,"OIS");
			setField(92, "CMS");
			setField(93, "");
			break;

		case 4 :

			setField(7,"DS3400 FW 7.35.66.0");
			setField(8,"STORAGE");
			setField(92, "OTHER");
			setField(93, "DISTRIBUTED");
			break;


		default : //Optional
			//Statements
		}
		
	}
	public void setField(int index, String value) {
		inventoryData[index] = CSV_Quote + value + CSV_Quote;
	}
	
	public String getHostName() {
		return hostName;
	}
	public String getField(int index) {
		return inventoryData[index];
	}
	
	public int getSize() {
		return inventoryData.length;
	}
	
	public String getSeparator() {
		return SESDR_Separator;
	}
	
	public String getSystemID() {
		return String.valueOf(systemID);
	}
	
	public String getIPAddress() {
		return IPAddress;
	}
	
	public Date getInvDate() {
		return dateID;
	}
}
