package model;

import java.util.ArrayList;

public class Restaurant {
	
	private ArrayList<Product> products;
	private String name;
	private String nit;
	private String namAdmin;
	
	
	public Restaurant(String nam, String niT, String namA) {
		products = new ArrayList<>();
		name = nam;
		nit = niT;
		namAdmin = namA;
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	public String getName() {
		return name;
	}

	public String getNit() {
		return nit;
	}

	public String getNamAdmin() {
		return namAdmin;
	}

	public void setName(String nam) {
		name = nam;
	}
	public void setNit(String niT) {
		nit = niT;
	}
	public void setNamAdmin(String namA){
		namAdmin = namA;
	}
	

}
