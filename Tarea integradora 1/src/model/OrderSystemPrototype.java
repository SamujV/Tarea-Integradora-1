package model;

import java.util.ArrayList;
import java.util.List;

public class OrderSystemPrototype {

	private List<Customer> customers;
	private List<Order> orders;
	private List<Product> products;
	private List<Restaurant> restaurants;

	public OrderSystemPrototype() {

		customers = new ArrayList<>();
		orders = new ArrayList<>();
		products = new ArrayList<>();
		restaurants = new ArrayList<>();
	}

	public void registerRestaurant(String nam, String nit, String namA) {
		Restaurant r = new Restaurant(nam, nit, namA);
		restaurants.add(r);

	}

	public void registerCustomer(String type, int id, String fullNam, String phone, String address) {
		Customer c = new Customer(type, id, fullNam, phone, address);
		addByFirstALastNameDescending(c);
	}

	public void addByFirstALastNameDescending(Customer c) {
		if(customers.size() ==0) {
			customers.add(c);
		}else {
			
			
			
			
			
		}
		
	}
	
	
	
	public List<Customer> getCustomers(){
		return customers;
	}
	public List<Order> getOrders(){
		return orders;
	}public List<Product> getProducts(){
		return products;
	}
	public List<Restaurant> getRestaurants(){
		return restaurants;
	}



































}
