package resources;

import dao.SalesDao;
import dao.StockDao;
import model.RevenueItem;
import model.Stock;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class GetItemsController
 */
public class GetSummaryListingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSummaryListingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyword = request.getParameter("searchKeyword");
		SalesDao salesDao = new SalesDao();
		List<RevenueItem> items = salesDao.getSummaryListing(keyword);
		
		request.setAttribute("items", items);
		request.setAttribute("heading", "Summary Listing of revenue generated - " + keyword);
		RequestDispatcher rd = request.getRequestDispatcher("showSalesReport.jsp");
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
