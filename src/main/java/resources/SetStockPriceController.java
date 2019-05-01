package resources;

import dao.EmployeeDao;
import dao.LoginDao;
import dao.StockDao;
import model.Employee;
import model.Location;
import model.Login;
import model.Stock;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class AddCustomerController
 */
public class SetStockPriceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetStockPriceController() {
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
		String stockPrice = request.getParameter("stockPrice");

		StockDao stockDao = new StockDao();
		String result = stockDao.setStockPrice(stockSymbol, Double.parseDouble(stockPrice));

		if(result.equals("success")) {
				response.sendRedirect("home.jsp?status=success");
		}
		else {
			response.sendRedirect("home.jsp?status=error");
		}
	}

}
