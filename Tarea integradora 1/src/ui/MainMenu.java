package ui;
import model.OrderSystemPrototype;

import java.util.Scanner;

import exceptions.WrongOptionException;

public class MainMenu {

	private OrderSystemPrototype osp;
	private RestaurantMenu resMenu;
	private CustomerMenu custMenu;
	private ProductMenu proMenu;
	private OrderMenu ordMenu;
	public final static int EXIT = 6;
	private Scanner sc;

	public MainMenu() {
		osp = new OrderSystemPrototype();
		resMenu = new RestaurantMenu();
		custMenu = new CustomerMenu();
		proMenu = new ProductMenu();
		ordMenu = new OrderMenu();
		sc = new Scanner(System.in);
	}

	public void startMainMenu() {
		int option;
		try {
			do {
				showMenu();
				option = Integer.parseInt(sc.nextLine());
				manageOptions(option);			
			}while(option != EXIT);	
		}catch (NumberFormatException nfe ) {
			System.out.println("\nPlease insert a valid format");
			 startMainMenu();
		}
	}


	private void manageOptions(int option) {
		try {
			switch(option) {
			case 1:
				resMenu.setOrderSystem(osp);
				resMenu.startRestaurantMenu();
				osp = resMenu.getRestaurantOrderSystem();
				break;
			case 2:
				custMenu.setOrderSystem(osp);
				custMenu.startCustomerMenu();
				osp = custMenu.getCustomerOrderSystem();

				break;
			case 3:
				proMenu.setOrderSystem(osp);
				proMenu.startProductMenu();
				osp = proMenu.getProductOrderSystem();

				break;
			case 4:
				ordMenu.setOrderSystem(osp);
				ordMenu.startOrderMenu();
				osp = ordMenu.getOrderOrderSystem();
				break;
			case 5:
				exportarInfo();
				break;
			case 6:
				goodBye();
				System.out.println(osp.getPrueba());
				break;
			default: throw new WrongOptionException();
			}	
		}catch (WrongOptionException wop) {
			System.out.println(wop.getMessage());
		}
	}

	public void exportarInfo() {

	}

	public OrderSystemPrototype getOrderSystem() {
		return osp;
	}
	private void showMenu() {

		System.out.println("WELCOME TO THE RESTAURANT ASSOCIATION\n");
		System.out.println("Please insert an option");
		System.out.println("1. Go to the Restaurant module.");
		System.out.println("2. Go to the Customer module.");
		System.out.println("3. Go to the Product module.");
		System.out.println("4. Go to the Order module.");
		System.out.println("5. Export information.");
		System.out.println("6. Exit.");


	}


	public void goodBye() {
		System.out.println("\n		THANKS FOR USING THE PROGRAM		");
		System.out.println("           		COME BACK SOON            ");
	}


}
