package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderSystemPrototypeTest {
	OrderSystemPrototype osp = new OrderSystemPrototype();

	public void setupScenary1() {
		osp.registerRestaurant("A", "12345", "alberto");
		osp.registerRestaurant("B", "123456", "marco");
		osp.registerRestaurant("C", "1234567", "rosa");
		osp.registerRestaurant("D", "12345678", "luz");	
	}
	public void setupScenary2() {
		osp.registerProduct("12345", "Chocolate", "very delicious dessert",4.0, "12345");
		osp.registerProduct("123456", "Juice", "very delicious drink",3.0, "123454");
		osp.registerProduct("1234567", "Apple", "very delicious fruit",2.0, "123245");
		osp.registerProduct("12345678", "Doritos", "very delicious chips",2.5, "123545");
	}
	public void setupScenary3() {
		osp.registerCustomer("CC", "12345", "Roberto Gomez Bolaños", "123", "address");
		osp.registerCustomer("TI", "123456", "Marco Tulio Bolaños", "1213", "address");
		osp.registerCustomer("CC", "1234567", "Alberto Henao Bolaños", "1223", "address");
		osp.registerCustomer("CC", "12345678", "Lucia Gomez Albarado", "1323", "address");
		
	}
	@Test
	void updateResDataTest() {
		setupScenary1();

		osp.updateResData("12345678", "E", "111", "Flaco");
		
		assertEquals("E",osp.getRestaurants().get(3).getName());
		assertEquals("111",osp.getRestaurants().get(3).getNit());
		assertEquals("Flaco",osp.getRestaurants().get(3).getNamAdmin());
	}
	
	@Test
	void updateProdDataTest() {
		setupScenary2();

		osp.updateProdData("12345678", "12345666", "Beer", "Delicious drink", 3.0, "12351");
		
		assertEquals("12345666",osp.getProducts().get(3).getCode());
		assertEquals("Beer",osp.getProducts().get(3).getName());
		assertEquals("Delicious drink",osp.getProducts().get(3).getDescription());
		assertEquals(3.0,osp.getProducts().get(3).getCost());
		assertEquals("12351",osp.getProducts().get(3).getNitRes());
		
	}
	
	@Test
	void updateCustDataTest() {
		setupScenary3();

		osp.updateCustData("12345678", "TI", "12351", "New Name Surname", "12546", "address");
		
		assertEquals("TI",osp.getCustomers().get(3).getTypeId());
		assertEquals("12351",osp.getCustomers().get(3).getId());
		assertEquals("New Name Surname",osp.getCustomers().get(3).getFullName());
		assertEquals("12546",osp.getCustomers().get(3).getPhone());
		assertEquals("address",osp.getCustomers().get(3).getAdress());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
