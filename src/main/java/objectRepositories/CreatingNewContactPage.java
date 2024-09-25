package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreatingNewContactPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;

	@FindBy(name="lastname")
	private WebElement lastNameTF;

	@FindBy(xpath = "//img[contains(@onclick,'Accounts')]")
	private WebElement orgPlusBTN;
	
	private String orgCommonPath = "//a[text()='%s']";
	
	@FindBy(xpath = "//input[normalize-space(@value)='Save']")
	private WebElement saveBTN;

	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void setLastName(String lastName) {
		lastNameTF.sendKeys(lastName);
	}

	public void selectOrganization(WebDriverUtility web, String orgName) {
		orgPlusBTN.click();
		web.switchToWindow("Accounts");
		web.convertDynamicXpathToWebElement(orgCommonPath, orgName).click();
		web.switchToWindow("Contacts");		
	}
	
	public void clickSave() {
		saveBTN.click();
	}
}
