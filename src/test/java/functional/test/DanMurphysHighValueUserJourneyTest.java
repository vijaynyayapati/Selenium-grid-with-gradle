package functional.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;

import functional.test.BaseTestSetup;
import functional.testdata.GuestUser;
import functional.testdata.Order;

@RunWith(ConcurrentTestRunner.class)
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
	
	@Test
	public void subscribedUser_addingFromSearchGallery_standard_delivery_singleAddress_usingPayPal_qtyBottles() {
		Order order = Order.standardDeliveryWithPostcodeAndSuburb();
		launchDanMurphysOnline().searchFor("Red Wine").addItemToShoppingCart()
				.viewTheCartAndValidateItems()
				.enterDeliveryDetailsAndProceedToCheckout(order);
	}

	@Test
	public void subscribedUser_addingItemFromDepartmentPage_clickAndCollect_sevenDays_usingCC_qtyBottles() {
		Order order = Order.clickAndCollectDeliveryWithPostcodeAndSuburb();
		launchDanMurphysOnline().selectFromMegaNav("Sparkling", "Yellowglen")
				.addItemToShoppingCart().viewTheCartAndValidateItems()
				.enterClickAndCollectDetailsAndProceedToCheckout(order);
	}
	
}

