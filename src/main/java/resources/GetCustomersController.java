package resources;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import model.Customer;

/**
 * Servlet implementation class GetCustomersController
 */
public class GetCustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCustomersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * This method receives the "Search Keyword" data from "Search Customer" page
		 * This data is sent to the getCustomers method in the dao.CustomerDao class
		 * The data received from the getCustomers method is sent to the Customer Listing page as request attribute "customers"
		 * This method redirects to the Customer Listing page
		 */
		
		String searchKeyword = request.getParameter("searchKeyword");
		
		CustomerDao dao = new CustomerDao();
		List<Customer> customers = dao.getCustomers(searchKeyword);
		
		request.setAttribute("customers", customers);
		request.setAttribute("heading", "Show customers");
		RequestDispatcher rd = request.getRequestDispatcher("showCustomer.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
