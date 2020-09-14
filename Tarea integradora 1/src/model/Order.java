package model;

import java.util.List;

public class Order {

	public static final String REQUESTED = "requested";
	public static final String IN_PROCESS= "in process";
	public static final String SENT = "sent";
	public static final String DELIVERED = "delivered";

	private String code;
	private int idClient;
	private String nitRest;
	private String status;
	private List<Product> productsToOrder;
	
	
	
	
	
	
}
