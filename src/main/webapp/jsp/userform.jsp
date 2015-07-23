<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="container">
		<c:choose>
			<c:when test="${userForm['new'] }">
				<h1>Add User</h1>
			</c:when>
			<c:otherwise>
				<h1>Update User</h1>
			</c:otherwise>
		</c:choose>
		<br/>
		
		<spring:url value="/uers" var="userActionUrl"/>
		
		<form:form class="form-horizontal" action="${userActionUrl}" method="POST" modelAttribute="userForm">
			<form:hidden path="id"/>
			
			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10">
						<form:input path="name" cssClass="form-control" id="name" />
						<form:errors path="name" cssClass="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<form:input path="email" cssClass="form-control" id="email" />
						<form:errors path="email" cssClass="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			
			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<form:password path="password" cssClass="form-control" id="password" />
						<form:errors path="password" cssClass="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			
			<spring:bind path="confirmPassword">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">Confirm Password</label>
					<div class="col-sm-10">
						<form:password path="confirmPassword" cssClass="form-control" id="confirmPassword" />
						<form:errors path="confirmPassword" cssClass="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			
			<spring:bind path="address">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">Address</label>
					<div class="col-sm-10">
						<form:input path="address" cssClass="form-control" id="address" />
						<form:errors path="address" cssClass="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			<spring:bind path="newsletter">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">NewsLetter</label>
					<div class="col-sm-10">
						<div class="checkbox">
							<label><form:checkbox path="newsletter" id="newsletter" /></label>
							<form:errors path="newsletter" cssClass="control-label"/>
						</div>
					</div>
				</div>
			</spring:bind>
			
			
			<spring:bind path="framework">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">Web Frameworks</label>
					<div class="col-sm-10">
						<form:checkboxes items="frameworkList" path="framework" element="label class='checkbox-inline'"/>
						<br/>
						<form:errors path="framework" cssClass="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			<spring:bind path="sex">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">Sex</label>
					<div class="col-sm-10">
						<label class="radio-inline">
							<form:radiobutton path="sex" value="M"/>Male
						</label>
						<label class="radio-inline">
							<form:radiobutton path="sex" value="F"/>Female
						</label>
						<br/>
						<form:errors path="sex" cssClass="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			
			<spring:bind path="number">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">Number</label>
					<div class="col-sm-10">
						<form:radiobuttons path="number" items="${numberList}" element="label class='radio-inline'"/>
						<br/>
						<form:errors path="number" cssClass="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			
			<spring:bind path="country">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">Country</label>
					<div class="col-sm-5">
						<form:select path="country" cssClass="form-control">
							<form:option value="NONE" label="---SELECT---"></form:option>
							<form:options items="${countryList}"/>
						</form:select>
						<form:errors path="country" cssClass="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			<spring:bind path="skill">
				<div class="form-group ${status.error ? 'has-error':''}">
					<label class="col-sm-2 control-label">Java Sills</label>
					<div class="col-sm-5">
						<form:select path="skill" items="${javaSkillList}" multiple="true" size="5" cssClass="form-control"/>
						<form:errors path="skill" cssClass="control-label"/>
					</div>
				</div>
			</spring:bind>
			
			
			<div class="form-group">
		  		<div class="col-sm-offset-2 col-sm-10">
					<c:choose>
			  			<c:when test="${userForm['new']}">
			     			<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
			  			</c:when>
			 			<c:otherwise>
			     			<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
			  			</c:otherwise>
					</c:choose>
		  		</div>
			</div>
		
		</form:form>
	</div>
	
	<jsp:include page="footer.jsp" />
</body>
</html>