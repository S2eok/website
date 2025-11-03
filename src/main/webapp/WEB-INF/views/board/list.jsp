<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board list</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<a href="${pageContext.request.contextPath}/board?act=write">게시글 작성</a>
	<h2>게시판 목록</h2>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<%-- 게시글 등록되어있다면 출력하기, 반복문 사용할 예정 --%>
		<%-- c:forEach == for문임, board라는 list객체를 반복의 대상으로 지정, board라는 이름으로 list 안의 각 원소를 board 변수로 접근 가능 --%>
		<tbody>
			<c:forEach items="${boardList}" var="board" varStatus="vs">
				<tr>
					<td>${vs.index + 1}</td> <!-- 화면용 번호 -->
					<td>
					<a href="${pageContext.request.contextPath}/board?act=detail&boardId=${board.boardId}">
					${board.title}</td></a>
					<td>${board.writerName}</td>
					<td>${board.createdAt.toLocalDate()}</td>
					<td>${board.views}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>