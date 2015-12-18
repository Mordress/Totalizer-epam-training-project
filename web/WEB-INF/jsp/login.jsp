<!DOCTYPE HTML>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Тотализатор - Вход</title>
    <link rel="stylesheet" type="text/css" href="/styles.css" media="all">
</head>
<body>
<div id="header">
    <H1>Тотализатор</H1>
</div>
<div id="page">
    <h2>Вход в систему</h2>
    <c:if test="${not empty message}">
        <h3 style="color: #fc0011;">${message}</h3>
    </c:if>
    <c:url value="/login.html" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
        <input type="text" id="login" name="login" value="${param.login}" maxlength="30" placeholder="Логин:">
        <br>
        <input type="password" id="password" name="password" value="${param.password}" placeholder="Пароль:">
        <br>
        <button type="submit">Войти</button>
    </form>
    <c:url value="/registration.html" var="registrationUrl"/>
    <form action="${registrationUrl}" method="post">
        <button type="submit">Регистрация</button>
    </form>
</div>
<div id="jokey">
    <img src="/jokey.jpg" alt="Жокей" align="right">
</div>
</body>
</html>
