package com.jayesh.dtos;

public class paidDto {
private int paidstatus;

public paidDto(int paidstatus) {
	this.paidstatus = paidstatus;
}

public int getPaidstatus() {
	return paidstatus;
}

public void setPaidstatus(int paidstatus) {
	this.paidstatus = paidstatus;
}

@Override
public String toString() {
	return "paidDto [paidstatus=" + paidstatus + "]";
}

}
