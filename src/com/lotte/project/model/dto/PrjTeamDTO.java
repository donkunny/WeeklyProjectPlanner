package com.lotte.project.model.dto;

public class PrjTeamDTO {
	private int ptIndex; 		// 팀인덱스
	private int pIndex; 		// 프로젝트코드
	private int eIndex; 		// 사원코드

	public PrjTeamDTO() {}
	public PrjTeamDTO(int ptIndex, int pIndex, int eIndex) {
		super();
		this.ptIndex = ptIndex;
		this.pIndex = pIndex;
		this.eIndex = eIndex;
	}

	public int getPtIndex() {
		return ptIndex;
	}

	public void setPtIndex(int ptIndex) {
		this.ptIndex = ptIndex;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProjectTeam [ptIndex=");
		builder.append(ptIndex);
		builder.append(", pIndex=");
		builder.append(pIndex);
		builder.append(", eIndex=");
		builder.append(eIndex);
		builder.append("]");
		return builder.toString();
	}
}
