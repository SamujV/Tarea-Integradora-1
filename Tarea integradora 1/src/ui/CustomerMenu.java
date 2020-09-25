package ui;
import java.util.Scanner;

import exceptions.SameIdException;
import exceptions.SameNameException;
import exceptions.SameNitException;
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



	private void registerCustomer() {
		String typeId;
		String id = "";
		String fullName;
		String phone;
		String address;
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
		fullName = sc.nextLine();
		System.out.println("Customer's phone");
		phone = sc.nextLine();
		System.out.println("Customer's address");
		address = sc.nextLine();
		
		osp.registerCustomer(typeId, id, fullName, phone, address);
	}
	
	
	
	private void updateCustomerData() {
		String typeId;
		String id;
		String fullName;
		String phone;
		String address;

		System.out.println("\nUPDATE CUSTOMER DATA\n");
		if (osp.getCustomers().size()>0) {

			try {
				do {
					System.out.println("Insert customer's id");
					id = sc.nextLine();
					if (osp.existingCustomerId(id)) {
						System.out.println("id does not exist, please insert an existing one");
					}				
				} while (!osp.existingCustomerId(id));

				do {
					System.out.println("Insert restaurant's new name");
					name = sc.nextLine();
					if (osp.existingRestaurantName(name)) {
						throw new SameNameException();
					}
				} while (osp.existingRestaurantName(name));
				do {
					System.out.println("Insert the new restaurant's new nit");
					nit2 = sc.nextLine();
					if (osp.existingRestaurantNit(nit2)) {
						throw new SameNitException();
					}
				} while (osp.existingRestaurantNit(nit2));

				System.out.println("Insert admin's name");
				nameA = sc.nextLine();

				osp.updateResData(nit, name, nit2, nameA);
			}catch (SameNameException sne) {
				System.out.println(sne.getMessage());
				updateRestaurantData();
			}catch (SameNitException sne) {
				System.out.println(sne.getMessage());
				updateRestaurantData();
			}
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
		System.out.println("1. Register customer .");
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
