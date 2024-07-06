package rahulshettyacademy.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resource.ExtendReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentReports extent=ExtendReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
    public void onTestStart(ITestResult result) {
        // Your custom logic here
	 test=	extent.createTest(result.getMethod().getMethodName());
    	extentTest.set(test);       

    }
	
	
	@Override
	 public void onTestSuccess(ITestResult result) {
	        // Your custom logic here
	        System.out.println("Test Succeeded: " + result.getName()+ Status.PASS);

	    }

		
    @Override
    public void onTestFailure(ITestResult result) {
    	extentTest.get().fail(result.getThrowable());      

        try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        
        
        //if want to know all the error message
      String path=null;  
      
      try {
		 path= getscreenshot(result.getMethod().getMethodName(),driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
    extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        // Your custom logic here
        System.out.println("Test skipped: " + result.getName());
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Your custom logic here
        System.out.println("Test : " + result.getName());
    }
    @Override
    public void onFinish(ITestContext context) {
        // Your custom logic here
    	extent.flush();
    }

}
