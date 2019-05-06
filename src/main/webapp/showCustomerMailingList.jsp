<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container">
	<h2>${heading}</h2>
	<div class="container">
	<c:if test="${empty customers}">
		<h3> Customer details not found! <h3/> 
	</c:if>
	<c:if test="${not empty customers}">
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th>SSN</th>
		      <th>First Name</th>
		      <th>Last Name</th>
		      <th>Address</th>
		      <th>City</th>
		      <th>State</th>
		      <th>Zip Code</th>
			  <th>Email</th>
		    </tr>
		  </thead>
		  <tbody>
		     <c:forEach items="${customers}" var="cd">
		       <tr>
		         <td>${cd.id}</td>
		         <td>${cd.firstName}</td>
		         <td>${cd.lastName}</td>
		         <td>${cd.address}</td>
		         <td>${cd.location.city}</td>
		         <td>${cd.location.state}</td>
		         <td>${cd.location.zipCode}</td>
		         <td>${cd.email}</td>
		       </tr>
		     </c:forEach>
		  </tbody>
		</table>
	</c:if>
	</div>
<%@ include file="footer.jsp" %>
