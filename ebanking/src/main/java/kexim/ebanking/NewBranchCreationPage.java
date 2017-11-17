package kexim.ebanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class NewBranchCreationPage extends AdminHomePage{

	WebDriver driver;
	public NewBranchCreationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	//branchName
	@FindBy(how = How.ID, using = "txtbName")
	private WebElement branchName;
	
	//Address1
    @FindBy(how=How.ID,using= "txtAdd1")
    private WebElement Address1;
    //Address2
    @FindBy(how= How.ID,using="Txtadd2")
    private WebElement Address2;
    
  //Address3
    @FindBy(how= How.ID,using="txtadd3")
    private WebElement Address3;
    
  //Area
    @FindBy(how= How.ID,using="txtArea")
    private WebElement Area;
    
  //ZipCode
    @FindBy(how= How.ID,using="txtZip")
    private WebElement ZipCode;
    
  //country
    @FindBy(how= How.ID,using="lst_counrtyU")
    private WebElement country;
  
  //state
    @FindBy(how= How.ID,using="lst_stateI")
    private WebElement state;
  
  //city
    @FindBy(how= How.ID,using="lst_cityI")
    private WebElement city;
 
    
    //submit
    @FindBy(how= How.ID,using="btn_insert")
    private WebElement submit;
   
  //rest
    @FindBy(how= How.ID,using="Btn_Reset")
    private WebElement rest;
    
    //cancel
    @FindBy(how= How.ID,using="Btn_cancel")
    private WebElement cancel;
   
  //newRoles
  	@FindBy(how = How.ID, using= "btnRoles")
  	private WebElement Roles;
  	
    
  
    
  //selectCountry    
    public void SelectCountry(String country) {
    	//Anonymous Object
    	new Select(this.country).selectByVisibleText(country);
    }
    //selectState
    public void SelectState(String state) {
    	new Select(this.state).selectByVisibleText(state);
    }
    //SelecCity
    public void SelectCity(String city) {
    	new Select(this.city).selectByVisibleText(city);
    }
    //click submit
    public void submit() {
    	this.submit.click();
    }
    //click rest
    public void rest() {
    	this.rest.click();
    }
    //click cancel
    public void cancel() {
    	this.cancel.click();
    }
  //click newRoles
  	public void clickRoles() {
  		this.Roles.click();
  	}
    
}
