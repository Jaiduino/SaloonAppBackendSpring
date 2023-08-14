package com.jayesh.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rId;
	private String review;
	@ManyToOne
	@JoinColumn(name="customer_Id")
	@JsonIgnoreProperties("orderlist")
	private Customers customer;
	
	@ManyToOne
	@JoinColumn(name = "branch_Id")
	@JsonIgnoreProperties({"orderList"})
	private Branch branch;
	
	
	public Review() {
	}
	public Review(int rId, String review) {
		this.rId = rId;
		this.review = review;
	}
	
	public Review(int rId, String review, Customers customer, Branch branch) {
		this.rId = rId;
		this.review = review;
		this.customer = customer;
		this.branch = branch;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
//	@Override
//	public String toString() {
//		return "Review [rId=" + rId + ", review=" + review + "]";
//	}
	
	

}
