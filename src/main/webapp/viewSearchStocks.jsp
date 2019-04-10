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
                        <h5 class="card-title">Search by type</h5>
                        <div class="container">
                            <form method="POST" action="getStocksByType">
                                <label for="itemType">Select stock type:</label>
                                <select class="form-control" name="itemType">
                                    <c:forEach items="${items}" var="cd">
                                        <option value="${cd}"> <c:out value = "${cd}"/></option>
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
                    <h5 class="card-title">Search by stock name</h5>
                    <div class="container">
                        <form method="POST" action="getStocksByName">
                            <label for="itemName">Stock Name:</label>
                            <input type="text" class="form-control" id="itemName" name="itemName" placeholder="Apple">
                            <input type="submit" value="Search" class="btn btn-primary"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>