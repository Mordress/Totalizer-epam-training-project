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
    <H2>Список предыдущих ставок</H2>
        <table border="2">
            <tr>
                <th>Дата забега</th>
                <th>Дистанция (м)</th>
                <th>Имя лошади</th>
                <th>Место</th>
                <th>Время финиша</th>
                <th>Предполагаемое место</th>
                <th>Ставка</th>
                <th>Выигрыш</th>
                <th>Победила ли ставка?</th>
            </tr>
            <c:forEach items="${bets}" var="bet">
                <tr>
                    <td>${bet.horseRace.race.raceDate}</td>
                </tr>
            </c:forEach>

        </table>


</DIV>
Это страница ставок!
</body>
</html>
