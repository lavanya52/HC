package DataProvider;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class TemdViol extends ConfigReader implements Report {

	private String[] temdVio;
/*	private SesdrApplication appData;
	private SesdrInventory inventory; */
	private GacdwInventory inventory;
	private GacdwApplication appData;
	private String scanType;
	private String priority;
	private String  checkmsg;
	private String checkDesc;
	private String voilation;
	
	public TemdViol(String[] TemdVio,GacdwInventory Inventory,String ScanType,GacdwApplication AppData,String Priority,String  CheckMsg,String CheckDesc,String Voilation)
	{
		this.temdVio = TemdVio.clone();
		this.inventory = Inventory;
		this.appData = AppData;
		this.scanType = ScanType;
		this.checkmsg=CheckMsg;
		this.checkDesc=CheckDesc;
		this.voilation=Voilation;
		this.priority=Priority;
		
		
		temdVio[3] = inventory.getCustomer();
		temdVio[4] = inventory.getCustomer();
		
		setField(5, COUNTRY_NAME);
		setField(6, inventory.getHostName());
		setField(8, inventory.getIPAddress());
		
		switch(scanType)
		{
		
		case "O":   setField(11, scanType);
              	setField(17, "AIX POL_O");
					break;
		
		case "A":   setField(11, scanType);
					setField(13,appData.getField(4));
					setField(14,appData.getField(3));
             		setField(15,appData.getField(2));
            		setField(17, "AIX POL_A");
					break;
					
		case "I":   setField(11, scanType);
	           	   setField(13,appData.getField(4));
	           	   setField(14,appData.getField(3));
	           	   setField(15,appData.getField(2));
	           	   setField(17, "AIX POL_I");
				   break;
				   
		}
		setField(16, getDate(inventory.getInvDate(), "yyyy-MM-dd-hh.mm.ss.SSSSSS"));
		setField(19,this.priority);
		setField(20,this.checkmsg);
		setField(21, this.checkDesc);
		
		setField(23, this.voilation);
		
		
	}

	public void setField(int index, String value) {
		temdVio[index] =  value ;
	}
	
	public String getField(int index) {
		return temdVio[index];
	}
	
	public int getSize() {
		return temdVio.length;
	}
	
	public String getSeparator() {
		return TEMD_Separator;
	}
}
