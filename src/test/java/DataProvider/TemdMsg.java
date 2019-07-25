package DataProvider;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class TemdMsg extends ConfigReader implements Report {
	private String[] temdMsg;
	/*private SesdrApplication appData;
	private SesdrInventory inventory;*/
	private GacdwInventory inventory;
	private GacdwApplication appData;
	private String scanType;
	private String  checkmsg;
	private String checkDesc;

	public TemdMsg(String[] TemdMsg,GacdwInventory Inventory,String ScanType,GacdwApplication AppData,String Priority,String  CheckMsg,String CheckDesc)
	{
	this.temdMsg = TemdMsg.clone();
	this.inventory = Inventory;
	this.appData = AppData;
	this.scanType = ScanType;
	this.checkmsg=CheckMsg;
	this.checkDesc=CheckDesc;

	
	temdMsg[3] = inventory.getCustomer();
	switch(scanType)
	{
	
	case "O":   setField(5, scanType);
            	setField(4, "AIX POL_O");
	
				break;
	
	case "A":   setField(5, scanType);
				setField(4, "AIX POL_A");
				break;
				
	case "I":  setField(5, scanType);
			   setField(4, "AIX POL_I");
			   break;
			   
	}
	 setField(6,appData.getField(10));
	setField(7, this.checkmsg);
	setField(8,	this.checkDesc);
	setField(9, Priority);
}

public void setField(int index, String value) {
	temdMsg[index] =  value ;
}
public String getField(int index) {
	return temdMsg[index];
}

public int getSize() {
	return temdMsg.length;
}

public String getSeparator() {
	return TEMD_Separator;
}


}
