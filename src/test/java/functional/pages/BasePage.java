package functional.pages;

import static org.fest.assertions.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withName;
import static org.fluentlenium.core.filter.FilterConstructor.withText;
import static org.fluentlenium.core.filter.FilterConstructor.withClass;
import org.openqa.selenium.WebDriver;
import functional.providers.PageUtils;
import functional.testdata.OrderType;

public abstract class BasePage extends PageUtils {

	private static final String NUMBER_OF_ITEMS_IN_CART = "#header-cart-msg";
	private static final String SHOPPING_CART_CONTAINER = ".shopping-cart-container";
	private static final String VIEW_CART = "View Cart";
	private static final String DELIVERY_POSTCODE_SUBURB = "postalField";
	private static final String CLICK_AND_COLLECT_POSTCODE = "#txtPostcode1";
	public static final String ANCHORTAG = "a";
	public static final String BUTTON = "button";
	public static final String INPUT = "input";
	public static final String SPAN = "span";
	public static final String DIV = "div";

	protected BasePage(WebDriver driver) {
		super(driver);
		assertThat(title()).contains(getExpectedTitle());
	}

	protected abstract String getExpectedTitle();

	public void verifyItemAddedToCart() {
		assertThat(element(NUMBER_OF_ITEMS_IN_CART).hasText("1"));
	}

	public CheckOutPage viewTheCartAndValidateItems() {
		find(ANCHORTAG, withText(VIEW_CART)).click();
		waitForElementVisible(SHOPPING_CART_CONTAINER);
		return new CheckOutPage(getDriver());
	}

	public void enterPostCodeForDelivery(OrderType orderType, String postCode,
			String suburb) {
		if (orderType.toString().equalsIgnoreCase("Delivery")) {
			fill(INPUT, withName(DELIVERY_POSTCODE_SUBURB)).with(suburb);
		} else {
			fill(CLICK_AND_COLLECT_POSTCODE).with(suburb);
		}
		find(ANCHORTAG,
				withText(generateSuburbPostCodeStateText(postCode, suburb)))
				.click();
	}

	public String generateSuburbPostCodeStateText(String postCode, String suburb) {
		return suburb + " " + postCode + ", NSW";
	}

	public String generatePostCodeSuburbStateText(String postCode, String suburb) {
		return postCode + " " + suburb + ", NSW";
	}

	public BasePage addItemToShoppingCart() {
		findFirst(ANCHORTAG, withClass("btn-red")).click();
		verifyItemAddedToCart();
		return this;
	}
}
