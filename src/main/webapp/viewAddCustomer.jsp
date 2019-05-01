<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>

<!--
This is the Add Customer page
This page displays fields to add a Customer
The details are sent to the AddCustomerController class in resources package
-->

<div class="container">
	<h1>Add a new Customer:</h1>
	<form action="addCustomer" method="POST">
		<div class="form-group">
			<label for="customerEmail">Email address</label>
			<input type="email" class="form-control" id="customerEmail" name="customerEmail" placeholder="Enter email" required>
		</div>
		<div class="form-group">
			<label for="customerPassword">Password</label>
			<input type="password" class="form-control" id="customerPassword" name="customerPassword" placeholder="Password" required>
		</div>
		<div class="form-group">
			<label for="customerFirstName">First Name</label>
			<input type="text" class="form-control" id="customerFirstName" name="customerFirstName" placeholder="First Name" required>
		</div>
		<div class="form-group">
			<label for="customerLastName">last Name</label>
			<input type="text" class="form-control" id="customerLastName" name="customerLastName" placeholder="Last Name" required>
		</div>
		<div class="form-group">
			<label for="customerAddress">Address</label>
			<input type="text" class="form-control" id="customerAddress" name="customerAddress" placeholder="Address" required>
		</div>
		<div class="form-group">
			<label for="customerCity">City</label>
			<input type="text" class="form-control" id="customerCity" name="customerCity" placeholder="City" required>
		</div>
		<div class="form-group">
			<label for="customerState">State</label>
			<input type="text" class="form-control" id="customerState" name="customerState" placeholder="State" required>
		</div>
		<div class="form-group">
			<label for="customerZipcode">Zipcode</label>
			<input type="text" class="form-control" id="customerZipcode" name="customerZipcode" placeholder="Zipcode" required>
		</div>
		<div class="form-group">
			<label for="customerTelephone">Telephone</label>
			<input type="text" class="form-control" id="customerTelephone" name="customerTelephone" placeholder="Telephone number" required>
		</div>
		<div class="form-group">
			<label for="customerSSN">SSN</label>
			<input type="text" class="form-control" id="customerSSN" name="customerSSN" placeholder="XXX-XX-XXXX" required>
		</div>
		<div class="form-group">
			<label for="customerCreditCard">Credit Card Number</label>
			<input type="text" class="form-control" id="customerCreditCard" name="customerCreditCard" placeholder="XXXX-XXXX-XXXX-XXXX" required>
		</div>
		<div class="form-group">
			<label for="customerRating">Rating</label>
			<input type="text" class="form-control" id="customerRating" name="customerRating" placeholder="Rating" required>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<%@ include file="footer.jsp" %>