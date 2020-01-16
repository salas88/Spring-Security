<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
	<head><title>Only for Managers</title></head>
	
	<body>
		<h2>Hello manager - <security:authentication property="principal.username" /></h2>
	</body>
	
	<hr>
	
	<p>
		<a href="${pageContext.request.contextPath }/">Back</a>
	</p>
</html>