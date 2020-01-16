<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<htmL>
	<head>
		<title>Login Page</title>
	</head>
	
	<style>
		.failed {
			color: red;}
	</style>
	
	<body>
		<h2>Login Page</h2>
		
		<form:form action="${pageContext.request.contextPath}/autinicatedPage" method="POST">
		
		<c:if test="${param.error != null }">
			<i class="failed">Sorry! You entered invalid password/name!</i>
		</c:if>
		
		<p>
			User name: <input type="text" name="username" />
		</p>
		
		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login"/>
		
		</form:form>
	</body>
</htmL>