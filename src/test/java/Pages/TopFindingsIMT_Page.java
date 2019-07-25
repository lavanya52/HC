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
public class TopFindingsIMT_Page {
	WebDriver driver;
	public TopFindingsIMT_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='countryID']")
	WebElement IMTContry;
	
	@FindBy(how = How.XPATH, using = "//*[@id='inter']")
	WebElement Interface;
	
	////*[@id="reportedSystem"]
	
	@FindBy(how = How.XPATH, using = "//*[@id='reportedSystem']")
	WebElement ReportedSystem;
	@FindBy(how = How.XPATH, using = "//*[@id='rs0']")
	WebElement server;
	@FindBy(how = How.XPATH, using = "//*[@id='rs1']")
	WebElement network;
	@FindBy(how = How.XPATH, using = "//*[@id='rs2']")
	WebElement stroage;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='filterform']/p[8]/input")
	WebElement GenerateBurron;
	@FindBy(how = How.XPATH, using = "//a[text()='Download CSV document']")
	WebElement downloadCSV;
	@FindBy(how = How.XPATH, using = "//*[@id='sysState']")
	WebElement SystemState;
	
	@FindBy(how = How.XPATH, using = "//*[@id='osfamily']")
	WebElement OSFamily;
	
	//*[@id="osfamily"]/option[2]
	
	@FindBy(how = How.XPATH, using = "//*[@id='osfamily']/option[2]")
	WebElement mf;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ibm-tooltip-1']")
	WebElement downloadCSV_Systems;
	
	@FindBy(how = How.XPATH, using = "//a[@id='ibm-tooltip-2']")
	WebElement systems;
	@FindBy(how = How.XPATH, using = "//*[@id='ibm-content-main']/div[4]/div/table[1]/thead/tr/th[3]")
	WebElement CheckName;
	@FindBy(how = How.XPATH, using = "//*[@id='ibm-content-main']/div[4]/div/table[1]/thead/tr/th[4]")
	WebElement CheckDescription;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[1]/tbody[1]/tr")})
	List<WebElement> rowsizeAll;
	
	@FindAll({@FindBy(how = How.XPATH, using = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/table[1]/tbody[1]/tr")})
	List<WebElement> rowsize;
	
	public void getSystems()
	{
		JavascriptExecutor Je3 = (JavascriptExecutor) driver;
		Je3.executeScript("arguments[0].click();", systems);
	}
	public void getDownloadCSVSystems()
	{
		JavascriptExecutor Je3 = (JavascriptExecutor) driver;
		Je3.executeScript("arguments[0].click();", downloadCSV_Systems);
	}
	
	
	public void getDownloadCSV()
	{
		JavascriptExecutor Je3 = (JavascriptExecutor) driver;
		Je3.executeScript("arguments[0].click();", downloadCSV);
	}
	public void getAllSystemState()
	{
		Select all = new Select(SystemState);
		all.selectByValue("all");
	}
	public void getTransition()
	{
		Select all = new Select(SystemState);
		all.selectByValue("Transition");
	}
	
	public void getDeployment()
	{
		Select deploy = new Select(SystemState);
		deploy.selectByValue("Deployment");
	}
	public void getDistributed()
	{
		Select dis = new Select(OSFamily);
		dis.selectByValue("1");
	}
	public void getMainframe()
	{
		Select mf = new Select(OSFamily);
		mf.selectByValue("2");
	}
	
	public void getimtCountry() {
		Select wwts = new Select(IMTContry);
		wwts.selectByValue("2MEA-kw");

	}
	public void getWWTS() {
		Select wwts = new Select(Interface);
		wwts.selectByValue("WWTS");

	}
	public void getTemd() {
		Select temd = new Select(Interface);
		temd.selectByValue("TEM");

	}
	public int getRowSizeAll()
	{
		return rowsizeAll.size();
	}

	public int getRowSize()
	{
		return rowsize.size();
	}
	
	public void getServer() {
		Select server = new Select(ReportedSystem);
		server.selectByValue("0");

	}
	public void getNetwork() {
		Select net = new Select(ReportedSystem);
		net.selectByValue("1");

	}
	public void getStorage() {
		Select sto = new Select(ReportedSystem);
		sto.selectByValue("2");

	}
	public void getSSD() {
		Select ssd = new Select(ReportedSystem);
		ssd.selectByValue("4");

	}
	public void getAllDevices() {
		Select all = new Select(ReportedSystem);
		all.selectByValue("3");

	}
	
	
	

	public WebElement getGenerateReportButton() {
		return GenerateBurron;
	}
	
	public WebElement getmf() {
		return mf;
	}

	public WebElement getCheckName() {
		return CheckName;
	}
	
	
	public WebElement getCheckDescription() {
		return CheckDescription;
	}
}




