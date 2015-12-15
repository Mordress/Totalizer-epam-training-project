<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
  <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <TITLE>Тотализатор - редактирование результатов забега</TITLE>
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
    <%--<c:set var="id" value="${horseRace.id}"/>
    <c:set var="date" value="${horseRace.race.raceDate}"/>
    <c:set var="distance" value="${horseRace.race.distance}"/>
    <c:set var="horsename" value="${horseRace.horse.name}"/>
    <c:set var="resultRank" value="${hRhorseRaceace.resultRank}"/>
    <c:set var="resultTime" value="${hRhorseRaceace.resultTime}"/>--%>
    <table border="2">
        <tr>
            <th>empty</th>
            <th>Дата забега</th>
            <th>Дистанции (м)</th>
            <th>Имя лошади</th>
            <th>Место</th>
            <th>Время финиша</th>
        </tr>
        <tr>
            <td>Текущее значение</td>
            <td>${horseRace.race.raceDate}</td>
            <td>${horseRace.race.distance}</td>
            <td>${horseRace.horse.name}</td>
            <td>${horseRace.resultRank}</td>
            <td>${horseRace.resultTime}</td>
        </tr>
        <tr>
            <td>Новое значение</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
            <td>-</td>
        </tr>
    </table>
</DIV>
result edit page
</body>
</html>
