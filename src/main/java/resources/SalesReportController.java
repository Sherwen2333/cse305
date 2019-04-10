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
 * Servlet implementation class AddCustomerController
 */
public class SalesReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		SalesDao dao = new SalesDao();
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        List<RevenueItem> items = dao.getSalesReport(month, year);

        request.setAttribute("heading", "Sales Report for " + month + "/" + year);
        request.setAttribute("items", items);
		RequestDispatcher rd = request.getRequestDispatcher("showSalesReport.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
