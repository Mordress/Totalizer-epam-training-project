<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<HTML>
	<HEAD>
		<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<TITLE>Строительные материалы. Интернет-магазин</TITLE>

		<c:url value="/WEB-INF/style.css" var="styleUrl"/>
		<LINK rel="stylesheet" type="text/css" href="${styleUrl}">
	</HEAD>
	<BODY>
		<TABLE id="main">
			<TR>
				<TD align="center">
					<c:choose>
						<c:when test="${empty error}">
							<H1>вход в систему</H1>
						</c:when>
						<c:otherwise>
							<H1 class="error">${error}</H1>
						</c:otherwise>
					</c:choose>
					<c:url value="/index.html" var="loginUrl"/>
					<FORM action="${loginUrl}" method="post">
						<TABLE class="form">
							<TR>
								<TD align="right"><LABEL for="login">имя пользователя:</LABEL></TD>
								<TD><INPUT type="text" id="login" name="login"></TD>
							</TR>
							<TR>
								<TD align="right"><LABEL for="password">пароль:</LABEL></TD>
								<TD><INPUT type="password" id="password" name="password"></TD>
							</TR>
							<TR>
								<TD>&nbsp;</TD>
								<TD align="center"><BUTTON type="submit">вход</BUTTON></TD>
							</TR>
						</TABLE>
					</FORM>
				</TD>
			</TR>
		</TABLE>
	</BODY>
</HTML>