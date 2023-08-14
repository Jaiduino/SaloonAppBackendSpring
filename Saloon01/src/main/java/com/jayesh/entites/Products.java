package com.jayesh.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Table(name="products")
@Entity
public class Products {

@Id
private String product_Id;
private String product_Name;
@Column(name="product_Price")
private Double price;
private String gender;
private String description;
@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
@JsonIgnoreProperties("product")
private List<Orders_Products> order_productList = new ArrayList<Orders_Products>();
//@ManyToMany(mappedBy = "plist",cascade = CascadeType.ALL)
//private List<Orders> ordList = new ArrayList<Orders>();
public String getProduct_Id() {
	return product_Id;
}

public Products() {
}


public Products(String product_Id, String product_Name, Double price, String gender,String description) {
	this.product_Id = product_Id;
	this.product_Name = product_Name;
	this.price = price;
	this.gender = gender;
	this.description = description;
}


public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public void setProduct_Id(String product_Id) {
	this.product_Id = product_Id;
}
public String getProduct_Name() {
	return product_Name;
}
public void setProduct_Name(String product_Name) {
	this.product_Name = product_Name;
}

public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

//@Override
//public String toString() {
//	return "Products [product_Id=" + product_Id + ", product_Name=" + product_Name + ", description=" + description
//			+ ", gender=" + gender + "]";
//}



}
