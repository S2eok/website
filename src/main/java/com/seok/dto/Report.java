package com.seok.dto;

import java.time.LocalDateTime;

public class Report {
	private int reportId; //PK
	private String targetType;
	private int targetId;
	private int reporterNum; //FK → users.user_num
	private String reason;
	private LocalDateTime createdAt;

	public Report() {
	}

	public Report(int reportId, String targetType, int targetId, int reporterNum, String reason, LocalDateTime createdAt) {
		this.reportId = reportId;
		this.targetType = targetType;
		this.targetId = targetId;
		this.reporterNum = reporterNum;
		this.reason = reason;
		this.createdAt = createdAt;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
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

	public int getReporterNum() {
		return reporterNum;
	}

	public void setReporterNum(int reporterNum) {
		this.reporterNum = reporterNum;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", targetType=" + targetType + ", targetId=" + targetId
				+ ", reporterNum=" + reporterNum + ", reason=" + reason + ", createdAt=" + createdAt + "]";
	}
}
