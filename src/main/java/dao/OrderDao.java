package dao;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao {
    public static void main(String[] args) {
    }

    public Order getDummyTrailingStopOrder() {
        TrailingStopOrder order = new TrailingStopOrder();

        order.setId(1);
        order.setDatetime(new Date());
        order.setNumShares(5);
        order.setPercentage(12.0);
        return order;
    }

    public Order getDummyMarketOrder() {
        MarketOrder order = new MarketOrder();

        order.setId(1);
        order.setDatetime(new Date());
        order.setNumShares(5);
        order.setBuySellType("buy");
        return order;
    }

    public Order getDummyMarketOnCloseOrder() {
        MarketOnCloseOrder order = new MarketOnCloseOrder();

        order.setId(1);
        order.setDatetime(new Date());
        order.setNumShares(5);
        order.setBuySellType("buy");
        return order;
    }

    public Order getDummyHiddenStopOrder() {
        HiddenStopOrder order = new HiddenStopOrder();

        order.setId(1);
        order.setDatetime(new Date());
        order.setNumShares(5);
        order.setPricePerShare(145.0);
        return order;
    }

    public List<Order> getDummyOrders() {
        List<Order> orders = new ArrayList<Order>();

        for (int i = 0; i < 3; i++) {
            orders.add(getDummyTrailingStopOrder());
        }

        for (int i = 0; i < 3; i++) {
            orders.add(getDummyMarketOrder());
        }

        for (int i = 0; i < 3; i++) {
            orders.add(getDummyMarketOnCloseOrder());
        }

        for (int i = 0; i < 3; i++) {
            orders.add(getDummyHiddenStopOrder());
        }

        return orders;
    }

    public String submitOrder(Order order, Customer customer, Employee employee, Stock stock) {

		/*
		 * Student code to place stock order
		 * Employee can be null, when the order is placed directly by Customer
         * */

		/*Sample data begins*/
        try{
            customer= new Customer();
            customer.setClientId("1232323");
            employee= new Employee();
            employee.setEmployeeID("213232");
            System.out.println(customer.getClientId());
            System.out.println(stock.getSymbol());
//            customer.get
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "INSERT into Orders  (EmployeeId,OrderId,OrderType,StockSymbol,NumberOfShare,buy_sell,Percentage,Time,ClientID,Fee,PricePerShare)\n" +
                    "values (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);
            if(employee==null){
                ps.setNull(1, Types.NULL);
            }
            else {
                ps.setInt(1,Integer.parseInt(employee.getEmployeeID()));

            }
            ps.setNull(2, Types.NULL);
            ps.setString(4,stock.getSymbol());
            ps.setInt(5,order.getNumShares());
            ps.setDouble(11,stock.getPrice());
            Class a = order.getClass();
            if(a.getName().equals("model.MarketOrder")){
                MarketOrder marketOrder= (MarketOrder)order;
                ps.setString(3,"MarketOrder");
                ps.setString(6,marketOrder.getBuySellType());
                ps.setNull(7, Types.NULL);

                System.out.println(marketOrder.getBuySellType());
                if(marketOrder.getBuySellType().equals("Sell")){
                    stockOperation(marketOrder,con,stock,customer,"-");
                }
                else {
                    stockOperation(marketOrder,con,stock,customer,"+");
                }

            }
            else if(a.getName().equals("model.MarketOnCloseOrder")){
                MarketOnCloseOrder marketOrder= (MarketOnCloseOrder)order;
                MarketOnCloseOrder marketOnCloseOrder= (MarketOnCloseOrder)order;
                ps.setString(3,"MarketOnCloseOrder");
                ps.setString(6,marketOnCloseOrder.getBuySellType());
                ps.setNull(7, Types.NULL);

                if(marketOrder.getBuySellType().equals("Sell")){
                    stockOperation(marketOrder,con,stock,customer,"-");
                }
                else {
                    stockOperation(marketOrder,con,stock,customer,"+");
                }

            }else if(a.getName().equals("model.TrailingStopOrder")){
                System.out.println("test trailing");
                TrailingStopOrder trailingStopOrder= (TrailingStopOrder)order;
                ps.setString(3,"TrailingStopOrder");
                ps.setNull(6, Types.NULL);
                ps.setInt(7,(int) Math.round(trailingStopOrder.getPercentage()));
            }else if(a.getName().equals("model.HiddenStopOrder")){
                HiddenStopOrder hiddenStopOrder= (HiddenStopOrder)order;
                ps.setString(3,"HiddenStopOrder");
                ps.setNull(6, Types.NULL);
                ps.setInt(7,Types.NULL);
                ps.setDouble(11,((HiddenStopOrder) order).getPricePerShare());
            }
            java.util.Date date = order.getDatetime();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(8,sqlDate);
            ps.setInt(9,Integer.parseInt(customer.getClientId()));
            ps.setDouble(10,stock.getPrice()*order.getNumShares()*0.05);
            ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "success";
		/*Sample data ends*/

    }

    public List<Order> getOrderByStockSymbol(String stockSymbol) {

        /*
		 * Student code to get orders by stock symbol
         */
        List<Order> orders= new ArrayList<Order>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "SELECT * from Orders where StockSymbol=?;";
            PreparedStatement ps = con.prepareStatement(query);
           ps.setString(1,stockSymbol);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                if(rs.getString(3).equals("MarketOrder")){
                    MarketOrder marketOrder= new MarketOrder();
                    marketOrder.setBuySellType(rs.getString(6));
                    marketOrder.setId(rs.getInt(2));
                    marketOrder.setDatetime(rs.getDate("Time"));
                    marketOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(marketOrder);
                }
                if(rs.getString(3).equals("MarketOnCloseOrder")){
                    MarketOnCloseOrder onCloseOrder= new MarketOnCloseOrder();
                    onCloseOrder.setBuySellType(rs.getString("buy_sell"));
                    onCloseOrder.setId(rs.getInt(2));
                    onCloseOrder.setDatetime(rs.getDate("Time"));
                    onCloseOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(onCloseOrder);
                }
                if(rs.getString(3).equals("HiddenStopOrder")){
                    HiddenStopOrder hiddenStopOrder= new HiddenStopOrder();
                    hiddenStopOrder.setPricePerShare(rs.getDouble("PricePerShare"));
                    hiddenStopOrder.setId(rs.getInt(2));
                    hiddenStopOrder.setDatetime(rs.getDate("Time"));
                    hiddenStopOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(hiddenStopOrder);

                }
                if(rs.getString(3).equals("TrailingStopOrder")){
                    TrailingStopOrder trailingStopOrder= new TrailingStopOrder();
                    trailingStopOrder.setPercentage(rs.getDouble("Percentage"));
                    trailingStopOrder.setId(rs.getInt(2));
                    trailingStopOrder.setDatetime(rs.getDate("Time"));
                    trailingStopOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(trailingStopOrder);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return orders;
    }

    public List<Order> getOrderByCustomerName(String customerName) {
        String last=customerName.split(" ")[1];
        String first=customerName.split(" ")[0];
        System.out.println(last);
        System.out.println(first);
        List<Order> orders= new ArrayList<Order>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "SELECT Orders.* from Orders,Person where LastName =? and FirstName=?;\n";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,last);
            ps.setString(2,first);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                if(rs.getString(3).equals("MarketOrder")){
                    MarketOrder marketOrder= new MarketOrder();
                    marketOrder.setBuySellType(rs.getString(6));
                    marketOrder.setId(rs.getInt(2));
                    marketOrder.setDatetime(rs.getDate("Time"));
                    marketOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(marketOrder);
                }
                if(rs.getString(3).equals("MarketOnCloseOrder")){
                    MarketOnCloseOrder onCloseOrder= new MarketOnCloseOrder();
                    onCloseOrder.setBuySellType(rs.getString("buy_sell"));
                    onCloseOrder.setId(rs.getInt(2));
                    onCloseOrder.setDatetime(rs.getDate("Time"));
                    onCloseOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(onCloseOrder);
                }
                if(rs.getString(3).equals("HiddenStopOrder")){
                    HiddenStopOrder hiddenStopOrder= new HiddenStopOrder();
                    hiddenStopOrder.setPricePerShare(rs.getDouble("PricePerShare"));
                    hiddenStopOrder.setId(rs.getInt(2));
                    hiddenStopOrder.setDatetime(rs.getDate("Time"));
                    hiddenStopOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(hiddenStopOrder);

                }
                if(rs.getString(3).equals("TrailingStopOrder")){
                    TrailingStopOrder trailingStopOrder= new TrailingStopOrder();
                    trailingStopOrder.setPercentage(rs.getDouble("Percentage"));
                    trailingStopOrder.setId(rs.getInt(2));
                    trailingStopOrder.setDatetime(rs.getDate("Time"));
                    trailingStopOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(trailingStopOrder);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        /*
         * The students code to fetch data from the database will be written here
         * Show orders for given customerId
         */


        return orders;
    }

    public List<Order> getOrderHistory(String customerId) {
        List<Order> orders= new ArrayList<Order>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "SELECT * from Orders where ClientID=?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,Integer.parseInt("1232323"));
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                if(rs.getString(3).equals("MarketOrder")){
                    MarketOrder marketOrder= new MarketOrder();
                    marketOrder.setBuySellType(rs.getString(6));
                    marketOrder.setId(rs.getInt(2));
                    marketOrder.setDatetime(rs.getDate("Time"));
                    marketOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(marketOrder);
                }
                if(rs.getString(3).equals("MarketOnCloseOrder")){
                    MarketOnCloseOrder onCloseOrder= new MarketOnCloseOrder();
                    onCloseOrder.setBuySellType(rs.getString("buy_sell"));
                    onCloseOrder.setId(rs.getInt(2));
                    onCloseOrder.setDatetime(rs.getDate("Time"));
                    onCloseOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(onCloseOrder);
                }
                if(rs.getString(3).equals("HiddenStopOrder")){
                    HiddenStopOrder hiddenStopOrder= new HiddenStopOrder();
                    hiddenStopOrder.setPricePerShare(rs.getDouble("PricePerShare"));
                    hiddenStopOrder.setId(rs.getInt(2));
                    hiddenStopOrder.setDatetime(rs.getDate("Time"));
                    hiddenStopOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(hiddenStopOrder);

                }
                if(rs.getString(3).equals("TrailingStopOrder")){
                    TrailingStopOrder trailingStopOrder= new TrailingStopOrder();
                    trailingStopOrder.setPercentage(rs.getDouble("Percentage"));
                    trailingStopOrder.setId(rs.getInt(2));
                    trailingStopOrder.setDatetime(rs.getDate("Time"));
                    trailingStopOrder.setNumShares(rs.getInt("NumberOfShare"));
                    orders.add(trailingStopOrder);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        /*
		 * The students code to fetch data from the database will be written here
		 * Show orders for given customerId
		 */
        return orders;
    }


    public List<OrderPriceEntry> getOrderPriceHistory(String orderId) {

        /*
		 * The students code to fetch data from the database will be written here
		 * Query to view price history of hidden stop order or trailing stop order
		 * Use setPrice to show hidden-stop price and trailing-stop price
		 */
        List<OrderPriceEntry> orderPriceHistory = new ArrayList<OrderPriceEntry>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql4.cs.stonybrook.edu:3306/zhaowhuang", "zhaowhuang", "111067886");
            String query = "SELECT OrderType from Orders where OrderId="+Integer.parseInt(orderId);
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                if(rs.getString(1).equals("HiddenStopOrder")){
                    String query1="SELECT HiddenStopOrder.* from HiddenStopOrder where HiddenStopOrder.TradeId =31";
                }
            }
        }

        catch (Exception e){

        }
        return orderPriceHistory;
    }
    void stockOperation (Order order,Connection con,Stock stock,Customer customer,String buySell){
        try{
            String query = "SELECT * from StockHold where StockHold.StockSymbol=? and ClientID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,stock.getSymbol());
            ps.setInt(2,Integer.parseInt(customer.getClientId()));
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
            int ClientId=Integer.parseInt(customer.getClientId());
            String StockSymbol=stock.getSymbol();
            int SellNumber=order.getNumShares();
        String query1="UPDATE StockHold\n" +
                "set NumShare= (SELECT NumShare where ClientID = "+ClientId+" and StockSymbol='"+StockSymbol+"')"+buySell+SellNumber+"\n" +
                "WHERE ClientID = "+ClientId+" and StockSymbol='"+StockSymbol+"'";
                System.out.println(query1);
        PreparedStatement ps1 = con.prepareStatement(query1);
        ps1.execute();
            }
            else {
                if(buySell.equals("+")){
                 String query1 ="INSERT StockHold values (?,?,?);";
                 ps= con.prepareStatement(query1);
                 ps.setInt(1,order.getNumShares());
                 ps.setString(2,stock.getSymbol());
                 ps.setInt(3,Integer.parseInt(customer.getClientId()));
                 ps.execute();
                }

            }
        }
        catch (Exception e){

        }
    }
}
