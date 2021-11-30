<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.menu_box img{width:200px; height:200px;}
</style>
</head>
<body>
	<c:forEach items="${menulist}" var="dto">
		<div class="menu_box">
			<img src="${dto.img}">
			<p>${dto.name}</p>
		</div>
	</c:forEach>
</body>
</html>