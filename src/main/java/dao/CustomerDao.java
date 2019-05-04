package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Location;

public class CustomerDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */

    public Customer getDummyCustomer() {
        Location location = new Location();
        location.setZipCode(11790);
        location.setCity("Stony Brook");
        location.setState("NY");

        Customer customer = new Customer();
        customer.setId("111-11-1111");
        customer.setAddress("123 Success Street");
        customer.setLastName("Lu");
        customer.setFirstName("Shiyong");
        customer.setEmail("shiyong@cs.sunysb.edu");
        customer.setLocation(location);
        customer.setTelephone("5166328959");
        customer.setCreditCard("1234567812345678");
        customer.setRating(1);

        return customer;
    }
    public List<Customer> getDummyCustomerList() {
        /*Sample data begins*/
        List<Customer> customers = new ArrayList<Customer>();

        for (int i = 0; i < 10; i++) {
            customers.add(getDummyCustomer());
        }
		/*Sample data ends*/

        return customers;
    }

    /**
	 * @param  searchKeyword
	 * @return ArrayList<Customer> object
	 */
	public List<Customer> getCustomers(String searchKeyword) {
		/*
		 * This method fetches one or more customers based on the searchKeyword and returns it as an ArrayList
		 */
		

		/*
		 * The students code to fetch data from the database based on searchKeyword will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */
		
		return getDummyCustomerList();
	}


	public Customer getHighestRevenueCustomer() {
		/*
		 * This method fetches the customer who generated the highest total revenue and returns it
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */

		return getDummyCustomer();
	}

	public Customer getCustomer(String customerID) {
        Location location = new Location();
        Customer temp = new Customer();
        /*
         * The students code to fetch data from the database based on "employeeID" will be written here
         * employeeID, which is the Employee's ID who's details have to be fetched, is given as method parameter
         * The record is required to be encapsulated as a "Employee" class object
         */
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");


            String query = "SELECT DISTINCT * FROM Person,Location,Clients WHERE Person.SSN=Clients.Id  AND Location.SSN=Person.SSN AND Person.SSN="+customerID;

            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()) {


                temp.setEmail("" + rs.getString("Email"));
                temp.setFirstName("" + rs.getString("FirstName"));
                temp.setLastName("" + rs.getString("LastName"));

                temp.setAddress(rs.getString("Address"));

                temp.setCity("" + rs.getString("City"));
                temp.setState("" + rs.getString("State"));
                temp.setZipcode(rs.getInt("Zipcode"));
                location.setCity("" + rs.getString("City"));
                location.setState("" + rs.getString("State"));
                location.setZipCode(rs.getInt("Zipcode"));
                temp.setLocation(location);
                int a = rs.getInt("Zipcode");
                temp.setZipcode(rs.getInt("Zipcode"));
                temp.setTelephone(rs.getString("Telephone"));
                temp.setSsn("" + rs.getString("SSN"));
                temp.setClientId("" + rs.getString("SSN"));
                temp.setId("" + rs.getString("SSN"));
                temp.setCreditCard("" + rs.getString("CreditCardNumber"));
                temp.setRating(rs.getInt("Rating"));

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;


		/*
		 * This method fetches the customer details and returns it
		 * customerID, which is the Customer's ID who's details have to be fetched, is given as method parameter
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */


	}
	
	public String deleteCustomer(String customerID) {

		/*
		 * This method deletes a customer returns "success" string on success, else returns "failure"
		 * The students code to delete the data from the database will be written here
		 * customerID, which is the Customer's ID who's details have to be deleted, is given as method parameter
		 */
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            Statement state = con.createStatement();


            int i = state.executeUpdate("DELETE User FROM User,Clients WHERE User.SSN =  "+customerID);
            int j = state.executeUpdate("DELETE FROM zhaowhuang.Clients WHERE Id = "+customerID);
            int k = state.executeUpdate("DELETE FROM zhaowhuang.Person WHERE SSN = "+customerID);
            int l=state.executeUpdate("DELETE FROM zhaowhuang.Location WHERE SSN = "+customerID);

            if(i>0&&j>0&&k>0&&l>0){
                return "success";
            }
            else{
                return "failure";

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "failure";
		/*Sample data begins*/

		/*Sample data ends*/
		
	}


	public String getCustomerID(String email) {
		String customerID="";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
			String query = "SELECT Id from Clients where Email=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			customerID = rs.getString(1);
			}else {
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		/*
		 * This method returns the Customer's ID based on the provided email address
		 * The students code to fetch data from the database will be written here
		 * username, which is the email address of the customer, who's ID has to be returned, is given as method parameter
		 * The Customer's ID is required to be returned as a String
		 */

		return customerID;
	}


	public String addCustomer(Customer customer) {

		/*
		 * All the values of the add customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the customer details and return "success" or "failure" based on result of the database insertion.
		 */
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
			String query = "INSERT Location VALUE (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,customer.getZipcode());
			ps.setString(2,customer.getCity());
			ps.setString(3,customer.getState());
			ps.setInt(4,Integer.parseInt(customer.getSsn()));
			ps.execute();
			query = "INSERT Person VALUE (?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1,Integer.parseInt(customer.getSsn()));
			ps.setString(2,customer.getLastName());
			ps.setString(3,customer.getFirstName());
			ps.setString(4,customer.getAddress());
			ps.setInt(5,customer.getZipcode());
			ps.setString(6,customer.getTelephone());
			ps.execute();
			query = "INSERT Clients VALUE (?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1,customer.getEmail());
			ps.setString(2,customer.getCreditCard());
			ps.setInt(3,Integer.parseInt(customer.getSsn()));
            ps.setInt(4,customer.getRating());
			ps.execute();

			query = "INSERT USER VALUE (?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1,customer.getEmail());
			ps.setString(2,customer.getRole());
			ps.setString(3,customer.getPassword());
            ps.setInt(4,Integer.parseInt(customer.getSsn()));
            ps.execute();

			return "success";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";




	}

	public String editCustomer(Customer customer) {
		/*
		 * All the values of the edit customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "UPDATE Location SET  ZipCode=? , City=? ,State=? WHERE SSN="+Integer.parseInt(customer.getSsn());
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,customer.getZipcode());
            ps.setString(2,customer.getCity());
            ps.setString(3,customer.getState());

            ps.execute();

            query = "UPDATE Person SET LastName=? , FirstName=?, Address=?,Zipcode=? ,Telephone=? WHERE SSN="+Integer.parseInt(customer.getSsn());

            ps = con.prepareStatement(query);

            ps.setString(1,customer.getLastName());
            ps.setString(2,customer.getFirstName());
            ps.setString(3,customer.getAddress());
            ps.setInt(4,customer.getZipcode());
            ps.setString(5,customer.getTelephone());
            ps.execute();

            query = "UPDATE Clients SET Email=?,CreditCardNumber=?,Rating=? WHERE Id="+Integer.parseInt(customer.getSsn());;
            ps = con.prepareStatement(query);
            ps.setString(1,customer.getEmail());
           ps.setString(2,customer.getCreditCard());
            ps.setInt(3,Math.round(customer.getRating()));

            ps.execute();

            query = "UPDATE User SET Email=?  WHERE SSN="+Integer.parseInt(customer.getSsn());;
            ps = con.prepareStatement(query);
            ps.setString(1,customer.getEmail());

            ps.execute();

            return "success";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "failure";


    }

    public List<Customer> getCustomerMailingList() {

        List<Customer> CustomerList = new ArrayList<Customer>();


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

            //	Statement state = con.createStatement();
            String query = "SELECT DISTINCT * FROM Person,Location,Clients WHERE Person.SSN=Clients.Id AND Person.SSN=Location.SSN";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()){
                Customer customer = new Customer();
                Location location = new Location();
                customer.setClientId(""+rs.getInt("SSN"));
                customer.setEmail(""+rs.getString("Email"));
                customer.setLastName(""+rs.getString("LastName"));
                customer.setFirstName(""+rs.getString("FirstName"));
                customer.setAddress(""+rs.getString("Address"));
                location.setCity(""+rs.getString("City"));
                location.setState(""+rs.getString("State"));
                location.setZipCode(rs.getInt("Zipcode"));
                customer.setLocation(location);
                int a=rs.getInt("Zipcode");
                customer.setZipcode(rs.getInt("Zipcode"));
                customer.setId(""+rs.getInt("SSN"));
                customer.setTelephone(""+rs.getString("Telephone"));
                customer.setCreditCard(""+rs.getString("CreditCardNumber"));
                customer.setRating(rs.getInt("Rating"));
                CustomerList.add(customer);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CustomerList;

    }

    public List<Customer> getAllCustomers() {
        List<Customer> CustomerList = new ArrayList<Customer>();


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

            //	Statement state = con.createStatement();
            String query = "SELECT DISTINCT * FROM Person,Location,Clients WHERE Person.SSN=Clients.Id AND Person.SSN=Location.SSN";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()){
               Customer customer = new Customer();
                Location location = new Location();
                customer.setClientId(""+rs.getInt("SSN"));
                customer.setEmail(""+rs.getString("Email"));
                customer.setLastName(""+rs.getString("LastName"));
                customer.setFirstName(""+rs.getString("FirstName"));
                customer.setAddress(""+rs.getString("Address"));
                location.setCity(""+rs.getString("City"));
                location.setState(""+rs.getString("State"));
                location.setZipCode(rs.getInt("Zipcode"));
                customer.setLocation(location);
                int a=rs.getInt("Zipcode");
                customer.setZipcode(rs.getInt("Zipcode"));
                customer.setId(""+rs.getInt("SSN"));
                customer.setTelephone(""+rs.getString("Telephone"));
                customer.setCreditCard(""+rs.getString("CreditCardNumber"));
                customer.setRating(rs.getInt("Rating"));
                CustomerList.add(customer);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CustomerList;
    }

}
