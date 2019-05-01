package resources;

import dao.OrderDao;
import model.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class SearchItemsByTypeController
 */
public class GetOrdersByCustomerNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrdersByCustomerNameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doget(HttpServletRequest request, HttpServletResponse response)
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
		String customerName = request.getParameter("customerName");

		OrderDao orderDao = new OrderDao();
		List<Order> orders = orderDao.getOrderByCustomerName(customerName);

		request.setAttribute("orders", orders);
		request.setAttribute("heading", "Orders for customer name " + customerName);

		RequestDispatcher rd = request.getRequestDispatcher("showOrders.jsp");
		rd.forward(request, response);

	}

}
