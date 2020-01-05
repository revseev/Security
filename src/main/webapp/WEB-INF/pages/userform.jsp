<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>User Management Application</title>
</head>
<body>

	<center>
		<h1>User Management</h1>
        <h2>
        	<a href="/new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="/list">List All Users</a>
        </h2>
	</center>

    <div align="center">
		<form:form action="/save" modelAttribute="user" method="post">
			<form:hidden path="id" />

			<table border="1" cellpadding="5">
				<caption>
					<h2>
						<c:choose>
							<c:when test="${edit}">Edit User <c:out value="${user.username}" /></c:when>
							<c:otherwise>New User</c:otherwise>
						</c:choose>
					</h2>
				</caption>
				<tr>
					<th>User Name: </th>
					<td>
						<form:input path="username" size="45" />
					</td>
				</tr>
				<tr>
					<th>User Password: </th>
					<td>
						<form:input path="password" size="45" />
					</td>
				</tr>
				<tr>
					<th>Money: </th>
					<td>
						<form:input path="money" type="number" size="45" />
					</td>
				<tr>
					<th>Role: </th>
					<td>
                        	<form:select path="roles" items="${allRoles}" itemValue="id" itemLabel="type" />
					</td>
				<tr>
					<td colspan="2" align="center">
						<c:choose>
							<c:when test="${edit}">
								<input type="submit" value="Update" /> or <a href="<c:url value='/list' />">Cancel</a>
							</c:when>
							<c:otherwise>
								<input type="submit" value="Register" /> or <a href="<c:url value='/list' />">Cancel</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</form:form>
    </div>

	<footer>
		<p>Your role is: ${sessionScope['role']}</p>
	</footer>
</body>
</html>
