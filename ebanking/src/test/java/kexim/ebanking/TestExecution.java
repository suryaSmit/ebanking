package kexim.ebanking;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestExecution {

	WebDriver wdriver;
	EventFiringWebDriver driver;
	KeximHomePage keximHomePageObj;
	AdminHomePage adminHomePageObj;
	BranchesPage branchesPageObj;
	NewBranchCreationPage newBranchCreationPageObj;
	RolesPage RolesPageobj;
	NewRoleCreation NewRoleCreationobj;
	EmployeesPage EmployeesPageobj;
	NewEmployeePageCreation NewEmployeePageCreationobj;
	
	//to work with selenium grid
	private void launchGrid(String url, String brow, String os)  {
		DesiredCapabilities caps = new DesiredCapabilities();
		if(brow.equals("firefox")) {
			caps = DesiredCapabilities.firefox();
			caps.setBrowserName("firefox");
		}
		if(brow.equals("chrome")) {
			caps =DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");
		}
		if(brow.equals("safari")) {
			caps = DesiredCapabilities.safari();
			caps.setBrowserName("safari");	
		}
		if(os.equals("ubuntu")) {
			caps.setPlatform(Platform.LINUX);
		}
		if(os.equals("mac")) {
			caps.setPlatform(Platform.MAC);
		}
		try {
			this.wdriver = new RemoteWebDriver(new URL(url), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void launchBrowserByName(String brow) {
		if(brow.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/surya/Documents/selenium/softwares/geckodriver");
			this.wdriver = new FirefoxDriver();
		}else if(brow.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/surya/Documents/selenium/softwares/chromedriver");
			this.wdriver = new ChromeDriver();
		}else if(brow.equals("safari")) {
			this.wdriver = new SafariDriver();
		}
	}


	@BeforeClass(groups = { "branches", "roles", "employee", "creation", "reset", "cancel"})
	@Parameters({"url","browser", "os"})
	public void launchBrowser(String url, String brow, String os) {
		// System.setProperty("webdriver.chrome.driver",
		// "‪C:\\Users\\prudhviraj\\Music\\chromedriver_win32\\chromedriver.exe");
		// this.driver = new ChromeDriver();
//		launchBrowserByName(brow);
		launchGrid(url, brow, os);
		// System.setProperty("webdriver.gecko.driver",
		// "/Users/surya/Documents/selenium/softwares/geckodriver");

//		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
//		this.wdriver = new FirefoxDriver();
//		launchBrowserByName(brow);
		driver = new EventFiringWebDriver(wdriver);
		EventListener elistener = new EventListener();
		driver.register(elistener);
		driver.get("http://srssprojects.in");
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


	@AfterClass(groups = { "branches", "roles", "employee", "creation", "reset", "cancel" })
	public void closeBrowser() {
		driver.close();
	}

	// verify admin login functionality with valid data
	@BeforeMethod(groups = { "branches", "roles", "employee", "creation", "reset", "cancel" })
	@Parameters({"username","password"})
	public void testAdminLogin(String uname, String pwd) {
		keximHomePageObj.fillUserName(uname, driver);
		keximHomePageObj.fillPasword(pwd, driver);
		keximHomePageObj.clickLogin(driver);
	}

	// verify logout functionality
	@AfterMethod(groups = { "branches", "roles", "employee", "creation", "reset", "cancel" })
	public void testLogout() throws InterruptedException {
		Thread.sleep(2000);
		adminHomePageObj.clickLogout();
	}

	@Test(priority = 0, groups = { "branches", "creation" })
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
		boolean testResutlt = Validations.compareText(alertText, "New Branch with id");
		assertTrue(testResutlt);
	}

	@Test(priority = 1, groups = { "branches", "reset" })
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
		String defaultCountry = newBranchCreationPageObj.getDefaultCountry();
		boolean testResult = Validations.compareText(defaultCountry, "Select");
		assertTrue(testResult);

	}

	@Test(priority = 2, groups = { "branches", "cancel" })
	public void testBranchCreationCancelWithOutEnteringData() {
		adminHomePageObj.clickBrnaches();
		branchesPageObj.clickNewBranch();
		newBranchCreationPageObj.clickCancel();
		assertEquals(branchesPageObj.newBranchIsDisplayed(), true);
		Reporter.log("branches page is displayed");
	}

	@Test(priority = 3, groups = { "branches", "cancel" })
	public void testBranchCretionCancelWithData() {
		adminHomePageObj.clickBrnaches();
		branchesPageObj.clickNewBranch();
		newBranchCreationPageObj.fillbranchName("kphb branch 1");
		newBranchCreationPageObj.fillAddress1("kphb main road");
		newBranchCreationPageObj.fillZipcode("52315");
		newBranchCreationPageObj.clickCancel();
		// assertEquals(branchesPageObj.newBranchIsDisplayed(),true);
		assertTrue(branchesPageObj.newBranchIsDisplayed());
		Reporter.log("branches page is displayed");
		/*
		 * if (branchesPageObj.newBranchIsDisplayed()) { Reporter.log("test passed"); }
		 * else { Reporter.log("test failed"); }
		 */
	}

	@Test(priority = 4, groups = { "roles", "creation" })
	public void testRoleCreation() {

		adminHomePageObj.clickRoles();
		RolesPageobj.clicknewRole();
		NewRoleCreationobj.fillRolename("prudhviraj");
		NewRoleCreationobj.fillRoledescription("he is a good man");
		NewRoleCreationobj.selectRoleType("E");
		NewRoleCreationobj.clickSubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		boolean testResutlt1 = Validations.compareText(alertText, "new role with id");
		assertTrue(testResutlt1);

		/*
		 * if (alertText.contains("new Role creation with id")) {
		 * Reporter.log("new Role has been creted succesfully"); } else {
		 * Reporter.log("role creation failed"); }
		 */
	}

	@Test(priority = 5, groups = { "roles", "reset" })
	public void testRoleCreationReset() {
		adminHomePageObj.clickRoles();
		RolesPageobj.clicknewRole();
		NewRoleCreationobj.fillRolename("prudhviraj");
		NewRoleCreationobj.fillRoledescription("he is a good man");
		NewRoleCreationobj.selectRoleType("E");
		NewRoleCreationobj.clickReset();

		String selectRole = NewRoleCreationobj.getDefaultSelectRoleType();
		boolean testResult2 = Validations.compareText(selectRole, "Select");
		assertTrue(testResult2);

	}

	@Test(priority = 6, groups = { "roles", "cancel" })
	public void testRoleCreationCancelWithOutData() {
		adminHomePageObj.clickRoles();
		RolesPageobj.clicknewRole();
		NewRoleCreationobj.clickCancel();

		assertEquals(RolesPageobj.newRoleIsDisplayed(), false);
		Reporter.log("Roles page is displayed");

		/*
		 * if (RolesPageobj.newRoleIsDisplayed()) {
		 * Reporter.log("new role page displayed"); } else {
		 * Reporter.log("new role page is not displayed"); }
		 */

	}

	@Test(priority = 7, groups = { "employee", "creation" })
	public void testEmployeeCreation() {
		adminHomePageObj.clickEmployee();
		EmployeesPageobj.clickNewEmployee();
		NewEmployeePageCreationobj.fillEmployerName("pradeep");
		NewEmployeePageCreationobj.fillLoginPassword("selenium");
		NewEmployeePageCreationobj.selectRole("manager");
		NewEmployeePageCreationobj.selectBranch("kphb branch 1");
		NewEmployeePageCreationobj.clicksubmit();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		boolean testResutlt2 = Validations.compareText(alertText, "new Employeer created with id successfully");
		assertTrue(testResutlt2);

		/*
		 * if (alertText.contains("New Employer Created ID Successfully")) {
		 * Reporter.log("Employeer id created"); } else
		 */ // Reporter.log("not created");
	}

	@Test(priority = 8, groups = { "employee", "reset" })
	public void employeeCreationReset() {
		adminHomePageObj.clickEmployee();
		EmployeesPageobj.clickNewEmployee();
		NewEmployeePageCreationobj.fillEmployerName("pradeep");
		NewEmployeePageCreationobj.selectRole("manager");
		NewEmployeePageCreationobj.selectBranch("123456");
		NewEmployeePageCreationobj.clickreset();
		String selectRole = NewEmployeePageCreationobj.getDefaultSelectRoleType();
		boolean testResult2 = Validations.compareText(selectRole, "Select");
		assertTrue(testResult2);

		String selectBranch = NewEmployeePageCreationobj.getDefaultSelectBranchType();
		boolean testResult3 = Validations.compareText(selectBranch, "Select");
		assertTrue(testResult3);

	}

	@Test(priority = 9, groups = { "employee", "cancel" })
	public void employeeCreationWithoutData() {
		adminHomePageObj.clickEmployee();
		EmployeesPageobj.clickNewEmployee();
		NewEmployeePageCreationobj.clickCancel();
		assertEquals(EmployeesPageobj.newEmployeeIsDisplayed(), false);
		Reporter.log("employees page is displayed");

		/*
		 * if (EmployeesPageobj.newEmployeeIsDisplayed()) {
		 * Reporter.log("new employee page displayed"); } else {
		 * Reporter.log("new employee page is not displayed"); }
		 */
	}

}
