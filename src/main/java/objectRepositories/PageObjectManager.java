package objectRepositories;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage getLogin() {
		return new LoginPage(driver);
	}
	public HomePage getHome() {
		return new HomePage(driver);
	}
	public OrganizationsPage getOrg() {
		return new OrganizationsPage(driver);
	}
	public CreatingNewOrganizationPage getCreateOrg() {
		return new CreatingNewOrganizationPage(driver);
	}
	public OrganizationInformationPage getOrgInfo() {
		return new OrganizationInformationPage(driver);
	}
	public ContactsPage getContact() {
		return new ContactsPage(driver);
	}
	public CreatingNewContactPage getCreateContact() {
		return new CreatingNewContactPage(driver);
	}
	public ContactInformationPage getContactInfo() {
		return new ContactInformationPage(driver);
	}
	public LeadsPage getLeads() {
		return new LeadsPage(driver);
	}
	public CreatingNewLeadPage getCreateLead() {
		return new CreatingNewLeadPage(driver);
	}
	public DuplicatingLeadPage getDuplicateLead() {
		return new DuplicatingLeadPage(driver);
	}
	public LeadInformationPage getLeadInfo() {
		return new LeadInformationPage(driver);
	}
	public CreateToDoPage getCreateToDo() {
		return new CreateToDoPage(driver);
	}
	public EventInformationPage getEventInfo() {
		return new EventInformationPage(driver);
	}
}
