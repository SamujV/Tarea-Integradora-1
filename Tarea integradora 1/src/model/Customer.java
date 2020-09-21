package model;

public class Customer implements Comparable<Customer>{
	private String typeId;
	private int id;
	private String fullName;
	private String phone;
	private String address;
	private String name;
	private String surnames;





	public Customer(String typeId, int id, String fullNam, String phone, String address) {
		this.typeId = typeId;
		this.id = id;
		this.fullName = fullNam;
		this.phone = phone;
		this.address = address;
		splitFullName();
	}	

	private void splitFullName() {
		String[] names = fullName.split(" ");
		name = names[0];
		surnames = names[1]+ " "+ names[2];
	}

	public String getTypeId() {
		return typeId;
	}
	public int getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAdress() {
		return address;
	}
	public String getName() {
		return name;
	}
	public String getSurnames() {
		return surnames;
	}

	public void setTypeId(String type) {
		typeId = type;
	}

	public void setId(int id2) {
		id = id2;
	}
	public void setFullName(String name) {
		fullName = name;
		splitFullName();
	}
	public void setPhone(String ph) {
		phone = ph;
	}

	public void setAddress(String add) {
		address = add;
	}

	@Override
	public int compareTo(Customer o) {
		int comp = 0;
		comp = name.compareTo(o.getName());
		if(comp == 0) {
			comp = surnames.compareTo(o.getSurnames());
		}		
		return comp;
	}
}
