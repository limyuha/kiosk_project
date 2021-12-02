<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu_box">
	<ul>
		<c:forEach items="${menulist}" var="dto">
			<li>
				<a href="drink_detail?menu_seq=${dto.seq}">
					<div>
						<img src="${dto.img}">
					</div>
					<p>${dto.name}</p>
					<p>${dto.price} 원</p>
				</a>
			</li>
		</c:forEach>
	</ul>
</div>
	
</body>
</html>