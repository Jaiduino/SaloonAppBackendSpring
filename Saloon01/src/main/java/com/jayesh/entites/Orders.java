package com.jayesh.entites;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.aspectj.weaver.tools.Trace;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_Id;
	//@JsonIgnoreProperties("customers")
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_Id")
	@JsonIgnoreProperties({"orderlist","reviewlist"})
	private Customers customers;
	//private String  product_Id;
	//private Products product;
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"order"})
	//@JsonIgnore
	private List<Orders_Products> order_productList = new ArrayList<Orders_Products>();
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name="Orders_Products",joinColumns = {@JoinColumn(name="order_Id")},inverseJoinColumns = {@JoinColumn(name="product_Id")})
//	private List <Products>plist = new ArrayList<Products>();
	@ManyToOne
	@JoinColumn(name="DId")
	@JsonIgnoreProperties("orderlist")
	private com.jayesh.entites.Date date;
	private String slot_Time;
	private double amount;
	@ManyToOne
	@JoinColumn(name="branch_Id")
	@JsonIgnoreProperties({"reviewlist"})
	private Branch branch;
	private int approved;
	private int paid;
	public Orders() {
	}
//	public Orders(int order_Id, Customers customers, String slot_Time, double amount,
//			Branch branch) {
//		this.order_Id = order_Id;
//		this.customers = customers;
//		
//		this.slot_Time = slot_Time;
//		this.amount = amount;
//		this.branch = branch;
//	}
//	
	public Orders(int order_Id, Customers customers, com.jayesh.entites.Date date, String slot_Time, double amount,
			Branch branch) {
		this.order_Id = order_Id;
		this.customers = customers;
		this.date = date;
		this.slot_Time = slot_Time;
		this.amount = amount;
		this.branch = branch;
	}
	
	public int getOrder_Id() {
		return order_Id;
	}
	public Orders(int order_Id, int approved, int paid) {
	this.order_Id = order_Id;
	this.approved = approved;
	this.paid = paid;
}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	
	public String getSlot_Time() {
		return slot_Time;
	}
	public void setSlot_Time(String slot_Time) {
		this.slot_Time = slot_Time;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public List<Orders_Products> getOrder_productList() {
		return order_productList;
	}
	public void setOrder_productList(List<Orders_Products> order_productList) {
		this.order_productList = order_productList;
	}
	public com.jayesh.entites.Date getDate() {
		return date;
	}
	public void setDate(com.jayesh.entites.Date date) {
		this.date = date;
	}
	public int getApproved() {
		return approved;
	}
	public void setApproved(int approved) {
		this.approved = approved;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	
	
//	@Override
//	public String toString() {
//		return "Orders [order_Id=" + order_Id + ", customers=" + customers + ", order_productList=" + order_productList
//				+ ", slot_Date=" + slot_Date + ", slot_Time=" + slot_Time + ", amount=" + amount + ", branch=" + branch
//				+ "]";
//	}
	
	
}
