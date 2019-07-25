package DataProvider;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.openqa.selenium.WebDriver;


/**
 * @author RAVIKUMARREDDY
 *
 */
public class ConfigReader {

	private final static String propertyFilePath = "Data//config.properties";

	protected static final String Local_Folder_SESDR = getMainFolder() + File.separator	+ loadProperty("LocalFolderSesdr");
	protected static final String Local_Folder_GACDW = getMainFolder() + File.separator	+ loadProperty("LocalFolderGacdw");
	protected static final String Local_Folder_HC = getMainFolder() + File.separator + loadProperty("LocalFolderHC");

	protected static final String IP_ADDRESS = loadProperty("ServerIP");
	protected static final String COUNTRY_ID = loadProperty("CountryID");
	protected static final String COUNTRY_NAME = loadProperty("CountryName");
	protected static final String IMT_COUNTRY = loadProperty("IMTcountry");
	protected static final String CUSTOMER_NAME = loadProperty("CustomerName");

	protected static final String CSV_Quote = loadProperty("CSVQuote");
	protected static final String HOSTNAME_PREFIX = loadProperty("HostnamePrefix");
	protected static final String AppName_PREFIX = loadProperty("AppNamePrefix");
	protected static final String InsName_PREFIX = loadProperty("InsNamePrefix");
	protected static final String[] App_Type = loadProperty("ApplicationType").split(",");
	protected static final String System_Owner = loadProperty("SystemOwner");

	protected static final String ECM_SSH_Login = loadProperty("ECMSSHLogin");
	protected static final String ECM_SSH_Password = loadProperty("ECMSSHPass");
	protected static final String Web_Login = loadProperty("WebUserName");
	protected static final String Web_Password = loadProperty("WebPassword");

	protected static final String Group_NAME = loadProperty("GroupName");
	protected static final String Group_File = loadProperty("GroupFile");
	protected static final String Group_Separator = loadProperty("GroupSeparator");
	
	protected static final String SESDR_FILE = loadProperty("SESDRv14File");
	protected static final String SESDR_APP_FILE = loadProperty("SESDRAppFile");
	protected static final String SESDR_Separator = loadProperty("SESDRSeparator");

	protected static final String GACDW_FILE = loadProperty("GACDWFile");
	protected static final String GACDW_APP_FILE = loadProperty("GACDWAppFile");
	protected static final String GACDW_Separator = loadProperty("GACDWSeparator");
	
	protected static final String AUCU_File = loadProperty("AUCUFile");
	protected static final String AUCU_COMMANDS_FILE = loadProperty("AUCUCommandsFile");
	protected static final String AUCU_OUTPUT_FILE = loadProperty("AUCUOutputName");
	protected static final String AUCU_SERVER = loadProperty("AUCUServer");
	protected static final String AUCU_Separator = loadProperty("AUCUSeperator");

	protected static final String SSH_COMMANDS_FILE = loadProperty("SSHCommandsFile");
	protected static final String SSH_OUTPUT_NAME = loadProperty("SSHOutputName");
	
	protected static final String CSV_Separator = loadProperty("CSVSeparator");
	
	protected static final String Scan_Type_WWTS = loadProperty("ScanType_WWTS");
	protected static final String Scan_Type_TEMD = loadProperty("ScanType_TEMD");
	
	protected static final String WWTS_File = loadProperty("WWTSFile");
	protected static final String WWTS_COMMANDS_FILE = loadProperty("WWTSCommandsFile");
	protected static final String WWTS_OUTPUT_FILE = loadProperty("WWTSOutputName");
	protected static final String WWTS_SERVER = loadProperty("WWTSServer");
	protected static final String WWTS_Separator = loadProperty("WWTSSeperator");
	
	protected static final String TEMD_VIOL_FILE = loadProperty("TemdViolFile");
	protected static final String TEMD_MSG_FILE = loadProperty("TemdMSGFile");
	protected static final String TEMD_Separator = loadProperty("TEMDSeperator");
	protected static final String TEMD_Server = loadProperty("TemdServer");
	protected static final String TEMD_COMMANDS_FILE = loadProperty("TemdCommandsFile");
	protected static final String TEMD_OUTPUT_NAME = loadProperty("TemdOutputName");
	
