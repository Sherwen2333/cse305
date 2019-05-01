<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container-fluid">
    <h2>${heading}</h2>
    <c:if test="${empty employees}">
    <h3> Employee details not found! <h3/>
        </c:if>
        <c:if test="${not empty employees}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Employee ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Zip Code</th>
                <th>Telephone</th>
                <th>Email</th>
                <th>Start Date</th>
                <th>Hourly Rate</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employees}" var="cd">
                <tr>
                    <td>${cd.id}</td>
                    <td>${cd.firstName}</td>
                    <td>${cd.lastName}</td>
                    <td>${cd.address}</td>
                    <td>${cd.location.city}</td>
                    <td>${cd.location.state}</td>
                    <td>${cd.location.zipCode}</td>
                    <td>${cd.telephone}</td>
                    <td>${cd.email}</td>
                    <td>${cd.startDate}</td>
                    <td>${cd.hourlyRate}</td>
                    <td>
                        <form method="POST" action="editEmployee">
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="employeeID" value=${cd.employeeID}>
                            </div>
                            <input type="submit" value="Edit" class="btn btn-success"/>
                        </form>
                    </td>
                    <td>
                        <form method="POST" action="deleteEmployee">
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="employeeID" value=${cd.employeeID}>
                            </div>
                            <input type="submit" value="Delete" class="btn btn-success"/>
                        </form>
                    </td>

                    <td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </c:if>
</div>
<%@ include file="footer.jsp" %>