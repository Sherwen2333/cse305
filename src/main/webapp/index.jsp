<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="heading" value="Home"/>

<style type="text/css">
	body{
		background-image:url("img/pic.jpeg");
	}
</style>
<body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="login.css" rel="stylesheet" />
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
<div class="loginBlock">
			<h2 class="loginTitle">Login</h2>
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

						System.out.print("Incorrect Login credentials!");
					}

					else {
						System.out.print("Some error occurred! Please try again.");
					}
				}
			%>
		<div class="loginTitle">
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
				<input type="submit" value="Login" class="btn btn-danger"/>
			</form>
		</div>

<script type="text/javascript"> window.onload = alertName; </script>
<%@ include file="footer.jsp" %>