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
 * 좋아요 기능 전용 컨트롤러 역할: 좋아요 토글(추가/취소), 상태 확인 등 AJAX 요청 처리
 */
@WebServlet("/like")
public class LikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LikeService service = LikeServiceImpl.getInstance();

	// 서버에 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		User loginUser = (User) request.getSession().getAttribute("loginUser");

		// 유료친구가 알려줌. 틀리거나 괴상할 수도...
		if (loginUser == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("{\"success\":false, \"message\":\"로그인이 필요합니다.\"}");
			return;
		}

		switch (act) {
		case "check":
			checkUserLike(request, response, loginUser);
			break;

		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			break;
		}

	}

	// 서버에 제출
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");
		User loginUser = (User) request.getSession().getAttribute("loginUser");

		// 유료친구가 알려줌. 틀리거나 괴상할 수도...
		if (loginUser == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write("{\"success\":false, \"message\":\"로그인이 필요합니다.\"}");
			return;
		}

		switch (act) {
		case "toggle":
			toggleLike(request, response, loginUser);
			break;

		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			break;
		}
	}

	// ======= GET =======

	// 좋아요 확인
	private void checkUserLike(HttpServletRequest request, HttpServletResponse response, User user)
			throws ServletException, IOException {

		String targetType = request.getParameter("targetType");
		int targetId = Integer.parseInt(request.getParameter("targetId"));
		
		Like like = new Like();
		like.setTargetType(targetType);
		like.setTargetId(targetId);
		like.setUserNum(user.getUserNum());
		
		boolean liked = service.checkUserLike(like);
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write("{\"liked\": " + liked + "}");
	}

	// ======= POST =======

	// 게시글 작성
	private void toggleLike(HttpServletRequest request, HttpServletResponse response, User user)
			throws IOException, ServletException {

		String targetType = request.getParameter("targetType");
		int targetId = Integer.parseInt(request.getParameter("targetId"));
		
		Like like = new Like();
		like.setTargetType(targetType);
		like.setTargetId(targetId);
		like.setUserNum(user.getUserNum());
		
		boolean liked = service.toggleLike(like);
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write("{\"liked\": " + liked + "}");	
		}
}