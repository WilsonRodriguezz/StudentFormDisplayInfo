package application;

public class ComputerScience extends Student {

	public ComputerScience(String name, String address, String province, String city, String postalCode,
			String phoneNumber, String email) {
		super(name, address, province, city, postalCode, phoneNumber, email);
		// TODO Auto-generated constructor stub
	}
	public ComputerScience() {
		
	}

	@Override
	public void setCourses() {
		courses[0] = "Java programming";
		courses[1] = "Web application Development";
		courses[2] = "Software Systems Design";
		courses[3] = "Programming-3";
		courses[4] = "Lineal Algebra";
	}

}
