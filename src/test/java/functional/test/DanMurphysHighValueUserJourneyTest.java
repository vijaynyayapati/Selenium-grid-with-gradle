package functional.test;

import org.junit.Test;
import functional.test.BaseTestSetup;
import functional.testdata.GuestUser;
import functional.testdata.Order;

public class DanMurphysHighValueUserJourneyTest extends BaseTestSetup {

	@Test
	public void guest_addingItemThroughRecommendedList_clickAndCollect_singleAddress_usingCC_qtyBottles() {
		Order order = Order.clickAndCollectDeliveryWithPostcodeAndSuburb();
		GuestUser user = GuestUser.newGuestUserDetails();
		launchDanMurphysOnline().addItemToShoppingCartFromAdvertisedOffers()
				.viewTheCartAndValidateItems()
				.enterClickAndCollectDetailsAndProceedToCheckout(order)
				.checkoutToDeliveryDetailsAsGuestUser(user).proceedToPayments()
				.enterPaymentDetailsAndConfirmOrder(order);
	}
}
