<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>this is SpringMVC demo page11</h2>

<c:forEach items="${users}" var="user">
    <c:out value="${user.username}"/><br>
    <c:out value="${user.age}"/><br>
</c:forEach>