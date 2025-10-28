package com.seok.dto;

import java.time.LocalDateTime;

public class Like {
	private int           likeId;     // PK
	private String        targetType; // BOARD or COMMENT
	private int           targetId;
	private int           user_num;   // FK → users.user_num
	private LocalDateTime created_at;

	public Like() {}

	public Like(int likeId, String targetType, int targetId, int user_num, LocalDateTime created_at) {
		this.likeId     = likeId;
		this.targetType = targetType;
		this.targetId   = targetId;
		this.user_num   = user_num;
		this.created_at = created_at;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", targetType=" + targetType + ", targetId=" + targetId + ", user_num="
				+ user_num + ", created_at=" + created_at + "]";
	}
}