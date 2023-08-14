package com.jayesh.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Orders_Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kid;
	
	@ManyToOne
	@JoinColumn(name = "order_Id")
	private Orders order;
    @ManyToOne
    @JoinColumn(name="product_Id")
    @JsonIgnoreProperties("order_productList")
 	private Products product;
	
	
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	
    
	

}
