<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>
</head>
<body>
	<center>
		<h1>Welcome to User Management Application</h1>
        <h2>
<%--        	<a href="/register">Register</a>--%>
            <a href="/list">/list</a>
        </h2>
	</center>
 <%--   <div align="center">
        ${message}
    </div>

    <div align="center">
        <form action="/" method="post">

        <table border="1" cellpadding="5">
            <caption>
            	<h3>Enter your information to sign in</h3>
            </caption>
            <tr>
                <th>Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${user.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                	<input type="text" name="password" size="45"
                			value="<c:out value='${user.password}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Sign In">
            	</td>
            </tr>
        </table>
        </form>
    </div>
    <footer>
        <p>Your role is: ${sessionScope['role']}</p>
    </footer>--%>
</body>
</html>
