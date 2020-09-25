package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Comparator;
import java.util.List;

public class OrderSystemPrototype {

	private List<Customer> customers;
	private List<Order> orders;
	private List<Product> products;
	private List<Restaurant> restaurants;
	private String prueba = "";
	public OrderSystemPrototype() {

		customers = new ArrayList<>();
		orders = new ArrayList<>();
		products = new ArrayList<>();
		restaurants = new ArrayList<>();
	}

	public void setPrueba(String añadir) {
		prueba += añadir + "\n";
	}
	public String getPrueba() {
		return prueba;
	}
	public void registerRestaurant(String nam, String nit, String namA) {
		Restaurant r = new Restaurant(nam, nit, namA);
		if(restaurants.isEmpty()) {
			restaurants.add(r);
		}else {
			int i = 0;
			while (i<restaurants.size() && nam.compareTo(restaurants.get(i).getName())>0) {
				i++;
			}
			restaurants.add(i, r);
		}		
	}

	public void registerProduct(String name, String description, double cost, String nitRes) {
		Product p = new Product( name, description, cost, nitRes);
		products.add(p);		
	}

	public void registerCustomer(String type, String id, String fullNam, String phone, String address) {
		Customer c = new Customer(type, id, fullNam, phone, address);
		if(customers.isEmpty()) {
			customers.add(c);
		}else {			
			int i = 0;
			while (i<customers.size() && c.compareTo(customers.get(i))<0) {
				i++;
			}
			customers.add(i, c);
		}
	}

	//restaurants.size!=0
	//customers.siz2 != 0
	//show 
	public void registerOrder(String idC, String nitRes) {
		Order o = new Order(idC, nitRes);
		orders.add(o);		
	}

	//restaurants.size != 0
	//nit has to exist
	//nit2 has to be a new one
	public void updateResData(String nit,String nam,String nit2, String namA) {

		boolean found = false;
		int start = 0;
		int end = restaurants.size()-1;
		Restaurant r1 = restaurants.get(0);
		while(start <= end && !found) {
			int half = (start + end)/2;
			r1 = restaurants.get(half);
			if(r1.getNit().equals(nit)) {
				found = true;
			}else if (r1.getNit().compareTo(nit)>0) {
				end = half - 1;
			}else {
				start = half + 1;
			}			
		}
		r1.setName(nam);
		r1.setNamAdmin(namA);
		r1.setNit(nit2);
	}
	//products.size != 0
	//code has to exist
	//code2 has to be a new one
	public void updateProdData(String code, String name, String description, double cost, String nitRes) {

		boolean found = false;
		int start = 0;
		int end = products.size()-1;
		Product p1 = products.get(0);
		while(start <= end && !found) {
			int half = (start + end)/2;
			p1 = products.get(half);
			if(p1.getCode().equals(code)) {
				found = true;
			}else if (p1.getCode().compareTo(code)>0) {
				end = half - 1;
			}else {
				start = half + 1;
			}			
		}
		p1.setName(name);
		p1.setDescription(description);
		p1.setCost(cost);
		p1.setNitRes(nitRes);
	}
	//customers.size != 0
	//id has to exist
	//id2 has to be a new one
	public void updateCustData(String id,String typeId, String id2, String fullNam, String phone, String address) {

		boolean found = false;
		int start = 0;
		int end = customers.size()-1;
		Customer c1 = customers.get(0);
		while(start <= end && !found) {
			int half = (start + end)/2;
			c1 = customers.get(half);
			if(c1.getId().equals(id)) {
				found = true;
			}else if (c1.getId().compareTo(id)>0) {
				end = half - 1;
			}else {
				start = half + 1;
			}			
		}
		c1.setTypeId(typeId);
		c1.setId(id2);
		c1.setFullName(fullNam);
		c1.setPhone(phone);
		c1.setAddress(address);	
	}
	//customers.size != 0
	//code has to exist
	public void updateOrdData(String code, String idCust, String nitRest) { // KIND OF DONE

		boolean found = false;
		int start = 0;
		int end = orders.size()-1;
		Order o1 = orders.get(0);
		while(start <= end && !found) {
			int half = (start + end)/2;
			o1 = orders.get(half);
			if(o1.getCode().equals(code)) {
				found = true;
			}else if (o1.getCode().compareTo(code)>0) {
				end = half - 1;
			}else {
				start = half + 1;
			}			
		}
		o1.setIdCust(idCust);
		o1.setNitRest(nitRest);
	}
	//code order has to exist
	public void changeOrderStatus(String orderCode) {
		Order o = getOrder(orderCode);

		if (o.getStatus() == OrderStatus.REQUESTED) {
			o.setStatus(OrderStatus.IN_PROCESS);
		}else if (o.getStatus() == OrderStatus.IN_PROCESS) {
			o.setStatus(OrderStatus.SENT);
		}else {
			o.setStatus(OrderStatus.DELIVERED);
		}		
	}

	public Order getOrder(String orderCode) {
		Order o = orders.get(0);		
		boolean found = false;
		int start = 0;
		int end = orders.size()-1;
		while(start <= end && !found) {
			int half = (start + end)/2;
			o = orders.get(half);
			if(o.getCode().equals(orderCode)) {
				found = true;
			}else if (o.getCode().compareTo(orderCode)>0) {
				end = half - 1;
			}else {
				start = half + 1;
			}			
		}	
		return o;		
	}



	public boolean existingRestaurantName(String rName) {
		boolean exist = false;		
		if (restaurants.size() > 0) {
			for (Restaurant r : restaurants) {				
				if (r.getName().equals(rName)) {
					exist = true;
				}				
			}
		}		
		return exist;
	}
	public boolean existingRestaurantNit(String rNit) {
		boolean exist = false;		
		if (restaurants.size() > 0) {
			for (Restaurant r : restaurants) {				
				if (r.getNit().equals(rNit)) {
					exist = true;
				}				
			}
		}		
		return exist;
	}

	public String restaurantsToString() {
		String list = "	Restaurants 	";
		list += "\nName:	Nit:	Admin: \n";		
		for (Restaurant res : restaurants) {
			list +=  res.getName() + ", " + res.getNit() + ", "+res.getNamAdmin()+"\n";
		}		
		return list;
	}


	public List<Customer> getCustomers(){
		return customers;
	}
	public String customersToString() {
		String toString = "";
		for (Customer customer : customers) {
			toString += "";
		}
		return toString;
	}


	public void importRestaurantsData(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while (line != null) {
			String[] parts = line.split(",");
			String nam = parts[0];
			String nit = parts[1];
			String namA = parts[2];				
			registerRestaurant(nam, nit, namA);
		}
		br.close();
	}


	public List<Order> getOrders(){
		return orders;
	}



	public List<Product> getProducts(){
		return products;
	}
	public List<Restaurant> getRestaurants(){
		return restaurants;
	}

































}
