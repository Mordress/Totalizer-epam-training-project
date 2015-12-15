<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <TITLE>Тотализатор - создание нового забега</TITLE>
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
    <c:url value="/races/save.html" var="racesSaveUrl"/>
    <FORM action="${racesSaveUrl}" method="post" >
        <label for="date">Введите дату и время будущего забега</label>
        <INPUT type="datetime-local" id="date" name="date">
        <br>
        <label for="distance">Введите длину дистанции</label>
        <INPUT type="number" id="distance" name="distance">
        <br>
        <BUTTON type="submit">Сохранить</BUTTON>
        <BUTTON type="reset">Сбросить</BUTTON>
    </FORM>
</DIV>
it's race create page!
</body>
</html>
