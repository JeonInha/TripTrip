<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TripTrip/여행 계획짜기</title>
</head>
<body>
<form action="writeWithPlan.do" method="post">
<p>
	제목:<br/><input type="text" name="title" value="여기에 요청받는 값이 들어와야 합니다.">
	<c:if test="${errors.title}">제목 값 받아와야 합니다</c:if>
</p>
<p>
	내용:<br/>
	<textarea name="contents" rows="5" cols="30">${param.contets}</textarea>
</p>
<input type="submit" value="글 저장하기">
</form>
</body>
</html>>