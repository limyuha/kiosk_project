<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	int menu_seq = Integer.parseInt(request.getParameter("menu_seq")); 
%>
	<jsp:include page="top.jsp" flush="false"/>
	
	<div class="menu_detail width_1000">
		<div class="img_box">
			<img src="${menu_detail.img_url}">
		</div>
		
		<div class="content_box">
			<p class="name">${menu_detail.name}</p>
				<hr style="border:0px; height:1px; background:black; margin-bottom:12px;">
				<div class="option">
					<form name="option" action="cart.do?menu_seq=<%=menu_seq%>" method="post" target="actionFrame">
					<input type="hidden" name="id" value="${member_seq}">
						<div>
							<p>SIZE</p>
							<c:forEach items="${cup_size}" var="dtos" varStatus="status">
								<label><input type="radio" name="${dtos.name}" value="${dtos.value}"><span>${dtos.value}</span></label>
							</c:forEach>
						</div>
						<div>
							<p>CUP</p>
							<c:forEach items="${cup_choice}" var="dtos">
								<label><input type="radio" name="${dtos.name}" value="${dtos.value}"><span>${dtos.value}</span></label>
							</c:forEach>
						</div> 
						
						<button type="button" target="option" onclick="" style="margin-right:36px;">주문하기</button>
						<button type="submit">장바구니</button>
					</form>
				</div>
				
				<!-- <button type="button" onclick="location.href='cart.do?menu_seq=<%=menu_seq%>'" target="actionFrame"><i class="fas fa-cart-plus"></i> 장바구니</button>  -->
				<hr style="border:0px; height:0.5px; background:#D5D5D5; margin-top:12px;">
			<p class="context">${menu_detail.context}</p>
				<hr style="border:0px; height:0.5px; background:#D5D5D5; margin:15px 0;">
			<dl class="dl_box">
				<dt>1회 제공량 (kcal)</dt>
					<dd>${menu_detail.provid}</dd>
				<dt>포화지방 (g)</dt>
					<dd>${menu_detail.saturated_fat}</dd>
				<dt>단백질 (g)</dt>
					<dd>${menu_detail.protein}</dd>
			</dl>
		
			<dl>
				<dt>나트륨 (mg)</dt>
					<dd>${menu_detail.sodium}</dd>
				<dt>당류 (g)</dt>
					<dd>${menu_detail.sugar}</dd>
				<dt>카페인 (mg)</dt>
					<dd>${menu_detail.caffeine}</dd>
			</dl>
			
			<div class="allergy">알레르기 유발 요인 : ${menu_detail.allergy}</div>
		</div>
	
		<hr style="clear:both; width:1000px; border:0px; height:0.5px; background:#D5D5D5;">
	</div>
	
	<iframe name="actionFrame" src="" frameborder="0" width="0" height="0" ></iframe>
	<jsp:include page="footer.jsp" flush="false"/>

<script>
	$(function(){
		$('input:radio[name=cup_size]').eq(0).attr("checked", true);
		$('input:radio[name=cup_choice]').eq(0).attr("checked", true);
	});
</script>