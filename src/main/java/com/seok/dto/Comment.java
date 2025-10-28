package com.seok.dto;

import java.time.LocalDateTime;

public class Comment {
	private int           commentId;  // PK
	private int           boardId;    // FK → boards.board_id
	private int           writerNum;  // FK → users.user_num
	private int           parentId;   // FK → comments.comment_id
	private String        content;
	private int           likeCount;
	private int           reportCount;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;

	public Comment() {}

	public Comment(int commentId, int boardId, int writerNum, int parentId, String content, int likeCount,
			int reportCount, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
		this.commentId   = commentId;
		this.boardId     = boardId;
		this.writerNum   = writerNum;
		this.parentId    = parentId;
		this.content     = content;
		this.likeCount   = likeCount;
		this.reportCount = reportCount;
		this.createdAt   = createdAt;
		this.updatedAt   = updatedAt;
		this.deletedAt   = deletedAt;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getWriterNum() {
		return writerNum;
	}

	public void setWriterNum(int writerNum) {
		this.writerNum = writerNum;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
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
		return "Comment [commentId=" + commentId + ", boardId=" + boardId + ", writerNum=" + writerNum + ", parentId="
				+ parentId + ", content=" + content + ", likeCount=" + likeCount + ", reportCount=" + reportCount
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
}
