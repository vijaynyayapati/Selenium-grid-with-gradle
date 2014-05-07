package functional.pages;

import org.openqa.selenium.WebDriver;

import functional.testdata.SubscribedUser;

public class AboutYou extends BasePage {

	private static final String DAY_OF_BIRTH = "#dayOfBirth-DOB";
	private static final String MONTH_OF_BIRTH = "#monthOfBirth-DOB";
	private static final String YEAR_OF_BIRTH = "#yearOfBirth-DOB";
	private static final String MOBILE = "#phone";
	private static final String NEXT = "#saveAboutYouDetailsNext";

	public AboutYou(WebDriver driver) {
		super(driver);
	}

	@Override
	protected String getExpectedTitle() {
		return "Dan Murphy's | Lowest Liquor Price Guarantee!";
	}

	public DeliveryDetails enterPersonalDetailsAndProceedToDeliveryDetails() {
		SubscribedUser user = SubscribedUser.newSubscribedUserDetails();
		waitForElementVisible(DAY_OF_BIRTH);
		fill(DAY_OF_BIRTH).with(user.getSubscribedUserDayOfBirth());
		fill(MONTH_OF_BIRTH).with(user.getSubscribedUserMonthOfBirth());
		fill(YEAR_OF_BIRTH).with(user.getSubscribedUserYearOfBirth());
		fill(MOBILE).with(user.getSubscribedUserMobile());
		click(NEXT);
		waitForPageToLoad();
		return new DeliveryDetails(getDriver());
	}
}
