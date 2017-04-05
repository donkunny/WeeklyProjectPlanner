package com.lotte.emp.model.dto;

public class DeptDTO {
	private int dIndex; 			//담당코드
	private String dName; 		//부서이름
	private String dPart; 			//담당이름

	public DeptDTO() {}
	public DeptDTO(int dIndex, String dName, String dPart) {
		super();
		this.dIndex = dIndex;
		this.dName = dName;
		this.dPart = dPart;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartmentDTO [dIndex=");
		builder.append(dIndex);
		builder.append(", dName=");
		builder.append(dName);
		builder.append(", dPart=");
		builder.append(dPart);
		builder.append("]");
		return builder.toString();
	}
}
