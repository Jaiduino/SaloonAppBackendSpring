package com.jayesh.dtos;

import java.util.ArrayList;
import java.util.List;

import com.jayesh.entites.Date;
import com.jayesh.entites.Orders;
import com.jayesh.entites.Products;

public class CustomreqSdate {

	Orders orders;
	
	List<Products> products=new ArrayList<>();
	
	private StringDateDTO sdate;

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

	public StringDateDTO getSdate() {
		return sdate;
	}

	public void setSdate(StringDateDTO sdate) {
		this.sdate = sdate;
	}

	
	
}
