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
//		Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
//			String query = "INSERT Location VALUE (?,?,?)";
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setInt(1,employee.getZipcode());
//			ps.setString(2,employee.getCity());
//			ps.setString(3,employee.getState());
//			ps.execute();
		}
		catch (Exception e){
		e.printStackTrace();
		}



	}
	/*
	 * This class handles all the database operations related to the employee table
	 */

    public Employee getDummyEmployee()
    {
        Employee employee = new Employee();

        Location location = new Location();
        location.setCity("Stony Brook");
        location.setState("NY");
        location.setZipCode(11790);

		/*Sample data begins*/
        employee.setEmail("shiyong@cs.sunysb.edu");
        employee.setFirstName("Shiyong");
        employee.setLastName("Lu");
        employee.setLocation(location);
        employee.setAddress("123 Success Street");
        employee.setStartDate("2006-10-17");
        employee.setTelephone("5166328959");
        employee.setEmployeeID("631-413-5555");
        employee.setHourlyRate(100);
		/*Sample data ends*/

        return employee;
    }

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
			String query = "INSERT Location VALUE (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,employee.getZipcode());
			ps.setString(2,employee.getCity());
			ps.setString(3,employee.getState());
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

			query = "INSERT USER VALUE (?,?,?)";
			ps = con.prepareStatement(query);
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
			String query = "INSERT Location VALUE (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,employee.getZipcode());
			ps.setString(2,employee.getCity());
			ps.setString(3,employee.getState());
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

			query = "INSERT USER VALUE (?,?,?)";
			ps = con.prepareStatement(query);
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
			System.out.println(email);

			int i = state.executeUpdate("DELETE User FROM User,Employee WHERE User.Email=Employee.Email");
			int j = state.executeUpdate("DELETE FROM zhaowhuang.Employee WHERE SSN = "+employeeID);
			int k = state.executeUpdate("DELETE FROM zhaowhuang.Person WHERE SSN = "+employeeID);

			if(i>0&&j>0&&k>0){
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

		Location location = new Location();
		//location.setCity("Stony Brook");
	//	location.setState("NY");
		//location.setZipCode(11790);


		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

		//	Statement state = con.createStatement();
			String query = "SELECT DISTINCT * FROM Person,Location,Employee WHERE Person.SSN=Employee.SSN AND Person.ZipCode=Location.Zipcode";
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(query);

			while (rs.next()){
				Employee employee = new Employee();
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

		/*
		 * The students code to fetch data from the database based on "employeeID" will be written here
		 * employeeID, which is the Employee's ID who's details have to be fetched, is given as method parameter
		 * The record is required to be encapsulated as a "Employee" class object
		 */

		return getDummyEmployee();
	}
	
	public Employee getHighestRevenueEmployee() {
		
		/*
		 * The students code to fetch employee data who generated the highest revenue will be written here
		 * The record is required to be encapsulated as a "Employee" class object
		 */
		
		return getDummyEmployee();
	}

	public String getEmployeeID(String username) {
		/*
		 * The students code to fetch data from the database based on "username" will be written here
		 * username, which is the Employee's email address who's Employee ID has to be fetched, is given as method parameter
		 * The Employee ID is required to be returned as a String
		 */

		return "111-11-1111";
	}

	public String SetStockPrice(Stock stock){
    	//	String sql1 = "INSERT INTO zhaowhuang.Person (SSN,LastName,FirstName,Address,ZipCode,Telephone) "+
		//					"VALUES("+id+",\""+employee.getLastName()+"\",\""+employee.getFirstName()+"\",\""+address+"\","+Integer.valueOf(employee.getZipcode())+","+Long.parseLong(employee.getTelephone())+");";
		//
    	//String sql1="UPDATE  zhaowhuang.Stock"+"SET PricePerShare=="
		//		+"WHERE


		return "success";
	}
}
