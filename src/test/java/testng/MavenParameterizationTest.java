package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class MavenParameterizationTest {

	@Test
	public void parameterizationTest() {
		String url = System.getProperty("url");
		String browser = System.getProperty("browser");
		Reporter.log(browser, true);
		Reporter.log(url, true);
	}
}
