package functional.testdata;

public class GuestUser extends User {

	private String guestUserFirstName;
	private String guestUserLastName;
	private String guestUserEmail;
	private String guestUserDayOfBirth;
	private String guestUserMonthOfBirth;
	private String guestUserYearOfBirth;
	private String guestUserMobileNumber;

	public GuestUser(String guestUserFirstName, String guestUserLastName,
			String guestUserEmail, String guestUserDayOfBirth,
			String guestUserMonthOfBirth, String guestUserYearOfBirth,
			String guestUserMobileNumber) {
		this.guestUserFirstName = guestUserFirstName;
		this.guestUserLastName = guestUserLastName;
		this.guestUserEmail = guestUserEmail;
		this.guestUserDayOfBirth = guestUserDayOfBirth;
		this.guestUserMonthOfBirth = guestUserMonthOfBirth;
		this.guestUserYearOfBirth = guestUserYearOfBirth;
		this.guestUserMobileNumber = guestUserMobileNumber;
	}

	public String getGuestUserFirstName() {
		return guestUserFirstName;
	}

	public void setGuestUserFirstName(String guestUserFirstName) {
		this.guestUserFirstName = guestUserFirstName;
	}

	public String getGuestUserLastName() {
		return guestUserLastName;
	}

	public void setGuestUserLastName(String guestUserLastName) {
		this.guestUserLastName = guestUserLastName;
	}

	public String getGuestUserEmail() {
		return guestUserEmail;
	}

	public void setGuestUserEmail(String guestUserEmail) {
		this.guestUserEmail = guestUserEmail;
	}

	public String getGuestUserDayOfBirth() {
		return guestUserDayOfBirth;
	}

	public void setGuestUserDayOfBirth(String guestUserDayOfBirth) {
		this.guestUserDayOfBirth = guestUserDayOfBirth;
	}

	public String getGuestUserMonthOfBirth() {
		return guestUserMonthOfBirth;
	}

	public void setGuestUserMonthOfBirth(String guestUserMonthOfBirth) {
		this.guestUserMonthOfBirth = guestUserMonthOfBirth;
	}

	public String getGuestUserYearOfBirth() {
		return guestUserYearOfBirth;
	}

	public void setGuestUserYearOfBirth(String guestUserYearOfBirth) {
		this.guestUserYearOfBirth = guestUserYearOfBirth;
	}

	public String getGuestUserMobileNumber() {
		return guestUserMobileNumber;
	}

	public void setGuestUserMobileNumber(String guestUserMobileNumber) {
		this.guestUserMobileNumber = guestUserMobileNumber;
	}

	public static GuestUser newGuestUserDetails() {
		return new GuestUser("Viren", "Khatri", "viren.khatri@woolies.com.au",
				"10", "10", "1977", "0411000111");
	}

}
