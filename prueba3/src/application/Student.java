package application;

public abstract class Student {
	
	protected String[] courses = new String[5];
	protected String name;
	protected String address;
	protected String province;
	protected String city;
	protected String postalCode;
	protected String phoneNumber;
	protected String email;
	
	//EMPTY CONSTRUCTOR
	public Student() {
		
	}
	
	//constructor
	public Student(String name, String address, String province, String city,  String postalCode, String phoneNumber, String email) {
		this.name = name;
		this.address = address;
		this.province = province;
		this.city = city;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	
	//getters
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getProvince() {
		return province;
	}
	public String getCity() {
		return city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public String[] getCourses() {
		return courses;
	}
	
	//Abstract setter for courses
	
	public abstract void setCourses();  

	public String toString() {
		return String.format(getName() +", "+ getAddress() +", "+ getProvince() +", "+ getCity() +", "+ getPostalCode() + ", "+getPhoneNumber() +", "+ getEmail() +
				".%nCourses: ") ;
	}
}
