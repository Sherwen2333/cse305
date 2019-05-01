<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>${heading}</h2>
    <form action="getStockSuggestions" method="POST">
        <div class="form-group">
            <label for="customerId">Customer:</label>
            <select class="form-control" name="customerId">
                <c:forEach items="${customers}" var="cd">
                    <option value="${cd.id}"> <c:out value = "${cd.firstName} ${cd.lastName}"/></option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@ include file="footer.jsp" %>