	protected static final String[] CSV_Column_HCTop_IMT = loadProperty("CsvColumnsTopFindingsIMT").split(",");
	protected static final String[] Web_Column_HCTop_IMT = loadProperty("WebColumnsTopFindingsIMT").split(",");
	protected static final String[] CSV_Column_HCTopMsg_IMT = loadProperty("CsvColumnsTopFindingsIMTMsg").split(",");
	protected static final String[] Web_Column_HCTopMsg_IMT = loadProperty("WebColumnsTopFindingsIMTMsg").split(",");
	
	protected static final String[] CSV_Column_HCTop_IMT_TEMD = loadProperty("CsvColumnsTopFindingsIMTTEMD").split(",");
	protected static final String[] Web_Column_HCTop_IMT_TEMD = loadProperty("WebColumnsTopFindingsIMTTEMD").split(",");
	protected static final String[] CSV_Column_HCTopMsg_IMT_TEMD = loadProperty("CsvColumnsTopFindingsIMTMsgTEMD").split(",");
	protected static final String[] Web_Column_HCTopMsg_IMT_TEMD = loadProperty("WebColumnsTopFindingsIMTMsgTEMD").split(",");
	
	protected static final String[] CSV_Column_HCCUST = loadProperty("HC_CUST_csvcolumns").split(",");
	protected static final String[] Web_Column_HCCUST = loadProperty("HC_CUST_webcolumns").split(",");
	protected static final String[] CSV_Column_DOWNLOAD_HCCUST = loadProperty("HC_CUST_Download_csvcolumns").split(",");
	protected static final String[] Web_Column_DOWNLOAD_HCCUST = loadProperty("HC_CUST_Download_webcolumns").split(",");
	protected static final String[] CSV_Column_HCCUST_country = loadProperty("HC_CUST_SUMMARY_CsvColumns").split(",");
	protected static final String[] Web_Column_HCCUST_country = loadProperty("HC_CUST_SUMMARY_WebColumns").split(",");
	protected static final String[] CSV_Column_DOWNLOAD_HCCUST_country = loadProperty("HC_CUST_Dowload_SUMMARY_CsvColumns").split(",");
	protected static final String[] Web_Column_DOWNLOAD_HCCUST_country = loadProperty("HC_CUST_Download_SUMMARY_WebColumns").split(",");
	
	
	protected static final String[] HC_Cust_NonProd_Web_Column = loadProperty("HC_Cust_NonProd_WebColumns").split(",");
	protected static final String[] HC_Cust_NonProd_CSV_Column = loadProperty("HC_Cust_NonProd_CsvColumns").split(",");
	protected static final String[] HC_Cust_NonProd_Web_Column_Country = loadProperty("HC_Cust_NonProd_WebColumnsCountry").split(",");
	protected static final String[] HC_Cust_NonProd_CSV_Column_Country = loadProperty("HC_Cust_NonProd_CsvColumnsCountry").split(",");
	protected static final String[] HC_Cust_NonProd_TRANS_Web_Column_Country = loadProperty("HC_Cust_NonProd_Trans_WebColumnsCountry").split(",");
	protected static final String[] HC_Cust_NonProd_TRANS_CSV_Column_Country = loadProperty("HC_Cust_NonProd_Trans_CsvColumnsCountry").split(",");
	
	protected static final String[] HC_Cust_NonProd_Complt_Web_Column = loadProperty("HC_Cust_NonProd_CompltWebColumns").split(",");
	protected static final String[] HC_Cust_NonProd_Complt_CSV_Column = loadProperty("HC_Cust_NonProd_CompltCsvColumns").split(",");
	protected static final String[] HC_Cust_NonProd_Complt_Web_Column_Country = loadProperty("HC_Cust_NonProd_CompltWebColumnsCountry").split(",");
	protected static final String[] HC_Cust_NonProd_Complt_CSV_Column_Country = loadProperty("HC_Cust_NonProd_CompltCsvColumnsCountry").split(",");
	protected static final String[] HC_Cust_NonProd_TRANS_Complt_Web_Column_Country = loadProperty("HC_Cust_NonProd_Trans_CompltWebColumnsCountry").split(",");
	protected static final String[] HC_Cust_NonProd_TRANS_Complt_CSV_Column_Country = loadProperty("HC_Cust_NonProd_Trans_CompltCsvColumnsCountry").split(",");
	
