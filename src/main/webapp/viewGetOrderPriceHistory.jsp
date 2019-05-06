<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>${heading}</h2>
    <div class="container">
        <c:if test="${empty entries}">
        <h3> No stocks found! <h3/>
            </c:if>
            <c:if test="${not empty entries}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>OrderId</th>
                    <th>Date</th>
                    <th>Symbol</th>
                    <th>PricePerShare</th>
                    <th>Price</th> <!-- trailing-stop price or hidden-stop price -->
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${entries}" var="cd">
                    <tr>
                        <td>${cd.orderId}</td>
                        <td>${cd.date}</td>
                        <td>${cd.stockSymbol}</td>
                        <td>${cd.pricePerShare}</td>
                        <td>${cd.price}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>
    </div>
<%@ include file="footer.jsp" %>