<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="heading" value="Home"/>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>Manager Options:</h2>
    <%
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");

        //redirect to appropriate home page if already logged in
        if (email != null) {
            if (role.equals("customerRepresentative")) {
                response.sendRedirect("customerRepresentativeHome.jsp");
            } else if (!role.equals("manager")) {
                response.sendRedirect("home.jsp");
            }
        } else {
            // redirect to log in if not alreaddy logged in
            response.sendRedirect("index.jsp");
        }

    %>

    <div class="row">
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Manage Employee</h5>
                    <div class="container">
                        <form action="viewAddEmployee.jsp">
                            <input type="submit" value="Add Employee" class="btn btn-primary"/>
                        </form>
                        <form action="getEmployees" class="pt-1">
                            <input type="submit" value="View / Edit / Delete Employee" class="btn btn-primary"/>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Sales and orders</h5>
                    <div class="container">
                        <form action="viewSalesReport.jsp">
                            <input type="submit" value="View sales report" class="btn btn-primary"/>
                        </form>
                        <form action="viewSummaryListing.jsp" class="pt-1">
                            <input type="submit" value="View Revenue Summary" class="btn btn-primary"/>
                        </form>
                        <form action="getHighestRevenueEmployee" class="pt-1">
                            <input type="submit" value="Highest Revenue Customer Representative" class="btn btn-success"/>
                        </form>
                        <form action="getHighestRevenueCustomer" class="pt-1">
                            <input type="submit" value="Highest Revenue Customer" class="btn btn-success"/>
                        </form>
                        <form action="viewSearchOrders" class="pt-1">
                            <input type="submit" value="Search orders" class="btn btn-success"/>
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
                        <form action="viewSetStockPrice">
                            <input type="submit" value="Set stock price" class="btn btn-primary"/>
                        </form>
                        <form action="getStocks" class="pt-1">
                            <input type="submit" value="View all Stocks" class="btn btn-primary"/>
                        </form>

                        <form action="getBestsellers" class="pt-1">
                            <input type="submit" value="View Bestsellers" class="btn btn-primary"/>
                        </form>

                        <form action="getActivelyTradedStocks" class="pt-1">
                            <input type="submit" value="View actively traded stocks" class="btn btn-success"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>
<%@ include file="footer.jsp" %>