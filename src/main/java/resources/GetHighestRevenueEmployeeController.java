package resources;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class GetHighestRevenueEmployeeController
 */
public class GetHighestRevenueEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHighestRevenueEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.getHighestRevenueEmployee();

		List<Employee> employees = new LinkedList<Employee>();
		employees.add(employee);
		request.setAttribute("employees", employees);
		request.setAttribute("heading", "Highest Revenue Employee");
		RequestDispatcher rd = request.getRequestDispatcher("showEmployee.jsp");
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
