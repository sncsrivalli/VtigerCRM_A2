package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromProperties {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties property = new Properties();
		property.load(fis);

		String url = property.getProperty("url");
		String time = property.getProperty("timeouts");
		String browser = property.getProperty("browser");

		System.out.println(url + "\n" + time + "\n" + browser);
	}

}
