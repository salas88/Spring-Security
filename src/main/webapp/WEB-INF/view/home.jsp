<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head><title></title></head>

<body>
	<h2>Company Home Page</h2>
	
	Welcome to the company
	<hr>
		<!-- Display user name and role -->
		
		Use: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	<hr>
	
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>