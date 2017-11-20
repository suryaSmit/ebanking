package kexim.ebanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RolesPage extends AdminHomePage {
	WebDriver driver;

	public RolesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// new role button

	// new Role
	@FindBy(how = How.ID, using = "btnRoles")
	private WebElement newRole;

	// click new role button

	public void newRole() {
		this.newRole.click();
	}

}
