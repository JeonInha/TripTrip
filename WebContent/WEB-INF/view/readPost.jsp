<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
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
			<td><u:pre value='${postData.contents.contents}' /></td>
		</tr>
		<tr>

			<c:if test="${ loginUser.id == null }">
					좋아요 기능은 <button type="button" id="newLogin">로그인</button> 후 사용 가능합니다.<br />
			</c:if>
			<c:if
				test="${ loginUser.id != null && loginUser.id != postData.post.writer.id}">
				 	좋아요 기능이 가능합니다.<br />
				<button type="button" id="rec_update">좋아요${postData.post.like_count}</button>
			</c:if>


			<td colspan="2"><c:set var="pageNo"
					value="${empty param.pageNo ? '1' : param.pageNo}" /> <a
				href="list.do?pageNo=${pageNo}">[목록]</a> <c:if
					test="${loginUser.id == postData.post.writer.id}">
					<a href="modify.do?no=${postData.post.post_id}">[게시글수정]</a>
					<a href="delete.do?no=${postData.post.post_id}">[게시글삭제]</a>
				</c:if></td>
		</tr>
	</table>
	<div id="map" data-loca="${planList}" style="width: 1200px; height: 350px;"></div>
	
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0de878f53f69b6e817227568f39af332"></script>
	<script src="../js/readPostMap.js"></script>
	
</body>
</html>