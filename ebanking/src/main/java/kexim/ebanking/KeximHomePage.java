package kexim.ebanking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class KeximHomePage {
	
	//user name
	public WebElement username(WebDriver driver) {
		return driver.findElement(By.id("txtuId"));
	}
	
	//password
	public WebElement password(WebDriver driver) {
		return driver.findElement(By.id("txtPword"));
	}
	
	//login button
	public WebElement loginButton(WebDriver driver) {
		return driver.findElement(By.id("login"));
	}
	
	//branch name
	public WebElement branchName(WebDriver driver) {
		return driver.findElement(By.id("drlist"));
	}
	
	//enter username
	public void fillUserName(String username, WebDriver driver) {
		this.username(driver).sendKeys(username);
	}
	
	//enter password
	public void fillPasword(String password, WebDriver driver) {
		this.password(driver).sendKeys(password);
	}
	
	//click on login button
	public void clickLogin(WebDriver driver) {
		this.loginButton(driver).click();
	}
	
	//select branch name
	public void selectBranchName(WebDriver driver, String visibleText) {
		Select bname = new Select(this.branchName(driver));
		bname.selectByVisibleText(visibleText);
	}

}
