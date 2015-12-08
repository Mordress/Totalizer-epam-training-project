<!DOCTYPE HTML>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
  <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <TITLE>Библиотека - Вход в систему</TITLE>
  <c:url value="/main.css" var="cssUrl"/>
  <LINK rel="stylesheet" type="text/css" href="${cssUrl}">
</HEAD>
<BODY>
<DIV id="header">
  <H1>Библиотека<BR>«Книжный червь»</H1>
</DIV>
<DIV id="page">
  <H2>Вход в систему</H2>
  <c:if test="${not empty message}">
    <H3 style="color: #733;">${message}</H3>
  </c:if>
  <c:url value="/login.html" var="loginUrl"/>
  <FORM action="${loginUrl}" method="post">
    <LABEL for="login">Имя пользователя:</LABEL>
    <INPUT type="text" id="login" name="login" value="${param.login}">
    <LABEL for="password">Пароль:</LABEL>
    <INPUT type="password" id="password" name="password">
    <BUTTON type="submit">Войти</BUTTON>
  </FORM>
</DIV>
</BODY>
</HTML>
