package kexim.ebanking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeesPage extends AdminHomePage  {
WebDriver driver;
	public EmployeesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
	}
	//Employee page
      @FindBy(how=How.ID,using="BtnNew")
      private WebElement EmployeePage;
      
    //is displayed New Employee
    		public boolean newEmployeeIsDisplayed() {
    			return this.employee().isDisplayed();
    			}

//click New Employee 
  public void clickNewEmployee() {
	  this.EmployeePage.click();
  }
}
