<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<table>
    <caption>
        <h3>Your info</h3>
    </caption>
    <tr>
        <th>Name: </th>
        <td>
            <security:authentication property="principal.username"/>
        </td>
    </tr>
    <tr>
        <th>Role(s): </th>
        <td>
            <security:authentication property="principal.authorities"/>
        </td>
    </tr>
    <tr>
        <td>
            <form:form action="${pageContext.request.contextPath}/logout" method="post">
                <input type="submit" value="Logout">
            </form:form>
        </td>
    </tr>
</table>



