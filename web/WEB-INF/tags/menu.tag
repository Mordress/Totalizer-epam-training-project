<%@tag language="java" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header">
    <div id="logo">
        <img src="/jokey.png" alt="jokey" align="left">
    </div>
    <c:if test="${not empty authorizedUser}">
        <ul class="right">
        <c:forEach items="${menu}" var="item">
            <c:url value="${item.url}" var="itemUrl"/>
            <li class="item"><A href="${itemUrl}">${item.name}</A></li>
        </c:forEach>
        <c:url value="/profile/edit.html" var="profileEditUrl"/>
        <li class="item"><A href="${profileEditUrl}">профиль</A></li>
        <c:url value="/logout.html" var="logoutUrl"/>
        <li class="item"><A href="${logoutUrl}">выход</A></li>
        </ul>
    </c:if>
</div>
