package AASProductTestCase.AASProductTest.qa.ExtentReportListener;

import java.io.File;
import java.util.Date;

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
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.setSystemInfo("Organization","Ciphertech AAS QA Team");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		
		return extent;
	}
	
	public static String getReportName() {
		Date d = new Date();
		
		String filename = "AASAutomationReport_"+d.toString().replace(":", "_").replace(" ", "_")+".png";
		return filename;
	}

}
