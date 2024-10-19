package vtigerTests;

import java.util.Map;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.TabNames;
import objectRepositories.CreatingNewLeadPage;
import objectRepositories.DuplicatingLeadPage;
import objectRepositories.LeadInformationPage;
import objectRepositories.LeadsPage;

public class CreateAndDuplicateLeadTest extends BaseClass{

	@Test(retryAnalyzer = genericUtilities.RetryImplementation.class)
	public void createLeadTest() {
		LeadsPage leads = pom.getLeads();
		CreatingNewLeadPage createLead = pom.getCreateLead();
		DuplicatingLeadPage duplicateLead = pom.getDuplicateLead();
		LeadInformationPage leadInfo = pom.getLeadInfo();
		
		home.clickRequiredTab(web, TabNames.LEADS);
		leads.clickCreateLead();
		Map<String, String> map = excel.readFromExcel("Create and Duplicate Lead");
		String lastName = map.get("Last Name") + jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		createLead.setCompany(map.get("Company"));
		createLead.clickSave();
		
		leadInfo.clickDuplicate();
		String newLastName = map.get("New Last Name") + jutil.generateRandomNum(100);
		duplicateLead.setLastName(newLastName);
		duplicateLead.clickSave();
	}
}
