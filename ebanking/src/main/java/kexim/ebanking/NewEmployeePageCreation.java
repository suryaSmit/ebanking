package kexim.ebanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewEmployeePageCreation extends AdminHomePage {

	public NewEmployeePageCreation(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	//Employer Name
	
	@FindBy(how=How.ID,using="txtUname")
	private WebElement EmployerName;
	
	//Login Password
	
	@FindBy(how=How.ID,using="txtLpwd")
	private WebElement LoginPassword;
	
	//Role
	
	@FindBy(how=How.ID,using="lst_Roles")
	private WebElement Role;

	//Branch
	
	@FindBy(how=How.ID,using="lst_Branch")
	private WebElement Branch;
	
	//submit
	@FindBy(how=How.ID,using="BtnSubmit")
	private WebElement submit;
	
	//Reset
	@FindBy(how=How.ID,using="btnreset")
	private WebElement Reset;
	
	//Cancel
	
	@FindBy(how=How.ID,using="btnCancel")
	private WebElement Cancel;
	
	
	
	
	//fill EmployerName
	public void fillEmployerName(String employername) {
		this.EmployerName.sendKeys(employername);
	}
	
	//fill LoginPassword
	
	public void fillLoginPassword(String loginpassword) {
		this.LoginPassword.sendKeys(loginpassword);
	}
	//selectRole
	
	public void selectRole(String role) {
		new Select(this.Role).selectByVisibleText(role);
	}
	
	//selectBranch
	
	public void selectBranch(String branch) {
		new Select(this.Branch).selectByVisibleText(branch);
	}
	//ClickSubmit
	public void clicksubmit() {
		this.submit.click();
	}
	
	//clickReset
	
	public void clickreset() {
		this.Reset.click();
	}
	//clickCancel
	public void clickCancel() {
		this.Cancel.click();
	}
	
	
	
}
