package com.seok.dto;

import java.time.LocalDateTime;

public class Board {
	private int           boardId;     // PK
	private String        title;
	private String        content;
	private int           writerNum;   // FK → users.user_num
	private int           views;
	private String        category;
	private boolean       pinned;
	private int           likeCount;
	private int           commentCount;
	private int           reportCount;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;

	public Board() {}

	public Board(int boardId, String title, String content, int writerNum, int views, String category, boolean pinned,
			int likeCount, int commentCount, int reportCount, LocalDateTime createdAt, LocalDateTime updatedAt,
			LocalDateTime deletedAt) {
		this.boardId      = boardId;
		this.title        = title;
		this.content      = content;
		this.writerNum    = writerNum;
		this.views        = views;
		this.category     = category;
		this.pinned       = pinned;
		this.likeCount    = likeCount;
		this.commentCount = commentCount;
		this.reportCount  = reportCount;
		this.createdAt    = createdAt;
		this.updatedAt    = updatedAt;
		this.deletedAt    = deletedAt;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getWriterNum() {
		return writerNum;
	}

	public void setWriterNum(int writerNum) {
		this.writerNum = writerNum;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isPinned() {
		return pinned;
	}

	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", content=" + content + ", writerNum=" + writerNum
				+ ", views=" + views + ", category=" + category + ", pinned=" + pinned + ", likeCount=" + likeCount
				+ ", commentCount=" + commentCount + ", reportCount=" + reportCount + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
}