<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Restricted area</title>

    <style>
        .failed {
            color: darkred;
            font-size: x-large;
            font-style: italic;
        }
    </style>
</head>
<body>
        <center>
             <p class="failed">You are not authorised to view this resource!</p>
            <br>
            <a href="${pageContext.request.contextPath}/">Back to starting page</a>
        </center>

    <footer>
        <c:import url="page_components/logout.jsp" />
    </footer>
</body>
</html>