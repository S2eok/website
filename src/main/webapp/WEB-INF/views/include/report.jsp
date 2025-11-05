<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<button id="report-btn" class="report-btn" data-type="BOARD"
		data-id="${board.boardId}">신고</button>

	<div id="report-modal">

		<h3>신고하기</h3>
		<form action="${pagecontext.request.comtextPath}/report">

			<input type="hidden" name="targetType" id="report-target-type">
			<input type="hidden" name="targetId" id="report-target-id"> <label
				for="report-category">사유</label> <select name="reason"
				id="report-category">
				<option value="">선택하세요</option>
				<option value="SPAM">광고/스팸</option>
				<option value="FLOOD">도배</option>
				<option value="SEXUAL">음란물</option>
				<option value="ABUSE">욕설/혐오</option>
				<option value="PRIVACY">개인정보 침해</option>
				<option value="COPYRIGHT">저작권 침해</option>
				<option value="OTHER">기타</option>
			</select> <label for="report-content">내용</label>
			
			<textarea id="report-content" name="detail" rows="4"
				placeholder="신고하실 내용을 적어주세요."></textarea>

			<button type="submit" class="add-report">신고하기</button>
		</form>
	</div>
</body>
</html>