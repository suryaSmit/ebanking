package kexim.ebanking;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestExecution {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "/Users/surya/Documents/selenium/softwares/geckodriver");
		this.driver = new FirefoxDriver();
		driver.get("http://srssprojects.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	//verify admin login functionality with valid data
	@Test
	public void testAdminLogin() {
		KeximHomePage keximHomePageObj = new KeximHomePage();
		keximHomePageObj.fillUserName("Admin", driver);
		keximHomePageObj.fillPasword("Admin", driver);
		keximHomePageObj.clickLogin(driver);
	}

}
