package hello;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String address;
	private String telephone;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setAddress(String addr) {
		this.address = addr;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setTelephone(String phone) {
		this.telephone = phone;
	}
	
	public String getTelephone() {
		return this.telephone;
	}

}
