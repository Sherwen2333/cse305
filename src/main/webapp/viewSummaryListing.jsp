<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="heading" value="Home"/>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>Summary Listing</h2>
    <h3>Search Item Name, Item Type or Customer Name:</h3>
    <form action="getSummaryListing">
        <input type="text" name="searchKeyword" placeholder="Item Name or Item Type or Customer Name"
               class="form-control"/>
        <input type="submit" value="Search" class="btn btn-success"/>
    </form>
</div>
<%@ include file="footer.jsp" %>
