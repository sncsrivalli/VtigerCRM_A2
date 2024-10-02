package listenerPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	@BeforeSuite
	public void suiteSetUp() {
		System.out.println("@BeforeSuite");
	}
	
	@BeforeTest
	public void testSetUp() {
		System.out.println("@BeforeTest");
	}
	
	@BeforeClass
	public void classSetUp() {
		System.out.println("@BeforeClass");
	}
	
	@BeforeMethod
	public void methodSetUp() {
		System.out.println("@BeforeMethod");
	}
	
	@AfterMethod
	public void methodTearDown() {
		System.out.println("@AfterMethod");
	}
	
	@AfterClass
	public void classTearDown() {
		System.out.println("@AfterClass");
	}
	
	@AfterTest
	public void testTearDown() {
		System.out.println("@AfterTest");
	}
	
	@AfterSuite
	public void suiteTearDown() {
		System.out.println("@AfterSuite");
	}
}
