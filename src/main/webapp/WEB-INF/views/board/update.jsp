<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board update</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h2>게시글 수정</h2>
	<form method="post" action="${pageContext.request.contextPath}/board?act=update" id="update-form">
	    <!-- 이거 한줄 안넣어서 오류터짐 -->
	    <input type="hidden" name="boardId" value="${board.boardId}"> 
	    
		<input type="hidden" name="writerNum" value="${sessionScope.loginUser.userNum}">
		<label for="boardtitle">분류</label>
		<input type="text" name="category" placeholder="카테고리" value="${board.category}">
		<label for="boardtitle">제목</label>
		<input type="text" name = "title" id="boardtitle" placeholder="제목을 작성해주세요" value="${board.title}">
		<label for="boardcontent">내용</label>
		<textarea  name = "content" id="boardcontent" placeholder="내용을 작성해주세요"><c:out value="${board.content}"/></textarea>
		<input type="submit" value="수정하기">
	</form>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>