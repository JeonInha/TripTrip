<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	const map = '${errors}';
	for (let item of map) {
		console.log(item[0]);
	}
	
	
</script>
<body>
	<form action="./login.do" method="post">
		<label>ID: <input type="text" name="id" />
		</label> 
		<label>PW:<input type="password" name="pw" /> 
		</label> 
		<input
			type="submit" value="login" />
	</form>
	<c:if test="${! empty errors}">
		<p>값을 입력해야 합니다. 계정 정보가 없거나 아이디, 패스워드를 정확히 입력했는지 확인하세요.</p>
	</c:if>
</body>
</html>