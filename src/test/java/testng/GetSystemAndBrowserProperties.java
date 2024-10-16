package testng;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GetSystemAndBrowserProperties {

	@Test
	public void demo() {
		//System.getProperties().list(System.out);
		
		RemoteWebDriver driver = new ChromeDriver();
		Capabilities cap = driver.getCapabilities();
		System.out.println(cap.getBrowserName()+"\t"+cap.getBrowserVersion());
	}
}
