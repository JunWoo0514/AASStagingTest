package AASProductTestCase.AASProductTest.qa.ExtentReportListener;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	//private static ExtentReporter htmlReporter;
	
	public static ExtentReports createInstance() {
		String filename = getReportName();
		String directory = System.getProperty("user.dir")+"/reports/";
		new File(directory).mkdirs();
		String path = directory + filename;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter = new ExtentHtmlReporter("./reports/AASTestReport.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("AASAutomationSmokeTestReport");
		htmlReporter.config().setReportName("AAS Automation Test Result");
		htmlReporter.setAnalysisStrategy(AnalysisStrategy.SUITE);
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.setSystemInfo("Provider","Ciphertech AAS QA Team");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		//extent.setSystemInfo("Java Version : ", System.getProperty("java.version"));
		extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		extent.setSystemInfo("Machine Name : ", System.getProperty("machine.name"));
		extent.setSystemInfo("IP Address : ", System.getProperty("machine.address"));
		extent.attachReporter(htmlReporter);
		
		return extent;
	}
	
	public static String getReportName() {
		Date d = new Date();
		
		String filename = "AASAutomationReport_"+d.toString().replace(":", "_").replace(" ", "_")+".png";
		return filename;
	}

}
