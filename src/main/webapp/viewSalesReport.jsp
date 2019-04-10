<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="heading" value="Home"/>
<%@ include file="header.jsp" %>
<div class="container">

    <h2>Sales Report</h2>
    <h3>Select Month and Year</h3>
    <form method="post" action="showSalesReport">
        <div class="form-group">
            <label for="month">Month</label>
            <select class="form-control" name="month">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>
            <label for="year">Year</label>
            <select class="form-control" name="year">
                <c:forEach var="i" begin="1900" end="2018">
                    <option value="${i}"><c:out value="${i}"/></option>
                </c:forEach>
            </select>
        </div>
        <input type="submit" value="Search" class="btn btn-success"/>
    </form>
</div>
<%@ include file="footer.jsp" %>