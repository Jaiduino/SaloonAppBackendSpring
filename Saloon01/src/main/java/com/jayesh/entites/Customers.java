package com.jayesh.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.TrueFalseType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="customer")
public class Customers{

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int customer_Id;
	private String fullName;
	//@Column(name="email_Id")
	private String email;
	
	private String mobileNo;
	private String gender;
	
	private String building_No;
	private String area_Name;
	private int pincode;
	private String password;
//	@Enumerated(EnumType.STRING)
//	private Role role;
	private String Role;
	private int enabled;
//	@JsonBackReference
	//@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "customers",cascade = CascadeType.ALL,orphanRemoval =true)
	@JsonIgnoreProperties("customers")
	private List<Orders> orderlist = new ArrayList<Orders>();
	//@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval =true)
	@JsonIgnoreProperties("customer")
	private List<Review> reviewlist = new ArrayList<Review>();
	public Customers() {
	}
	public Customers(int customer_Id, String fullName, String email, String mobileNo, String gender, String building_No,
			String area_Name, int pincode, String password, String role, int enabled ){
		this.customer_Id = customer_Id;
		this.fullName = fullName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.building_No = building_No;
		this.area_Name = area_Name;
		this.pincode = pincode;
		this.password = password;
		this.Role = role;
		this.enabled = enabled;
		//this.orderlist = orderlist;
	}
	
	
	public Customers(int customer_Id, String fullName, String email, String mobileNo, String gender, String building_No,
			String area_Name, int pincode, String password) {
		this.customer_Id = customer_Id;
		this.fullName = fullName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.building_No = building_No;
		this.area_Name = area_Name;
		this.pincode = pincode;
		this.password = password;
		
	}
	public Customers(int customer_Id2, String fullName2, String email2, String mobileNo2, String gender2,
			String building_No2, String area_Name2, int pincode2, String password2, String role2) {
		this.customer_Id = customer_Id2;
		this.fullName = fullName2;
		this.email = email2;
		this.mobileNo = mobileNo2;
		this.gender = gender2;
		this.building_No = building_No2;
		this.area_Name = area_Name2;
		this.pincode = pincode2;
		this.password = password2;
		this.Role = role2;
	}
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public List<Orders> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<Orders> orderlist) {
		this.orderlist = orderlist;
	}
	public List<Review> getReviewlist() {
		return reviewlist;
	}
	public void setReviewlist(List<Review> reviewlist) {
		this.reviewlist = reviewlist;
	}
	
//	@Override
//	public String toString() {
//		return "Customers [customer_Id=" + customer_Id + ", fullName=" + fullName + ", email=" + email + ", mobileNo="
//				+ mobileNo + ", gender=" + gender + ", building_No=" + building_No + ", area_Name=" + area_Name
//				+ ", pincode=" + pincode + ", password=" + password + ", Role=" + Role + ", enabled=" + enabled
//				+ ", orderlist=" + orderlist + "]";
//	}
	
	
	
	
	
}
