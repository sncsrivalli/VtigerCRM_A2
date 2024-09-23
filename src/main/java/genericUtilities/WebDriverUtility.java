package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	Select select;

	public WebDriver launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			System.out.println("Invalid browser info");

		return driver;
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void navigateToApp(String url) {
		driver.get(url);
	}

	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public WebElement explicitWait(long time, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement explicitWait(WebElement element, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public Boolean explicitWait(long time, String title) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}

	public void mouseHoverToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClickAnElement(WebElement element) {
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void rightClickAnElement(WebElement element) {
		action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void dragAndDropAnElement(WebElement element, WebElement target) {
		action = new Actions(driver);
		action.dragAndDrop(element, target).perform();
	}

	public String getScreenshot(WebDriver driver, JavaUtility jutil, String classname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshots/" + classname + "_" 
												+ jutil.getCurrentTime() + ".png");
		try {
			FileUtils.copyFile(temp, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return target.getAbsolutePath();
	}
	
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	public void chooseFromDropdown(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void chooseFromDropdown(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}
	
	public void chooseFromDropdown(String text, WebElement element) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public void handleAlert(String status) {
		Alert a = driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
			a.accept();
		else
			a.dismiss();
	}
	
	public void switchToWindow(String requiredUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			if(driver.getCurrentUrl().contains(requiredUrl))
				break;
		}
	}
	
	public void closeWindow() {
		driver.close();
	}
	
	public void quitAllWindows() {
		driver.quit();
	}
}
