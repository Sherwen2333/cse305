package model;

import java.util.Date;

public class Customer extends Person{
	
	/*
	 * This class is a representation of the customer table in the database
	 * Each instance variable has a corresponding getter and setter
	 */
	
	private String clientId;
    private String creditCard;
	private int rating;
    private int accountNumber;
    private String accountCreationTime;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountCreationTime() {
        return accountCreationTime;
    }

    public void setAccountCreationTime(String accountCreationTime) {
        this.accountCreationTime = accountCreationTime;
    }


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
