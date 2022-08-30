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
여기에는 내가 쓴 거 다시 보여줘야함
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/post/choice.do">[아직 작성 안한 리뷰 목록보기]</a>
<a href="${ctxPath}">홈으로 돌아가기</a>
<a href="${ctxPath}/post/read.do?id=${newPostNo}">쓴 내용 확인하기</a>
</body>
</html>
