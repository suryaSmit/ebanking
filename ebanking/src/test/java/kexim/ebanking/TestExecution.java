package kexim.ebanking;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestExecution {
	
	WebDriver driver;
	KeximHomePage keximHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchesPage branchesPageObj;
	NewBranchCreationPage newBranchCreationPageObj;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "/Users/surya/Documents/selenium/softwares/geckodriver");
		this.driver = new FirefoxDriver();
		driver.get("http://srssprojects.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		keximHomePageObj = new KeximHomePage();
		adminHomePageObj = new AdminHomePage(driver);
		branchesPageObj = new BranchesPage(driver);
		newBranchCreationPageObj = new NewBranchCreationPage(driver); 
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	//verify admin login functionality with valid data
	@BeforeMethod
	public void testAdminLogin() {
		keximHomePageObj.fillUserName("Admin", driver);
		keximHomePageObj.fillPasword("Admin", driver);
		keximHomePageObj.clickLogin(driver);
	}
	
	//verify logout functionality
	@AfterMethod
	public void testLogout() throws InterruptedException {
		Thread.sleep(2000);
		adminHomePageObj.clickLogout();
	}
	
	@Test(priority = 0)
	public void testBranchCreation() {
		adminHomePageObj.clickBrnaches();
		branchesPageObj.clickNewBranch();
		newBranchCreationPageObj.fillbranchName("kphb branch 1");
		newBranchCreationPageObj.fillAddress1("kphb main road");
		newBranchCreationPageObj.fillZipcode("52315");
		newBranchCreationPageObj.SelectCountry("INDIA");
		newBranchCreationPageObj.SelectState("Andhra Pradesh");
		newBranchCreationPageObj.SelectCity("Hyderabad");
		newBranchCreationPageObj.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if(alertText.contains("New Branch with id")) {
			Reporter.log("branch created successfully");
		}else {
			Reporter.log("Branch creation failed");
		}
	}
	
	@Test(priority = 1)
	public void testBranchCreationReset() {
		adminHomePageObj.clickBrnaches();
		branchesPageObj.clickNewBranch();
		newBranchCreationPageObj.fillbranchName("kphb branch 1");
		newBranchCreationPageObj.fillAddress1("kphb main road");
		newBranchCreationPageObj.fillZipcode("52315");
		newBranchCreationPageObj.SelectCountry("INDIA");
		newBranchCreationPageObj.SelectState("Andhra Pradesh");
		newBranchCreationPageObj.SelectCity("Hyderabad");
		newBranchCreationPageObj.clickReset();
		if(newBranchCreationPageObj.getDefaultCountry().getText().equals("Select")) {
			Reporter.log("test passed");
		}else {
			Reporter.log("test failed");
		}	
	}
	
	@Test(priority =2)
	public void testBranchCreationCancelWithOutEnteringData() {
		adminHomePageObj.clickBrnaches();
		branchesPageObj.clickNewBranch();
		newBranchCreationPageObj.clickCancel();
		if(branchesPageObj.newBranchIsDisplayed()) {
			Reporter.log("test passed");
		}else {
			Reporter.log("test failed");
		}
	}
	
	@Test(priority = 3)
	public void testBranchCretionCancelWithData() {
		adminHomePageObj.clickBrnaches();
		branchesPageObj.clickNewBranch();
		newBranchCreationPageObj.fillbranchName("kphb branch 1");
		newBranchCreationPageObj.fillAddress1("kphb main road");
		newBranchCreationPageObj.fillZipcode("52315");
		newBranchCreationPageObj.clickCancel();
		if(branchesPageObj.newBranchIsDisplayed()) {
			Reporter.log("test passed");
		}else {
			Reporter.log("test failed");
		}
	}
	
	

}
