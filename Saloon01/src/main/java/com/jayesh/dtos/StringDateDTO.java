package com.jayesh.dtos;

public class StringDateDTO {
private int id;
private String sdate;
public StringDateDTO() {
}
public StringDateDTO(int id, String sdate) {
	this.id = id;
	this.sdate = sdate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSdate() {
	return sdate;
}
public void setSdate(String sdate) {
	this.sdate = sdate;
}
@Override
public String toString() {
	return "StringDateDTO [id=" + id + ", sdate=" + sdate + "]";
}

}
