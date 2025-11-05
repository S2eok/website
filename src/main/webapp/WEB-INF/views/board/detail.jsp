<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<!-- 좋아요 버튼 -->
	<button id="like-btn" data-type="BOARD" data-id="${board.boardId}">
		${isLiked ? "♥" : "♡"}</button>
		
	<!-- 신고 버튼 -->
	<button id="report-btn" data-type="BOARD" data-id="${board.boardId}">신고</button>
	 
	    <div id="modalWrap"> 
        <span id="closeBtn">&times;</span>
        <select name = "report-category" id="report-category">
          <option value="javascript">JavaScript</option>
    <option value="java">광고</option>
    <option value="python">도배</option>
    <option value="golang">음란물</option>
    <option value="php">욕설</option>
    <option value="c#">개인정보침해</option>
    <option value="C++">저작권침해</option>
    <option value="erlang">기타</option></select>>
        <label name = "report-content">내용</label>
        <textarea type="text" placeholder="신고하실 사항을 적어주세요."></textarea>
        <button className="cancle" type="button">
          취소
        </button>
        <button className="add-report" type="button">
          신고하기
        </button>
      </div>

	<a href="${pageContext.request.contextPath}/board?act=list">목록으로</a>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>

<script>
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
	 const likeUrl = "${pageContext.request.contextPath}/like?act=" + action
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