package com.jayesh.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="branch")
public class Branch {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int branch_Id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_Id")
	private Manager manager;
	
	private String branch_Contact_No;
	
	private String shop_Address;

	private String area_Name;
	
	private int branch_PinCode;
	
	private String landmark;
	
	private int enabled;
	@JsonIgnoreProperties({"branch","date"})
	@OneToMany(mappedBy = "branch",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	//@JsonIgnore
	private List<Orders> orderList = new ArrayList<Orders>();
	@OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"branch","customer"})
	private List<Review> reviewlist = new ArrayList<Review>(); 
	public Branch() {
	}
	public Branch(int branch_Id, Manager manager, String branch_Contact_No, String shop_Address, String area_Name,
			int branch_PinCode, String landmark, int enabled) {
		this.branch_Id = branch_Id;
		this.manager = manager;
		this.branch_Contact_No = branch_Contact_No;
		this.shop_Address = shop_Address;
		this.area_Name = area_Name;
		this.branch_PinCode = branch_PinCode;
		this.landmark = landmark;
		this.enabled = enabled;
	}
	public int getBranch_Id() {
		return branch_Id;
	}
	public void setBranch_Id(int branch_Id) {
		this.branch_Id = branch_Id;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getBranch_Contact_No() {
		return branch_Contact_No;
	}
	public void setBranch_Contact_No(String branch_Contact_No) {
		this.branch_Contact_No = branch_Contact_No;
	}
	public String getShop_Address() {
		return shop_Address;
	}
	public void setShop_Address(String shop_Address) {
		this.shop_Address = shop_Address;
	}
	public String getArea_Name() {
		return area_Name;
	}
	public void setArea_Name(String area_Name) {
		this.area_Name = area_Name;
	}
	public int getBranch_PinCode() {
		return branch_PinCode;
	}
	public void setBranch_PinCode(int branch_PinCode) {
		this.branch_PinCode = branch_PinCode;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public List<Orders> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	public List<Review> getReviewlist() {
		return reviewlist;
	}
	public void setReviewlist(List<Review> reviewlist) {
		this.reviewlist = reviewlist;
	}
	
//	@Override
//	public String toString() {
//		return "Branch [branch_Id=" + branch_Id + ", manager=" + manager + ", branch_Contact_No=" + branch_Contact_No
//				+ ", shop_Address=" + shop_Address + ", area_Name=" + area_Name + ", branch_PinCode=" + branch_PinCode
//				+ ", landmark=" + landmark + ", enabled=" + enabled + ", orderList=" + orderList + "]";
//	}
	
}
