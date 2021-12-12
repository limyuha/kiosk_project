<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	java.util.Date today = new java.util.Date(); //현재 날짜(변하는 값) //css수정 시 빠르게 보려고
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 초기화 css -->
	<link rel="stylesheet" href="resources/css/reset.css"/>
	
	<!-- 모든 css -->
	<!-- link rel="stylesheet" href="<c:url value="/resources/css/all.css?v=<%=today%>"/>"> -->
	<link rel="stylesheet" href="resources/css/all.css?v=<%=today%>"/>
	
	<!-- 폰트 -->
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel=sytlesheet">
	
	<!-- 아이콘 css -->
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>
	
	<!-- 자바스크립트 이벤트 사용시 필요한 소스 -->
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<div class="top_box">
	<div class="gnb">
		<ul>
			<li><a href="main">전체</a></li>
			<li><a href="main?target=coffee_menu">Coffee</a></li>
			<li><a href="main?target=non_coffee_menu">Non-Coffee</a></li>
			<li><a href="main?target=dessert_menu">Dessert</a></li>
		</ul>
		<c:choose>
			<c:when test="${id == null}"> <!-- if, 세션에 저장되어 있는 id -->
				<p><a href="login"><i class="fas fa-sign-in-alt"></i> LOGIN</a></p>
			</c:when>
			<c:otherwise> <!-- else -->
				
				<p>${id}님 | <a href="cart?member_seq=${member_seq}">장바구니</a> | <a href="kiosk_order?member_seq=${member_seq}"> 주문내역</a> | <a href="logout"> LOGOUT</a></p>
			</c:otherwise>
		</c:choose>
	</div>
</div>