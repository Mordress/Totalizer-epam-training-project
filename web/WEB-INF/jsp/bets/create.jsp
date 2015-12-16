<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Тотализатор - сделать ставку</title>
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
  <h2>Создать ставку</h2>
  <form action="" method="post">
      <select size = "3" multiple name = "name[]">
        <option disabled>Какие имена вам нравятся?</option>
        <option selected value = "Никакие">Никакие</option>
        <option value = "Иван">Иван</option>
        <option value = "Петр">Петр</option>
        <option value = "Николай">Николай</option>
      </select>
      <input type = "submit" value = "Ответить">
  </form>
</div>
<div id="jokey">
  <img src="/footer.jpg" alt="Жокей" align="right">
</div>
</body>
</html>
