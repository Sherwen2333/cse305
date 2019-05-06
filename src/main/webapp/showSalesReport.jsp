<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container">
	<h2>${heading}</h2>
	<div class="container">
		<c:if test="${empty items}">
		<h3>No items found! <h3/>
        </c:if>

        <c:if test="${not empty items}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Date</th>
                <th>AccountId</th>
                <th>StockSymbol</th>
                <th>NumberOfShares</th>
                <th>PricePerShare</th>
                <th>Amount</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${items}" var="cd">
                <tr>
                    <td>${cd.date}</td>
                    <td>${cd.accountId}</td>
                    <td>${cd.stockSymbol}</td>
                    <td>${cd.numShares}</td>
                    <td>${cd.pricePerShare}</td>
                    <td>${cd.amount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </c:if>
	</div>
	<%@ include file="footer.jsp" %>