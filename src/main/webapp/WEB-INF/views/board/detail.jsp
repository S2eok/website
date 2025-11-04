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

    <a href="${pageContext.request.contextPath}/board?act=list">목록으로</a>
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
    <script>
        const contextPath = "${pageContext.request.contextPath}";
    </script>
</body>

<script>
    window.addEventListener("DOMContentLoaded", async () => {
        const likeBtn = document.getElementById("like-btn");
        if (!likeBtn) return;

        const targetType = likeBtn.dataset.type || "BOARD";
        const targetId = likeBtn.dataset.id;

        // 1. 초기 상태 확인 (GET /like?act=check)
        const checkUrl = contextPath + "/like?act=check&" + new URLSearchParams({
            targetType,
            targetId
        }).toString();

        try {
            const checkRes = await fetch(checkUrl, {
                method: "GET",
                credentials: "include"
            });
            // 401 / 400 등일 수 있으니 텍스트로 받아보고 JSON 파싱 시도
            const raw = await checkRes.text();
            let checkData = {};
            try {
                checkData = JSON.parse(raw);
            } catch (_) {
                checkData = {};
            }
            likeBtn.innerText = checkData.isLiked ? "♥" : "♡";
        } catch (e) {
            // 실패해도 기본 표시 유지
            console.error("초기 좋아요 상태 확인 실패:", e);
        }

        // 2) 클릭 시 insert/delete (POST /like?act=insert|delete)
        likeBtn.addEventListener("click", async () => {
            const isLiked = likeBtn.innerText === "♥";
            const action = isLiked ? "delete" : "insert";

            // UI 선반영
            likeBtn.innerText = isLiked ? "♡" : "♥";

            try {
                const res = await fetch(contextPath + "/like?act=" + action, {
                    method: "POST",
                    credentials: "include",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded"
                    },
                    body: new URLSearchParams({
                        targetType,
                        targetId
                    }).toString()
                });

                const raw = await res.text();
                let data = {};
                try {
                    data = JSON.parse(raw);
                } catch (_) {
                    data = {};
                }

                if (!data.success) {
                    // 서버 실패 시 롤백
                    likeBtn.innerText = isLiked ? "♥" : "♡";
                    if (res.status === 401) alert("로그인이 필요합니다.");
                }
            } catch (e) {
                console.error("좋아요 요청 중 오류:", e);
                // 네트워크 오류 시 롤백
                likeBtn.innerText = isLiked ? "♥" : "♡";
            }
        });
    });
</script>

</html>