package model;

public class Employee extends Person {
	
	/*
	 * This class is a representation of the employee table in the database
	 * Each instance variable has a corresponding getter and setter
	 */

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public float getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	private String employeeID;
	private String startDate;
	private float hourlyRate;
	private String level;

	private String city;
	private String state;
	private int zipcode;

	private String password;
	private String role;

	public String getPassword(){return password;}

	public void  setPassword(String password){this.password=password;}

	public String getRole(){return role;}

	public void setRole(String role){this.role=role;}

	public String getCity(){return city;}

	public void setCity(String city){this.city=city;}

	public String getState(){return state;}

	public void setState(String state){this.state=state;}

	public int getZipcode(){return zipcode;}

	public void setZipcode(int zipcode){this.zipcode=zipcode;}


}
