<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
</head>
<body>
<div class="top_box">
	<ul>
		<li><a href="main">전체</a></li>
		<li><a href="main?target=coffee_menu">Coffee</a></li>
		<li><a href="main?target=non_coffee_menu">Non-Coffee</a></li>
		<li><a href="main?target=dessert_menu">Dessert</a></li>
	</ul>
	
	<spen><a href="login"><i class="fas fa-sign-in-alt"></i> LOGIN</a></spen>
</div>