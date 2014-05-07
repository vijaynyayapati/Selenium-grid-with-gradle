package functional.testdata;

import functional.testdata.SubscribedUser;

public class SubscribedUser extends User {

	private String subscribedUserName;
	private String subscribedUserPassword;
	private String subscribedUserMobile;
	private String subscribedUserDayOfBirth;
	private String subscribedUserMonthOfBirth;
	private String subscribedUserYearOfBirth;

	public SubscribedUser(String userName, String password, String mobile,
			String day, String month, String year) {
		this.subscribedUserName = userName;
		this.subscribedUserPassword = password;
		this.subscribedUserMobile = mobile;
		this.subscribedUserDayOfBirth = day;
		this.subscribedUserMonthOfBirth = month;
		this.subscribedUserYearOfBirth = year;
	}

	public String getSubscribedUserDayOfBirth() {
		return subscribedUserDayOfBirth;
	}

	public void setSubscribedUserDayOfBirth(String subscribedUserDayOfBirth) {
		this.subscribedUserDayOfBirth = subscribedUserDayOfBirth;
	}

	public String getSubscribedUserMonthOfBirth() {
		return subscribedUserMonthOfBirth;
	}

	public void setSubscribedUserMonthOfBirth(String subscribedUserMonthOfBirth) {
		this.subscribedUserMonthOfBirth = subscribedUserMonthOfBirth;
	}

	public String getSubscribedUserYearOfBirth() {
		return subscribedUserYearOfBirth;
	}

	public void setSubscribedUserYearOfBirth(String subscribedUserYearOfBirth) {
		this.subscribedUserYearOfBirth = subscribedUserYearOfBirth;
	}

	public String getSubscribedUserMobile() {
		return subscribedUserMobile;
	}

	public void setSubscribedUserMobile(String subscribedUserMobile) {
		this.subscribedUserMobile = subscribedUserMobile;
	}

	public String getSubscribedUserName() {
		return subscribedUserName;
	}

	public void setSubscribedUserName(String subscribedUserName) {
		this.subscribedUserName = subscribedUserName;
	}

	public String getSubscribedUserPassword() {
		return subscribedUserPassword;
	}

	public void setSubscribedUserPassword(String subscribedUserPassword) {
		this.subscribedUserPassword = subscribedUserPassword;
	}

	public static SubscribedUser newSubscribedUserDetails() {
		return new SubscribedUser("max@kumar.com", 
				"asdfzxcv",
				"0411111000", 
				"01", 
				"01", 
				"1980");
	}
}
