package ui;

public class MainMenu {

	private RestauranteMenu resMenu;
	private ClienteMenu cliMenu;
	private ProductoMenu proMenu;
	private PedidoMenu pedMenu;
	
	public MainMenu() {
		resMenu = new RestauranteMenu();
		cliMenu = new ClienteMenu();
		proMenu = new ProductoMenu();
		pedMenu = new PedidoMenu();
	}
	
	public void startMainMenu() {
		
	}
	
}
