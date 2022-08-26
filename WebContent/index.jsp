<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>트립트립</title>

</head>
<body>
	<p>트립트립 여행 플래너, 여행특화 sns 사이트입니다.</p>
	<c:if test="${ ! empty loginUser }">
		<p>
			<strong>${ loginUser.name }님, 안녕하세용</strong>
			<a href="post/choice.do">[여행 리뷰하러 가기]</a>
			<a href="logout.do">[로그아웃 하기]</a>
		</p>
	</c:if>
	<c:if test="${ empty loginUser }">
		<p>
			<a href="login.do">[로그인하러 가기]</a>
		</p>
	</c:if>
</body>
</html>