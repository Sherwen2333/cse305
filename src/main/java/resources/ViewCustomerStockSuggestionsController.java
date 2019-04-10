package resources;

import dao.CustomerDao;
import dao.StockDao;
import model.Customer;
import model.Stock;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class GetStockSuggestionsController
 */
public class ViewCustomerStockSuggestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomerStockSuggestionsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customerID = (String)request.getSession(false).getAttribute("customerID");
		
		CustomerDao customerDao = new CustomerDao();
		List<Customer> customers = customerDao.getAllCustomers();

		request.setAttribute("customers", customers);
		request.setAttribute("heading", "Customer suggestions");
		RequestDispatcher rd = request.getRequestDispatcher("viewCustomerStockSuggestions.jsp");
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
