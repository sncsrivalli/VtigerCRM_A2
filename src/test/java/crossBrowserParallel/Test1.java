package crossBrowserParallel;

import org.testng.annotations.Test;

public class Test1 extends BaseClass {

	@Test
	public void googleTest() {
		driver.get("https://www.google.com/");
	}
}
