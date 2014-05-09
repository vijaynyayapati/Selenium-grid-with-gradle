package functional.providers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeWebDriverFactory implements WebDriverFactory {

	RemoteWebDriver driver;
	public static int DEFAULT_IMPLICIT_WAIT = 30;
	
	public WebDriver create(String host, int port) throws Exception {
		PropertyManager props = new PropertyManager();
		System.setProperty("webdriver.chrome.driver", pathToChromeDriver(props));
		HashMap<String, Object> chromeOptions = new HashMap<String, Object>();
		putChromeBinaryInChromeOptions(chromeOptions, props);
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		dc.setCapability( "takesScreenshot", true );
		dc.setCapability( "webdriver.remote.quietExceptions", false );
		dc.setBrowserName("chrome");
		driver = new RemoteWebDriver( new URL("http://" + host + ":" + port + "/wd/hub"), dc );
		driver.manage().timeouts().implicitlyWait( DEFAULT_IMPLICIT_WAIT, TimeUnit.MILLISECONDS );
		WebDriverManager.positionMainHandle(driver);
		return driver;
	}

	private static void putChromeBinaryInChromeOptions(
			HashMap<String, Object> chromeOptions, PropertyManager props)
			throws IOException {
		chromeOptions
				.put("binary", props.getPropertyValue("chrome.binarypath"));
	}

	private static String pathToChromeDriver(PropertyManager props)
			throws IOException {
		return props.getAbsolutePathForProperty("chrome.driverpath");
	}

}
