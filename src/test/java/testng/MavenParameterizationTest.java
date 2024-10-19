package testng;

import org.testng.annotations.Test;

public class MavenParameterizationTest {

	@Test
	public void parameterizationTest() {
		String url = System.getProperty("url");
		String browser = System.getProperty("browser");
		System.out.println(url + "\n" + browser);
	}
}
