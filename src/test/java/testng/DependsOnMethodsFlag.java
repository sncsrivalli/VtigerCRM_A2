package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsFlag {

	@Test
	public void registerToApp() {
		System.out.println("Registration Test");
		Assert.fail();
	}
	
	@Test(dependsOnMethods = "registerToApp", alwaysRun = true)
	public void applyToJob() {
		System.out.println("Apply Job Test");
	}
}
