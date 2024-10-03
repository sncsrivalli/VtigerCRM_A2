package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.DataType;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;

public class CreateToDoPage {

	@FindBy(xpath = "//b[text()='Create To Do']")
	private WebElement pageHeader;
	
	@FindBy(name = "subject")
	private WebElement subjectTF;
	
	@FindBy(id = "jscal_trigger_date_start")
	private WebElement startDateWidget;
	
	@FindBy(xpath = "//div[@class='calendar' and contains(@style, 'block')]/descendant::td[@class='title']")
	private WebElement calendarTitle;
	
	private String commonPath = "//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='%s']";
	
	@FindBy(id="jscal_trigger_due_date")
	private WebElement dueDateWidget;
	
	@FindBy(xpath = "//input[@value='  Save']")
	private WebElement saveBTN;
	
	public CreateToDoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void setSubject(String subject) {
		subjectTF.sendKeys(subject);
	}
	
	public void clickStartDateWidget() {
		startDateWidget.click();
	}
	
	public void clickDueDateWidget() {
		dueDateWidget.click();
	}
	
	public void clickSave() {
		saveBTN.click();
	}
	
	public void datePicker(String requiredStartDate, JavaUtility jutil, WebDriverUtility web) {
		String[] s = requiredStartDate.split("-");
		int reqYear = (Integer)jutil.convertStringToAnyDataType(DataType.INT, s[0]);
		
		String currentMonthYear = calendarTitle.getText();
		String[] str = currentMonthYear.split(", ");
		int currentYear = (Integer)jutil.convertStringToAnyDataType(DataType.INT, str[1]);
		
		while(currentYear < reqYear) {
			web.convertDynamicXpathToWebElement(commonPath, "»").click();
			currentMonthYear = calendarTitle.getText();
			str = currentMonthYear.split(", ");
			currentYear = (Integer)jutil.convertStringToAnyDataType(DataType.INT, str[1]);
		}
		
		int reqMonth = jutil.convertMonthToNum(s[1]);
		int currentMonth = jutil.convertMonthToNum(str[0]);
		
		while(currentMonth < reqMonth) {
			web.convertDynamicXpathToWebElement(commonPath, "›").click();;
			currentMonthYear = calendarTitle.getText();
			str = currentMonthYear.split(", ");
			currentMonth = jutil.convertMonthToNum(str[0]);
		}
		
		while(currentMonth > reqMonth) {
			web.convertDynamicXpathToWebElement(commonPath, "‹").click();;
			currentMonthYear = calendarTitle.getText();
			str = currentMonthYear.split(", ");
			currentMonth = jutil.convertMonthToNum(str[0]);
		}
		web.convertDynamicXpathToWebElement(commonPath, s[2]).click();		
	}
}
