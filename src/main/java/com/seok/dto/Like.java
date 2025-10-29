package com.seok.dto;

import java.time.LocalDateTime;

public class Like {
	private int           likeId;      // PK
	private String        targetType;  // BOARD or COMMENT
	private int           targetId;
	private int           userNum;     // FK → users.user_num
	private LocalDateTime createdAt;

	public Like() {}

	public Like(int likeId, String targetType, int targetId, int userNum, LocalDateTime createdAt) {
		this.likeId     = likeId;
		this.targetType = targetType;
		this.targetId   = targetId;
		this.userNum    = userNum;
		this.createdAt  = createdAt;
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

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Like [likeId=" + likeId + ", targetType=" + targetType + ", targetId=" + targetId + ", userNum="
				+ userNum + ", createdAt=" + createdAt + "]";
	}
}
