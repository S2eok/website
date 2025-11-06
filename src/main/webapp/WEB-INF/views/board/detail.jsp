<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="com.seok.dto.User"%>
<!DOCTYPE html>
<html>

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

	<c:set var="isLoggin" value="${not empty sessionScope.loginUser}" />
	<c:set var="isAuthor"
		value="${isLoggin and sessionScope.loginUser.userNum == board.writerNum}" />

	<c:choose>
		<%-- 로그인 + 작성자: 수정만 --%>
		<c:when test="${isAuthor}">
			<button type="button" id="update-btn" data-id="${board.boardId}">수정</button>
			<button type="button" id="delete-btn" data-id="${board.boardId}">삭제</button>
		</c:when>

		<%-- 로그인 + 비작성자: 좋아요/신고 --%>
		<c:when test="${isLoggin}">
			<button type="button" id="like-btn" data-type="BOARD"
				data-id="${board.boardId}">${isLiked ? "♥" : "♡"}</button>
			<button type="button" id="report-btn" data-type="BOARD"
				data-id="${board.boardId}">신고</button>
		</c:when>

		<c:otherwise>
			<%-- no buttons --%>
		</c:otherwise>
	</c:choose>

	<a href="${pageContext.request.contextPath}/board?act=list">목록으로</a>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>

<script>

document.getElementById('update-btn')?.addEventListener('click', (e) => {
	const boardId = e.currentTarget.dataset.id; // currentTarget 유료친구가 알려줌
    location.href = "${pageContext.request.contextPath}/board?act=update&boardId=" + boardId;
  });
  
document.getElementById('delete-btn')?.addEventListener('click', (e) => {
	const boardId = e.currentTarget.dataset.id;
    location.href = "${pageContext.request.contextPath}/board?act=delete";
  });
  
async function checklike(targetType, targetId) {
	 const checkUrl = "${pageContext.request.contextPath}/like?act=check&" 
			        + new URLSearchParams({ targetType, targetId }).toString();

     const checkRes = await fetch(checkUrl, {
    	  method: "GET", });
      
     const raw = await checkRes.text();
     return JSON.parse(raw);
}

async function toggleLike(targetType, targetId, currentText) {
	 const action = currentText === "♥" ? "delete" : "insert";
	 const likeUrl = "${pageContext.request.contextPath}/like?act=" + action;
     const res = await fetch(likeUrl, {
	             method: "POST",
                 body:   new URLSearchParams({ targetType, targetId })
	             });

	        const raw = await res.text();
	        const data = JSON.parse(raw);
	        return currentText === "♥" ? "♡" : "♥";
}

window.addEventListener("DOMContentLoaded", async () => {
    const likeBtn = document.getElementById("like-btn");
    const targetType = likeBtn.dataset.type;
    const targetId = likeBtn.dataset.id;

    // 1. 초기 좋아요 상태 확인
    const checkData = await checklike(targetType, targetId);
    likeBtn.innerText = checkData.isLiked ? "♥" : "♡";

    // 2. 클릭 시 좋아요 토글
    likeBtn.addEventListener("click", async () => {
        const newText = await toggleLike(targetType, targetId, likeBtn.innerText);
        likeBtn.innerText = newText;
    });
});
</script>

</html>