package functional.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import functional.providers.WebDriverManager;
import functional.config.Configuration;
import functional.pages.DanMurphysHomePage;

public abstract class BaseTestSetup extends WebDriverManager {

	WebDriver driver;
	
	@Before
	public void setup() {
		driver = new WebDriverManager().getWebDriver();
	}

	public DanMurphysHomePage launchDanMurphysOnline() {
		driver.get(Configuration.DANMURPHYS_URL);
		return new DanMurphysHomePage(driver);
	}

	@After
	public void tearDown(){
		driver.manage().deleteAllCookies();
		closeAllBrowserWindows(driver);
	}
}
