package vtigerTests;

import java.util.Map;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepositories.CreateToDoPage;
import objectRepositories.EventInformationPage;

public class CreateEventTest extends BaseClass {

	@Test
	public void createEventTest() {
		CreateToDoPage createToDo = pom.getCreateToDo();
		EventInformationPage eventInfo = pom.getEventInfo();
		
		Map<String, String> map = excel.readFromExcel("Create New Event");
		home.selectFromQuickCreate(web, map.get("Quick Create"));
		createToDo.setSubject(map.get("Subject"));
		createToDo.clickStartDateWidget();
		createToDo.datePicker(map.get("Start Date"), jutil, web);
		createToDo.clickDueDateWidget();
		createToDo.datePicker(map.get("Due Date"), jutil, web);
		createToDo.clickSave();
		
		eventInfo.clickDelete();
		web.handleAlert("ok");
	}
}
