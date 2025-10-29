package com.seok.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.seok.dto.User;
import com.seok.service.UserService;
import com.seok.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService service = UserServiceImpl.getInstance();

	// 서버에 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

    //System.out.println("user Action execute");
		String act = request.getParameter("act");

		switch (act) {
		case "login":
			showLoginForm(request, response);
			break;

		case "signup":
			showSingupForm(request, response);
			break;

		case "logout":
			logout(request, response);
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
		case "login":
			doLogin(request, response);
			break;

		default:
			break;
		}
	}

	// ======= GET =======
	private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
	}

	private void showSingupForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/user/signup.jsp").forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	      request.getSession().invalidate();
	      response.sendRedirect(request.getContextPath() + "/");

	}

	// ======= POST =======
	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id = request.getParameter("userId");
		String password = request.getParameter("password");

		User user = service.login(id, password);

		if (user != null) {
			request.getSession().setAttribute("loginUser", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "계정 정보를 찾을 수 없습니다.");
			request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
		}
	}
}