	protected static final String[] CSV_Column_HC_Cust = loadProperty("HC_Complete_CSvCol").split(",");
	protected static final String[] Web_Column_HCO_Cust = loadProperty("HC_Complete_webCol").split(",");
	protected static final String[] CSV_Column_Country_HCO_Cust = loadProperty("HC_Complete_Sum_csvCol").split(",");
	protected static final String[] Web_Column_Country_HCO_Cust= loadProperty("HC_Complete_Sum_webCol").split(",");
	protected static final String[] CSV_Column_HCO_Cust_SUM = loadProperty("HC_CUST_SUM_Complete_CSvCol").split(",");
	protected static final String[] Web_Column_HCO_Cust_SUM= loadProperty("HC_CUST_SUM_Complete_webCol").split(",");
	
	protected static final String[] CSV_Column_HCTop_Table1 = loadProperty("CsvColumnsTopFindings_msg").split(",");
	protected static final String[] Web_Column_HCTop_Table1 = loadProperty("WebColumnsTopFindings_msg").split(",");
	protected static final String[] CSV_Column_HCTop_Table1_TEMD = loadProperty("CsvColumnsTopFindings_msg_TEMD").split(",");
	protected static final String[] Web_Column_HCTop_Table1_TEMD = loadProperty("WebColumnsTopFindings_msg_TEMD").split(",");
	protected static final String[] CSV_Column_HCTop = loadProperty("CsvColumnsTopFindings").split(",");
	protected static final String[] Web_Column_HCTop = loadProperty("WebColumnsTopFindings").split(",");
	protected static final String[] CSV_Column_HCTop_Table2 = loadProperty("CSVColumnsTopFIndindingsTable2").split(",");
	protected static final String[] Web_Column_HCTop_Table2 = loadProperty("WebColumnsTopFIndindingsTable2").split(",");
	
	
	/*protected static final String[] CSV_Column = loadProperty("CsvColumns").split(",");
	protected static final String[] Web_Column = loadProperty("WebColumns").split(",");
	
	
	*/
	
	protected static final String[] CSV_Column_HCO = loadProperty("CsvColumnsHCOver").split(",");
	protected static final String[] Web_Column_HCO = loadProperty("WebColumnsHCOver").split(",");
	protected static final String[] CSV_Column_Country_HCO = loadProperty("CsvColumnsCountryHCOver").split(",");
	protected static final String[] Web_Column_Country_HCO = loadProperty("WebColumnsCountryHCOver").split(",");
	
	protected static final String[] HC_NonProd_Overview_CSV_Column = loadProperty("HC_NonProd_Overview_CsvColumns").split(",");
	protected static final String[] HC_NonProd_Overview_Web_Column = loadProperty("HC_NonProd_Overview_WebColumns").split(",");
	
	/*protected static final String[] CSV_Column_Country = loadProperty("CsvColumnsCountry").split(",");
	protected static final String[] Web_Column_Country = loadProperty("WebColumnsCountry").split(",");*/
	
	protected static final String[] HC_NonProd_Overview_CSV_Column_Country = loadProperty("HC_NonProd_Overview_CsvColumnsCountry").split(",");
	protected static final String[] HC_NonProd_Overview_Web_Column_Country = loadProperty("HC_NonProd_Overview_WebColumnsCountry").split(",");
	protected static final String[] HCAPP_NonProd_Overview_CSV_Column = loadProperty("HCAPP_NonProd_Overview_CsvColumns").split(",");
	protected static final String[] HCAPP_NonProd_Overview_Web_Column = loadProperty("HCAPP_NonProd_Overview_WebColumns").split(",");

