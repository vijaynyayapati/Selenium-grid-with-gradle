package functional.providers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class Browser {

	private final WebDriver webDriver;

	public Browser(WebDriver webDriver) {
		this.webDriver = webDriver;
		setWindowSize();
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	private void setWindowSize() {
		webDriver.manage().window().setPosition(new Point(0, 0));
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		Dimension dim = new Dimension((int) screenSize.getWidth(),
				(int) screenSize.getHeight());
		webDriver.manage().window().setSize(dim);
	}
}
