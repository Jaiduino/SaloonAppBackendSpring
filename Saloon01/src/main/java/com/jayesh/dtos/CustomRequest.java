package com.jayesh.dtos;

import java.util.ArrayList;
import java.util.List;

import com.jayesh.entites.Date;
import com.jayesh.entites.Orders;
import com.jayesh.entites.Products;

public class CustomRequest {
	
	Orders orders;
	
	List<Products> products=new ArrayList<>();
	
	private Date date;

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
