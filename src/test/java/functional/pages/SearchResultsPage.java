package functional.pages;

import org.openqa.selenium.WebDriver;
import functional.pages.BasePage;

public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected String getExpectedTitle() {
		return "Online";
	}
}
