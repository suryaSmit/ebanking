package kexim.ebanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewRoleCreation extends AdminHomePage {
	WebDriver driver;

	public NewRoleCreation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	private WebElement reset;

	// submit
	@FindBy(how = How.ID, using = "btninsert")
	private WebElement submit;

	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	// fill role name
	public void fillRolename(String rolename) {
		this.RoleName.sendKeys(rolename);
	}

	// fill role description
	public void fillRoledescription(String roledescription) {
		this.RoleDesc.sendKeys(roledescription);
	}

	// selectRoleType
	public void selectRoleType(String RoleType) {
		// Anonymous Object
		new Select(this.RoleType).selectByVisibleText(RoleType);
	}

	// click submit
	public void clickSubmit() {
		this.submit.click();
	}

	// click reset
	public void clickReset() {
		this.reset.click();
	}

	// click cancel
	public void clickCancel() {
		this.cancel.click();
	}

}
