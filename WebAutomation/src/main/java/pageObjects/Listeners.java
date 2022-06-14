package pageObjects;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;		
import org.testng.ITestListener;		
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.Base;
import resource.Utils.ExtentReportNG;	

public class Listeners extends Base implements ITestListener {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> reportThread = new ThreadLocal<ExtentTest>(); 

	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		String testMethodName = result.getMethod().getMethodName();
		System.out.println(testMethodName);
		test = extent.createTest(testMethodName);
		reportThread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case Passed");
		reportThread.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.error("Test Case Failed");
		reportThread.get().fail(result.getThrowable());
		WebDriver driver = null;
		
		String testMethodName = result.getMethod().getMethodName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
		} 
		
		try
		{
			
			reportThread.get().addScreenCaptureFromPath(getScreenshot(testMethodName, driver),testMethodName);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	
	}

}
