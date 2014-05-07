package functional.pages;

import org.openqa.selenium.WebDriver;

import functional.pages.BasePage;
import functional.pages.DeliveryCheckOut;
import functional.testdata.DeliveryType;
import functional.testdata.Order;
import functional.testdata.OrderType;
import static org.fluentlenium.core.filter.FilterConstructor.withClass;

public class CheckOutPage extends BasePage {

	private static final String I_AM_NEW_TO_DAN_MURPHYS = "#guest-user-details-radio";
	private static final String DELIVERY_CHECKOUT = ".btn-red.right";
	private static final String CLICK_AND_COLLECT_POSTCODE = "#txtPostcode1";
	private static final String DELIVERY = "ico-radio";
	private static final String CLICK_AND_COLLECT = "ico-radio";
	private static final String VIEW_DELIVERY_OPTIONS = "#delEstimClick";

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected String getExpectedTitle() {
		return "Buy Wine, Champagne, Beer & Spirits Online";
	}

	public DeliveryCheckOut enterDeliveryDetailsAndProceedToCheckout(Order order) {
		selectOrderTypeAs(order.getOrderType());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		enterPostCodeForDelivery(order.getOrderType(), order.getPostCode(),
				order.getSuburb());
		selectDeliveryType(order.getDeliveryType());
		proceedToDeliveryCheckout();
		return new DeliveryCheckOut(getDriver());
	}

	public DeliveryCheckOut enterClickAndCollectDetailsAndProceedToCheckout(
			Order order) {
		selectOrderTypeAs(order.getOrderType());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		enterPostCodeForDelivery(order.getOrderType(), order.getPostCode(),
				order.getSuburb());
		setStore();
		proceedToDeliveryCheckout();
		return new DeliveryCheckOut(getDriver());
	}

	private void setStore() {
		findFirst(ANCHORTAG, withClass().contains("setstore")).click();
		waitForPageToLoad();
	}

	private void proceedToDeliveryCheckout() {
		click(DELIVERY_CHECKOUT);
		waitForElementVisible(I_AM_NEW_TO_DAN_MURPHYS);
	}

	private void selectDeliveryType(DeliveryType deliveryType) {
		executeScript((Order.getdeliveryTypes().get(deliveryType))
				+ ".click();");
	}

	private void selectOrderTypeAs(OrderType orderType) {
		if (orderType.getOrderType().equalsIgnoreCase("Delivery")) {
			find(SPAN, withClass(DELIVERY)).first().click();
			waitForElementVisible(VIEW_DELIVERY_OPTIONS);
		} else {
			find(DIV, withClass().contains("clickcollect")).find(SPAN,
					withClass(CLICK_AND_COLLECT)).click();
			waitForElementToBeEnabled(CLICK_AND_COLLECT_POSTCODE);
		}
	}
}
