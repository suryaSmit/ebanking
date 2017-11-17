package kexim.ebanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewBranchCreationPage extends AdminHomePage{

	WebDriver driver;
	public NewBranchCreationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.ID, using = "txtbName")
	private WebElement branchName;
	

}
