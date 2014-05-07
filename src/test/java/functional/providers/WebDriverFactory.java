package functional.providers;

import org.openqa.selenium.WebDriver;

interface WebDriverFactory {
	WebDriver create(String host, int port) throws Exception;

}
