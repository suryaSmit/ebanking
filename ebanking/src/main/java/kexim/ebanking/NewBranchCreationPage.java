package kexim.ebanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class NewBranchCreationPage extends AdminHomePage {

	WebDriver driver;

	public NewBranchCreationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	// branchName
	@FindBy(how = How.ID, using = "txtbName")
	private WebElement branchName;

	// Address1
	@FindBy(how = How.ID, using = "txtAdd1")
	private WebElement Address1;
	// Address2
	@FindBy(how = How.ID, using = "Txtadd2")
	private WebElement Address2;

	// Address3
	@FindBy(how = How.ID, using = "txtadd3")
	private WebElement Address3;

	// Area
	@FindBy(how = How.ID, using = "txtArea")
	private WebElement Area;

	// ZipCode
	@FindBy(how = How.ID, using = "txtZip")
	private WebElement ZipCode;

	// country
	@FindBy(how = How.ID, using = "lst_counrtyU")
	private WebElement country;

	// state
	@FindBy(how = How.ID, using = "lst_stateI")
	private WebElement state;

	// city
	@FindBy(how = How.ID, using = "lst_cityI")
	private WebElement city;

	// submit
	@FindBy(how = How.ID, using = "btn_insert")
	private WebElement submit;

	// rest
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;

	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	//fill branch name
	public void fillbranchName(String branchname) {
		this.branchName.sendKeys(branchname);
	}
	
	//fill address1
	public void fillAddress1(String address1) {
		this.Address1.sendKeys(address1);
	}
	//fill address2
	public void fillAddress2(String address2) {
		this.Address2.sendKeys(address2);
	}
	
	//fill address3
	public void fillAdress3(String address3) {
		this.Address3.sendKeys(address3);
	}
	//fill  area
	public void fillArea(String area) {
		this.Area.sendKeys(area);
	}
	
	//fill zipcode
	public void fillZipcode(String zipcode) {
		this.ZipCode.sendKeys(zipcode);
	}
	
	// selectCountry
	public void SelectCountry(String country) {
		// Anonymous Object
		new Select(this.country).selectByVisibleText(country);
	}

	// selectState
	public void SelectState(String state) {
		new Select(this.state).selectByVisibleText(state);
	}

	// SelecCity
	public void SelectCity(String city) {
		new Select(this.city).selectByVisibleText(city);
	}

	// click submit
	public void clickSubmit() {
		this.submit.click();
	}

	// click rest
	public void clickReset() {
		this.reset.click();
	}

	// click cancel
	public void clickCancel() {
		this.cancel.click();
	}

}
