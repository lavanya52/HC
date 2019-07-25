/**
 * 
 */
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
public class HCApp_NonProd_Overview_Page {

	WebDriver driver;

	public HCApp_NonProd_Overview_Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//select[@id='sectorID']")
	WebElement sector;

	@FindBy(how = How.XPATH, using = "//select[@id='imtcountry']")
	WebElement iot_imt;

	@FindBy(how = How.XPATH, using = "//select[@id='sysState']")
	WebElement systemState;

	@FindBy(how = How.XPATH, using = "//select[@id='reportedSystem']")
	WebElement reportedSystem;

	@FindBy(how = How.XPATH, using = "//select[@id='accountType']")
	WebElement accountType;

	@FindBy(how = How.XPATH, using = "//select[@id='osfamily']")
	WebElement osfamily;
	
	@FindBy(how = How.XPATH, using = "//select[@id='appliID']")
	WebElement appFamily;
	
	@FindBy(how = How.XPATH, using = "//input[@class='ibm-btn-arrow-pri']")
	WebElement generateButton;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Download CSV document']")
	WebElement downloadCSV;
	
	@FindBy(how = How.LINK_TEXT, using = "Download complete CSV document")
	WebElement completeCSV;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr")})
	List<WebElement> rowsizeAll;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[1]/tbody/tr[1]")})
	List<WebElement> rowsizeIOTAll;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[5]/div/table[2]/tbody/tr")})
	List<WebElement> custSizeAll;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[1]/tbody/tr")})
	List<WebElement> rowsizeImt;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[6]/div/table[2]/tbody/tr")})
	List<WebElement> custSize;

	public void getSector() {
		Select selectedSector = new Select(sector);
		selectedSector.selectByVisibleText("NA IMI");

	}

	public void getAllIMT() {
		Select allIMT = new Select(iot_imt);
		allIMT.selectByValue("1");

	}

	public void getSingleIOT() {
		Select singleIOT = new Select(iot_imt);
		singleIOT.selectByValue("3NORTH_AM-IOT");

	}

	public void getSingleIOT_IMT() {
		Select singleIOT_IMT = new Select(iot_imt);
		singleIOT_IMT.selectByValue("1UNITED_STATES");

	}

	public void getSingleIOT_IMT_Country() {
		Select singleIOT_IMT_Country = new Select(iot_imt);
		singleIOT_IMT_Country.selectByValue("2UNITED_STATES-us");

	}

	public void getTransitionState() {
		Select transition = new Select(systemState);
		transition.selectByValue("Transition");
	}

	public void getDeploymentState() {
		Select deployment = new Select(systemState);
		deployment.selectByValue("Deployment");
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
	
	public void getAccountType() {
		Select all = new Select(accountType);
		all.selectByValue("all");

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
	
	public void getOsAppFamily() {
		Select OS = new Select(appFamily);
		OS.selectByValue("4SAP");
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
	
	public void getCompleteCSV()
	{
		JavascriptExecutor Je3 = (JavascriptExecutor) driver;
		Je3.executeScript("arguments[0].click();", completeCSV);
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
