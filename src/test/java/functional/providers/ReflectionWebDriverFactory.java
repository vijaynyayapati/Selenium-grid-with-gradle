package functional.providers;

import org.openqa.selenium.WebDriver;

public class ReflectionWebDriverFactory implements WebDriverFactory {
	private final String className;

	public ReflectionWebDriverFactory(String className) {
		this.className = className;
	}

	@Override
	public WebDriver create(String host, int port) throws Exception {
		@SuppressWarnings("unchecked")
		Class<? extends WebDriver> driverClass = (Class<? extends WebDriver>) Class
				.forName(className);
		return driverClass.newInstance();
	}
}
