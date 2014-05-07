package functional.providers;

import java.util.concurrent.TimeUnit;
import org.fest.assertions.fluentlenium.custom.FluentListAssert;
import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageUtils extends FluentPage {

	public PageUtils(WebDriver driver) {
		super(driver);
	}

	public void waitForElementVisible(final String element) {
		await().atMost(10, TimeUnit.SECONDS).until(element).areDisplayed();
	}

	public void waitForPageToLoad() {
		await().atMost(10, TimeUnit.SECONDS).untilPage().isLoaded();
	}

	public void waitForElementToBeEnabled(final String element) {
		await().atMost(10, TimeUnit.SECONDS).until(element).areEnabled();
	}

	public FluentListAssert element(String element) {
		return new FluentListAssert(find(element));
	}

	public void mouseHover(String element) {
		Actions actions = new Actions(getDriver());
		WebElement menuHoverLink = getDriver().findElement(
				By.partialLinkText(element));
		actions.moveToElement(menuHoverLink).build().perform();
	}
}
