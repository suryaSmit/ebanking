package kexim.ebanking;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TestListener extends EventListener implements ITestListener, ISuiteListener, IInvokedMethodListener{

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//testng report
		Reporter.log("test result is: "+ITestResult.FAILURE);
		//extent report
		test1.log(LogStatus.FAIL, "test failed");
		report.endTest(test1);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//extent report
		test1.log(LogStatus.SKIP, "test skipped");
		report.endTest(test1);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		//extent report
		Reporter.log("test started ");
		startTest(result.getName());
		System.out.println("test started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//testng report
		Reporter.log("test passed ");
		//extent report
		test1.log(LogStatus.PASS, "test passed");
		report.endTest(test1);
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		report = startReport();
		System.out.println("report started");
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		
		
	}

}
