package ui;

import java.util.Scanner;

public class OrderMenu {

	public final static int REGRESAR = 5;
	private Scanner sc;
	public OrderMenu() {
		sc = new Scanner(System.in);
	}

	public void startProductoMenu() {
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
			registrarPedido();
			break;
		case 2:
			actualizarPedido();
			break;
		case 3:
			cambiarEstadoPedido();
			break;
		case 4:
			importarDatosPedidos();
			break;
		case 5:
			regresar();
			break;
		default: System.out.println("hacer excepcion");
		break;
		}

	}





	private void registrarPedido() {

	}
	private void actualizarPedido() {

	}
	private void cambiarEstadoPedido() {

	}
	private void importarDatosPedidos() {

	}	
	private void showMenu() {

		System.out.println("\nBIENVENIDO AL MODULO DE PEDIDOS\n");
		System.out.println("Porfavor ingrese la opcion deseada");
		System.out.println("1. Registrar pedido.");
		System.out.println("2. Actualizar pedido.");
		System.out.println("3. Cambiar estado de un pedido.");
		System.out.println("4. Importar datos de pedidos.");
		System.out.println("5. Regresar.");


	}

	private void regresar() {
		System.out.println("ha regresado al menu principal\n");
	}
}
