package functional.providers;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import functional.providers.Browser;

public class WebDriverManager {

	private static List<Browser> allBrowsers = Collections
			.synchronizedList(new LinkedList<Browser>());
	public static final String FIREFOX_DRIVER = "Firefox";
	public static final String CHROME_DRIVER = "Chrome";
	private static final String DEFAULT_DRIVER = CHROME_DRIVER;
	protected static RemoteWebDriver driver;
	public static int DEFAULT_IMPLICIT_WAIT = 30;
	protected static String mainHandle = "";
	protected static String mainWindowTitle = "";
	protected static Set<String> handleCache = new HashSet<String>();

	private ThreadLocal<Browser> webDriver = new ThreadLocal<Browser>() {
		@Override
		protected Browser initialValue() {
			Browser browsers = getInstance();
			allBrowsers.add(browsers);
			return browsers;
		}
	};

	@SuppressWarnings("serial")
	private static final Map<String, WebDriverFactory> TYPE_TO_FACTORY_MAP = new HashMap<String, WebDriverFactory>() {
		{
			put(FIREFOX_DRIVER, new FirefoxWebDriverFactory());
			put(CHROME_DRIVER, new ChromeWebDriverFactory());
		}
	};

	private Browser create() throws Exception {
		String driverType = getDriverType();
		System.out.println("Initialising " + driverType);
		if (TYPE_TO_FACTORY_MAP.containsKey(driverType)) {
			WebDriverFactory factory = TYPE_TO_FACTORY_MAP.get(driverType);
			return new Browser(factory.create( 
					  System.getProperty("hubIP"), 
					  Integer.parseInt( System.getProperty("hubPort"))));
		}
		return new Browser(new ReflectionWebDriverFactory(driverType).create(System.getProperty("hubIP"), 
				  Integer.parseInt( System.getProperty("hubPort"))));
	}

	private Browser getInstance() {
		try {
			return create();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Browser browser() {
		return webDriver.get();
	}

	public WebDriver getWebDriver() {
		return browser().getWebDriver();
	}

	private static String getDriverType() {
		return System.getProperties().getProperty("browser", DEFAULT_DRIVER);
	}	

	public static void positionMainHandle(WebDriver driver) {
		handleCache = driver.getWindowHandles();
		if ( handleCache.size() == 0 ) {
			mainHandle = "";
			throw new IllegalStateException("No browser window handles are open.\n" +
					"Browser is uninitialized.");
		} else if ( handleCache.size() > 1 ) {
			mainHandle = "";
			throw new IllegalStateException("More than one browser window handle is open.\n" +
					"Please close all browsers and restart test.");
		} else {
			mainHandle = driver.switchTo().defaultContent().getWindowHandle();
			mainWindowTitle = driver.switchTo().defaultContent().getTitle();
		}
	}

	public static void setWindowPosition(String handle, int width, int height, int fleft, int ftop, WebDriver driver) {
		driver.switchTo().window( handle ).manage().window().setPosition( new Point(fleft, ftop) );
		driver.switchTo().window( handle ).manage().window().setSize( new Dimension( width, height) );
		//TODO add a javascript executor to get window focus
	}
	
	public void closeAllBrowserWindows(WebDriver driver) {
		Set<String> handles = driver.getWindowHandles();
		if ( handles.size() > 1 ) {
			System.out.println("Closing " + handles.size() + " window(s).");
			for ( String windowId : handles ) {
				System.out.println("-- Closing window handle: " + windowId );
				driver.switchTo().window( windowId ).close();
			}
		} else if ( handles.size()==1 ) {
			System.out.println("Closing last open window.");
		} else {
			System.out.println("There were no window handles to close.");
		}
		driver.quit();
	}
	
}