	protected static final String[] CSV_Column_HCAPPO = loadProperty("CsvColumnsHCAPPOver").split(",");
	protected static final String[] Web_Column_HCAPPO = loadProperty("WebColumnsHCAPPOver").split(",");
	
	protected static final String[] App_IOT_IMT_NonProd_CSV_Column = loadProperty("App_IOT_IMT_NonProd_CsvColumns").split(",");
	protected static final String[] App_IOT_IMT_NonProd_Web_Column = loadProperty("App_IOT_IMT_NonProd_WebColumns").split(",");
	protected static final String[] App_IOT_IMT_NonProd_CSV_Column_Country = loadProperty("App_IOT_IMT_NonProd_CsvColumnsCountry").split(",");
	protected static final String[] App_IOT_IMT_NonProd_Web_Column_Country = loadProperty("App_IOT_IMT_NonProd_WebColumnsCountry").split(",");
	
	protected static final String[] HC_AUCU_Overview_CSV_Column_Summary = loadProperty("HC_AUCU_Overview_CsvColumnsSummary").split(",");
	protected static final String[] HC_AUCU_Overview_Web_Column_Summary = loadProperty("HC_AUCU_Overview_WebColumnsSummary").split(",");
	protected static final String[] HC_AUCU_Overview_CSV_Column_Customers = loadProperty("HC_AUCU_Overview_CsvColumnsCustomers").split(",");
	protected static final String[] HC_AUCU_Overview_Web_Column_Customers = loadProperty("HC_AUCU_Overview_WebColumnsCustomers").split(",");
	
	protected static final String[] HC_App_AUCU_Overview_CSV_Column_Summary = loadProperty("HC_App_AUCU_Overview_CsvColumnsSummary").split(",");
	protected static final String[] HC_App_AUCU_Overview_Web_Column_Summary = loadProperty("HC_App_AUCU_Overview_WebColumnsSummary").split(",");
	protected static final String[] HC_App_AUCU_Overview_CSV_Column_Customers = loadProperty("HC_App_AUCU_Overview_CsvColumnsCustomers").split(",");
	protected static final String[] HC_App_AUCU_Overview_Web_Column_Customers = loadProperty("HC_App_AUCU_Overview_WebColumnsCustomers").split(",");
	
	static {
		new File(Local_Folder_SESDR).mkdirs();
	}

	static {
		new File(Local_Folder_GACDW).mkdirs();
	}
	
	static {
		new File(Local_Folder_HC).mkdirs();
	}

	public static String loadProperty(String propName) {
		// System.out.println("==========Inside load property=============");
		Properties props = new Properties();
		String sysProp = System.getProperties().getProperty(propName);
		String value = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
			props.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (propName != null) {
			value = props.getProperty(propName);
		}

		if (sysProp != null) {
			value = System.getProperties().getProperty(propName);
		}

		// System.out.println(" Value is : "+value);
		return value;
	}

