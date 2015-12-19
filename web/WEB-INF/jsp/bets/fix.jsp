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
<div id="page">
  <table>
      <tr>
          <th>Дата забега</th>
          <th>Дистанция</th>
          <th>Имя лошади</th>
          <th>Факт. место</th>
          <th>Предп. место</th>
          <th>Ставка($)</th>
          <th>Выигрыш($)</th>
          <th>Победа ставки</th>
          <th>Дата создания ставки</th>
          <th>Установить результат</th>
      </tr>
      <c:if test="${not empty nofixbets}">
          <c:forEach items="${nofixbets}" var="bet">
              <tr>
                  <form action="" method="post">
                      <input type="hidden" name="betId" value="${bet.id}">
                      <td>${bet.horseRace.race.raceDate}</td>
                      <td>${bet.horseRace.race.distance}</td>
                      <td>${bet.horseRace.horse.name}</td>
                      <td>${bet.horseRace.resultRank}</td>
                      <td>${bet.resultRank}</td>
                      <td>${bet.betAmount}</td>
                      <td>
                          <input type="number" min="${bet.betAmount}" id="winamount" name="winamount" placeholder="$">
                      </td>
                      <td>
                          <select name="iswinner">
                              <option selected value = "empty">не выбрано</option>
                                  <option value = "yes">Да</option>
                                  <option value = "no">Нет</option>
                          </select>
                      </td>
                      <td>${bet.createdDate}</td>
                      <td>
                          <BUTTON type="submit">Установить</BUTTON>
                      </td>
                  </form>
              </tr>
          </c:forEach>
      </c:if>
  </table>
</div>
it's page for bets fixing
</body>
</html>
