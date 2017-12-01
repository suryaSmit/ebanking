package kexim.ebanking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EventListener implements WebDriverEventListener{
	static ExtentReports report;
	static ExtentTest test1;
	
	public static ExtentReports startReport() {
		return new ExtentReports(".//extent report/report.html",false);
	}
	
	public static void startTest(String testName) {
		test1 = report.startTest(testName);
	}
	
	@Override
	public void afterAlertAccept(WebDriver arg0) {
		//testng report
		Reporter.log("alert accpetd");
		//extent report
		test1.log(LogStatus.INFO, "alert accpeted");
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		Reporter.log("alert dissmissed");
		
		test1.log(LogStatus.INFO, "alert dismissed");
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		Reporter.log("value changed to "+arg2);
		test1.log(LogStatus.INFO, "vlaue chnaged to "+arg2);
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		Reporter.log("element clicked");
		test1.log(LogStatus.INFO, "element clicked");
		
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		Reporter.log("element loacted by :"+arg0 );
		test1.log(LogStatus.INFO, "element located by : "+arg0);
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		Reporter.log("navigated to "+arg0+"title of the page is: "+arg1.getTitle());
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		String alertText = arg0.switchTo().alert().getText();
		Reporter.log("alert is: "+alertText);
		test1.log(LogStatus.INFO, "alert is: "+alertText);
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		String alertText = arg0.switchTo().alert().getText();
		Reporter.log("alert is: "+alertText);
		test1.log(LogStatus.INFO, "alert is: "+alertText);
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		Reporter.log("clicking on element");
		test1.log(LogStatus.INFO, "clicking on element");
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		Reporter.log("locating element using : "+arg0);
		test1.log(LogStatus.INFO, "locating element using: "+arg0);
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
//		test.log(LogStatus.ERROR, "Exception occured: "+arg0.getMessage());
		
	}

}
