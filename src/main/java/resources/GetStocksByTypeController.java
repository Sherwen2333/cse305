package resources;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StockDao;
import model.Stock;

/**
 * Servlet implementation class SearchItemsByTypeController
 */
public class GetStocksByTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStocksByTypeController() {
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
		String itemType = request.getParameter("itemType");
		
		StockDao stockDao = new StockDao();
		List<Stock> stocks = stockDao.getStockByType(itemType);
		
		request.setAttribute("stocks", stocks);
		request.setAttribute("heading", "Stock by Type");

		RequestDispatcher rd = request.getRequestDispatcher("showStocks.jsp");
		rd.forward(request, response);

	}

}
