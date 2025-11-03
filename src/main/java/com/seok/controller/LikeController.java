package com.seok.controller;

import java.io.IOException;
import java.util.List;

import com.seok.dto.Board;
import com.seok.dto.Like;
import com.seok.dto.User;
import com.seok.service.BoardService;
import com.seok.service.BoardServiceImpl;
import com.seok.service.LikeService;
import com.seok.service.LikeServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 좋아요 기능 전용 컨트롤러 역할: 좋아요 (추가/취소), 상태 확인 등 AJAX 요청 처리
 */
@WebServlet("/like")
public class LikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LikeService service = LikeServiceImpl.getInstance();

	// 서버에 제출
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		User loginUser = (User) request.getSession().getAttribute("loginUser");

		if (loginUser == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("{\"success\":false, \"message\":\"로그인이 필요합니다.\"}");
			return;
		}

		String targetType = request.getParameter("targetType");
		int targetId = Integer.parseInt(request.getParameter("targetId"));

		Like like = new Like();
		like.setTargetType(targetType);
		like.setTargetId(targetId);
		like.setUserNum(loginUser.getUserNum());

		boolean success = false;

		switch (act) {
		case "insert":
			success = service.insertLike(like) > 0;
			break;
		case "delete":
			success = service.deleteLike(like) > 0;
			break;
		case "check":
			success = service.checkUserLike(like);
			break;
		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		response.getWriter().write("{\"success\":" + success + "}");
	}
}
