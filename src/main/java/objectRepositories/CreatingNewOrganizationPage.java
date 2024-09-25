package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreatingNewOrganizationPage {

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;

	@FindBy(name = "accountname")
	private WebElement orgNameTF;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(name = "accounttype")
	private WebElement typeDD;

	@FindBy(xpath = "//input[normalize-space(@value)='Save']")
	private WebElement saveBTN;

	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void setOrgName(String orgName) {
		orgNameTF.sendKeys(orgName);
	}

	public void selectIndustry(WebDriverUtility web, String value) {
		web.chooseFromDropdown(industryDD, value);
	}
	
	public void selectType(WebDriverUtility web, String value) {
		web.chooseFromDropdown(typeDD, value);
	}
	
	public void clickSave() {
		saveBTN.click();
	}
}
