package com.jayesh.dtos;

public class approvepaidDto {
	private int paid ;
	private int approve;
	public approvepaidDto(int paid, int approve) {
		this.paid = paid;
		this.approve = approve;
	}
	public approvepaidDto() {
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public int getApprove() {
		return approve;
	}
	public void setApprove(int approve) {
		this.approve = approve;
	}
	@Override
	public String toString() {
		return "approvepaidDto [paid=" + paid + ", approve=" + approve + "]";
	}
	

}
