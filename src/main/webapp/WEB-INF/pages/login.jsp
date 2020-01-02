<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <title>Login Page</title>

        <style>
            .failed {
              color: darkred;
              font-size: large;
            }
        </style>
    </head>
<body>
    <h3>My Login Page</h3>
    <form:form action="${pageContext.request.contextPath}/authenticate" method="post">
        <%-- Error message       --%>
        <c:if test="${param.error != null}">
            <p class="failed"><i>You entered invalid username/password!</i></p>
        </c:if>

        <%-- Logout message--%>
        <c:if test="${param.logout != null}">
            <p class="failed"><i>You have been logged out.</i></p>
        </c:if>

        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="username" placeholder="Enter your name">
       <br>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password" placeholder="Enter your password">
        </div>
        <input type="submit" value="Login">
    </form:form>

</body>
</html>
