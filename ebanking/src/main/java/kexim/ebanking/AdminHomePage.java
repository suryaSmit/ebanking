package kexim.ebanking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AdminHomePage {
	WebDriver driver;
	
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//home button
	public WebElement home() {
		return driver.findElement(By.xpath("//a[@href='adminflow.aspx']"));
	}
	
	//change password 
	public WebElement changePassword() {
		return driver.findElement(By.xpath("//a[@href='change_password1234.aspx']"));
	}
	//logout
	public WebElement logout() {
		return driver.findElement(By.xpath("//a[@href='home.aspx']"));
	}
	
	//branches
	public WebElement branches() {
		return driver.findElement(By.xpath("//a[@href='admin_banker_master.aspx']"));
	}
	
	//roles
	public WebElement roles() {
		return driver.findElement(By.xpath("//a[@href='Admin_Roles_details.aspx']"));
	}
	
	//users
	public WebElement users() {
		return driver.findElement(By.xpath("//a[@href='userdetails.aspx']"));
	}
	
	//employee
	public WebElement employee() {
		return driver.findElement(By.xpath("//a[@href='Admin_Emp_details.aspx']"));
	}
	
	
	//click home
	public void clickHome() {
		this.home().click();
	}
	
	//click change password
	public void clickChangePassword() {
		this.changePassword().click();
	}
	//click logout
	public void clickLogout() {
		this.logout().click();
	}
	//click branches
	public void clickBrnaches() {
		this.branches().click();
	}
	//click roles
	public void clickRoles() {
		this.roles().click();
	}
	//click users
	public void clickUsers() {
		this.users().click();
	}
	//click employee
	public void clickEmployee() {
		this.employee().click();
	}
}
