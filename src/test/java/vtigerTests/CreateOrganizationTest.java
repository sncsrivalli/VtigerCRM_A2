package vtigerTests;

import java.util.Map;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.TabNames;
import objectRepositories.CreatingNewOrganizationPage;
import objectRepositories.OrganizationInformationPage;
import objectRepositories.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrgTest() {
		OrganizationsPage org = pom.getOrg();
		OrganizationInformationPage orgInfo = pom.getOrgInfo();
		CreatingNewOrganizationPage createOrg = pom.getCreateOrg();
		
		home.clickRequiredTab(web, TabNames.ORGANIZATIONS);
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickCreateOrg();
		soft.assertEquals(createOrg.getPageHeader(),"Creating New Organization");
		Map<String, String> map = excel.readFromExcel("Create Organization With Industry And Type");
		createOrg.setOrgName(map.get("Organization Name"));
		createOrg.selectIndustry(web, map.get("Industry"));
		createOrg.selectType(web, map.get("Type"));
		createOrg.clickSave();
		
		soft.assertTrue(orgInfo.getPageHeader().contains(map.get("Organization Name")));
		orgInfo.clickDelete();
		web.handleAlert("ok");
		soft.assertFalse(org.searchOrganization(map.get("Organization Name")));
		if(!(org.searchOrganization(map.get("Organization Name"))))
			excel.updateStatus("Create Organization With Industry And Type", "Pass");
		else
			excel.updateStatus("Create Organization With Industry And Type", "Fail");
		soft.assertAll();
	}
}
