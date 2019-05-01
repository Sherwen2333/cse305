<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>${heading}</h2>
    <div class="container">
        <c:if test="${empty stocks}">
        <h3> No stocks found! <h3/>
            </c:if>
            <c:if test="${not empty stocks}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Symbol</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Number of stocks</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${stocks}" var="cd">
                    <tr>
                        <td>${cd.symbol}</td>
                        <td>${cd.name}</td>
                        <td>${cd.type}</td>
                        <td>${cd.numShares}</td>
                        <td></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>
    </div>
<%@ include file="footer.jsp" %>