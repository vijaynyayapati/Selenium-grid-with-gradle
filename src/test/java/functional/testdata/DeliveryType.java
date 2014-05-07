package functional.testdata;

public enum DeliveryType {
	STANDARD("Standard"), 
	SAME_DAY("Same Day"), 
	NEXT_DAY("Next Day"), 
	PICK_A_DATE("Pick a date"), 
	NOT_APPLICABLE("Not Applicable");

	private final String deliveryType;

	private DeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	@Override
	public String toString() {
		return deliveryType;
	}

}
