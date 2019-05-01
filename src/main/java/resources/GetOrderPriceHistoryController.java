package resources;

import dao.OrderDao;
import dao.StockDao;
import model.OrderPriceEntry;
import model.Stock;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ViewGetStockPriceHistory
 */
public class GetOrderPriceHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderPriceHistoryController() {
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
		String orderId = request.getParameter("orderId");
		OrderDao orderDao = new OrderDao();
		List<OrderPriceEntry> entries = orderDao.getOrderPriceHistory(orderId);

		request.setAttribute("entries", entries);
		request.setAttribute("heading", "Order price history");

        RequestDispatcher rd = request.getRequestDispatcher("viewGetOrderPriceHistory.jsp");
        rd.forward(request, response);
	}

}
