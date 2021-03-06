<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>

    <!-- reference our style sheet -->

   <%-- <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />--%>
</head>
<body>
	<center>
        <div id="wrapper">
            <div id="header">
		<h1>User Management</h1>
        <h2>
        	<a href="/new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/">Back to starting page</a>
        	
        </h2>
            </div>
        </div>
	</center>
    <div align="center">
        <table border="1" cellpadding="10">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Password</th>
                <th>Money</th>
                <th>Role(s)</th>
                <th >Actions</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.password}" /></td>
                    <td><c:out value="${user.money}" /></td>
                    <td><c:forEach var="role" items="${user.roles}">
                            <c:out value="${role.type}" />
                        </c:forEach>
                    <td>
                        <a href="/edit?id=<c:out value='${user.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="/delete?id=<c:out value='${user.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <footer>
        <c:import url="page_components/logout.jsp" />
    </footer>
</body>
</html>
