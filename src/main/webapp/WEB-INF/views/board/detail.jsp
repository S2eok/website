<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.title}</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h2>게시글 내용</h2>
	<p>작성자 ${board.writerName}</p>
	<p>작성일 ${board.createdAt.toLocalDate()}</p>
	<p>조회수 ${board.views}</p>
	<p>좋아요 수 ${board.likeCount}</p>
	<p>구분 ${board.category}</p>
	<p>제목 ${board.title}</p>
	<p>내용 ${board.content}</p>
	
	<c:if test="${userLiked}">
		<button id="like-btn" class="liked">♥</button>
	</c:if>
	<c:if test="${!userLiked}">
		<button id="like-btn">♡</button>
	</c:if>
	
	<a href="${pageContext.request.contextPath}/board?act=list">목록으로</a>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>