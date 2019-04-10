<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="Set Stock Price" value="Home"/>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>Stock Price History:</h2>
    <form action="getStockPriceHistory" method="POST">
        <div class="form-group">
            <label for="stockSymbol">Stock Symbol:</label>
            <select class="form-control" name="stockSymbol">
                <c:forEach items="${stocks}" var="cd">
                    <option value="${cd.symbol}"> <c:out value = "${cd.symbol}"/></option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@ include file="footer.jsp" %>