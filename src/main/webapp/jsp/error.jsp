<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="container">
		<h1>Error Page</h1>
		
		<p>${exception.message}</p>
	</div>
	
	<jsp:include page="footer.jsp" />
</body>
</html>