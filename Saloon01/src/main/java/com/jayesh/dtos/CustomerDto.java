package com.jayesh.dtos;
//
public class CustomerDto {
	private int cusid;
	private String cname;
	private String email;
	private String mobile;
	private String gender;
	private String building_no;
	private String street_name;
	private int pincode;
	private String password;
	private int enabled;
	public CustomerDto() {
	}
	public CustomerDto(int cusid, String cname, String email, String mobile, String gender, String building_no,
			String street_name, int pincode) {
		this.cusid = cusid;
		this.cname = cname;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.building_no = building_no;
		this.street_name = street_name;
		this.pincode = pincode;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBuilding_no() {
		return building_no;
	}
	public void setBuilding_no(String building_no) {
		this.building_no = building_no;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "CustomerDto [cusid=" + cusid + ", cname=" + cname + ", email=" + email + ", mobile=" + mobile
				+ ", gender=" + gender + ", building_no=" + building_no + ", street_name=" + street_name + ", pincode="
				+ pincode + ", password=" + password + ", enabled=" + enabled + "]";
	}
	

}
