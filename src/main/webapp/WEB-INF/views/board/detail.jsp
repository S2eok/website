<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<button id="like-btn" data-type="BOARD" data-id="${board.boardId}">
		${userLiked ? "♥" : "♡"}</button>

	<a href="${pageContext.request.contextPath}/board?act=list">목록으로</a>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

	<script>
document.addEventListener("DOMContentLoaded", () => {
  const likeBtn = document.getElementById("like-btn");
  const targetType = likeBtn.dataset.type; // "BOARD"
  const targetId = likeBtn.dataset.id;     // 게시글 ID
  let liked = ${userLiked};

  likeBtn.addEventListener("click", async () => {
    // URL 수정
    const url = `${pageContext.request.contextPath}/like?act=${liked ? "delete" : "insert"}`;

    // JSON 말고 Form 방식으로 전송
    const params = new URLSearchParams();
    params.append("targetType", targetType);
    params.append("targetId", targetId);

    const response = await fetch(url, {
      method: "POST",
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
      body: params
    });

    // ✅ ③ 응답 처리
    const data = await response.json();
    if (data.success) {
      liked = !liked;
      likeBtn.textContent = liked ? "♥" : "♡";
    }
  });
});
</script>

</body>

</html>