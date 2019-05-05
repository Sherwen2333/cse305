package dao;

import model.Login;
import java.sql.*;
public class LoginDao {
	/*
	 * This class handles all the database operations related to login functionality
	 */
    public static void main(String[] args) {
//        try{
//        Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
//        String query = "SELECT * FROM zhaowhuang.User WHERE user.Email=? and user.Password=?";
//        PreparedStatement ps = con.prepareStatement(query);
//        ps.setString(1, "ak123@qq.com");
//        ps.setString(2, "ak123");
//        ps.setString(3, "Customer");
//        ResultSet rs = ps.executeQuery();
//        if(rs.next()) {
//            System.out.println(rs.getString("Role"));}}
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }
	
	public Login login(String username, String password, String role) {

		/*
		 * Return a Login object with role as "manager", "customerRepresentative" or "customer" if successful login
		 * Else, return null
		 * The role depends on the type of the user, which has to be handled in the database
		 * username, which is the email address of the user, is given as method parameter
		 * password, which is the password of the user, is given as method parameter
		 * Query to verify the username and password and fetch the role of the user, must be implemented
		 */
		
		/*Sample data begins*/
		Login login = new Login();
		login.setRole(role);
//		try{
//			if(role.equals("customerRepresentative")){
//				role="Customer Representative";
//			}
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
//			String query = "SELECT * FROM zhaowhuang.User WHERE user.Email=? and user.role=? and user.Password=? ";
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(1, username);
//			ps.setString(2,role);
//
//			ps.setString(3, password);
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//				System.out.println("dasjdlkasjdlaksdjlkasdjas");
//				login.setUsername(username);
//				login.setPassword(password);
//				login.setRole(role);
//
//			}else {
//				login = null;
//
//			}
//		}catch (Exception e){
//			e.printStackTrace();
//		}
		return login;
		/*Sample data ends*/

	}
		/*Sample data ends*/


	
	public String addUser(Login login) {
		/*
		 * Query to insert a new record for user login must be implemented
		 * login, which is the "Login" Class object containing username and password for the new user, is given as method parameter
		 * The username and password from login can get accessed using getter methods in the "Login" model
		 * e.g. getUsername() method will return the username encapsulated in login object
		 * Return "success" on successful insertion of a new user
		 * Return "failure" for an unsuccessful database operation
		 */
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/
	}

}
