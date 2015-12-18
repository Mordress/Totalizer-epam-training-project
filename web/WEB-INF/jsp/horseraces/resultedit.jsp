<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <TITLE>Тотализатор - редактирование результатов забега</TITLE>
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
    <table border="2">
        <tr>
            <th>Дата забега</th>
            <th>Дистанции (м)</th>
            <th>Имя лошади</th>
            <th>Место</th>
            <th>Время финиша</th>
        </tr>
        <tr>
            <td>${horseRace.race.raceDate}</td>
            <td>${horseRace.race.distance}</td>
            <td>${horseRace.horse.name}</td>
            <td>${horseRace.resultRank}</td>
            <td>${horseRace.resultTime}</td>
        </tr>

        <c:url value="/horseraces/resultsave.html" var="resultSaveUrl"/>
        <FORM action="${resultSaveUrl}" method="post">
            <INPUT type="hidden" name="horseRaceId" value="${horseRace.id}">
            <tr>
                <td colspan="3">
                    Введите результаты:
                </td>
                <td>
                    <input type="number" id="newRank" name="newRank"/>
                </td>
                <td>
                    <input type="datetime-local" id="newTime" name="newTime"/>
                    <input type="number" min="0" max="59" id="newTimeSeconds" name="newTimeSeconds" placeholder="сек."/>
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <button type="submit">Сохранить</button>
                    <button type="reset">Сбросить</button>
                </td>
            </tr>
        </form>

    </table>
</DIV>
<div id="jokey">
    <img src="/jokey.jpg" alt="Жокей" align="right">
</div>
</body>
</html>
