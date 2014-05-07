package functional.test;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import functional.providers.WebDriverManager;
import functional.config.Configuration;
import functional.pages.DanMurphysHomePage;
import functional.providers.TakeScreenshotOnFailRule;

public abstract class BaseTestSetup extends WebDriverManager {

	WebDriver driver;
	
	@Rule
	public TakeScreenshotOnFailRule fail = new TakeScreenshotOnFailRule(
			getWebDriver());

	@Before
	public void setup() {
		driver = (WebDriver) WebDriverManager.getWebDriver();
	}

	public DanMurphysHomePage launchDanMurphysOnline() {
		driver.get(Configuration.DANMURPHYS_URL);
		return new DanMurphysHomePage(driver);
	}

	@AfterClass
	public static void tearDown() throws IOException {
		closeAllBrowserWindows();
	}
}
