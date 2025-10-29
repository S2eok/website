<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board write</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h2>게시글 작성</h2>
	<form method="post" action="${pageContext.request.contextPath}/user?act=write" id="write-form">
		<label for="boardtitle">내용</label>
		<input type="text" id="boardtitle" placeholder="제목을 작성해주세요">
		<label for="boardcontent">내용</label>
		<textarea id="boardcontent" placeholder="내용을 작성해주세요"></textarea>
		<input type="submit" value="작성하기">
	</form>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>