<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="heading"  value="Search stocks"/>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>Search Options:</h2>
    <div class="row">
        <c:if test="${empty items}">
        </c:if>
        <c:if test="${not empty items}">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Search by stock symbol</h5>
                        <div class="container">
                            <form method="POST" action="getOrdersByStockSymbol">
                                <label for="stockSymbol">Select stock symbol:</label>
                                <select class="form-control" name="stockSymbol">
                                    <c:forEach items="${items}" var="cd">
                                        <option value="${cd.symbol}"> <c:out value = "${cd.symbol}"/></option>
                                    </c:forEach>
                                </select>
                                <input type="submit" value="Search" class="btn btn-primary"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="col">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Search by customer name</h5>
                    <div class="container">
                        <form method="POST" action="getOrdersByCustomerName">
                            <label for="customerName">Customer Name:</label>
                            <input type="text" class="form-control" id="customerName" name="customerName" placeholder="John">
                            <input type="submit" value="Search" class="btn btn-primary"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>