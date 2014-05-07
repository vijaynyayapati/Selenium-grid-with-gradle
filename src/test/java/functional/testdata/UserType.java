package functional.testdata;

public enum UserType {
	SUBSCRIBED_USER("Subscribed"), 
	GUEST_USER("Guest");

	private final String userType;

	private UserType(String userType) {
		this.userType = userType;
	}

	public String getUserType() {
		return userType;
	}

	@Override
	public String toString() {
		return userType;
	}
}
