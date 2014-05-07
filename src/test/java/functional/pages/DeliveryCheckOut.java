package functional.pages;

import org.openqa.selenium.WebDriver;
import functional.testdata.GuestUser;
import functional.testdata.SubscribedUser;
import static org.fluentlenium.core.filter.FilterConstructor.withId;

public class DeliveryCheckOut extends BasePage {

	private static final String EMAIL = "#email_login";
	private static final String PASSWORD = "#pwd_login";
	private static final String LOGIN = "#loginFromCheckout";
	private static final String I_AM_NEW_TO_DAN_MURPHYS = "guest-user";
	private static final String GUEST_FIRST_NAME = "#aboutYouFName";
	private static final String GUEST_LAST_NAME = "#aboutYouLName";
	private static final String GUEST_EMAIL = "#idUserEmail";
	private static final String GUEST_DAY_OF_BIRTH = "#dayOfBirth-DOB";
	private static final String GUEST_MONTH_OF_BIRTH = "#monthOfBirth-DOB";
	private static final String GUEST_YEAR_OF_BIRTH = "#yearOfBirth-DOB";
	private static final String GUEST_MOBILE = "#phone";
	private static final String NEXT = "#aboutYouNext";

	public DeliveryCheckOut(WebDriver driver) {
		super(driver);
	}

	@Override
	protected String getExpectedTitle() {
		return "Buy Wine, Champagne, Beer & Spirits Online";
	}

	public AboutYou checkoutToDeliveryDetailsAsRegisteredUser() {
		SubscribedUser user = SubscribedUser.newSubscribedUserDetails();
		fill(EMAIL).with(user.getSubscribedUserName());
		fill(PASSWORD).with(user.getSubscribedUserPassword());
		click(LOGIN);
		waitForPageToLoad();
		return new AboutYou(getDriver());
	}

	public PickUpDetails checkoutToDeliveryDetailsAsGuestUser(GuestUser user) {
		find(INPUT, withId().contains(I_AM_NEW_TO_DAN_MURPHYS)).click();
		fill(GUEST_FIRST_NAME).with(user.getGuestUserFirstName());
		fill(GUEST_LAST_NAME).with(user.getGuestUserLastName());
		fill(GUEST_EMAIL).with(user.getGuestUserEmail());
		fill(GUEST_DAY_OF_BIRTH).with(user.getGuestUserDayOfBirth());
		fill(GUEST_MONTH_OF_BIRTH).with(user.getGuestUserMonthOfBirth());
		fill(GUEST_YEAR_OF_BIRTH).with(user.getGuestUserYearOfBirth());
		fill(GUEST_MOBILE).with(user.getGuestUserMobileNumber());
		click(NEXT);
		waitForPageToLoad();
		return new PickUpDetails(getDriver());
	}
}
