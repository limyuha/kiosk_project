<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String target = request.getParameter("target");
	if (target == null) {
		target = "main_body";
	}
	String targetpage = target + ".jsp";
	
	java.util.Date today = new java.util.Date(); //현재 날짜(변하는 값) //css수정 시 빠르게 보려고
%>
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

	<jsp:include page="<%=targetpage%>" flush="false"/>
</body>
</html>