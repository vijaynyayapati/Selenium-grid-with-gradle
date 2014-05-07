package functional.pages;

import org.openqa.selenium.WebDriver;

import functional.testdata.Order;
import static org.fluentlenium.core.filter.FilterConstructor.withClass;

public class DeliveryDetails extends BasePage {

	/**
	 * 
	 */
	private static final String ADDRESS_LINE1 = "address1";
	private static final String NEXT = "btn-red";
	private static final String DELIVER_TO_SINGLE_ADDRESS = "single-delivery-radio";

	public DeliveryDetails(WebDriver driver) {
		super(driver);
	}

	@Override
	protected String getExpectedTitle() {
		return "Dan Murphy's | Lowest Liquor Price Guarantee!";
	}
	
	public Payments deliverToSingleAddressAndProceedToPayments(Order order){
		click(DELIVER_TO_SINGLE_ADDRESS);
		waitForElementToBeEnabled(ADDRESS_LINE1);
		fill(ADDRESS_LINE1).with(order.getBillingAddressLine1());
		find(ANCHORTAG, withClass().contains(NEXT)).click();
		waitForPageToLoad();
		return new Payments(getDriver());
	}
}
