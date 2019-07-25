/**
 * 
 */
package DataProvider;




/**
 * @author RAVIKUMARREDDY
 *
 */
public class WWTS extends ConfigReader implements Report{
	
	private String[] WWTSScan;
	private GacdwApplication appData;
	private GacdwInventory inventory;
	private String scanType;
	
	public WWTS(String[] wwts,GacdwInventory Inventory,String ScanType,GacdwApplication AppData)
	{
		this.WWTSScan = wwts.clone();
		this.inventory = Inventory;
		this.appData = AppData;
		this.scanType = ScanType;
		
		
		WWTSScan[1] = inventory.getCustomer();
		WWTSScan[2] = inventory.getCustomer();
		
		setField(3, COUNTRY_NAME);
		setField(4, inventory.getHostName());
		setField(5, inventory.getIPAddress());
		
		switch(scanType)
		{
		
		case "O":   setField(8, scanType);
					//setField(9,appData.getField(4));
					setField(13, "POLITEM_O");
					break;
		
		case "A":   setField(8, scanType);
					//setField(9, "SAP");
					setField(9,appData.getField(4));
					setField(10,appData.getField(3));
					setField(11,appData.getField(2));
					setField(13, "POLITEM_A");
					break;
					
		case "I":  setField(8, scanType);
				   setField(9,appData.getField(10));
				   setField(10,appData.getField(5));
				   setField(11,appData.getField(3));
				   setField(13, "POLITEM_A");
				   break;
				   
		}
		
		setField(12, getDate("yyyyMMdd"));
		
		String CheckID = "WWTSCheckID@" + generateRandomNumber(4);
		String CheckMsg = "WWTSCheckMessage@" + generateRandomNumber(4);
		String CheckDesc = "WWTSCheckDesc@" + generateRandomNumber(4);
		String Voilation = "WWTSVoilation@" + generateRandomNumber(4);
		
		setField(17, CheckID);
		setField(18, CheckDesc);
		setField(20, CheckMsg);
		setField(21, Voilation);
		
		
	}

	public void setField(int index, String value) {
		WWTSScan[index] =  value ;
	}
	
	public String getField(int index) {
		return WWTSScan[index];
	}
	
	public int getSize() {
		return WWTSScan.length;
	}
	
	public String getSeparator() {
		return WWTS_Separator;
	}

}
