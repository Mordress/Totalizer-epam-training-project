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
    <c:url value="/horseraces/resultedit.html" var="resultEditUrl"/>
    <table border="2">
        <tr>
            <th>Дата забега</th>
            <th>Дистанции (м)</th>
            <th>Имя лошади</th>
            <th>Место</th>
            <th>Время финиша</th>
            <th>Изменить результат</th>
        </tr>
            <c:forEach items="${horseRaces}" var="hRace">
                <c:set var="id" value="${hRace.id}"/>
                <c:set var="date" value="${hRace.race.raceDate}"/>
                <c:set var="distance" value="${hRace.race.distance}"/>
                <c:set var="horsename" value="${hRace.horse.name}"/>
                <c:set var="resultRank" value="${hRace.resultRank}"/>
                <c:set var="resultTime" value="${hRace.resultTime}"/>
                <tr>
                    <td>${date}</td>
                    <td>${distance}</td>
                    <td>${horsename}</td>
                    <td>${resultRank}</td>
                    <td>${resultTime}</td>
                    <td>
                        <FORM action="${resultEditUrl}" method="post">
                            <INPUT type="hidden" name="id" value="${hRace.id}">
                            <BUTTON type="submit">Изменить результат</BUTTON>
                        </FORM>
                    </td>
                </tr>
            </c:forEach>
    </table>
</DIV>
It's horseraces edit page!
</body>
</html>
