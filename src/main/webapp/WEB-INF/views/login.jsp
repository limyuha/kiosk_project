<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String msg = request.getParameter("msg"); //사용 x %>
	<jsp:include page="top.jsp" flush="false"/>
	
	<div class="login">
		<form name="login" method="post" action="login.do" target="actionFrame"><!-- 포커스를 target="iframe" 으로 넘김 -->
			<p>LOGIN</p>
			<input type="text" placeholder="아이디" name="id">
			<input type="password" placeholder="비밀번호" name="password"> 
			<button type="submit" >로그인</button>
			<p class="join_box"><a>ID/PW 찾기</a> | <a href="join">회원가입</a></p>
		</form>
	</div>

	<iframe name="actionFrame" src="" frameborder="0" width="0" height="0" ></iframe><!-- 영역이 잡혀있지만 border, width, height 0으로 보이는 영역을 없앰 -->
	<jsp:include page="footer.jsp" flush="false"/>

<script type="text/javascript">

	var message = '<%=msg%>';
	//var message = null;
	//alert(messge);
	//alert("로그인");
/*	
	console.log(message);
	console.log('dd');
	//console.log(test);
	
	if(message != 'null') { //message에 null이 문자열로 들어감
		alert(message);
		//history.back();
		console.log('if');
	}
*/
</script>