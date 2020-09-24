package ui;
import model.OrderSystemPrototype;
import java.util.Scanner;

public class MainMenu {

	private OrderSystemPrototype osp;
	private RestaurantMenu resMenu;
	private CustomerMenu custMenu;
	private ProductMenu proMenu;
	private OrderMenu ordMenu;
	public final static int SALIR = 6;
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
		do {
			showMenu();
			option = Integer.parseInt(sc.nextLine());
			manageOptions(option);			
		}while(option != SALIR);	
	}
	
	
	
	private void manageOptions(int option) {
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
			break;
		case 5:
			exportarInfo();
			break;
		case 6:
			goodBye();
			System.out.println(osp.getPrueba());
			break;
			default: System.out.println("Ingrese una opcion valida ");	
			break;
		}	
	}
	
	public void exportarInfo() {
		
	}
	
	public OrderSystemPrototype getOrderSystem() {
		return osp;
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
