package ui;

import java.io.IOException;
import java.util.Scanner;

import exceptions.SameNameException;
import exceptions.SameNitException;
import exceptions.WrongOptionException;
import model.OrderSystemPrototype;

public class RestaurantMenu {
	private OrderSystemPrototype osp;
	public static final int GO_BACK = 5;
	public static final String PATH = "data/restaurantsData.csv";
	private Scanner sc;
	public RestaurantMenu() {
		osp = null;
		sc = new Scanner(System.in);
	}

	public void startRestaurantMenu() {
		int  option;
		try {
			do {
				showMenu();
				option = Integer.parseInt(sc.nextLine());
				manageOptions(option);
			} while (option != GO_BACK);
		}catch (NumberFormatException nfe) {
			System.out.println("\nPlease insert a valid format");
			startRestaurantMenu();
		}

	}
	private void manageOptions(int option) {

		try {
			switch (option) {
			case 1:
				registerRestaurant();
				break;
			case 2:
				updateRestaurantData();
				break;
			case 3:
				listRestaurants();
				break;
			case 4:
				importData();
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


	private void registerRestaurant () {
		String nam ;
		String nit ;
		String namA;
		System.out.println(" \nREGISTER RESTAURANT");
		System.out.println("Plese insert the following data. \n");
		try {
			do {
				System.out.println("Restaurant's name");
				nam = sc.nextLine();
				if(osp.existingRestaurantName(nam)) {
					throw new SameNameException();
				}
			}while(osp.existingRestaurantName(nam));

			do {
				System.out.println("Restaurant's nit");

				nit = sc.nextLine();
				if(osp.existingRestaurantNit(nit)) {
					throw new SameNitException();
				}
			} while (osp.existingRestaurantNit(nit));

			System.out.println("Admin's name");
			namA = sc.nextLine();
			osp.registerRestaurant(nam, nit, namA);
		}catch (SameNameException sne) {
			System.out.println(sne.getMessage());
			registerRestaurant();
		}catch (SameNitException sne) {
			System.out.println(sne.getMessage());
			registerRestaurant();
		}
		System.out.println("\nRestaurant added\n");
	}


	private void updateRestaurantData() {
		String nit;
		String name;
		String nit2;
		String nameA;
		System.out.println("\n	UPDATE RESTAURANT DATA	\n");
		if (osp.getRestaurants().size()>0) {

			try {
				do {
					System.out.println("Insert restaurant's nit");
					nit = sc.nextLine();
					if (!osp.existingRestaurantNit(nit)) {
						System.out.println("Nit does not exist, please insert an existing one");
					}				
				} while (!osp.existingRestaurantNit(nit));

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
			System.out.println("please register a restaurant first");

	}

	private void listRestaurants() {
		if (osp.getRestaurants().size() == 0) {
			System.out.println("Register at least one restaurant");
		}else {
			System.out.println(osp.restaurantsToString());
		}
	}	
	private void importData() {
		String fileName;
		System.out.println("	IMPORT RESTAURANTS DATA");
		try {
			System.out.println("Please insert path");
			fileName = sc.nextLine();
			osp.importRestaurantsData(fileName);
			System.out.println("Data imported successfully");
		}catch (IOException io) {
			System.out.println("Unable to import data");
		}
	}

	public void setOrderSystem(OrderSystemPrototype os) {
		osp = os;
	}

	public OrderSystemPrototype getRestaurantOrderSystem() {
		return osp;
	}

	private void showMenu() {

		System.out.println("\nWELCOME TO RESTAURANT MODULE\n");
		System.out.println("Please insert one option");
		System.out.println("1. Register restaurant.");
		System.out.println("2. Update restaurant data.");
		System.out.println("3. List restaurants on screen.");
		System.out.println("4. Import restaurants data.");
		System.out.println("5. Go back.");


	}

	private void goBack() {
		System.out.println("you have returned to the main menu\n");
	}
}
