<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<html>

<head>

	<title>login</title>
	<style>
		.failed{color: red;}
	</style>
</head>
<body>

<h2>My login page </h2>
<!-- /authenticateTheUser komt van de DemoSecurityConfig class -->
	<form:form action="${pageContext.request.contextPath }/authenticateTheUser" methid="POST">
		
		<c:if test="${param.error!=null }">
			<i class="failed">Sorry invlaid username/password</i>
		</c:if>
	<p>
	User Name: <input type="text" name="username"/>
	</p>
	
	<p>
	password: <input type="password" name="password"/>
	</p>
	
	<input type="submit" value="Login"/>
	</form:form>

</body>
</html>