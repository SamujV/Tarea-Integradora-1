package ui;

import java.util.Scanner;

public class MainMenu {

	private RestaurantMenu resMenu;
	private ClientMenu cliMenu;
	private ProductMenu proMenu;
	private OrderMenu pedMenu;
	public final static int SALIR = 6;
	private Scanner sc;
	
	public MainMenu() {
		resMenu = new RestaurantMenu();
		cliMenu = new ClientMenu();
		proMenu = new ProductMenu();
		pedMenu = new OrderMenu();
		sc = new Scanner(System.in);
	}
	
	public void startMainMenu() {
		int option;
		do {
			showMenu();
			option = Integer.parseInt(sc.nextLine());
			manageOptions(option);			
		}while(option != SALIR);	
	}
	
	
	
	private void manageOptions(int option) {
		switch(option) {
		
		case 1:
			resMenu.startRestauranteMenu();
			break;
		case 2:
			cliMenu.startClienteMenu();
			break;
		case 3:
			proMenu.startProductoMenu();
			break;
		case 4:
			pedMenu.startProductoMenu();
			break;
		case 5:
			exportarInfo();
			break;
		case 6:
			goodBye();
			break;
			default: System.out.println("hacer excepcion ");	
			break;
		}	
	}
	
	public void exportarInfo() {
		
	}
	private void showMenu() {
		
		System.out.println("BIENVENIDO A LA ASOCIACION DE RESTAURANTES\n");
		System.out.println("Porfavor ingrese la opcion deseada");
		System.out.println("1. Ir al modulo Restaurante.");
		System.out.println("2. Ir al modulo Cliente.");
		System.out.println("3. Ir al modulo Producto.");
		System.out.println("4. Ir al modulo Pedido.");
		System.out.println("5. Exportar informacion.");
		System.out.println("6. Salir.");
		
		
	}
	
	
	public void goodBye() {
		System.out.println("\nMUCHAS GRACIAS POR USAR EL PROGRAMA");
		System.out.println("           VUELVA PRONTO            ");
	}
	
	
}
