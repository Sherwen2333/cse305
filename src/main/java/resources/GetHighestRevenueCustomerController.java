package resources;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dao.EmployeeDao;
import model.Customer;
import model.Employee;

/**
 * Servlet implementation class GetHighestRevenueCustomerController
 */
public class GetHighestRevenueCustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHighestRevenueCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        CustomerDao customerDao = new CustomerDao();
        Customer customer = customerDao.getHighestRevenueCustomer();

        List<Customer> customers = new LinkedList<Customer>();
        customers.add(customer);
        request.setAttribute("customers", customers);
        request.setAttribute("heading", "Highest Revenue Customer");
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
