<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<!--  <h3>Save Customer</h3>-->
	<div id = "content">
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		<!-- Need to associate the data with the given customer.This helps to keep track of Customer ID in database -->
		<form:hidden path = "id"/><!-- This is very important because it helps us update customer -->
			<table> <!-- setId gets called and helps to keep track as to which customer we are updating -->
				<tbody><!-- It is also passed us parameter to showFormForUpdate -->
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>
	
</div>	

</body>

</html>










