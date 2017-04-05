package com.lotte.project.model.dto;

import java.sql.Date;

public class PrjDetailDTO{
	private int pIndex; 				//프로젝트코드
	private int eIndex; 				//사원코드(책임자)
	private int pdIndex; 					// 업무코드
	private String pdName; 			// 업무이름
	private double pdProgress; 	// 진행률
	private Date pdStartDate; 		// 시작일
	private Date pdEndDate; 			// 종료일
	private Date pdWriteDate; 		// 작성일


	
	
	public PrjDetailDTO() { }
	public PrjDetailDTO(int pIndex, int eIndex, int pdIndex, String pdName, double pdProgress, Date pdStartDate,
			Date pdEndDate, Date pdWriteDate) {
		super();
		this.pIndex = pIndex;
		this.eIndex = eIndex;
		this.pdIndex = pdIndex;
		this.pdName = pdName;
		this.pdProgress = pdProgress;
		this.pdStartDate = pdStartDate;
		this.pdEndDate = pdEndDate;
		this.pdWriteDate = pdWriteDate;
	}

	public int getpIndex() {
		return pIndex;
	}

	public void setpIndex(int pIndex) {
		this.pIndex = pIndex;
	}

	public int geteIndex() {
		return eIndex;
	}

	public void seteIndex(int eIndex) {
		this.eIndex = eIndex;
	}

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
