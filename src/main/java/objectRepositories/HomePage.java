package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.TabNames;
import genericUtilities.WebDriverUtility;

public class HomePage {

	private String commonPath = "//a[text()='%s' and contains(@href, 'action=index')]";
	
	@FindBy(id = "qccombo")
	private WebElement quickCreateDD;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminIcon;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	public void clickRequiredTab(WebDriverUtility web, TabNames tabName) {
		web.convertDynamicXpathToWebElement(commonPath, tabName.getTabName()).click();
	}
	
	public void selectFromQuickCreate(WebDriverUtility web, String value) {
		web.chooseFromDropdown(quickCreateDD, value);
	}
	
	public void signOutOfVtiger(WebDriverUtility web) {
		web.mouseHoverToElement(adminIcon);
		signOutLink.click();
	}
}
