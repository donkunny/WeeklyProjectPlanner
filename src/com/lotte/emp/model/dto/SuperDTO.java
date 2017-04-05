package com.lotte.emp.model.dto;

import java.sql.Date;

public class SuperDTO {
	//Dept
	private int dIndex; 			//담당코드
	private String dName; 		//부서이름
	private String dPart; 			//담당이름
	
	//Emp
	private int eIndex; 				//사원코드
	private int eNum; 				//사원번호(아이디)
	private String eName; 			//사원이름
	private String ePassword;		//비밀번호
	private Date eHiredate; 		//입사일
	private String ePosition; 		//직책
	private String eTel; 				//전화번호
	
	//Project
	private int pIndex; 				//프로젝트코드
	private String pName; 			//프로젝트이름
	private double pProgress; 	//진행률
	private Date pStartDate; 		//시작일
	private Date pEndDate; 		//종료일
	private Date pWriteDate; 		//작성일
	
	//PrjDetail
	private int pdIndex; 					// 업무코드
	private String pdName; 			// 업무이름
	private double pdProgress; 	// 진행률
	private Date pdStartDate; 		// 시작일
	private Date pdEndDate; 			// 종료일
	private Date pdWriteDate; 		// 작성일
	
	//PrjTeam
	private int ptIndex; 		// 팀인덱스
	
	public SuperDTO() {
	}

	public int getdIndex() {
		return dIndex;
	}

	public void setdIndex(int dIndex) {
		this.dIndex = dIndex;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdPart() {
		return dPart;
	}

	public void setdPart(String dPart) {
		this.dPart = dPart;
	}

	public int geteIndex() {
		return eIndex;
	}

	public void seteIndex(int eIndex) {
		this.eIndex = eIndex;
	}

	public int geteNum() {
		return eNum;
	}

	public void seteNum(int eNum) {
		this.eNum = eNum;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getePassword() {
		return ePassword;
	}

	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}

	public Date geteHiredate() {
		return eHiredate;
	}

	public void seteHiredate(Date eHiredate) {
		this.eHiredate = eHiredate;
	}

	public String getePosition() {
		return ePosition;
	}

	public void setePosition(String ePosition) {
		this.ePosition = ePosition;
	}

	public String geteTel() {
		return eTel;
	}

	public void seteTel(String eTel) {
		this.eTel = eTel;
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

	public int getPtIndex() {
		return ptIndex;
	}

	public void setPtIndex(int ptIndex) {
		this.ptIndex = ptIndex;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SuperDTO [dIndex=");
		builder.append(dIndex);
		builder.append(", dName=");
		builder.append(dName);
		builder.append(", dPart=");
		builder.append(dPart);
		builder.append(", eIndex=");
		builder.append(eIndex);
		builder.append(", eNum=");
		builder.append(eNum);
		builder.append(", eName=");
		builder.append(eName);
		builder.append(", ePassword=");
		builder.append(ePassword);
		builder.append(", eHiredate=");
		builder.append(eHiredate);
		builder.append(", ePosition=");
		builder.append(ePosition);
		builder.append(", eTel=");
		builder.append(eTel);
		builder.append(", pIndex=");
		builder.append(pIndex);
		builder.append(", pName=");
		builder.append(pName);
		builder.append(", pProgress=");
		builder.append(pProgress);
		builder.append(", pStartDate=");
		builder.append(pStartDate);
		builder.append(", pEndDate=");
		builder.append(pEndDate);
		builder.append(", pWriteDate=");
		builder.append(pWriteDate);
		builder.append(", pdIndex=");
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
		builder.append(", ptIndex=");
		builder.append(ptIndex);
		builder.append("]");
		return builder.toString();
	}

}
