<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div class="container">
	<hr>
	<footer>
		<p>&copy; Sudarshan Reddy 2015</p>
	</footer>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js" type="text/javascript"></script>

<spring:url value="/resources/js/hello.js" var="coreJs" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>