<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
	<jsp:include page="header.jsp" />
<body>
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
		<h1>All Users</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>framework</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="users">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>
							<c:forEach items="${user.framework}" var="framework" varStatus="loop">
								${framework}
								<c:if test="${not loop.last}">
									,
								</c:if>
							</c:forEach>
						</td>
						<spring:url value="/users/${user.id}" var="userUrl"/>
						<spring:url value="/users/${user.id}/delete" var="deleteUrl"/>
						<spring:url value="/users/${user.id}/update" var="updateUrl"/>
						<td>
							<button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
							<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
							<button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>