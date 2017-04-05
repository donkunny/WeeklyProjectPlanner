package com.lotte.project.model.dto;

import java.sql.Date;

public class ProjectDTO {
	private int pIndex; 				//프로젝트코드
	private String pName; 			//프로젝트이름
	private int eIndex; 				//사원코드(책임자)
	private double pProgress; 	//진행률
	private Date pStartDate; 		//시작일
	private Date pEndDate; 		//종료일
	private Date pWriteDate; 		//작성일
	
	public ProjectDTO() {}
	public ProjectDTO(int pIndex, String pName, int eIndex, double pProgress, Date pStartDate, Date pEndDate,
			Date pWriteDate) {
		super();
		this.pIndex = pIndex;
		this.pName = pName;
		this.eIndex = eIndex;
		this.pProgress = pProgress;
		this.pStartDate = pStartDate;
		this.pEndDate = pEndDate;
		this.pWriteDate = pWriteDate;
	}

	public int getpIndex() {
		return pIndex;
	}
	public void setpIndex(int pIndex) {
		this.pIndex = pIndex;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int geteIndex() {
		return eIndex;
	}
	public void seteIndex(int eIndex) {
		this.eIndex = eIndex;
	}
	public double getpProgress() {
		return pProgress;
	}
	public void setpProgress(double pProgress) {
		this.pProgress = pProgress;
	}
	public Date getpStartDate() {
		return pStartDate;
	}
	public void setpStartDate(Date pStartDate) {
		this.pStartDate = pStartDate;
	}
	public Date getpEndDate() {
		return pEndDate;
	}
	public void setpEndDate(Date pEndDate) {
		this.pEndDate = pEndDate;
	}
	public Date getpWriteDate() {
		return pWriteDate;
	}
	public void setpWriteDate(Date pWriteDate) {
		this.pWriteDate = pWriteDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProjectDTO [pIndex=");
		builder.append(pIndex);
		builder.append(", pName=");
		builder.append(pName);
		builder.append(", eIndex=");
		builder.append(eIndex);
		builder.append(", pProgress=");
		builder.append(pProgress);
		builder.append(", pStartDate=");
		builder.append(pStartDate);
		builder.append(", pEndDate=");
		builder.append(pEndDate);
		builder.append(", pWriteDate=");
		builder.append(pWriteDate);
		builder.append("]");
		return builder.toString();
	}
}
