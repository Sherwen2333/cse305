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
public class GetOrdersByStockSymbolController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrdersByStockSymbolController() {
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
		String stockSymbol = request.getParameter("stockSymbol");

		OrderDao orderDao = new OrderDao();
		List<Order> orders = orderDao.getOrderByStockSymbol(stockSymbol);

		request.setAttribute("orders", orders);
		request.setAttribute("heading", "Orders for " + stockSymbol);

		RequestDispatcher rd = request.getRequestDispatcher("showOrders.jsp");
		rd.forward(request, response);

	}

}
