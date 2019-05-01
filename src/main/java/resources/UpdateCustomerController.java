package resources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dao.LoginDao;
import model.Customer;
import model.Location;
import model.Login;

/**
 * Servlet implementation class UpdateCustomerController
 */
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("customerEmail");
		String firstName = request.getParameter("customerFirstName");
		String lastName = request.getParameter("customerLastName");
		String address = request.getParameter("customerAddress");
		String city = request.getParameter("customerCity");
		String state= request.getParameter("customerState");
		int zipcode = Integer.parseInt(request.getParameter("customerZipcode"));
		String telephone = request.getParameter("customerTelephone");
		String ssn = request.getParameter("customerSSN");
		String creditCard = request.getParameter("customerCreditCard");
		int rating = Integer.parseInt(request.getParameter("customerRating"));

		Location location = new Location();
        location.setCity(city);
        location.setState(state);
        location.setZipCode(zipcode);

        Customer customer = new Customer();
		customer.setEmail(email);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		customer.setTelephone(telephone);
		customer.setId(ssn);
		customer.setSsn(ssn);
		customer.setCreditCard(creditCard);
		customer.setRating(rating);
        customer.setLocation(location);
		
		CustomerDao customerDao = new CustomerDao();
		String result = customerDao.editCustomer(customer);
		
		if(result.equals("success")) {
			response.sendRedirect("customerRepresentativeHome.jsp?status=editCustomerSuccess");
		}
		else {
			response.sendRedirect("editCustomer.jsp?status=error");
		}

	}

}
