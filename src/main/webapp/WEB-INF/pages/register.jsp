<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>
</head>
<body>
	<center>
		<h1>Registration</h1>
        <h2>
        	<a href="/">Back to starting page</a>
		</h2>
	</center>
    <div align="center">
		<form action="/register" method="post">
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		Enter your information to sign up
            	</h2>
            </caption> 
            <tr>
                <th>User Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${user.name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>User Password: </th>
                <td>
                	<input type="text" name="password" size="45"
                			value="<c:out value='${user.password}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Money: </th>
                <td>
                	<input type="number" name="money" size="15" min="1"
                			value="<c:out value='${user.money}' />"
                	/>
				</td>
				<tr>
				</tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Register" />
            	</td>
            </tr>
        </table>
        </form>
    </div>
	<footer>
		<p>Your role is: ${sessionScope['role']}</p>
	</footer>
</body>
</html>
