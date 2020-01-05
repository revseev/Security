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
					<h2> Save User </h2>
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
				</tr>
					<th>Role: </th>
					<td>
                        	<form:select path="roles" items="${allRoles}" itemValue="id" itemLabel="type" />
					</td>
<%--				itemValue="type" itemLabel="type"--%>
			<%--<td>
						<c:if test="${user != null}">
							<c:if test="${user.role == 'user'}">
								user <input type="radio" name="role" value="user" checked>
								admin <input type="radio" name="role" value="admin">
							</c:if>
							<c:if test="${user.role == 'admin'}">
								user <input type="radio" name="role" value="user">
								admin <input type="radio" name="role" value="admin" checked>
							</c:if>
						</c:if>
						<c:if test="${user == null}">
							user <input type="radio" name="role" value="user" checked>
							admin <input type="radio" name="role" value="admin">
						</c:if>
					</td>--%>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Save" />
					</td>
				</tr>
			</table>
		</form:form>

<%--        		<c:if test="${user != null}">--%>
<%--        			<input type="hidden" name="id" value="<c:out value='${user.id}' />" />--%>
<%--        		</c:if>            --%>

        </form>
    </div>
	<footer>
		<p>Your role is: ${sessionScope['role']}</p>
	</footer>
</body>
</html>
