package ui;

import java.util.Scanner;

import model.OrderSystemPrototype;

public class RestaurantMenu {
	private OrderSystemPrototype osp;
	public final static int REGRESAR = 5;
	private Scanner sc;
	public RestaurantMenu() {
		osp = null;
		sc = new Scanner(System.in);
	}

	public void startRestaurantMenu() {
		int  option;
		do {
			showMenu();
			option = Integer.parseInt(sc.nextLine());
			manageOptions(option);
		} while (option != REGRESAR);


	}
	private void manageOptions(int option) {

		switch (option) {
		case 1:
			registrarRestaurante();
			testearPrueba();
			break;
		case 2:
			actualizarDatos();
			break;
		case 3:
			listarRestaurantes();
			break;
		case 4:
			importarDatos();
			break;
		case 5:
			regresar();
			break;
		default: System.out.println("hacer excepcion");
		break;
		}

	}

	public void testearPrueba() {
		System.out.println("ingrese una linea");
		String prueba = sc.nextLine();
		osp.setPrueba(prueba);
	
	}



	
	private void registrarRestaurante() {

	}
	private void actualizarDatos() {

	}
	private void listarRestaurantes() {

	}	
	private void importarDatos() {

	}
	
	public void setOrderSystem(OrderSystemPrototype os) {
		osp = os;
	}
	
	public OrderSystemPrototype getRestaurantOrderSystem() {
		return osp;
	}
	
	private void showMenu() {

		System.out.println("\nBIENVENIDO AL MODULO DE RESTAURANTES\n");
		System.out.println("Porfavor ingrese la opcion deseada");
		System.out.println("1. Registrar restaurante.");
		System.out.println("2. Actualizar datos de un restaurante.");
		System.out.println("3. Listar restaurantes en pantalla.");
		System.out.println("4. Importar datos de restaurantes.");
		System.out.println("5. Regresar.");


	}

	private void regresar() {
		System.out.println("ha regresado al menu principal\n");
	}
}
