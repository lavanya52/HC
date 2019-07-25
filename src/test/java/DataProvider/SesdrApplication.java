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
public class SesdrApplication extends ConfigReader implements Report{
	
	private String[] appData;
	private SesdrInventory inventoryData;
	private String instName;
	private String appName;
	private String appType;
	private String HCMatch;
	private int appSubSystemID;
	private String customerID;
	
	public SesdrApplication(String[] appLoad, SesdrInventory inv, String HCMatch)
	{
		this.appData = appLoad.clone();
		this.inventoryData = inv;
		this.HCMatch = HCMatch;
		
		customerID = COUNTRY_ID + "_" + CUSTOMER_NAME;
		
		setField(1, inventoryData.getSystemID());
		
		this.appSubSystemID = (new Random()).nextInt(100000000);
		setField(2, getSubSystemID());
		
		this.instName = CUSTOMER_NAME + InsName_PREFIX + generateRandomString(2);
		setField(3, instName);
		
		
		this.appName = CUSTOMER_NAME + AppName_PREFIX + generateRandomString(2);
		setField(5, appName);
		
		setField(6, inventoryData.getIPAddress());
		
		setField(10, App_Type[0]);
		
		switch (HCMatch) {
		case "A":
			setField(36, "APPLICATION");
			setField(37, "APPLICATION");
			break;
		case "I":
			setField(36, "INSTANCE");
			setField(37, "INSTANCE");
			break;
		case "AI":
			setField(36, "APPLICATION");
			setField(37, "INSTANCE");
			break;
		case "IA":
			setField(36, "INSTANCE");
			setField(37, "APPLICATION");
			break;	
		
		}
		
		setField(39, System_Owner);
		
		setField(66, getDate(inventoryData.getInvDate(), "yyyy-MM-dd"));
		
		setField(66, getDate(inventoryData.getInvDate(), "yyyy-MM-dd-hh.mm.ss.SSSSSS"));
		
		setField(57, customerID);
		setField(58, customerID);
		setField(59, customerID);
		
	}
	
	private String getSubSystemID() {
		return String.valueOf(appSubSystemID);
	}

	public void setField(int index, String value) {
		appData[index] = CSV_Quote + value + CSV_Quote;
	}

	public String getField(int index) {
		return appData[index];
	}

	public int getSize() {
		return appData.length;
	}

	public String getSeparator() {
		return SESDR_Separator;
	}
	
	

}
