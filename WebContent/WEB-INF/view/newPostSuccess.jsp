<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록</title>
</head>
<body>
게시글을 등록했습니다.
<br>
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/post/choice.do">[아직 작성 안한 리뷰 목록보기]</a>
<a href="${ctxPath}/post/list.do">[작성한 리뷰 목록보기]</a>
<a href="${ctxPath}/post/read.do?no=${newPostNo}">[내가 방금 작성한 리뷰 보기]</a>
</body>
</html>