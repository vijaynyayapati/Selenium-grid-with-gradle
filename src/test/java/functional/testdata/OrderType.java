package functional.testdata;

public enum OrderType {
	DELIVERY("Delivery"), 
	CLICK_AND_COLLECT("Click and Collect");

	private final String orderType;

	private OrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderType() {
		return orderType;
	}

	@Override
	public String toString() {
		return orderType;
	}
}
