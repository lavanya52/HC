package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class HC_AUCU_Overview_Page {
	WebDriver driver;

	public HC_AUCU_Overview_Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//select[@id='aucu']")
	WebElement aucu;

	@FindBy(how = How.XPATH, using = "//select[@id='reportedSystem']")
	WebElement reportedSystem;

	@FindBy(how = How.XPATH, using = "//select[@id='appliID']")
	WebElement FamilyApplication;

	@FindBy(how = How.XPATH, using = "//select[@id='osfamily']")
	WebElement osfamily;
	
	@FindBy(how = How.XPATH, using = "//input[@class='ibm-btn-arrow-pri']")
	WebElement generateButton;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Download CSV document']")
	WebElement downloadCSV;
	
	
	
	@FindAll({@FindBy(how = How.XPATH, using = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/table[1]/tbody[1]/tr")})
	List<WebElement> rowsizeAll;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[1]/tbody/tr[1]")})
	List<WebElement> rowsizeIOTAll;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr")})
	List<WebElement> custSizeAll;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr")})
	List<WebElement> rowsizeImt;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/table[3]/tbody[1]/tr")})
	List<WebElement> custSize;

	

	public void getAllSummary() {
		Select server = new Select(FamilyApplication);
		server.selectByValue("0");

	}	
	public void getAllFamilies() {
		Select server = new Select(FamilyApplication);
		server.selectByValue("1");

	}
	
	public void getBusinessmgtSAP() {
		Select server = new Select(FamilyApplication);
		server.selectByValue("4SAP");

	}
	
	public void getBusinessmgtAll() {
		Select server = new Select(FamilyApplication);
		server.selectByValue("2Business management");

	}

	public void getaucuIMT() {
		Select transition = new Select(aucu);
		transition.selectByValue("2AU FRANCE---CU FRANCE");
	}

	public void getauAllIMT() {
		Select deployment = new Select(aucu);
		deployment.selectByValue("1AU FRANCE");
	}

	public void getServer() {
		Select server = new Select(reportedSystem);
		server.selectByValue("0");

	}
	
	public void getNetworkDevices() {
		Select network = new Select(reportedSystem);
		network.selectByValue("1");

	}
	
	public void getStorageDevices() {
		Select storage = new Select(reportedSystem);
		storage.selectByValue("2");

	}
	
	public void getAllExceptNetwork() {
		Select allExceptNetwork = new Select(reportedSystem);
		allExceptNetwork.selectByValue("4");

	}
	
	public void getAllDevices() {
		Select all = new Select(reportedSystem);
		all.selectByValue("3");

	}
	
	
	
	public void getOsFamilyDistributed() {
		Select OS = new Select(osfamily);
		OS.selectByValue("1");
	}
	
	public void getOsFamilyMainframe() {
		Select OS = new Select(osfamily);
		OS.selectByValue("2");
	}
	
	public void getOsFamilyAll() {
		Select OS = new Select(osfamily);
		OS.selectByValue("0");
	}
	
	public void getGenerateButton() {
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", generateButton);
	}
	
	public void getDownloadCSV()
	{
		JavascriptExecutor Je3 = (JavascriptExecutor) driver;
		Je3.executeScript("arguments[0].click();", downloadCSV);
	}
	
	
	
	public int getRowSizeAll()
	{
		return rowsizeAll.size();
	}
	
	public int getRowSizeIOTAll()
	{
		return rowsizeIOTAll.size();
	}
	
	
	public int getRowSizeImt()
	{
		return rowsizeImt.size();
	}
		
	public int getCustSize()
	{
		return custSize.size();
	}
	
	public int getCustSizeAll()
	{
		return custSizeAll.size();
	}
}
