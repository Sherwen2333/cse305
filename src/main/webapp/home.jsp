<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="heading" value="Home"/>
<%@ include file="header.jsp" %>

<div class="container">
    <h2>Customer Options:</h2>
    <%
        String email = (String)session.getAttribute("email");
        String role = (String)session.getAttribute("role");

        //redirect to appropriate home page if already logged in
        if(email != null) {
            if(role.equals("manager")) {
                response.sendRedirect("managerHome.jsp");
            }
            else if(role.equals("customerRepresentative")) {
                response.sendRedirect("customerRepresentativeHome.jsp");
            }
        }
        else {
            // redirect to log in if not alreaddy logged in
            response.sendRedirect("index.jsp");
        }
    %>
    <div class="row">
    <div class="col">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Orders</h5>
            <div class="container">
                <form action="viewAddOrder">
                    <input type="submit" value="Place Order" class="btn btn-success"/>
                </form>

                <form action="getOrdersByCustomer" class="pt-1">
                    <input type="submit" value="Order History" class="btn btn-success"/>
                </form>
            </div>
          </div>
        </div>
    </div>
    <div class="col">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Stocks</h5>
            <div class="container">
                <form action="getStocksByCustomer">
                    <input type="submit" value="Current stock holdings" class="btn btn-success"/>
                </form>
                <form action="viewGetStockPriceHistory" class="pt-1">
                    <input type="submit" value="Stock price history" class="btn btn-success"/>
                </form>
                <form action="viewSearchStocks" class="pt-1">
                    <input type="submit" value="Search stocks" class="btn btn-success"/>
                </form>
                <form action="getCustomerBestsellers" class="pt-1">
                    <input type="submit" value="View bestseller stocks" class="btn btn-success"/>
                </form>
                <form action="getStockSuggestions" class="pt-1">
                    <input type="submit" value="View suggested stocks" class="btn btn-success"/>
                </form>
            </div>
          </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>