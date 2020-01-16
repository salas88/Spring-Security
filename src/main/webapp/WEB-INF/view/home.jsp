<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head><title></title></head>

<body>
	<h2>Company Home Page</h2>
	
	Welcome to the company
	
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>