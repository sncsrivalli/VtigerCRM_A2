package groupExecution;

import org.testng.annotations.Test;

public class Test4 {
	
	@Test(groups = {"regression", "sanity", "smoke"})
	public void demo() {
		System.out.println("Test4 - demo - regression, smoke and sanity");
	}
}
