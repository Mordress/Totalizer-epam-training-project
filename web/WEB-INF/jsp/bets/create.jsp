<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Тотализатор - создание ставки</title>
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

  <h1>Текущий баланс: ${cash}$</h1>
  <h2>Введите данные ставки</h2>
  <br>
  <form action="" method="post">
      <select name="chosenRace">
          <option selected value = "emptyRace">Выберите дату и время забега</option>
          <c:forEach items="${futureRaces}" var="fRace">
            <option value = "${fRace}">${fRace.raceDate}</option>
        </c:forEach>
      </select>
      <select name="chosenHorse">
          <option selected value = "emptyHorse">Выберите лошадь</option>
          <c:forEach items="${allHorses}" var="horse">
              <option value = "${horse}">${horse.name}</option>
          </c:forEach>
      </select>
      <input type="number" min="10" max="${cash}" id="betAmount" name="betAmount" placeholder="Размер ставки"/>
      <input type="number" min="1" max="${horseCount}" id="rank" name="rank" placeholder="Предполагаемое место"/>
      <button type="submit">Создать ставку</button>
      <button type="reset">Сбросить</button>
  </form>
  <br>
  <br>
  <br>
  <h3>Доступные лошади</h3>
  <table>
      <tr>
          <th>Имя</th>
          <th>Порода</th>
          <th>Возраст (лет)</th>
          <th>Вес (кг)</th>
      </tr>
      <c:forEach items="${allHorses}" var="horse">
          <tr>
            <td>${horse.name}</td>
            <td>${horse.breed.name}</td>
            <td>${horse.age}</td>
            <td>${horse.weight}</td>
          </tr>
      </c:forEach>
  </table>
</div>
<div id="jokey">
  <img src="/footer.jpg" alt="Жокей" align="right">
</div>
</body>
</html>
