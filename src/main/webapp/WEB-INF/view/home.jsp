<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head><title></title></head>

<body>
	<h2>Company Home Page</h2>
	<hr>
	Welcome to the company
	<hr>
		<!-- Display user name and role -->
		
		Use: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	<hr>
	
	<p>
		<a href="${pageContext.request.contextPath }/leaders">campaign orders</a>
		(Only for Managers)
	</p>
	
	<hr>
		<p>
		<a href="${pageContext.request.contextPath }/admins">status orders</a>
		(Only for Admins)
	</p>
	
	<hr>
	
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>