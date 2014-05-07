package functional.pages;

import org.openqa.selenium.WebDriver;

import functional.testdata.Order;
import static org.fluentlenium.core.filter.FilterConstructor.withClass;
import static org.fluentlenium.core.filter.FilterConstructor.withName;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

public class Payments extends BasePage {

	private static final String COUNTRY = "#select-country";
	private static final String POSTCODE_SEARCH = "postcode-search";
	private static final String POSTCODE_FIND_BUTTON = "#postcodeFind";
	private static final String ADDRESS_LINE1 = "#address1-au";
	private static final String SUBMIT_BILLING_ADDRESS = "#billing-address-new-au";
	private static final String CREDIT_DEBIT_CARD = "card";
	private static final String AGREE_TO_TERMS_AND_CONDITIONS = "tncagree";
	private static final String ACCEPT_AGE_OVER_EIGHTEEN = "ageagree";

	public Payments(WebDriver driver) {
		super(driver);
	}

	@Override
	protected String getExpectedTitle() {
		return "|";
	}

	public Payments enterAndSubmitBillingAddressDetails(Order order) {
		fillSelect(COUNTRY).withValue("AU");
		waitForElementVisible(POSTCODE_FIND_BUTTON);
		fill(INPUT, withClass().contains(POSTCODE_SEARCH)).with(
				order.getPostCode());
		find(
				ANCHORTAG,
				withText(generatePostCodeSuburbStateText(order.getPostCode(),
						order.getSuburb()))).click();
		waitForElementVisible(ADDRESS_LINE1);
		fill(ADDRESS_LINE1).with(order.getBillingAddressLine1());
		click(SUBMIT_BILLING_ADDRESS);
		waitForPageToLoad();
		return this;
	}

	public Payments payByCreditCard() {
		find(INPUT, withName().contains(CREDIT_DEBIT_CARD)).click();
		return this;
	}

	public Payments acceptTermsAndConditions() {
		find(INPUT, withName().contains(AGREE_TO_TERMS_AND_CONDITIONS)).click();
		return this;
	}

	public Payments acceptAgeOverEighteen() {
		find(INPUT, withName().contains(ACCEPT_AGE_OVER_EIGHTEEN)).click();
		return this;
	}

	public Payments enterPaymentDetailsAndConfirmOrder(Order order) {
		enterAndSubmitBillingAddressDetails(order);
		payByCreditCard();
		acceptTermsAndConditions();
		acceptAgeOverEighteen();
		return this;
	}

}
