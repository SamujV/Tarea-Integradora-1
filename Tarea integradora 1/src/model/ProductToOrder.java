package model;

public class ProductToOrder {
	
	private String productCode;
	private int amount;
	
	public ProductToOrder(String pCode, int amount) {
		this.productCode = pCode;
		this.amount = amount;
	}
	
	
	public void setProductCode(String code) {
		productCode = code;
	}
	public void setAmount(int a) {
		amount = a;
	}
		
	public String getProductCode() {
		return productCode;
	}
	public int getAmount() {
		return amount;
	}
	
	
	

}
