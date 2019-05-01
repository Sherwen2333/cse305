package model;

import java.util.Date;

public class Order {
	
	/*
	 * This class is a representation of the bid table in the database
	 * Each instance variable has a corresponding getter and setter
	 */

	private int id;
    private Date datetime;
    private int numShares;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public int getNumShares() {
        return numShares;
    }

    public void setNumShares(int numShares) {
        this.numShares = numShares;
    }
}
