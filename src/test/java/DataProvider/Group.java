package DataProvider;

public class Group extends ConfigReader implements Report {

	
	private String[] GroupScan;
	private GacdwApplication appData;
	private GacdwInventory inventory;
	private String scanType;
//	private WWTS wwts;
	
	public Group(String[] Group,GacdwInventory Inventory,String ScanType,GacdwApplication AppData)
	{
		this.GroupScan = Group.clone();
		this.inventory = Inventory;
		this.appData = AppData;
		this.scanType = ScanType;
		
		
		setField(1, ScanType);
		setField(3,Group_NAME);
		GroupScan[4] = inventory.getCustomer();
		GroupScan[5] = inventory.getCustomer();
		
		//setField(3, COUNTRY_NAME);
		setField(6, inventory.getHostName());
		setField(7, appData.getField(4));
		
	}

	private void setField(int index, GacdwApplication appData2) {
		// TODO Auto-generated method stub
		
	}

	public void setField(int index, String value) {
		GroupScan[index] =  value ;
	}
	
	public String getField(int index) {
		return GroupScan[index];
	}
	
	public int getSize() {
		return GroupScan.length;
	}
	
	public String getSeparator() {
		return Group_Separator;
	}

}
