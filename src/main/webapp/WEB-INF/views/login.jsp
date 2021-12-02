<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<jsp:include page="top.jsp" flush="false"/>
	
	<div class="login">
		<form>
			<p>LOGIN</p>
			<input type="text" placeholder="아이디" name="id">
			<input type="password" placeholder="비밀번호" name="password"> 
			<button>로그인</button>
			<p class="join_box"><a>ID/PW 찾기</a> | <a>회원가입</a></p>
		</form>
	</div>
	
	<jsp:include page="footer.jsp" flush="false"/>