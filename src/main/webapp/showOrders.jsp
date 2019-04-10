<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>${heading}</h2>
    <div class="container">
        <c:if test="${empty orders}">
        <h3> No orders found! </h3>
        </c:if>
            <c:if test="${not empty orders}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Date</th>
                    <th>Type</th>
                    <th>Number of stocks</th>
                    <th>Details</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="cd">
                    <tr>
                        <td>${cd.id}</td>
                        <td>${cd.datetime}</td>
                        <td>${cd.getClass().getSimpleName()}</td>
                        <td>${cd.numShares}</td>
                        <td>
                        <c:choose>
                            <c:when test="${cd.getClass().getSimpleName() == 'MarketOrder'}">
                                <strong>Buy/Sell: </strong>${cd.buySellType}
                            </c:when>
                            <c:when test="${cd.getClass().getSimpleName() == 'MarketOnCloseOrder'}">
                                <strong>Buy/Sell: </strong>${cd.buySellType}
                            </c:when>
                            <c:when test="${cd.getClass().getSimpleName() == 'TrailingStopOrder'}">
                                <strong>Percentage: </strong>${cd.percentage}
                                <form method="post" action="getOrderPriceHistory">
                                <input type="hidden" name="orderId" value="${cd.id}" />
                                    <input type="submit" value="price history" class="btn btn-success"/>
                                </form>
                            </c:when>
                            <c:when test="${cd.getClass().getSimpleName() == 'HiddenStopOrder'}">
                                <strong>PricePerShare: </strong>${cd.pricePerShare}
                                <form method="post" action="getOrderPriceHistory">
                                <input type="hidden" name="orderId" value="${cd.id}" />
                                <input type="submit" value="price history" class="btn btn-success"/>
                                </form>
                            </c:when>
                        </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>
    </div>
<%@ include file="footer.jsp" %>