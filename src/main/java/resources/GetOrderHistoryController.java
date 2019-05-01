package resources;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import model.Order;

/**
 * Servlet implementation class GetOrderHistoryController
 */
public class GetOrderHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderHistoryController() {
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
		String customerID = request.getParameter("customerID");
		
		OrderDao orderDao = new OrderDao();
		List<Order> orders = orderDao.getOrderHistory(customerID);

		request.setAttribute("orders", orders);
		request.setAttribute("heading", "Customer orders");

		RequestDispatcher rd = request.getRequestDispatcher("showOrders.jsp");
		rd.forward(request, response);

	}

}
