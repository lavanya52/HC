package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class TopFindings_Message_Page {

	WebDriver driver;
	public TopFindings_Message_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	@FindAll({@FindBy(how = How.XPATH, using = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr")})
	List<WebElement> rowsizeAll;
	@FindAll({@FindBy(how = How.XPATH, using = "html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/table[2]/tbody[1]/tr")})
	List<WebElement> custSizeAll;

	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Download CSV document']")
	WebElement downloadCSV_Systems;
	
	@FindBy(how = How.XPATH, using = "//a[@id='ibm-tooltip-2']")
	WebElement systems;
	
	public int getRowSizeAll_sys()
	{
		return rowsizeAll.size();
	}
	public int getCustSizeAll_sys()
	{
		return rowsizeAll.size();
	}
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
	

}
