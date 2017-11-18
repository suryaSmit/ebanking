package kexim.ebanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class NewRoleCreation extends AdminHomePage {
	WebDriver driver;

	public NewRoleCreation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	// RoleName
	@FindBy(how = How.ID, using = "txtRname")
	private WebElement RoleName;

	// RoleDesc
	@FindBy(how = How.ID, using = "txtRDesc")
	private WebElement RoleDesc;

	// RoleType
	@FindBy(how = How.ID, using = "lstRtypeN")
	private WebElement RoleType;

	// rest
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement rest;

	// submit
	@FindBy(how = How.ID, using = "btninsert")
	private WebElement submit;

	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	// fill role name

	// fill role description

	// selectRoleType
	public void selectRoleType(String RoleType) {
		// Anonymous Object
		new Select(this.RoleType).selectByVisibleText(RoleType);
	}

	// click submit
	public void submit() {
		this.submit.click();
	}

	// click reset
	public void rest() {
		this.rest.click();
	}

	// click cancel
	public void cancel() {
		this.cancel.click();
	}

}
