package application;

public class Business extends Student{

	public Business(String name, String address, String province, String city, String postalCode, String phoneNumber,
			String email) {
		super(name, address, province, city, postalCode, phoneNumber, email);
		// TODO Auto-generated constructor stub
	}
	public Business() {
		
	}

	@Override
	public void setCourses() {
		// TODO Auto-generated method stub
		courses[0] = "Introduction to Business";
		courses[1] = "Marketing";
		courses[2] = "Financial Accounting Principles";
		courses[3] = "International Business Fundamentals";
		courses[4] = "Entrepeneurship";
		
	}

}
