package functional.pages;

import org.openqa.selenium.WebDriver;

import static org.fluentlenium.core.filter.FilterConstructor.withClass;

public class PickUpDetails extends BasePage {

	private static final String NEXT = "btn-red right";

	public PickUpDetails(WebDriver driver) {
		super(driver);
	}

	@Override
	protected String getExpectedTitle() {
		return "|";
	}

	public Payments proceedToPayments() {
		find(ANCHORTAG, withClass().contains(NEXT)).click();
		return new Payments(getDriver());
	}
}
