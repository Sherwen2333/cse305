package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Stock;
import model.Customer;
import model.Employee;
import model.Location;

import javax.rmi.CORBA.Util;


public class StockDao {

    public List<Stock> getActivelyTradedStocks() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch details of all the stocks has to be implemented
		 * Return list of actively traded stocks
		 */
        List<Stock> stocks = new ArrayList<Stock>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

            //	Statement state = con.createStatement();
            String query = "SELECT Stock.* from Stock,ActivelyStock where ActivelyStock.StockSymbol=Stock.StockSymbol order by ActivelyStock.Time desc";
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

	public List<Stock> getAllStocks() {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Return list of stocks
		 */
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

    public Stock getStockBySymbol(String stockSymbol)
    {
        Stock stock= new Stock();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

            String query="SELECT * from Stock where StockSymbol=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, stockSymbol);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                stock.setSymbol(rs.getString(1));
                stock.setName(rs.getString(2));
                stock.setType(rs.getString(3));
                stock.setNumShares(rs.getInt(4));
                stock.setPrice(rs.getDouble(5));
            }
        }
        catch (Exception e){

        }
        /*
		 * The students code to fetch data from the database will be written here
		 * Return stock matching symbol
		 */
        return stock;
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

            String query1="INSERT StockChange values (?,?,?)";
            ps=con.prepareStatement(query1);
            ps.setString(1,stockSymbol);
            ps.setDouble(2,stockPrice);
            ps.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
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
		List<Stock> stocks= new ArrayList<Stock>();
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query="SELECT Symbol,CompanyName,StockType,TotalSell,PricePerShare from StockSellRecord,Stock where StockSellRecord.Symbol=Stock.StockSymbol order by TotalSell desc";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                Stock stock= new Stock();
                stock.setSymbol(resultSet.getString("Symbol"));
                stock.setName(resultSet.getString("CompanyName"));
                stock.setType(resultSet.getString("StockType"));
                stock.setPrice(resultSet.getDouble("PricePerShare"));
                stock.setNumShares(resultSet.getInt("TotalSell"));
                stocks.add(stock);
            }

        }
		catch (Exception e){

        }

		return stocks;

	}

    public List<Stock> getCustomerBestsellers(String customerID) {

		/*
		 * The students code to fetch data from the database will be written here.
		 * Get list of customer bestseller stocks
		 */
        List<Stock> stocks= new ArrayList<Stock>();
        System.out.println();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query="SELECT Stock.StockSymbol,Stock.CompanyName,Stock.StockType,StockHold.NumShare,Stock.PricePerShare from StockHold ,Stock where ClientID=? and Stock.StockSymbol=StockHold.StockSymbol order by StockHold.NumShare desc;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,Integer.parseInt(customerID));
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                Stock stock= new Stock();
                stock.setSymbol(resultSet.getString("StockSymbol"));
                stock.setName(resultSet.getString("CompanyName"));
                stock.setType(resultSet.getString("StockType"));
                stock.setPrice(resultSet.getDouble("PricePerShare"));
                stock.setNumShares(resultSet.getInt("NumShare"));
                stocks.add(stock);
            }

        }
        catch (Exception e){
                e.printStackTrace();
        }

        return stocks;

    }

	public List getStocksByCustomer(String customerId) {

        List<Stock> stocks= new ArrayList<Stock>();
        System.out.println();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query="SELECT Stock.StockSymbol,Stock.CompanyName,Stock.StockType,StockHold.NumShare,Stock.PricePerShare from StockHold ,Stock where ClientID=? and Stock.StockSymbol=StockHold.StockSymbol order by Stock.PricePerShare;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,Integer.parseInt(customerId));
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                Stock stock= new Stock();
                stock.setSymbol(resultSet.getString("StockSymbol"));
                stock.setName(resultSet.getString("CompanyName"));
                stock.setType(resultSet.getString("StockType"));
                stock.setPrice(resultSet.getDouble("PricePerShare"));
                stock.setNumShares(resultSet.getInt("NumShare"));
                stocks.add(stock);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return stocks;
		/*
		 * The students code to fetch data from the database will be written here
		 * Get stockHoldings of customer with customerId
		 */

	}

    public List<Stock> getStocksByName(String name) {

        /*
		 * The students code to fetch data from the database will be written here
		 * Return list of stocks matching "name"
		 */

        List<Stock> stocks= new ArrayList<Stock>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

            //	Statement state = con.createStatement();
            String query = "SELECT * FROM Stock where CompanyName like '%"+name+"%';";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(query);
            while (rs.next()){
                Stock stock= new Stock();
                stock.setPrice(rs.getDouble("PricePerShare"));
                stock.setNumShares(rs.getInt("NumShares"));
                stock.setType(rs.getString("StockType"));
                stock.setName(rs.getString("CompanyName"));
                stock.setSymbol(rs.getString("StockSymbol"));
                stocks.add(stock);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stocks;
    }

    public List<Stock> getStockSuggestions(String customerID) {

		/*
		 * The students code to fetch data from the database will be written here
		 * Return stock suggestions for given "customerId"
		 */
        List<Stock> stocks= new ArrayList<Stock>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

            //	Statement state = con.createStatement();
            String query = "SELECT Stock.* from Stock where StockSymbol not in (SELECT StockHold.StockSymbol from StockHold where StockHold.ClientID="+Integer.parseInt(customerID)+") order by PricePerShare";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(query);
            while (rs.next()){
                Stock stock= new Stock();
                stock.setPrice(rs.getDouble("PricePerShare"));
                stock.setNumShares(rs.getInt("NumShares"));
                stock.setType(rs.getString("StockType"));
                stock.setName(rs.getString("CompanyName"));
                stock.setSymbol(rs.getString("StockSymbol"));
                stocks.add(stock);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stocks;


    }

    public List<Stock> getStockPriceHistory(String stockSymbol) {

		/*
		 * The students code to fetch data from the database
		 * Return list of stock objects, showing price history
		 */
        List<Stock> stocks= new ArrayList<Stock>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

            //	Statement state = con.createStatement();
            String query = "SELECT * from StockHistory where Symbol='"+stockSymbol+"'";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(query);
            while (rs.next()){
                Stock stock= new Stock();
                stock.setPrice(rs.getDouble("Price"));
                stock.setDate(rs.getTimestamp("Time").toString());
                stock.setType(rs.getString("Type"));
                stock.setName(rs.getString("Name"));
                stock.setSymbol(rs.getString("Symbol"));
                stocks.add(stock);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stocks;


    }

    public List<String> getStockTypes() {

		/*
		 * The students code to fetch data from the database will be written here.
		 * Populate types with stock types
		 */
		List<String> types= new ArrayList<String>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

            //	Statement state = con.createStatement();
            String query = "SELECT DISTINCT StockType FROM STOCK";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(query);

            while (rs.next()){
                types.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return types;

    }

    public List<Stock> getStockByType(String stockType) {

		/*
		 * The students code to fetch data from the database will be written here
		 * Return list of stocks of type "stockType"
		 */

        List<Stock> stocks= new ArrayList<Stock>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");

            //	Statement state = con.createStatement();
            String query = "SELECT  * FROM STOCK where StockType='"+stockType+"'";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(query);
            while (rs.next()){
                Stock stock= new Stock();
                stock.setPrice(rs.getDouble("PricePerShare"));
                stock.setNumShares(rs.getInt("NumShares"));
                stock.setType(stockType);
                stock.setName(rs.getString("CompanyName"));
                stock.setSymbol(rs.getString("StockSymbol"));
                stocks.add(stock);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stocks;
    }
}
