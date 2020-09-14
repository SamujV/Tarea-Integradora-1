package ui;

import java.util.Scanner;

public class ClientMenu {
	
	public final static int REGRESAR = 6;
	private Scanner sc;
	public ClientMenu() {
		sc = new Scanner(System.in);
	}

	public void startClienteMenu() {
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
			registrarCliente();
			break;
		case 2:
			actualizarDatosCliente();
			break;
		case 3:
			listarClientes();
			break;
		case 4:
			buscarCliente();
			break;
		case 5:
			importarDatosCliente();
			break;
		case 6:
			regresar();
			break;
		default: System.out.println("hacer excepcion");
		break;
		}

	}





	private void registrarCliente() {

	}
	private void actualizarDatosCliente() {

	}
	private void listarClientes() {

	}	
	private void buscarCliente() {

	}
	private void importarDatosCliente() {

	}
	private void showMenu() {

		System.out.println("\nBIENVENIDO AL MODULO DE CLIENTES\n");
		System.out.println("Porfavor ingrese la opcion deseada");
		System.out.println("1. Registrar cliente.");
		System.out.println("2. Actualizar datos de un cliente.");
		System.out.println("3. Listar clientes en pantalla.");
		System.out.println("4. Buscar un cliente.");
		System.out.println("5. Importar datos de clientes.");
		System.out.println("6. Regresar.");


	}

	private void regresar() {
		System.out.println("ha regresado al menu principal\n");
	}
}
