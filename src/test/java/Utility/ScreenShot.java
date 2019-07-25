/**
 * 
 */
package Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DataProvider.ConfigReader;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class ScreenShot extends ConfigReader{

	public static void captureScreenshot(WebDriver driver, String screenshotName)

	{
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File SS = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(SS, new File("./OutPut/" + screenshotName + ".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			System.out.println("Exception while taking screenshot--- " + e.getMessage());
		}

	}

}
