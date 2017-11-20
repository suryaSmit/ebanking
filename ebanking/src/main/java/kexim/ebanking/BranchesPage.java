package kexim.ebanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchesPage extends AdminHomePage {

	//this class we are using pagefactory
	WebDriver driver;
	public BranchesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//country
	@FindBy(how = How.ID, using= "lst_countryS")
	private WebElement country;
	//state
	@FindBy(how = How.ID, using= "lst_stateS")
	private WebElement state;
	//city
	@FindBy(how = How.ID, using= "lst_cityS")
	private WebElement city;
	
	//search
	@FindBy(how = How.ID, using= "btn_search")
	private WebElement search;
	
	//clear
	@FindBy(how = How.ID, using= "btn_clsearch")
	private WebElement clear;
	
	//new branch
	@FindBy(how = How.ID, using= "BtnNewBR")
	private WebElement newBranch;
	
	//select country
	public void selectCountry(String country) {
		//Anonymous object 
		new Select(this.country).selectByVisibleText(country);
	}
	
	//select state
	public void selectState(String state) {
		//Anonymous object 
		new Select(this.state).selectByVisibleText(state);
	}
	//select city
	public void selectCity(String city) {
		//Anonymous object 
		new Select(this.city).selectByVisibleText(city);
	}
	//click search
	public void clickSearch() {
		this.search.click();
	}
	
	//click clear
	public void clickClear() {
		this.clear.click();
	}
	
	
	//is displayed new branch
	public boolean newBranchIsDisplayed() {
		return this.newBranch.isDisplayed();
	}
	//click new branch
	public void clickNewBranch() {
		this.newBranch.click();
	}
	
	

}
