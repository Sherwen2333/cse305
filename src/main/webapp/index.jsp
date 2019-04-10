<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="heading" value="Home"/>
<%@ include file="header.jsp" %>

<div class="container">
			<h2>Login</h2>
			<%
				String email = (String)session.getAttribute("email");
				String role = (String)session.getAttribute("role");
				
				//redirect to home page if already logged in
				if(email != null) {
					if(role.equals("manager")) {
						response.sendRedirect("managerHome.jsp");
					}
					else if(role.equals("customerRepresentative")) {
						response.sendRedirect("customerRepresentativeHome.jsp");
					}
					else {
						response.sendRedirect("home.jsp");	
					}
				}
				
				String status = request.getParameter("status");
				if(status != null) {
					if(status.equals("false")) {
						out.print("Incorrect Login credentials!");
					}
					else {
						out.print("Some error occurred! Please try again.");
					}
				}
			%>
			<form action="login">
				<div class="form-group">
					<input type="email" class="form-control" name="username" placeholder="Username">
				</div>
				<div class="form-group">
	            	<input type="password" class="form-control" name="password" placeholder="Password">
	        	</div>
				<div class="form-group">
					<select class="form-control" name="role">
                        <option value="customer">Customer</option>
                        <option value="manager">Manager</option>
                        <option value="customerRepresentative">Customer Representative</option>
					</select>
				</div>
				<input type="submit" value="Login" class="btn btn-success"/>
			</form>
		</div>
<%@ include file="footer.jsp" %>