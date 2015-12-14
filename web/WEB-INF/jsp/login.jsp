<!DOCTYPE HTML>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Тотализатор - Вход</title>
    <!-- Подключение css-->
</head>
<body>
<DIV id="header">
    <H1>Тотализатор</H1>
</DIV>
<DIV id="page">
    <H2>Вход в систему</H2>
    <c:if test="${not empty message}">
        <H3 style="color: #733;">${message}</H3>
    </c:if>
    <c:url value="/login.html" var="loginUrl"/>
    <FORM action="${loginUrl}" method="post" >
        <INPUT type="text" id="login" name="login" value="${param.login}" maxlength="30" placeholder="Логин:">
        <br>
        <INPUT type="password" id="password" name="password" value="${param.password}" placeholder="Пароль:">
        <BUTTON type="submit">Войти</BUTTON>
    </FORM>
</DIV>
</body>
</html>
