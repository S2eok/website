<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="login-wrapper">
		<h2>Login</h2>
		<form method="post" action="${pageContext.request.contextPath}/user?act=login" id="login-form">
			<input type="text" name="userId" placeholder="아이디">
			<input type="password" name="password" placeholder="비밀번호">
			<label for="rememder-check">
				<input type="checkbox" id="rememder-check">
				아이디 저장하기
			</label>
			<input type="submit" value="Login">
		</form>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>