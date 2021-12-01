<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	java.util.Date today = new java.util.Date(); //현재 날짜(변하는 값) //css수정 시 빠르게 보려고
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<!-- 모든 css -->
	<!-- link rel="stylesheet" href="<c:url value="/resources/css/all.css?v=<%=today%>"/>"> -->
	<link rel="stylesheet" href="resources/css/all.css?v=<%=today%>"/>
	
	<!-- 초기화 css -->
	<link rel="stylesheet" href="resources/css/reset.css" />
	
	<!-- 폰트 -->
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel=sytlesheet">
	
	<!-- 아이콘 css -->
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	
</head>
<body>
	<jsp:include page="top.jsp" flush="false"/>
	

<div class="menu_box">
	<ul>
		<c:forEach items="${menulist}" var="dto">
			<li>
				<div>
					<img src="${dto.img}">
				</div>
				<p>${dto.name}</p>
				<p>${dto.price} 원</p>
			</li>
		</c:forEach>
	</ul>
</div>
	
</body>
</html>