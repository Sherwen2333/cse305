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
 * Servlet implementation class AddCustomerController
 */
public class ViewAddCustomerOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAddCustomerOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		StockDao stockDao = new StockDao();
		List<Stock> stocks = stockDao.getAllStocks();

		CustomerDao customerDao = new CustomerDao();
		List<Customer> customers = customerDao.getAllCustomers();

		request.setAttribute("stocks", stocks);
		request.setAttribute("customers", customers);

        RequestDispatcher rd = request.getRequestDispatcher("viewAddCustomerOrder.jsp");
        rd.forward(request, response);
	}

}
