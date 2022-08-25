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
	// TODO 고칠 로직
	const map = '${errors}';
	   	
	var pattern_kor = /[\s.가-힣]/;
	var pattern_eql = /[=]/;
	
	var str = '';
	
	for (let item of map) {
		console.log(item);
		if (pattern_eql.test(item)) {
			break;
		}
		if (pattern_kor.test(item)) {
			str = str + item;
		}
	}
	
	if (str) {
	window.alert(str);
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
</body>
</html>