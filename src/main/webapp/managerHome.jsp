<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="heading" value="Home"/>
<%@ include file="header.jsp" %>
<style type="text/css">
    body{
        background-image:url("img/pic.jpeg");
    }
</style>
<div class="container">
    <h2 style="color: azure;">Manager Options:</h2>
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

<%--    <div class="row">--%>
<%--        <div class="col">--%>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Manage Employee</h5>
                    <div class="container">
                        <form action="viewAddEmployee.jsp">
                            <img src="img/addEmployee.png"  width="60" height="60">
                            <input type="submit" value="Add Employee" class="btn btn-danger"/>
                        </form>

                        <form action="getEmployees" class="pt-1">
                            <img src="img/deleteEmployee.png"  width="60" height="60">
                            <input type="submit" value="Edit Employee" class="btn btn-danger"/>
                        </form>

                    </div>
                </div>
            </div>
<%--        </div>--%>
<%--        <div class="col">--%>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Sales and orders</h5>
                    <div class="container">
                        <form action="viewSalesReport.jsp">
                            <img src="img/saleReport.jpg"  width="60" height="60">
                            <input type="submit" value="View sales report" class="btn btn-danger"/>
                        </form>
                        <form action="viewSummaryListing.jsp" class="pt-1">
                            <img src="img/revenueReport.jpg"  width="60" height="60">
                            <input type="submit" value="View Revenue Summary" class="btn btn-danger"/>
                        </form>
                        <form action="getHighestRevenueEmployee" class="pt-1">
                            <img src="img/bestSeller.jpg"  width="60" height="60">
                            <input type="submit" value="Best Representative" class="btn btn-danger"/>
                        </form>
                        <form action="getHighestRevenueCustomer" class="pt-1">
                            <img src="img/highestCumstoer.jpg"  width="60" height="60">
                            <input type="submit" value="Best Customer" class="btn btn-danger"/>
                        </form>
                        <form action="viewSearchOrders" class="pt-1">
                            <img src="img/search.png" width="60" height="60">
                            <input type="submit" value="Search orders" class="btn btn-danger"/>
                        </form>
                    </div>
                </div>
            </div>
<%--        </div>--%>
<%--        <div class="col">--%>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Stocks</h5>
                    <div class="container">
                        <form action="viewSetStockPrice">
                            <img src="img/setPrice.png"  width="60" height="60">
                            <input type="submit" value="Set stock price" class="btn btn-danger"/>
                        </form>
                        <form action="getStocks" class="pt-1">
                            <img src="img/allStocks.jpg"  width="60" height="60">
                            <input type="submit" value="View all Stocks" class="btn btn-danger"/>
                        </form>

                        <form action="getBestsellers" class="pt-1">
                            <img src="img/bestSell.png"  width="60" height="60">
                            <input type="submit" value="View Bestsellers" class="btn btn-danger"/>
                        </form>

                        <form action="getActivelyTradedStocks" class="pt-1">
                            <img src="img/popularStock.png"  width="60" height="60">
                            <input type="submit" value="Popular stocks" class="btn btn-danger"/>
                        </form>
                    </div>
                </div>
            </div>
<%--        </div>--%>
<%--    </div>--%>


</div>
<%@ include file="footer.jsp" %>