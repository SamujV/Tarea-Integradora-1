package ui;

import java.util.Scanner;

import exceptions.WrongOptionException;
import model.OrderSystemPrototype;

public class OrderMenu {
	private OrderSystemPrototype osp;
	public final static int GO_BACK = 5;
	private Scanner sc;
	public OrderMenu() {
		sc = new Scanner(System.in);
	}

	public void startOrderMenu() {
		int  option;
		try {
			do {
				showMenu();
				option = Integer.parseInt(sc.nextLine());
				manageOptions(option);
			} while (option != GO_BACK);
		}catch (NumberFormatException nfe) {
			System.out.println("\nPlease insert a valid format");
			startOrderMenu();
		}

	}
	private void manageOptions(int option) {
		try {
			switch (option) {
			case 1:
				registerOrder();
				break;
			case 2:
				updateOrder();
				break;
			case 3:
				changeStatusOrder();
				break;
			case 4:
				importOrdersData();
				break;
			case 5:
				goBack();	
				break;
			default: throw new WrongOptionException();
			}
		}catch (WrongOptionException wop) {
			System.out.println(wop.getMessage());
		}
	}




	private void registerOrder() {
		String idCustomer;
		String nitRest;
		
		System.out.println("REGISTER ORDER");
		System.out.println("insert the following data");
		
		do {
			System.out.println("Insert customer's id");
			idCustomer = sc.nextLine();
			if (!osp.existingCustomerId(idCustomer)) {
				System.out.println("There is no such id, try again");
			}
		} while (!osp.existingCustomerId(idCustomer));
		
		do {
			System.out.println("Insert restaurant's nit");
			nitRest = sc.nextLine();
			if (!osp.existingRestaurantNit(nitRest)) {
				System.out.println("There is no such a nit, please try again");
			}
			
		} while (osp.existingRestaurantNit(nitRest));
		
		osp.registerOrder(idCustomer, nitRest);
		
		System.out.println("\nOrder added...\n");

	}
	private void updateOrder() {

	}
	private void changeStatusOrder() {
		

	}
	private void importOrdersData() {

	}	
	public void setOrderSystem(OrderSystemPrototype os) {
		osp = os;
	}

	public OrderSystemPrototype getOrderOrderSystem() {
		return osp;
	}
	private void showMenu() {

		System.out.println("\n	WELCOME TO ORDER MODULE\n");
		System.out.println("Please insert one option");
		System.out.println("1. Register order.");
		System.out.println("2. Update order.");
		System.out.println("3. Change status order.");
		System.out.println("4. Import orders data.");
		System.out.println("5. Go back.");


	}

	private void goBack() {
		System.out.println("you have returned to the main menu\n");
	}
}
