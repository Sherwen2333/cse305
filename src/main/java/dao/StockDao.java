package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Stock;

public class StockDao {
    public static void main(String[] args) {
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
//            String query = "SELECT * FROM Stock";
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()) {
//                System.out.println(rs.getString(1));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

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

		/*Sample data begins*/
        for (int i = 0; i < 10; i++) {
            stocks.add(getDummyStock());
        }
		/*Sample data ends*/

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
        List<Stock> stocks = new ArrayList<Stock>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "SELECT * FROM Stock";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Stock stock= new Stock();
                stock.setName(rs.getString(2));
                stock.setNumShares(rs.getInt(4));
                stock.setPrice(rs.getDouble(5));
                stock.setSymbol(rs.getString(1));
                stock.setType(rs.getString(3));
            stocks.add(stock);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return stocks;

	}

    public Stock getStockBySymbol(String stockSymbol)
    {

    Stock stock = new Stock();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "SELECT * FROM Stock WHERE StockSymbol=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, stockSymbol);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                stock.setName(rs.getString(2));
                stock.setNumShares(rs.getInt(4));
                stock.setPrice(rs.getDouble(5));
                stock.setSymbol(stockSymbol);
                stock.setType(rs.getString(3));
            }else {
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        /*
		 * The students code to fetch data from the database will be written here
		 * Return stock matching symbol
		 */
        return stock;
    }

    public String setStockPrice(String stockSymbol, double stockPrice) {
        /*
         * The students code to fetch data from the database will be written here
         * Perform price update of the stock symbol
         */

        return "success";
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

        List<Stock> stocks = new ArrayList<Stock>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "SELECT * FROM Stock where CompanyName like ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,'%'+name+'%');
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Stock stock= new Stock();
                stock.setName(rs.getString(2));
                stock.setNumShares(rs.getInt(4));
                stock.setPrice(rs.getDouble(5));
                stock.setSymbol(rs.getString(1));
                stock.setType(rs.getString(3));
                stocks.add(stock);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return stocks;
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
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "SELECT distinct StockType FROM Stock";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {

                types.add(rs.getString(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return types;

    }

    public List<Stock> getStockByType(String stockType) {

        List<Stock> stocks = new ArrayList<Stock>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "SELECT * FROM Stock where StockType like ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,stockType);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Stock stock= new Stock();
                stock.setName(rs.getString(2));
                stock.setNumShares(rs.getInt(4));
                stock.setPrice(rs.getDouble(5));
                stock.setSymbol(rs.getString(1));
                stock.setType(rs.getString(3));
                stocks.add(stock);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stocks;

    }
}
