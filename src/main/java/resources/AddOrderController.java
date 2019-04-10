package resources;

import dao.CustomerDao;
import dao.EmployeeDao;
import dao.OrderDao;
import dao.StockDao;
import model.*;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddOrderController
 */
public class AddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderController() {
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
        String employeeId;
        Employee employee = null;
        String customerId = request.getParameter("customerId");

        // submitted by customer
        if (customerId == null) {
            customerId = (String) request.getSession(false).getAttribute("customerID");
        }
        else
        {
            EmployeeDao employeeDao = new EmployeeDao();
            employeeId = (String) request.getSession(false).getAttribute("employeeID");
            employee = employeeDao.getEmployee(employeeId);
        }
        String numShares = request.getParameter("orderNumShares");
        String type = request.getParameter("orderType");
        String buySellType = request.getParameter("orderBuySellType");
        String orderStockPercentage = request.getParameter("orderPercentage");
        String pricePerShare = request.getParameter("orderPricePerShare");
        String stockSymbol = request.getParameter("stockSymbol");

        OrderDao orderDao = new OrderDao();
        CustomerDao customerDao = new CustomerDao();
        StockDao stockDao = new StockDao();

        Customer customer = customerDao.getCustomer(customerId);
        Stock stock = stockDao.getStockBySymbol(stockSymbol);
        String result = "success";

        if (type.equals("Market"))
        {
            MarketOrder order = new MarketOrder();
            order.setDatetime(new Date());
            order.setBuySellType(buySellType);
            order.setNumShares(Integer.parseInt(numShares));
            result = orderDao.submitOrder(order, customer, employee, stock);
        }
        else if(type.equals("MarketOnClose"))
		{
            MarketOnCloseOrder order = new MarketOnCloseOrder();
            order.setDatetime(new Date());
            order.setBuySellType(buySellType);
            order.setNumShares(Integer.parseInt(numShares));
            result = orderDao.submitOrder(order, customer, employee, stock);
        }
		else if(type.equals("TrailingStop"))
		{
            TrailingStopOrder order = new TrailingStopOrder();
            order.setDatetime(new Date());
            order.setPercentage(Double.parseDouble(orderStockPercentage));
            order.setNumShares(Integer.parseInt(numShares));
            result = orderDao.submitOrder(order, customer, employee, stock);

        }
		else if(type.equals("HiddenStop"))
		{
            HiddenStopOrder order = new HiddenStopOrder();
            order.setDatetime(new Date());
            order.setPricePerShare(Double.parseDouble(pricePerShare));
            order.setNumShares(Integer.parseInt(numShares));
            result = orderDao.submitOrder(order, customer, employee, stock);
        }
        RequestDispatcher rd;

        if (result.equals("success")) {
            rd = request.getRequestDispatcher("home.jsp?result=success");
        }
        else
        {
            rd = request.getRequestDispatcher("home.jsp?result=error");
        }
        rd.forward(request, response);


    }

}
