package ui;

import java.util.Scanner;

import model.OrderSystemPrototype;

public class ProductMenu {
	private OrderSystemPrototype osp;
	public final static int REGRESAR = 4;
	private Scanner sc;
	public ProductMenu() {
		sc = new Scanner(System.in);
	}

	public void startProductMenu() {
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
			registrarProducto();
			testearPrueba();
			break;
		case 2:
			actualizarProducto();
			break;
		case 3:
			importarDatosProductos();
			break;
		case 4:
			regresar();
			break;
		default: System.out.println("hacer excepcion");
		break;
		}

	}

	private void testearPrueba() {
		System.out.println("ingrese una linea");
		String prueba = sc.nextLine();
		osp.setPrueba(prueba);
	
	}



	private void registrarProducto() {

	}
	private void actualizarProducto() {

	}
	private void importarDatosProductos() {

	}
	public void setOrderSystem(OrderSystemPrototype os) {
		osp = os;
	}
	
	public OrderSystemPrototype getProductOrderSystem() {
		return osp;
	}

	private void showMenu() {

		System.out.println("\nBIENVENIDO AL MODULO DE PRODUCTOS\n");
		System.out.println("Porfavor ingrese la opcion deseada");
		System.out.println("1. Registrar producto.");
		System.out.println("2. Actualizar producto.");
		System.out.println("3. Importar datos de productos.");
		System.out.println("4. Regresar.");


	}

	private void regresar() {
		System.out.println("ha regresado al menu principal\n");
	}
}
