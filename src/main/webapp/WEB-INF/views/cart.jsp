<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- 콤마 라이브러리 -->

	<jsp:include page="top.jsp" flush="false"/>	
	
	<div class="cart_box">
		<div class="header">
			<p>장바구니 <button><i class="far fa-trash-alt"></i></button></p>
		</div>
		
		<ul>
			<c:forEach items="${cart}" var="dtos" varStatus="status">
				<script type="text/javascript">
					var eaa = '<c:out value="${ea}" escapeXml="false" default="${dtos.ea}"/>';
				</script>
			
				<li>
					<div class="img_box">
						<img src="${dtos.img_url}">
					</div>
					
					<div class="cart_detail">
						<p class="name"><c:out value="${dtos.name}"/>  ${dtos.seq}</p>
						<p><c:out value="${dtos.cup_size}"/> | <c:out value="${dtos.cup_choice}"/><span class="price_box price"><fmt:formatNumber value="${dtos.price}" pattern="#,###"/></span>원</p>
						
						<p class="box">
							<button type="button" class="down" data-seq="${dtos.seq}"><i class="fas fa-minus-circle"></i></button>
							<span class="ea"><c:out value="${dtos.ea}"/></span><!-- ${dtos.ea}  <c:out value="<script>document.write(eaa);</script>" escapeXml="false" default="기본값"/> <script>document.write(eaa)</script>-->
							<button type="button" class="up" data-seq="${dtos.seq}"><i class="fas fa-plus-circle"></i></button>
							<span class="price_box"><em class="price_sum"><fmt:formatNumber value="${dtos.ea * dtos.price}" pattern="#,###"/></em>원
							</span>
						</p>
					</div>
				</li>
			</c:forEach>
		</ul>
		
		<div class="order_box">
			<p>
				<span class="menu_sum">총 0건</span>
				<span class="sum">0원</span>
			</p>
			<button>주문하기</button>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" flush="false"/>
<script>
	function calculation(ea, price) {
		var price_sum = 0;
		price_sum = ea * price;
		
		return price_sum;
	}
	
	function totalCalculation() {
		var sum = 0;
		var menu_sum = 0;
		
		$('.cart_box ul li').each(function(index, item){ //item = this
			var price_sum = $(this).find('.price_sum').text();
			price_sum = price_sum.replace(',',''); //콤마 지워주기
				
			sum += parseInt(price_sum); //사칙연산 사용하려면 캐스팅 필요(parseInt)
			menu_sum += 1;
			
			console.log("price_sum" + price_sum);
			console.log(sum);
		});
		
		$('.cart_box .sum').html(comma(sum)+"원");
		$('.cart_box .menu_sum').html("총 "+menu_sum+"건");
	
	}
	function comma(v) {
		return v.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}

	$(function() { //마크업 끝나고 실행됨
		totalCalculation(); //호출 안하면 0원
	
		$('.up, .down').click(function() { //class up 또는 down 눌리면 실행
			var that = $(this); //ajax 안으로 들어가면 ajax this로 사용되서 위에서 선언하고 사용
			var ea = 0;
			
			if(that.hasClass('up')) { ea = parseInt(that.parents('li').find('.ea').text()) + 1; }
			if(that.hasClass('down')) { ea = parseInt(that.parents('li').find('.ea').text()) - 1; }
		
			if(ea < 1) {
				alert("수량은 1개이상만 가능합니다.");
				return false; //밑에 안타게
			}
			
			$.ajax({
				url : '/project/updwon',
				type : 'post',
				data : 'cart_seq=' +$(this).attr('data-seq')+ '&ea=' +ea,
				success : function(check) {
					
					that.parents('li').find('.ea').html(ea); //부모한테 갔다가 자식찾기, html => 원래 작성되어 있는거 초기화 하고 넣어짐
					
					var price = that.parents('li').find('.price').text();
					price = price.replace(',',''); //콤마 지워주기
					var price_sum = calculation(ea, price);
					
					that.parents('li').find('.price_sum').html(comma(price_sum));
					
					totalCalculation();
				},
				error : function(check) {
					console.log(check);
				}
			});
		});
	});
</script>
