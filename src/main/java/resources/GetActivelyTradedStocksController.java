package resources;

import dao.StockDao;
import model.Stock;

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
public class GetActivelyTradedStocksController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetActivelyTradedStocksController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		StockDao stockDao = new StockDao();
		List<Stock> stocks = stockDao.getActivelyTradedStocks();
		
		request.setAttribute("stocks", stocks);
		request.setAttribute("heading", "Actively Traded stocks");

		RequestDispatcher rd = request.getRequestDispatcher("showStocks.jsp");
		rd.forward(request, response);

	}

}
