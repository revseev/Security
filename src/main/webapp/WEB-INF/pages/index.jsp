<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
<head>
	<title>User Management Application</title>
</head>
<body>
	<center>
		<h1>Welcome to User Management Application</h1>
        <hr>
<%--        	<a href="/register">Register</a>--%>
            <a href="${pageContext.request.contextPath}/list">List of all users</a>
        </h2>
	</center>
    <footer>
        <c:import url="page_components/logout.jsp" />
    </footer>
</body>
</html>
