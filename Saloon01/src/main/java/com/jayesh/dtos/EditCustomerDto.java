package com.jayesh.dtos;

public class EditCustomerDto {
	private int customer_Id;
	private String mobileNo;
	private String password;
	private String building_No;
	private String area_Name;
	private int pincode;
	public EditCustomerDto(int customer_Id, String mobileNo, String password, String building_No, String area_Name,
			int pincode) {
		
		this.customer_Id = customer_Id;
		this.mobileNo = mobileNo;
		this.password = password;
		this.building_No = building_No;
		this.area_Name = area_Name;
		this.pincode = pincode;
	}
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBuilding_No() {
		return building_No;
	}
	public void setBuilding_No(String building_No) {
		this.building_No = building_No;
	}
	public String getArea_Name() {
		return area_Name;
	}
	public void setArea_Name(String area_Name) {
		this.area_Name = area_Name;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "EditCustomerDto [customer_Id=" + customer_Id + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", building_No=" + building_No + ", area_Name=" + area_Name + ", pincode=" + pincode + "]";
	}
	
	
	
	
	
	
}
