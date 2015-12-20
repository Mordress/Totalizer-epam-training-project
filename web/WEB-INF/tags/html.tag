<%@ tag import="java.util.Date" %>
<%@ tag import="com.gmail.mordress.lab4.utils.DateFormatConverter" %>
<!DOCTYPE html>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" rtexprvalue="true" type="java.lang.String"%>
<%@attribute name="message" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@attribute name="validator" required="false" rtexprvalue="true" type="java.lang.String"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Тотализатор - ${title}</title>
        <link rel="stylesheet" type="text/css" href="/styles.css" media="all">
        <%--<c:if test="${not empty message}">
            <SCRIPT type="text/javascript">
                startMessage = "${message}";
            </SCRIPT>
        </c:if>--%>
        <%--скрипты--%>
        <%--валидаторы--%>
    </head>
<body>
    <u:menu/>
    <c:if test="${not empty message}">
        <h3>${message}</h3>
    </c:if>
    <div id="page">
        <jsp:doBody/>
    </div>
</body>
</html>