package functional.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import functional.providers.WebDriverManager;
import functional.config.Configuration;
import functional.pages.DanMurphysHomePage;

public abstract class BaseTestSetup extends WebDriverManager {

	WebDriver driver;
	private String testName;
	
	@Rule
	public TestWatcher watchman= new TestWatcher(){
		@Override
	      protected void failed(Throwable e, Description description) {
			  super.failed(e, description);
			  testName = description.getMethodName();
	          silentlySaveScreenshotWith(driver, testName);
	      }
		
		@Override
		protected void finished(Description description) {
			driver.manage().deleteAllCookies();
			closeAllBrowserWindows(driver);
		}
		
	};
	
	@Before
	public void setup() {
		driver = new WebDriverManager().getWebDriver();
	}

	public DanMurphysHomePage launchDanMurphysOnline() {
		driver.get(Configuration.DANMURPHYS_URL);
		return new DanMurphysHomePage(driver);
	}
}
