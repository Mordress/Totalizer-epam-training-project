<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Тотализатор - Ставки</title>
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
    <H2>Cтавки</H2>
        <table border="2">
            <tr>
                <th>Дата забега</th>
                <th>Дистанция (м)</th>
                <th>Имя лошади</th>
                <th>Место</th>
                <th>Время финиша</th>
                <th>Предполагаемое место</th>
                <th>Размер ставки</th>
                <th>Размер выигрыша</th>
                <th>Победа</th>
            </tr>
            <c:if test="${not empty bets}">
                <c:forEach items="${bets}" var="bet">
                    <tr>
                        <td>${bet.horseRace.race.raceDate}</td>
                        <td>${bet.horseRace.race.distance}</td>
                        <td>${bet.horseRace.horse.name}</td>
                        <td>${bet.horseRace.resultRank}</td>
                        <td>${bet.horseRace.resultTime}</td>
                        <td>${bet.resultRank}</td>
                        <td>${bet.betAmount}</td>
                        <td>${bet.winAmount}</td>
                        <c:choose>
                            <c:when test="${not empty bet.winAmount}">
                                <td>${bet.isWinner}</td>
                            </c:when>
                            <c:when test="${empty bet.winAmount}">
                                <td></td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    <c:url value="/bets/create.html" var="betsCreateUrl"/>
    <FORM action="${betsCreateUrl}" method="post">
        <BUTTON type="submit">Сделать ставку</BUTTON>
    </FORM>
</DIV>
<div id="jokey">
    <img src="/footer.jpg" alt="Жокей" align="right">
</div>
</body>
</html>
