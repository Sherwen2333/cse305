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



}
