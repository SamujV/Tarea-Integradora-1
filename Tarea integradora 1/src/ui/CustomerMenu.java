package ui;
import java.util.Scanner;

import exceptions.SameIdException;
import exceptions.WrongOptionException;
import model.OrderSystemPrototype;

public class CustomerMenu {
	private OrderSystemPrototype osp;
	public final static int GO_BACK = 6;
	private Scanner sc;
	public CustomerMenu() {
		sc = new Scanner(System.in);
	}

	public void startCustomerMenu( ) {
		int  option;
		try {
			do {
				showMenu();
				option = Integer.parseInt(sc.nextLine());
				manageOptions(option);
			} while (option != GO_BACK);
		}catch (NumberFormatException nfe) {
			System.out.println("\nPlease insert a valid format");
			startCustomerMenu();
		}

	}
	private void manageOptions(int option) {
		try {
			switch (option) {
			case 1:
				registerCustomer();
				break;
			case 2:
				updateCustomerData();
				break;
			case 3:
				listCustomers();
				break;
			case 4:
				findCustomer();
				break;
			case 5:
				importCustomersData();
				break;
			case 6:
				goBack();
				break;
			default: throw new WrongOptionException();
			}
		}catch (WrongOptionException wop ) {
			System.out.println(wop.getMessage());
		}
	}


	//DONE
	private void registerCustomer() { 
		String typeId;
		String id = "";
		String fullName;
		String phone;
		String address;
		char ch='"';
		System.out.println(" \nREGISTER CUSTOMER");
		System.out.println("Plese insert the following data. \n");

		try {
			do {
				System.out.println("Customer's id");
				id = sc.nextLine();
				if(osp.existingCustomerId(id)) {
					throw new SameIdException();
				}
			}while(osp.existingCustomerId(id));			
		}catch (SameIdException sie) {
			System.out.println(sie.getMessage());
			registerCustomer();
		}

		System.out.println("Customer's type id");
		typeId = sc.nextLine();
		System.out.println("Customer's fullname");
		System.out.println(ch+"name"+ch+ " " +ch+"middle name"+ch + " " +ch+"last name"+ch);
		fullName = sc.nextLine();
		System.out.println("Customer's phone");
		phone = sc.nextLine();
		System.out.println("Customer's address");
		address = sc.nextLine();

		osp.registerCustomer(typeId, id, fullName, phone, address);
		System.out.println("Customer added...");
	}

	private void updateCustomerData() {
		String id;
		String typeId;
		String fullName;
		String phone;
		String address;
		char ch='"';
		System.out.println("\nUPDATE CUSTOMER DATA\n");
		if (osp.getCustomers().size()>0) {
			do {
				System.out.println("Insert customer's id");
				id = sc.nextLine();
				if (osp.existingCustomerId(id)) {
					System.out.println("id does not exist, please insert an existing one");
				}				
			} while (!osp.existingCustomerId(id));
			System.out.println("Insert customer's typeId");
			typeId = sc.nextLine();
			System.out.println("Insert customer's fullname");
			System.out.println(ch+"name"+ch+ " " +ch+"middle name"+ch + " " +ch+"last name"+ch );
			fullName = sc.nextLine();
			System.out.println("Insert customer's phone");
			phone = sc.nextLine();
			System.out.println("Insert customer's address");
			address = sc.nextLine();

			osp.registerCustomer(typeId, typeId, fullName, phone, address);
			System.out.println("\n Updated customer data \n");


		}else
			System.out.println("Register at least one customer first");
	}

	private void listCustomers() {
		if (osp.getCustomers().size() == 0) {
			System.out.println("Register at least one Customer");
		}else {
			System.out.println(osp.customersToString());
		}
	}	

	private void findCustomer() {
		String id;	
		System.out.println("FIND CUSTOMER\n");


		if (osp.getCustomers().size()>0) {
			do {
				System.out.println("Insert customer's id");	
				id = sc.nextLine();
				if (!osp.existingCustomerId(id)) {
					System.out.println("There is no such id");	
				}	
			} while (!osp.existingCustomerId(id));
			System.out.println(osp.getCustomerInfo(osp.findCustomer(id)));			
		}else {
			System.out.println("Register at least one customer");
		}		
	}
	private void importCustomersData() {

	}
	public void setOrderSystem(OrderSystemPrototype os) {
		osp = os;
	}

	public OrderSystemPrototype getCustomerOrderSystem() {
		return osp;
	}
	private void showMenu() {

		System.out.println("\nWELCOME TO CUSTOMER MODULE\n");
		System.out.println("Please insert one option");
		System.out.println("1. Register customer.");
		System.out.println("2. Update customer data.");
		System.out.println("3. List customers on screen.");
		System.out.println("4. Find customer.");
		System.out.println("5. Import customers data.");
		System.out.println("6. Go back.");


	}

	private void goBack() {
		System.out.println("you have returned to the main menu\n");
	}
}
