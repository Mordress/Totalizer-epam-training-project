<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Тотализатор - забеги</title>
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
    <H2>Список прошлых забегов</H2>
    <c:if test="${not empty message}"><H3>${message}</H3></c:if>
    <TABLE border="2">
        <TR>
            <TH>Дата забега</TH>
            <TH>Дистанция (м)</TH>
            <TH>Результаты</TH>
        </TR>
        <c:url value="/horseraces/edit.html" var="horseRacesEditUrl"/>
        <c:forEach items="${passedRaces}" var="pRace">
            <TR align="center">
                <TD>${pRace.raceDate}</TD>
                <TD>${pRace.distance}</TD>
                <TD>
                    <FORM action="${horseRacesEditUrl}" method="post">
                        <INPUT type="hidden" name="id" value="${pRace.id}">
                        <BUTTON type="submit">Результаты</BUTTON>
                    </FORM>
                </TD>
            </TR>
        </c:forEach>
    </TABLE>

    <H2>Список будущих забегов</H2>
    <c:if test="${not empty message}"><H3>${message}</H3></c:if>
    <TABLE border="2">
        <TR>
            <TH>Дата забега</TH>
            <TH>Дистанция</TH>

        </TR>
        <c:forEach items="${futureRaces}" var="fRace">
            <TR align="center">
                <TD>${fRace.raceDate}</TD>
                <TD>${fRace.distance} м.</TD>
            </TR>
        </c:forEach>
    </TABLE>
    <br>
    <%--прикрутить кнопку добавления нового забега--%>
    <c:url value="/races/edit.html" var="raceEditUrl"/>
    <FORM action="${raceEditUrl}" method="post">
        <BUTTON type="submit">Добавить забег</BUTTON>
    </FORM>
</DIV>
</body>
</html>
