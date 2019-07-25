/**
 * 
 */
package DataProvider;

import java.util.Date;
import java.util.Random;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class AUCU extends ConfigReader implements Report{
	
	private String[] aucu;
	private GacdwApplication appData;
	private GacdwInventory inventory;
	private String scanType;
	
	public AUCU(String[] aucu,GacdwInventory Inventory,String ScanType,GacdwApplication AppData)
	{
		this.aucu = aucu.clone();
		this.inventory = Inventory;
		this.appData = AppData;
		this.scanType = ScanType;
		
		
		/*aucu[5] = inventory.getCustomer();
		aucu[6] = inventory.getCustomer();*/
		
		setField(5,inventory.getCustomer());
		setField(6,inventory.getCustomer());
		
		setField(1, COUNTRY_NAME);
		setField(2,"AUjj "+ COUNTRY_NAME);
		setField(3,"CUgg "+ COUNTRY_NAME);
		
		setField(4, COUNTRY_ID);
		
	}

	public void setField(int index, String value) {
		aucu[index] =  value ;
	}
	
	public String getField(int index) {
		return aucu[index];
	}
	
	public int getSize() {
		return aucu.length;
	}
	
	public String getSeparator() {
		return AUCU_Separator;
	}

}
