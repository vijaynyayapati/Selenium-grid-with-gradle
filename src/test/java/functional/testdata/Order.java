package functional.testdata;

import java.util.HashMap;
import java.util.Map;

public class Order {
	
	private static final String PICK_A_DATE = "$("+"\""+"[id='PADradio']"+"\""+")";
	private static final String NEXT_DAY = "$("+"\""+"[id='NBDradio']"+"\""+")";
	private static final String SAME_DAY = "$("+"\""+"[id='SDDradio']"+"\""+")";
	private static final String STANDARD_DELIVERY = "$("+"\""+"[id='NORradio']"+"\""+")";
	private OrderType orderType;
	private DeliveryType deliveryType;
	private String postCode;
	private String suburb;
	private String billingAddressLine1;
	public static Map<String, String> deliveryTypes;
		
	public Order(OrderType orderType, DeliveryType deliveryType, String billingAddressLine1, String postCode, String suburb){
		this.orderType = orderType;
		this.deliveryType = deliveryType;
		this.postCode = postCode;
		this.suburb = suburb;
		this.billingAddressLine1 = billingAddressLine1;
	}

	public String getBillingAddressLine1() {
		return billingAddressLine1;
	}

	public void setBillingAddressLine1(String billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	
	public static Order standardDeliveryWithPostcodeAndSuburb(){
		return new Order(OrderType.DELIVERY, 
						 DeliveryType.STANDARD,
						 "136 Bridge Road",
						 "2145", 
						 "Wentworthville");
	}
	
	public static Order nextDayDeliveryWithPostcodeAndSuburb(){
		return new Order(OrderType.DELIVERY, 
						 DeliveryType.NEXT_DAY,
						 "",
						 "2145", 
						 "Wentworthville");
	}
	
	public static Order clickAndCollectDeliveryWithPostcodeAndSuburb(){
		return new Order(OrderType.CLICK_AND_COLLECT, 
						 DeliveryType.NOT_APPLICABLE,
						 "136 Bridge Road",
						 "2145", 
						 "Wentworthville");
	}
	
	public static Map<DeliveryType, String> getdeliveryTypes(){
		Map<DeliveryType, String> deliveryTypes = new HashMap<DeliveryType, String>();
		deliveryTypes.put(DeliveryType.STANDARD, STANDARD_DELIVERY);
		deliveryTypes.put(DeliveryType.SAME_DAY, SAME_DAY);
		deliveryTypes.put(DeliveryType.NEXT_DAY, NEXT_DAY);
		deliveryTypes.put(DeliveryType.PICK_A_DATE, PICK_A_DATE);
		return deliveryTypes;
	}
}
