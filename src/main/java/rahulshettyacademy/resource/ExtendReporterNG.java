package rahulshettyacademy.resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG {
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter esr=new ExtentSparkReporter(path);
		esr.config().setReportName("Web Automation Report");
		esr.config().setDocumentTitle("Web Report");
		
		ExtentReports	extent =new ExtentReports();
			extent.setSystemInfo("Tester", "Tanya");
			extent.attachReporter(esr);
			return extent;
		
	}

}
