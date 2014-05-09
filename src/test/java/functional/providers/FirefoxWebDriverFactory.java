package functional.providers;


import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxWebDriverFactory implements WebDriverFactory {

	RemoteWebDriver driver;
	public static int DEFAULT_IMPLICIT_WAIT = 30;
	
	@Override
	public WebDriver create(String host, int port) throws Exception{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability( "takesScreenshot", true );
		dc.setCapability( "webdriver.remote.quietExceptions", false );
		dc.setBrowserName("firefox");
		driver = new RemoteWebDriver( new URL("http://" + host + ":" + port + "/wd/hub"), dc );
		driver.manage().timeouts().implicitlyWait( DEFAULT_IMPLICIT_WAIT, TimeUnit.MILLISECONDS );
		WebDriverManager.positionMainHandle(driver);
		return driver;
	}
}
