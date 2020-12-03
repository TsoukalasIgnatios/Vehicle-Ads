<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
 <title>List of Bikes</title>
 <link type="text/css"
 		rel="stylesheet"
 		href="${pageContext.request.contextPath}/resources/css/style.css "/>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Bike Advertisement Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
		
			<input type="button" value="add BikeAdvert"
					onclick="window.location.href='showFormForAdd';return false;"
					class="add-button"/>
			<form:form action="search" modelAttribute="BikeAdverts" method="GET">
			Insert company name:
			<input type="text" name="theCompanyName"/>
			<input type="submit" value="search" class="add-button"/>
			</form:form>
		 	<table>
				<tr>
					<th>Company name</th>
					<th>Model name</th>
					<th>Cylinder</th>
					<th>Build Year</th>
					<th>Kilometers</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<!-- loop over and print our BikeAds -->
			  	<c:forEach var="tempBikeAdvert" items="${bikeAdverts}">
				 <!-- construct an "update" link with BikeAdvert id -->
				<c:url var="updateLink" value="/BikeAdverts/showFormForUpdate">
					<c:param name="BikeAdvertId" value="${tempBikeAdvert.id}"></c:param>
				</c:url>
				<!-- construct an "delete" link with BikeAdvert id -->
				<c:url var="deleteLink" value="/BikeAdverts/delete">
					<c:param name="BikeAdvertId" value="${tempBikeAdvert.id}"></c:param>
				</c:url>
				
				<tr>
					<td>${tempBikeAdvert.companyName}</td>
					<td>${tempBikeAdvert.modelName}</td>
					<td>${tempBikeAdvert.cylinder}</td>
					<td>${tempBikeAdvert.buildYear}</td>
					<td>${tempBikeAdvert.kms}</td>
					<td>${tempBikeAdvert.price}</td>
					
					<td>
					<a href="${updateLink}">Update</a>|<a href="${deleteLink}"
					onclick="if(!(confirm('Are you sure you want to delete this BikeAd?'))) return false">Delete</a>
					</td>
				</tr>

			  	</c:forEach> 
			</table>

		</div>
	</div>
</body>
</html>