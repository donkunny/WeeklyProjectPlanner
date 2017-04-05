package com.lotte.emp.model.dto;

import java.sql.Date;

public class EmpDTO {
	private int eIndex; 				//사원코드
	private int eNum; 				//사원번호(아이디)
	private String eName; 			//사원이름
	private String ePassword;		//비밀번호
	private Date eHiredate; 		//입사일
	private String ePosition; 		//직책
	private String eTel; 				//전화번호
	private int dIndex; 				//담당코드
	
	public EmpDTO() {}
	
	public EmpDTO(int eIndex, int eNum, String eName, String ePassword, Date eHiredate, String ePosition, String eTel, int dIndex) {
		this.eIndex = eIndex;
		this.eNum = eNum;
		this.eName = eName;
		this.ePassword = ePassword;
		this.eHiredate = eHiredate;
		this.ePosition = ePosition;
		this.eTel = eTel;
		this.dIndex = dIndex;
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
	public int getdIndex() {
		return dIndex;
	}
	public void setdIndex(int dIndex) {
		this.dIndex = dIndex;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpDTO [eIndex=");
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
		builder.append(", dIndex=");
		builder.append(dIndex);
		builder.append("]");
		return builder.toString();
	}
}