	/**
	 * Executes shell commands.
	 */
	public static String execute(String command) {
		String OSName = System.getProperty("os.name").toLowerCase();
		StringBuilder sb = new StringBuilder();
		String[] commands = new String[] { "/bin/bash", "-c", command };
		if (OSName.indexOf("win") >= 0) {
			commands[0] = "cmd";
			commands[1] = "/c";
		}
		try {
			Process proc = new ProcessBuilder(commands).start();
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

			String s = null;
			while ((s = stdInput.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}

			while ((s = stdError.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(sb);
		return sb.toString();
	}

	public static String getDate(Date date, String format) {
		SimpleDateFormat sdt = new SimpleDateFormat(format);
		return sdt.format(date).toString();
	}

	public static String getDate(String format) {
		return getDate(new Date(), format);
	}

	public void writeDataToFile(String fileName, String data, boolean append) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
			writer.write(data);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Method for validating downloaded file.
	 * 
	 * @return file size in bytes.
	 */
	public static long checkDownloadFile(String filePath) {
		File f = new File(filePath);
		if (f.exists() && !f.isDirectory()) {
			return f.length();
		}
		return 0;
	}

	public static String generateRandomString(int length) {

		StringBuffer buffer = new StringBuffer();
		String characters = "";
		characters = "abcdefghijklmnopqrstuvwxyz";
		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}
	
	public static String generateRandomNumber(int length) {

		StringBuffer buffer = new StringBuffer();
		String characters = "";
		characters = "123456789";
		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}

	public static String getMainFolder() {
		String OSName = System.getProperty("os.name").toLowerCase();
		if (OSName.indexOf("win") >= 0) {
			return loadProperty("MainFolderWin");
		}
		return loadProperty("MainFolderLin");
	}

	public String downloadCSV(WebDriver driver, String FilePartialName, String filePath, String type) throws Exception {

		Robot robot = new Robot();
		if (type.equalsIgnoreCase("0")) {

			Thread.sleep(4000); // Thread.sleep throws InterruptedException
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_F5);
			Thread.sleep(2000);
		} else {
			Thread.sleep(4000); // Thread.sleep throws InterruptedException
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_F5);
			Thread.sleep(2000);
		}

		String csvfileName = getCSVName(FilePartialName, filePath);
		long fileSize = csvfileName.length();

		if (fileSize > 0) {
			System.out.println("File downloaded sucessfully");
		} else
			System.out.println("File downloading error");

		/*
		 * String xlsName = csvfileName.substring(0, csvfileName.indexOf(".csv")) +
		 * ".xls" ;
		 * 
		 * System.out.println("xlsName :" + xlsName);
		 * 
		 * xlsName = Local_Folder_TPCHC + "\\" + xlsName ;
		 * 
		 * File excelFileName = new File(xlsName);
		 * 
		 * System.out.println(" xls Name *** :" + excelFileName);
		 */

		// csvToEXCEL(csvfileName , excelFileName);

		return csvfileName;

	}

	public static String getCSVName(String FilePartialName, String filePath) {

		System.out.println("FilePartialName :" + FilePartialName);

		File dir = new File(filePath);
		File theNewestFile = null;

		File[] files = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				return file.getName().startsWith(FilePartialName);
			}
		});

		if (files.length > 0) {
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
		} else {
			System.out.println("****** File Not Found ***********");
		}

		System.out.println("File Name :" + files[0].getName() + "Length :" + files.length);
		System.out.println("File size : " + +files[0].length());

		// return files[0].getName();
		return theNewestFile.getName();
	}

	public static String getCellValueFromCSV(String csvfileName, int rowIndex, int colIndex, String scanFolder,
			String separator) {

		BufferedReader br = null;
		String[] rowLine = null;
		String val = null;

		try {

			String fileLocation = scanFolder + "\\" + csvfileName;

			// System.out.println("File Location :"+ fileLocation);
			br = new BufferedReader(new FileReader(fileLocation));

			List<String> lines = new ArrayList<>();
			String line = null;
			while ((line = br.readLine()) != null) {
				lines.add(line);

			}

			rowLine = lines.get(rowIndex).trim().split(separator);
			// System.out.println("csv row size :"+ rowLine.length);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		val = rowLine[colIndex].toString();
		
		return val.replaceAll("^" + CSV_Quote + "|" + CSV_Quote + "$", "");
	}
	
	protected static List<String> getRowsFromCSV(String file, int rowNum) {
		List<String> rows = new ArrayList<String>();
		int currentRow = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    for (String line; (line = br.readLine()) != null; currentRow++) {
		        if (!(currentRow < rowNum)) {
		        	rows.add(line);
		        }
		    }
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return rows;
	}
		
		public void cleanLocalFolder(String folder) {
			try {
				for (File file : (new File(folder)).listFiles()) {
					file.delete();
				}

				System.out.println("Successfully deleted all the files inside local_folder.");
			} catch (NullPointerException e) {
				System.out.println(folder + " did not exist. Created it newly.");
				System.err.println(folder + " did not exist. Created it newly.");
				new File(folder).mkdirs();
			}
	}

}
