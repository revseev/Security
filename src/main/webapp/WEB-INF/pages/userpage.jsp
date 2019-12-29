<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Management Application</title>
</head>
<body>
    <center>
        <h1>Personal page</h1>
        <h2>
            <a href="/">Back to starting page</a>
        </h2>
        <h3>
            ${message}
        </h3>
    </center>
<div align="center">
    <h3><p>Welcome back ${user.name}!</p></h3>
    <p>You have ${user.money}$.</p>
</div>
<footer>
    <p>Your role is: ${sessionScope['role']}</p>
</footer>
</body>
</html>
