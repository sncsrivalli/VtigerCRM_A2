package vtigerTests;

import java.util.Map;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.TabNames;
import objectRepositories.ContactInformationPage;
import objectRepositories.ContactsPage;
import objectRepositories.CreatingNewContactPage;

public class CreateContactTest extends BaseClass {

	@Test
	public void createContactWithOrgTest() {
		ContactsPage contact = pom.getContact();
		CreatingNewContactPage createContact = pom.getCreateContact();
		ContactInformationPage contactInfo = pom.getContactInfo();
		
		home.clickRequiredTab(web, TabNames.CONTACTS);
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		contact.clickCreateContact();
		soft.assertEquals(createContact.getPageHeader(),"Creating New Contact");
		Map<String, String> map = excel.readFromExcel("Create Contact With Organization");
		createContact.setLastName(map.get("Last Name"));
		createContact.selectOrganization(web, map.get("Organization Name"));
		createContact.clickSave();
		
		soft.assertTrue(contactInfo.getPageHeader().contains(map.get("Last Name")));
		contactInfo.clickDelete();
		web.handleAlert("OK");
		soft.assertFalse(contact.searchContact(map.get("Last Name")));
		if(!(contact.searchContact(map.get("Last Name"))))
			excel.updateStatus("Create Contact With Organization", "Pass");
		else
			excel.updateStatus("Create Contact With Organization", "Fail");
		soft.assertAll();
	}
}
