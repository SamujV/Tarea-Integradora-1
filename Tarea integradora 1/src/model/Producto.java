package model;

public class Producto {

	private int codigo;
	private String nombre;
	private String descripcion;
	private double costo;
	private String nitRes;
	private int cantidad;
	
	public Producto(int codigo, String nombre, String descripcion, double costo, String nitRes) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
		this.nitRes = nitRes;
	}
	
	
	public void setCantidad(int cant) {
		cantidad = cant;		
	}
	
}
