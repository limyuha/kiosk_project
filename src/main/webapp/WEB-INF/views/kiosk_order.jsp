<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<jsp:include page="top.jsp" flush="false"/>	
	
	<div class="order_box">
		<div class="header">
			<p>주문내역</p>
		</div>
		
		<ul>
			<c:forEach items="${order_list}" var="o">
				<li>
					<p class="order_header">
						<span>주문 일자 <fmt:formatDate value="${o.date}" pattern="yyyy-MM-dd HH시 ss분"/></span>
						<span class="sum_box"><fmt:formatNumber value="${o.sum}" pattern="#,###"/>원</span>
					</p>
					<ul>
						<c:forEach items="${o.orderitem}" var="s">
							<li>
								<a href="menu_detail?menu_seq=${s.menu_seq}">
									<div class="img_box">
										<img src="${s.img_url}">
									</div>
									
									<div class="order_detail_box">
										<p class="name"><c:out value="${s.name}"/></p>
										<p>
											<c:out value="${s.cup_size}"/> | <c:out value="${s.cup_choice}"/>
											<span class="price_box"><fmt:formatNumber value="${s.price}" pattern="#,###"/>원
											</span>
										</p>
										<p class="ea">
											<span>
												수량 : <c:out value="${s.ea}"/>
												<span class="price_box"><fmt:formatNumber value="${s.price * s.ea}" pattern="#,###"/>원</span>
											</span>
										</p>
									</div>
								</a>
							</li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<jsp:include page="footer.jsp" flush="false"/>
