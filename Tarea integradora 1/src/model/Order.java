package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
public class Order {


	private String code;
	private String idCust;
	private String nitRest;
	private OrderStatus status;
	private String currentTime;
	private String currentDate;
	private List<Product> productsToOrder;

	public Order(String idCust, String nitRest) {
		this.idCust = idCust;
		this.nitRest = nitRest;
		status = OrderStatus.REQUESTED;
		
		code = UUID.randomUUID().toString();
		generateDateTime();
	}

	public String getIdCust() {
		return idCust;
	}
	public String getCode() {
		return code;
	}

	public void setIdCust(String idCust) {
		this.idCust = idCust;
	}

	public String getNitRest() {
		return nitRest;
	}

	public void setNitRest(String nitRest) {
		this.nitRest = nitRest;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void generateDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a ");
		Date date = new Date();
		currentTime  = dateFormat.format(date);
		String strDateFormat = "dd-MMM-yyyy"; 
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); 
		currentDate = objSDF.format(date);

	}


	public void setStatus(OrderStatus oStatus) {
		status = oStatus;
	}



}
