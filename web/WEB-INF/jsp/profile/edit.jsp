<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
  <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <TITLE>Тотализатор - результаты забега</TITLE>
  <link rel="stylesheet" type="text/css" href="/styles.css" media="all">
</head>
<body>
<DIV id="header">
  <H1>Тотализатор</H1>
  <UL class="right">
    <c:forEach items="${menu}" var="item">
      <c:url value="${item.url}" var="itemUrl"/>
      <LI class="item"><A href="${itemUrl}">${item.name}</A></LI>
    </c:forEach>
    <c:url value="/profile/edit.html" var="profileEditUrl"/>
    <LI class="item"><A href="${profileEditUrl}">${authorizedUser.login}</A></LI>
    <c:url value="/logout.html" var="logoutUrl"/>
    <LI class="item"><A href="${logoutUrl}">выход</A></LI>
  </UL>
</DIV>
<DIV id="page">
  <H2>Профиль пользователя «${authorizedUser.login}»</H2>
  <c:if test="${not empty message}"><H4>${message}</H4></c:if>
  <c:url value="/profile/save.html" var="profileSaveUrl"/>
  <FORM action="${profileSaveUrl}" method="post">
    <LABEL for="login">Имя пользователя:</LABEL>
    <INPUT type="text" id="login" value="${authorizedUser.login}" disabled>
    <LABEL for="role">Роль:</LABEL>
    <SELECT id="role" disabled>
      <OPTION selected>${authorizedUser.role.name}</OPTION>
    </SELECT>
    <LABEL for="old-password">Старый пароль:</LABEL>
    <INPUT type="password" id="old-password" name="old-password">
    <LABEL for="new-password">Новый пароль:</LABEL>
    <INPUT type="password" id="new-password" name="new-password">
     <LABEL for="confirm-password">Подтвердить новый пароль:</LABEL>
     <INPUT type="password" id="confirm-password" name="confirm-password">
    <BUTTON type="submit">Сменить пароль</BUTTON>
    <BUTTON type="reset">Сбросить</BUTTON>
  </FORM>
</DIV>
</body>
</html>
