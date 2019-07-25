/**
 * 
 */
package Utility;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class Reports {

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void setUp()
	{
		reporter = new ExtentHtmlReporter("./OutPut/extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.fail(MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			logger.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.pass(MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
			logger.pass(result.getThrowable());
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}
}
