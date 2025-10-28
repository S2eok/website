<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.seok.dto.User"%>
<header>
	<a href="${pageContext.request.contextPath}/">홈</a>
	<%
	User loginUser = (User) request.getSession().getAttribute("loginUser");
	if (loginUser != null) {
	%>
	<span>(${sessionScope.loginUser.name}님)</span>
	<a href="${pageContext.request.contextPath}/user?act=mypage">마이페이지</a>
	<a href="${pageContext.request.contextPath}/user?act=logout">로그아웃</a>
	<%
	} else {
	%>
	<a href="${pageContext.request.contextPath}/user?act=login">로그인</a>
	<a href="${pageContext.request.contextPath}/user?act=signup">회원가입</a>
	<%
	}
	%>
</header>