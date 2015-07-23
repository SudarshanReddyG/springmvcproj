<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="container">
		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" 
                                aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>
		<h1>User Detail</h1>
		<br/>
		<div class="row">
			<label class="col-sm-2">ID</label>
			<div class="col-sm-10">${user.id}</div>
		</div>
 
		<div class="row">
			<label class="col-sm-2">Name</label>
			<div class="col-sm-10">${user.name}</div>
		</div>
	 
		<div class="row">
			<label class="col-sm-2">Email</label>
			<div class="col-sm-10">${user.email}</div>
		</div>
	 
		<div class="row">
			<label class="col-sm-2">Address</label>
			<div class="col-sm-10">${user.address}</div>
		</div>
	 
		<div class="row">
			<label class="col-sm-2">Newsletter</label>
			<div class="col-sm-10">${user.newsletter}</div>
		</div>
	 
		<div class="row">
			<label class="col-sm-2">Web Frameworks</label>
			<div class="col-sm-10">${user.framework}</div>
		</div>
	 
		<div class="row">
			<label class="col-sm-2">Sex</label>
			<div class="col-sm-10">${user.sex}</div>
		</div>
	 
		<div class="row">
			<label class="col-sm-2">Number</label>
			<div class="col-sm-10">${user.number}</div>
		</div>
	 
		<div class="row">
			<label class="col-sm-2">Country</label>
			<div class="col-sm-10">${user.country}</div>
		</div>
	 
		<div class="row">
			<label class="col-sm-2">Skill</label>
			<div class="col-sm-10">${user.skill}</div>
		</div>
		
	</div>
	
	<jsp:include page="footer.jsp" />
</body>
</html>