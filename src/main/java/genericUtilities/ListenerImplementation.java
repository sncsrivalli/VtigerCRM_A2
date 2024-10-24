package genericUtilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	ExtentReports reports;
	ExtentTest test;
	public static ExtentTest stest;
	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/report.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Extent Report");
		spark.config().setReportName("Vtiger CRM");
		
		reports = new ExtentReports();
		reports.attachReporter(spark);
		
		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("OS Version", System.getProperty("os.version"));
		reports.setSystemInfo("Java Version", System.getProperty("java.specification.version"));
		reports.setSystemInfo("Author", "Srivalli");
	}

	@Override
	public void onTestStart(ITestResult result) {
		Capabilities cap = ((RemoteWebDriver)BaseClass.sdriver).getCapabilities();
		reports.setSystemInfo("Browser", cap.getBrowserName()+" "+cap.getBrowserVersion());
		
		test = reports.createTest(result.getMethod().getMethodName());
		stest = test;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+ " Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+" Fail");
		test.fail(result.getThrowable());
		test.addScreenCaptureFromPath(BaseClass.sweb.getScreenshot(BaseClass.sdriver, 
				BaseClass.sjutil, result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+" Skip");
		test.skip(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
