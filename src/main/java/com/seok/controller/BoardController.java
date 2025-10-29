package com.seok.controller;

import java.io.IOException;

import com.seok.dto.Board;
import com.seok.dto.User;
import com.seok.service.BoardService;
import com.seok.service.BoardServiceImpl;

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

    //System.out.println("user Action execute");
		String act = request.getParameter("act");

		switch (act) {
		case "list":
			showListForm(request, response);
			break;
		case "write":
			showWriteForm(request, response);
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

		default:
			break;
		}
	}

	// ======= GET =======
	private void showListForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}
	
	private void showWriteForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(request, response);
	}


	// ======= POST =======
	
	//게시글 작성
	private void doWrite(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login.jsp");
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
	        response.sendRedirect(request.getContextPath() + "/board/list");
	    } else {
	        // 실패 시 에러 메시지 전달
	        request.setAttribute("error", "게시글 등록 실패");
	        request.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(request, response);
	    }
	}
}