package model;

public class Restaurant {
	
	private String name;
	private String nit;
	private String namAdmin;
	
	
	public Restaurant(String name, String nit, String namA) {
		this.name = name;
		this.nit = nit;
		this.namAdmin = namA;
	}
	
	public String getName() {
		return name;
	}

	public String getNit() {
		return nit;
	}

	public String getNamAdmin() {
		return namAdmin;
	}

	public void setName(String nam) {
		name = nam;
	}
	public void setNit(String niT) {
		nit = niT;
	}
	public void setNamAdmin(String nAdmin){
		namAdmin = nAdmin;
	}
	

}
