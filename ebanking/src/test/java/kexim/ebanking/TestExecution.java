package kexim.ebanking;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	RolesPage RolesPageobj;
	NewRoleCreation NewRoleCreationobj;
	EmployeesPage EmployeesPageobj;
	NewEmployeePageCreation NewEmployeePageCreationobj;

	@BeforeClass(groups= {"branches","roles","employee","creation","reset","cancel"})
	public void launchBrowser() {
		// System.setProperty("webdriver.chrome.driver",
		// "‪C:\\Users\\prudhviraj\\Music\\chromedriver_win32\\chromedriver.exe");
		// this.driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "/Users/surya/Documents/selenium/softwares/geckodriver");
		this.driver = new FirefoxDriver();
		driver.get("http://srssprojects.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		keximHomePageObj = new KeximHomePage();
		adminHomePageObj = new AdminHomePage(driver);
		branchesPageObj = new BranchesPage(driver);
		newBranchCreationPageObj = new NewBranchCreationPage(driver);
		RolesPageobj = new RolesPage(driver);
		NewRoleCreationobj = new NewRoleCreation(driver);
		EmployeesPageobj = new EmployeesPage(driver);
		NewEmployeePageCreationobj = new NewEmployeePageCreation(driver);

	}

	@AfterClass(groups= {"branches","roles","employee","creation","reset","cancel"})
	public void closeBrowser() {
		driver.close();
	}

	// verify admin login functionality with valid data
	@BeforeMethod(groups= {"branches","roles","employee","creation","reset","cancel"})
	public void testAdminLogin() {
		keximHomePageObj.fillUserName("Admin", driver);
		keximHomePageObj.fillPasword("Admin", driver);
		keximHomePageObj.clickLogin(driver);
	}

	// verify logout functionality
	@AfterMethod(groups= {"branches","roles","employee","creation","reset","cancel"})
	public void testLogout() throws InterruptedException {
		Thread.sleep(2000);
		adminHomePageObj.clickLogout();
	}

	@Test(priority = 0, groups= {"branches","creation"})
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
		if (alertText.contains("New Branch with id")) {
			Reporter.log("branch created successfully");
		} else {
			Reporter.log("Branch creation failed");
		}
	}

	@Test(priority = 1, groups= {"branches","reset"})
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

	}

	@Test(priority = 2,groups= {"branches","cancel"})
	public void testBranchCreationCancelWithOutEnteringData() {
		adminHomePageObj.clickBrnaches();
		branchesPageObj.clickNewBranch();
		newBranchCreationPageObj.clickCancel();
		if (branchesPageObj.newBranchIsDisplayed()) {
			Reporter.log("test passed");
		} else {
			Reporter.log("test failed");
		}
	}

	@Test(priority = 3, groups= {"branches","cancel"})
	public void testBranchCretionCancelWithData() {
		adminHomePageObj.clickBrnaches();
		branchesPageObj.clickNewBranch();
		newBranchCreationPageObj.fillbranchName("kphb branch 1");
		newBranchCreationPageObj.fillAddress1("kphb main road");
		newBranchCreationPageObj.fillZipcode("52315");
		newBranchCreationPageObj.clickCancel();
		if (branchesPageObj.newBranchIsDisplayed()) {
			Reporter.log("test passed");
		} else {
			Reporter.log("test failed");
		}
	}

	@Test(priority = 4,groups= {"roles","creation"})
	public void testRoleCreation() {

		adminHomePageObj.clickRoles();
		RolesPageobj.clicknewRole();
		NewRoleCreationobj.fillRolename("prudhviraj");
		NewRoleCreationobj.fillRoledescription("he is a good man");
		NewRoleCreationobj.selectRoleType("E");
		NewRoleCreationobj.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if (alertText.contains("new Role creation with id")) {
			Reporter.log("new Role has been creted succesfully");
		} else {
			Reporter.log("role creation failed");
		}
	}

	@Test(priority = 5, groups= {"roles","reset"})
	public void testRoleCreationReset() {
		adminHomePageObj.clickRoles();
		RolesPageobj.clicknewRole();
		NewRoleCreationobj.fillRolename("prudhviraj");
		NewRoleCreationobj.fillRoledescription("he is a good man");
		NewRoleCreationobj.selectRoleType("E");
		NewRoleCreationobj.clickReset();

	}

	@Test(priority = 6, groups= {"roles","cancel"})
	public void testRoleCreationCancelWithOutData() {
		adminHomePageObj.clickRoles();
		RolesPageobj.clicknewRole();
		NewRoleCreationobj.clickCancel();
		if (RolesPageobj.newRoleIsDisplayed()) {
			Reporter.log("new role page displayed");
		} else {
			Reporter.log("new role page is not displayed");
		}

	}

	@Test(priority = 7, groups= {"employee","creation"})
	public void testEmployeeCreation() {
		adminHomePageObj.clickEmployee();
		EmployeesPageobj.clickNewEmployee();
		NewEmployeePageCreationobj.fillEmployerName("pradeep");
		NewEmployeePageCreationobj.fillLoginPassword("selenium");
		NewEmployeePageCreationobj.selectRole("manager");
		NewEmployeePageCreationobj.selectBranch("Ameerpet");
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		if (alertText.contains("New Employer Created ID Successfully")) {
			Reporter.log("Employeer id created");
		} else
			Reporter.log("not created");
	}

	@Test(priority = 8,groups= {"employee","reset"})
	public void employeeCreationReset() {
		adminHomePageObj.clickEmployee();
		EmployeesPageobj.clickNewEmployee();
		NewEmployeePageCreationobj.fillEmployerName("pradeep");
		NewEmployeePageCreationobj.selectRole("manager");
		NewEmployeePageCreationobj.selectBranch("123456");
		NewEmployeePageCreationobj.clickreset();
	}

	@Test(priority = 9, groups= {"employee","cancel"})
	public void employeeCreationWithoutData() {
		adminHomePageObj.clickEmployee();
		EmployeesPageobj.clickNewEmployee();
		NewEmployeePageCreationobj.clickCancel();
		if (EmployeesPageobj.newEmployeeIsDisplayed()) {
			Reporter.log("new employee page displayed");
		} else {
			Reporter.log("new employee page is not displayed");
		}
	}

}
