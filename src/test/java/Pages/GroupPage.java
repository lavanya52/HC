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

public class GroupPage {
	

	WebDriver driver;

	public GroupPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='imtcountry']")
	WebElement IOTIMTCountry;
	
	@FindBy(how = How.XPATH, using = "//*[@id='filterform']/p[4]/input[2]")
	WebElement GenerateBurron;
	
	
	
	
	public void getIoTIMTCountry() {
		Select server = new Select(IOTIMTCountry);
		server.selectByValue("1");

	}

	public WebElement getGenerateReportButton() {
		return GenerateBurron;
	}

}
