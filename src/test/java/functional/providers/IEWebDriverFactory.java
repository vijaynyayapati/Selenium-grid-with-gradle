package functional.providers;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IEWebDriverFactory implements WebDriverFactory {

	RemoteWebDriver driver;
	public static int DEFAULT_IMPLICIT_WAIT = 30;
	
	@Override
	public WebDriver create(String host, int port) throws IOException {
		PropertyManager props = new PropertyManager();
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		dc.setCapability( "takesScreenshot", true );
		dc.setCapability( "webdriver.remote.quietExceptions", false );
		dc.setBrowserName("firefox");
		dc.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		System.setProperty("webdriver.ie.driver", pathToIEDriver(props));
		driver = new RemoteWebDriver( new URL("http://" + host + ":" + port + "/wd/hub"), dc );
		driver.manage().timeouts().implicitlyWait( DEFAULT_IMPLICIT_WAIT, TimeUnit.MILLISECONDS );
		WebDriverManager.positionMainHandle();
		return driver;
	}

	private String pathToIEDriver(PropertyManager props) throws IOException {
		return props.getAbsolutePathForProperty("ie.driverpath");
	}
}
