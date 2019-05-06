<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="heading" value="Home"/>
<%@ include file="header.jsp" %>
<!--
	This is the Home page for Customer Representative
	This page contains various buttons to navigate the online auction house
	This page contains customer representative specific accessible buttons
-->
<style type="text/css">
    body{
        background-image:url("img/pic.jpeg");
    }
    .card-body{
        background-color: #f9d4d4;
    }
</style>
<div class="container">
    <h2 style="color: azure;">Customer Representative Options:</h2>
    <%
        String email = (String)session.getAttribute("email");
        String role = (String)session.getAttribute("role");

        //redirect to appropriate home page if already logged in
        if(email != null) {
            if(role.equals("manager")) {
                response.sendRedirect("managerHome.jsp");
            }
            else if(!role.equals("customerRepresentative")) {
                response.sendRedirect("home.jsp");
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
                <h5 class="card-title">Record order</h5>
                <div class="container">
                    <form action="viewAddCustomerOrder">
                        <img src="img/search.png"  width="60" height="60">
                        <input type="submit" value="Record order" class="btn btn-danger"/>
                    </form>
                </div>
              </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Manage Customer</h5>
                <div class="container">
                    <form action="viewAddCustomer.jsp">
                        <img src="img/addEmployee.png"  width="60" height="60">
                        <input type="submit" value="Add Customer" class="btn btn-danger"/>
                    </form>
                    <form action="getCustomers" class="pt-1">
                        <img src="img/deleteEmployee.png"  width="60" height="60">
                        <input type="submit" value="Edit Customer" class="btn btn-danger"/>
                    </form>

                </div>
              </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Other</h5>
                <div class="container">
                    <form action="getCustomerMailingList">
                        <img src="img/mail.png"  width="60" height="60">
                        <input type="submit" value="Customer Mailing List" class="btn btn-danger"/>
                    </form>

                    <form action="viewCustomerStockSuggestions" class="pt-1">
                        <img src="img/suggestion.png"  width="60" height="60">
                        <input type="submit" value="View Suggestions" class="btn btn-danger"/>
                    </form>
                </div>
              </div>
            </div>
        </div>
</div>
<%@ include file="footer.jsp" %>