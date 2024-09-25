package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createLeadBTN;
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateLead() {
		createLeadBTN.click();
	}
}
