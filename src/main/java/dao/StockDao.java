package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Stock;
import model.Customer;
import model.Employee;
import model.Location;


public class StockDao {

    public Stock getDummyStock() {
        Stock stock = new Stock();
        stock.setName("Apple");
        stock.setSymbol("AAPL");
        stock.setPrice(150.0);
        stock.setNumShares(1200);
        stock.setType("Technology");

        return stock;
    }

    public List<Stock> getDummyStocks() {
        List<Stock> stocks = new ArrayList<Stock>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

            //	Statement state = con.createStatement();
            String query = "SELECT DISTINCT * FROM STOCK";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()){
        Stock stock=new Stock();
      stock.setSymbol(""+rs.getString("StockSymbol"));
        stock.setName(""+rs.getString("CompanyName"));
        stock.setType(""+rs.getString("StockType"));
        stock.setNumShares(rs.getInt("NumShares"));
        stock.setPrice(rs.getInt("PricePerShare"));
        stocks.add(stock);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stocks;
    }

    public List<Stock> getActivelyTradedStocks() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch details of all the stocks has to be implemented
		 * Return list of actively traded stocks
		 */

        return getDummyStocks();

    }

	public List<Stock> getAllStocks() {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Return list of stocks
		 */
		
		return getDummyStocks();

	}

    public Stock getStockBySymbol(String stockSymbol)
    {
        /*
		 * The students code to fetch data from the database will be written here
		 * Return stock matching symbol
		 */
        return getDummyStock();
    }

    public String setStockPrice(String stockSymbol, double stockPrice) {
        try {

            //UPDATE Stock SET PricePerShare=20 WHERE StockSymbol='F'

            //  int i = state.executeUpdate("UPDATE zhaowhuang.Stock SET PricePerShare = "+stockPrice+"WHERE StockSymbol ="+stockSymbol);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "UPDATE Stock SET PricePerShare=? WHERE StockSymbol=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, stockPrice);
            ps.setString(2, stockSymbol);

            ps.execute();

            return "success";
        }


        catch (Exception e){
            e.printStackTrace();
        }
        return "failure";
    }
	
	public List<Stock> getOverallBestsellers() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Get list of bestseller stocks
		 */

		return getDummyStocks();

	}

    public List<Stock> getCustomerBestsellers(String customerID) {

		/*
		 * The students code to fetch data from the database will be written here.
		 * Get list of customer bestseller stocks
		 */

        return getDummyStocks();

    }

	public List getStocksByCustomer(String customerId) {

		/*
		 * The students code to fetch data from the database will be written here
		 * Get stockHoldings of customer with customerId
		 */

		return getDummyStocks();
	}

    public List<Stock> getStocksByName(String name) {

		/*
		 * The students code to fetch data from the database will be written here
		 * Return list of stocks matching "name"
		 */

        return getDummyStocks();
    }

    public List<Stock> getStockSuggestions(String customerID) {

		/*
		 * The students code to fetch data from the database will be written here
		 * Return stock suggestions for given "customerId"
		 */

        return getDummyStocks();

    }

    public List<Stock> getStockPriceHistory(String stockSymbol) {

		/*
		 * The students code to fetch data from the database
		 * Return list of stock objects, showing price history
		 */

        return getDummyStocks();
    }

    public List<String> getStockTypes() {

		/*
		 * The students code to fetch data from the database will be written here.
		 * Populate types with stock types
		 */

        List<String> types = new ArrayList<String>();
        types.add("technology");
        types.add("finance");
        return types;

    }

    public List<Stock> getStockByType(String stockType) {

		/*
		 * The students code to fetch data from the database will be written here
		 * Return list of stocks of type "stockType"
		 */

        return getDummyStocks();
    }
}
