package com.seok.dto;

import java.time.LocalDateTime;

public class File {
	private int           fileId;       // PK
	private int           boardId;      // FK → boards.board_id
	private String        originalName;
	private String        savedName;
	private String        fileType;
	private String        extension;
	private String        filePath;
	private long          size;
	private int           downloadCount;
	private LocalDateTime createdAt;

	public File() {}

	public File(int fileId, int boardId, String originalName, String savedName, String fileType, String extension,
			String filePath, long size, int downloadCount, LocalDateTime createdAt) {
		this.fileId        = fileId;
		this.boardId       = boardId;
		this.originalName  = originalName;
		this.savedName     = savedName;
		this.fileType      = fileType;
		this.extension     = extension;
		this.filePath      = filePath;
		this.size          = size;
		this.downloadCount = downloadCount;
		this.createdAt     = createdAt;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getSavedName() {
		return savedName;
	}

	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setgetDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "File [fileId=" + fileId + ", boardId=" + boardId + ", originalName=" + originalName + ", savedName="
				+ savedName + ", fileType=" + fileType + ", extension=" + extension + ", filePath=" + filePath
				+ ", size=" + size + ", downloadCount=" + downloadCount + ", createdAt=" + createdAt + "]";
	}

}