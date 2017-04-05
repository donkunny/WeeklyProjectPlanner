package com.lotte.project.model.dto;

import java.sql.Date;

public class PrjDetailDTO extends ProjectDTO{
	private int pdIndex; 					// 업무코드
	private String pdName; 			// 업무이름
	private double pdProgress; 	// 진행률
	private Date pdStartDate; 		// 시작일
	private Date pdEndDate; 			// 종료일
	private Date pdWriteDate; 		// 작성일

	public int getPdIndex() {
		return pdIndex;
	}

	public void setPdIndex(int pdIndex) {
		this.pdIndex = pdIndex;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public double getPdProgress() {
		return pdProgress;
	}

	public void setPdProgress(double pdProgress) {
		this.pdProgress = pdProgress;
	}

	public Date getPdStartDate() {
		return pdStartDate;
	}

	public void setPdStartDate(Date pdStartDate) {
		this.pdStartDate = pdStartDate;
	}

	public Date getPdEndDate() {
		return pdEndDate;
	}

	public void setPdEndDate(Date pdEndDate) {
		this.pdEndDate = pdEndDate;
	}

	public Date getPdWriteDate() {
		return pdWriteDate;
	}

	public void setPdWriteDate(Date pdWriteDate) {
		this.pdWriteDate = pdWriteDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProjectDetail [pdIndex=");
		builder.append(pdIndex);
		builder.append(", pdName=");
		builder.append(pdName);
		builder.append(", pdProgress=");
		builder.append(pdProgress);
		builder.append(", pdStartDate=");
		builder.append(pdStartDate);
		builder.append(", pdEndDate=");
		builder.append(pdEndDate);
		builder.append(", pdWriteDate=");
		builder.append(pdWriteDate);
		builder.append("]");
		return builder.toString();
	}
}
