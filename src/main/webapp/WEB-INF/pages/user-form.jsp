<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>
</head>
<body>
	<center>
		<h1>User Management</h1>
        <h2>
        	<a href="/admin/new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="/admin/list">List All Users</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${user != null}">
			<form action="/admin/update" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="/admin/insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${user != null}">
            			Edit User
            		</c:if>
            		<c:if test="${user == null}">
            			Add New User
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${user != null}">
        			<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
        		</c:if>            
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
			<th>Role: </th>
                <td>
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
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
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