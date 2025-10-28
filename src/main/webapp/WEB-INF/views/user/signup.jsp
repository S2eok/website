<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="Signup-wrapper">
		<h2>Login</h2>
		<form method="post" action="${pageContext.request.contextPath}/user?act=signup" id="signup-form">
			<input type="text" name="userId" placeholder="아이디">
			<input type="password" name="userPassword" placeholder="비밀번호">
			<input type="password" name="userPasswordCheck" placeholder="비밀번호 확인">
			<input type="text" name="userName" placeholder="이름">
			<input type="email" name="userEmail" placeholder="이메일">
			<input type="submit" value="Signup">
		</form>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>
