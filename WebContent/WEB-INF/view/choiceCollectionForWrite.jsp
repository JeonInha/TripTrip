<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${ empty planList }">
			<p>포스팅을 하려면 여행계획이 있어야 합니다. 여행계획 작성하기 기능은 미구현입니다.</p>
			<a href="../index.jsp"> 타이틀로 돌아가기 </a>
		</c:when>
		<c:otherwise>
			<p>포스트를 작성할 여행계획을 선택하세요.</p>
			<ul>
				<c:forEach var="plan" items="${ planList }">
					<li>
						<form action="post/writeWithPlan.do" method = "POST">
							<label>${ plan.title }<input type="hidden"
								value="${plan}" /><input type="submit" value="쓰러가자!" /></label>
						</form>
				</c:forEach>
			</ul>
			<p>여행계획 없이 포스팅하는 기능을 업뎃할 예정입니다.</p>
		</c:otherwise>
	</c:choose>

</body>
</html>