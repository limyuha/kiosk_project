<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<jsp:include page="top.jsp" flush="false"/>
	
	<div class="join">
		<form name="join" method="post" action="join.do" target="actionFrame">
			<p>JOIN</p>
			<input type="text" placeholder="아이디" name="id">
			<input type="password" placeholder="비밀번호" name="password">
			<input type="text" placeholder="연락처" name="tel"> 
			<button type="submit" >회원가입</button>
		</form>
	</div>
	
	<iframe name="actionFrame" src="" frameborder="0" width="0" height="0" ></iframe>
	<jsp:include page="footer.jsp" flush="false"/>