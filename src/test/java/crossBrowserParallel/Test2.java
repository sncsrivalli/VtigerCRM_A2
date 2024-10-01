package crossBrowserParallel;

import org.testng.annotations.Test;

public class Test2 extends BaseClass {

	@Test
	public void zomatoTest() {
		driver.get("https://www.zomato.com/");
	}
}
