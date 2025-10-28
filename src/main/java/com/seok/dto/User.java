package com.seok.dto;

import java.time.LocalDateTime;

public class User {

	private int userNum;
	private String userId; // PK
	private String password;
	private String name;
	private String email; // UNIQUE
	private String role;
	private String status;
	private String profileImg;
	private LocalDateTime createdAt;
	private LocalDateTime lastLoginAt;

	// 기본 생성자
	public User() {}

	// 전체 필드 생성자
	public User(int userNum, String userId, String password, String name, String email, String role, String status,
			String profileImg, LocalDateTime createdAt, LocalDateTime lastLoginAt) {
		this.userNum = userNum;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.role = role;
		this.status = status;
		this.profileImg = profileImg;
		this.createdAt = createdAt;
		this.lastLoginAt = lastLoginAt;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(LocalDateTime lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	@Override
	public String toString() {
		return "User{" + "userNum=" + userNum + ", userId='" + userId + '\'' + ", password='" + password + '\''
				+ ", name='" + name + '\'' + ", email='" + email + '\'' + ", role='" + role + '\'' + ", status='"
				+ status + '\'' + ", profileImg='" + profileImg + '\'' + ", createdAt=" + createdAt + ", lastLoginAt="
				+ lastLoginAt + '}';
	}
}
