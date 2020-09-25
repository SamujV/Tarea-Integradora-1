package model;

import java.util.UUID;

public class Product {

	private String code;
	private String name;
	private String description;
	private double cost;
	private String nitRes;
	

	
	public Product(String name, String description, double cost, String nitRes) {
		code = UUID.randomUUID().toString();
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.nitRes = nitRes;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getCost() {
		return cost;
	}



	public void setCost(double cost) {
		this.cost = cost;
	}



	public String getNitRes() {
		return nitRes;
	}



	public void setNitRes(String nitRes) {
		this.nitRes = nitRes;
	}





	
	
}
