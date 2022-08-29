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
	<p>회원가입 하기</p>

	<form action="./signUp.do" method="POST">
		<p>※이메일 주소를 입력해 주세요.</p>
		<label>ID: <input type="text" name="id" required />
		</label><br />
		<br />

		<p>※닉네임은 영문자, 숫자, 한글만 사용 가능합니다. 2~12자 사이로 입력하세요.</p>
		<label>닉네임: <input type="text" name="name" required  />
		</label><br />
		<br />

		<p>※패스워드는 영문자와 숫자, 일부 특수문자(~!@#$%^&*())만 사용 가능합니다. 4~20자 사이로
			입력하세요.</p>
		<label>패스워드: <input type="password" name="pw" required /></label><br />
		<br />

		<p>※비밀번호 확인입니다. 상단에 기입한 패스워드를 동일하게 입력해주세요.</p>
		<label>패스워드 확인: <input type="password" name="confirmpw" required />
		</label><br />
		<br /> <input type="submit" value="가입하기" />
	</form>
	
	<c:if test="${ not empty errors }">
		<p style="color: #ff7062;">에러 메시지</p>
		<c:forEach var="error" items="${ errors }">
			<p style="color: #ff7062;">${ error.key }</p>
		</c:forEach>
	</c:if>

</body>
</html>