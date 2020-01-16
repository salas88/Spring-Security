<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
	<head><title>Page only for Admins</title></head>
	<body>
		<h2> Hello administrator - <security:authentication property="principal.username" /></h2>
	</body>
	
	<hr>
	
	<p>
		<a href="${pageContext.request.contextPath }/">Back</a>
	</p>
</html>