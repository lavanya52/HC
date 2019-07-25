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
 * @author LAVANYA
 *
 */

public class TopFindings_Page {
	WebDriver driver;
	public TopFindings_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='customerID']")
	WebElement custmerName;
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
	
	@FindBy(how = How.XPATH, using = "//*[@id='ibm-content-main']/div[4]/div/table/thead/tr/th[3]")
	WebElement Checkexp;
	@FindBy(how = How.XPATH, using = "//*[@id='ibm-content-main']/div[4]/div/table/thead/tr/th[4]")
	WebElement CheckId;
	@FindAll({@FindBy(how = How.XPATH, using = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr")})
	List<WebElement> rowsizeAll;
	
	public void getSystems()
	{
		JavascriptExecutor Je4 = (JavascriptExecutor) driver;
		Je4.executeScript("arguments[0].click();", systems);
	}
	public void getDownloadCSVSystems()
	{
		JavascriptExecutor Je4 = (JavascriptExecutor) driver;
		Je4.executeScript("arguments[0].click();", downloadCSV_Systems);
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
	
	public WebElement getImtCustomer() {
		return custmerName;
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
/*	public void getServer()
	{
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", server);
		
	}
	
	public void getNetwork()
	{
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", network);
		
	}
	
	public void getStorage()
	{
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", stroage);
		
	}*/

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
	public WebElement getCheckExp() {
		return Checkexp;
	}
	
	
	public WebElement getChekID() {
		return CheckId;
	}
}




