<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Save Bike Ad</title>
		
		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
			
			<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/bikeAdverts-form-style.css">
	</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>BIKE AD FORM</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Bike Ad</h3>
		
		<form:form action="saveBikeAd" modelAttribute="BikeAdvert" method="POST">
		
		<!-- need to associate this data with BikeAdvert Id -->
			<form:hidden path="id"/>
			<table>
				<body>
					<tr>
						<td>Company Name:</td>
						<td><form:input path="companyName"/></td>
					</tr>
					<tr>
						<td>Model Name:</td>
						<td><form:input path="modelName"/></td>
					</tr>
					<tr>
						<td>Cylinder:</td>
						<td><form:input path="cylinder"/></td>
					</tr>
					
					<tr>
						<td>Build Year:</td>
						<td><form:input path="buildYear"/></td>
					</tr>
					<tr>
						<td>Kilometers:</td>
						<td><form:input path="kms"/></td>
					</tr>
					<tr>
						<td>Price:</td>
						<td><form:input path="price"/></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</body>
			</table>
			
			
			
		</form:form>
		<div style="clear;both";></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/BikeAdverts/list">Back to list</a>
		</p>
	</div>
	
</body>
</html>
