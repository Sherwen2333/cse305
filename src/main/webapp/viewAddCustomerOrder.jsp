<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<div class="container">
    <h2>Add order</h2>

	<form action="addOrder" method="POST">
	  <div class="form-group">
	    <label for="orderType">Order Type</label>
		  <select name="orderType" id="orderType" class="form-control">
			  <option selected>Market</option>
			  <option>MarketOnClose</option>
			  <option>TrailingStop</option>
			  <option>HiddenStop</option>
		  </select>
	  </div>
        <div class="form-group">
            <label for="customerId">Customer:</label>
            <select class="form-control" name="customerId">
                <c:forEach items="${customers}" var="cd">
                    <option value="${cd.id}"> <c:out value = "${cd.firstName} ${cd.lastName}"/></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="stockSymbol">Stock Symbol:</label>
            <select class="form-control" name="stockSymbol">
                <c:forEach items="${stocks}" var="cd">
                    <option value="${cd.symbol}"> <c:out value = "${cd.symbol}"/></option>
                </c:forEach>
            </select>
        </div>
        <div id='orderNumShares-group' class="form-group">
            <label for="orderNumShares">Number of Shares</label>
            <input type="number" class="form-control" id="orderNumShares" name="orderNumShares" required>
        </div>
        <div id='orderPercentage-group' class="form-group d-none">
            <label for="orderPercentage">Percentage</label>
            <input type="number" class="form-control" id="orderPercentage" name="orderPercentage" >
        </div>
        <div id="orderPricePerShare-group" class="form-group d-none">
            <label for="orderPricePerShare">Price per share</label>
            <input type="number" class="form-control" id="orderPricePerShare" name="orderPricePerShare">
        </div>
        <div id="orderBuySellType-group" class="form-group">
            <label for="orderBuySellType">Buy/Sell</label>
            <select id="orderBuySellType" name="orderBuySellType" class="form-control">
                <option>Buy</option>
                <option>Sell</option>
            </select>
        </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>

<script>

    $('#orderType').on('change', function(){
        console.log(this.value);
        if (this.value == "Market" || this.value == "MarketOnClose")
        {
            $('#orderBuySellType-group').removeClass('d-none');
            $('#orderPricePerShare-group').addClass('d-none');
            $('#orderPercentage-group').addClass('d-none');
        }
        else if (this.value == "HiddenStop")
        {
            $('#orderPricePerShare-group').removeClass('d-none');
            $('#orderPercentage-group').addClass('d-none');
            $('#orderBuySellType-group').addClass('d-none');
        }
        else if (this.value == "TrailingStop")
        {
            $('#orderPercentage-group').removeClass('d-none');
            $('#orderPricePerShare-group').addClass('d-none');
            $('#orderBuySellType-group').addClass('d-none');
        }
    })
</script>
<%@ include file="footer.jsp" %>
