package com.jayesh.dtos;

public class ProductDto {
	private String product_Id;
	private String product_Name;
	private String description;
	private String gender;
	public ProductDto(String product_Id, String product_Name, String description, String gender) {
		this.product_Id = product_Id;
		this.product_Name = product_Name;
		this.description = description;
		this.gender = gender;
	}
	public String getProduct_Id() {
		return product_Id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "ProductDto [product_Id=" + product_Id + ", product_Name=" + product_Name + ", description="
				+ description + ", gender=" + gender + "]";
	}
	
	 

}
