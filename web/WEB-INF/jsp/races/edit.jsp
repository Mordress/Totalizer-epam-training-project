<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:choose>
    <c:when test="${not empty race}">
        <c:set var="date" value="${race.raceDate}"/>
        <c:set var="distance" value="${race.distance}"/>
    </c:when>

</c:choose>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <TITLE>Результаты забега</TITLE>
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
    <table border="2">
        <tr>
            <th>Дата забега</th>
            <th>Длина дистанции (м)</th>
            <th>Имя лошади</th>
            <th>Место</th>
            <th>Время финиша</th>
        </tr>
            <c:set var="id" value="${horseRace0.id}"/>
            <c:set var="date" value="${horseRace0.race.raceDate}"/>
            <c:set var="distance" value="${horseRace0.race.distance}"/>
            <c:set var="horsename" value="${horseRace0.horse.name}"/>
            <c:set var="resultRank" value="${horseRace0.resultRank}"/>
            <c:set var="resultTime" value="${horseRace0.resultTime}"/>
            <tr>
                <td>${date}</td>
                <td>${distance}</td>
                <td>${horsename}</td>
                <td>${resultRank}</td>
                <td>${resultTime}</td>
            </tr>
    </table>
</DIV>
It's races edit page!
</body>
</html>
