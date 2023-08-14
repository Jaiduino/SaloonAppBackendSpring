package com.jayesh.dtos;

public class approvestatus {
private int approvestatus;

public approvestatus(int approvestatus) {
	this.approvestatus = approvestatus;
}

public int getApprovestatus() {
	return approvestatus;
}

public void setApprovestatus(int approvestatus) {
	this.approvestatus = approvestatus;
}

@Override
public String toString() {
	return "approvestatus [approvestatus=" + approvestatus + "]";
}

}
