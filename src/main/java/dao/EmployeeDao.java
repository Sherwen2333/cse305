package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;
import model.Location;
import model.Stock;


public class EmployeeDao {
	public static void main(String[] args) {
		Employee employee=new Employee();

		try{
//
		}
		catch (Exception e){
		e.printStackTrace();
		}



	}
	/*
	 * This class handles all the database operations related to the employee table
	 */



    public List<Employee> getDummyEmployees()
    {
       List<Employee> employees = new ArrayList<Employee>();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

			Statement state = con.createStatement();
			String sql = "SELECT * FROM zhaowhuang.Employee e, zhaowhuang.Person p "
					+ "WHERE p.SSN=e.EmployeeID";
			ResultSet rs = state.executeQuery(sql);

			while (rs.next()){
				Employee employee = new Employee();
				employee.setEmployeeID(""+rs.getInt("SSN"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//        for(int i = 0; i < 10; i++)
//        {
//            employees.add(getDummyEmployee());
//        }

        return employees;
    }

	public String addEmployee(Employee employee) {


		/*
		 * All the values of the add employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the employee details and return "success" or "failure" based on result of the database insertion.
		 */
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
			String query = "INSERT Location VALUE (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,employee.getZipcode());
			ps.setString(2,employee.getCity());
			ps.setString(3,employee.getState());
			ps.setInt(4,Integer.parseInt(employee.getSsn()));
			ps.execute();
			query = "INSERT Person VALUE (?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1,Integer.parseInt(employee.getSsn()));
			ps.setString(2,employee.getLastName());
			ps.setString(3,employee.getFirstName());
			ps.setString(4,employee.getAddress());
			ps.setInt(5,employee.getZipcode());
			ps.setString(6,employee.getTelephone());
			ps.execute();
			query = "INSERT Employee VALUE (?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1,Integer.parseInt(employee.getSsn()));
			ps.setDate(2,Date.valueOf(employee.getStartDate()));
			ps.setInt(3,Math.round(employee.getHourlyRate()));
			ps.setString(4,employee.getEmail());
			ps.execute();

			query = "INSERT USER VALUE (?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(4,Integer.parseInt(employee.getSsn()));
			ps.setString(1,employee.getEmail());
			ps.setString(2,employee.getRole());
			ps.setString(3,employee.getPassword());
			ps.execute();

			return "success";
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return "failure";



	}

	public String editEmployee(Employee employee) {
		/*
		 * All the values of the edit employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
			String query = "UPDATE Location SET  ZipCode=? , City=? ,State=? WHERE SSN="+Integer.parseInt(employee.getSsn());
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(2,employee.getCity());
			ps.setString(3,employee.getState());
			ps.setInt(1,employee.getZipcode());
			ps.execute();

			query = "UPDATE Person SET LastName=? , FirstName=?, Address=?,Zipcode=? ,Telephone=? WHERE SSN="+Integer.parseInt(employee.getSsn());

			ps = con.prepareStatement(query);

			ps.setString(1,employee.getLastName());
			ps.setString(2,employee.getFirstName());
			ps.setString(3,employee.getAddress());
			ps.setInt(4,employee.getZipcode());
			ps.setString(5,employee.getTelephone());
			ps.execute();

			query = "UPDATE Employee SET StartDate=? , HourlyRate=? , Email=? WHERE SSN="+Integer.parseInt(employee.getSsn());;
			ps = con.prepareStatement(query);
			ps.setDate(1,Date.valueOf(employee.getStartDate()));
			ps.setInt(2,Math.round(employee.getHourlyRate()));
			ps.setString(3,employee.getEmail());
			ps.execute();

			query = "UPDATE User SET Email=?  WHERE SSN="+Integer.parseInt(employee.getSsn());;
			ps = con.prepareStatement(query);
			ps.setString(1,employee.getEmail());

			ps.execute();

			return "success";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";


		/*Sample data begins*/
		//return "success";
		/*Sample data ends*/

	}

	public String deleteEmployee(String employeeID,String email) {
		/*
		 * employeeID, which is the Employee's ID which has to be deleted, is given as method parameter
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
			Statement state = con.createStatement();


			int i = state.executeUpdate("DELETE User FROM User,Employee WHERE User.SSN =  "+employeeID);
			int j = state.executeUpdate("DELETE FROM zhaowhuang.Employee WHERE SSN = "+employeeID);
			int k = state.executeUpdate("DELETE FROM zhaowhuang.Person WHERE SSN = "+employeeID);
			int l=state.executeUpdate("DELETE FROM zhaowhuang.Location WHERE SSN = "+employeeID);

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

	
	public List<Employee> getEmployees() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Query to return details about all the employees must be implemented
		 * Each record is required to be encapsulated as a "Employee" class object and added to the "employees" List
		 */

		List<Employee> employees = new ArrayList<Employee>();


		//location.setCity("Stony Brook");
	//	location.setState("NY");
		//location.setZipCode(11790);


		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

		//	Statement state = con.createStatement();
			String query = "SELECT DISTINCT * FROM Person,Location,Employee WHERE Person.SSN=Employee.SSN AND Person.SSN=Location.SSN";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(query);



			while (rs.next()){
				Employee employee = new Employee();
				Location location = new Location();
				employee.setId(""+rs.getInt("SSN"));
				employee.setEmail(""+rs.getString("Email"));
				employee.setLastName(""+rs.getString("LastName"));
				employee.setFirstName(""+rs.getString("FirstName"));
				employee.setAddress(""+rs.getString("Address"));
				location.setCity(""+rs.getString("City"));
				location.setState(""+rs.getString("State"));
				location.setZipCode(rs.getInt("Zipcode"));
				employee.setLocation(location);
				int a=rs.getInt("Zipcode");
				employee.setZipcode(rs.getInt("Zipcode"));

				employee.setTelephone(""+rs.getString("Telephone"));
				employee.setEmployeeID(""+rs.getInt("SSN"));
				employee.setHourlyRate(rs.getInt("HourlyRate"));
				employee.setStartDate(rs.getDate("StartDate").toString());
				employees.add(employee);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*Sample data begins*/
//		for (int i = 0; i < 10; i++) {
//			Employee employee = new Employee();
//			employee.setId("111-11-1111");
//			employee.setEmail("shiyong@cs.sunysb.edu");
//			employee.setFirstName("FUCKU");
//			employee.setLastName("Lu");
//			employee.setAddress("123 Success Street");
//			employee.setLocation(location);
//			employee.setTelephone("5166328959");
//			employee.setEmployeeID("631-413-5555");
//			employee.setHourlyRate(100);
//			employees.add(employee);
//		}
		/*Sample data ends*/
		
		return employees;
	}

	public Employee getEmployee(String employeeID) {
		Location location = new Location();
		Employee temp = new Employee();
		/*
		 * The students code to fetch data from the database based on "employeeID" will be written here
		 * employeeID, which is the Employee's ID who's details have to be fetched, is given as method parameter
		 * The record is required to be encapsulated as a "Employee" class object
		 */
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

			String query = "SELECT DISTINCT * FROM Person,Location,Employee WHERE Person.SSN=Employee.SSN  AND Location.SSN=Person.SSN AND Person.SSN="+employeeID;
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
				temp.setEmployeeID("" + rs.getString("SSN"));
				temp.setId("" + rs.getString("SSN"));
				temp.setStartDate("" + rs.getString("StartDate"));
				temp.setHourlyRate(rs.getInt("HourlyRate"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public Employee getHighestRevenueEmployee() {
		Employee temp=new Employee();
		/*
		 * The students code to fetch employee data who generated the highest revenue will be written here
		 * The record is required to be encapsulated as a "Employee" class object
		 */
		
		return temp;
	}

	public String getEmployeeID(String username) {
    	String SSN=new String();

		/*
		 * The students code to fetch data from the database based on "username" will be written here
		 * username, which is the Employee's email address who's Employee ID has to be fetched, is given as method parameter
		 * The Employee ID is required to be returned as a String
		 */
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

			String query = "SELECT DISTINCT Employee.SSN FROM Employee WHERE Employee.Email="+username;
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(query);
			while (rs.next()) {

				 SSN= rs.getString("Email");

			System.out.println(SSN+"320");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return "SSN";
	}

	public String SetStockPrice(Stock stock){


		return "success";
	}
}
