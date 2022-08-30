<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 읽기</title>
</head>
<body>
<table border="1" width="100%">
<tr>
	<td>번호</td>
	<td>${postData.post.post_id}</td>
</tr>
<tr>
	<td>작성자</td>
	<td>${postData.post.writer.name}</td>
</tr>
<tr>
	<td>제목</td>
	<td><c:out value='${postData.post.title}' /></td>
</tr>
<tr>
	<td>내용</td>
	<td><u:pre value='${postData.contents.contents}'/></td>
</tr>
<tr>
	<td colspan="2">
		<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
		<a href="list.do?pageNo=${pageNo}">[목록]</a>
		<c:if test="${loginUser.id == postData.post.writer.id}">
		<a href="modify.do?no=${postData.post.post_id}">[게시글수정]</a>
		<a href="delete.do?no=${postData.post.post_id}">[게시글삭제]</a>
		</c:if>
	</td>
</tr>
</table>

</body>
</html>