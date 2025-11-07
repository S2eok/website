package com.seok.controller;

import java.io.IOException;
import java.util.List;

import com.seok.dto.Board;
import com.seok.dto.Comment;
import com.seok.dto.User;
import com.seok.service.BoardService;
import com.seok.service.BoardServiceImpl;
import com.seok.service.CommentService;
import com.seok.service.CommentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService service = BoardServiceImpl.getInstance();

	// 서버에 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");

		switch (act) {
		case "list":
			showListForm(request, response);
			break;
		case "write":
			showWriteForm(request, response);
			break;
		case "detail":
			showDetailForm(request, response);
			break;
		case "update":
			showUpdateForm(request, response);
			break;

		default:
			break;
		}
	}

	// 서버에 제출
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act");

		switch (act) {
		case "write":
			doWrite(request, response);
			break;
		case "update":
			doUpdate(request, response);
			break;
		case "delete":
			doDeleteBoard(request, response);
			break;

		default:
			break;
		}
	}



	// ======= GET =======

	// 게시글 목록 불러오기
	private void showListForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 서비스 객체 가져오기
		BoardService service = BoardServiceImpl.getInstance();

		// 2. 게시글 목록 조회
		List<Board> boardlist = service.selectAllBoards();

		// 3. JSP 에서 쓸 수 있게 requset에 담기
		request.setAttribute("boardList", boardlist);

		// 4. 목록 페이지로 forward
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}

	private void showWriteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(request, response);
	}

	// 게시글 상세 조회
	private void showDetailForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int boardId = Integer.parseInt(request.getParameter("boardId"));
		// 1. 서비스 객체 가져오기
		BoardService service = BoardServiceImpl.getInstance();

		// 2. 기능

		// 2-1. 조회수
		// 로그인한 사용자 가져오기
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String viewKey = "viewed_" + boardId;

		// 세션에 해당 게시글 조회 기록이 없을 때만 조회수 증가
		if (loginUser != null && request.getSession().getAttribute(viewKey) == null) {
			service.increaseViews(boardId);
			request.getSession().setAttribute(viewKey, true);
		}

		// 2-3. 해당 게시글 1개 조회
		Board board = service.selectBoardById(boardId);

		// 3. JSP로 전달
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(request, response);
	}

	// 게시글 수정페이지 이동
	private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int boardId = Integer.parseInt(request.getParameter("boardId"));

		Board board = service.selectBoardById(boardId);

		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
	}

	// ======= POST =======

	// 게시글 작성
	private void doWrite(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");

		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/user?act=login");
			return;
		}
		int writerNum = loginUser.getUserNum();

		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriterNum(writerNum);
		board.setCategory(category);

		BoardService service = BoardServiceImpl.getInstance();
		int result = service.insertBoard(board);

		if (result > 0) {
			// 성공 시 목록 페이지로
			response.sendRedirect(request.getContextPath() + "/board?act=list");
		} else {
			// 실패 시 에러 메시지 전달
			request.setAttribute("error", "게시글 등록 실패");
			request.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(request, response);
		}
	}

	// 게시글 수정하기
	private void doUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		User loginUser = (User) request.getSession().getAttribute("loginUser");

		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		int writerNum = loginUser.getUserNum();

		Board board = new Board();
		
		board.setBoardId(boardId); 
		board.setTitle(title);
		board.setContent(content);
		board.setWriterNum(writerNum);
		board.setCategory(category);
		
		BoardService service = BoardServiceImpl.getInstance();
		int result = service.updateBoard(board);

		if (result > 0) {
			// 성공 시 상세 페이지로
			response.sendRedirect(request.getContextPath() + "/board?act=detail&boardId=" + boardId);
		} else {
			// 실패 시 에러 메시지 전달
			request.setAttribute("error", "게시글 수정 실패");
			request.setAttribute("board", board);
			request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
		}
	}
	
	//게시글 삭제
	private void doDeleteBoard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		BoardService service = BoardServiceImpl.getInstance();
		int result = service.deleteBoard(boardId);
		
		if (result > 0) {
			// 성공 시 상세 페이지로
			response.sendRedirect(request.getContextPath() + "/board?act=list");
		} else {
			// 실패 시 에러 메시지 전달
			request.setAttribute("error", "게시글 삭제 실패");
			request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
		}
	}
}