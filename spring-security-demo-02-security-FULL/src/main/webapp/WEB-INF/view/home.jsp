<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>

<title>HELLO</title>
</head>
<body>
	<h2>Welcome yohoo</h2>
	<hr>
	<!-- Display user name and role -->
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Roles:
		<security:authentication property="principal.authorities" />
	</p>
	<hr>
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				only for managers</a>
		</p>

	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">

		<p>
			<a href="${pageContext.request.contextPath}/systems">systems,
				only for admin</a>
		</p>
	</security:authorize>
	<hr>


	<form:form action="${pageContext.request.contextPath }/logout"
		methid="POST">
		<input type="submit" value="logout" />
	</form:form>
</body>
</html>