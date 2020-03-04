<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Hello</title>
	</head>
	<body>
		<header>
			<h1>Title : ${title}</h1>
		</header>
		<section>
			<h1>Стартовая страница</h1>
			<h1>Message : ${message}</h1>
		</section>
		<div><a href="bookslist">LIBRARY</a></div>
		<br>
		<div><a href="free">Free test page №1</a></div>
		<div><a href="free2">Test page №2 by USER</a></div>
		<div>Get <a href="protected">protected</a> resource for admin.</div>
		<div>Get <a href="confidential">confidential</a> resource for superadmin.</div>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>Welcome : ${pageContext.request.userPrincipal.name}</h2>
			<%--@elvariable id="_csrf" type="org.springframework.web.bind.MissingServletRequestParameterException"--%>
			<c:url var="logoutUrl" value="/logout" />
			<form action="${logoutUrl}" id="logout" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					   value="${_csrf.token}" />
				<input type="submit" name="submit" value="Log Out">
			</form>
		</c:if>
	</body>
</html>
